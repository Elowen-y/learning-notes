# Maven

- 管理规模庞大的 jar 包，需要专门的工具
  - jar 包规模
  - jar 包的来源问题
  - jar 包的导入问题
    - 在使用Maven之后，通过配置依赖(jar包)的坐标，查找本地仓库中相应jar包，若本地仓库没有，则统一从镜像网站或中央仓库中下载
  - jar 包之间的依赖
- 脱离 IDE 环境执行构建操作，需要专门工具

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507260937871.png)







## Maven 介绍

*Maven 是一款为 Java 项目管理构建、依赖管理的工具（软件），使用 Maven 可以自动化构建、测试、打包和发布项目，大大提高了开发效率和质量。*

1. **依赖管理**：
   - Maven 可以管理项目的依赖，包括自动下载所需依赖库、自动下载依赖需要的依赖并且保证版本没有冲突、依赖版本管理等。
2. **构建管理**：
   - Maven 可以管理项目的编译、测试、打包、部署等构建过程。通过实现标准的构建生命周期，Maven 可以确保每一个构建过程都遵循同样的规则和最佳实践。同时，Maven 的插件机制也使得开发者可以对构建过程进行扩展和定制。主动触发构建，只需要简单的命令操作即可。

**Maven 软件工作原理模型图**

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507260937197.png)







## Maven 安装和配置

### 一、Maven 安装

- **软件结构**：

  ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251122039.png)
  
  - **bin**：含有Maven的运行脚本
  - boot：含有plexus-classworlds类加载器框架
  - **conf**：含有Maven的核心配置文件
  - lib：含有Maven运行时所需要的Java类库
  - LICENSE、NOTICE、README.txt：针对Maven版本，第三方软件等简要介绍
  



### 二、Maven 环境配置

1. 配置 MAVEN_HOME

2. 配置Path

3. 命令测试（cmd 窗口）

   - ```bash
     mvn -v 
     # 输出版本信息即可，如果错误，请仔细检查环境变量即可！
     ```



### 三、Maven 功能配置

我们需要需改 **maven/conf/settings.xml** 配置文件，来修改 maven 的一些默认配置。我们主要需要修改的有三个配置：

1. 依赖本地缓存位置（本地仓库位置）

   ```xml
     <!-- localRepository
      | The path to the local repository maven will use to store artifacts.
      |
      | Default: ${user.home}/.m2/repository
     <localRepository>/path/to/local/repo</localRepository>
     -->
    <!-- conf/settings.xml 55行 -->
    <localRepository>D:\maven-repository</localRepository>
   ```

2. maven 下载镜像

   ```xml
   <!--在mirrors节点(标签)下添加中央仓库镜像 160行附近-->
   <mirror>
       <id>alimaven</id>
       <name>aliyun maven</name>
       <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
       <mirrorOf>central</mirrorOf>
   </mirror>
   ```

3. maven 选用编译项目的jdk版本

   ```xml
   <!--在profiles节点(标签)下添加jdk编译版本 268行附近-->
   <profile>
       <id>jdk-17</id>
       <activation>
         <activeByDefault>true</activeByDefault>
         <jdk>17</jdk>
       </activation>
       <properties>
         <maven.compiler.source>17</maven.compiler.source>
         <maven.compiler.target>17</maven.compiler.target>
         <maven.compiler.compilerVersion>17</maven.compiler.compilerVersion>
       </properties>
   </profile>
   ```



### 四、IDEA 配置本地 Maven 软件

我们需要将配置好的 maven 软件，配置到 idea 开发工具中即可！ 注意： idea 工具默认自带 maven 配置软件，但是因为没有修改配置，建议替换成本地配置好的 maven！

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251920244.png)



## 基于 IDEA 创建 Maven 工程

### 一、概念梳理Maven工程的GAVP

1. Maven 工程相对之前的项目，多出一组 gavp 属性，gav 需要我们在创建项目的时候指定，p 有默认值。
2. Maven 中的 GAVP 是指 GroupId、ArtifactId、Version、Packaging 等四个属性的缩写，其中前三个是必要的，而 Packaging 属性为可选项。
   - 这四个属性主要为每个项目在 maven 仓库中做一个标识，类似人的姓-名！有了具体标识，方便后期项目之间相互引用依赖等！
3. GAV 遵循以下规则：
   1. **GroupID 格式**：com.{公司/BU }.业务线.\[子业务线]，最多 4 级。
   2. **ArtifactID 格式**：产品线名-模块名。语义不重复不遗漏，先到仓库中心去查证一下。
   3. **Version版本号格式推荐**：主版本号.次版本号.修订号
      1. 主版本号：当做了不兼容的 API 修改，或者增加了能改变产品方向的新功能。
      2. 次版本号：当做了向下兼容的功能性新增（新增类、接口等）。
      3. 修订号：修复 bug，没有修改方法签名的功能加强，保持 API 兼容性。
