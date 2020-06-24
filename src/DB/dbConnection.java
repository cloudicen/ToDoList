package DB;

import java.sql.Connection;

public interface dbConnection {

    public Connection getConnection();

    public void close();

}
