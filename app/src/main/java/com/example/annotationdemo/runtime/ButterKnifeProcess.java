package com.example.annotationdemo.runtime;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ButterKnifeProcess {
    
    public static void bind(final Activity target){
        bindView(target);
        bindClick(target);
    }

    private static void bindView(Activity target) {
        Class<? extends Activity> clazz = target.getClass();
        Field[] declaredFields = clazz.getDeclaredFields(); // 获取Activity所有字段
        for (Field field: declaredFields) {
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation != null && annotation.value() != 0) {
                int id = annotation.value();
                View view = target.findViewById(id);
                try {
                    field.setAccessible(true);
                    field.set(target, view); // 设置字段field在target中的值为view。
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void bindClick(final Activity target) {
        final Class<? extends Activity> clazz = target.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (final Method method: declaredMethods) {
            // 如果有这个注解就获取一下
            OnClick annotation = method.getAnnotation(OnClick.class);
            if (annotation != null && annotation.value()[0] != 0) {
                for (int id: annotation.value()) {
                    View view = target.findViewById(id);
                    // view触发点击事件就调用函数
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.setAccessible(true);
                                // 调用target中的method方法。
                                method.invoke(target);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

}