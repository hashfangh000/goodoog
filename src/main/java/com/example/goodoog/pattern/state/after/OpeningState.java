package com.example.goodoog.pattern.state.after;


/**
 * 电梯开启状态类
 */
public class OpeningState extends LiftState{


    // 当前状态要执行的

    @Override
    public void open() {
        System.out.println("电梯开启了～");
    }

    @Override
    public void close() {
        //
        super.context.setLiftState(Context.CLOSING_STATE);
        super.context.close();
    }

    @Override
    public void run() {
        // do nothing
    }

    @Override
    public void stop() {
        // do nothing
    }
}
