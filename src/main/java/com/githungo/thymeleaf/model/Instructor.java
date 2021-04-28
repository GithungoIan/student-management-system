package com.githungo.thymeleaf.model;
import javax.persistence.*;

@Entity
@Table
public class Instructor {
    @Id
    @SequenceGenerator(
            name = "instructor_sequence",
            sequenceName = "instructor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructor_sequence"
    )
    private long id;
    private String name;
    private String email;
    private String phoneNo;
    private String Course;

    public Instructor() {}

    public Instructor(String name, String email, String phoneNo, String course) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        Course = course;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", Course='" + Course + '\'' +
                '}';
    }
}
