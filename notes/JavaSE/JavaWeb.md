# JavaWeb



## HTML

*用于搭建基础网页，展示页面内容*



### 语法

- 在开始标签中可以定义属性。属性是由键值对构成，值需要用引号（单双都可）引起来。
- html不区分大小写。



### 标签

#### 文件标签

- html：html的根标签
- head：头标签。用于指定 html 文档的一些属性。引入外部资源
- title：标题标签
- body：体标签
- `<!DOCTYPE html>` ：html5 中定义该文档是 html 文档

#### 文本标签

- 注释：`<!-- 注释内容-->`
- `<h1>` to `<h6>`：标题标签，字体逐渐减小
- `<p>`：段落标签
- `<br>`
- `<hr>`
  - 属性：
    - color：颜色
    - width：宽度
    - size：高度
    - align：对齐方式
      - center：居中
      - left：左对齐
      - right：右对齐
- `<b>`
- `<i>`
- `<font>`：字体标签
- `<center>`
  - 属性：
    - color
    - size
    - face：字体

#### 图片标签

- `<img>`：
  - 属性：
    - src：
      - 路径：
        - 相对路径：
          - `./`：代表当前目录
          - `../`：代表上一级目录
        - 绝对路径

#### 列表标签

- 有序列表：
  - `<ol>`
    - 属性：
      - type
      - start
  - `<li>`
- 无序列表
  - `<ul>`（属性 type）
  - `<li>`

#### 链接标签

- `<a>`
  - 属性：
    - href：指定访问资源的URL
      - "mailto:邮箱"
    - target：指定打开资源的方式
      - _self：默认值，在当前页面打开
      - _blank：在空白页面打开

#### 其他标签

- `<div>`：每个 div 沾满一整行。块级标签
- `<span>`：文本信息在一行展示，行内标签 内联标签

#### 语义化标签

- `<header>`
- `<footer>`

#### 表格标签

- `<table>`：定义表格
  - width
  - border：边框
  - cellpadding：定义内容和单元格的距离
  - cellspacing：定义单元格之间的距离。如果指定为0，则单元格的线会合为一条
  - bgcolor：背景色
  - align：对齐方式
- `<tr>`：定义行
  - bgcolor：背景色
  - align：对齐方式
- `<td>`：定义单元格
  - colspan：合并列
  - rowspan：合并行
- `<th>`：定义表头单元格
- `<caption>`：表格标题
- `<thead>`：表示表格的头部分
- `<tbody>`：表示表格的体部分
- `<tfoot>`：表示表格的脚部分

#### 表单标签

- `<form>`：用于定义表单的。可以定义一个范围，范围代表采集用户数据的范围
  - 属性：
    - action：指定提交数据的URL
    - method：指定提交方式
      - **get**：
        - 请求参数会在地址栏中显示。会封装到请求行中
        - 请求参数大小是有限制的
        - 不太安全
      - **post**
        - 请求参数不会在地址栏中显示。会封装到请求体中
        - 请求参数的大小没有限制
        - 较为安全
  - 表单项中的数据想要被提交，必须指定其 name 属性
- 表单项标签：
  - `<input>`：可以通过type属性值，改变元素展示的样式
    - type：
      - text（默认值）：文本输入框
        - placeholder：指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息

      - password：密码输入框
      - radio：单选框
        - **注意**
          1. 要让多个单选框实现单选的效果，则多个单选框的 name 属性值必须一样
          2. 一般会给每一个单选框提供 value 属性，指定其被选中后提交的值
          3. checked 属性，可以指定默认值

      - checkbox：复选框、
        - **注意**
          1. 一般会给每一个多选框提供 value 属性，指定其被选中后提交的值
          2. checked 属性，可以指定默认值

      - file：文件选择框
      - hidden：隐藏域，用于提交一些信息
      - 按钮：
        - submit：提交按钮。可以提交表单
        - button：普通按钮
        - image：图片提交按钮
          - src 属性指定图片的路径

      - 其他：
        - color：取色器
        - date：日期
        - datetime-local：日期+时间
        - email
        - number
        - gender
        - tel：手机号

    - `<label>`：指定输入项的文字描述信息
      - **注意**
        - label 的 for 属性一般会和 input 的 id 属性值对应。一旦对应了，则点击 label 区域，会让 input 输入框获取焦点。

  - `<select>`：下拉列表
    - 子元素：option，指定列表项

  - `<textarea>`：文本域
    - cols：指定列数，每一行有多少个字符
    - rows：默认多少行




### 属性定义

- color：
  - 英文单词
  - rgb(值1, 值2, 值3)：值的范围 0 ~ 255，如 rgb(0, 0, 255)
  - #值1值2值3：值的范围：00 ~ FF，如 #FF00FF
- width：
  - 数值：width="20"，数值单位默认是 px（像素）
  - 百分比



### 特殊字符

- 空格：  `&nbsp;`
- 版权字符：&copy; `&copy;`



### 示例

如果某一行只有一个单元格

```html
<tr><td></td></tr>
```

如果某一行有多个单元格（不需要考虑合并单元格了）

```html
<tr><td><table></table></td></tr>
```





## CSS

*用于美化页面，布局页面*



### 3种使用方式

1. 内联样式：

   - 在标签内使用style属性指定css代码

   - eg：`<div style="color:red;">hello css</div>`

2. 内部样式：

   - 在 head 标签内，定义style标签

3. 外部样式：

   - 在head标签内，定义link标签，引入外部的资源文件

     `<link rel="stylesheet" href="css/a.css">`

     或者

     `<style>@import "css/a.css";</style>`



### 语法

选择器{

​		属性名1:属性值1;

​		属性名2:属性值2;

​		···

}



### 选择器

1. 基础选择器

   - id 选择器：建议在一个 html 页面中 id 值唯一。**#id属性值{}**
   - 元素选择器：**标签名称{}**
   - 类选择器：**.class属性值{}**

   *优先级*：id选择器 > 类选择器 > 元素选择器

2. 扩展选择器：

   - 选择所有元素：*{}
   - 并集选择器：选择器1,选择器2{}

   - 子选择器：筛选选择器1元素下的选择器2元素
     - 选择器1 选择器2{}
   - 父选择器：筛选选择器2的父元素选择器1
     - 选择器1 > 选择器2{}
   - 属性选择器：元素名称[属性名="属性值"]{}
   - 伪类选择器：元素:状态{}
     - 如：`<a>`
       - 状态：
         - link：初始化的状态
         - visited：被访问过的状态
         - active：正在访问状态
         - hover：鼠标悬浮状态



### 属性

1. 字体、文本：
   - font-size
   - color
   - text-align：对齐方式
   - line-height：行高
2. 背景：
   - background
3. 边框：
   - border
4. 尺寸：
   - width
   - height
5. 盒子模型：控制布局
   - margin：外边距
   - padding：内边距
   - float：浮动
     - left
     - right





## JavaScript

ECMAScript + BOM + DOM

*控制页面的元素，让页面有一些**动态**的效果*

*客户端脚本语言*

- 脚本语言：不需要编译，直接就可以被浏览器解析执行了



### 2种使用方式

1. 内部JS
2. 外部JS：通过 src 属性引入外部的 js 文件



### 语法

1. 注释：
   - 单行注释：// 注释内容
   - 多行注释：/* 注释内容 */

2. 数据类型：
   - number：整数、小数、NaN（not a number 一个不是数字的数字类型）
   - string
   - boolean
   - null
   - undefined
   - object

3. 变量：
   - *JavaScript是弱类型语言*
     - 强类型：在开辟变量存储空间时，定义了空间将来存储的数据的数据类型。只能存储固定类型的数据
     - 弱类型：在开辟变量存储空间时，不定义空间将来的存储数据类型，可以存放任意类型的数据。
   - var 变量名 = 初始化值
   - typeof 运算符：获取变量的类型
     - 注：**null 运算得到的是 object**

