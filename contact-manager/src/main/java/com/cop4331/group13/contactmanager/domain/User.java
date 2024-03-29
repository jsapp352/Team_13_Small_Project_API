package com.cop4331.group13.contactmanager.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String securityQuestion;
    private String securityAnswer;

    @CreatedDate
    private Date createDate;

    public User(long userId, String username, String password, String firstName, String lastName, String securityQuestion, String securityAnswer, Date createDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.createDate = createDate;
    }

    public User(String username, String password, String firstName, String lastName, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.createDate = new Date();
    }

    public User() {
        this.createDate = new Date();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
