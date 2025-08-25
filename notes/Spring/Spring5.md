# Spring

Spring 有两个核心部分：IOC 和 AOP

- IOC：控制反转，把创建对象过程交给 Spring 进行管理

- AOP：面向切面，不修改源代码进行功能增强



## IOC

### IOC 概念和原理

1. 概念：
   - 控制反转，把对象创建和对象之间的调用过程，交给 Spring 进行管理
   - 使用 IOC 目的：为了耦合度降低
2. 底层原理：
   - xml 解析
   - 工厂模式
   - 反射



### Spring 提供 IOC 容器的实现两种方式

1. `BeanFactory`：是 Spring 内部的使用接口，不提供开发人员进行使用
   - 加载配置文件时，不会创建对象，在获取对象（使用）采取创建对象
2. `ApplicationContext`：BeanFactory 接口的子接口，提供更多更强大的功能，一般由开发人员进行使用
   - 加载配置文件时就会把在配置文件中所定义的对象进行创建
3. `ApplicationContext` 接口有实现类：
   - `FileSystemXmlApplicationContext`
   - `ClassPathXmlApplicationContext`



### IOC 操作（Bean 管理）

1. Bean 管理的两个操作
   - Spring 创建对象
   - 用 Spring 注入属性
2. Bean 管理操作有两种方式
   - 基于 xml 配置文件方式实现
   - 基于注解方式实现



#### 基于 xml 方式

1. **基于 xml 方式创建对象**

   - ```xml
     <!--  配置User对象创建  -->
     <bean id="user" class="com.wang.spring5.User"></bean>
     ```

     1. 在 spring 配置文件中，使用 `bean` 标签，标签里面添加对应属性，就可以实现对象的创建
     2. bean 标签常用的属性
        - id 属性：唯一标识
        - class 属性：类全路径（包类路径）
     3. 创建对象时，默认执行**无参构造方法**完成对象的创建

2. **基于 xml 方式注入属性**

   - DI：依赖注入，就是注入属性（是在创建对象的基础之上注入）

     1. 第一种注入方式：使用 set 方法进行注入

        1. 创建类，定义属性和对应的 set 方法

        2. 在 spring 配置文件（xml 文件）配置对象的创建，配置属性的注入

           - ```xml
             <bean id="book" class="com.wang.spring5.Book">
                     <!--  使用 property 完成属性注入
                             name：类里面属性名称
                             value：向属性注入的值
                     -->
             	<property name="bname" value="易筋经"></property>
             	<property name="bauthor" value="达摩老祖"></property>
             </bean>
             ```

     2. 第二种注入方式：使用有参构造进行注入

        1. 创建类，定义属性，创建属性对应有参构造方法

        2. 在 spring 配置文件中进行配置

           - ```xml
             <bean id="orders" class="com.wang.spring5.Orders">
             	<constructor-arg name="oname" value="电脑"></constructor-arg>
             	<constructor-arg name="address" value="China"></constructor-arg>
             </bean>
             ```

3. p 名称空间注入

   - 使用 p 名称空间注入，可以简化基于 xml 配置方式

     1. 添加 p 名称空间在配置文件中

        - ```xml
          <beans xmlns="http://www.springframework.org/schema/beans"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xmlns:p="http://www.springframework.org/schema/p"
                 xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
          ```

     2. 进行属性注入，在 bean 标签里面进行操作

        - ```xml
          <bean id="book" class="com.wang.spring5.Book" p:bname="九阳神功" p:bauthor="无名氏">
          </bean>
          ```



#### xml 注入其他类型属性

1. 字面量

   1. null 值

      - ```xml
        <!--null 值-->
        <property name="address">
        	<null/>
        </property>
        ```

   2. 属性值包含特殊符号

      - ```xml
        <!--属性值包含特殊符号
        	1 把<>进行转义 &lt; &gt;
        	2 把带特殊符号内容写到 CDATA
        -->
        <property name="address">
            <value><![CDATA[<<南京>>]]></value>
        </property>
        ```

        - 输出“<<南京>>”

2. 注入属性 - 外部 bean      *通过 service 调用 dao 就叫外部 bean*

   1. 创建两个类 service 类和 dao 类

   2. 在 service 调用 dao 里面的方法

   3. 在 spring 配置文件中进行配置

      - ```xml
        <!--1. service 和 dao 对象创建-->
        <bean id="userService" class="com.wang.spring5.service.UserService">
            <!--注入 userDao 对象
            name 属性：类里面属性名称
            ref 属性：创建 userDao 对象 bean 标签中的 id 值
            -->
            <property name="userDao" ref="userDaoImpl"></property>
        </bean>
        <bean id="userDaoImpl" class="com.wang.spring5.dao.UserDaoImpl"></bean>
        ```

3. 注入属性 - 内部 bean

   1. 一对多关系：部门和员工

      - 部门是一，员工是多：一个部门有多个员工，一个员工属于一个部门

   2. 在实体类之间表示一对多关系，员工表示所属部门，使用对象类型属性进行表示

   3. 在 spring 配置文件中进行配置

      - ```xml
        <!--内部 bean-->
        <bean id="emp" class="com.wang.spring5.bean.Emp">
            <!--设置两个普通属性-->
            <property name="ename" value="Elowen"></property>
            <property name="gender" value="女"></property>
            <!--设置对象类型属性-->
            <property name="dept">
                <bean id="dept" class="com.wang.spring5.bean.Dept">
                    <property name="dname" value="安保部"></property>
                </bean>
            </property>
        </bean>
        ```

