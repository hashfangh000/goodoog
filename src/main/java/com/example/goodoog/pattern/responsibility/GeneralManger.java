package com.example.goodoog.pattern.responsibility;

/**
 * 总经理
 */
public class GeneralManger extends Handler{

    public GeneralManger() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天" + leave.getContent() + "。");
        System.out.println("总经理同意～");
    }
}
