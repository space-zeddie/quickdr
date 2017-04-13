package com.zakharuk.quickdr.dao.impl.jdbc;

import com.zakharuk.quickdr.dao.UserDao;
import com.zakharuk.quickdr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by matvii on 13.04.17.
 */
@Repository
public class UserDaoImplJDBC implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET =
            "SELECT username, password, role, enabled FROM users WHERE username=?";
    private static final String INSERT_USER =
            "INSERT INTO users (username, password, role, enabled) SELECT ?,md5(?),?,? WHERE NOT exists(SELECT username FROM users WHERE username = ?)";
    private static final String UPDATE = "UPDATE users SET password=md5(?), role=?, enabled=? WHERE username=?";
    private static final String DELETE = "DELETE FROM user WHERE username=?";

    private static final String EXISTS = "SELECT exists (SELECT username FROM users WHERE username = ?)";

    public User get(String login) {
        return jdbcTemplate.queryForObject(GET, mapper, login);
    }

    public int add(User user) {
        if (exists(user))
            return -1;
        return jdbcTemplate.update(INSERT_USER, user.getName(), user.getPassword(), user.getRole(),
                user.isEnabled(), user.getName());
    }

    public void update(User user) {
        jdbcTemplate.update(UPDATE, user.getPassword(), user.getRole(), user.isEnabled(), user.getName());
    }

    public void remove(User user) {
        jdbcTemplate.update(DELETE, user.getName());
    }

    public boolean exists(User user){
        return jdbcTemplate.queryForObject(EXISTS, Boolean.class, user.getName());
    }

    private RowMapper<User> mapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setEnabled(rs.getBoolean("enabled"));
            return user;
        }
    };
}
