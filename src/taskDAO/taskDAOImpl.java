package taskDAO;

import VO.taskVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class taskDAOImpl implements taskDAO {
    private Connection conn;
    private PreparedStatement sqlStatement;

    public taskDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public List<taskVO> findAll() throws Exception {
        List<taskVO> taskVOList = new ArrayList<>();
        String sql = "SELECT taskNo, isFinished, taskInfo FROM taskList";
        try {
            this.sqlStatement = this.conn.prepareStatement(sql);
            ResultSet rs = this.sqlStatement.executeQuery();
            while (rs.next()) {
                taskVO task = new taskVO();
                task.setTaskNo(rs.getInt("taskNo"));
                task.setTaskInfo(rs.getString("taskInfo"));
                task.setIsFinished(rs.getBoolean("isFinished"));
                taskVOList.add(task);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.sqlStatement.close();
        return taskVOList;
    }

    @Override
    public taskVO findByID(int id) throws Exception {
        taskVO task = new taskVO();
        String sql = "SELECT taskNo, isFinished, taskInfo FROM taskList WHERE taskNo = ?";
        try {
            this.sqlStatement = this.conn.prepareStatement(sql);
            this.sqlStatement.setInt(1, id);
            ResultSet rs = this.sqlStatement.executeQuery();
            if (rs.next()) {
                task.setTaskNo(rs.getInt("taskNo"));
                task.setTaskInfo(rs.getString("taskInfo"));
                task.setIsFinished(rs.getBoolean("isFinished"));
            }
        } catch (
                SQLException e) {
            throw e;
        }
        return task;
    }

    @Override
    public int doCreate(taskVO task) throws Exception {
        boolean ok = false;
        int id=-1;
        String sql = "INSERT INTO taskList (isFinished, taskInfo) VALUES (?,?)";
        try {
            this.sqlStatement = this.conn.prepareStatement(sql);
            this.sqlStatement.setBoolean(1, task.getIsFinished());
            this.sqlStatement.setString(2, task.getTaskInfo());
            if (this.sqlStatement.executeUpdate() > 0) {
                ok = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        if(ok)
        {
            sql = "SELECT last_insert_rowid() FROM taskList";
            try {
                this.sqlStatement = this.conn.prepareStatement(sql);
                ResultSet rs = this.sqlStatement.executeQuery();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (
                    SQLException e) {
                throw e;
            }
        }
        return id;
    }

    @Override
    public boolean doDelete(taskVO task) throws Exception {
        boolean ok = false;
        String sql = "DELETE FROM taskList WHERE taskNo = ?";
        try {
            this.sqlStatement = this.conn.prepareStatement(sql);
            this.sqlStatement.setInt(1, task.getTaskNo());
            if (this.sqlStatement.execute()) {
                ok = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return ok;
    }

    @Override
    public boolean doUpdate(taskVO task) throws Exception {
        boolean ok = false;
        String sql = "UPDATE taskList SET isFinished= ? , taskInfo= ? WHERE taskNo= ?";
        try {
            this.sqlStatement = this.conn.prepareStatement(sql);
            this.sqlStatement.setBoolean(1, task.getIsFinished());
            this.sqlStatement.setString(2, task.getTaskInfo());
            this.sqlStatement.setInt(3, task.getTaskNo());
            if (this.sqlStatement.execute()) {
                ok = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return ok;
    }

    @Override
    public boolean doUpdateFinishState(boolean isFinished, int taskNo) throws Exception {
        boolean ok = false;
        String sql = "UPDATE taskList SET isFinished= ? WHERE taskNo= ?";
        try {
            this.sqlStatement = this.conn.prepareStatement(sql);
            this.sqlStatement.setBoolean(1, isFinished);
            this.sqlStatement.setInt(2, taskNo);
            if (this.sqlStatement.execute()) {
                ok = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return ok;
    }
}
