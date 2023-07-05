package com.example.goodoog.pattern.state.before;

/**
 * 电梯接口
 */
public interface ILeft {
    // 定义4个电梯状态的常量
    int OPENING_STATUS = 1;
    int CLOSING_STATUS = 2;
    int RUNNING_STATUS = 3;
    int STOPING_STATUS = 4;

    void setStatus(int state);

    // 电梯操作功能
    void open();

    void close();

    void run();

    void stop();
}
