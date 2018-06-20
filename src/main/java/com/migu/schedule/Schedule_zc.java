package com.migu.schedule;

import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;
import com.migu.schedule.info.TaskInfo_zc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZC on 2018/6/20.
 */
public class Schedule_zc {


    Map<Integer,TaskInfo_zc> tasks = new ConcurrentHashMap<Integer,TaskInfo_zc>();

//    private HashSet<Integer> nodeSet = new HashSet<Integer>();
    //当前结点的
    Map<Integer,Map<Integer,TaskInfo_zc>> nodeTaskMap = new ConcurrentHashMap<Integer,Map<Integer,TaskInfo_zc>>();

    public int init() {
        //重置结点
//        nodeSet.clear();
        nodeTaskMap.clear();
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        //结点非法
        if(nodeId < 1)
        {
            return ReturnCodeKeys.E004;
        }
        //结点存在
        if(nodeTaskMap.keySet().contains(nodeId))
        {
            return ReturnCodeKeys.E003;
        }
//        nodeSet.add(nodeId);
        nodeTaskMap.put(nodeId,new HashMap<Integer, TaskInfo_zc>());

        return ReturnCodeKeys.E000;
    }

    public int unregisterNode(int nodeId) {
//        nodeSet.remove(nodeId);

        Map<Integer,TaskInfo_zc> task = nodeTaskMap.get(nodeId);
        //将
        if(null != task)
        {
            tasks.putAll(task);
        }
        nodeTaskMap.remove(nodeId);
        return ReturnCodeKeys.E006;
    }


    public int addTask(int taskId, int consumption) {
        if(taskId < 1)
        {
            return ReturnCodeKeys.E009;
        }
        if(tasks.containsKey(taskId))
        {
            return ReturnCodeKeys.E010;
        }
        for(Integer nodeid : nodeTaskMap.keySet())
        {
            if (nodeTaskMap.get(nodeid).containsKey(taskId))
            {
                return ReturnCodeKeys.E010;
            }

        }
        //添加到任务队列
        tasks.put(taskId,new TaskInfo_zc(taskId,consumption));

        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        boolean flag = false;
        // TODO 方法未实现
        if(tasks.containsKey(taskId))
        {
            flag = true;
            tasks.remove(taskId);
        }
        for(Integer nodeid : nodeTaskMap.keySet())
        {
            if (nodeTaskMap.get(nodeid).containsKey(taskId))
            {
                flag = true;
                nodeTaskMap.get(nodeid).remove(taskId);
            }
        }

        if(!flag)
        {
            return ReturnCodeKeys.E012;
        }

        return ReturnCodeKeys.E011;
    }


    public int scheduleTask(int threshold) {

        //挂起中任务
        if(tasks.size() > 0)
        {

        }
        else
        {
            
        }
        return 0;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        return 0;
    }
}
