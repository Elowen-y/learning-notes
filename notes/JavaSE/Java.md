# Java 编程基础



## Java 特点

- 平台独立性
- 面向对象
- 简单性
- 安全性
- 多线程
- 健壮性
- 动态性
- 高性能
- 分布式
- 可移植性





## Java的内存需要划分成为5个部分

- 栈(Stack)：存放的都是方法中的局部变量。方法的运行一定要在栈当中运行。
- 堆(Heap)：凡是new出来的东西，都在堆当中。
- 方法区(Method Area)：存储.class相关信息，包含方法的信息。
- 本地方法栈(Native Method Stack)：与操作系统先关。
- 寄存器(pc Register)：与CPU相关。





## 引用数据类型

- 字符串（String）
- 数组（Array）
- 类（Class）
- 接口（Interface）
- Lambda





## 流程控制

- 条件语句（if···else）
- 循环语句（for、foreach、while、do···while）
- 跳转语句（break、continue、return）
- switch 语句（case；default）





## 数组

- 长度不可变
- 数组作为参数，传递的是地址
- 数组作为返回值，返回的也是地址
- 数组索引越界异常：ArrayIndexOutOfBoundsException
- 空指针异常：NullPointerException





## 方法

- 成员变量、成员方法（不要写 static 关键字，普通方法有 static）

- 静态变量、静态方法（不再属于对象自己，而是属于类的）

  - 静态代码块

    ````java
    public class 类名称{
        static{
        	// 静态代码块的内容
        }
    }
    ````

    *当第一次用到本类时，静态代码块执行唯一的一次。*

    **静态代码块比静态方法先执行**





## 重写 and 重载

- 重写（Override）：方法的名称一样，参数列表【也一样】（用于继承 extends 关系）
  - @Override 写在方法前，用于检测是否正确重写
- 重载（Overload）：方法的名称一样，参数列表【不一样】





## 封装

*就是把对象封装成一个类*

1. 隐藏内部状态：外部代码不能直接访问对象的内部变量
2. 提供公共接口：通过公共接口（gettter 和 setter方法）来访问或修改对象的状态





## 继承（extends）

**单继承**，但是可以多级继承

*继承主要解决的问题就是：共性抽取*

- 称呼
  - 父类：基类、超类
  - 子类：派生类
- 访问成员变量（父子类中成员变量可能重名）
  - 直接通过**子类对象**访问成员变量：等号左边是谁，就优先用谁
  - 间接通过成员方法访问成员变量：该方法属于谁，就优先用谁
- 使用变量/方法：
  - 本类：this.变量名
  - 父类：super.变量名
- 创建的对象是谁就是谁
- **子类必须调用父类构造方法**，不写则赠送 `super()`；写了则用的指定的 super 调用，super 只能有一个，还必须是第一个。
- **注意**
  - `this()` 调用也必须是构造方法的第一个语句，唯一一个
  - super 和 this 两种构造调用，不能同时使用





## 多态

*接口、继承*

1. 父类/接口 对象名 = new 子类/实现类();

2. 用多态创建的对象：

   - 成员变量：编译看左边，运行还看左边。

   - 成员方法：编译看左边，运行看右边。

3. 向下转型

   - 不知道原来的对象是谁，用如下代码判断

     `对象 instanceof 类名称` 返回的是 boolean 值





## 抽象类（abstract）

1. 抽象方法：父类当中的方法不知道具体如何实现时，就可以抽象为一个抽象方法。（抽象方法没有大括号方法体{}）
2. 抽象类：抽象方法所在的类必须是抽象类（可以有构造方法）
3. 使用：
   - 不能直接创建 new 抽象类对象，必须用一个子类继承抽象类对象
   - 子类必须重写抽象父类中的所有抽象方法
   - 创建子类对象进行使用





## 接口（interface）

*一个类可以实现多个接口（多实现）*

1. 格式：

```java
public interface 接口名称{
	// 接口内容
}
```

2. 接口中最重要的内容：抽象方法
3. 接口没有静态代码块或者构造方法
4. 如果直接父类当中的方法，和接口当中的默认方法产生了冲突，【优先用父类】当中的方法。（其他形式的方法重复，需要覆盖重写）





## 枚举（enum）



## 权限修饰符

1. Java 中有四种权限修饰符：

   - |                        | public | protected | （default） | private |
     | ---------------------- | ------ | --------- | ----------- | ------- |
     | 同一个类（我自己）     | YES    | YES       | YES         | YES     |
     | 同一个包（我邻居）     | YES    | YES       | YES         | NO      |
     | 不同包子类（我儿子）   | YES    | YES       | NO          | NO      |
     | 不同包非子类（陌生人） | YES    | NO        | NO          | NO      |

     - 注意：(default) 并不是关键字，而是根本不写



## 常用类

### Scanner

System.in 代表从键盘进行输入



### Random

- 获取随机的int数字（范围是 int 所有范围，有正有负）

   `int num = r.nextInt();`

- 获取一个随机的int数字（参数代表范围，左闭右开）

   `int num = r.nextInt(3);`



### Math

*java.util.Math*：提供了大量的静态方法

- static double abs(double num)：获取绝对值。
- static double ceil(double num)：向上取整。
- static double floor(double num)：向下取整。
- static long round(double num)：四舍五入。
- Math.PI 代表近似的圆周率常量（double）



### Object

- toString()方法
  - 重写前：打印的是 包名类名@地址值
  - 重写后：打印的是对象中的属性值
- 对于基本类型来说，==是进行【数值】的比较；对于引用类型来说，==是进行【地址值】的比较
- equals()方法
  - 重写前：比较的是对象的地址值
  - 重写后：比较的是对象的属性值



#### Objects

- **`Objects`** 类中的 equals 方法（两个参数）
  - 比较两个对象是否相同
  - 对两个对象进行比较，防止了空指针异常
- static <T> T requireNonNull(T obj)：查看指定应用对象是不是 null



### Arrays

*java.util.Arrays*：提供了大量的静态方法

- static String toString(数组)：按照默认格式 [元素1,元素2,元素3,...]，返回指定数组内容的字符串表示形式
- static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序
  - 如果是数值，sort默认按照升序从小到大
  - 如果是字符串，sort默认按照字母升序
  - 如果是自定义的类型，那么这个自定义的类需要有 Comparable 或者 Comparator 接口的支持。





## String

*字符串效果上相当于 char[ ] 字符数组，但是底层原理是 byte[ ] 字节数组*

1. 创建字符串：
   - public String(byte[] array)：根据字符数组进行创建
   - public String(char[] array)：根据字节数组进行创建
   - 直接双引号
2. 字符串常量池：直接双引号的字符串在字符串常量池中，new 的不在池中
3. 字符串的比较：
   - 对于基本类型来说，== 是进行【数值】的比较
   - 对于引用类型来说，== 是进行【地址值】的比较
     - String 是引用数据类型，进行字符串内容比较的方法：
       - public boolean equals(Object object)：只有参数是一个字符串并且内容相同的才返回 true
         - 如果比较双方一个常量，一个变量：推荐 `"abc".equals(str)`，不推荐 `str.equals("abc")`（如果 str 是为空，会出现空指针异常）
       - public boolean equalsIgnoreCase(String str)：忽略大小写，进行内容比较
