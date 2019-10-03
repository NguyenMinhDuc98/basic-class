/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Micropost {

    private int id;
    private int user_id;
    private String content;

    public Micropost() {
    }

    public Micropost(int id, int user_id, String content) {
        this.id = id;
        this.user_id = user_id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Micropost: " + id + "------user id: " + user_id + "-----content: " + content;
    }
}
