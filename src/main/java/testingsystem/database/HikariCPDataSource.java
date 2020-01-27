package testingsystem.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class HikariCPDataSource implements ConnectionPool {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    private static ResourceBundle resource = PropertyResourceBundle.getBundle("properties");

    static {
        config.setJdbcUrl(resource.getString("link"));
        config.setUsername(resource.getString("user"));
        config.setPassword(resource.getString("password"));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
