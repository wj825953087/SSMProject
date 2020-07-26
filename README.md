# SSM框架整合测试项目
## SSM项目配置过程
##### 第一步 ： 配置Spring配置文件 applicationContext.xml
```html
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
     http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
     http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!--激活那些已经在spring容器里注册过的bean上面的注解 -->
    <context:annotation-config />
    <context:component-scan base-package="com.mytext.Service" />
    <!-- 加载配数据源配置文件 db.properties -->
    <!-- 配置数据源 -->
   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">  
	     <property name="driverClassName" value="${db.driver_class}"/>  
	     <property name="url" value="${db.url}"/>   
	     <property name="username" value="${db.username}"/>   
	     <property name="password" value="${db.password}"/>   
  	</bean>
  <!-- 配置MyBatis的SqlSessionFactoryBean -->
  <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		    <property name="typeAliasesPackage" value="com.mytext.entity" />
		    <property name="dataSource" ref="dataSource"/>
	    	<property name="mapperLocations" value="classpath:com/mytext/dao/*.xml"/>
	</bean>
 <!-- 配置扫描 dao 包，动态实现 dao 接口，注入到 spring 容器中 -->
	 <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		    <property name="basePackage" value="com.mytext.dao"/>
	 </bean>
</beans>
```
##### 第二步 ： 配置SpringMVC配置文件 springMVC.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd 
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd">
    <context:annotation-config/>
    <context:component-scan base-package="com.mytext.controller">
          <context:include-filter type="annotation" 
          expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
	<!-- 启动 mvc 注解驱动 -->
    <mvc:annotation-driven />
    <!-- 静态资源处理 -->
    <mvc:default-servlet-handler />
	<!-- 配置视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>
</beans>
```
##### 第三步 ： 配置Tomcat容器web.xml
```xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>SSM_project_setting</display-name>
	<!-- spring的配置文件-->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:applicationContext.xml</param-value>
	</context-param>
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	<!-- spring mvc核心：分发servlet -->
	<servlet>
		<servlet-name>mvc-dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<!-- spring mvc的配置文件 -->
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:springMVC.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>mvc-dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
	
<welcome-file-list>
	    <welcome-file>index.jsp</welcome-file>
</welcome-file-list>	
</web-app>
```
## SSM知识学习
[SSM学习](https://how2j.cn/k/ssm/ssm-tutorial/1137.html)
### java 面试题
1. HashMap和HashTable区别
2. String、StringBuffer、StringBuilder区别
3.  String类能被继承吗？

### Spring 面试题
### SpringMVC 面试题
### MyBatis 面试题
