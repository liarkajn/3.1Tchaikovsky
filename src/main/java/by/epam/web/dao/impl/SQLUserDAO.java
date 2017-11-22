package main.java.by.epam.web.dao.impl;

import main.java.by.epam.web.dao.UserDAO;
import main.java.by.epam.web.dao.exception.DAOException;
import main.java.by.epam.web.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;// не импортирует через *
import java.util.Properties;

public class SQLUserDAO implements UserDAO {

    private static final String MYSQL_CONFIG = "mysql.properties";
    private static final String URL_PROPERTY = "url";
    private static final String USERNAME_PROPERTY = "username";
    private static final String PASSWORD_PROPERTY = "password";
    private static final String DRIVER_PROPERTY = "driver";
    private final static String queryByNameAndSurname = "SELECT * FROM user WHERE name=? AND surname=?";// как объявляются final-поля?
    // если начал писать static final - так и продолжай
    private String DB_URL;
    private String USERNAME;
    private String PASSWORD;
    private String JDBC_DRIVER;

    public SQLUserDAO() { }

    @Override
    public User findUser(String name, String surname) throws DAOException {
        User user = new User();
        prepareDatabase();// зачем этот метод каждый раз читает из файла одни и теже данные?
        // еу больше заняться нечем?
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(queryByNameAndSurname)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setName(resultSet.getString(2));
                    user.setSurname(resultSet.getString(3));
                    user.setPhoneNumber(resultSet.getString(4));
                    user.setEmail(resultSet.getString(5));
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Problems with database operations", e);
        }

        return user;
    }

    private void prepareDatabase() throws DAOException {
        Properties properties = getMySQLProperties();
        DB_URL = properties.getProperty(URL_PROPERTY);
        USERNAME = properties.getProperty(USERNAME_PROPERTY);
        PASSWORD = properties.getProperty(PASSWORD_PROPERTY);
        JDBC_DRIVER = properties.getProperty(DRIVER_PROPERTY);
        loadDriver();// и каждый раз грузит класс в память?
    }

    private Properties getMySQLProperties() throws DAOException {// private методу излишне выбрасывать DAOException
        Properties properties = new Properties();
        URL url = getClass().getClassLoader().getResource(MYSQL_CONFIG);
        if (url == null) {
            throw new DAOException("Properties file not found");
        }
        try {
            InputStream inputStream = url.openStream();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new DAOException("Unable open properties file", e);
        }
        return properties;
    }

    private void loadDriver() throws DAOException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Can't find JDBC driver", e);
        }
    }

}
