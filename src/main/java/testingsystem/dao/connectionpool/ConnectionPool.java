package testingsystem.dao.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    public Connection getConnection() throws SQLException;
}
