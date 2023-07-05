package com.example.goodoog.pattern.state.before;

public class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();

        lift.setStatus(ILeft.RUNNING_STATUS);

        // 开门
        lift.open();

        lift.close();

        lift.run();

        lift.stop();
    }
}