4. 一些常用方法：
   - 构造方法：
     - String(byte[] bytes)：把字节数组转换为字符串
     - String(byte[] bytes, int offset, int length)：把字节数组的一部分转换为字符串

   - 与获取相关
     - int length()
     - String concat(String str)：字符串拼接
     - char charAt(int index)：获取指定索引位置的单个字符（索引从0开始）
     - int indexOf(String str)：查找参数字符串在本字符串中首次出现的索引位置，如果没有返回 -1
   - 截取方法
     - String substring(int index)：截取从参数位置一直到字符串末尾的字符串并返回
     - String substring(int begin,int end)：截取从 begin 开始到 end 结束的字符串并返回，范围 [begin, end)
   - 与转换相关
     - char[] toCharArray()：将当前字符串拆分成为字符数组
     - byte[] getBytes()：获得当前字符串底层的字节数组
     - String replace(CharSequence oldString,CharSequence newString)：将所有出现的老字符串替换为新的字符串，并返回（CharSequence 可以接受字符串）
   - 分割字符串
     - String[] split(String regex)：按照参数的规则，将字符串切分为若干部分
       - 参数其实是一个正则表达式。
       - 如果按照英文句点 “.” 进行切分，必须写 “\\\\.”（两个反斜杠）
   - 其他
     - boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     - 基本类型 --> 字符串的静态方法
       - static String toString(int i)
       - static String valueOf(int i)
     - 字符串 --> 基本类型的静态方法
       - parseXxx("字符串")：如 `static int parseInt(String s)`




### StringBuilder

*java.lang.StringBuilder*：字符串缓冲区（可以看成一个长度可以变化的字符串）

1. 底层也是一个数组，但是没有被final修饰，可以改变长度 `byte[] value = new byte[16];`

2. StringBuilder在内存中始终是一个数组，如果超出了StringBuilder的容量，会自动扩容。
3. 构造方法
   - StringBuilder()：构造一个空的StringBuilder容器。
   -  StringBuilder(String str)：构造一个StringBuilder容器，并将字符串添加进去。
4. 成员方法
   - StringBuilder append(Object obj)：添加内容
     - 参数可以是任意的数据类型
   - StringBuilder reverse()：反转内容
   - String toString()：将当前StringBuilder对象转换为String对象
5. StringBuilder 和 String 相互转换：
   - String -> StringBuilder：可以使用StringBuilder的构造方法
     - StringBuilder(String str)
   - StringBuilder -> String：可以使用StringBuilder中的 toString 方法
     - String toString()
6. 链式编程：方法的返回值是一个对象，可以根据对象继续使用方法。（比如append方法）





## 日期时间



### Data

*java.util.Date*：精确到毫秒

1. 时间原点：1970 年 1 月 1 日 00:00:00 
   - 注意：中国属于东八区，会把时间增加8个小时。1970 年 1 月 1 日 08:00:00
2. 构造方法
   - Date()：根据当前系统创建日期对象
   - Date(long date)：根据传入的毫秒值时间创建日期对象
3. 成员方法
   - long getTime()：获取当前日期对象的毫秒值时间（相当于 `System.currentTimeMillis()`）



### DateFormat

*java.text.DateFormat*：日期/时间格式化子类的【抽象类】

作用：格式化（也就是日期 -> 文本）、解析（文本 -> 日期）

1. 成员方法

   *需要先 `SimpleDateFormat sdf = new SimpleDateFormat(String pattern)`,进行对象的创建，然后才能使用下面的方法！*

   - String format(Date date)：根据指定格式，格式化日期对象
   - Date parse(String source)：根据指定格式解析字符串

2. DateFormat 是一个抽象类，无法直接创建对象使用，可以使用 DateFormat 的子类 SimpleDateFormat（java.text.SimpleDateFormat extends DateFormat）

   - **SimpleDateFormat**
     - 构造方法：
       - SimpleDateFormat(String pattern)：根据指定模版创建日期格式化对象
         - 参数：
           - String pattern：传递指定的模式
         - 模式：区分大小写的
           - y	年
           - M   月
           - d    日
           - H    时
           - m   分
           - s     秒
         - "yyyy-MM-dd HH-mm-ss" ---> “yyyy年MM月dd HH时mm分ss秒”
           - 连接模式的符号可以改变



### Calendar

*java.util.Calendar*：日历【抽象类】

1. Calendar 类中有一个静态方法 getInstance()（`static Calendar getInstance()`），该方法返回了 Calendar 类的子类对象

   - ```java
     Calendar c = new Calendar.newInstance();	// 获取日历类对象（多态）
     ```

2. 成员方法：

   - int get(int field)：返回指定日历字段的值。
   - void set(int field, int value)：将指定日历字段设置为指定值。（可单独设置，也可同时设置）
   - abstract void add(int field, int amount)：将指定的日历字段增加或减少指定的值。
   - Date getTime()：把日历对象转换为日期对象
     - 参数：
       - int field：日历类的字段，可以使用Calendar类的【静态成员变量】获取。
         - YEAR、MONTH、DATE、DAY_OF_MONTH、HOUR、MINUTE、SECOND





## System

*java.lang.System*：提供了大量的静态方法

- static long currentTimeMillis()：获取当前系统毫秒值时间
- static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
  - 参数：
    - src 		   - 源数组。
    - srcPos 	 - 源数组中的起始位置。
    - dest 	     - 目标数组。
    - destPos    - 目标数据中的起始位置。
    - length 	  - 要复制的数组元素的数量。





## 集合类

Collection是单列集合，Map集合是双列集合

Collection 接口

 - List接口：（有序、可以存储重复元素、可以保证存取顺序）
   - Vector 集合（单线程的，被 ArrayList 取代了）
   - ArrayList 集合
   - LinkedList集合
 - Set接口：（无序、不可以存储重复元素、存取无序）
   - TreeSet集合：无序的集合
   - HashSet集合：无序的集合
     - LinkedHashSet集合：有序的集合

Map 接口

- HashMap
  - LinkedHashMap
- Hashtable（被 HashMap 取代了）
  - Properties extends Hashtable：Properties 集合是唯一和 IO 流相结合的集合



### Collection 接口

*java.util.Collection*：所有**单列集合**的最顶层的接口，里边定义了所有单列集合共性的方法

- boolean add(E e)：向集合中添加元素
- void clear()：清空集合所有的元素
- boolean remove(E e)：删除集合中的某个元素
- boolean contains(E e)：判断集合中是否包含某个对象
- boolean isEmpty()：判断集合是否为空
- int size()：获取集合的长度
- Object[] toArray()：将集合转成一个数组



#### Iterator 接口

*java.util Iterator*：迭代器（对集合进行遍历）

1. 常用方法：

   - boolean hasNext()：判断集合中还有没有下一个元素，有就返回true

   - E next()：取出集合中的下一个元素

2. Iterator 接口的实现类对象获取：Collection 接口中的一个方法 `iterator()`

3. 迭代器的使用步骤：

   1. 使用集合中的方法 `iterator()` 获取迭代器的实现类对象，使用 Iterator 接口接收（多态）

      ```java
      Collection<String> coll = new ArrayList<>();
      Iterator<String> it = coll.iterator();
      ```

   2. 使用方法 `hasNext()` 判断还有没有下一个元素
   3. 使用方法 `next()` 取出集合中的下一个元素

4. 增强 for 循环：简化迭代器

   - `public interface Collection<E> extends Iterable<E>`：所有的单列集合都可以使用增强 for 循环
   - `public interface Iterable<T>`：实现这个接口允许对象成为 "foreach" 语句的目标



#### Collections

*java.utils.Collections*：集合工具类，用来对集合进行操作

- static <T> boolean addAll(Collection<? super T> c, T... elements)：往集合中添加一些元素。

- static void shuffle(List<?> list)：会随机打乱集合中元素的顺序

