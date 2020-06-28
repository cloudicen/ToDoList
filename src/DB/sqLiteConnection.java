package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqLiteConnection implements dbConnection {

    //todo：实现数据库连接

    //数据库连接驱动
    private static final String dbDRIVER = "org.sqlite.JDBC";
    //数据库文件名
    private static final String DBNAME = "/task.db";
    //数据库连接
    private Connection conn;

    @Override
    public Connection getConnection() throws Exception{
        String dbURL = "jdbc:sqlite:" + this.getClass().getResource(DBNAME).getPath();
        try {
            Class.forName(dbDRIVER);
            this.conn = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            throw e;
        }
        return this.conn;
    }

    @Override
    public void close() throws Exception{
        if(this.conn != null) {
            try{
                this.conn.close();
            }catch(Exception e) {
                throw e;
            }
        }
    }
}
