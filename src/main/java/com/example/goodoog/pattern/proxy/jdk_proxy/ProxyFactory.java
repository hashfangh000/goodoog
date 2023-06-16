package com.example.goodoog.pattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 声明目标对象
    private TrainStation station = new TrainStation();
    public SellTickets getProxyObject() {
        // 返回代理对象
        /**
         * ClassLoader loader,  类加载器
         * Class<?>[] interfaces, 代理类实现的接口字节码对象
         * InvocationHandler h)  代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                /**
                 * Object proxy : 代理对象 和 proxyObject对象是同一对象，在invoke方法基本不用
                 * Method metohd : 对接口中的方法进行封装method对象
                 * Object[] args ： 调用方法的实际参数
                 * 返回值 ： 方法的返回值。
                 */
                (proxy, method, args) -> {
//                        System.out.println("invoke 方法执行了～");
                    System.out.println("代售点收取费用～");
                    // 执行目标对象的方法
                    Object obj = method.invoke(station, args);
                    return obj;
                }
        );
        return proxyObject;
    }
}
