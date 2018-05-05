package com.lvjianet.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String sex;
    private String age;
    private String salary;

    @Generated(hash = 750802071)
    public User(Long id, String name, String sex, String age, String salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
