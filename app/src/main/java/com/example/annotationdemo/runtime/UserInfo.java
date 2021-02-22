package com.example.annotationdemo.runtime;

public class UserInfo {
    
    String name;
    int age;

    public UserInfo() {
        this.name = "default";
        this.age = 10;
    }
    
    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
