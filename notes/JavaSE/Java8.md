# Java 8



## Lambda 表达式

1. Lambda 表达式的标准格式：
   - `(参数列表)->{一些重写方法的代码}`
     - `()`：接口中抽象方法的列表
     - `->`：传递的意思，把参数传递给方法体 {}
     - `{}`：重写接口中的抽象方法的方法体
   - 可以省略的内容：
     - `(参数列表)`：括号中参数列表的数据类型，可以省略不写
     - `(参数列表)`：括号中的参数如果只有一个，那么类型和()都可以省略
     - `{一些代码}`：如果{}中的代码只有一行，无论是否有返回值，都可以省略({},return,分号)
       -  注意：要省略{}，return，分号必须一起省略
2. Lambda 使用前提：
   - 使用 Lambda 必须具有接口，且接口中只能有一个抽象方法
     - 有且只有一个抽象方法的接口，称为“**函数式接口**”。
3. 思想：把 Lambda 表达式看做一个**函数对象**。（将方法的调用化为函数对象，用 Lambda 表达式）
   - 把抽象方法所在的接口类型，作为函数对象的类型。




### 函数式编程

1. 使用 Lambda 优化：
   - Lambda 的特点：延迟加载





## 函数式接口

*有且仅有一个方法的接口，称之为函数式接口（接口中可以包含其他的方法（默认，静态，私有））*

1. `@FunctionalInterface` 注解：
   - 作用：可以检测接口是否是一个函数式接口
     - 否：编译失败（接口中没有抽象方法；抽象方法的个数大于1个）
2. 函数式接口的使用：一般可以作为方法的**参数**和**返回值**类型
   - 定义一个方法，参数使用函数式接口
     - 可以传递接口的实现类对象
     - 可以传递接口的匿名内部类（内存中**有** class 文件）
     - 可以使用 Lambda 表达式（内存中**没有** class 文件）【建议】





### 常用的函数式接口

1. Runnable
   - `() -> void`
2. Callable：用于实现多线程任务的接口（有返回值）
   - `() -> T`
3. Comparator
   - `(T, T) -> int`
4. Supplier , Int  Long  Double ...
   - `() -> T` Int 指返回值是 int
5. Consumer , BiConsumer , IntConsumer , LongConsumer , DoubleConsumer
   - `(T) -> void` Bi 是两参，Int 指参数是 int
6. Predicate , BiPredicate , Int  Long  Double ...
   - `(T) -> boolean` Bi 是两参，Int 指参数是 int
7. Function , BiFunction , Int  Long  Double ...
   - `(T) -> R` Bi 是两参，Int 指参数是 int
8. UnaryOperator , BinaryOperator , Int  Long  Double ...
   - `(T) -> T` Unary 一参，Binary 两参，Int 指参数是 int



#### Supplier 接口

1. `java.util.function.Supplier<T>` ：（生产型接口）
   - 该接口仅包含一个无参的方法：`T get()` 用来获取一个泛型参数指定类型的对象数据



#### Consumer 接口

1. `java.util.function.Consumer<T>` ：正好与 Supplier 接口相反（消费型接口）
   - 该接口中包含抽象方法：`void accept(T t)`
     - 消费方式：自定义
   - 该接口中的默认方法：`Consumer<T> andThen(Consumer<T> after)`
     - 作用：需要两个 Consumer 接口，可以把两个 Consumer 接口组合到一起，再对数据进行消费
       - 连接两个 Consumer 接口，再进行消费：`con1.andThen(con2).accept(s);`
         - 谁写前边谁先消费



#### Predicate 接口

1. `java.util.function Predicate<T>`：
   - 该接口中包含一个抽象方法：`boolean test(T t)` 用来对指定数据类型数据进行判断的方法
     - 符合条件为 true
   - 该接口中的默认方法：
     - `Predicate<T> and(Predicate<T> other)` 表示并且关系
     - `Predicate<T> negate()` 表示取反的意思
     - `Predicate<T> or(Predicate<T> other)` 表示或者关系



#### Function 接口

1. `java.util.function<T,R>`：接口用来根据一个类型的数据得到另一个类型的数据
   - 该接口中的抽象方法：`R apply(T t)` 根据类型T的参数获取类型R的结果
   - 该接口中的默认方法：`Function<T, V> andThen(Function<R, V> after)`