- static <T> void sort(List<T> list)：将集合中元素按照默认规则顺序排序

  - sort(List<T> list)使用前提：被排序的集合里边存储的元素，必须实现 Comparable，重写接口中的方法 compareTo 定义排序的规则

    ```java
    public class Person implements Comparable<Person>{
    	// 重写compareTo方法，定义排序的规则：自己(this)-参数：升序
    }
    ```

- static <T> void sort(List<T> list, Comparator<? super T> c)：将集合中元素按照指定规则排序

  - 重写接口中的方法 compare
  - Comparator 排序规则：o1-o2：升序




### List 接口

*java.util.List extends Collection*

- void add(int index, E element)：在列表的指定位置插入指定元素。
- E get(int index)：返回列表中指定位置的元素。
- E remove(int index)：移除列表中指定位置的元素。
- E set(int index, E element)：用指定元素替换列表中指定位置的元素。



#### ArrayList

1. `ArrayList<E> obj = new ArrayList<E>();`
   - 长度可变
   - <E> 代表泛型，只能是引用类型
   - 直接打印 ArrayList 得到的不是地址值，而是内容
     - 内容为空，则得到 []
   - 如果想向集合ArrayList当中存储基本类型数据，必须使用基本类型对应的 “包装类”。
     - int --- Integer
     - char --- Character
2. 常用方法：
   - boolean add(E e)：向集合当中添加元素，参数的类型和泛型一致。
   - E get(int index)：从集合当中获取元素，参数是索引编号，返回对应位置的元素。
   - E remove(int index)：从集合当中删除元素，参数是索引编号，返回被删除掉的元素。
   - int size()：返回集合中包含的元素个数。



#### LinkedList

*java.util.LinkedList implements List*：里面有大量的操作首尾元素的方法

**使用LinkedList集合特有的方法，不能使用多态**

- void addFirst(E e)：将指定元素插入此列表的开头
- void addLast(E e)：将指定元素添加到此列表的结尾
- void push(E e)：将元素推入此列表所表示的堆栈【等效于 addFirst()】

- E getFirst()：返回此列表的第一个元素
- E getLast()：返回此列表的最后一个元素
- E removeFirst()：移除并返回此列表的第一个元素
- E removeLast()：移除并返回此列表的最后一个元素
- E pop()：从此列表所表示的堆栈处弹出一个元素【等效于removeFirst()】
- boolean isEmpty()：如果列表不包含元素，则返回true



### Set 接口

*java.util.Set extends Collection*



#### HashSet

*java.util.HashSet implements Set*：底层是一个哈希表结构（查询速度非常快）

1. 哈希表：数组+链表/红黑树
   - 哈希值是一个十进制的整数，由系统随机给出（就是对象的地址值，是一个逻辑地址，是模拟出来得到的地址，不是数据实际存储到物理地址）
   - Object 类有一个方法，可以获取对象的哈希值
     - int hashCode()：返回对象的哈希码值。
2. **set集合存储不重复的元素：存储的元素必须重写 hashCode 方法和 equals 方法**
   - Set集合在调用 add 方法的时候，add 方法会调用元素的【hashCode 方法和 equals 方法】，判断元素是否重复
   - 存储自定义元素：存储的元素必须重写 hashCode 方法和 equals 方法



##### LinkedHashSet

*java.util.LinkedHashSet extends HashSet*：底层是一个哈希表（数组+链表/红黑树）+ 链表：多了一条链表（记录元素的存储顺序），保证元素有序



### Map 接口

*java.utils.Map<k,v>*

1. Map<k,v>接口：

   - 包含两个值（key, value）

   - key 不允许重复，value 可以重复

   - key 和 value 是一一对应的

2. 成员方法

   - V put(K key, V value)：把指定的键与指定的值添加到Map集合中
     - key 不重复，返回值 V 是null
     - key 重复，会使用新的 value 替换 Map 中重复的 value，返回被替换的 value 值
   - V remove(Object key)：把指定的键和键所对应的元素在Map集合中删除，返回被删除元素的值
     - key 存在，v 返回被删除的值
     - key 不存在，v 返回 null
   - V get(Object key)：根据指定的键，在Map集合中获取对应的值
   - boolean containsKey(Object key)：判断集合中是否包含指定的键
   - Set<K> keySet()：把 Map 集合中的所有 key 取出来，存储到一个 Set 集合中
   - Set<Map.Entry<K,V>> entrySet()：把 Map 集合中的 Entry 对象取出来，存储到一个Set集合中

3. Map 集合的两种遍历方式

   1. 通过键找值的方式：`Set<K> keySet()`
      - 实现步骤：
        1. 使用方法 `keySet()`，把 Map 集合中的所有 key 取出来，存储到一个 Set 集合中
        2. 遍历 set 集合，获取 Map 集合中的每一个 key
        3. 使用 Map 中的方法 `get(key)`，通过 key 找到 value
   2. 使用Entry对象遍历：`Set<Map.Entry<K,V>> entrySet()`
      - 实现步骤：
        1. 使用方法 `entrySet()`，把 Map 集合中的 Entry 对象取出来，存储到一个 Set 集合中
        2. 遍历Set集合，获取每一个Entry对象
        3. 使用 Entry 对象中的方法 `getKey()` 和 `getValue()` 获取键与值



#### HashMap

*java.util.HashMap<K,V> implements Map<K,V>*：无序

- HashMap 存储自定义类型键值：保证 key 元素唯一（同 HashSet 一样）
  - **作为 key 的元素，必须重写 hashCode 方法和 equals 方法，以保证 key 唯一**



##### LinkedHashMap

*java.util.LinkedHashMap<K,V> extends HashMap<K,V>*：有序





## 泛型、可变参数

```
T ：代表一般的任何类。
E ：代表 Element 元素的意思，或者 Exception 异常的意思。
K ：代表 Key 的意思。
V ：代表 Value 的意思，通常与 K 一起配合使用。
S ：代表 Subtype 的意思，文章后面部分会讲解示意。
```

1. 泛型定义格式：

   - 泛型类：

     ```java
     public class 类名<泛型>
     ```

   - 泛型方法：

     ```java
     public <泛型> 返回值类型 方法名(使用泛型的参数列表)
     ```

   - 泛型接口：

     ```java
     public interface 接口名<泛型>{}
     ```

2. 泛型是没有继承概念的；但是数据具备继承性

3. 可变参数

   - 使用条件：数据类型确定，参数个数不确定
   - 格式：`修饰符 返回值类型 方法名(数据类型...变量名){}`
   - 注意：
     - 一个方法的参数列表只能有一个可变参数；
     - 如果方法参数有多个，那么可变参数必须写在参数列表的末尾





## 注解

1. JDK 中预定义的一些注解：

   - @Override：检测被该注解标注的方法是否是继承自父类（接口）的
   - @Deprecated：该注解标注的内容，表示已过时
   - @SuppressWarnings：压制警告
     - 一般传递参数all；@SuppressWarnings("all")

