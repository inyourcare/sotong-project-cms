package com.sotong.projectcms.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DbRepository {
    private final JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    public DbRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(String tableName, String databaseName, String columns) throws Exception {
        try (Connection conn = DriverManager.getConnection(url + "/" + databaseName, username, password);
             Statement stmt = conn.createStatement();
        ) {
            String sql = """
                    CREATE TABLE\040
                    """
                    + tableName +
                    """
                    (
                    """
                    + columns +
                    """
                    )
                    """;
            System.out.println("sql::" + sql);
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

//    public void testSelectQuery() throws Exception {
//        String sql = """
//                SELECT * from SOTONG_USER
//                """;
//        jdbcTemplate.query(sql, new RowCallbackHandler() {
//            public void processRow(ResultSet rs) throws SQLException {
//                System.out.println(rs.getString("user_id"));
//            }
//        });
//    }

//    public void testCreateDatabaseQuery() throws Exception {
//        String sql = "CREATE DATABASE TEST_DATABASE";
////        System.out.println(driverClassName + url + username + password);
////        try(Connection conn = DriverManager.getConnection(url, username, password);
////            Statement stmt = conn.createStatement();
////        ) {
////            stmt.executeUpdate(sql);
////            System.out.println("Database created successfully...");
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
//        jdbcTemplate.query(sql, new RowCallbackHandler() {
//            public void processRow(ResultSet rs) throws SQLException {
//                System.out.println(rs);
//            }
//        });
//    }
}