4. 注入属性 - 级联赋值

   1.  第一种写法：采用外部 bean

      - ```xml
        <!--级联赋值-->
        <bean id="emp" class="com.wang.spring5.bean.Emp">
            <!--设置两个普通属性-->
            <property name="ename" value="Elowen"></property>
            <property name="gender" value="女"></property>
            <!--设置对象类型属性-->
            <property name="dept" ref="dept"></property>
        </bean>
        
        <bean id="dept" class="com.wang.spring5.bean.Dept">
        	<property name="dname" value="财务部"></property>
        </bean>
        ```

   2. 第二种写法

      - 生成 dept 的 get 方法

      - ```xml
        <!--级联赋值-->
        <bean id="emp" class="com.wang.spring5.bean.Emp">
            <!--设置两个普通属性-->
            <property name="ename" value="Elowen"></property>
            <property name="gender" value="女"></property>
            <!--设置对象类型属性-->
            <property name="dept" ref="dept"></property>
            <property name="dept.dname" value="技术部"></property>
        </bean>
        
        <bean id="dept" class="com.wang.spring5.bean.Dept">
        	<property name="dname" value="财务部"></property>
        </bean>
        ```



#### xml 注入集合属性

1. 注入数组类型属性

2. 注入 List 集合类型属性

3. 注入 Map 集合类型属性

   1. 创建类，定义数组、list、map、set 类型属性，生成对应 set 方法

   2. 在 spring 配置文件进行配置

      - ```xml
        <!--1 集合类型属性注入-->
        <bean id="stu" class="com.wang.spring5_demo2.collectiontype.Stu">
            <!--数组类型属性注入-->
            <property name="courses">
                <array>
                    <value>java 课程</value>
                    <value>数据库课程</value>
                </array>
            </property>
        
            <!--list 类型属性注入-->
            <property name="list">
                <list>
                    <value>张三</value>
                    <value>小三</value>
                </list>
            </property>
        
            <!--map 类型属性注入-->
            <property name="maps">
                <map>
                    <entry key="JAVA" value="java"></entry>
                    <entry key="PHP" value="php"></entry>
                </map>
            </property>
        
            <!--set 类型属性注入-->
            <property name="sets">
                <set>
                    <value>MySQL</value>
                    <value>Redis</value>
                </set>
            </property>
        </bean>
        ```

4. 在集合里面设置对象类型值

   - 创建多个 course 对象

     - ```xml
       <!--创建多个 course 对象-->
       <bean id="course1" class="com.wang.spring5_demo2.collectiontype.Course">
       	<property name="cname" value="Spring5 框架"></property>
       </bean>
       
       <bean id="course2" class="com.wang.spring5_demo2.collectiontype.Course">
       	<property name="cname" value="MyBatis 框架"></property>
       </bean>
       ```

   - 注入 list 集合类型，值是对象

     - ```xml
       <!--注入 list 集合类型，值是对象-->
       <property name="courseList">
           <list>
               <ref bean="course1"></ref>
               <ref bean="course2"></ref>
           </list>
       </property>
       ```

5. 把集合注入部分提取出来

   1. 在 spring 配置文件中引入名称空间 util

      - ```xml
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:util="http://www.springframework.org/schema/util"
               xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                                   http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">
        ```

   2. 使用 util 标签完成 list 集合注入提取

      - ```xml
        <!--1 提取 list 集合类型属性注入-->
        <util:list id="bookList">
            <value>易筋经</value>
            <value>九阴真经</value>
            <value>九阳神功</value>
        </util:list>
        
        <!--2 提取 list 集合类型属性注入使用-->
        <bean id="book" class="com.wang.spring5_demo2.collectiontype.Book">
        	<property name="list" ref="bookList"></property>
        </bean>
        ```



#### FactoryBean

1. Spring 有两种类型 bean：一种普通 bean，另外一种工厂 bean（FactoryBean）

   1. 普通 bean：在配置文件中定义 bean 类型就是返回类型

   2. 工厂 bean：在配置文件定义 bean 类型可以和返回类型不一样

      1. 创建类，让这个类作为工厂 bean，实现接口 FactoryBean

      2. 实现接口里面的方法，在实现的方法中定义返回的 bean 类型

         - ```java
           public class MyBean implements FactoryBean<Course> {
               // 定义返回 bean
               @Override
               public Course getObject() throws Exception {
                   Course course = new Course();
                   course.setCname("abc");
                   return course;
               }
               @Override
               public Class<?> getObjectType() {
                   return null;
               }
               @Override
               public boolean isSingleton() {
                   return FactoryBean.super.isSingleton();
               }
           }
           ```

         - 配置文件（不变）

           - ```xml
             <bean id="myBean" class="com.wang.spring5_demo2.factoryBean.MyBean">
             </bean>
             ```



#### bean 作用域

1. 在 Spring 里面，设置创建 bean 实例是单实例还是多实例
   1. 默认情况下，bean 是单实例对象
2. 设置单实例 or 多实例
   1. 在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例
   2. scope 属性值
      1. 默认值，singleton 表示是单实例对象
      2. prototype 表示是多实例对象
   3. singleton 和 prototype 区别
      1. singleton 单实例，prototype 多实例
      2. 设置 scope 值是
         1. singleton：加载 spring 配置文件时候就会创建单实例对象
         2. prototype：不是在加载 spring 配置文件时候创建 对象，在调用 `getBean` 方法时候创建多实例对象