2. 自定义注解

   - 格式：

     ```java
     元注解
     public @interface 注解名称 {}
     ```

   - 本质：注解本质上就是一个接口，该接口默认继承 Annotation 接口

     - `public interface 注解名称 extends java.lang.annotation.Annotation {}`

   - 属性：接口中的抽象方法

     - 要求：
       1. 属性的返回值类型
          - 基本数据类型
          - String
          - 枚举
          - 注解
          - 以上类型的数组
       2. 定义了属性，在使用时需要给属性赋值
          1. 如果定义属性时，使用 `default` 关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
          2. 如果只有一个属性需要赋值，并且属性的名称是 value，则 value 可以省略，直接定义值即可。
          3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}省略。

   - 元注解：用于描述注解的注解

     - @Target：描述注解能够作用的位置
       - ElementType取值：
         - TYPE：可以作用于类上
         - METHOD：可以作用于方法上
         - FIELD：可以作用于成员变量上

     - @Retention：描述注解被保留的阶段
       - `@Retention(RetentionPolicy.RUNTIME)`：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到

     - @Documented：描述注解是否被抽取到api文档中

     - @Inherited：描述注解是否被子类继承

3. 在程序中使用（解析）注解：获取注解中定义的属性值

   1. 获取注解定义的位置的对象（Class，Method，Field）

   2. 获取指定的注解

      - `getAnnotation(Class)`

        ```java
        // 其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
        	public class ProImpl implements Pro{
        		public String className(){
        			return "www.wang.demo05annotation.Demo1";
        		}
        		public String methodName(){
        			return "show";
        		}
        	}
        */
        ```

   3. 调用注解中的抽象方法获取配置的属性值





## 异常处理



### Throwable

*java.lang.Throwable*：Java 语言中所有错误或异常的超类

- Exception：编译期异常
  - RuntimeException：运行期异常
    - NullPointerException 运行期异常
    - ArrayIndexOutOfBoundsException 运行期异常

- Error：错误



- 异常处理的方法：
  - String getMessage()：返回此 throwable 的简短描述
  - String toString()：返回此 throwable 的详细消息字符串
  - void printStackTrace()：JVM打印异常对象，默认此方法，打印的异常信息是最全面的



### throw 关键字

- `throw new xxxException("异常产生的原因");`
- 注意：
  - throw 关键字后边 new 的对象必须是 Exception 或者 Exception 的子类对象
  - throw 关键字抛出指定的异常对象，我们就必须处理这个异常对象
    - throw 关键字后边创建的是 RuntimeException 或者是 RuntimeException 的子类对象，我们可以不处理，默认交给JVM处理（打印异常对象，中断程序）
    - throw 关键字后边创建的是编译异常，我们就必须处理这个异常，要么 `throws`，要么 `try...catch`



### throws 关键字

*异常处理的第一种方式 --- 交给别人处理*

- 会把异常对象声明抛出给方法的调用者处理（自己不处理，给别人处理），最终交给JVM处理-->中断处理

```java
修饰符 返回值类型 方法名(参数列表) throws AAAException,BBBException...{
	throw new AAAException("产生原因");
	throw new BBBException("产生原因");
	...
}
```

- 注意：
  - throws 关键字后边声明的异常必须是 Exception 或者是 Exception 的子类



### try...catch

*异常处理的第二种方式，自己处理异常*

```java
try{
	可能产生的异常
}catch(定义一个异常的变量，用来接收try中抛出的异常对象){
	异常的处理逻辑，产生异常对象之后，怎么处理异常对象
	一般在工作中，会把异常的信息记录到一个日志中
}
···
catch(异常类名 变量名){
}
```

注意：

- 如果try中产生了异常，那么就会执行catch中的异常处理逻辑，执行完毕catch中的处理逻辑，继续执行try...catch之后的代码
- 如果try中没有产生了异常，那么就不会执行catch中的异常处理逻辑，执行完try中的代码，继续执行try...catch之后的代码



### finally 代码块

```java
try{
	可能产生的异常
}catch(异常类名 变量名){
}
···
catch(异常类名 变量名){

}finally{
	无论是否出现异常都会执行
}
```

注意：

- finally 不能单独使用，必须和try一起使用
- **finally 一般用于资源释放**（资源回收），无论程序是否出现异常，最后都要资源释放（IO）
- 如果finally有return语句，永远返回finally中的结果，**避免该情况**



多个异常的使用捕获注意：

- 多个异常分别处理
- 多个异常一次捕获，多次处理（一个 try 多个 catch）
  - catch 里边定义的异常变量，如果有子父类关系，那么子类的异常变量必须写在上边，否则会报错
- 多个异常一次捕获一次处理
  - 运行时异常被抛出可以不处理（即不捕获也不声明抛出）。默认给虚拟机处理，终止程序，什么时候不抛出运行时异常了，再来继续执行程序



子父类的异常（父类异常什么样，子类异常就什么样）

- 如果父类抛出了多个异常，子类重写父类方法时，抛出和父类相同的异常或者是父类异常的子类或者不抛出异常
- 父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生异常，只能捕获处理，不能声明抛出



### 自定义异常类

```java
public class XXXException extends Exception | RuntimeException {
    // 添加一个空参数的构造方法
    public XXXException(){
    	super();
    }

    // 添加一个带异常信息的构造方法
    // 查看源码发现，所有的异常类都会一个带异常信息的构造方法，方法内部会调用父类带异常信息的构造方法，让父类来处理这个异常信息
    public XXXException(String message){
        super(message);
    }
}
```

注意：

- 自定义异常类必须得继承 `Exception` 或者 `RuntimeException`
- 继承`Exception`：那么自定义的异常类就是一个**编译期异常**，如果方法内部抛出了编译期异常，就必须处理这个异常，**要么 `throws`，要么 `try···catch`**
- 继承 `RuntimeException`：那么自定义的异常就是一个**运行期异常，无需处理**，交给虚拟机处理（中断处理）





## 多线程



### 概念

1. 并发与并行
   - 并发：交替执行
   - 并行：同时执行
2. 进程和线程
   - 进程：进入到内存的程序叫进程
   - 线程：属于进程，是进程中的一个执行单元，负责程序的执行
3. 一个进程中可以并发多个线程，每条线程并行执行不同的任务。
4. 线程调度：有两种调度模型
   - 分时调度
   - 抢占式调度



### 创建多线程程序的两种方式

#### 创建 Thread 类的子类

*java.lang.Thread*：描述线程的类，想要实现多线程程序，就必须继承 Thread 类

1. 实现步骤：

   1. 创建一个Thread类的子类
   2. 在Thread类的子类中重写Thread类中的 `run` 方法，设置线程任务（开启线程要做什么）
   3. 创建Thread类的子类对象
   4. 调用Thread类中的方法 `start` 方法，开启新的线程，执行 `run` 方法
      - void start()：使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
      - 结果是两个线程并发地运行；当前线程（main线程）和另一个线程（创建的新线程，执行其 run 方法）。
      - 多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
      - java 程序属于抢占式调度，哪个线程的优先级高，哪个线程优先执行；同一个优先级，随机选择一个执行

2. Thread 类中的方法：

   - 获取线程的名称：

     - String getName()：返回该线程的名称
     - static Thread currentThread()：返回对当前正在执行的线程对象的引用
       - 可以先获取到当前正在执行的线程，使用线程中的方法 `getName()` 获取正在执行的线程的名字

   - 设置线程的名称：

     - void setName(String name)：改变线程名称，使之与参数 name 相同

     - 创建一个带参数的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类（Thread）给子类线程起一个名字

       ```java
       public class MyThread extends Thread {
       
           public MyThread(){}
       
           public MyThread(String name){
               super(name);
           }
       
           @Override
           public void run() {
               // 获取线程的名称
               System.out.println(Thread.currentThread().getName());
           }
       }
       ```

   - static void sleep(long millis)：使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）；毫秒数结束之后，线程继续执行



#### 实现Runnable接口

*java.lang.Runnable*

