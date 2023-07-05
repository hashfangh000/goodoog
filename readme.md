## springboot项目
>>主要针对设计模式进行开发，并熟练运，涉及常用的中间件、常用的开发功能。

- 登陆模块
    考虑登陆方式的多样性，采用策略模式进行设计，登陆方式有：手机号(手机号和验证码)、账号密码、邮箱密码
  ~~~java
  public interface LoginStrategyService {
    R login(LoginDTO loginDTO, HttpSession session);
  }
  ~~~
  ![img.png](img.png)
- 添加自定义IOC容器，管理对象
  - Bean工厂: BeanFactory
  - 封装Bean数据：BeanDefinition
  - 封装Bean标签属性：PropertyValue，简单定义name, ref, value三个属性即可；
    - Bean标签：
    ~~~java
    <bean id="userService" class="com.example.dubbo.service.impl.UserServiceImpl">
        <property name="userDao" ref="userDao"></property>
    </bean>
  - MutablePropertyValues: 存储和管理多个PropertyValue对象；
  - **BeanDefinitionReader, XmlBeanDefinitionReader**两个接口定义解析xml配置文件、注册表对象的规范；
  - **XmlBeanDefinitionReader**中添加dom4j依赖，解析xml配置文件。
  ~~~java
  <dependency>
    <groupId>dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>1.6.1</version>
  </dependency>
  ~~~
  - 下面设计ApplicationContext延时加载，交给子类实现，
  ~~~java
  public interface ApplicationContext extends BeanFactory {

    void refresh() throws Exception;
  }
  ~~~
  - AbstractApplicationContext实现ApplicationContext
  ~~~java
  public abstract class AbstractApplicationContext implements ApplicationContext {
    ...
  }
  ~~~
  - ClassPathXmlApplicationContext继承抽象类AbstractApplicationContext
  ~~~java
  public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    ...
  }
  ~~~
  
  
    