package edu.school21.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Message {
    private int id;
    private int author;
    private int room;
    private String text_msg;
    private LocalDateTime date;

    public Message(int id, int author, int room, String text_msg, LocalDateTime date) {
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
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", text_msg='" + text_msg + '\'' +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
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