1. 实现步骤：
   1. 创建一个Runnable接口的实现类
   2. 在实现类中重写Runnable接口的 `run` 方法，设置线程任务
   3. 创建一个Runnable接口的实现类对象
   4. 创建 `Thread` 类对象，构造方法中传递Runnable接口的实现类对象
      - Thread(Runnable target)：分配新的 Thread 对象
      - Thread(Runnable target, String name)：分配新的 Thread 对象
   5. 调用Thread类中的 `start` 方法，开启新的线程，执行 `run` 方法
2. 实现了Runnable接口创建多线程程序的好处：
   1. 避免了单继承的局限性
      - 一个类只能继承一个类，类继承了Thread类就不能继承其他的类
      - 实现Runnable接口，还可以继承其他的类，实现其他的接口
   2. 增强了程序的扩展性，降低了程序的耦合性（解耦）
      - 实现Runnable接口的方式，把设置线程任务和开启新线程进行了分离（解耦）
        - 实现类中，重写了run方法：用来设置线程任务
        - 创建Thread类对象，调用start方法：用来开启新线程



### 解决线程安全问题

#### 使用同步代码块

```java
synchronized(锁对象){
	可能会出现线程安全问题的代码(访问了共享数据的代码)
}
```

注意：

- 锁对象可以使用任意对象
- 必须保证多个线程使用的锁对象是同一个
- 锁对象作用：把同步代码块锁住，只让一个线程在同步代码块中执行



#### 使用同步方法

使用步骤：

1. 把访问了共享数据的代码抽取出来，放到一个方法中
2. 在方法上添加 `synchronized` 修饰符

```java
修饰符 synchronized 返回值类型 方法名(参数列表){
	可能会出现线程安全问题的代码(访问了共享数据的代码)
}
```

3. 锁对象：
   1. 同步方法的锁对象：实现类对象 `new RunnableImpl()`，也就是 `this`
   2. 静态同步方法的锁对象：本类的class属性 --> class文件对象，即 `RunnableImpl.class`
      - 不能是this，this是创建对象之后产生的，静态方法优先于对象



#### 使用 Lock 锁

*java.util.concurrent.locks.Lock 接口*：Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作

1. Lock接口中的方法：
   - void lock()：获取锁
   - void unlock()：释放锁
     - 一般释放锁写在 `finally` 代码块里
2. **ReentrantLock**（显式锁）：*java.util.concurrent.locks.ReentrantLock implements Lock*
   - 使用步骤：
     1. 在成员方法位置创建一个 `ReentrantLock` 对象
     2. 在可能会出现安全问题的代码前调用Lock接口中的方法 `lock()` 获取锁
     3. 在可能会出现安全问题的代码后调用Lock接口中的方法 `unlock()` 释放锁
3. 线程状态：
   - NEW（新建状态）
   - ‌RUNNABLE（可运行状态）
   - BLOCKED（阻塞状态）
   - ‌WAITING（等待状态）
   - ‌TIMED_WAITING（超时等待）
   - ‌TERMINATED（终止状态）



### 等待唤醒机制

- **同步使用的锁对象必须保证唯一**
- **只有锁对象才能调用 `wait` 和 `notify` 方法**

1. Object 类中的方法：

   - void wait()：在其他线程调用此对象的 `notify()` 方法或 `notifyAll()` 方法前，导致当前线程等待。

   - void notify()：唤醒在此对象监视器上等待的单个线程。会继续执行 `wait()` 方法之后的代码

2. 进入到 TimeWaiting（计时等待）有两种方式：

   - 使用 `static void sleep(long m)`（静态方法，直接 `Thread.sleep(m);` 调用）方法，在毫秒值结束之后，线程睡醒进入到 Runnable / Blocked 状态
   - 使用 `wait(long m)` 方法，wait 方法如果在毫秒值结束之后，还没有被 notify 唤醒，就会自动醒来，线程睡醒进入到 Runnable / Blocked 状态

3. 唤醒的方法：

   - void notify()：唤醒在此对象监视器上等待的**单个**线程。
   - void notifyAll()：唤醒在此对象监视器上等待的**所有**线程。



### 线程池

1. *java.util.concurrent.Executors*：线程池的工厂类，**用来生成线程池**
   - Executors类中的静态方法：
     - static ExecutorService newFixedThreadPool(int nThreads)：创建一个可重用固定线程数的线程池。
2. *java.util.concurrent.ExecutorService*：线程池接口，**用来从线程池中获取线程**，调用start方法，执行线程任务
   - submit(Runnable task)：提交一个 Runnable 任务用于执行
   - void shutdown()：关闭/销毁线程池
3. 线程池的使用步骤：
   1. 使用线程池的工厂类 `Executors` 里边提供的静态方法 `newFixedThreadPool()` 生产一个指定线程数量的线程池
   2. 创建一个类，实现Runnable接口，重写run方法，设置线程任务
   3. 调用ExecutorService中的方法 `submit()`，传递线程任务（步骤 2 中的实现类），开启线程，执行run方法
   4. 调用ExecutorService中的方法 `shutdown()` 销毁线程池（不建议执行）





## IO 流



### File 类

*java.io.File：File类是一个与系统无关的类，任何操作系统都可以使用这个类中的方法*

- file 文件
- directory 文件夹/目录
- path 路径



1. File 类的字段
   - static String pathSeparator：与系统有关的路径分隔符，为了方便，它被表示为一个字符串。另一个方法是 static char pathSeparatorChar
     - 路径分隔符：
       - windows：分号 ;
       - linux：冒号 :
   - static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。另一个方法是 static char separatorChar
     - 文件名称分隔符：
       - windows：反斜杠 \
       - linux：正斜杠 /
2. 路径：
   - 绝对路径：完整的路径
   - 相对路径：简化的路径
     - 注意：
       1. 路径是不区分大小写的
       2. 路径中的文件名称分隔符windows使用反斜杠，反斜杠是一个转义字符，两个反斜杠代表一个普通的反斜杠
3. 构造方法：
   - File(String pathname)
   - File(String parent, String child)
   - File(File parent, String child)
     - 路径可以是以文件结尾，也可以是以文件夹结尾
     - 创建 File 对象，只是把字符串路径封装为 File 对象，不考虑路径的真假情况
4. 成员方法：
   - File类**获取**功能的方法：
     - String getAbsolutePath()：返回绝对路径。
     - String getPath() 返回构造方法中传递的路径。（`toString()` 方法调用的就是 `getPath()` 方法）
     - String getName()：返回构造方法中传递的路径传递的结尾部分。
     - long length()：返回构造方法指定文件的大小，以字节为单位。
       - 文件夹没有大小概念，不能获取文件夹的大小
       - 如果构造方法中给出的路径不存在，那么length方法返回 0
   - File类**判断**功能的方法：
     - boolean exists()：用于判断构造方法中的路径是否存在
     - boolean isDirectory()：用于判断构造方法中给定的路径是否是以文件夹结尾
     - boolean isFile()：用于判断构造方法中给定的路径是否是以文件结尾
   - File类**创建删除**功能的方法：
     - boolean createNewFile()：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
       - 创建文件的路径和名称在构造方法中给出（构造方法的参数）【只能创建文件，不能创建文件夹】【路径不存在会抛异常】
     - boolean delete()：删除构造方法路径中给出的文件/文件夹
       - 直接在硬盘上删除文件/文件夹，不走回收站，删除要谨慎
     - boolean mkdir()：创建单级**文件夹**
     - boolean mkdirs()：既可以创建单级文件夹，也可以创建多级**文件夹**
       - 只能创建文件夹，不能创建文件（路径不存在是不会创建的，不会抛异常）
   - File类**遍历**（文件夹）目录功能：
     - String[] list()：遍历构造方法中给出的目录，返回一个String数组
     - File[] listFiles()：遍历构造方法中给出的目录，返回一个File数组
       - 如果构造方法中给出的目录的路径错误，会抛出空指针异常



