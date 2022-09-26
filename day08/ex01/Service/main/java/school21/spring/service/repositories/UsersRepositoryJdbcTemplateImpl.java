package school21.spring.service.repositories;

import com.sun.istack.internal.NotNull;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource driverManagerDataSource) {
        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }


    private RowMapper<User> rowMapper = (user, rowMapper) ->
    new User
    (
        user.getLong(1),
        user.getString(2)
    );

    @Override
    public User findById(Long id) throws SQLException {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", rowMapper, id)
                .stream().findAny().orElse(null);
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users VALUES (?, ?)", entity.getId(), entity.getEmail());
    }

    public void update(User entity) {
        jdbcTemplate.update("UPDATE users Set email = ? WHERE id = ?", entity.getEmail(), entity.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id =?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM users WHERE email=?;", rowMapper, email).stream().findAny();
    }
}
