package testingsystem.dao;

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
        config.addDataSourceProperty("cachePrepStmts", resource.getString("cachePrepStmts"));
        config.addDataSourceProperty("prepStmtCacheSize", resource.getString("prepStmtCacheSize"));
        config.addDataSourceProperty("prepStmtCacheSqlLimit", resource.getString("prepStmtCacheSqlLimit"));
        ds = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
