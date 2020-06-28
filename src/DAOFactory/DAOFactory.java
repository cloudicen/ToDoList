package DAOFactory;

import taskDAO.taskDAO;
import taskDAO.taskDAOProxy;

public class DAOFactory {

    //todo：编写获取taskDAO实例的工厂方法
    public static taskDAO getTaskDAOInstance() throws Exception {
        return new taskDAOProxy();
    }
}
