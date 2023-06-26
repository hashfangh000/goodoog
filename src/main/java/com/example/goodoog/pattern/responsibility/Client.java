package com.example.goodoog.pattern.responsibility;

public class Client {
    public static void main(String[] args) {
        // 创建一个请假条对象
        LeaveRequest leave = new LeaveRequest("张三", 2, "回家～");

        // 创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manger manger = new Manger();
        GeneralManger generalManger = new GeneralManger();

        groupLeader.setNextHandler(manger);
        manger.setNextHandler(generalManger);

        // 提交请假
        groupLeader.submit(leave);
    }
}
