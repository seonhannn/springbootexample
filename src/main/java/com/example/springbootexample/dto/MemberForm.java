package com.example.springbootexample.dto;

import com.example.springbootexample.entity.Article;
import com.example.springbootexample.entity.Member;

public class MemberForm {
    private String email;
    private String password;

    public MemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Member toEntity() { return new Member(null, email, password); }
}
