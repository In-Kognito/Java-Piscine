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
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String... param) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/javachat");
        hikariDataSource.setUsername("jinigo");
        hikariDataSource.setPassword("");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(hikariDataSource);
        Optional<Message> messageOptional = repository.findById(4L);

        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText_msg("Bye");
            message.setDate(null);
            repository.update(message);
        }
    }
}