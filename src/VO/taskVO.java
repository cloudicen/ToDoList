package VO;

public class taskVO {
    private int taskNo;
    private String taskInfo;
    private boolean isFinished;

    //Todo ：实现 getters & setters

    public void setTaskNo(int taskNo) {
        this.taskNo = taskNo;
    }

    public int getTaskNo() {
        return taskNo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean getIsFinished() {
        return isFinished;
    }
}