#### bean 生命周期

*生命周期：从对象创建到对象销毁的过程*

1. bean 生命周期：

   1. 通过构造器创建 bean 实例（无参数构造）
   2. 为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
   3. 调用 bean 的初始化的方法（需要进行配置初始化的方法）
   4. bean 可以使用了（对象获取到了）
   5. 当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

2. 演示 bean 的生命周期

   - ```java
     public class Orders {
         // 无参数构造
         public Orders() {
             System.out.println("第一步 执行无参数构造创建 bean 实例");
         }
         private String oname;
         public void setOname(String oname) {
             this.oname = oname;
             System.out.println("第二步 调用 set 方法设置属性值");
         }
         // 创建执行的初始化的方法
         public void initMethod() {
             System.out.println("第三步 执行初始化的方法");
         }
         // 创建执行的销毁的方法
         public void destroyMethod() {
             System.out.println("第五步 执行销毁的方法");
         }
     }
     ```

   - ```xml
     <bean id="orders" class="com.wang.spring5_demo2.bean.Orders" init-method="initMethod" destroy-method="destroyMethod">
     	<property name="oname" value="手机"></property>
     </bean>
     ```

   - ```java
     @Test
     public void testBean4(){
     // ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
     
     Orders orders = context.getBean("orders", Orders.class);
     System.out.println("第四步 获取创建 bean 实例对象");
     System.out.println(orders);
     
     // 手动让 bean 实例销毁
     context.close();
     }
     ```

3. bean 的后置处理器，bean 生命周期有 7 步

   1. 通过构造器创建 bean 实例（无参数构造）
   2. 为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
   3. **把 bean 实例传递 bean 后置处理器的方法** `postProcessBeforeInitialization`
   4. 调用 bean 的初始化的方法（需要进行配置初始化的方法）
   5. **把 bean 实例传递 bean 后置处理器的方法** `postProcessAfterInitialization`
   6. bean 可以使用了（对象获取到了）
   7. 当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

4. 演示添加后置处理器

   1. 创建类，实现接口 BeanPostProcessor，创建后置处理器

      - ```java
        public class MyBeanPost implements BeanPostProcessor {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("在初始化之前执行的方法");
                return bean;
            }
        
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("在初始化之后执行的方法");
                return bean;
            }
        }
        ```

      - ```xml
        <!--配置后置处理器-->
        <bean id="myBeanPost" class="com.wang.spring5_demo2.bean.MyBeanPost"></bean>
        ```



#### xml 自动装配

*自动装配：根据指定装配规则（属性名称或者属性类型），Spring 自动将匹配的属性值进行注入*

1. bean 标签属性 autowire，配置自动装配。autowire 属性常用两个值

   1. byName 根据属性名称自动注入【**注入值 bean 的 id 值和类属性名称一样**】

      - ```xml
        <!--实现自动装配
        	bean 标签属性 autowire，配置自动装配
        	autowire 属性常用两个值：
        		byName 根据属性名称注入，注入值 bean 的 id 值和类属性名称一样
        		byType 根据属性类型注入
        -->
        <bean id="emp" class="com.wang.spring5_demo2.autowire.Emp" autowire="byName"></bean>
        <bean id="dept" class="com.wang.spring5_demo2.autowire.Dept">
        </bean>
        ```

   2. byType 根据属性类型自动注入

      - ```xml
        <bean id="emp" class="com.wang.spring5_demo2.autowire.Emp" autowire="byType"></bean>
        <bean id="dept" class="com.wang.spring5_demo2.autowire.Dept">
        </bean>
        ```



#### 外部属性文件

1. 直接配置数据库信息

   1. 配置 Druid 连接池

   2. 引入 Druid 连接池依赖 jar 包

      - ```xml
        <!--直接配置连接池-->
        <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
            <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
            <property name="url" value="jdbc:mysql://localhost:3306/userDb"></property>
            <property name="username" value="root"></property>
            <property name="password" value="root"></property>
        </bean>
        ```

2. 引入外部属性文件配置数据库连接池

   1. 创建外部属性文件，properties 格式文件，写数据库信息

      - ```properties
        prop.driverClass=com.mysql.jdbc.Driver
        prop.url=jdbc:mysql://localhost:3306/userDb
        prop.userName=root
        prop.password=root
        ```

   2. 把外部 properties 属性文件引入到 spring 配置文件中

      - 引入 context 名称空间

        - ```xml
          <beans xmlns="http://www.springframework.org/schema/beans"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                       xmlns:context="http://www.springframework.org/schema/context"
                 xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                                     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
          ```

      - 在 spring 配置文件使用标签引入外部属性文件

        - ```xml
          <!--引入外部属性文件-->
          <context:property-placeholder location="classpath:jdbc.properties"/>
          
          <!--配置连接池-->
          <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
              <property name="driverClassName" value="${prop.driverClass}"></property>
              <property name="url" value="${prop.url}"></property>
              <property name="username" value="${prop.userName}"></property>
              <property name="password" value="${prop.password}"></property>
          </bean>
          ```



#### 基于注解方式

*注解：简化 xml 配置*

1. Spring 针对 Bean 管理中创建对象提供注解

   1. `@Component`
   2. `@Service`
   3. `@Controller`
   4. `@Repository`

   - 这四个注解功能是一样的，都可以用来创建 bean 实例

