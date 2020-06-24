package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqLiteConnection implements dbConnection {

    //todo：实现数据库连接

    //数据库连接驱动
    private static final String DBDRIVER = "";
    //数据库地址
    private static final String DBURL = "";

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void close() {

    }
}
