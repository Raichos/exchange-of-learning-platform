package com.ckkj.exchangeoflearningplatform.model;

/**
 * @author lzh
 * create 2019-04-30-17:50
 */
public class Tests {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Tests{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