#### 过滤器

*在File类中有两个和 `listFiles()` 重载的方法，方法的参数传递的就是过滤器*

1. File[] listFiles(FileFilter filter)
   - `java.io.FileFilter` 接口：用于抽象路径名（File对象）的过滤器。
     - 作用：用来过滤文件（File 对象）
     - 抽象方法：用来过滤文件的方法
       - boolean accept(File pathname)：定义过滤的规则
         - 参数：
           - File pathname：使用 `listFiles()` 方法遍历目录，得到的每一个文件对象
2. File[] listFiles(FilenameFilter filter)
   - `java.io.FilenameFilter` 接口：实现此接口的类实例可用于过滤器文件名
     - 作用：用于过滤文件名称
     - 抽象方法：用来过滤文件的方法
       - boolean accept(File pathname)：定义过滤的规则
         - 参数：
           - File dir：构造方法中传递的被遍历的目录
           - String name：使用 `listFiles()` 方法遍历目录，获取的每一个文件 / 文件夹名称
3. 注意：两个过滤器接口是没有实现类的，需要我们自己写实现类，重写过滤的方法 **`accept()`** ，在方法中定义过滤的规则



### IO流

*硬盘是永久存储的，内存是临时存储*

i（input）输入（读取）：把硬盘中的数据，读取到内存中使用

o（output）输出（写入）：把内存中的数据，写入到硬盘中保存

|        | 输入流      | 输出流       |
| ------ | ----------- | ------------ |
| 字节流 | InputStream | OutputStream |
| 字符流 | Reader      | Writer       |



#### 字节流

**`java.io.OutputStream`**：字节输出流；抽象类

1. 成员方法：

   - void close()：关闭此输出流并释放与此流有关的所有系统资源。

   - void flush()：刷新此输出流并强制写出所有缓冲的输出字节。

2. 一次写多个字节的方法：

   - void write(byte[] b)：将 b.length 个字节从指定的 byte 数组写入此输出流。
   - void write(byte[] b, int off, int len)：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
     - 如果写的第一个字节是正数（ 0~127 ），那么显示的时候会查询ASCII码表
     - 如果写的第一个字节是负数，那第一个字节会和第二个字节，两个字节组合一个中文显示，查询系统默认码表

3. abstract void write(int b)：将指定的字节写入此输出流。

4. 写入字符串的方法：可以使用String类中的方法，把字符串转换为字节数组

   - byte[] getBytes()：把字符串转换为字节数组



**`java.io.FileOutputStream extends OutputStream`**：文件字节输出流

作用：把内存中的数据写入到硬盘的文件中。

1. 构造方法：
   - FileOutputStream(File file)：创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
   - FileOutputStream(String name)：创建一个向具有指定名称的文件中写入数据的输出文件流。
     - 参数：写入数据的目的地
       - File file：目的地是一个文件
       - String name：目的地是一个文件的路径
   - 追加写 / 续写：使用两个参数的构造方法
     - FileOutputStream(String name, boolean append)：创建一个向具有指定 name 的文件中写入数据的输出文件流。
     - FileOutputStream(File file, boolean append)：创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
       - 参数：
         - boolean append：追加写开关
           - true：创建对象不会覆盖原文件，继续在文件的末尾追加写数据
           - false：创建一个新文件，覆盖原文件
       - 写换行：写换行符号
         - windows：\r\n
         - linux：/n
         - mac：/r
2. 构造方法的作用：
   1. 创建一个 FileOutputStream 对象
   2. 会根据构造方法中传递的文件 / 文件路径，创建一个空的文件
   3. 会把 FileOutputStream 对象指向创建好的文件
3. 字节输出流的使用步骤：
   1. 创建一个 FileOutputStream 对象，构造方法中传递写入数据的目的地
   2. 调用 FileOutputStream 对象中的方法 `write`，把数据写入到文件中
   3. 释放资源（流使用会占用一定的内存，使用完毕要把内存清空，提高程序的效率）



**`java.io.InputStream`**：字节输入流；抽象类

1. 方法：
   - int read()：从输入流中读取数据的下一个字节。读取到文件的末尾返回-1
   - int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
     - byte[]：数组的长度一般定义为1024或者1024的整数倍
     - 返回值int：每次读取的有效字节个数
   - void close()：关闭此输入流并释放与该流关联的所有系统资源



**`java.io.FileInputStream extends InputStream`**：文件字节输入流

作用：把硬盘文件中的数据，读取到内存中使用

1. 构造方法：
   - FileInputStream(File file)
   - FileInputStream(String name)
     - 参数：读取文件的数据源
       - File file：文件
       - String name：文件的路径
2. 构造方法的作用：
   1. 会创建一个 FileInputStream 对象
   2. 会把 FileInputStream 对象指向构造方法中要读取的文件
3. 字节输入流的使用步骤：
   1. 创建FileInputStream对象，构造方法中绑定要读取的数据源
   2. 使用FileInputStream对象中的方法read，读取文件
   3. 释放资源



释放资源：先关写的，后关读的，如果写完了，肯定读取完毕了

​		释放资源时，应判断是否为空，若为空，则会出现空指针异常；不为空则释放。

使用字节流读取中文文件会产生乱码



#### 字符流

**`java.io.Reader`**：字符输入流；抽象类

1. 成员方法：
   - int read()：读取单个字符并返回。
   - int read(char[] cbuf)：一次读取多个字符，将字符读入数组。
   - void close()：关闭该流并释放与之关联的所有资源。



**`java.io.FileReader extends InputStreamReader extends Reader`**：文件字符输入流

作用：把硬盘文件中的数据以字符的方式读取到内存中

1. 构造方法：
   - FileReader(File file)
   - FileReader(String fileName)
     - 参数：
       - File file：文件
       - String fileName：文件的路径



**`java.io.Writer`**：字符输出流；抽象类

1. 成员方法：
   - void write(int c)：写入单个字符。
   - void write(char[] cbuf)：写入字符数组。
   - abstract void write(char[] cbuf, int off, int len)：写入字符数组的某一部分。
   - void write(String str)：写入字符串。
   - void write(String str, int off, int len)：写入字符串的某一部分。
   - void close()：关闭此流，但要先刷新它。
   - void flush()：刷新该流的缓冲。



**`java.io.FileWriter extends OutputStreamWriter extends Writer`**：文件字符输出流

作用：把内存中字符数据写入到文件中

1. 构造方法：
   - FileWriter(File file)
   - FileWriter(String fileName)
     - 参数：写入数据的目的地
       - File file：是一个文件
       - String fileName：文件的路径
   - 续写，追加写：使用两个参数的构造方法
     - FileWriter(File file, boolean append)
     - FileWriter(String fileName, boolean append)
2. 字符输出流的使用步骤：（与字节输出流有区别：把数据写入内存中(不是直接写到文件)，然后再用 `flush` 或者 `close` 刷新到文件）
   1. 创建FileWriter对象，构造方法中绑定要写入数据的目的地
   2. 使用FileWriter中的方法 `write`，把数据写入到内存缓冲区中（字符转换为字节的过程）
   3. 使用FileWriter中的方法 `flush`，把内存缓冲区中的数据，刷新到文件中
   4. 释放资源（会先把内存缓冲区中的数据刷新到文件中）