4. **Packaging定义规则**：指示将项目打包为什么类型的文件，idea根据 packaging 值，识别 maven 项目类型。
   1. packaging 属性为 jar（默认值），代表普通的Java工程，打包以后是 `.jar` 结尾的文件。
   2. packaging 属性为 war，代表 Java 的 web 工程，打包以后 `.war` 结尾的文件。
   3. packaging 属性为 pom，代表不会打包，用来做继承的父工程。



### 二、Idea 构建 Maven Java SE 工程

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251845171.png)

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251845200.png)



### 三、Idea 构建 Maven Java Web 工程

1. 手动创建

   1. 创建一个 maven 的 javase 工程

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251908658.png)

   2. 修改 pom.xml 文件打包方式

      - ```xml
        <groupId>com.wang.maven</groupId>
        <artifactId>maven_web</artifactId>
        <version>1.0-SNAPSHOT</version>
        <!-- 新增一列打包方式packaging -->
        <packaging>war</packaging>
        ```

   3. 设置 **web资源路径** 和 **web.xml路径**

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251910390.png)

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251911704.png)

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251911942.png)

   4. 刷新和校验

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251912077.png)

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251912951.png)

2. 插件创建

   1. 安装插件 JBLJavaToWeb

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251918628.png)

   2. 创建一个 javase maven 工程

   3. 右键、使用插件快速补全web项目

      ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507251922796.png)



### 四、Maven 工程项目结构说明

*Maven 是一个强大的构建工具，它提供一种标准化的项目结构*

以下是 Maven Web 程序的文件结构及每个文件的作用：

```xml
|-- pom.xml                               # Maven 项目管理文件 
|-- src
    |-- main                              # 项目主要代码
    |   |-- java                          # Java 源代码目录
    |   |   `-- com/example/myapp         # 开发者代码主目录
    |   |       |-- controller            # 存放 Controller 层代码的目录
    |   |       |-- service               # 存放 Service 层代码的目录
    |   |       |-- dao                   # 存放 DAO 层代码的目录
    |   |       `-- model                 # 存放数据模型的目录
    |   |-- resources                     # 资源目录，存放配置文件、静态资源等
    |   |   |-- log4j.properties          # 日志配置文件
    |   |   |-- spring-mybatis.xml        # Spring Mybatis 配置文件
    |   |   `-- static                    # 存放静态资源的目录
    |   |       |-- css                   # 存放 CSS 文件的目录
    |   |       |-- js                    # 存放 JavaScript 文件的目录
    |   |       `-- images                # 存放图片资源的目录
    |   `-- webapp                        # 存放 WEB 相关配置和资源
    |       |-- WEB-INF                   # 存放 WEB 应用配置文件
    |       |   |-- web.xml               # Web 应用的部署描述文件
    |       |   `-- classes               # 存放编译后的 class 文件
    |       `-- index.html                # Web 应用入口页面
    `-- test                              # 项目测试代码
        |-- java                          # 单元测试目录
        `-- resources                     # 测试资源目录
