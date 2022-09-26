package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text_msg;
    private LocalDateTime date;

    public Message(Long id, User author, Chatroom room, String text_msg, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text_msg = text_msg;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && author == message.author && room == message.room && Objects.equals(text_msg, message.text_msg) && Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text_msg, date);
    }

    @Override
    public String toString() {
        return "Message : {\n" +
                "id=" + id + ",\n" +
                "author=" + author.toString() + ",\n" +
                "room=" + room.toString() + ",\n" +
                "text=\"" + text_msg + '\"' + ",\n" +
                "dateTime=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                "\n}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText_msg() {
        return text_msg;
    }

    public void setText_msg(String text_msg) {
        this.text_msg = text_msg;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