3. flush 方法和 close 方法的区别：
   - flush方法：刷新缓冲区，流对象可以继续使用
   - close方法：先刷新到缓冲区，然后通知系统释放资源。流对象不可以再使用。



#### 字节缓冲流

**`java.io.BufferedInputStream extends InputStream`**：字节缓冲输入流

1. 成员方法：
   - int read()：从输入流中读取数据的下一个字节。
   - int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
   - void close()：关闭此输入流并释放与该流关联的所有系统资源。
2. 构造方法：
   - BufferedInputStream(InputStream in)：创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
   - BufferedInputStream(InputStream in, int size)：创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
     - 参数：
       - InputStream in：字节输入流
         - 可以传递FileInputStream，缓冲流会给FileInputStream增加一个缓冲区
       - int size：指定缓冲流内部缓冲区的的大小，不指定默认
3. 使用步骤：
   1. 创建FileInputStream对象，构造方法中绑定要读取的数据源
   2. 创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的读取效率
   3. 使用BufferedInputStream对象中的方法read，读取文件
   4. 释放资源



**`java.io.BufferedOutputStream extends OutputStream`**：字节缓冲输出流

1. 成员方法：
   - void close()
   - void flush()
   - void write(byte[] b)
   - void write(byte[] b, int off, int len)
   - abstract void write(int b)
2. 构造方法：
   - BufferedOutputStream(OutputStream out)：创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
   - BufferedOutputStream(OutputStream out, int size)：创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
     - 参数：
       - OutputStream out：字节输出流
         - 可以传递FileOutputStream，缓冲流会对FileOutputStream增加一个缓冲区，提高FileOutputStream的写入效率
       - int size：指定缓冲流内部缓冲区的的大小，不指定默认
3. 使用步骤：
   1. 创建FileOutputStream对象，构造方法中绑定要输出的目的地
   2. 创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream对象效率
   3. 使用BufferedOutputStream对象中的方法write，把数据写入到内部缓冲区中
   4. 使用BufferedOutputStream对象中的方法flush，把内部缓冲区中的数据，刷新到文件中
   5. 释放资源（会先调用flush方法刷新数据，第4步可省略）



#### 字符缓冲流

**`java.io.BufferedReader extends Reader`**：字符缓冲输入流

1. 成员方法：
   - int read()
   - int read(char[] cbuf)
   - void close()
2. 构造方法：
   - BufferedReader(Reader in)：创建一个使用默认大小输入缓冲区的缓冲字符输入流。
   - BufferedReader(Reader in, int sz) 创建一个使用指定大小输入缓冲区的缓冲字符输入流。
     - 参数：
       - Reader in：字符输入流
         - 可以传递 FileReader，缓冲流会给 FileReader 增加一个缓冲区，提高FileReader的读取效率
3. 特有的成员方法：
   - String readLine()：读取一个文本行。
     - 行的终止符号：通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行('\r\n')。
     - 返回值：
       - 包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null



**`java.io.BufferedWriter extends Writer`**：字符缓冲输出流

1. 成员方法：
   - void write(int c)
   - void write(char[] cbuf)
   - abstract void write(char[] cbuf, int off, int len)
   - void write(String str)
   - void write(String str, int off, int len)
   - void close()
   - void flush()
2. 构造方法：
   - BufferedWriter(Writer out)：创建一个使用默认大小输出缓冲区的缓冲字符输出流。
   - BufferedWriter(Writer out, int sz) 创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
     - 参数：
       - Writer out：字符输出流
         - 可以传递FileWriter，缓冲流会给FileWriter增加一个缓冲区，提高FileWriter的写入效率
       - int sz：指定缓冲区的大小，不写默认大小
3. 特有的成员方法：
   - void newLine()：写入一个行分隔符。 会根据不同的操作系统，获取不同的行分隔符



#### 对象流

##### 对象的序列化流

**`java.io.ObjectOutputStream extends OutputStream`**：对象的序列化流

作用：把对象以流的方式写入到文件中保存

1. 构造方法：
   - ObjectOutputStream(OutputStream out)
     - 参数：
       - OutputStream out：字节输出流
2. 特有的成员方法：
   - void writeObject(Object obj)：将指定的对象写入 ObjectOutputStream。



##### 对象的反序列化流

**`java.io.ObjectInputStream extends InputStream`**：对象的反序列化流

作用：把文件中保存的对象，以流的方式读取出来使用

1. 构造方法：
   - ObjectInputStream(InputStream in)
     - 参数：
       - InputStream in：字节输入流
2. 特有的成员方法：
   - Object readObject()：从 ObjectInputStream 读取对象。
     - readObject 方法声明抛出了 ClassNotFoundException（class文件找不到异常）
       - 当不存在对象的 class 文件时抛出异常
3. 反序列化的前提：
   1. 类必须实现 `Serializable`
   2. 必须存在类对应的 class 文件



#### 打印流

`java.io.PrintStream extends OutputStream`：打印流

1. 构造方法：
   - PrintStream(File file)：输出的目的地是一个文件
   - PrintStream(OutputStream out)：输出的目的地是一个字节输出流
   - PrintStream(String fileName)：输出的目的地是一个文件路径
2. 成员方法：
   - void close()
   - void flush()
   - void write(byte[] b)
   - void write(byte[] b, int off, int len)
   - abstract  void write(int b)
3. 特有的方法：
   - void print(任意类型的值)
   - void println(任意类型的值并换行)
4. 注意事项：
   1. 如果使用**继承自父类的** write 方法写数据，那么查看数据的时候**会查询编码表** 97->a
   2. 如果使用**自己特有的方法** print/println 方法写数据，写的数据**原样输出** 97->97
5. 可以改变输出语句的目的地：
   - 输出语句，默认在控制台输出
     - 使用 `System.setOut` 方法把输出语句的目的地改为参数中传递的打印流的目的地
       - static void setOut(PrintStream out)：重新分配“标准”输出流。



#### 转换流

**`java.io.OutputStreamWriter extends Writer`**：是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。（编码：把能看懂的变成看不懂的）

1. 成员方法：
   - void write(int c)
   - void write(char[] cbuf)
   - abstract void write(char[] cbuf, int off, int len)
   - void write(String str)
   - void write(String str, int off, int len)
   - void close()
   - void flush()
2. 构造方法：
   - OutputStreamWriter(OutputStream out)
   - OutputStreamWriter(OutputStream out, String charsetName)
     - 参数：
       - OutputStream out：字节输出流，可以用来写转换之后的字节到文件中
       - String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8,gbk/GBK,...不指定默认UTF-8



**`java.io.InputStreamReader extends Reader`**：是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。（解码：把看不懂的变成能看懂的）

1. 成员方法：
   - int read()
   - int read(char[] cbuf)
   - void close()
2. 构造方法：
   - InputStreamReader(InputStream in)
   - InputStreamReader(InputStream in, String charsetName)
     - 参数：
       - InputStream in：字节输入流，用来读取文件中保存的字节
       - String charsetName：指定的编码表名称，不区分大小写
3. 注意事项：
   - 构造方法中指定的编码表名称要和文件的编码相同，否则会出现乱码



### 序列化和反序列化

*类通过实现 `java.io.Serializable` 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。*

1. *`Serializable` 接口也叫标记性接口。*
   - 要进行序列化和反序列化的类必须实现 Serializable 接口，就会给类添加一个标记
   - 当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记
     - 有：就可以序列化和反序列化
     - 没有：就会抛出 NotSerializableException 异常