```







## 基于 IDEA 进行 Maven 工程构建

### 一、构建概念和构建过程

*项目构建是指将源代码、依赖库和资源文件等转换成可执行或可部署的应用程序的过程，在这个过程中包括编译源代码、链接依赖库、打包和部署等多个步骤。*常见的构建工具包括 Maven、Gradle、Ant 等。

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507260950910.png)



### 二、命令方式项目构建

| 命令        | 描述                        |
| ----------- | --------------------------- |
| mvn compile | 编译项目，生成 target 文件  |
| mvn package | 打包项目，生成jar或war文件  |
| mvn clean   | 清理编译或打包后的项目结构  |
| mvn install | 打包后上传到maven本地仓库   |
| mvn deploy  | 只打包，上传到maven私服仓库 |
| mvn site    | 生成站点                    |
| mvn test    | 执行测试源码                |

- 命名规范：（必须这样命名，否则无法识别为测试类 or 测试方法）

  - 测试类的类名命名为 `XxxTest`
  - 测试类中的测试方法名命名为 `testXxx`

- war 包打包插件和 jdk 版本不匹配：pom.xml 添加以下代码即可

  ```xml
  <build>
      <!-- jdk17 和 war包版本插件不匹配 -->
      <plugins>
          <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-war-plugin</artifactId>
              <version>3.2.2</version>
          </plugin>
      </plugins>
  </build>
  ```



### 三、可视化方式项目构建

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507261011020.png)

注意：打包（package）和安装（install）的区别：

- 打包是将工程打成 jar 或 war 文件，保存在 target 目录下
- 安装是将当前工程所生成的 jar 或 war 文件，安装到本地仓库，会按照坐标保存到指定位置



### 四、构建插件、命令、生命周期命令之间关系

- **构建生命周期**

  - 构建生命周期可以理解成是一组固定构建命令的有序集合，**触发周期后的命令，会自动触发周期前的命令**。

- 默认周期：定义了真正构件时所需要执行的所有步骤，它是生命周期中最核心的部分

  ```
  包含命令：compile -  test - package - install - deploy
  ```

- **插件、命令、周期三者关系**

  - 周期 → 包含若干命令 → 包含若干插件
  - 使用周期命令构建，简化构建过程！
  - 最终进行构建的是插件！



## 基于 IDEA 进行 Maven 依赖管理

### 一、依赖管理概念

通过定义 POM 文件，Maven 能够自动解析项目的依赖关系，并通过 Maven **仓库自动**下载和管理依赖，从而避免了手动下载和管理依赖的繁琐工作和可能引发的版本冲突问题。



### 二、Maven工程核心信息配置和解读（GAVP）

位置：pom.xml

```xml
<!-- 模型版本 -->
<modelVersion>4.0.0</modelVersion>
<!-- 公司或者组织的唯一标志，并且配置时生成的路径也是由此生成， 如com.companyname.project-group，maven会将该项目打成的jar包放本地路径：/com/companyname/project-group -->
<groupId>com.companyname.project-group</groupId>
<!-- 项目的唯一ID，一个groupId下面可能多个项目，就是靠artifactId来区分的 -->
<artifactId>project</artifactId>
<!-- 版本号 -->
<version>1.0.0</version>

<!--打包方式
    默认：jar
    jar指的是普通的java项目打包方式！ 项目打成jar包！
    war指的是web项目打包方式！项目打成war包！
    pom不会讲项目打包！这个项目作为父工程，被其他工程聚合或者继承！后面会讲解两个概念
-->
<packaging>jar/pom/war</packaging>
```



### 三、Maven工程依赖管理配置

位置：pom.xml

依赖管理和依赖添加

```xml
<!-- 
   通过编写依赖jar包的gav必要属性，引入第三方依赖！
   scope属性是可选的，可以指定依赖生效范围！
   依赖信息查询方式：
      1. maven仓库信息官网 https://mvnrepository.com/
      2. mavensearch插件搜索
 -->
<dependencies>
    <!-- 引入具体的依赖包 -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
        <!-- 依赖范围 -->
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

依赖版本统一提取和维护

```xml
<!--声明版本-->
<properties>
  <!--命名随便,内部制定版本号即可！-->
  <junit.version>5.11.4</junit.version>
  <!-- 也可以通过 maven规定的固定的key，配置maven的参数！如下配置编码格式！-->
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>

<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <!--引用properties声明版本 -->
    <version>${junit.version}</version>
  </dependency>
</dependencies>
```



### 四、依赖范围

通过设置坐标的依赖范围（scope），可以设置对应 jar 包的作用范围：编译环境、测试环境、运行环境

| 依赖范围     | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| **compile**  | 编译依赖范围，scope 元素的缺省值。使用此依赖范围的 Maven 依赖，对于三种 classpath 均有效，即该 Maven 依赖在上述三种 classpath 均会被引入。例如，log4j 在编译、测试、运行过程都是必须的。 |
| **test**     | 测试依赖范围。使用此依赖范围的 Maven 依赖，只对测试 classpath 有效。例如，Junit 依赖只有在测试阶段才需要。 |
| **provided** | 已提供依赖范围。使用此依赖范围的 Maven 依赖，只对编译 classpath 和测试 classpath 有效。例如，servlet-api 依赖对于编译、测试阶段而言是需要的，但是运行阶段，由于外部容器已经提供，故不需要 Maven 重复引入该依赖。 |
| runtime      | 运行时依赖范围。使用此依赖范围的 Maven 依赖，只对测试 classpath、运行 classpath 有效。例如，JDBC 驱动实现依赖，其在编译时只需 JDK 提供的 JDBC 接口即可，只有测试、运行阶段才需要实现了 JDBC 接口的驱动。 |
| system       | 系统依赖范围，其效果与 provided 的依赖范围一致。其用于添加非 Maven 仓库的本地依赖，通过依赖元素 dependency 中的 systemPath 元素指定本地依赖的路径。鉴于使用其会导致项目的可移植性降低，一般不推荐使用。 |
| import       | 导入依赖范围，该依赖范围只能与 dependencyManagement 元素配合使用，其功能是将目标 pom.xml 文件中 dependencyManagement 的配置导入合并到当前 pom.xml 的 dependencyManagement 中。 |



