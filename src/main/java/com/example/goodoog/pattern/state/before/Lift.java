package com.example.goodoog.pattern.state.before;

/**
 * 电梯类
 */
public class Lift implements ILeft{
    // 声明一个记录当前电梯状态的变量
    private int state;
    @Override
    public void setStatus(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state) {
            case OPENING_STATUS:
            case RUNNING_STATUS:
                // 不做
                break;
            case CLOSING_STATUS:
            case STOPING_STATUS:
                System.out.println("电梯打开了....");
                setStatus(OPENING_STATUS);
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {
            case OPENING_STATUS:
                System.out.println("电梯关闭了....");
                setStatus(CLOSING_STATUS);
                break;
            case CLOSING_STATUS:
            case STOPING_STATUS:
            case RUNNING_STATUS:
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {
            case STOPING_STATUS:
            case CLOSING_STATUS:
                System.out.println("电梯开始运行了....");
                setStatus(RUNNING_STATUS);
                break;
            case OPENING_STATUS:
            case RUNNING_STATUS:
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {
            case CLOSING_STATUS:
            case RUNNING_STATUS:
                System.out.println("电梯停止了....");
                this.setStatus(STOPING_STATUS);
                break;
            case STOPING_STATUS:
            case OPENING_STATUS:
                break;
        }
    }
}