## 方法引用与构造器引用

*方法引用是用来优化 Lambda 表达式的*

1. 双冒号 `::` 为引用运算符，它所在的表达式被称为方法引用。如果 Lambda 要表达的函数方案已经存在于某个方法的实现中，那么则可以通过双冒号来引用该方法作为 Lambda 的替代者。
   - 注：Lambda 中传递的参数一定是方法引用中的那个方法可以接收的类型，否则会抛出异常
2. 方法引用：
   1. 通过对象名引用成员方法：**对象::非静态方法** **类名::非静态方法**
     - *适用前提：对象名是已经存在的；成员方法也是已经存在*
       - eg：`stu::getName`
   2. 通过类名引用静态成员方法：**类名::静态方法**
     - *适用前提：类已经存在的；静态成员方法也已经存在*
       - eg：`Integer::parseInt`
   3. 通过 super 引用成员方法：**super::非静态方法**
     - *前提：得有子父类继承关系，super存在；父类中有成员方法*
   4. 通过this引用成员方法：**this::非静态方法**
     - *前提：this是已经存在的；本类的成员方法也是已经存在的*
   5. 类的构造方法已知：**类名::new**
     - *前提：构造方法已知；创建对象已知*
       - `Student::new`
   6. 数组的构造器引用：**数组类型[]::new**
     - *前提：创建数组的类型已知；数组长度已知*
       - eg：`int[]::new`
3. 方法引用可以作为**函数对象**来使用。（将方法的调用化为函数对象，也可以用方法引用）
4. 特例：对于无需返回值的函数接口，例如 Consumer 和 Runnable 它们可以配合有返回值的函数对象使用。





## StreamAPI

*Stream 流关注的是做什么，而不是怎么做*

*Stream 流属于管道流，只能被消费（使用）一次*

1. Stream 自己不会存储对象。
2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新 Stream
3. Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。



### 获取流

*`java.util.stream Stream<T>`：常用流接口*

1. 获取流常用的方式：

   1. 所有的 **Collection** 集合都可以通过 Stream 默认方式获取流；

      - `default Stream<E> stream()` 返回的是一个顺序流

        - Collection：List 和 Set

        - 对于 Map 集合：

          ```java
          Map<String,String> map = new HashMap<>();
          // 获取键，存储到一个Set集合中
          Set<String> keySet = map.keySet();
          Stream<String> stream3 = keySet.stream();
          
          // 获取值，存储到一个Collection集合中
          Collection<String> values = map.values();
          Stream<String> stream4 = values.stream();
          
          // 获取键值对（鉴于知道映射关系  entrySet）
          Set<Map.Entry<String, String>> entries = map.entrySet();
          Stream<Map.Entry<String, String>> stream5 = entries.stream();
          ```
        
      - `default Stream<E> parallelStream()` 返回的是一个并行流

   2. 通过Arrays 的静态方法 stream() 可以获取数组 Stream 流
   
      - `static <T> Stream<T> stream(T[] array)`
   
   3. Stream 接口的静态方法 of 可以获取数组对应的流。
   
      - `static <T> Stream<T> of(T... values)`
        - 参数是一个可变参数，传递一个数组即可
   
   4. 可以使用静态方法 Stream.iterate() 和 Stream.generate()，创建无限流
   
      - `static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)`
      - `static<T> Stream<T> generate(Supplier<? extends T> s)`



### 常用方法

1. 延迟方法（中间操作）：返回值类型仍然是 Stream 接口自身类型的方法，因此支持链式调用。
   - 筛选与切片
   - 映射
   - 排序

2. 终结方法（终止操作）：返回值类型不再是 Stream 接口自身类型的方法，因此不再支持链式调用。
   - 匹配与查找
   - 归约
   - 收集
3. 常用方法：
   1. concat：`static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)` 用于把流组合到一起。（静态方法）



#### 筛选与切片

1. filter：`Stream<T> filter(Predicate<? super T> predicate)` 用来对 Stream 流中的数据进行过滤。
2. limit：`Stream<T> limit(long maxSize)` 用于截取流中的元素，只取前 n 个。
3. skip：`Stream<T> skip(long n)` 用于跳过元素。如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
4. distinct：`distinct()` 筛选，通过流生成元素的 `hashCode()` 和 `equals` 去除重复元素。



