package edu.school21.chat.models;

import edu.school21.chat.models.User;
import edu.school21.chat.models.Message;
import java.util.List;
import java.util.Objects;

public class Chatroom {
    private int id;
    private String Chat_name;
    private User Owner;
    private List<Message> message;

    public Chatroom(int id, String chat_name, User owner, List<Message> message) {
        this.id = id;
        Chat_name = chat_name;
        Owner = owner;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return id == chatroom.id && Objects.equals(Chat_name, chatroom.Chat_name) && Objects.equals(Owner, chatroom.Owner) && Objects.equals(message, chatroom.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Chat_name, Owner, message);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", Chat_name='" + Chat_name + '\'' +
                ", Owner=" + Owner +
                ", message=" + message +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChat_name() {
        return Chat_name;
    }

    public void setChat_name(String chat_name) {
        Chat_name = chat_name;
    }

    public User getOwner() {
        return Owner;
    }

    public void setOwner(User owner) {
        Owner = owner;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
