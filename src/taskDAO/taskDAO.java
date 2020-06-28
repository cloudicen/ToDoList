package taskDAO;

import java.util.List;

import VO.taskVO;

public interface taskDAO {
    public List<taskVO> findAll() throws Exception;

    public taskVO findByID(int id) throws Exception;

    public int doCreate(taskVO task) throws Exception;

    public boolean doDelete(taskVO task) throws Exception;

    public boolean doUpdate(taskVO task) throws Exception;

    public boolean doUpdateFinishState(boolean isFinished,int taskNo) throws Exception;

}
