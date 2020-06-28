package taskDAO;

import VO.taskVO;
import DB.sqLiteConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class taskDAOProxy implements taskDAO{
    private sqLiteConnection conn = null;
    private taskDAO dao;

    public taskDAOProxy() throws Exception {
        this.conn = new sqLiteConnection();
        this.dao = new taskDAOImpl(this.conn.getConnection());
    }

    @Override
    public List<taskVO> findAll() throws Exception {
        List<taskVO> taskVOList = new ArrayList<>();
        try {
            taskVOList = this.dao.findAll();
        }catch(SQLException e) {
            throw e;
        }finally {
            // 关闭数据库
            this.conn.close();
        }
        return taskVOList;
    }

    @Override
    public taskVO findByID(int id) throws Exception {
        taskVO task = null;
        try {
            task = this.dao.findByID(id);
        }catch(SQLException e) {
            throw e;
        }finally {
            // 关闭数据库
            this.conn.close();
        }
        return task;
    }

    @Override
    public int doCreate(taskVO task) throws Exception {
        int id = -1;
        try {
            id = this.dao.doCreate(task);
        }catch(SQLException e) {
            throw e;
        }finally {
            // 关闭数据库
            this.conn.close();
        }
        return id;
    }

    @Override
    public boolean doDelete(taskVO task) throws Exception {
        boolean ok;
        try {
            ok = this.dao.doDelete(task);
        }catch(SQLException e) {
            throw e;
        }finally {
            // 关闭数据库
            this.conn.close();
        }
        return ok;
    }

    @Override
    public boolean doUpdate(taskVO task) throws Exception {
        boolean ok;
        try {
            ok = this.dao.doUpdate(task);
        }catch(SQLException e) {
            throw e;
        }finally {
            // 关闭数据库
            this.conn.close();
        }
        return ok;
    }

    @Override
    public boolean doUpdateFinishState(boolean isFinished, int taskNo) throws Exception {
        boolean ok;
        try {
            ok = this.dao.doUpdateFinishState(isFinished,taskNo);
        }catch(SQLException e) {
            throw e;
        }finally {
            // 关闭数据库
            this.conn.close();
        }
        return ok;
    }
}