2. **基于注解方式实现对象创建**

   1. 引入依赖 spring-aop-5.2.6.RELEASE.jar

   2. 开启组件扫描

      - ```xml
        <!--开启组件扫描
            如果扫描多个包，
                1 多个包使用逗号隔开
                2 扫描包上层目录
        -->
        <context:component-scan base-package="com.wang.spring5_demo3"></context:component-scan>
        ```

   3. 创建类，在类上面添加创建对象注解

   4. 开启组件扫描细节配置

      - `use-default-filters="false"` 表示现在不使用默认 filter，自己配置 filter

        - `context:include-filter` 设置扫描哪些内容

          - ```xml
            <!--示例 1
            	use-default-filters="false" 表示现在不使用默认 filter，自己配置 filter
            	context:include-filter 设置扫描哪些内容
            -->
            <context:component-scan base-package="com.wang.spring5_demo3" use-default-filters="false">
            	<context:include-filter type="annotation" 
            expression="org.springframework.stereotype.Controller"/>
            </context:component-scan>
            ```

      - `context:exclude-filter` 设置哪些内容不进行扫描

        - ```xml
          <!--示例 2
              下面配置扫描包所有内容
              context:exclude-filter： 设置哪些内容不进行扫描
          -->
          <context:component-scan base-package="com.wang.spring5_demo3">
          	<context:exclude-filter type="annotation"
          expression="org.springframework.stereotype.Controller"/>
          </context:component-scan>
          ```

   5. **基于注解方式实现属性注入**

      1. `@Autowired`：根据属性类型进行自动装配

         1. 把 service 和 dao 对象创建，在 service 和 dao 类添加创建对象注解

         2. 在 service 注入 dao 对象，在 service 类添加 dao 类型属性，在属性上面使用注解

            - 在 UserDaoImpl 类类上加 `@Repository`

            - ```java
              @Service
              public class UserService {
                  // 定义 dao 类型属性
                  // 不需要添加 set 方法
                  // 添加注入属性注解
                  @Autowired // 根据属性类型进行注入
                  private UserDao userDao;
              
                  public void add() {
                      System.out.println("service add.......");
                      userDao.add();
                  }
              }
              ```

      2. `@Qualifier`：根据属性名称进行注入

         - 这个 @Qualifier 注解的使用，和上面 @Autowired 一起使用

           - ```java
             @Repository("userDaoImpl1")
             public class UserDaoImpl implements UserDao{
                 @Override
                 public void add() {
                     System.out.println("dao add...");
                 }
             }
             ```

           - ```java
             @Service
             public class UserService {
             
                 // 定义 dao 类型属性
                 // 不需要添加 set 方法
                 // 添加注入属性注解
                 @Autowired // 根据属性类型进行注入
                 @Qualifier(value = "userDaoImpl1") // 根据属性名称进行注入
                 private UserDao userDao;
             
                 public void add() {
                     System.out.println("service add.......");
                     userDao.add();
                 }
             }
             ```

      3. `@Resource`：可以根据类型注入，可以根据名称注入

         - ```java
           @Service
           public class UserService {
           
           //    @Resource // 根据类型进行注入
               @Resource(name = "userDaoImpl1") // 根据名称进行注入
               private UserDao userDao;
           
               public void add() {
                   System.out.println("service add.......");
                   userDao.add();
               }
           }
           ```

      4. `@Value`：注入**普通类型属性**

         - ```java
           @Service
           public class UserService {
           
               @Value(value = "abc")
               private String name;
           
               //    @Resource // 根据类型进行注入
               @Resource(name = "userDaoImpl1") // 根据名称进行注入
               private UserDao userDao;
           
               public void add() {
                   System.out.println("service add......." + name);
                   userDao.add();
               }
           }
           ```

   6. 完全注解开发

      1. 创建配置类，替代 xml 配置文件

         - ```java
           @Configuration // 作为配置类，替代 xml 配置文件
           @ComponentScan(basePackages = "com.wang.spring5_demo3")
           public class SpringConfig {
           }
           ```

      2. 编写测试类

         - ```java
           @Test
           public void testService2() {
               ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
               UserService userService = context.getBean("userService", UserService.class);
               System.out.println(userService);
               userService.add();
           }
           ```







## AOP

*面向切面编程*：利用 AOP 可以对业务逻辑的各个部分进行隔离，从而使得

业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。（即不通过修改源代码方式，在主干功能里面添加新功能）



### AOP 底层原理

1. AOP 底层使用动态代理
   1. 有接口，使用 JDK 动态代理
      - 创建接口实现类的代理对象，增强类的方法
   2. 没有接口，使用 CGLIB 动态代理
      - 创建子类的代理对象，增强类的方法



### JDK 动态代理

1. 使用 JDK 动态代理，使用 `Proxy` 类里面的方法创建代理对象

   1. 调用 `newProxyInstance` 方法
      - `static Object newProxyInstance(ClassLoader loader, 类<?>[] interfaces, InvocationHandler h)` 返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
        - 三个参数：
          1. 类加载器
          2. 增强方法所在的类，这个类实现的接口，支持多个接口。
          3. 实现这个接口 `InvocationHandler`，创建代理对象，写增强的部分。

