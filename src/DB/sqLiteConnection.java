package DB;

import java.sql.*;

public class sqLiteConnection implements dbConnection {

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

            //初始化表
            PreparedStatement sql = conn.prepareStatement(
                    "create table if not exists taskList\n" +
                    "(\n" +
                    "    taskNo INTEGER not null\n" +
                    "        constraint taskList_pk\n" +
                    "            primary key autoincrement,\n" +
                    "    isFinished INTEGER default 0 not null,\n" +
                    "    taskInfo TEXT\n" +
                    ");\n" +
                    "\n" +
                    "create unique index if not exists taskList_taskID_uindex\n" +
                    "    on taskList (taskNo);");
            sql.execute();

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