#### 映射

1. map：`<R> Stream<R> map(Function<? super T,? extends R> mapper)` 将当前流中的T类型转换为另一种R类型。
2. flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
3. 二者区别：map 是 Stream 里面包着 Stream，遍历需要嵌套；flatMap 是 Stream 里面具体一个一个的元素，直接遍历即可。



#### 排序

1. sorted 无参：`Stream<T> sorted()` 产生一个新流，其中按自然顺序排序。
2. sorted 有参：`Stream<T> sorted(Comparator<? super T> comparator)` 产生一个新流，其中按比较器顺序排序。



#### 匹配与查找

1. allMatch：`boolean allMatch(Predicate<? super T> predicate)` 检查是否匹配所有元素。
2. anyMatch：`boolean anyMatch(Predicate<? super T> predicate)` 检查是否至少匹配一个元素。
3. noneMatch：`boolean noneMatch(Predicate<? super T> predicate)` 检查是否没有匹配的元素。
4. findFirst：`Optional<T> findFirst()` 返回第一个元素。
5. findAny：`Optional<T> findAny()` 返回当前流中的任意元素。
6. count：`long count()` 用于统计 Stream 流中元素的个数。
7. max：`Optional<T> max(Comparator<? super T> comparator)` 返回流中最大值
8. min：`Optional<T> min(Comparator<? super T> comparator)` 返回流中最小值
9. forEach：`void forEach(Consumer<? super T> action)` 用来遍历流中的数据。



#### 归约

1. reduce 双参：`T reduce(T identity, BinaryOperator<T> accumulator)` 可以将流中元素反复结合起来，得到一个值。返回 T
2. reduce 单参：`Optional<T> reduce(BinaryOperator<T> accumulator)` 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>



#### 收集

1. collect：将流转换为其他形式。接收一个 Collector 【`Collectors.toList()` 、`Collectors.toSet()`】接口的实现，用于给 Stream 中的元素做汇总的方法。



### Optional 类

*为了在程序中避免出现空指针异常而创建的*

1. Optional<T> 类是一个容器类，可以保存类型 T 的值，代表这个值存在。或者仅仅保存 null，表示这个值不存在。
   - 可以避免空指针异常
2. 常用方法：
   - `Optional.of(T value)`：保证 value 是非空的
   - `Optional.ofNullable(T value)`：value 可以为空
   - `T orElse(T other)`：如果当前的 Optional 内部封装的 value 是非空的，则返回内部的 t；如果内部的 t 是空的，则返回 orElse() 方法中的参数 other
   - `T get()`：如果调用对象包含值，返回该值，否则抛异常（不想抛异常，也可先判断）
   - `boolean isPresent()`：判断是否包含对象





### 并行流

一种**多线程数据处理机制**，通过将集合数据分割成多个块并利用多核CPU并行处理。

1. 并行流基于 `Fork/Join` 框架实现，默认使用 `ForkJoinPool.commonPool()` 线程池（线程数等于CPU核心数），通过数据分块、并行处理和结果合并三个步骤加速计算。
2. Java 8 中将并行流进行了优化，Stream API 可以通过 `parallel()` 和 `sequential()` 在并行流和顺序流之间进行切换。





## 接口中的默认方法与静态方法

1. 接口中的默认方法的“类优先”原则
   - 若一个接口中定义了一个默认方法，而另一个【父类】或【接口】中又定义了一个同名的方法时
     - 选择父类中的方法。如果【父类】提供了具体的实现，那么【接口】中具有相同名称和参数的**默认方法**会被忽略。
     - 接口冲突。如果一个【父接口】提供一个默认方法，而另一个【接口】也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），那么必须覆盖该方法来解决冲突。
2. 接口中允许有静态方法。





## 新时间日期API

1. 传统的时间类：（Date、SimpleDateFormate、Calendar）
2. JDK 8 新增的时间API：
   1. 都是不可变对象，修改后会返回新的时间对象，不会丢失最开始的时间。
   2. 线程安全。
   3. 能精确到毫秒、纳秒。




### 新增的时间API

#### 代替 Calendar

