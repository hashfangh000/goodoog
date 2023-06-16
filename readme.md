## 本项目作为springboot项目
>>主要针对设计模式进行开发，并熟练运，涉及常用的中间件、常用的开发功能。

- 登陆模块
    考虑登陆方式的多样性，采用策略模式进行设计，登陆方式有：手机号(手机号和验证码)、账号密码、邮箱密码
  ~~~java
  public interface LoginStrategyService {
    R login(LoginDTO loginDTO, HttpSession session);
  }
  ~~~
  ![img.png](img.png)
- 自定义IOC容器，管理对象
    