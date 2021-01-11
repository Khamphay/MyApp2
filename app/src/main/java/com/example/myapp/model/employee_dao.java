package com.example.myapp.model;

public class employee_dao {
    private  String id;
    private  String name;
    private  String surname;
    private  String age;
    private  String tel;

    public employee_dao(String id, String name, String surname, String age, String tel) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.tel = tel;
    }

    public employee_dao(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