1. LocalDate：年、月、日

   - `static Xxx now()` 获取系统当前时间对应的该对象

   - 获取日期对象中的信息

     - ```java
       int year = ld.getYear(); // 年
       int month = ld.getMonthValue(); // 月（1~12）
       int day = ld.getDayOfMonth(); // 日
       int dayOfYear = ld.getDayOfYear(); // 一年中的第几天
       int dayOfWeek = ld.getDayOfWeek().getValue(); // 星期几
       ```

   - 修改信息

     - ```java
       LocalDate ld2 = ld.withYear(2099);
       LocalDate ld3 = ld.withMonth(12);
       withDayOfMonth()、withDayOfYear()...
       ```

   - 把某个信息加多少

     - ```java
       LocalDate ld4 = ld.plusYears(2);
       LocalDate ld5 = ld.plusMonths(2);
       plusDays()、plusWeeks()...
       ```

   - 把某个信息减多少

     - ```java
       LocalDate ld6 = ld.minusYears(2);
       LocalDate ld7 = ld.minusMonths(2);
       minusDays()、minusWeeks()...
       ```

   - 获取指定日期的 LocalDate 对象

     - `static LocalDate of(int year, int month, int dayOfMonth)`

   - 判断两个日期对象，是否相等、在前还是在后

     - `equals`、`isAfter`、`isBefore`

2. LocalTime：时、分、秒

   - 同 LocalDate 类似，只不过对应的是 时、分、秒、纳秒

3. LocalDateTime：年、月、日、时、分、秒

   - 同上
   - 可以转换成 LocalDate 和 LocalTime
     - `LocalDate toLocalDate()`、`LocalTime toLocalTime()`
     - 再变回去 `static LocalDateTime of(LocalDate date, LocalTime time)`
   - `String format(DateTimeFormatter formatter)` 格式化时间
   - `static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter)` 解析时间

4. ZoneId：时区

   - `static ZoneId systemDefault()` 获取系统默认的时区
   - `static Set<String> getAvailableZoneIds()` 获取 Java 支持的全部时区 Id
   - `static ZoneId of(String zoneId)` 把某个时区 Id 封装成 ZoneId

5. ZoneDateTime：带时区的时间

   - `static ZonedDateTime now(ZoneId zone)` 获取某个时区的 ZonedDateTime 对象

   - ```java
     ZonedDateTime zonedDateTime = ZonedDateTime.now(Clock.systemUTC());
     ```

     - `static ZonedDateTime now(Clock clock)` 获取世界标准时间

   - `static ZonedDateTime now()` 获取系统默认时区的时间

   - 修改时间的一些方法与 LocalDateTime 类似



#### 代替Date

1. Instant：时间戳 / 时间线【可以用来记录代码的执行时间，或用于记录用户操作某个事件的时间点。】
   - `static Instant now()` 获取当前时间的 Instant 对象（标准时间）
   - `long getEpochSecond()` 获取从 1970-01-01T00: 00: 00开始的总秒数
   - `int getNano()` 获取不够1秒的纳秒数
   - `Instant plusNanos(long nanosToAdd)` 增加时间的方法
   - `Instant minusNanos(long nanosToSubtract)` 减少时间的方法
   - `equals`、`isAfter`、`isBefore` 判断时间的方法



#### 代替 SimpleDateFormat

1. DateTimeFormatter：用于时间格式化和解析

   - ```java
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY年MM月dd日 HH:mm:ss");
     ```

     - `static DateTimeFormatter ofPattern(String pattern)` 获取格式化对象

   - `String format(localDateTime / ...)`  格式化时间



#### 其它补充

1. Period：时间间隔（年、月、日）
   - `static Period between(LocalDate startDateInclusive, LocalDate endDateExclusive)` 传入2个日期对象，得到 Period 对象
   - `int getYears()` 计算隔多少年
   - `int getMonths()` 计算隔多少月
   - `int getDays()` 计算隔多少天
2. Duration：时间间隔（时、分、秒、纳秒）
   - `static Duration between(开始时间对象, 截止时间对象)` 传入2个时间对象，得到 Duration 对象
   - `long toDays()` 计算隔多少天
   - `long toHours()` 计算隔多少小时
   - `long toMinutes()` 计算隔多少分钟
   - `long toSeconds()` 计算隔多少秒
   - `long toMillis()` 计算隔多少毫秒
   - `long toNanos()` 计算隔多少纳秒





