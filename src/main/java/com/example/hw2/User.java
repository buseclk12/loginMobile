package com.example.hw2;

public class User {
    private String username;
    private String email;
    private String password;

    public User(int anInt, String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // opsiyonel olarak diğer bilgileri de ekleyebilirsiniz
}

