package com.example.goodoog.pattern.combination;

/**
 * 菜单项类 属于叶子节点
 */
public class MenuItem extends MenuComponent{

    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }
    @Override
    public void print() {
        System.out.println(name);
    }
}
