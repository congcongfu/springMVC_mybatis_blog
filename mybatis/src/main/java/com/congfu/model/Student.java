package com.congfu.model;


public class Student {
    /**
     *  主键id
     */
    private int id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生年龄
     */
    private int age;
    /**
     * 学生性别
     */
    private String sex;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("id=").append(id);
        builder.append(" ,name=").append(name);
        builder.append(" ,age=").append(age);
        builder.append(" ,sex=").append(sex);
        builder.append("}");
        return builder.toString();
    }
    
}
