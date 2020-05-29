package com.ac.designpatterns.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anchao
 * @date 2020/5/29 11:13
 **/
public class EmployeeFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP = new ConcurrentHashMap<>();


    public static Employee getManager(String department){
        Manager manager = (Manager)EMPLOYEE_MAP.get(department);
        if(manager == null){
            manager = new Manager(department);
            System.out.println("创建部门经理："+department);
            String reportContent = department+"部门汇报：此次汇报内容.......";
            manager.setReportContent(reportContent);
            EMPLOYEE_MAP.put(department, manager);
            System.out.println("创建报告:"+reportContent);
        }
        return manager;
    }
}