4. 运算符：

   - 运算符的比较：

     - 类型相同，直接比较

     - 类型不同，先进行类型转换，再比较
       - ===：全等于。在比较之前，先判断类型，如果类型不一样，直接返回 false

   - 类型转换：

     - 其他类型转 number
     - 其他类型转 boolean：
       - number ：0 或 NaN 为 false，其他为 true
       - string：除了空字符串 ""，其他都为 true
       - null & undefined：都是 false
       - 对象：所有对象都为 true

5. 流程控制语句：

   - switch：在 JS 中，switch 语句可以接受任意的原始数据类型



### 基本对象

1. Function
   1. 创建：
      - function 方法名称 () {}
      - var 方法名 = function () {}
   2. 特点：
      - 方法定义时，形参的类型不用写,返回值类型也不写。
      - 方法是一个对象，如果定义名称相同的方法，会覆盖
      - 在JS中，方法的调用只与方法的名称有关，和参数列表无关
      - 在方法声明中有一个隐藏的内置对象（数组）arguments，封装所有的实际参数
2. Array
   1. 创建：
      - var arr = new Array(元素列表);
      - var arr = new Array(默认长度);
      - var arr = [元素列表];
   2. 方法：
      - join(参数)：将数组中的元素按照指定的分隔符拼接为字符串
      - push()：向数组的末尾添加一个或更多元素，并返回新的长度。
3. Date
   1. 创建：
      - var date = new Date();
   2. 方法：
      - toLocaleString()：返回当前 date 对象对应的时间本地字符串格式
      - getTime()：获取毫秒值。返回当前如期对象描述的时间到 1970年1月1日零点 的毫秒值差
4. Math
   1. Math 对象不用创建，直接使用。Math.方法名();
   2. 方法：
      - random()：返回 0 ~ 1 之间的随机数。 含0不含1
      - ceil(x)
      - floor(x)
      - round(x)
5. RegExp：正则表达式对象
   1. 正则表达式：
      - 单个字符
      - 量词符号：
        - ?：表示出现 0次 或 1次
        - *：表示出现 0次 或 多次
        - +：表示出现 1次 或 多次
        - {m,n}
      - 开始结束符号：
        - ^：开始
        - $：结束
   2. 正则对象：
      1. 创建：
         - var reg = new RegExp("正则表达式");
           - eg：`var reg = ("^\\w{6,12}$");`
         - var reg = /正则表达式/;
           - eg：`var reg = /^\w{6,12}$/;`
      2. 方法：
         - test(参数)：验证指定的字符串是否符合正则定义的规范
6. Global
   1. 全局对象。这个Global中封装的方法 不需要对象就可以直接调用。
      - 方法名();
   2. 方法：
      - encodeURI()：url编码
      - decodeURI()：url解码
      - encodeURIComponent()：url编码,编码的字符更多
      - decodeURIComponent()：url解码
      - parseInt()：将字符串转为数字
        - 逐一判断每一个字符是否是数字，直到不是数字为止，将前边数字部分转为number
      - isNaN()：判断一个值是否是NaN
        - NaN参与的 == 比较全部为 false，用 isNaN() 判断为 true
      - eval()：将 JavaScript 字符串，并把它作为脚本代码来执行。
7. Boolean
8. Number
9. String



### BOM

浏览器对象模型

1. 组成：
   - Window：窗口对象
   - Navigator：浏览器对象
   - Screen：显示器屏幕对象
   - History：历史记录对象
   - Location：地址栏对象
2. Window：窗口对象
   1. 特点：
      - Window对象不需要创建可以直接使用 window使用。 window.方法名();
      - window引用可以省略。  方法名();
   2. 方法：
      1. 与弹出框有关的方法：
         - alert()：显示带有一段消息和一个 确认按钮 的警告框。
         - confirm()：显示带有一段消息以及 确认按钮 和 取消按钮 的对话框。
         - prompt()：显示可提示用户输入的对话框。
      2. 与打开关闭有关的方法：
         - close()：关闭浏览器窗口。
         - open()：打开一个新的浏览器窗口
      3. 与定时器有关的方式：
         - setTimeout()：在指定的毫秒数后调用函数或计算表达式。
           - 参数：
             1. js 代码或者方法对象
             2. 毫秒值
         - clearTimeout()：取消由 setTimeout() 方法设置的 timeout。
         - setInterval()：按照指定的**周期**（以毫秒计）来调用函数或计算表达式。
         - clearInterval()：取消由 setInterval() 设置的 timeout。
   3. 属性：
      1. 获取其他 BOM 对象
      2. 获取 DOM 对象
         - document
3. Location：地址栏对象
   1. 创建：
      - window.location
      - location
   2. 方法：
      - reload()：重新加载当前文档。刷新
   3. 属性：
      - href：设置或返回完整的 URL。
4. History：历史记录对象
   1. 创建：
      - window.history
      - history
   2. 方法：
      - back()：加载 history 列表中的前一个 URL。
      - forward()：加载 history 列表中的下一个 URL。
      - go(参数)：加载 history 列表中的某个具体页面。
        - 参数：
          - 正数：前进几个历史记录
          - 负数：后退几个历史记录
   3. 属性：
      - length：返回当前窗口历史列表中的 URL 数量。



### DOM

*控制 html 文档的内容*	文档对象模型



#### 核心 DOM

*针对任何结构化文档的标准模型*

1. Document：文档对象
   1. 创建(获取)：在html dom模型中可以使用window对象来获取
      - window.document
      - document
   2. 方法：
      1. 获取Element对象：
         - getElementById()：id属性值一般唯一
         - getElementsByTagName()：返回值是一个数组
         - getElementsByClassName()：返回值是一个数组
         - getElementsByName()：返回值是一个数组
      2. 创建其他DOM对象
2. Element：元素对象
   1. 获取 / 创建：通过document来获取和创建
   2. 方法：
      - removeAttribute()：删除属性
      - setAttribute()：设置属性
3. Attribute：属性对象
4. Text：文本对象
5. Comment：注释对象
6. Node：节点对象，其他5个的父对象
   1. 方法：
      - appendChild()：向节点的子节点列表的结尾添加新的子节点。
      - removeChild()：删除（并返回）当前节点的指定子节点。
      - replaceChild()：用新节点替换一个子节点。
   2. 属性：
      - parentNode：返回节点的父节点



#### XML DOM

*针对 XML 文档的标准模型*



#### HTML DOM

*针对 HTML 文档的标准模型*

1. 标签体的设置和获取：innerHTML
2. 使用html元素对象的属性
3. 控制元素样式：
   1. 使用元素的style属性来设置
   2. 提前定义好类选择器的样式，通过元素的className属性来设置其class属性值。



#### 事件

1. 常见的事件：
   1. 点击事件：
      - onclick：单击事件
      - ondblclick：双击事件
   2. 焦点事件：
      - onblur：失去焦点
      - onfocus:元素获得焦点
   3. 加载事件：
      - onload：一张页面或一幅图像完成加载
   4. 鼠标事件：
      - onmousedown：鼠标按钮被按下。
      - onmouseup：鼠标按键被松开。
      - onmousemove：鼠标被移动。
      - onmouseover：鼠标移到某元素之上。
      - onmouseout：鼠标从某元素移开。
   5. 键盘事件：
      - onkeydown：某个键盘按键被按下。	
      - onkeyup：某个键盘按键被松开。
      - onkeypress：某个键盘按键被按下并松开。
   6. 选择事件：
      - onchange：域的内容被改变。
      - onselect：文本被选中。
   7. 表单事件：
      - onsubmit：确认按钮被点击。
      - onreset：重置按钮被点击。