2. 编写 JDK 动态代理代码

   1. 创建接口，定义方法

      - `UserDao` 接口

   2. 创建接口实现类，实现方法

      - `UserDaoImpl` 实现类

   3. 使用 Proxy 类创建接口代理对象

      - ```java
        public class JDKProxy {
            public static void main(String[] args) {
        
                // 创建接口实现类代理对象
                Class[] interfaces = {UserDao.class};
                /*Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                });*/
        
                UserDaoImpl userDao = new UserDaoImpl();
                UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        
                int result = dao.add(1, 3);
                System.out.println("result:" + result);
            }
        }
        
        // 创建代理对象代码
        class UserDaoProxy implements InvocationHandler {
        
            // 创建的是谁的代理对象，把谁传递过来
            // 有参构造传递
            private Object obj;
        
            public UserDaoProxy(Object obj) {
                this.obj = obj;
            }
        
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
                // 方法之前
                System.out.println("方法之前执行....." + method.getName() + "：传递过来的参数..." + Arrays.toString(args));
                // 被增强的方法执行
                Object res = method.invoke(obj, args);
                // 方法之后
                System.out.println("方法之后执行...." + obj);
                return res;
            }
        }
        ```



### 术语

1. 连接点：类里面哪些方法可以被增强，这些方法称为连接点
2. 切入点：实际被真正增强的方法，成为切入点
3. 通知（增强）
   1. 实际增强的逻辑部分称为通知（增强）
   2. 通知有多种类型：
      - 前置通知
      - 后置通知
      - 环绕通知
      - 异常通知
      - 最终通知（类似 finally）
4. 切面：是动作，把通知应用到切入点过程



### 准备工作

1. Spring 框架一般都是基于 AspectJ 实现 AOP 操作
   - AspectJ 不是 Spring 组成部分，独立 AOP 框架，一般把 AspectJ 和Spring 框架一起使用，进行 AOP 操作
2. 基于 AspectJ 实现 AOP 操作
   1. 基于 xml 配置文件实现
   2. 基于注解方式实现
3. 引入 AOP 相关依赖
4. 切入点表达式
   1. 切入点表达式作用：知道对哪个类里面的哪个方法进行增强
   2. 语法结构： `execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]))`
      - eg：
        1. 对 com.wang_AOP.dao.BookDao 类里面的 add 进行增强 `execution(* com.wang_AOP.dao.BookDao.add(..))`
        2. 对 com.wang_AOP.dao.BookDao **类里面的所有的方法**进行增强 `execution(* com.wang_AOP.dao.BookDao.* (..))`
        3. 对 com.atguigu.dao **包里面所有类，类里面所有方法**进行增强 `execution(* com.atguigu.dao.*.* (..))`



### AspectJ 注解

1. 创建类，在类里面定义方法

2. 创建增强类（编写增强逻辑）

   - 在增强类里面，创建方法，让不同方法代表不同通知类型

3. 进行通知的配置

   1. 在 spring 配置文件中，开启注解扫描

      - ```xml
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:context="http://www.springframework.org/schema/context"
               xmlns:aop="http://www.springframework.org/schema/aop"
               xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                                    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
                                    http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
        ```

      - ```xml
        <!-- 开启注解扫描 -->
        <context:component-scan base-package="com.wang_AOP.aopanno"></context:component-scan>
        ```

   2. 使用注解创建 User 和 UserProxy 对象

   3. 在增强类上面添加注解 @Aspect

      - ```java
        // 增强的类
        @Component
        @Aspect // 生成代理对象
        public class UserProxy {
            // 前置通知
            public void before() {
                System.out.println("before......");
            }
        }
        ```

   4. 在 spring 配置文件中开启 Aspect 生成代理对象

      - ```xml
        <!-- 开启 Aspect 生成代理对象-->
        <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
        ```

4. 配置不同类型的通知

   - 在增强类的里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置

     - ```java
       // 增强的类
       @Component
       @Aspect // 生成代理对象
       public class UserProxy {
       
           // 前置通知
           @Before(value = "execution(* com.wang_AOP.aopanno.User.add(..))")
           public void before() {
               System.out.println("before......");
           }
       
           // 后置通知（返回通知）
           @AfterReturning(value = "execution(* com.wang_AOP.aopanno.User.add(..))")
           public void afterReturning() {
               System.out.println("afterReturning......");
           }
       
           // 最终通知
           @After(value = "execution(* com.wang_AOP.aopanno.User.add(..))")
           public void after() {
               System.out.println("after......");
           }
       
           // 异常通知
           @AfterThrowing(value = "execution(* com.wang_AOP.aopanno.User.add(..))")
           public void afterThrowing() {
               System.out.println("afterThrowing......");
           }
       
           // 环绕通知
           @Around(value = "execution(* com.wang_AOP.aopanno.User.add(..))")
           public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
               System.out.println("环绕之前......");
               // 被增强的方法执行
               proceedingJoinPoint.proceed();
               System.out.println("环绕之后......");
           }
       
       }
       ```

5. 相同的切入点抽取

   - ```java
     // 相同切入点抽取
     @Pointcut(value = "execution(* com.wang_AOP.aopanno.User.add(..))")
     public void pointdemo(){
     }
     
     // 前置通知
     @Before(value = "pointdemo()")
     public void before() {
         System.out.println("before......");
     }
     ```

6. 有多个增强类对同一个方法进行增强，设置增强类优先级

   - 在增强类上面添加注解 `@Order(数字类型值)`，数字类型值越小，优先级越高

     - ```java
       @Component
       @Aspect
       @Order(1)
       public class PersonProxy
       ```

