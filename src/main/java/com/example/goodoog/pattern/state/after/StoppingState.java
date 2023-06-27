package com.example.goodoog.pattern.state.after;


/**
 * 电梯停止状态类
 */
public class StoppingState extends LiftState{




    @Override
    public void open() {
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        //
        super.context.setLiftState(Context.CLOSING_STATE);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        // do nothing
        super.context.setLiftState(Context.RUNNING_STATE);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        // do nothing
        System.out.println("电梯停止了～");
    }
}