### 五、Maven 工程依赖下载失败错误解决

在使用 Maven 构建项目时，可能会发生依赖项下载错误的情况，主要原因有以下几种：

1. 下载依赖时出现网络故障或仓库服务器宕机等原因，导致无法连接至 Maven 仓库，从而无法下载依赖。
2. 依赖项的版本号或配置文件中的版本号错误，或者依赖项没有正确定义，导致 Maven 下载的依赖项与实际需要的不一致，从而引发错误。
3. 本地 Maven 仓库或缓存被污染或损坏，导致 Maven 无法正确地使用现有的依赖项。

解决方案：

1. 检查网络连接和 Maven 仓库服务器状态。

2. 确保依赖项的版本号与项目对应的版本号匹配，并检查 POM 文件中的依赖项是否正确。

3. 清除本地 Maven 仓库缓存（`.lastUpdated` 文件），因为只要存在lastupdated 缓存文件，刷新也不会重新下载。本地仓库中，根据依赖的gav属性依次向下查找文件夹，最终删除内部的文件，刷新重新下载即可！

4. 或者可以将清除 **lastUpdated 文件**的操作写在一个脚本文件中，手动创建文件"clearLastUpdated.bat"，名字任意，但是后缀必须是bat，将以下内容复制到文件中

   ```bat
   cls 
   @ECHO OFF 
   SET CLEAR_PATH=D: 
   SET CLEAR_DIR=D:\maven-repository(本地仓库路径)
   color 0a 
   TITLE ClearLastUpdated For Windows 
   GOTO MENU 
   :MENU 
   CLS
   ECHO. 
   ECHO. * * * *  ClearLastUpdated For Windows  * * * * 
   ECHO. * * 
   ECHO. * 1 清理*.lastUpdated * 
   ECHO. * * 
   ECHO. * 2 查看*.lastUpdated * 
   ECHO. * * 
   ECHO. * 3 退 出 * 
   ECHO. * * 
   ECHO. * * * * * * * * * * * * * * * * * * * * * * * * 
   ECHO. 
   ECHO.请输入选择项目的序号： 
   set /p ID= 
   IF "%id%"=="1" GOTO cmd1 
   IF "%id%"=="2" GOTO cmd2 
   IF "%id%"=="3" EXIT 
   PAUSE 
   :cmd1 
   ECHO. 开始清理
   %CLEAR_PATH%
   cd %CLEAR_DIR%
   for /r %%i in (*.lastUpdated) do del %%i
   ECHO.OK 
   PAUSE 
   GOTO MENU 
   :cmd2 
   ECHO. 查看*.lastUpdated文件
   %CLEAR_PATH%
   cd %CLEAR_DIR%
   for /r %%i in (*.lastUpdated) do echo %%i
   ECHO.OK 
   PAUSE 
   GOTO MENU 
   ```



### 六、Maven工程Build构建配置

项目构建是指将源代码、依赖库和资源文件等转换成可执行或可部署的应用程序的过程，在这个过程中包括编译源代码、链接依赖库、打包和部署等多个步骤。

默认情况下，构建不需要额外配置，都有对应的缺省配置。

也可以在pom.xml定制一些配置，来修改默认构建的行为和产物。

1. 指定构建打包文件的名称，非默认名称
2. 制定构建打包时，指定包含文件格式和排除文件
3. 打包插件版本过低，配置更高版本插件

构建配置是在 **pom.xml / build** 标签中指定！

**指定打包命名**

```xml
<!-- 默认的打包名称：artifactid+verson.打包方式 -->
<build>
  <finalName>定义打包名称</finalName>
</build>  
```

**指定打包文件**

1. 默认情况下，按照 maven 工程结构放置的文件会默认被编译和打包！

   - 如果在 java 文件夹中添加 java 类，会自动打包编译到 classes 文件夹下。

   - 但是在 java 文件夹中添加 xml 文件，默认不会被打包。

2. 除此之外，我们可以使用 resources 标签，指定要打包资源的文件夹要把哪些静态资源打包到 classes 根目录下！

   - 应用场景：mybatis 中有时会将用于编写 SQL 语句的映射文件和 mapper 接口都写在 src/main/java 下的某个包中，此时映射文件就不会被打包，如何解决

     ```xml
     <build>
         <!--设置要打包的资源位置-->
         <resources>
             <resource>
                 <!--设置资源所在目录-->
                 <directory>src/main/java</directory>
                 <includes>
                     <!--设置包含的资源类型-->
                     <include>**/*.xml</include>
                 </includes>
             </resource>
         </resources>
     </build>
     ```