7. 完全注解开发

   - 创建配置类，不需要创建 xml 配置文件

     - ```java
       @Configurable
       @ComponentScan(basePackages = {"com.wang_AOP.aopanno"})
       @EnableAspectJAutoProxy(proxyTargetClass = true) // 开启 Aspect 生成代理对象，相当于 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
       public class ConfigAop {
       }
       ```



### AspectJ 配置文件

1. 创建两个类，增强类和被增强类，创建方法

2. 在 spring 配置文件中创建两个类对象

   - ```xml
     <!--创建对象-->
     <bean id="book" class="com.wang_AOP.aopxml.Book"></bean>
     <bean id="bookProxy" class="com.wang_AOP.aopxml.BookProxy"></bean>
     ```

3. 在 spring 配置文件中配置切入点

   - ```xml
     <!--配置 aop 增强-->
     <aop:config>
         <!--切入点-->
         <aop:pointcut id="p" expression="execution(* com.wang_AOP.aopxml.Book.buy(..))"/>
         <!--配置切面-->
         <aop:aspect ref="bookProxy">
             <!--增强作用在具体的方法上-->
             <aop:before method="before" pointcut-ref="p"/>
         </aop:aspect>
     </aop:config>
     ```



## JdbcTemplate

*Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作*



### 准备

1. 引入相关 jar 包

2. 在 spring 配置文件配置数据库连接池

   - ```xml
     <!-- 数据库连接池 -->
     <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
     destroy-method="close">
         <property name="url" value="jdbc:mysql:///user_db" />
         <property name="username" value="root" />
         <property name="password" value="root" />
         <property name="driverClassName" value="com.mysql.jdbc.Driver" />
     </bean>
     ```

3. 配置 JdbcTemplate 对象，注入 DataSource

   - ```xml
     <!-- JdbcTemplate 对象 -->
     <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
     <!--注入 dataSource-->
     	<property name="dataSource" ref="dataSource"></property>
     </bean>
     ```

4. 创建 service 类，创建 dao 类，在 service 注入 dao，在 dao 注入 jdbcTemplate 对象

   - ```java
     // 注入 dao
     @Autowired
     private BookDao bookDao;
     
     // 注入 JdbcTemplate
     @Autowired
     private JdbcTemplate jdbcTemplate;
     ```

   - 配置文件

     - ```xml
       <!-- 组件扫描 -->
       <context:component-scan base-package="com.wang.jdbcTemplate"></context:component-scan>
       ```



### 操作数据库

#### 添加、修改和删除

*以添加为例，修改和删除操作类似*

1. 对应数据库创建实体类
2. 编写 service 和 dao
   1. 在 dao 进行数据库添加操作
   2. 调用 JdbcTemplate 对象里面 `update` 方法实现添加操作
      - 有两个参数
        - sql 语句
        - 可变参数，设置 sql 语句值
      - `int update = jdbcTemplate.update(sql, args);`
3. 测试类



#### 查询返回某个值

1. 查询表里面有多少条记录，返回是某个值
2. 使用 JdbcTemplate 实现查询返回某个值代码
   - `<T> T queryForObject(String sql, Class<T> requiredType)`
     - 两个参数
       - sql 语句
       - 返回类型 Class



#### 查询返回对象

1. 场景：查询图书详情
2. JdbcTemplate 实现查询返回对象
   - `<T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args)`
     - 三个参数
       - sql 语句
       - RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成数据封装
       - sql 语句值



#### 查询返回集合

1. 场景：查询图书列表分页
2. 调用 JdbcTemplate 方法实现查询返回集合
   - `<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args)`
     - 三个参数
       - sql 语句
       - RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成数据封装
       - sql 语句值



#### 批量操作

*批量操作：操作表里多条记录*

1. JdbcTemplate 实现批量添加操作
   - `batchUpdate(String sql, List<Object[]> batchArgs)`
     - 两个参数
       - sql 语句
       - List 集合，添加多条记录数据
2. JdbcTemplate 实现批量修改操作
   - `batchUpdate(String sql, List<Object[]> batchArgs)` 类似添加
3. JdbcTemplate 实现批量删除操作
   - 同上







## 事务操作

*事务是数据库操作最基本单元，逻辑上一组操作，要么都成功，如果有一个失败，所有操作都失败*

1. 典型场景：银行转账
2. 事务四个特性（ACID）
   1. 原子性
   2. 一致性
   3. 隔离性
   4. 持久性



### 搭建事务操作环境

1. 创建数据库表，添加记录

2. 创建 service，搭建 dao，完成对象创建和注入关系

   - 【1】service 注入 dao
   - 【2】在 dao 注入 JdbcTemplate
   - 【3】在 JdbcTemplate 注入 DataSource

3. 在 dao 创建两个方法：多钱和少钱的方法，在 service 创建方法（转账的方法）

4. 如果正常执行没有问题的，但是如果代码执行过程中出现异常，有问题

   - 使用事务解决

     - ```java
       // 转账的方法
       public void accountMoney() {
           try {
               // 1、开启事务
       
               // 2、进行事务操作
       
               // lucy 少 100
               userDao.reduceMoney();
       
               // 模拟异常
               int i = 10 / 0;
       
               // mary 多 100
               userDao.addMoney();
       
               // 3、没有发生异常，提交事务
           } catch (Exception e) {
           // 4、出现异常，事务回滚
       }
       ```



### Spring 事务管理

1. **事务添加到** JavaEE 三层结构里面 **Service 层**（业务逻辑层）

2. Spring 中进行事务管理有两种方式：

   - 编程式事务管理
   - 声明式事务管理【建议使用】

