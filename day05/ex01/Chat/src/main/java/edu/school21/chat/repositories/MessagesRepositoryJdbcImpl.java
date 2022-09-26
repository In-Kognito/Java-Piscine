package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String request = "SELECT * FROM chat.message WHERE msg_id = " + id;
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.next();

        User user = new User(1, "jinigo", "123", null, null);
        Chatroom chatroom = new Chatroom(1, "classroom", null, null);
        optionalMessage = Optional.of(new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("msg_text"), LocalDateTime.of(2020, 10, 28, 00, 00)));

        resultSet.close();
        statement.close();
        connection.close();

        return optionalMessage;
    }
}
