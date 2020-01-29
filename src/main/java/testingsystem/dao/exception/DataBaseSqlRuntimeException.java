package testingsystem.dao.exception;

import java.sql.SQLException;

public class DataBaseSqlRuntimeException extends RuntimeException {
    public DataBaseSqlRuntimeException(String s, SQLException e) {
    }
}
