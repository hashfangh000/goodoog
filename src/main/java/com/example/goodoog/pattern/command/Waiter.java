package com.example.goodoog.pattern.command;


import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command cmd) {
        commands.add(cmd);
    }

    // 发起命令的功能
    public void orderUp() {
        System.out.println("新订单来了～");
        // 遍历list集合
        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }
        }
    }
}
