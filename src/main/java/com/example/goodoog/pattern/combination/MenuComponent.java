package com.example.goodoog.pattern.combination;

/**
 * 菜单组件，属于抽象根节点
 * 不管是菜单还是菜单项，都应该继承该类
 */
public abstract class MenuComponent {
    // 菜单组件的名称
    protected String name;
    // 菜单组件的层级
    protected int level;

    // 添加子菜单
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // 移除子菜单
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    // 获取指定的子菜单
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    // 获取菜单或者菜单项的名称
    public String getName() {
        return name;
    }

    // 打印菜单名称的方法
    public abstract void print();
}
