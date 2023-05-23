package com.example.goodoog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *  过程 ：
 *      1、主要通过 @EnableAutoConfiguration ---> @Import  ----> 将{AutoConfigurationImportSelector.class}引入当前类
 *      2、调用 AutoConfigurationImportSelector 的 selectImport方法 选择加载内容
 *      3、selectImport方法中 使用 this.getAutoConfigurationEntry(annotationMetadata) 获取加载配置的内容 (内容是List<String>)
 *      4、getAutoConfigurationEntry方法 使用 this.getCandidateConfigurations(annotationMetadata, attributes); 获取加载候选人的配置信息
 *      5、getCandidateConfigurations方法 使用 loadFactoryNames ---> loadSpringFactories 获取具体的加载配置内容
 *      6、loadSpringFactories方法 Map<String, List<String>> result = (Map)cache.get(classLoader); result获为空，则进行下一步，反之直接返回；
 *      7、获取 META-INF/spring.factories中的urls(urls里面的每一个url是配置文件的jar的绝对路径)
 *      8、url封装成UrlResource，然后再调用 loadProperties方法 加载UrlResource的配置和方法 这时候与6获取的不为空的result是一样的，然后将其放入到缓存中 方便读取
 *      9、将result转换为list，回到3，至此自动加载配置的流程结束
 */

/**
 *  springboot 启动流程：
 *      1、new 一个SpringApplication对象 (new SpringApplication(primarySources)).run(args); 通过SpringApplication.run方法运行
 *      2、在new SpringApplication构造方法中：做了两个初始化操作：setInitializers(配置应用启动前的初始化对象) 和 setListeners(配置应用启动前的监听器)
 *      3、执行run方法 开始启动
 *      4、通知2设置的监听器，我要启动了哦
 *      5、创建应用环境，这一步读取配置文件(application.properties、application.yml)
 *      6、创建应用程序上下文，这一步创建beanFactory
 *      7、刷新上下文(spring启动核心)
 *          7.1、配置工厂对象
 *          7.2、注册并实例化bean工厂处理器，并调用
 *          7.3、注册并实例化bean处理器
 *          7.4、初始化一些与上下文特别有关系的对象，创建tomcat
 *          7.5、实例化所有bean工厂缓存的bean对象(剩下的)
 *          7.6、发布通知，通知上下文刷新完成
 *      8、启动完成 通知监听器，我的环境准备好啦
 */
@MapperScan("com.example.goodoog.mapper")
@SpringBootApplication
public class GoodoogApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodoogApplication.class, args);
    }

}
