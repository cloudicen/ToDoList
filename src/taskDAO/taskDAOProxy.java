package taskDAO;

import VO.taskVO;
import DB.sqLiteConnection;

import java.util.List;

public class taskDAOProxy implements taskDAO{
    //todo：实现代理实现方法

    @Override
    public taskVO findAll() throws Exception {
        return null;
    }

    @Override
    public List<taskVO> findByID() throws Exception {
        return null;
    }

    @Override
    public boolean doCreate(taskVO task) throws Exception {
        return false;
    }

    @Override
    public boolean doDelete(taskVO task) throws Exception {
        return false;
    }

    @Override
    public boolean doUpdate(taskVO task) throws Exception {
        return false;
    }
}