## 其他新特性

### 重复注解

*允许在同一个地方多次使用同一个注解。*

1. 使用 `@Repeatable` 注解定义重复注解。

2. 代码详解：

   1. 定义重复注解的容器

      - ```java
        @Retention(RetentionPolicy.RUNTIME)
        public @interface MyAnnotations {
            MyAnnotation[] value();
        }
        ```

   2. 定义重复注解

      - ```java
        @Repeatable(MyAnnotations.class)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface MyAnnotation {
            String value();
        }
        ```

   3. 配置多个重复注解

      - ```java
        @MyAnnotation("test1")
        @MyAnnotation("test2")
        @MyAnnotation("test3")
        public class AnnoTest {
            
            @MyAnnotation("fun1")
            @MyAnnotation("fun2")
            public void test01() {
            }
        }
        ```

   4. 解析得到指定的注解

      1. 解析重复注解

         - ```java
           /**
           * 通过反射获取重复注解
           * @param args
           */
           public static void main(String[] args) throws NoSuchMethodException {
               // 获取类中标注的重复注解
               MyAnnotation[] annotationsByType = AnnoTest.class.getAnnotationsByType(MyAnnotation.class);
               for (MyAnnotation myAnnotation : annotationsByType) {
                   System.out.println(myAnnotation.value());
               }
           
               // 获取方法中标注的重复注解
               MyAnnotation[] test01s = AnnoTest.class.getMethod("test01").getAnnotationsByType(MyAnnotation.class);
               for (MyAnnotation test01 : test01s) {
                   System.out.println(test01.value());
               }
           }
           ```

      2. 直接获取容器注解，通过容器注解获取其下的重复注解

         - ```java
           MyAnnotations annotation = AnnoTest.class.getAnnotation(MyAnnotations.class);
           for (MyAnnotation myAnnotation : annotation.value()) {
           	System.out.println(myAnnotation.value());
           }
           ```

3. 通过反射获取重复注解所使用的方法：

   - `getAnnotationsByType(Class<T> annotationClass)`：能够直接获取重复注解的数组。



### 类型注解

`@Target` 元注解新增了两种类型：TYPE_PARAMETER，TYPE_USE

- `TYPE_PARAMETER` 表示该注解能写在类型参数的声明语句中。类型参数声明如：<T>

  - 定义

    - ```java
      @Target(ElementType.TYPE_PARAMETER)
      public @interface TypeParam {
      }
      ```

  - 使用

    - ```java
      public class TypeDemo01 <@TypeParam T> {
          public <@TypeParam K extends Object> K test01(){
              return null;
          }
      }
      ```

- `TYPE_USE` 表示注解可以在任何用到类型的地方使用。

  - 定义

    - ```java
      @Target(ElementType.TYPE_USE)
      public @interface NotNull {
      }
      ```

  - 使用

    - ```java
      public class TypeUseDemo01 {
          public @NotNull Integer age = 10;
          public Integer sum(@NotNull Integer a, @NotNull Integer b) {
              return a + b;
          }
      }
      ```









## JDK 8 经典面试题

### 1. Java 8 有哪些新特性？

1. Lambda 表达式
2. 函数式接口
3. Stream API
4. 接口中的默认方法和静态方法
5. Optional 类
6. 新的日期时间 API
7. 方法引用
8. JavaScript 引擎 Nashorn：在 JVM 上运行 JavaScript 代码
9. 底层优化
   - HashMap 性能改进
   - JVM 调整：移除永久代（PermGen），改用元空间（MetaSpace）管理类元数据



### 2. HashMap 在 jdk 1.7 和 1.8 的区别？

1. 存储结构：
   - JDK 1.7：数组+链表结构（即链地址法）
   - JDK 1.8：数组+链表+红黑树，当链表长度 > 8时，会将链表转为红黑树进行存储
2. 插入方式：（七上八下）
   - JDK 1.7：使用头插法
   - JDK 1.8：使用尾插法
3. `HashMap map = new HashMap();` 默认情况下，先不创建长度为16的数组。
   - 当首次调用 `map.put()` 时，再创建长度为16的数组
4. 在插入新值时，
   - JDK 1.7：先扩容后插入
   - JDK 1.8 ：HashMap先进行插入操作，然后再判断是否需要扩容