3. 声明式事务管理

   1. 基于注解方式【建议使用】
   2. 基于 xml 配置文件方式

4. Spring 进行声明式事务管理，底层使用 AOP 原理

5. Spring 事务管理 API

   - 提供一个接口，代表事务管理器，这个接口针对不同的框架提供不同的实现类

     ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507232244136.png)



### 注解声明式事务管理

1. 在 Spring 配置文件配置事务管理器

   - ```xml
     <!--创建事务管理器-->
     <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     <!--注入数据源-->
     	<property name="dataSource" ref="dataSource"></property>
     </bean>
     ```

2. 在 Spring 配置文件，开启事务注解

   1. 在 Spring 配置文件引入名称空间 tx
   2. 开启事务

      - ```xml
        <!--开启事务注解-->
        <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
        ```

3. 在 service 类上面（或者 service 类里面方法上面）添加事务注解

   1. `@Transactional` 这个注解添加到类上面，也可以添加方法上面
   2. 如果把这个注解添加类上面，这个类里面所有的方法都添加事务
   3. 如果把这个注解添加方法上面，为这个方法添加事务

   - ```java
     @Service
     @Transactional
     public class UserService
     ```



### 声明式事务管理参数配置

1. 在 service 类上面添加注解 @Transactional，在这个注解里面可以配置事务相关参数

   ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507241610504.png)

2. propagation：事务传播行为

   - 当一个事务方法被另外一个事务方法调用时候，这个事务方法如何进行
     - REQUIRED【强制新建独立事务，与外部事务完全隔离】
       - 两者处于不同的 logical transaction，但是，处于相同的physical transaction。当两者有一个回滚时，他们都会回滚
     - REQUIRED_NEW【根据是否存在事务决定加入或新建】
       - 处于不同的 logical transaction 和 physical transaction。两者彼此独立，互不影响。
     - SUPPORTS

3. ioslation：事务隔离级别

   1. 事务有特性称为隔离性，多事务操作之间不会产生影响。不考虑隔离性产生很多问题

   2. 有三个读问题：脏读、不可重复读、虚（幻）读

      1. 脏读：一个未提交事务读取到另一个未提交事务的数据
      2. 不可重复读：一个未提交事务读取到另一提交事务修改数据
      3. 虚读：一个未提交事务读取到另一提交事务添加数据

   3. 解决：通过设置事务隔离级别，解决读问题

      - |                                     | 脏读 | 不可重复读 | 幻读 |
        | ----------------------------------- | ---- | ---------- | ---- |
        | READ_UNCOMMITTED（读未提交）        | 有   | 有         | 有   |
        | READ_COMMITTED（读已提交）          | 无   | 有         | 有   |
        | REPEATABLE_READ（可重复读）【默认】 | 无   | 无         | 有   |
        | SERIALIZABLE（串行化）              | 无   | 无         | 无   |

      - ```java
        @Service
        @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
        public class UserService
        ```

4. timeout：超时时间

   1. 事务需要在一定时间内进行提交，如果不提交进行回滚
   2. 默认值是 -1 ，设置时间以秒单位进行计算

5. readOnly：是否只读

   1. 读：查询操作；写：添加修改删除操作
      1. readOnly 默认值 false，表示可以查询，可以添加修改删除操作
      2. 设置 readOnly 值是 true，设置成 true 之后，只能查询

6. rollbackFor：回滚

   1. 设置出现哪些异常进行事务回滚

7. noRollbackFor：不回滚

   1. 设置出现哪些异常不进行事务回滚



### xml 声明式事务管理

1. 在 spring 配置文件中进行配置

   1. 配置事务管理器
   2. 配置通知
   3. 配置切入点和切面

   - ```xml
     <!--1 创建事务管理器-->
     <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
         <!--注入数据源-->
         <property name="dataSource" ref="dataSource"></property>
     </bean>
     
     <!--2 配置通知-->
     <tx:advice id="txadvice">
         <!--配置事务参数-->
         <tx:attributes>
             <!--指定哪种规则的方法上面添加事务-->
             <tx:method name="accountMoney" propagation="REQUIRED"/>
             <!--<tx:method name="account*"/>-->
         </tx:attributes>
     </tx:advice>
     
     <!--3 配置切入点和切面-->
     <aop:config>
     <!--配置切入点-->
         <aop:pointcut id="pt" expression="execution(* com.wang.tx.service.UserService.*(..))"/>
         <!--配置切面-->
         <aop:advisor advice-ref="txadvice" pointcut-ref="pt"/>
     </aop:config>
     ```



### 完全注解声明式事务管理

1. 创建配置类，使用配置类替代 xml 配置文件

   - ```java
     @Configuration // 配置类
     @ComponentScan(basePackages = "com.wang.tx") // 组件扫描
     @EnableTransactionManagement // 开启事务
     public class TxConfig {
     
         // 创建数据库连接池
         @Bean
         public DruidDataSource getDruidDataSource(){
             DruidDataSource dataSource = new DruidDataSource();
             dataSource.setDriverClassName("com.mysql.jdbc.Driver");
             dataSource.setUrl("jdbc:mysql://localhost:3307/user_db");
             dataSource.setUsername("root");
             dataSource.setPassword("root");
             return dataSource;
         }
     
         // 创建 JdbcTemplate 对象
         @Bean
         public JdbcTemplate getJdbcTemplate(DataSource dataSource){
             // 到 ioc 容器中根据类型找到 dataSource
             JdbcTemplate jdbcTemplate = new JdbcTemplate();
             // 注入 dataSource
             jdbcTemplate.setDataSource(dataSource);
             return jdbcTemplate;
         }
     
         // 创建事务管理器
         @Bean
         public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
             DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
             transactionManager.setDataSource(dataSource);
             return transactionManager;
         }
     }
     ```







