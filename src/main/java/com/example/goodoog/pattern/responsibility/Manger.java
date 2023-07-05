package com.example.goodoog.pattern.responsibility;

/**
 * 部门经理
 */
public class Manger extends Handler{

    public Manger() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天" + leave.getContent() + "。");
        System.out.println("部门经理同意～");
    }
}