**配置依赖插件**

dependencies 标签下引入开发需要的 jar 包！我们可以在 build/plugins/plugin 标签引入插件！

常用的插件：修改jdk版本、tomcat插件、mybatis分页插件、mybatis逆向工程插件等等！

```xml
<build>
  <plugins>
      <!-- java编译插件，配jdk的编译版本 -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
          <encoding>UTF-8</encoding>
        </configuration>
      </plugin>
      <!-- tomcat插件 -->
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
         <version>2.2</version>
          <configuration>
          <port>8090</port>
          <path>/</path>
          <uriEncoding>UTF-8</uriEncoding>
          <server>tomcat7</server>
        </configuration>
      </plugin>
    </plugins>
</build>
```







## Maven 依赖传递和依赖冲突

### 一、Maven 依赖传递特性

**概念**

假如有 Maven 项目A，项目B依赖A，项目C依赖B。那么我们可以说C依赖A。也就是说，依赖的关系为：C —> B —> A， 那么我们执行项目C时，会自动把B、A都下载导入到C项目的 jar 包文件夹中，这就是依赖的传递性。

**作用**

-   简化依赖导入过程
-   确保依赖版本正确

**传递的原则**

在 A 依赖 B，B 依赖 C 的前提下，C 是否能够传递到 A，取决于 B 依赖 C 时使用的依赖范围以及配置

- B 依赖 C 时使用 compile 范围：可以传递

- B 依赖 C 时使用 test 或 provided 范围：不能传递，所以需要这样的 jar 包时，就必须在需要的地方明确配置依赖才可以。

- B 依赖 C 时，若配置了以下标签，则不能传递

  ```xml
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.2.15</version>
      <optional>true</optional> // 使用了这个标签之后不能传递
  </dependency>
  ```

**依赖传递终止**

-   非 compile 范围进行依赖传递
-   使用 optional 配置终止传递
-   依赖冲突（传递的依赖已经存在）

**案例：导入jackson依赖**

分析：jackson需要三个依赖

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262050530.png)

依赖传递关系：data-bind 中，依赖其他两个依赖

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262051856.png)

