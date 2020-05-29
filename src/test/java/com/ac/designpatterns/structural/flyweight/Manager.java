package com.ac.designpatterns.structural.flyweight;

/**
 * 经理
 * @author anchao
 * @date 2020/5/29 11:09
 **/
public class Manager implements Employee {
    @Override
    public void report() {
        System.out.println(reportContent);
    }
    private String title="部门经理";
    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
