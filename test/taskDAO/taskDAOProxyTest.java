package taskDAO;

import DB.sqLiteConnection;
import VO.taskVO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * taskDAOProxy Tester.
 *
 * @author <cloudicen>
 * @version 1.0
 * @since <pre>6ÔÂ 28, 2020</pre>
 */
public class taskDAOProxyTest {

    @org.junit.jupiter.api.Test
    void findAll() {
        System.out.println("test method findAll");
        List<taskVO> taskVOList = new ArrayList<>();
        try {
            taskVOList = new taskDAOProxy().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("total records: "+taskVOList.size());
        for (taskVO i : taskVOList) {
            System.out.printf("taskNo: %d;taskInfo: %s;isFinished %s.\n",i.getTaskNo(),i.getTaskInfo(),i.getIsFinished() ? "true" : "false");
        }
    }

    @org.junit.jupiter.api.Test
    void findByID() {
        System.out.println("test method findByID");
        taskVO task = new taskVO();
        try {
            task = new taskDAOProxy().findByID(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("id=2,record:");
        System.out.printf("taskNo: %d;taskInfo: %s;isFinished %s.\n",task.getTaskNo(),task.getTaskInfo(),task.getIsFinished() ? "true" : "false");
    }

    @org.junit.jupiter.api.Test
    void doUpdate() {
        taskVO task = new taskVO();
        task.setIsFinished(true);
        task.setTaskInfo("task test");
        try {
            System.out.println("create new task");
            task.setTaskNo(new taskDAOProxy().doCreate(task));
            System.out.printf("taskNo: %d;taskInfo: %s;isFinished %s.\n",task.getTaskNo(),task.getTaskInfo(),task.getIsFinished() ? "true" : "false");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("update task info to 'task info -changed',new record:");
            task.setTaskInfo("task info -changed");
            new taskDAOProxy().doUpdate(task);
            task = new taskDAOProxy().findByID(task.getTaskNo());
            System.out.printf("taskNo: %d;taskInfo: %s;isFinished %s.\n",task.getTaskNo(),task.getTaskInfo(),task.getIsFinished() ? "true" : "false");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("test over,remove record.");
            new taskDAOProxy().doDelete(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void doUpdateFinishState() {
        taskVO task = new taskVO();
        task.setIsFinished(false);
        task.setTaskInfo("task test");
        try {
            System.out.println("create test task");
            task.setTaskNo(new taskDAOProxy().doCreate(task));
            System.out.printf("taskNo: %d;taskInfo: %s;isFinished %s.\n",task.getTaskNo(),task.getTaskInfo(),task.getIsFinished() ? "true" : "false");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("set task state to 'is Finished',new record:");
            new taskDAOProxy().doUpdateFinishState(true,task.getTaskNo());
            task = new taskDAOProxy().findByID(task.getTaskNo());
            System.out.printf("taskNo: %d;taskInfo: %s;isFinished %s.\n",task.getTaskNo(),task.getTaskInfo(),task.getIsFinished() ? "true" : "false");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("test over,remove record.");
            new taskDAOProxy().doDelete(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