最佳导入：直接可以导入data-bind，自动依赖传递需要的依赖

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.2</version>
</dependency>
```



### 二、Maven依赖冲突特性

当直接引用或者间接引用出现了相同的jar包! 这时呢，一个项目就会出现相同的重复 jar 包，这就算作冲突！依赖冲突避免出现重复依赖，并且终止依赖传递！

maven自动解决依赖冲突问题能力，会按照自己的原则，进行重复依赖选择。同时也提供了手动解决的冲突的方式，不过不推荐！

**解决依赖冲突（如何选择重复依赖）方式**：

1. 自动选择原则

   - 短路优先原则（第一原则）

     A—>B—>C—>D—>E—>X(version 0.0.1)

     A—>F—>X(version 0.0.2)

     则A依赖于X(version 0.0.2)。

   - 依赖路径长度相同情况下，则“先声明优先”（第二原则）

     A—>E—>X(version 0.0.1)

     A—>F—>X(version 0.0.2)

     在\<depencies>\</depencies>中，先声明的，路径相同，会优先选择！

2. 手动排除

   ```xml
   <dependency>
     <groupId>com.wang.maven</groupId>
     <artifactId>maven_B</artifactId>
     <version>1.0-SNAPSHOT</version>
     <!-- 使用excludes标签配置依赖的排除  -->
     <exclusions>
       <!-- 在exclude标签中配置一个具体的排除 -->
       <exclusion>
         <!-- 指定要排除的依赖的坐标（不需要写version） -->
         <groupId>com.alibaba</groupId>
         <artifactId>druid</artifactId>
       </exclusion>
     </exclusions>
   </dependency>
   ```







## Maven 工程继承和聚合关系

### 一、Maven 工程继承关系

1. 继承概念

   Maven 继承是指在 Maven 的项目中，让一个项目从另一个项目中**继承配置信息**的机制。继承可以让我们在多个项目中共享同一配置信息，简化项目的管理和维护工作。

2. 继承作用

   在父工程中统一管理项目中的依赖信息。

   它的背景是：

   -   对一个比较大型的项目进行了模块拆分。
   -   一个 project 下面，创建了很多个 module。
   -   每一个 module 都需要配置自己的依赖信息。

3. 继承语法

   - 父工程

     ```xml
       <groupId>com.wang.maven</groupId>
       <artifactId>pro03-maven-parent</artifactId>
       <version>1.0-SNAPSHOT</version>
       <!-- 当前工程作为父工程，它要去管理子工程，所以打包方式必须是 pom -->
       <packaging>pom</packaging>
     ```

   - 子工程

     ```xml
     <!-- 使用parent标签指定当前工程的父工程 -->
     <parent>
       <!-- 父工程的坐标 -->
       <groupId>com.atguigu.maven</groupId>
       <artifactId>pro03-maven-parent</artifactId>
       <version>1.0-SNAPSHOT</version>
     </parent>
     
     <!-- 子工程的坐标 -->
     <!-- 如果子工程坐标中的groupId和version与父工程一致，那么可以省略（是一致的） -->
     <!-- <groupId>com.atguigu.maven</groupId> -->
     <artifactId>pro04-maven-module</artifactId>
     <!-- <version>1.0-SNAPSHOT</version> -->
     ```

4. 父工程依赖统一管理

   - 父工程声明版本

     ```xml
     <!-- 使用 dependencyManagement 标签配置对依赖的管理 -->
     <!-- 被管理的依赖并没有真正被引入到工程 -->
     <dependencyManagement>
       <dependencies>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-core</artifactId>
           <version>6.0.10</version>
         </dependency>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-beans</artifactId>
           <version>6.0.10</version>
         </dependency>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-context</artifactId>
           <version>6.0.10</version>
         </dependency>
       </dependencies>
     </dependencyManagement>
     ```

   - 子工程引用版本

     ```xml
     <!-- 子工程引用父工程中的依赖信息时，可以把版本号去掉。  -->
     <!-- 把版本号去掉就表示子工程中这个依赖的版本由父工程决定。 -->
     <!-- 具体来说是由父工程的 dependencyManagement 来决定。 -->
     <dependencies>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-core</artifactId>
       </dependency>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-beans</artifactId>
       </dependency>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-context</artifactId>
       </dependency>
     </dependencies>
     ```



### 二、Maven 工程聚合关系

1. 聚合概念

   Maven 聚合是指将多个项目组织到一个父级项目中，以便一起构建和管理的机制。聚合可以帮助我们更好地管理一组相关的子项目，同时简化它们的构建和部署过程。

2. 聚合作用

   1.  管理多个子项目：通过聚合，可以将多个子项目组织在一起，方便管理和维护。
   2.  构建和发布一组相关的项目：通过聚合，可以在一个命令中构建和发布多个相关的项目，简化了部署和维护工作。
   3.  优化构建顺序：通过聚合，可以对多个项目进行顺序控制，避免出现构建依赖混乱导致构建失败的情况。
   4.  统一管理依赖项：通过聚合，可以在父项目中管理公共依赖项和插件，避免重复定义。

3. 聚合语法

   父项目中包含的子项目列表。

   ```xml
   <project>
     <groupId>com.example</groupId>
     <artifactId>parent-project</artifactId>
     <packaging>pom</packaging>
     <version>1.0.0</version>
     <modules>
       <module>child-project1</module>
       <module>child-project2</module>
     </modules>
   </project>
   ```







## Maven 私服

### 一、Maven 私服简介

Maven 私服是一种特殊的Maven远程仓库，它是架设在局域网内的仓库服务，用来代理位于外部的远程仓库（中央仓库、其他远程公共仓库）。

建立了 Maven 私服后，当局域网内的用户需要某个构件时，会按照如下顺序进行请求和下载。

1. 请求本地仓库，若本地仓库不存在所需构件，则跳转到第 2 步；

2. 请求 Maven 私服，将所需构件下载到本地仓库，若私服中不存在所需构件，则跳转到第 3 步。

3. 请求外部的远程仓库，将所需构件下载并缓存到 Maven 私服，若外部远程仓库不存在所需构件，则 Maven 直接报错。

4. 此外，一些无法从外部仓库下载到的构件，也能从本地上传到私服供其他人使用。

   ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262157629.png)

**常见的 Maven 私服产品**

1. Apache 的 Archiva
2. JFrog 的 Artifactory
3. Sonatype 的 Nexus（[ˈneksəs]）（当前最流行、使用最广泛）



### 二、Nexus 下载安装

下载地址：https://help.sonatype.com/repomanager3/product-information/download

解压，以管理员身份打开 CMD，进入 bin 目录下，执行 `nexus.exe/run` 命令启动

访问 Nexus 首页

首页地址：http://localhost:8081/，8081为默认端口号



### 三、初始设置

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262244977.png)

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262245380.png)

这里参考提示：

- 用户名：admin
- 密码：查看 **D:\develop\nexus-3.61.0-02-win64\sonatype-work\nexus3\admin.password** 文件

继续执行初始化：

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262246232.png)

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262246358.png)

密码修改后为 `admin`

匿名登录，启用还是禁用？由于启用匿名登录后，后续操作比较简单，这里我们演示禁用匿名登录的操作：

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262247930.png)

初始化完毕

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262248107.png)



### 四、Nexus 上的各种仓库

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262248600.png)

| 仓库类型 | 说明                                           |
| -------- | ---------------------------------------------- |
| proxy    | 某个远程仓库的代理                             |
| group    | 存放：通过 Nexus 获取的第三方 jar 包           |
| hosted   | 存放：本团队其他开发人员部署到 Nexus 的 jar 包 |

| 仓库名称        | 说明                                                         |
| --------------- | ------------------------------------------------------------ |
| maven-central   | Nexus 对 Maven 中央仓库的代理                                |
| maven-public    | Nexus 默认创建，供开发人员下载使用的组仓库                   |
| maven-releases  | Nexus 默认创建，供开发人员部署自己 jar 包的宿主仓库 要求 releases 版本 |
| maven-snapshots | Nexus 默认创建，供开发人员部署自己 jar 包的宿主仓库 要求 snapshots 版本 |

初始状态下，这几个仓库都没有内容：

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262249095.png)



### 五、通过 Nexus 下载 jar 包

修改本地maven的核心配置文件settings.xml，设置新的本地仓库地址

```xml
<!-- 配置一个新的 Maven 本地仓库 -->
<localRepository>D:/maven-repository-new</localRepository>
```

把我们原来配置阿里云仓库地址的 mirror 标签改成下面这样：

```xml
<mirror>
	<id>nexus-mine</id>
	<mirrorOf>central</mirrorOf>
	<name>Nexus mine</name>
	<url>http://localhost:8081/repository/maven-public/</url>
