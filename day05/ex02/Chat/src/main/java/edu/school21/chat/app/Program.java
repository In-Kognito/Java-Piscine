package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String... param) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/javachat");
        hikariDataSource.setUsername("jinigo");
        hikariDataSource.setPassword("");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        User user = new User(1L, "jinigo", "123", null, null);
        Chatroom chatroom = new Chatroom(1L, "classroom", null, null);
        Message message = new Message(null, user, chatroom, "Help me, PLEASE!", LocalDateTime.of(2020, 10, 28, 00, 00));

        repository.save(message);

        System.out.println(message.getId());
    }
}