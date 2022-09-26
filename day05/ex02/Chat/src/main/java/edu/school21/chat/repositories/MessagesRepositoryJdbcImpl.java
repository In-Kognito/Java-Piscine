package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.exception.NotSavedSubEntityException;

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

        User user = new User(1L, "jinigo", "123", null, null);
        Chatroom chatroom = new Chatroom(1L, "classroom", null, null);
        optionalMessage = Optional.of(new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("msg_text"), LocalDateTime.of(2020, 10, 28, 00, 00)));

        resultSet.close();
        statement.close();
        connection.close();

        return optionalMessage;
    }

    @Override
    public boolean save(Message message) throws NotSavedSubEntityException {

        String request = "INSERT INTO chat.message(msg_author, msg_room, msg_text, msg_date) values (" + message.getAuthor().getId() + ", " + message.getRoom().getId() + ", '" + message.getText_msg() + "', '" + message.getDate() + "');";
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            User user = new User(1L, "jinigo", "123", null, null);
            Chatroom chatroom = new Chatroom(1L, "classroom", null, null);

            boolean result = statement.execute(request);

            String answer_id = "select msg_id from chat.message order by msg_id desc limit 1";

            ResultSet resultSet = statement.executeQuery(answer_id);
            resultSet.next();
            message.setId(resultSet.getLong(1));

            resultSet.close();
            statement.close();
            connection.close();

            return result;
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Error");
        }
    }
}
