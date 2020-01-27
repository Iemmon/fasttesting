package testingsystem.database.exception;

import java.sql.SQLException;

public class DataBaseSqlRuntimeException extends RuntimeException {
    public DataBaseSqlRuntimeException(String s, SQLException e) {
    }
}
