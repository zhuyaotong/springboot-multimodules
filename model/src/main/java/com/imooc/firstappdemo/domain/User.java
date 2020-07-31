package com.imooc.firstappdemo.domain;

/**
 * 用户模型
 * @author Yaotong Zhu
 * @date 2020/07/04
 */
public class User {
    private int id;

    /**
     * 用户名称
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