## XML

可扩展标签

*可扩展：标签都是自定义的。*



### 概念

1. 功能：存储数据
2. xml 与 properties 的区别：
   - 结构：xml 文件主要是树形结构；properties 文件主要是以 key-value 键值对的形式存在
   - 灵活程度：xml 比 properties 更灵活
   - 使用便捷程度：properties 配置起来更简单；xml 则较为复杂
   - 应用程度：properties 比较适合小型简单的项目；xml 适合大型复杂的项目，因为它比较灵活
3. xml 与 html 的区别：
   - xml 标签都是自定义的，html 标签是预定义
   - xml 的语法严格，html 语法松散
   - xml 是存储数据的，html 是展示数据



### 语法

1. 基本语法：
   1. xml 的第一行必须定义为文档声明
   2. xml 文档中有且仅有一个根标签
   3. xml 区分大小写
   
2. 组成部分：
   1. 文档声明
      1. 格式：`<?xml version='1.0' ?>`
      2. 属性列表：
         - version：版本号，必须的属性
         - encoding：编码方式。告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1
         - standalone：是否独立
           - 取值：
             - yes：不依赖其他文件
             - no：依赖其他文件
   2. 指令：结合 css 的
      - `<?xml-stylesheet type="text/css" href="a.css" ?>`
   3. 标签：标签名称自定义的
   4. 属性：id 属性值唯一
   5. 文本：
      - CDATA 区：在该区域中的数据会被原样展示
        - 格式：`<![CDATA[ 数据 ]]>`
   
