package com.migu.schedule.info;

/**
 * Created by ZC on 2018/6/20.
 */
public class TaskInfo_zc {
    private int taskId;
    private int consumption;
    public TaskInfo_zc (){}
    public TaskInfo_zc (int taskId, int consumption)
    {
        this.consumption = consumption;
        this.taskId = taskId;
    }
    public int getConsumption()
    {
        return consumption;
    }
    public int getTaskId(){  return taskId; }
    public void setConsumption(int consumption)
    {
        this.consumption = consumption;
    }
    public void setTaskId(int taskId)
    {
        this.taskId = taskId;
    }
}
