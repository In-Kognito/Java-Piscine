package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> usersList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users;");

        while (resultSet.next()) {
            usersList.add(new User( resultSet.getLong("id"), resultSet.getString("email") ));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return usersList;
    }

    @Override
    public User findById(Long id) throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String request = "SELECT * FROM users WHERE id = " + id + ";";
        ResultSet resultSet = statement.executeQuery(request);

        User user = new User(resultSet.getLong("id"), resultSet.getString("email"));

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }

    @Override
    public void update(User user) throws SQLException {

        String request = "UPDATE users SET email = " + "'" + user.getEmail() + "'" +
                "WHERE id = " + user.getId() + ";";

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(request);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();

    }

    @Override
    public void save(User user) throws SQLException {
        String request = "INSERT INTO users(id, email) values ("
                + user.getId() + ", '"
                + user.getEmail() + "');";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(request);

        statement.close();
        connection.close();

    }

    @Override
    public void delete(Long id) throws SQLException {
        String request = "DELETE FROM users WHERE id = " + id + ";";

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(request);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String request = "SELECT * FROM users WHERE email = '" + email + "';";
        ResultSet resultSet = statement.executeQuery(request);

        User user = new User(resultSet.getLong("id"), resultSet.getString("email"));

        resultSet.close();
        statement.close();
        connection.close();

        return Optional.of(user);
    }
}