## Spring 5 框架新功能

1. 整个 Spring5 框架的代码基于 Java8，运行时兼容 JDK9，许多不建议使用的类和方法在代码库中删除

2. Spring 5.0 框架自带了通用的日志封装

   1. Spring5 已经移除 Log4jConfigListener，官方建议使用 Log4j2

   2. Spring5 框架整合 Log4j2

      1. 引入 jar 包

      2. 创建 log4j2.xml 配置文件

         - ```xml
           <?xml version="1.0" encoding="UTF-8"?>
           <!--日志级别以及优先级排序: OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL -->
           <!--Configuration后面的status用于设置log4j2自身内部的信息输出，可以不设置，当设置成trace时，可以看到log4j2内部各种详细输出-->
           <configuration status="INFO">
               <!--先定义所有的appender-->
               <appenders>
                   <!--输出日志信息到控制台-->
                   <console name="Console" target="SYSTEM_OUT">
                       <!--控制日志输出的格式-->
                       <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
                   </console>
               </appenders>
               <!--然后定义logger，只有定义了logger并引入的appender，appender才会生效-->
               <!--root：用于指定项目的根日志，如果没有单独指定Logger，则会使用root作为默认的日志输出-->
               <loggers>
                   <root level="info">
                       <appender-ref ref="Console"/>
                   </root>
               </loggers>
           </configuration>
           ```

3. Spring5 框架核心容器支持 @Nullable 注解

   1. @Nullable 注解可以使用在方法上面，属性上面，参数上面：表示方法返回可以为空，属性值可以为空，参数值可以为空

   2. Spring5 核心容器支持函数式风格 GenericApplicationContext

      - ```java
        //函数式风格创建对象，交给 spring 进行管理
        @Test
        public void testGenericApplicationContext() {
            //1 创建 GenericApplicationContext 对象
            GenericApplicationContext context = new GenericApplicationContext();
            //2 调用 context 的方法对象注册
            context.refresh();
            context.registerBean("user1", User.class, () -> new User());
            //3 获取在 spring 注册的对象
            // User user = (User)context.getBean("com.atguigu.spring5.test.User");
            User user = (User) context.getBean("user1");
            System.out.println(user);
        }
        ```

4. Spring 5 支持整合 JUnit 5

   1. 整合 JUnit 4

      1. 引入 Spring 相关针对测试依赖

      2. 创建测试类，使用注解方式完成

         - ```java
           @RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架
           @ContextConfiguration("classpath:bean1.xml") // 加载配置文件
           public class JTest4 {
           
               @Autowired
               private UserService userService;
           
               @Test
               public void test1(){
                   userService.accountMoney();
               }
           }
           ```

   2. Spring 5 整合 JUnit 5

      1. 引入 JUnit5 的 jar 包

      2. 创建测试类，使用注解完成

         - ```java
           @ExtendWith(SpringExtension.class)
           @ContextConfiguration("classpath:bean1.xml")
           public class JTest5 {
               @Autowired
               private UserService userService;
           
               @Test
               public void test1() {
                   userService.accountMoney();
               }
           }
           ```

      3. 使用一个复合注解替代上面两个注解完成整合

         - ```java
           @SpringJUnitConfig(locations = "classpath:bean1.xml")
           public class JTest5 {
               @Autowired
               private UserService userService;
           
               @Test
               public void test1() {
                   userService.accountMoney();
               }
           }
           ```







## Spring 5 框架新功能 Webfiux

### SpringWebfiux 介绍

1. 是 Spring5 添加新的模块，用于 web 开发的，功能和 SpringMVC 类似的，Webflux 使用当前一种比较流程响应式编程出现的框架。

2. 使用传统 web 框架，比如 SpringMVC，这些基于 Servlet 容器， Webflux 是一种异步非阻塞的框架，异步非阻塞的框架在 Servlet3.1 以后才支持，核心是基于 Reactor 的相关 API 实现的。

3. **异步非阻塞**【下面针对对象不一样】

   1. 异步和同步【针对调用者】
      - 调用者发送请求
        - 如果等着对方回应之后才去做其他事情就是**同步**
        - 如果发送请求之后不等着对方回应就去做其他事情就是异步
   2. 非阻塞和阻塞【针对被调用者】
      - 被调用者受到请求之后
        - 做完请求任务之后才给出反馈就是**阻塞**
        - 受到请求之后马上给出反馈然后再去做事情就是**非阻塞**

4. Webflux 特点

   1. 非阻塞式：在有限资源下，提高系统吞吐量和伸缩性，以 Reactor 为基础实现响应式编程
   2. 函数式编程：Spring5 框架基于 java8，Webflux 使用 Java8 函数式编程方式实现路由请求

5. 比较 SpringMVC

   ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507241906307.png)

   - 共同点：两个框架都可以使用注解方式，都运行在 Tomcat 等容器中
   - 不同点：SpringMVC 采用命令式编程，Webflux 采用异步响应式编程



### 响应式编程

1. 



### Webfiux 执行流程和核心 API



### SpringWebfiux（基于注解编程模型）



### SpringWebfiux（基于函数式编程模型）























