package com.example.goodoog.pattern.combination;

public class Client {
    public static void main(String[] args) {
        // 创建菜单数
        MenuComponent menu1 = new Menu("菜单管理", 2);
        menu1.add(new MenuItem("页面访问", 3));
        menu1.add(new MenuItem("展开菜单", 3));
        menu1.add(new MenuItem("编辑菜单", 3));
        menu1.add(new MenuItem("页面访问", 3));
        MenuComponent menu2 = new Menu("权限管理", 2);
        MenuComponent menu3 = new Menu("角色管理", 2);
    }
}
