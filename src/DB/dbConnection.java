package DB;

import java.sql.Connection;

public interface dbConnection {

    public Connection getConnection() throws Exception;

    public void close() throws Exception;

}
