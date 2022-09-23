package com.sotong.projectcms.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DbRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DbRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testQuery() {
        String sql = """
                SELECT * from SOTONG_USER
                """;
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("user_id"));
            }
        });
    }
}
