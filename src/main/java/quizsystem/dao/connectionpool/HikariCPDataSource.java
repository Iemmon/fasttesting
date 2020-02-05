package quizsystem.dao.connectionpool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import quizsystem.injector.ApplicationInjector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HikariCPDataSource implements ConnectionPool {

    private HikariConfig config = new HikariConfig();
    private HikariDataSource ds;
    private ResourceBundle resource = ApplicationInjector.getInstance().getResourceBundle();

    public HikariCPDataSource() {
        config.setJdbcUrl(resource.getString("link"));
        config.setUsername(resource.getString("user"));
        config.setPassword(resource.getString("password"));
        config.setDriverClassName(resource.getString("driver"));
        config.addDataSourceProperty("cachePrepStmts", resource.getString("cachePrepStmts"));
        config.addDataSourceProperty("prepStmtCacheSize", resource.getString("prepStmtCacheSize"));
        config.addDataSourceProperty("prepStmtCacheSqlLimit", resource.getString("prepStmtCacheSqlLimit"));
        config.setMinimumIdle(Integer.parseInt(resource.getString("minimumIdle")));
        config.setMaximumPoolSize(Integer.parseInt(resource.getString("maximumPoolSize")));
        ds = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