3. 约束：规定 xml 文档的书写规则
   1. 分类
      - DTD：一种简单的约束技术
   
        ![](https://gitee.com/the-sherry/picture/raw/master/typora/202503252046018.png)
   
        *：表示 0 次或多次
   
        (name,age,sex)：按顺序出现
   
        #PCDATA：字符串
   
        #REQUIRED：必须出现
      - Schema：一种复杂的约束技术
   
   2. DTD：引入 dtd 文档到 xml 文档中
      - 内部 dtd：将约束规则定义在 xml 文档中
      - 外部 dtd：将约束规则定义在外部的 dtd 文档中
        - 本地：`<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">`
        - 网络：`<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">`（文件名字随便起）
   
   3. Schema：
   
      1. 填写 xml 文档的根元素
   
      2. 引入 xsi 前缀  `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`
   
      3. 引入 xsd 文件命名空间  `xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"`
   
      4. 为每一个 xsd 约束声明一个前缀，作为标识  `xmlns="http://www.itcast.cn/xml"`
   
         ```xml
         <students	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         			xmlns="http://www.itcast.cn/xml"
         			xsi:schemaLocation="http://www.itcast.cn/xml student.xsd">
         ```



### 解析

1. 操作 xml 文档，将文档中的数据读取到内存中

   1. 操作 xml 文档：

      1. 解析（读取）：将文档中的数据读取到内存中
      2. 写入：将内存中的数据保存到 xml 文档中。持久化的存储

   2. 解析 xml 的方式：

      1. DOM：将标记语言文档一次性加载进内存，在内存中形成一颗 dom 树
         - 优点：操作方便，可以对文档进行 CRUD 的所有操作
         - 缺点：占内存
      2. SAX：逐行读取，基于事件驱动的。
         - 优点：不占内存
         - 缺点：只能读取，不能增删改

   3. xml 常见的解析器：

      1. JAXP：sun 公司提供的解析器，支持 dom 和 sax 两种思想
      2. DOM4J：一款非常优秀的解析器
      3. Jsoup：jsoup 是一款 Java 的 HTML 解析器，可直接解析某个 URL 地址、HTML 文本内容。它提供了一套非常省力的 API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
      4. PULL：Android 操作系统内置的解析器，sax方式的。

   4. Jsoup：

      1. 快速入门：

         - 步骤：
           1. 导入 jar 包
           2. 获取 Document 对象
           3. 获取对应的标签 Element 对象
           4. 获取数据
         - 代码：

         ```java
         //2.1获取student.xml的path
         String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
         //2.2解析xml文档，加载文档进内存，获取dom树--->Document
         Document document = Jsoup.parse(new File(path), "utf-8");
         
         //3.获取元素对象 Element
         Elements elements = document.getElementsByTag("name");
         System.out.println(elements.size());
         //3.1获取第一个name的Element对象
         Element element = elements.get(0);
         //3.2获取数据
         String name = element.text();
         System.out.println(name);
         ```

   5. 对象的使用：

      1. Jsoup：工具类，可以解析 html 或 xml 文档，返回 Document
         - parse：解析 html 或 xml 文档，返回 Dodument
           - parse(File in, String charsetName)：解析 xml 或 html 文件的。
           - parse(String html)：解析 xml 或 html 字符串     *不常用*
           - parse(URL url, int timeoutMillis)：通过网络路径获取指定的 html 或 xml 的文档对象
      2. Document：文档对象。代表内存中的dom树
         - 获取 Element 对象
           - getElementById(String id)：根据id属性值获取唯一的element对象
           - getElementsByTag(String tagName)：根据标签名称获取元素对象集合
           - getElementsByAttribute(String key)：根据属性名称获取元素对象集合
           - getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
      3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用
      4. Element：元素对象
         1. 获取子元素对象
            - getElementById(String id)：根据id属性值获取唯一的element对象
            - getElementsByTag(String tagName)：根据标签名称获取元素对象集合
            - getElementsByAttribute(String key)：根据属性名称获取元素对象集合
            - getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
         2. 获取属性值
            - String attr(String key)：根据属性名称获取属性值
         3. 获取文本内容
            - String text()：获取文本内容
            - String html()：获取标签体的所有内容(包括字标签的字符串内容)
      5. Node：节点对象
         - 是Document和Element的父类

   6. 快捷查询方式：

      1. selector：选择器

         - 使用的方法：Elements select(String cssQuery)
           - 语法：参考 Selector 类中定义的语法

      2. XPath：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言

         *主要是对 dom 树形结构进行操作的。其实跟 Jsoup 没太大关系，是比较独立的一个东西*

         - 使用 Jsoup 的 Xpath 需要额外导入 jar 包。
         - 查询 w3cshool 参考手册，使用 xpath 的语法完成查询

         代码：

         ```java
         //1.获取student.xml的path
         String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
         //2.获取Document对象
         Document document = Jsoup.parse(new File(path), "utf-8");
         
         
         
         //3.根据document对象，创建JXDocument对象
         JXDocument jxDocument = new JXDocument(document);
         //4.结合xpath语法查询
         //4.1查询所有student标签
         List<JXNode> jxNodes = jxDocument.selN("//student");
         for (JXNode jxNode : jxNodes) {
         	System.out.println(jxNode);
         }
         
         System.out.println("--------------------");
         //4.2查询所有student标签下的name标签
         List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
         for (JXNode jxNode : jxNodes2) {
         	System.out.println(jxNode);
         }
         
         System.out.println("--------------------");
         //4.3查询student标签下带有id属性的name标签
         List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
         for (JXNode jxNode : jxNodes3) {
         	System.out.println(jxNode);
         }
         
         System.out.println("--------------------");
         //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
         List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='itcast']");
         for (JXNode jxNode : jxNodes4) {
         	System.out.println(jxNode);
         }
         ```





## 回顾

1. 软件架构：

   1. C/S：客户端/服务器端
   2. B/S：浏览器/服务器端

2. 资源分类：

   1. 静态资源：所有用户访问后，得到的结果都是一样的，称为静态资源。**静态资源可以直接被浏览器解析**

      如：html，css，JavaScript

   2. 动态资源:每个用户访问相同资源后，得到的结果可能不一样。称为动态资源。动态资源被访问后，**需要先转换为静态资源**，再返回给浏览器

      如：servlet / jsp，php，asp···

3. 网络通信三要素：

   1. IP：电子设备（计算机）在网络中的唯一标识。
   2. 端口：应用程序在计算机中的唯一标识。 0~65536
   3. 传输协议：规定了数据传输的规则
      - 基础协议：
        1. tcp：安全协议，三次握手。 速度稍慢
        2. udp：不安全协议。 速度快





## HTTP

*Hyper Text Transfer Protocol 超文本传输协议*

1. 概念：
   - 特点：
     - 基于 TCP/IP 的高级协议
     - 默认端口号：80
     - 基于请求 / 响应模型的：一次请求对应一次响应
     - 无状态的：每次请求之间相互独立，不能交互数据
   - 历史版本：
     - 1.0：每一次请求响应都会建立新的连接
     - 1.1：复用连接
2. 请求消息数据格式
   1. 请求行
      - 请求方式 请求url 请求协议/版本
      - 请求方式：HTTP协议有 7 种请求方式，常用的有 2 种
        - **GET**：
          - 请求参数在请求行中显示，在 url 后
          - 请求 url 长度有限制
          - 不太安全
        - **POST**
          - 请求参数在请求体中
          - 请求 url 长度没有限制
          - 相对安全
   2. 请求头：客户端浏览器告诉服务器一些信息
      - 请求头名称:请求头值
      - 常见的请求头：
        - User-Agent：浏览器告诉服务器，我访问你使用的浏览器版本信息
          - 可以在服务器端获取该头的信息，解决浏览器的兼容性问题
        - Referer：http://localhost/login.html
          - 告诉服务器，我(当前请求)从哪里来？
            - 作用：
              1. 防盗链
              2. 统计工作
   3. 请求空行
      - 用于分隔 post 请求的请求头和请求体
   4. 请求体（正文）
      - 封装 post 请求消息的请求参数
3. 响应信息：服务器端发送给客户端的数据
   1. 响应行
      1. 组成：协议/版本 响应状态码 状态码描述
      2. **分类**：
         - 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
         - 2xx：成功。代表：200
         - 3xx：重定向。代表：302(重定向)，304(访问缓存)
         - 4xx：客户端错误
           - 404（请求路径没有对应的资源）
           - 405：请求方式没有对应的doXxx方法
         - 5xx：服务器端错误。代表：500(服务器内部出现异常)
   2. 响应头
      1. 格式：头名称:值
      2. 常见的响应头：
         - Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式
         - Content-disposition：服务器告诉客户端以什么格式打开响应体数据
           - 值：
             - in-line：默认值，在当前页面内打开
             - attachment;filename=xxx：以附件形式打开响应体。文件下载
   3. 响应空行
   4. 响应体：传输的数据





## web服务器软件

1. 服务器：安装了服务器软件的计算机

2. 服务器软件：接收用户的请求，处理请求，做出响应

3. web服务器软件：接收用户的请求，处理请求，做出响应。
   - 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目
   - 也可以称为是一个**web容器**

4. 常见的java相关的web服务器软件：
   - webLogic：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
   - webSphere：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
   - JBOSS：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
   - Tomcat：Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的。

5. JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范

6. Tomcat：web 服务器软件

   1. 下载：http://tomcat.apache.org/

   2. 安装：解压压缩包即可。

   3. 卸载：删除目录即可。

   4. 启动：

      - bin/startup.bat（windows系统）,双击运行该文件即可

      - 访问：浏览器输入：`http://localhost:8080` 回车访问自己；`http://别人的ip:8080` 访问别人

      - 可能遇到的问题：

        1. 黑窗口一闪而过：

           - 原因：没有正确配置 JAVA_HOME 环境变量
           - 解决方案：正确配置 JAVA_HOME 环境变量

        2. 启动报错：

           1. 暴力：找到占用的端口，并且找到对应的进程，杀死该进程

              - netstat -ano  看PID

           2. 温柔：修改自身的端口号

              - conf/server.xml
              - <Connector port="8080" protocol="HTTP/1.1"

              connectionTimeout="20000"

              redirectPort="8445" />

              - 一般会将 tomcat 的默认端口号修改为 80。80 端口号是http协议的默认端口号。
                - 好处：在访问时不用输入端口号

   5. 关闭：

      1. 正常关闭：
         - bin/shutdown.bat
         - ctrl + c

      2. 强制关闭：
         - 点击启动窗口的×

   6. **配置**：

      - 部署项目的方式：

        1. 直接将项目放到 webapps 目录下即可。
           - /hello：项目的访问路径（虚拟目录）
           - 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。
             - war包会自动解压缩

        2. 配置 conf/server.xml 文件
           - 在<Host>标签体中配置
             - <Context docBase="D:\hello" path="/hehe" />
               - docBase：项目存放的路径
               - path：虚拟目录

        3. 在 conf\Catalina\localhost 创建任意名称的xml文件。在文件中编写
           - <Context docBase="D:\hello" />
             - 虚拟目录：xml文件的名称

      - 静态项目和动态项目：

        - **目录结构**：

          - java 动态项目的目录结构：

            -- 项目的根目录

            ​	-- WEB-INF目录

            ​		-- web.xml：web项目的核心配置文件

            ​		-- classes目录：放置字节码文件的目录

            ​		-- lib目录：放置依赖的jar包

      - 将Tomcat集成到IDEA中，并且创建**JavaEE的项目**，部署项目。



## web 三大组件

- Servlet
- Filter
- Listener






## Servlet

*server applet*



### 概念

运行在服务器端的小程序

- Servlet就是一个接口，定义了Java类被浏览器访问到（tomcat识别）的规则。



### 步骤

1. 创建 JavaEE 项目

2. 定义一个类，实现 Servlet 接口

3. 实现接口中的抽象方法

4. 配置 Servlet

   在 web.xml配置：

   ```java
   <!--配置Servlet -->
   <servlet>
   	<servlet-name>demo1</servlet-name>
   	<servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>
   </servlet>
   		
   <servlet-mapping>
   	<servlet-name>demo1</servlet-name>
   	<url-pattern>/demo1</url-pattern>
   </servlet-mapping>
   ```



### 执行原理

1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
3. 如果有，则在找到对应的<servlet-class>全类名
4. tomcat会将字节码文件加载进内存，并且创建其对象
5. 调用其方法



### 生命周期方法

1. 被创建：执行 **init方法**，只执行一次
   - Servlet 什么时候被创建？
     - 默认情况下，第一次被访问时，Servlet被创建
     - 可以配置执行Servlet的创建时机。
       - 在<servlet>标签下配置
         1. 第一次被访问时，创建
            - <load-on-startup>的值为负数
         2. 在服务器启动时，创建
            - <load-on-startup>的值为0或正整数
   - Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
     - 多个用户同时访问时，可能存在线程安全问题。
     - 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值
2. 提供服务：执行 **service方法**，执行多次
   - 每次访问Servlet时，Service方法都会被调用一次。
3. 被销毁：执行 **destroy方法**，只执行一次
   - Servlet被销毁时执行。服务器关闭时，Servlet被销毁
   - 只有服务器正常关闭时，才会执行destroy方法。
   - destroy方法在Servlet被销毁之前执行，一般用于释放资源



### Servlet3.0 注解配置

@WebServlet("资源路径")



IDEA 与 tomcat 的相关配置

1. IDEA会为每一个tomcat部署的项目单独建立一份配置文件
   - 查看控制台的log：Using CATALINA_BASE:   "C:\Users\Lenovo\AppData\Local\JetBrains\IntelliJIdea2022.3\tomcat\6b0d3be1-2a74-48a7-b8e6-1b6594ed6a23"
2. 工作空间项目 和 tomcat部署的web项目
   - tomcat真正访问的是“tomcat部署的web项目”，"tomcat部署的web项目"对应着"工作空间项目" 的web目录下的所有资源
   - **WEB-INF目录下的资源不能被浏览器直接访问**
3. 断点调试：debug启动



### Servlet的体系结构

Servlet -- 接口
			|
GenericServlet -- 抽象类
			|
HttpServlet  -- 抽象类

- GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将 service() 方法作为抽象
  - 将来定义Servlet类时，可以继承GenericServlet，实现 service() 方法即可
- HttpServlet：对http协议的一种封装，简化操作
- 步骤：
  1. 定义类继承 HttpServlet
  2. 复写 doGet / doPost 方法



### Servlet相关配置

1. urlpartten：Servlet 访问路径
   - 一个 Servlet 可以定义多个访问路径 ：`@WebServlet({"/d4","/dd4","/ddd4"})`
   - 路径定义规则：
     - /xxx
     - /xxx/xxx：多层路径，目录结构
     - *.do：扩展名匹配



### Request 对象

1. request 对象和 response 对象的原理

   - request和response对象是由服务器创建的。我们来使用它们
   - request对象是来获取请求消息，response对象是来设置响应消息

2. request对象继承体系结构

   ServletRequest				接口

   ​			|

   HttpServletRequest		接口

   ​			|

   org.apache.catalina.connector.RequestFacade 类（tomcat 编写的）

3. request 功能：

   1. 获取请求消息数据
      1. 获取请求行数据
         - 获取虚拟目录：`String getContextPath()`：/day14
         - 获取请求URI：
           - `String getRequestURI()`：/day14/demo1
           - `StringBuffer getRequestURL()`：http://localhost/day14/demo1
             - URL：统一资源定位符：http://localhost/day14/demo1		~ 中华人民共和国
             - URI：统一资源标识符：/day14/demo1									~ 共和国
      2. 获取请求头数据
         - String getHeader(String name)：通过请求头的名称获取请求头的值
      3. 获取请求体数据（只有 post 请求方式，才有请求体，在请求体中封装了 post 请求的请求参数）
         - 获取流对象：
           - BufferedReader getReader()：获取字符输入流，只能操作字符数据
           - ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
         - 再从流对象中拿数据
   2. 其他功能：
      1. 获取请求参数通用方式
         - String getParameter(String name)：根据参数名称获取参数值 username=zs&password=123
         - String[] getParameterValues(String name)：根据参数名称获取参数值的数组 hobby=xx&hobby=game
         - Enumeration<String> getParameterNames()：获取所有请求的参数名称
         - Map<String,String[]> getParameterMap()：获取所有参数的map集合
           - 中文乱码问题：
             - 设置编码：`request.setCharacterEncoding("utf-8");`
      2. 请求转发：一种在服务器内部的资源跳转方式
         - 步骤：
           1. 通过 request 对象获取请求转发器对象：`RequestDispatcher getRequestDispatcher(String path)`
           2. 使用 RequestDispatcher 对象来进行转发：`forward(ServletRequest request, ServletResponse response)`
         - 特点：
           - 浏览器地址栏路径不发生变化
           - 只能转发到当前服务器内部资源中
           - 转发是一次请求
      3. 共享数据：
         - void setAttribute(String name,Object obj)：存储数据
         - Object getAttitude(String name)：通过键获取值
         - void removeAttribute(String name)：通过键移除键值对
      4. 获取 ServletContext：
         - ServletContext getServletContext()



### Response 对象

*设置响应消息*

- 设置响应行
  - 格式：HTTP/1.1 200 ok
  - 设置状态码：setStatus(int sc)
  
- 设置响应头：setHeader(String name, String value)
- 设置响应体：
  - 使用步骤：
    1. 获取输出流
       - 字符输出流：PrintWriter getWriter()
       - 字节输出流：ServletOutputStream getOutputStream()
    2. 使用输出流，将数据输出到客户端浏览器



1. 完成重定向

   - 重定向：资源跳转的方向

   - 代码实现：

     ```java
     //1. 设置状态码为302
     response.setStatus(302);
     //2.设置响应头 location
     response.setHeader("location","/day15/responseDemo2");
     
     //简单的重定向方法
     response.sendRedirect("/day15/responseDemo2");
     ```

   - **forward 和 redirect 区别**

     - 重定向的特点：redirect

       1. 地址栏发生变化
       2. 重定向可以访问其他站点（服务器）的资源
       3. 重定向是两次请求。不能使用 request 对象来共享数据

     - 转发的特点：forward

       1. 转发地址栏路径不变

       2. 转发只能访问当前服务器下的资源

       3. 转发是一次请求，可以使用 request 对象来共享数据

       4. 代码实现：

          `request.getRequestDispatcher("转发的目的路径").forward(request,response);`

   - 路径写法：

     - 路径分类
       1. 相对路径：通过相对路径不可以确定唯一资源
          - 如：`./index.html`
          - 不以 / 开头，以 . 开头的路径
          - 规则：找到 当前资源 和 目标资源 之间的相对位置关系
            - `./`：当前目录
            - `../`：后退一级目录
       2. 绝对路径：通过绝对路径可以确定唯一资源
          - 如：http://localhost/day15/responseDemo2		/day15/responseDemo2
          - 以 / 开头的路径
          - 规则：判断定义的路径是给谁用的？（判断请求从哪儿发出）
            - 给客户端浏览器使用：需要加虚拟目录（项目的访问路径）
              - 建议虚拟目录动态获取：`request.getContextPath()` 获取项目的访问路径
              - <a>，<form>，重定向··· 都是给客户端使用的路径
            - 给服务器使用：不需要加虚拟目录
              - 转发路径 是给服务器端使用的路径

2. 服务器输出字符数据到浏览器

   - 代码

     ```java
     // 设置编码（解决中文乱码问题，在获取流之前设置）
     response.setContentType("text/html;charset=utf-8");
     
     // 1.获取字符输出流
     PrintWriter pw = response.getWriter();
     // 2.输出数据
     // pw.write("<h1>hello response</h1>");
     pw.write("你好啊啊啊 response");
     ```

3. 服务器输出字节数据到浏览器

   - 代码：

     ```java
     // 1.获取字节输出流
     ServletOutputStream sos = response.getOutputStream();
     // 2.输出数据
     sos.write("你好".getBytes());
     ```



### ServletConfig对象

1. 在 web.xml 中配置初始化参数，

   ```xml
   <servlet>
       <servlet-name>InitParamServlet</servlet-name>
       <servlet-class>nuc.ss.demo.InitParamServlet</servlet-class>
       <init-param>
           <param-name>url</param-name>
           <param-value>www.nuc.edu.cn</param-value>
       </init-param>
   </servlet>
   ```

2. 封装 Servlet 配置信息

   ```java
   ServletConfig config = this.getServletConfig();
   String servletname = config.getlnitParameter("url");
   System.out.print("servletname");
   ```



### ServletContext 对象

*代表整个 web 应用，可以和程序的容器（服务器）来通信*

1. 获取：
   - 通过 request 对象获取：`request.getServletContext();`
   - 通过 HttpServlet 获取：`this.getServletContext();`
2. 功能：
   1. 获取MIME类型：
      - MIME类型：在互联网通信过程中定义的一种文件数据类型
        - 格式：大类型/小类型      text/html      image/jpeg
      - 获取：`String getMimeType(String file)`
   2. 域对象：共享数据
      - setAttribute(String name,Object value)
      - getAttribute(String name)
      - removeAttribute(String name)
   3. 获取文件的真实（服务器）路径
      - String getRealPath(String path)





## JDBC

*Java DataBase Connectivity*：官方（Sun公司）定义的一套操作所有关系型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动jar包。



### 步骤

1. 导入驱动jar包
2. 注册驱动
3. 获取数据库连接对象 Connection
4. 定义 sql
5. 获取执行 sql 语句的对象 Statement
6. 执行 sql，接受返回结果
7. 处理结果
8. 释放资源

```java
// 1.导入驱动jar包
// 2.注册驱动
Class.forName("com.mysql.jdbc.Driver");
// 3.获取数据库连接对象
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
// 4.定义sql语句
String sql = "update account set balance = 2000 where id = 1";
// 5.获取执行sql的对象 Statement
Statement stmt = conn.createStatement();
// 6.执行sql
int count = stmt.executeUpdate(sql);
// 7.处理结果
System.out.println(count);
// 8.释放资源
stmt.close();
conn.close();
```



### 对象详解

#### DriverManager：驱动管理对象

1. 注册驱动：告诉程序该使用哪一个数据库驱动 jar

   - `static void registerDriver(Driver driver)`：注册与给定的驱动程序 DriverManager

     写代码使用：`Class.forName("com.mysql.jdbc.Driver");`

     通过查看源码发现，在 com.mysql.jdbc.Driver 类中存在静态代码块：

     ```java
     static {
         try {
             java.sql.DriverManager.registerDriver(new Driver());
         } catch (SQLException E) {
         	throw new RuntimeException("Can't register driver!");
         }
     }
     ```

     注意：mysql5 之后的驱动 jar 包可以省略注册驱动的步骤。

2. 获取数据库连接

   - `static Connection getConnection(String url, String user, String password) `
     - 参数：
       - url：指定连接的路径
         - 语法：`jdbc:mysql://ip地址(域名):端口号/数据库名称`
           - 如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则 url 可以简写为：`jdbc:mysql:///数据库名称`



#### Connection：数据库连接对象

1. 获取执行 sql 的对象
   - `Statement createStatement()`
   -  `PreparedStatement prepareStatement(String sql) `
2. 管理事务
   - 开启事务：`setAutoCommit(boolean autoCommit)`：调用该方法设置参数为false，即开启事务
   - 提交事务：`commit()`
   - 回滚事务：`rollback()`



#### Statement：执行 sql 的对象

1. 执行 sql
   - ` int executeUpdate(String sql)`：执行DML（insert、update、delete）语句、DDL（create，alter、drop）语句
     - 返回值：影响的行数，可以通过这个影响的行数判断 DML 语句是否执行成功。
       - 返回值 > 0的则执行成功，反之，则失败。
   - `ResultSet executeQuery(String sql)`：执行DQL（select）语句



#### ResultSet：结果集对象，封装查询结果

1. `boolean next()`：游标向下移动一行，判断当前行是否有数据，如果是，则返回false，如果不是则返回true
2. `getXxx(参数)`：获取数据
   - Xxx：代表数据类型。如：int getInt()，String getString()
   - 参数：
     - int：代表列的编号，从1开始。如：getString(1)
     - String：代表列名称。如：getDouble("balance")



#### PreparedStatement：执行 sql 对象

1. SQL 注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
   - 输入用户随便，输入密码：a' or 'a' = 'a
2. 解决 sql 注入问题：使用PreparedStatement对象来解决
3. 预编译的 SQL：参数使用 `?` 作为占位符



### 抽取 JDBC 工具类：JDBCUtils

*简化书写*

1. 内容：

   1. 抽取注册驱动（静态代码块）

      ```java
      static{
          //读取资源文件，获取值。
          try {
              //1. 创建Properties集合类。
              Properties pro = new Properties();
      
              //获取src路径下的文件的方式--->ClassLoader 类加载器
              ClassLoader classLoader = JDBCUtils.class.getClassLoader();
              URL res  = classLoader.getResource("jdbc.properties");
              String path = res.getPath();
      		System.out.println(path); // D:/IdeaProjects/itcast/out/production/day04_jdbc/jdbc.properties
              
              //2. 加载文件
              pro.load(new FileReader(path));
      
              //3. 获取数据，赋值
              url = pro.getProperty("url");
              user = pro.getProperty("user");
              password = pro.getProperty("password");
              driver = pro.getProperty("driver");
              
              //4. 注册驱动
              Class.forName(driver);
          } catch (IOException e) {...}
      }
      ```

   2. 抽取一个方法获取连接对象：`static Connection getConnection()`

      ```java
      return DriverManager.getConnection(url, user, password);
      ```

   3. 抽取一个方法释放资源：`static void close()`

      ```java
      // 重载
      public static void close(Statement stmt,Connection conn){...}
      public static void close(ResultSet rs,Statement stmt, Connection conn){...}
      ```



### JDBC 控制事务

1. 事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。
2. 操作：
   1. 开启事务
   2. 提交事务
   3. 回滚事务
3. 使用 Connection 对象来管理事务：
   - 开启事务：
        - `setAutoCommit(boolean autoCommit)`：调用该方法设置参数为false，即开启事务
          - 在执行sql之前开启事务
   - 提交事务：`commit() `
     			* 当所有 sql 都执行完提交事务
   - 回滚事务：`rollback()`
     			* 在 catch 中回滚事务（try 中代码出错了回滚）





### 数据库连接池

*其实就是一个容器（集合），存放数据库连接的容器。*

1. 实现：

   1. 标准接口：DataSource（*javax.sql 包下的*）
      - 方法：
        - 获取连接：`getConnection()`
        - 归还连接：`connection.close()`
          - 如果连接对象 Connection 是从连接池中获取的，那么调用 connection.close() 方法，则不会再关闭连接了，而是归还连接。
   2. 一般我们不去实现它，由数据库厂商来实现
      1. C3P0：数据库连接池技术
      2. Druid：数据库连接池实现技术，由阿里巴巴提供的

2. **C3P0**：数据库连接池技术

   1. 步骤：

      1. 导入 jar 包（c3p0-0.9.5.2.jar，mchange-commons-java-0.2.12.jar）
      2. 定义配置文件：xml 或者 properties
      3. 创建核心对象——数据库连接池对象-ComboPooledDataSource
      4. 获取连接：getConnection

      ```java
      //1.创建数据库连接池对象
      DataSource ds  = new ComboPooledDataSource();
      //2. 获取连接对象
      Connection conn = ds.getConnection();
      ```

3. **Druid**：数据库连接池实现技术，由阿里巴巴提供的

   1. 步骤：

      1. 导入 jar 包
      2. 定义配置文件-properties
      3. 加载配置文件。
      4. 获取数据库连接池对象：通过工厂来来获取-DruidDataSourceFactory
      5. 获取连接：getConnection

      ```java
      //3.加载配置文件
      Properties pro = new Properties();
      InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
      pro.load(is);
      //4.获取连接池对象
      DataSource ds = DruidDataSourceFactory.createDataSource(pro);
      //5.获取连接
      Connection conn = ds.getConnection();
      ```



### Spring JDBC

*Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发*

1. 步骤：
   1. 导入 jar 包
   2. 创建 JdbcTemplate 对象，依赖于数据源 DataSource
      - `JdbcTemplate template = new JdbcTemplate(ds);`
   3. 调用 JdbcTemplate 的方法来完成CRUD的操作：
      - `update()`：执行DML语句。增、删、改语句
      - `queryForMap()`：查询结果将结果集封装为Map集合，将列名作为key，将值作为value。将这条记录封装为一个Map集合
        - 注意：这个方法查询的**结果集长度只能是1**
      - `queryForList()`：查询结果将结果集封装为list集合
        - 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
      - `query()`：查询结果，将结果封装为JavaBean对象
        - query的参数：`RowMapper`
          					* 一般我们使用 `BeanPropertyRowMapper` 实现类。可以完成数据到JavaBean的自动封装
                					* new BeanPropertyRowMapper<类型>(类型.class)
      - `queryForObject()`：查询结果，将结果封装为对象
        - 一般用于聚合函数的查询
        - 参数：数据类型.class





## 会话技术

1. 会话：一次会话包含多次请求和响应。
   - 一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止
2. 功能：在一次会话的范围内的多次请求间，共享数据。
3. 方式：
   - 客户端会话技术：Cookie
   - 服务器端会话技术：Session





## Cookie

*客户端会话技术，将数据保存在客户端*

1. 使用步骤：

   1. 创建Cookie对象，绑定数据
      - `new Cookie(String name, String value) `
   2. 发送Cookie对象
      - `response.addCookie(Cookie cookie)`
   3. 获取Cookie，拿到数据
      - `Cookie[]  request.getCookies()`

2. 实现原理：

   - 基于响应头 set-cookie 和请求头 cookie 实现

3. cookie 的细节：

   1. 一次可不可以发送多个 cookie？
      - 可以
      - 可以创建多个 Cookie 对象，使用 response 调用多次 addCookie 方法发送 cookie 即可。
   2. cookie 在浏览器中保存多长时间？
      - 默认情况下，当浏览器关闭后，Cookie数据被销毁
      - 持久化存储：
        - `setMaxAge(int seconds)`
             					1. 正数：将Cookie数据写到硬盘的文件中，持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
                  					2. 负数：默认值
                  					3. 零：删除cookie信息
   3. cookie能不能存中文？
      - 在tomcat 8 之前 cookie中不能直接存储中文数据。在tomcat 8 之后，cookie支持中文数据，特殊字符还是不支持。
      - 建议使用URL编码存储，URL解码解析
   4. cookie共享问题？
      1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
         - 默认情况下cookie不能共享
         - `setPath(String path)`：设置cookie的获取范围。默认情况下，设置当前的虚拟目录
           - 如果要共享，则可以将path设置为”/“
      2. 不同的tomcat服务器间cookie共享问题？
         - `setDomain(String path)`：如果设置一级域名相同，那么多个服务器之间cookie可以共享
           - `setDomain(".baidu.com")`，那么 tieba.baidu.com 和 news.baidu.com 中cookie可以共享

4. Cookie 的特点和作用

   1. cookie存储数据在客户端浏览器
   2. 浏览器对于单个 cookie 的大小有限制(4kb)以及对同一个域名下的总 cookie 数量也有限制(20个)

   作用：

   1. cookie 一般用于存出少量的不太敏感的数据
   2. 在不登录的情况下，完成服务器对客户端的身份识别





## Session

*服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。*

1. 使用 session 共享数据：

   1. 获取 HttpSession 对象：
      - `HttpSession session = request.getSession();`
   2. 使用 HttpSession 对象：
      - `Object getAttribute(String name) `
      - `void setAttribute(String name, Object value)`
      - `void removeAttribute(String name)`

2. 原理：

   - Session 的实现是依赖于 Cookie 的。

3. 细节：

   1. 当客户端关闭后，服务器不关闭，两次获取 session 是否为同一个？

      - 默认情况下，不是。

      - 如果需要相同，则可以创建 Cookie，键为`JSESSIONID`，设置最大存活时间，让 cookie 持久化保存。

        ```java
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);
        ```

   2. 客户端不关闭，服务器关闭后，两次获取的 session 是同一个吗？

      - 不是同一个，但是要确保数据不丢失。tomcat 自动完成以下工作：
        - session 的钝化：
          - 在服务器正常关闭之前，将 session 对象系钝化到硬盘上
        - session的活化：
          - 在服务器启动后，将 session 文件转化为内存中的 session 对象即可。

   3. session 什么时候被销毁？

      1. 服务器关闭

      2. session 对象调用 `invalidate()`

      3. session 默认失效时间 30分钟

         - 选择性配置修改

           ```xml
           <session-config>
           	<session-timeout>30</session-timeout>
           </session-config>
           ```

4. session 的特点：

   1. session 用于存储一次会话的多次请求的数据，存在服务器端
   2. session可以存储任意类型，任意大小的数据

5. Session 与 Cookie 的区别：

   1. Session 存储数据在服务器端，Cookie 在客户端
   2. Session 没有数据大小限制，Cookie 有
   3. Session 数据安全，Cookie 相对于不安全





## JSP

*Java Server Pages：java 服务器端页面 —— 一个特殊的页面，其中既可以指定定义 html 标签，又可以定义 java 代码*

1. JSP 本质上就是一个 Servlet。

2. JSP 的脚本：JSP 定义 java 代码的方式

   1. `<% 代码 %>`：定义的 java 代码，在 service 方法中。service 方法中可以定义什么，该脚本中就可以定义什么。
   2. `<%! 代码 %>`：定义的 java 代码，在 jsp 转换后的 java 类的成员位置。
   3. `<%= 代码 %>`：定义的 java 代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。

3. 指令：用于配置 jsp 页面，导入资源文件

   1. 格式：`<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>`
   2. 分类：
      1. page：配置 jsp 页面
         - contentType：等同于 response.setContentType()
           1. 设置响应体的MIME类型以及字符集
           2. 设置当前 jsp 页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置 pageEncoding 属性设置当前页面的字符集）
         - import：导包
         - errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
         - isErrorPage：标识当前是否是错误页面。
           - true：是，可以使用内置对象exception
           - false：否。默认值。不可以使用内置对象exception
      2. include：页面包含的。导入页面的资源文件
         - `<%@include file="top.jsp"%>`
      3. taglib：导入资源
         - `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>`
           - prefix：前缀，自定义的

4. 注释：

   1. html注释：
      	`<!-- -->`：只能注释html代码片段
   2. jsp注释：推荐使用
      	<%-- --%>：可以注释所有

5. JSP 的内置对象：在 jsp 页面中不需要获取和创建，可以直接使用的对象

   - jsp 一共有9个内置对象。

     | 变量名      | 真实类型            | 作用                                         |
     | ----------- | ------------------- | -------------------------------------------- |
     | pageContext | PageContext         | 当前页面共享数据，还可以获取其他八个内置对象 |
     | request     | HttpServletRequest  | 一次请求访问的多个资源(转发)                 |
     | session     | HttpSession         | 一次会话的多个请求间                         |
     | application | ServletContext      | 所有用户间共享数据                           |
     | response    | HttpServletResponse | 响应对象                                     |
     | page        | Object              | 当前页面(Servlet)的对象：this                |
     | out         | JspWriter           | 输出对象，数据输出到页面上                   |
     | config      | ServletConfig       | Servlet的配置对象                            |
     | exception   | Throwable           | 异常对象                                     |

     - out：字符输出流对象。可以将数据输出到页面上。和 response.getWriter() 类似
       - response.getWriter() 和 out 的区别：
         - 在tomcat服务器真正给客户端做出响应之前，会先找 response 缓冲区数据，再找 out 缓冲区数据。
         - response.getWriter().write() 数据输出永远在 out.write() 之前





## EL 表达式

*Expression Language 表达式语言：替换和简化 jsp 页面中 java 代码的编写*

1. 语法：`${表达式}`

2. 注意：

   - jsp 默认支持 EL 表达式。如果要忽略 EL 表达式：
     1. 设置 jsp 中的 page 指令中：`isELIgnored="true"` —— 忽略当前 jsp 页面中所有的 EL 表达式
     2. `\${表达式}`：忽略当前这个 EL 表达式

3. 使用：

   1. 运算：

      - 运算符：
        1. 算数运算符：+	-	*	/(div)	%(mod)
        2. 比较运算符：>	<	>=	<=	==	!=
        3. 逻辑运算符：&&(and)	||(or)	!(not)
        4. 空运算符：empty
           - 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
             - `${empty list}`：判断字符串、集合、数组对象是否为null或者长度为0
             - `${not empty str}`：表示判断字符串、集合、数组对象是否不为null 并且 长度>0

   2. 获取值：

      1. EL 表达式只能从域对象中获取值

      2. 语法：

         1. `${域名称.键名}`：从指定域中获取指定键的值

            - 域名称：

              | 域名称（jstl用的） | 真实类型（el用的）            |
              | ------------------ | ----------------------------- |
              | pageScope          | pageContext                   |
              | requestScope       | request                       |
              | sessionScope       | session                       |
              | applicationScope   | application（ServletContext） |

                 - 举例：在 request 域中存储了 name=张三
                   -  获取：`${requestScope.name}`

         2. `${键名}`：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。

         3. 获取对象、List集合、Map集合的值：（如果没有重复的键名，不写域名称也可以）

            1. 对象：`${域名称.键名.属性名}`
               - 本质上会去调用对象的getter方法
            2. List集合：`${域名称.键名[索引]}`
            3. Map集合：
               * `${域名称.键名.key名称}`
               * `${域名称.键名["key名称"]}`

      3. 隐式对象：

         - EL 表达式中有11个隐式对象
         - pageContext：
           - 获取 jsp 其他八个内置对象：
             - `${pageContext.request.contextPath}`：动态获取虚拟目录





## JSTL

*JavaServer Pages Tag Library	JSP标准标签库*：用于简化和替换jsp页面上的java代码

1. 使用步骤：
   1. 导入 jstl 相关 jar包
   2. 引入标签库：taglib 指令 —— `<%@ taglib %>`
   3. 使用标签
2. 常用的 JSTL 标签
   1. `if`：相当于java代码的**if**语句
      1. 属性：
         - test 必须属性，接受 boolean 表达式
           - 如果表达式为true，则显示 if 标签体内容，如果为false，则不显示标签体内容
           - 一般情况下，test属性值会结合 EL 表达式一起使用
      2. 注意：
         - c:if 标签没有else情况，想要else情况，则可以在再一个 c:if 标签
   2. choose：相当于java代码的switch语句
      1. 使用 `choose` 标签声明，相当于**switch**声明
      2. 使用 `when` 标签做判断，相当于**case**声明
      3. 使用 `otherwise` 标签做其他情况的声明，相当于**default**
   3. `forEach`：相当于java代码的**for**语句
      1. 完成重复的操作
         - 属性：
           - begin：开始值
           - end：结束值
           - var：临时变量
           - step：步长
           - varStatus：循环状态对象
             - index：容器中的元素的索引，从0开始
             - count：循环次数，从1开始
      2. 遍历容器：
         - 属性：
           - items：容器对象
           - var：容器中元素的临时变量
           - varStatus：循环状态对象
             - index：容器中元素的索引，从0开始
             - count：循环次数，从1开始





## MVC

*开发模式*

1. M：Model，模型。JavaBean
    * 完成具体的业务操作（pojo、dao、service），如：查询数据库，封装对象
2. V：View，视图。JSP
  * 展示数据
3. C：Controller，控制器。Servlet
   * 获取用户的输入
   * 调用模型
   * 将数据交给视图进行展示





## Filter：过滤器

1. 概念：

   - web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊的功能。
   - 过滤器的作用：一般用于完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤···

2. 步骤：

   1. 定义一个类，实现接口 Filter
   2. 复写方法
   3. 配置拦截路径
      1. web.xml
      2. 注解

3. 过滤器细节：

   1. web.xml 配置

      ```xml
      <filter>
          <filter-name>demo1</filter-name>
          <filter-class>cn.itcast.web.filter.FilterDemo1</filter-class>
      </filter>
      <filter-mapping>
          <filter-name>demo1</filter-name>
          <!-- 拦截路径 -->
          <url-pattern>/*</url-pattern>
      </filter-mapping>
      ```

   2. 过滤器执行流程：

      1. 执行过滤器
      2. 执行放行后的资源
      3. 回来执行过滤器放行代码下边的资源

   3. 过滤器生命周期方法：

      1. init：在服务器启动后，会创建 Filter 对象，然后调用init方法。只执行一次。用于加载资源。
      2. doFilter：每一次请求被拦截资源时，会执行。执行多次。
      3. destroy：在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源

   4. 过滤器配置详解：

      - 拦截路径配置：
        1. 具体资源路径：`/index.jsp` --- 只有访问index.jsp资源时，过滤器才会被执行
        2. 拦截目录：`/user/*` --- 访问/user下的所有资源时，过滤器都会被执行
        3. 后缀名拦截：`*.jsp` --- 访问所有后缀名为jsp资源时，过滤器都会被执行
        4. 拦截所有资源：`/*` --- 访问所有资源时，过滤器都会被执行
      - 拦截方式配置：
        - 注解配置：
          - 设置 dispatcherTypes 属性
            1. REQUEST：默认值。浏览器直接请求资源
            2. FORWARD：转发访问资源
            3. INCLUDE：包含访问资源
            4. ERROR：错误跳转资源
            5. ASYNC：异步访问资源
        - web.xml 配置：
          - 设置 `<dispatcher></dispatcher>` 标签即可（值同上）
   
   5. 过滤器链（配置多个过滤器）
   
      - 执行顺序：如果有两个过滤器：过滤器1和过滤器2
         1. 过滤器1
         2. 过滤器2
         3. 资源执行
         4. 过滤器2
         5. 过滤器1
      - 过滤器先后顺序问题：
         1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
            - 如：AFilter 和 BFilter，AFilter就先执行了。
         2. web.xml 配置：`<filter-mapping>` 谁定义在上边，谁先执行



- 增强对象的功能：
  - 设计模式：一些通用的解决固定问题的方式
    - 装饰模式
    - 代理模式：
      - 概念：
        1. 真实对象：被代理的对象
        2. 代理对象
        3. 代理模式：代理对象代理真实对象，达到增强真实对象功能的目的
      - 实现方式：
        1. 静态代理：有一个类文件描述代理模式
        2. 动态代理：在内存中形成代理类
           - 实现步骤：
             1. 代理对象和真实对象实现相同的接口
             2. 代理对象 = Proxy.newProxyInstance();
             3. 使用代理对象调用方法
             4. 增强方法
           - 增强方式：
             1. 增强参数列表
             2. 增强返回值类型
             3. 增强方法体执行逻辑





## Listene：监听器

- 事件监听机制：

  - 事件：一件事情
  - 事件源：时间发生的地方
  - 监听器：一个对象
  - 注册监听：将事件、事件源、监听器绑定在一起。当事件源上发生某个事件后，执行监听器代码

- ServletContextListener：监听 ServletContext 对象的创建和销毁

  - 方法：

    - `void contextDestroyed (ServletContextEvent sce)`：ServletContext 对象被销毁之前会调用该方法
    - `void contextInitialized (ServletContextEvent sce)`：ServletContext 对象创建后会调用该方法

  - 步骤：

    1. 定义一个类，实现 ServletContextListener 接口

    2. 复写方法

    3. 配置：

       - web.xml

         ```xml
         <listener>
         	<listener-class>cn.itcast.web.listener.ContextLoaderListener</listener-class>
         </listener>
         ```

         - 指定初始化参数 `<context-param>`

       - 注解

         - @WebListener

