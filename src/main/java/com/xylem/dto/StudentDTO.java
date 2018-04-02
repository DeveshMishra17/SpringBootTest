package com.xylem.dto;

public class StudentDTO {

    private String name;

    private String age;
    private String rollNo;

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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "StudentDTO [name=" + name + ", age=" + age + ", rollNo=" + rollNo + "]";
    }

}
