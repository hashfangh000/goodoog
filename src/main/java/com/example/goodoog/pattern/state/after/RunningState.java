package com.example.goodoog.pattern.state.after;


/**
 * 电梯运行状态类
 */
public class RunningState extends LiftState{




    @Override
    public void open() {
    }

    @Override
    public void close() {
        //

    }

    @Override
    public void run() {
        // do nothing
        System.out.println("电梯正在运行～");
    }

    @Override
    public void stop() {
        // do nothing
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.stop();
    }
}