2. static关键字：静态关键字
   1. 静态优先于非静态加载到内存中（**静态优先于对象**进入到内存中）
   2. 被 static 修饰的成员变量不能被序列化，序列化的都是对象
3. transient关键字：瞬态关键字
   1. 被 transient 修饰的成员变量不能被序列化
4. 序列化集合：
   - 当我们想在文件中保存多个对象的时候，可以把多个对象存储到一个集合中，**对集合进行序列化和反序列化**



### Properties

*`java.util.Properties` 集合 extends Hashtable<K,V> implements Map<K,V>*

- **Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。**

- **Properties集合是一个唯一和IO流相结合的集合**

1. Properties 集合有一些操作字符串的特有方法：
   - Object setProperty(String key, String value)：调用 Hashtable 的方法 put。
   - String getProperty(String key)：通过key找到value值，此方法相当于Map集合中的get(key)方法
   - Set<String> stringPropertyNames()：返回此属性列表中的键集，其中该键及其对应值是字符串，此方法相当于Map集合中的keySet方法
2. 可以使用 Properties 集合中的方法 `store`，把集合中的临时数据，持久化写入到硬盘中存储
   - void store(OutputStream out, String comments)
   - void store(Writer writer, String comments)
     - 参数：
       - OutputStream out：字节输出流，不能写入中文
       - Writer writer：字符输出流，可以写入中文
       - String comments：注释，用来解释说明保存的文件是做什么用的
         - 不能使用中文，会产生乱码，默认是Unicode编码
         - 一般使用 “” 空字符串
   - 使用步骤：
     1. 创建Properties集合对象，添加数据
     2. 创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
     3. 使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
     4. 释放资源
3. 可以使用 Properties 集合中的方法 `load`，把硬盘中保存的文件（键值对），读取到集合中的使用
   - void load(InputStream inStream)
   - void load(Reader reader)
     - 参数：
       - InputStream inStream：字节输入流，不能读取含有“中文”的键值对
       - Reader reader：字符输入流，能读取含有中文的键值对
   - 使用步骤：
     1. 创建Properties集合对象
     2. 使用Properties集合对象中的方法load读取保存键值对的文件
     3. 遍历Properties集合
   - 注意：
     1. 存储键值对的文件中，键与值默认的连接符号可以使用 = ，空格，（其他符号）
     2. 存储键值对的文件中，可以使用 # 进行注释，被注释的键值对不会被读取
     3. 存储键值对的文件中，键与值默认都是字符串，不用再加引号





## 反射

将类的各个组成部分封装为其他对象，这就是反射机制。

![](https://gitee.com/the-sherry/picture/raw/master/typora/202505032148108.png)

Class 对象功能：

获取功能：

第一步永远是获取对象的 Class 对象：`Class 变量名 = 对象.Class;`

1. 获取成员变量们：
   - Field[] getFields()：获取所有public修饰的成员变量
   - Field getField(String name)：获取指定名称的public修饰的成员变量
   - Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
   - Field getDeclaredField(String name)
2. 获取构造方法们：
   - Constructor<?>[] getConstructors()
   - Constructor<T> getConstructor(类<?>... parameterTypes)
   - Constructor<?>[] getDeclaredConstructors()
   - Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
3. 获取成员方法们：
   - Method[] getMethods()
   - Method getMethod(String name, 类<?>... parameterTypes)
   - Method[] getDeclaredMethods()
   - Method getDeclaredMethod(String name, 类<?>... parameterTypes)
4. 获取类名：
   - String getName()：获取全类名



### Field：成员变量

- 操作：
  - 设置值：
    - void set(Object obj, Object value)：设置对象obj的该成员变量的值。
  - 获取值：
    - Object get(Object obj)：获取对象obj的该成员变量的值。
  - 忽略访问权限修饰符的安全检查：
    - void setAccessible(boolean flag)：暴力反射



### Constructor：构造方法

- 创建对象：

  - T newInstance(Object... initargs)

    - eg：

      ```java
      Constructor constructor1 = personClass.getConstructor(String.class, int.class);
      // 创建对象
      Object person1 =  constructor1.newInstance("张三", 23);
      
      Constructor constructor2 = personClass.getConstructor();
      // 创建对象
      Object person2 = constructor2.newInstance();
      
      // 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
      Object o = personClass.newInstance();
      ```



### Method：方法对象

- 执行方法：
  - Object invoke(Object obj, Object... args)
- 获取方法名称：
  - String getName()：获取方法名



### 获取 Class 对象的方式

1. Class.forName("全类名")
   - 多用于配置文件，将类名定义在配置文件中。读取文件，加载类。
2. 类名.class
3. 对象.getClass()





## TCP 通信程序

**服务器使用客户端的流和客户端交互。**

### TCP 通信的客户端

*向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据*

1. 表示客户端的类：
   - `java.net.Socket`：此类实现客户端套接字（也可以叫“套接字”）。套接字是两台机器间通信的端点。
     - 套接字：包含了 IP 地址和端口号的网络单位
2. 方法：
   - 构造方法：
     - `Socket(String host, int port)`：创建一个流套接字并将其连接到指定主机上的指定端口号
       - 参数：
         - String host：服务器主机的名称 / 服务器的 IP 地址
         - int port：服务器的端口号
   - 成员方法：
     - `OutputStream getOutputStream()`：返回此套接字的输出流
     - `InputStream getInputStream()`：返回此套接字的输入流
3. 步骤：
   1. 创建客户端对象 Socket，构造方法绑定服务器的IP地址和端口号
   2. 使用 Socket 对象中的方法 getOutputStream() 获取网络字节输出流 OutputStream 对象
   3. 使用网络字节输出流 OutputStream 对象中的方法 write，给服务器发送数据
   4. 使用 Socket 对象中的方法 getInputStream() 获取网络字节输入流 InputStream 对象
   5. 使用网络字节输入流 InputStream 对象中的方法 read，读取服务器回写的数据
   6. 释放资源（Socket）
4. 注意：
   1. 客户端与服务器端进行交互，必须使用 Socket 中提供的网络流，不能使用自己创建的流对象
   2. 当我们创建客户端对象 Socket 的时候，就会去请求服务器，和服务器3次握手建立连接通路
      - 这时如果服务器没有启动，那么就会抛出异常 ConnectException: Connection refused: connect
      - 如果服务器已经启动，那么就可以进行交互了



### TCP 通信的服务器端

*接受客户端的请求，读取客户端发送的数据，给客户端回写数据*

1. 表示服务器的类：
   - `java.net.ServerSocket`：此类实现服务器套接字。
2. 构造方法：
   - `ServerSocket(int port)`：创建绑定到特定端口的服务器套接字。
3. 成员方法：服务端必须明确一件事情，必须的知道是哪个客户端请求的服务器，所以可以使用 accept 方法获取到请求的客户端对象 Socket
   - `Socket accept()`：侦听并接受到此套接字的连接。
4. 服务器的实现步骤：
   1. 创建服务器 ServerSocket 对象和系统要指定的端口号
   2. 使用 ServerSocket 对象中的方法 accept，获取到请求的客户端对象 Socket
   3. 使用 Socket 对象中的方法 getInputStream() 获取网络字节输入流 InputStream 对象
   4. 使用网络字节输入流 InputStream 对象中的方法 read，读取客户端发送的数据
   5. 使用 Socket 对象中的方法 getOutputStream() 获取网络字节输出流 OutputStream 对象
   6. 使用网络字节输出流 OutputStream 对象中的方法 write，给客户端回写数据
   7. 释放资源（Socket，ServerSocket）
