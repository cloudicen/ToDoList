package taskDAO;

import java.util.List;

import VO.taskVO;

public interface taskDAO {
    public taskVO findAll() throws Exception;

    public List<taskVO> findByID() throws Exception;

    public boolean doCreate(taskVO task) throws Exception;

    public boolean doDelete(taskVO task) throws Exception;

    public boolean doUpdate(taskVO task) throws Exception;

}