</mirror>
```

这里的 url 标签是这么来的：

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262250382.png)

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262250516.png)

把上图中看到的地址复制出来即可。如果我们在前面允许了匿名访问，到这里就够了。但如果我们禁用了匿名访问，那么接下来我们还要继续配置 settings.xml：

```xml
<server>
  <id>nexus-mine</id>
  <username>admin</username>
  <password>admin</password>
</server>
```

这里需要**格外注意**：server 标签内的 id 标签值必须和 mirror 标签中的 id 值一样。

找一个用到框架的 Maven 工程，执行命令：

```sh
mvn clean compile
```

下载过程日志......

下载后，Nexus 服务器上就有了 jar 包：eg如下图

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262252221.png)

若下载速度太慢，可以设置私服中中央仓库的地址为阿里云仓库地址

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262253191.png)

修改为：http://maven.aliyun.com/nexus/content/groups/public/

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262253229.png)



### 六、将 jar 包部署到 Nexus

maven 工程中配置：

```xml
<distributionManagement>
    <snapshotRepository>
        <id>nexus-mine</id>
        <name>Nexus Snapshot</name>
        <url>http://localhost:8081/repository/maven-snapshots/</url>
    </snapshotRepository>
</distributionManagement>
```

注意：这里 snapshotRepository 的 id 标签必须和 settings.xml 中指定的 mirror 标签的 id 属性一致。

执行部署命令：

```sh
mvn deploy
```

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262255773.png)



### 七、引用别人部署的 jar 包

maven工程中配置：

```xml
<repositories>
    <repository>
        <id>nexus-mine</id>
        <name>nexus-mine</name>
        <url>http://localhost:8081/repository/maven-snapshots/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>true</enabled>
        </releases>
    </repository>
