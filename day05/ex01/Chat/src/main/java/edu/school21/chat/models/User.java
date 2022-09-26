package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String pass;
    private List<Chatroom> created_rooms;
    private List<Chatroom> rooms_where_socializes;

    public User(int id, String login, String pass, List<Chatroom> created_rooms, List<Chatroom> rooms_where_socializes) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.created_rooms = created_rooms;
        this.rooms_where_socializes = rooms_where_socializes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(pass, user.pass) && Objects.equals(created_rooms, user.created_rooms) && Objects.equals(rooms_where_socializes, user.rooms_where_socializes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, pass, created_rooms, rooms_where_socializes);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", created_rooms=" + created_rooms +
                ", rooms_where_socializes=" + rooms_where_socializes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Chatroom> getCreated_rooms() {
        return created_rooms;
    }

    public void setCreated_rooms(List<Chatroom> created_rooms) {
        this.created_rooms = created_rooms;
    }

    public List<Chatroom> getRooms_where_socializes() {
        return rooms_where_socializes;
    }

    public void setRooms_where_socializes(List<Chatroom> rooms_where_socializes) {
        this.rooms_where_socializes = rooms_where_socializes;
    }
}
