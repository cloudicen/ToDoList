package DAOFactory;

import taskDAO.taskDAO;
import taskDAO.taskDAOProxy;

public class DAOFactory {

    public static taskDAO getTaskDAOInstance() throws Exception {
        return new taskDAOProxy();
    }
}
