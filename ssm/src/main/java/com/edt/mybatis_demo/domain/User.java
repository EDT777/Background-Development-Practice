package com.edt.mybatis_demo.domain;

public class User {
    private Long id;
    private String username;
    private String password;
    private String headImg;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headImg='" + headImg + '\'' +
                '}';
    }

    public User() {
    }

    public User(Long id, String username, String password, String headImg) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headImg = headImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
