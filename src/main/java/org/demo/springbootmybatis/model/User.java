package org.demo.springbootmybatis.model;

import java.util.Date;

/**
 * Created by zhaol on 2018/7/17.
 */
public class User {
    private String name;
    private String age;
    private String sex;
    private Date date;

    public User() {
    }

    public User(String name, String age, String sex, Date date) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", sex='" + sex + '\'' + '}';
    }
}