</repositories>
```







## Maven 综合案例

### 一、项目需求和结构分析

![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262259772.png)

需求案例：搭建一个电商平台项目，该平台包括用户服务、订单服务、通用工具模块等。

项目架构：

1. 用户服务：负责处理用户相关的逻辑，例如用户信息的管理、用户注册、登录等。
   - spring-context
   - spring-core
   - spring-beans
   - common-service
2. 订单服务：负责处理订单相关的逻辑，例如订单的创建、订单支付、退货、订单查看等。
   - spring-context
   - spring-core
   - spring-beans
   - spring-security
   - common-service
3. 通用模块：负责存储其他服务需要通用工具类，其他服务依赖此模块。
   - commons-io
   - junit



### 二、项目搭建和统一构建

#### 父模块 (micro-shop)

1. 创建工程

2. pom.xml配置：

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
   
       <groupId>com.atguigu</groupId>
       <artifactId>micro-shop</artifactId>
       <version>1.0-SNAPSHOT</version>
       <!--知识点：父工程的打包方式为pom-->
       <packaging>pom</packaging>
   
       <properties>
           <spring.version>6.0.6</spring.version>
           <jackson.version>2.15.0</jackson.version>
           <commons.version>2.11.0</commons.version>
           <junit.version>5.9.2</junit.version>
           <maven.compiler.source>17</maven.compiler.source>
           <maven.compiler.target>17</maven.compiler.target>
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       </properties>
   
       <!-- 依赖管理 -->
       <dependencyManagement>
           <dependencies>
               <!-- spring-context会依赖传递core/beans -->
               <dependency>
                   <groupId>org.springframework</groupId>
                   <artifactId>spring-context</artifactId>
                   <version>${spring.version}</version>
               </dependency>
   
               <!-- jackson-databind会依赖传递core/annotations -->
               <dependency>
                   <groupId>com.fasterxml.jackson.core</groupId>
                   <artifactId>jackson-databind</artifactId>
                   <version>${jackson.version}</version>
               </dependency>
   
               <!-- commons-io -->
               <dependency>
                   <groupId>commons-io</groupId>
                   <artifactId>commons-io</artifactId>
                   <version>${commons.version}</version>
               </dependency>
   
               <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
               <dependency>
                   <groupId>org.junit.jupiter</groupId>
                   <artifactId>junit-jupiter-api</artifactId>
                   <version>${junit.version}</version>
                   <scope>test</scope>
               </dependency>
   
           </dependencies>
       </dependencyManagement>
   
       <!-- 统一更新子工程打包插件-->
       <build>
           <!-- jdk17 和 war包版本插件不匹配 -->
           <plugins>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-war-plugin</artifactId>
                   <version>3.2.2</version>
               </plugin>
           </plugins>
       </build>
   
   </project>
   ```

3. 可选操作：删除 src 目录



#### 通用模块 (common-service)

1. 创建工程

2. pom.xml配置：

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <artifactId>micro-shop</artifactId>
           <groupId>com.atguigu</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>
   
       <artifactId>common-service</artifactId>
       <!--知识点：打包方式默认就是jar，因此可以省略-->
       <packaging>jar</packaging>
   
       <properties>
           <maven.compiler.source>17</maven.compiler.source>
           <maven.compiler.target>17</maven.compiler.target>
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       </properties>
   
       <dependencies>
           <!-- 配置spring-context，继承父工程版本，自动传递 core / beans -->
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-context</artifactId>
           </dependency>
           <!-- 配置jackson-databind，继承父工程版本，自动传递 core / annotations -->
           <dependency>
               <groupId>com.fasterxml.jackson.core</groupId>
               <artifactId>jackson-databind</artifactId>
           </dependency>
           <!-- 配置commons-io，继承父工程版本 -->
           <dependency>
               <groupId>commons-io</groupId>
               <artifactId>commons-io</artifactId>
           </dependency>
           <!-- 配置junit，继承父工程版本 -->
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter-api</artifactId>
               <scope>test</scope>
           </dependency>
       </dependencies>
   
   </project>
   ```



#### 用户模块 (user-service)

1. 创建工程

   ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262323645.png)

2. pom.xml配置：

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <artifactId>micro-shop</artifactId>
           <groupId>com.atguigu</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>
   
       <artifactId>user-service</artifactId>
       <!-- web工程打包方式为war -->
       <packaging>war</packaging>
   
       <properties>
           <maven.compiler.source>17</maven.compiler.source>
           <maven.compiler.target>17</maven.compiler.target>
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       </properties>
   
       <dependencies>
           <!-- 配置common-service，所需依赖会传递到当前工程（仅限compile范围） -->
           <dependency>
               <groupId>com.atguigu</groupId>
               <artifactId>common-service</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
       </dependencies>
   
   </project>
   ```

3. 依赖传递结果：

   ![](https://gitee.com/the-sherry/picture/raw/master/typora/202507262324496.png)



#### 订单模块 (order-service)

1. 创建工程，并使用插件转为web工程

2. pom.xml配置：

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <artifactId>micro-shop</artifactId>
           <groupId>com.atguigu</groupId>
           <version>1.0-SNAPSHOT</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>
   
       <artifactId>order-service</artifactId>
       <!-- web工程打包方式为war -->
       <packaging>war</packaging>
   
       <properties>
           <maven.compiler.source>17</maven.compiler.source>
           <maven.compiler.target>17</maven.compiler.target>
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       </properties>
   
       <dependencies>
           <!-- 配置common-service，所需依赖会传递到当前工程（仅限compile范围） -->
           <dependency>
               <groupId>com.atguigu</groupId>
               <artifactId>common-service</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
       </dependencies>
   
   </project>
   ```

3. 此时，查看父工程的 pom.xml，会发现其中已经自动聚合了子工程：

   ```xml
   <modules>
       <module>common-service</module>
       <module>user-service</module>
       <module>order-service</module>
   </modules>
   ```

