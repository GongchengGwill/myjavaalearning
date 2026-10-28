# Java快速入门

## 2.1 java历史

- java是一个编译和解释型之间的语言
- 通过jvm来实现在所有平台运行

这里要说明几个java相关的概念：

- **jre**：jvm+environment 已经编译完的语言 再加上jre就可以跑通了
- **jdk**：只需要有写完的程序代码就可以运行了 包含了编译器等一系列套件

## 2.2 搭建开发环境

搭建环境首先要下载一个jdk。

我电脑中已经下载过java23了 所以我没有重新下载配置。

下载完需要在环境变量path中设置一个java的路径 从而使得其在各种环境中可用。

可以在powershell中 通过输入 `java -version` 来查看java版本情况。

在这里可以发现java文件夹中有很多可以运行的可执行文件，分别解释：

- `java` —— 是jvm虚拟机 用于执行java程序
- `javac` —— 是java的编译器 用于将编写的java文件编译成class文件
- `jar` —— 用于将一系列多个class文件编辑成一个jar包 来便于发布
- `javadoc` —— 用于读取注释以生成文档说明
- `jdb` —— 用于java调试

创建一个java源码文件 只能定义一个public类的class 并且文件名要和类名完全一致。

- `javac` 可以将源码文件编译生成一个class文件
- 使用java可以运行一个可执行文件 也就是 `.class` 文件

### 使用IDE

在这里没有按照教程使用eclipse。虽然我之前电脑上有eclipse，但是相比于idea，感觉使用的体感不太好，所以继续使用了我之前学习时使用的idea。

新建了一个java项目 并且测试运行通过 `java0917`。

## 2.3 Java程序基础

程序基本结构：一个名为 `main` 的方法是进入的主方法，外面是一个class类。

注释存在几种写法，分别是：

```java
//这是注释

/*
这是注释
*/

/**
 *
 * @author gongcheng
 */
```

还有可以生成文档的特殊注释，这种多出现在类和方法的定义处。

### 基本数据类型

**整型**

- `byte` 占位1字节
- `short` 占位2字节
- `int` 占位4字节
- `long` 占位8字节

**浮点型**

- `float` 占位4字节
- `double` 占位8字节

**字符型**

- `char` 占位2字节

**布尔类型**

- `boolean` 实际上没有明确规定 由JVM来实现并且确定 （占位1字节只能说是模糊的）

除开基本数据类型 其他的都是引用类型，最为常见的是 `String` 字符串类型。

- **变量**：代指 `var`，Java 10 引入的局部变量类型推断（编译器自动推断类型）
- **常量**：在数据前面添加 `final` 来固定数据不被修改

### 整数运算

与常规数学运算一致，注意这儿存在几个新的运算：

- **移位运算**：`<<`、`>>`
- **位运算**：与 `&`、或 `|`、非 `~`、异或 `^`

### 浮点数运算

浮点数运算时会存在一个情况：因为小数在电脑中存储的时候不能完全精确表示，所以计算时，只要两个数差值够小，就可以当作一个数。

### 布尔运算

布尔运算是短路运算，也就是前面的如果计算直接结束了，就不会计算后面的内容了。同时引入三元运算 `b ? x : y`。

### 字符和字符串

- 字符用 `char` 来创建变量
- 同时可以使用 `\u` 和 Unicode 编码来表示一个字符

```java
char a = '\u0041'
```

- 使用 `+` 号进行连接
- 同时可以通过 `"""..."""` 来表示多行字符串，这种情况下会把最前面齐头的空格都删掉

字符串是引用类型，也就是说，当其被指向另一个字符串时，之前的字符串不会被删掉。

引用类变量可以指向 `null`，但是 `null` 与空字符串 `""` 是不一样的。

### 数组类型

数组定义的时候代码是：

```text
数组类型 数组名称 = new 数组类型[数组长度]
```

例如：

```java
int money = new int[10];
```

或者是初始化时就定义数据，从而自动定义数组长度，例如：

```java
int[] money = new int[]{1, 2, 3};
```

数组也是一个引用类型，所以也和字符串一样，指向另一个数据时，原本的内容不会被删除，只是不再被原来的数组位置找到了。

### 流程控制

#### 输入与输出

需要 `import` 一个 Scanner 的包。

创建 Scanner 类来进行输入输出。

输出的时候在这里需要注意：有时候需要占位符，并且不能使用 `println`。

例如：

```java
System.out.printf("本次成绩提升的百分比为%.2f%%", ans);
```

#### 判断相等

浮点数比较的正确做法是给一个误差范围。

引用类型判断相等不能直接用 `==` 运算符，需要使用 `equals()` 函数。

引用类型判断内容的时候也是这样子，同时还要避免 `NullPointerException`。

#### switch 多重选择

两种方式。

**方式一**

```java
switch(a){
    case 1:
        sout();
        break;
    case 2:
        sout();
        break;
    ...
    default:
        break;
}
```

需要注意 `break` 很重要 因为 switch 存在穿透的情况。

**另一种方式**

```java
switch(a){
    case "hajimi" -> sout();
    case "nanbeilvdou" -> sout();
    ...
    default -> {
        sout();
        sout();
    }
}
```

可以直接用这个来赋值：

```java
int a = switch(geng){
    case "niulai" -> 1;
    case "wodingsini" -> 2;
    default -> {
        int code = geng.hashCode();
        yield code;
    }
}
```

#### while / do while / for 循环

- `break` 跳出当前循环
- `continue` 直接进入下一轮循环
- 两者多搭配 `if` 使用

#### 数组遍历与常用方法

遍历数组可以使用 for 循环，for 循环可以访问数组索引，for each 循环直接迭代每个数组元素，但无法获取索引；

使用 `Arrays.toString()` 可以快速获取数组内容。

可以直接使用 Java 标准库提供的 `Arrays.sort()` 进行排序；

#### 练习：数组倒序排列

```java
public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        // TODO:
        for(int i = ns.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(ns[j] < ns[j + 1]){
                    int temp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = temp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
```

#### 多维数组

多维数组的每个数组元素长度都不要求相同；

打印多维数组可以使用 `Arrays.deepToString()`；

## 3. 面向对象编程 OOP

模板和对象 是 类和实例的关系。

指向 instance 的变量都是引用变量。

外部代码通过 public 方法操作实例，内部代码可以调用 private 方法；

理解方法的参数绑定。

### 可变参数

```java
public void setNames(String... names){
    this.name = names;
}
```

上面的 `setNames()` 就定义了一个可变参数。调用时，可以这么写：

```java
Group g = new Group();
g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
g.setNames("Xiao Ming"); // 传入1个String
g.setNames(); // 传入0个String
```

### 参数绑定

调用方把参数传递给实例方法时，调用时传递的值会按参数位置一一绑定。

那什么是参数绑定？

#### 例1：基本类型参数的传递

我们先观察一个基本类型参数的传递：

```java
// 基本类型参数绑定
public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        int n = 15; // n的值为15
        p.setAge(n); // 传入n的值
        System.out.println(p.getAge()); // 15
        n = 20; // n的值改为20
        System.out.println(p.getAge()); // 15还是20?
    }
}

class Person {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

运行代码，从结果可知，修改外部的局部变量 n，不影响实例 p 的 age 字段，原因是 `setAge()` 方法获得的参数，复制了 n 的值，因此，`p.age` 和局部变量 n 互不影响。

**结论：基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。**

#### 例2：引用类型参数的传递（数组）

我们再看一个传递引用参数的例子：

```java
// 引用类型参数绑定
public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        String[] fullname = new String[] { "Homer", "Simpson" };
        p.setName(fullname); // 传入fullname数组
        System.out.println(p.getName()); // "Homer Simpson"
        fullname[0] = "Bart"; // fullname数组的第一个元素修改为"Bart"
        System.out.println(p.getName()); // "Homer Simpson"还是"Bart Simpson"?
    }
}

class Person {
    private String[] name;

    public String getName() {
        return this.name[0] + " " + this.name[1];
    }

    public void setName(String[] name) {
        this.name = name;
    }
}
```

注意到 `setName()` 的参数现在是一个数组。一开始，把 fullname 数组传进去，然后，修改 fullname 数组的内容，结果发现，实例 p 的字段 `p.name` 也被修改了！

**结论：引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方（因为指向同一个对象嘛）。**

#### 例3：String 的特殊情况

有了上面的结论，我们再看一个例子：

```java
// 引用类型参数绑定
public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        String bob = "Bob";
        p.setName(bob); // 传入bob变量
        System.out.println(p.getName()); // "Bob"
        bob = "Alice"; // bob改名为Alice
        System.out.println(p.getName()); // "Bob"还是"Alice"?
    }
}

class Person {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

### 构造方法

没有在构造方法中初始化字段时，引用类型的字段默认是 `null`，数值类型的字段用默认值，`int` 类型默认值是 `0`，布尔类型默认值是 `false`：

### 方法重载

如果有一系列方法，它们的功能都是类似的，只有参数有所不同，那么，可以把这一组方法名做成同名方法。

这种方法名相同，但各自的参数不同，称为方法重载（`Overload`）。

### 继承

继承是面向对象编程中非常强大的一种机制，它首先可以复用代码。当我们让 `Student` 从 `Person` 继承时，`Student` 就获得了 `Person` 的所有功能，我们只需要为 `Student` 编写新增的功能。

Java 使用 `extends` 关键字来实现继承。

**注意**

子类自动获得了父类的所有字段，严禁定义与父类重名的字段！

在 Java 中，没有明确写 `extends` 的类，编译器会自动加上 `extends Object`。所以，任何类，除了 `Object`，都会继承自某个类。

Java 只允许一个 class 继承自一个类，因此，一个类有且仅有一个父类。只有 `Object` 特殊，它没有父类。

继承有个特点，就是子类无法访问父类的 `private` 字段或者 `private` 方法。

这使得继承的作用被削弱了。为了让子类可以访问父类的字段，我们需要把 `private` 改为 `protected`。用 `protected` 修饰的字段可以被子类访问：

因此，`protected` 关键字可以把字段和方法的访问权限控制在继承树内部，一个 `protected` 字段和方法可以被其子类，以及子类的子类所访问

`super` 关键字表示父类（超类）。子类引用父类的字段时，可以用 `super.fieldName`。

但是，在某些时候，就必须使用 `super`。如果父类没有默认的构造方法，子类就必须显式调用 `super()` 并给出参数以便让编译器定位到父类的一个合适的构造方法。

#### 阻止继承

正常情况下，只要某个 class 没有 `final` 修饰符，那么任何类都可以从该 class 继承。从 Java 15 开始，允许使用 `sealed` 修饰 class，并通过 `permits` 明确写出能够从该 class 继承的子类名称

#### 向上转型

这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。

向上转型实际上是把一个子类型安全地变为更加抽象的父类型

#### 多态

继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）

Override 和 Overload 不同的是，如果方法签名不同，就是 Overload，Overload 方法是一个新方法；如果方法签名相同，并且返回值也相同，就是 `Override`

方法名相同，方法参数相同，但方法返回值不同，也是不同的方法。在 Java 程序中，出现这种情况，编译器会报错。

那么，一个实际类型为 `Student`，引用类型为 `Person` 的变量，调用其 `run()` 方法，调用的是 `Person` 还是 `Student` 的 `run()` 方法？

运行一下上面的代码就可以知道，实际上调用的方法是 `Student` 的 `run()` 方法。因此可得出结论：

**Java 的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。**

这个非常重要的特性在面向对象编程中称之为多态。它的英文拼写非常复杂：Polymorphic。

多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。例如：

```java
Person p = new Student();
p.run(); // 无法确定运行时究竟调用哪个run()方法
```

多态具有一个非常强大的功能，就是允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码。

#### 调用 super

在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过 `super` 来调用。例如：

```java
class Person {
    protected String name;
    public String hello() {
        return "Hello, " + name;
    }
}

class Student extends Person {
    @Override
    public String hello() {
        // 调用父类的hello()方法:
        return super.hello() + "!";
    }
}
```

#### final 关键字

继承可以允许子类覆写父类的方法。如果一个父类不允许子类对它的某个方法进行覆写，可以把该方法标记为 `final`。用 `final` 修饰的方法不能被 `Override`

如果一个类不希望任何其他类继承自它，那么可以把这个类本身标记为 `final`。用 `final` 修饰的类不能被继承

对于一个类的实例字段，同样可以用 `final` 修饰。用 `final` 修饰的字段在初始化后不能被修改

#### 抽象类

答案是不行，会导致编译错误，因为定义方法的时候，必须实现方法的语句。

能不能去掉父类的 `run()` 方法？

答案还是不行，因为去掉父类的 `run()` 方法，就失去了多态的特性。

如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法：

必须把 `Person` 类本身也声明为 `abstract`，才能正确编译它：

```java
abstract class Person {
    public abstract void run();
}
```

使用 `abstract` 修饰的类就是抽象类。我们无法实例化一个抽象类：

```java
Person p = new Person(); // 编译错误
```

因为抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”。

##### 面向抽象编程

当我们定义了抽象类 `Person`，以及具体的 `Student`、`Teacher` 子类的时候，我们可以通过抽象类 `Person` 类型去引用具体的子类的实例：

```java
Person s = new Student();
Person t = new Teacher();
```

这种引用抽象类的好处在于，我们对其进行方法调用，并不关心 `Person` 类型变量的具体子类型。

**编写抽象编程来计算需要交的税（以下是我自己写的任务）**

```java
public class Main {  
    public static void main(String[] args) {  
        Income[] incomes = new Income[]{  
                new IncomeByWork(6000),  
                new IncomeByWrite(500)  
        };  
        int tax = 0;  
        for(Income income : incomes){  
            tax += income.getTax();  
        }  
        System.out.println(tax);  
    }  
}  
abstract class Income{  
    protected double income;  
    public Income(double i){  
        this.income = i;  
    }  
  
    protected abstract double getTax();  
}  
  
class IncomeByWork extends Income {  
  
    public IncomeByWork(int i) {  
        super(i);  
    }  
  
    @Override  
    protected double getTax() {  
        return (income - 5000) * 0.2;  
    }  
}  
  
class IncomeByWrite extends Income {  
  
    public IncomeByWrite(int i) {  
        super(i);  
    }  
  
    @Override  
    protected double getTax() {  
        return income * 0.5;  
    }  
}
```

在抽象类中，抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。

#### 接口

如果一个抽象类没有字段，所有方法全部都是抽象方法：

```java
abstract class Person {
    public abstract void run();
    public abstract String getName();
}
```

就可以把该抽象类改写为接口：`interface`。

```java
interface Person {
    void run();
    String getName();
}
```

因为接口定义的所有方法默认都是 `public abstract` 的，所以这两个修饰符不需要写出来（写不写效果都一样）。

当一个具体的 `class` 去实现一个 `interface` 时，需要使用 `implements` 关键字。

我们知道，在 Java 中，一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个 `interface`，例如：

```java
class Student implements Person, Hello { // 实现了两个interface
    ...
}
```

##### 接口继承

一个 `interface` 可以继承自另一个 `interface`。`interface` 继承自 `interface` 使用 `extends`，它相当于扩展了接口的方法。例如：

```java
interface Hello {
    void hello();
}

interface Person extends Hello {
    void run();
    String getName();
}
```

此时，`Person` 接口继承自 `Hello` 接口，因此，`Person` 接口现在实际上有3个抽象方法签名，其中一个来自继承的 `Hello` 接口。

##### default 方法

在接口中，可以定义 `default` 方法。例如，把 `Person` 接口的 `run()` 方法改为 `default` 方法

实现类可以不必覆写 `default` 方法。`default` 方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是 `default` 方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。

`default` 方法和抽象类的普通方法是有所不同的。因为 `interface` 没有字段，`default` 方法无法访问字段，而抽象类的普通方法可以访问实例字段。

##### 接口小结

- Java 的接口（interface）定义了纯抽象规范，一个类可以实现多个接口；
- 接口也是数据类型，适用于向上转型和向下转型；
- 接口的所有方法都是抽象方法，接口不能定义实例字段；
- 接口可以定义 `default` 方法（JDK>=1.8）。

## 3.1 静态字段和静态方法

用 `static` 修饰的字段，称为静态字段：`static field`

对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：所有实例的静态字段都被修改了，原因是静态字段并不属于实例：

不推荐用 `实例变量.静态字段` 去访问静态字段，因为在 Java 程序中，实例对象并没有静态字段。在代码中，实例对象能访问静态字段只是因为编译器可以根据实例类型自动转换为 `类名.静态字段` 来访问静态对象。

推荐用类名来访问静态字段。可以把静态字段理解为描述 `class` 本身的字段。

有静态字段，就有静态方法。用 `static` 修饰的方法称为静态方法。

调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。静态方法类似其它编程语言的函数。

静态方法经常用于工具类。例如：

- `Arrays.sort()`
- `Math.random()`

静态方法也经常用于辅助方法。注意到 Java 程序的入口 `main()` 也是静态方法。

因为 `interface` 是一个纯抽象类，所以它不能定义实例字段。但是，`interface` 是可以有静态字段的，并且静态字段必须为 `final` 类型。实际上，因为 `interface` 的字段只能是 `public static final` 类型，所以我们可以把这些修饰符都去掉

```java
public interface Person {
    // 编译器会自动加上public static final:
    int MALE = 1;
    int FEMALE = 2;
}
```

### 练习：统计实例创建的个数

给 `Person` 类增加一个静态字段 `count` 和静态方法 `getCount()`，统计实例创建的个数。

```java
public class Main {  
    public static void main(String[] args) {  
        Person p1 = new Person();  
        Person p2 = new Person();  
        p1.changecount(100);  
        System.out.println(Person.getCount());  
        p2.changecount(233);  
        System.out.println(Person.getCount());  
    }  
}  
  
class Person{  
    public static int count = 0;  
    public void changecount(int i){  
        count = i;  
    }  
    public static int getCount(){  
        return count;  
    }  
}
```

## 3.1.1 包

在 Java 中，我们使用 `package` 来解决名字冲突。

Java 定义了一种名字空间，称之为包：`package`。一个类总是属于某个包，类名（比如 `Person`）只是一个简写，真正的完整类名是 `包名.类名`。

在定义 `class` 的时候，我们需要在第一行声明这个 `class` 属于哪个包。

小明的 `Person.java` 文件：

```java
package ming; // 申明包名ming

public class Person {
}
```

小军的 `Arrays.java` 文件：

```java
package mr.jun; // 申明包名mr.jun

public class Arrays {
}
```

包没有父子关系。`java.util` 和 `java.util.zip` 是不同的包，两者没有任何继承关系。

位于同一个包的类，可以访问包作用域的字段和方法。不用 `public`、`protected`、`private` 修饰的字段和方法就是包作用域。

### import

在一个 `class` 中，我们总会引用其他的 `class`，有三种写法：

第一种，直接写出完整类名

第二种写法是用 `import` 语句，导入小军的 `Arrays`，然后写简单类名

还有一种 `import static` 的语法，它可以导入一个类的静态字段和静态方法：

如果有两个 `class` 名称相同，例如，`mr.jun.Arrays` 和 `java.util.Arrays`，那么只能 `import` 其中一个，另一个必须写完整类名

### 最佳实践

为了避免名字冲突，我们需要确定唯一的包名。推荐的做法是使用倒置的域名来确保唯一性。例如：

- `org.apache`
- `org.apache.commons.log`
- `com.liaoxuefeng.sample`

子包就可以根据功能自行命名。

## 3.1.2 编译和运行

假设我们创建了如下的目录结构：

```text
work
├── bin
└── src
    └── com
        └── itranswarp
            ├── sample
            │   └── Main.java
            └── world
                └── Person.java
```

使用 Windows 的 PowerShell 可以利用 `Get-ChildItem` 来列出指定目录下的所有 `.java` 文件：

```powershell
PS C:\work> (Get-ChildItem -Path .\src -Recurse -Filter *.java).FullName
C:\work\src\com\itranswarp\sample\Main.java
C:\work\src\com\itranswarp\world\Person.java
```

因此，编译命令可写为：

```powershell
PS C:\work> javac -d .\bin (Get-ChildItem -Path .\src -Recurse -Filter *.java).FullName
```

现在，我们就可以直接运行 `class` 文件了。根据当前目录的位置确定 classpath，例如，当前目录仍为 `work`，则 classpath 为 `bin` 或者 `./bin`：

```console
$ java -cp bin com.itranswarp.sample.Main 
Hello, world!
```

请按如下包结构创建工程项目：

```text
oop-package
└── src
    └── com
        └── itranswarp
            ├── sample
            │   └── Main.java
            └── world
                └── Person.java
```

![Pasted image 20261025111222](<images/Pasted image 20261025111222.png>)

## 3.1.3 作用域

在 Java 中，我们经常看到 `public`、`protected`、`private` 这些修饰符。在 Java 中，这些修饰符可以用来限定访问作用域。

如果不确定是否需要 `public`，就不声明为 `public`，即尽可能少地暴露对外的字段和方法。

把方法定义为 `package` 权限有助于测试，因为测试类和被测试类只要位于同一个 `package`，测试代码就可以访问被测试类的 `package` 权限方法。

一个 `.java` 文件只能包含一个 `public` 类，但可以包含多个非 `public` 类。如果有 `public` 类，文件名必须和 `public` 类的名字相同。

### 小结

- Java 内建的访问权限包括 `public`、`protected`、`private` 和 `package` 权限；
- Java 在方法内部定义的变量是局部变量，局部变量的作用域从变量声明开始，到一个块结束；
- `final` 修饰符不是访问权限，它可以修饰 `class`、`field` 和 `method`；
- 一个 `.java` 文件只能包含一个 `public` 类，但可以包含多个非 `public` 类。

## 3.1.4 内部类

有一种类，它被定义在另一个类的内部，所以称为内部类（Nested Class）。Java 的内部类分为好几种，通常情况用得不多，但也需要了解它们是如何使用的。

如果一个类定义在另一个类的内部，这个类就是 Inner Class：

```java
class Outer {
    class Inner {
        // 定义了一个Inner Class
    }
}
```

上述定义的 `Outer` 是一个普通类，而 `Inner` 是一个 Inner Class，它与普通类有个最大的不同，就是 Inner Class 的实例不能单独存在，必须依附于一个 Outer Class 的实例。

Inner Class 和普通 Class 相比，除了能引用 Outer 实例外，还有一个额外的“特权”，就是可以修改 Outer Class 的 `private` 字段，因为 Inner Class 的作用域在 Outer Class 内部，所以能访问 Outer Class 的 `private` 字段和方法。

观察 Java 编译器编译后的 `.class` 文件可以发现，`Outer` 类被编译为 `Outer.class`，而 `Inner` 类被编译为 `Outer$Inner.class`。

### 匿名类

还有一种定义 Inner Class 的方法，它不需要在 Outer Class 中明确地定义这个 Class，而是在方法内部，通过匿名类（Anonymous Class）来定义。

`Runnable` 本身是接口，接口是不能实例化的，所以这里实际上是定义了一个实现了 `Runnable` 接口的匿名类，并且通过 `new` 实例化该匿名类，然后转型为 `Runnable`。在定义匿名类的时候就必须实例化它，定义匿名类的写法如下：

```java
Runnable r = new Runnable() {
    // 实现必要的抽象方法...
};
```

### 静态内部类（Static Nested Class）

最后一种内部类和 Inner Class 类似，但是使用 `static` 修饰，称为静态内部类（Static Nested Class）

用 `static` 修饰的内部类和 Inner Class 有很大的不同，它不再依附于 `Outer` 的实例，而是一个完全独立的类，因此无法引用 `Outer.this`，但它可以访问 `Outer` 的 `private` 静态字段和静态方法。如果把 `StaticNested` 移到 `Outer` 之外，就失去了访问 `private` 的权限。

## 3.1.5 classpath 与 jar

- JVM 通过环境变量 `classpath` 决定搜索 `class` 的路径和顺序；
- 强烈建议**不要设置**系统环境变量 `classpath`，建议始终通过 `-cp` 命令传入；
- jar 包本质上是 zip 格式，相当于目录，可以包含很多 `.class` 文件，方便下载和使用；
- `MANIFEST.MF` 文件可以提供 jar 包的信息，如 `Main-Class`，这样可以直接运行 jar 包。
- 高版本的 JDK 可编译输出低版本兼容的 class 文件，但需注意，低版本的 JDK 可能不存在高版本 JDK 添加的类和方法，导致运行时报错。
- 运行时使用哪个 JDK 版本，编译时就尽量使用同一版本的 JDK 编译源码。

## 3.1.6 模块

- Java 9 引入的模块目的是为了管理依赖；
- 使用模块可以按需打包 JRE；
- 使用模块对类的访问权限有了进一步限制。

![Pasted image 20261025125552](<images/Pasted image 20261025125552.png>)

## 3.2 JAVA核心类

### 字符串

当我们想要比较两个字符串是否相同时，要特别注意，我们实际上是想比较字符串的内容是否相同。必须使用 `equals()` 方法而不能用 `==`。

要忽略大小写比较，使用 `equalsIgnoreCase()` 方法。

`String` 类还提供了多种方法来搜索子串、提取子串。

```java
"Hello".contains("ll"); // true
```

```java
"Hello".indexOf("l"); // 2
"Hello".lastIndexOf("l"); // 3
"Hello".startsWith("He"); // true
"Hello".endsWith("lo"); // true
```

```java
"Hello".substring(2); // "llo"
"Hello".substring(2, 4); "ll"
```

使用 `trim()` 方法可以移除字符串首尾空白字符。空白字符包括空格，`\t`，`\r`，`\n`：

`String` 还提供了 `isEmpty()` 和 `isBlank()` 来判断字符串是否为空和空白字符串

要在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：

```java
String s = "hello";
s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
```

另一种是通过正则表达式替换：

```java
String s = "A,,B;C ,D";
s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
```

要分割字符串，使用 `split()` 方法，并且传入的也是正则表达式：

```java
String s = "A,B,C,D";
String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
```

拼接字符串使用静态方法 `join()`，它用指定的字符串连接字符串数组：

```java
String[] arr = {"A", "B", "C"};
String s = String.join("***", arr);
```

要把任意基本类型或引用类型转换为字符串，可以使用静态方法 `valueOf()`，这是一个重载方法，编译器会根据参数自动选择合适的方法：

要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为 `int` 类型：

```java
int n1 = Integer.parseInt("123"); // 123
int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
```

要特别注意，`Integer` 有个 `getInteger(String)` 方法，它不是将字符串转换为 `int`，而是把该字符串对应的系统变量转换为 `Integer`：

```java
Integer.getInteger("java.version"); // 版本号，11
```

`String` 和 `char[]` 类型可以互相转换，方法是：

```java
char[] cs = "Hello".toCharArray(); // String -> char[]
String s = new String(cs); // char[] -> String
```

### StringBuilder

Java 编译器对 `String` 做了特殊处理，使得我们可以直接用 `+` 拼接字符串。

虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，然后扔掉旧的字符串。这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响 GC 效率。

为了能高效拼接字符串，Java 标准库提供了 `StringBuilder`，它是一个可变对象，可以预分配缓冲区，这样，往 `StringBuilder` 中新增字符时，不会创建新的临时对象：

```java
StringBuilder sb = new StringBuilder(1024);
for (int i = 0; i < 1000; i++) {
    sb.append(',');
    sb.append(i);
}
String s = sb.toString();
```

`StringBuilder` 和 `StringBuffer` 接口完全相同，现在完全没有必要使用 `StringBuffer`。

### 练习：构造 INSERT 语句

请使用 `StringBuilder` 构造一个 `INSERT` 语句：

```java
public static void main(String[] args) {  
    String[] fields = { "name", "position", "salary" };  
    String table = "employee";  
    String insert = buildInsertSql(table, fields);  
    System.out.println(insert);  
    String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";  
    System.out.println(s.equals(insert) ? "测试成功" : "测试失败");  
}  
  
static String buildInsertSql(String table, String[] fields) {  
    StringBuilder sb = new StringBuilder(1024);  
    sb.append("INSERT INTO ").append(table).append(" (");  
    for(int i = 0; i < fields.length; i++){  
        if(i == fields.length - 1){  
            sb.append(fields[i]);  
        }else {  
            sb.append(fields[i]).append(", ");  
        }  
    }  
    sb.append(") VALUES (");  
    for(int i = 0; i < fields.length; i++){  
        if(i == fields.length - 1){  
            sb.append("?");  
        }else {  
            sb.append("?").append(", ");  
        }  
    }  
    sb.append(")");  
    return sb.toString();  
}
```

### StringJoiner

类似用分隔符拼接数组的需求很常见，所以 Java 标准库还提供了一个 `StringJoiner` 来干这个事

`String` 还提供了一个静态方法 `join()`，这个方法在内部使用了 `StringJoiner` 来拼接字符串，在不需要指定“开头”和“结尾”的时候，用 `String.join()` 更方便：

```java
String[] names = {"Bob", "Alice", "Grace"};
var s = String.join(", ", names);
```

#### 练习：构造 SELECT 语句

请使用 `StringJoiner` 构造一个 `SELECT` 语句：

```java
public static void main(String[] args) {  
    String[] fields = { "name", "position", "salary" };  
    String table = "employee";  
    String select = buildSelectSql(table, fields);  
    System.out.println(select);  
    System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");  
}  
  
static String buildSelectSql(String table, String[] fields) {  
    var s = new StringJoiner(", ", "SELECT ", " FROM ");  
    for(String field : fields) s.add(field);  
    String ans = s.toString();  
    return ans + table;  
}
```

### 包装类型

引用类型可以赋值为 `null`，表示空，但基本类型不能赋值为 `null`

那么，如何把一个基本类型视为对象（引用类型）？

比如，想要把 `int` 基本类型变成一个引用类型，我们可以定义一个 `Integer` 类，它只包含一个实例字段 `int`，这样，`Integer` 类就可以视为 `int` 的包装类

实际上，因为包装类型非常有用，Java 核心库为每种基本类型都提供了对应的包装类型：

#### 自动装箱与拆箱（Auto Boxing）

因为 `int` 和 `Integer` 可以互相转换：

```java
int i = 100;
Integer n = Integer.valueOf(i);
int x = n.intValue();
```

所以，Java 编译器可以帮助我们自动在 `int` 和 `Integer` 之间转型：

```java
Integer n = 100; // 编译器自动使用Integer.valueOf(int)
int x = n; // 编译器自动使用Integer.intValue()
```

这种直接把 `int` 变为 `Integer` 的赋值写法，称为自动装箱（Auto Boxing），反过来，把 `Integer` 变为 `int` 的赋值写法，称为自动拆箱（Auto Unboxing）

所有的包装类型都是不变类。我们查看 `Integer` 的源码可知，它的核心代码如下：

```java
public final class Integer {
    private final int value;
}
```

因此，一旦创建了 `Integer` 对象，该对象就是不变的。

对两个 `Integer` 实例进行比较要特别注意：绝对不能用 `==` 比较，因为 `Integer` 是引用类型，必须使用 `equals()` 比较

#### 静态工厂方法

因为 `Integer.valueOf()` 可能始终返回同一个 `Integer` 实例，因此，在我们自己创建 `Integer` 的时候，以下两种方法：

- 方法1：`Integer n = new Integer(100);`
- 方法2：`Integer n = Integer.valueOf(100);`

方法2更好，因为方法1总是创建新的 `Integer` 实例，方法2把内部优化留给 `Integer` 的实现者去做，即使在当前版本没有优化，也有可能在下一个版本进行优化。

我们把能创建“新”对象的静态方法称为静态工厂方法。`Integer.valueOf()` 就是静态工厂方法，它尽可能地返回缓存的实例以节省内存。

**最佳实践**

创建新对象时，优先选用静态工厂方法而不是 new 操作符。

#### Number

最后，所有的整数和浮点数的包装类型都继承自 `Number`，因此，可以非常方便地直接通过包装类型获取各种基本类型：

```java
// 向上转型为Number:
Number num = new Integer(999);
// 获取byte, int, long, float, double:
byte b = num.byteValue();
int n = num.intValue();
long ln = num.longValue();
float f = num.floatValue();
double d = num.doubleValue();
```

### JavaBean

在 Java 中，有很多 `class` 的定义都符合这样的规范：

- 若干 `private` 实例字段；
- 通过 `public` 方法来读写实例字段。

例如：

```java
public class Person {
    private String name;
    private int age;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age; }
}
```

如果读写方法符合以下这种命名规范：

```java
// 读方法:
public Type getXyz()
// 写方法:
public void setXyz(Type value)
```

那么这种 `class` 被称为 `JavaBean`：

我们通常把一组对应的读方法（`getter`）和写方法（`setter`）称为属性（`property`）。例如，`name` 属性：

- 对应的读方法是 `String getName()`
- 对应的写方法是 `setName(String)`

JavaBean 主要用来传递数据，即把一组数据组合成一个 JavaBean 便于传输。此外，JavaBean 可以方便地被 IDE 工具分析，生成读写属性的代码，主要用在图形界面的可视化设计中。

要枚举一个 JavaBean 的所有属性，可以直接使用 Java 核心库提供的 `Introspector`：

```java
import java.beans.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
    }
}
```

- JavaBean 是一种符合命名规范的 `class`，它通过 `getter` 和 `setter` 来定义属性；
- 属性是一种通用的叫法，并非 Java 语法规定；
- 可以利用 IDE 快速生成 `getter` 和 `setter`；
- 使用 `Introspector.getBeanInfo()` 可以获取属性列表。

### 枚举类

为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用 `enum` 来定义枚举类

```java
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}
```

注意到定义枚举类是通过关键字 `enum` 实现的，我们只需依次列出枚举的常量名。

和 `int` 定义的常量相比，使用 `enum` 定义枚举有如下好处：

首先，`enum` 常量本身带有类型信息，即 `Weekday.SUN` 类型是 `Weekday`，编译器会自动检查出类型错误。例如，下面的语句不可能编译通过：

```java
int day = 1;
if (day == Weekday.SUN) { // Compile error: bad operand types for binary operator '=='
}
```

其次，不可能引用到非枚举的值，因为无法通过编译。

最后，不同类型的枚举不能互相比较或者赋值，因为类型不符。例如，不能给一个 `Weekday` 枚举类型的变量赋值为 `Color` 枚举类型的值：

```java
Weekday x = Weekday.SUN; // ok!
Weekday y = Color.RED; // Compile error: incompatible types
```

这就使得编译器可以在编译期自动检查出所有可能的潜在错误。

使用 `enum` 定义的枚举类是一种引用类型。前面我们讲到，引用类型比较，要使用 `equals()` 方法，如果使用 `==` 比较，它比较的是两个引用类型的变量是否是同一个对象。因此，引用类型比较，要始终使用 `equals()` 方法，但 `enum` 类型可以例外。

这是因为 `enum` 类型的每个常量在 JVM 中只有一个唯一实例，所以可以直接用 `==` 比较

因为 `enum` 是一个 `class`，每个枚举的值都是 `class` 实例，因此，这些实例有一些方法：

#### name()

返回常量名，例如：

```java
String s = Weekday.SUN.name(); // "SUN"
```

#### ordinal()

返回定义的常量的顺序，从0开始计数，例如：

```java
int n = Weekday.MON.ordinal(); // 1
```

改变枚举常量定义的顺序就会导致 `ordinal()` 返回值发生变化。

要编写健壮的代码，就不要依靠 `ordinal()` 的返回值。因为 `enum` 本身是 `class`，所以我们可以定义 `private` 的构造方法，并且，给每个枚举常量添加字段：

```java
// enum
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;

    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}
```

这样就无需担心顺序的变化，新增枚举常量时，也需要指定一个 `int` 值。

#### 覆写 toString()

默认情况下，对枚举常量调用 `toString()` 会返回和 `name()` 一样的字符串。但是，`toString()` 可以被覆写，而 `name()` 则不行。我们可以给 `Weekday` 添加 `toString()` 方法

```java
enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}
```

#### 枚举用于 switch

最后，枚举类可以应用在 `switch` 语句中。因为枚举类天生具有类型信息和有限个枚举常量，所以比 `int`、`String` 类型更适合用在 `switch` 语句中：

```java
// switch
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        switch(day) {
        case MON:
        case TUE:
        case WED:
        case THU:
        case FRI:
            System.out.println("Today is " + day + ". Work at office!");
            break;
        case SAT:
        case SUN:
            System.out.println("Today is " + day + ". Work at home!");
            break;
        default:
            throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}
```

### 记录类

使用 `String`、`Integer` 等类型的时候，这些类型都是不变类，一个不变类具有以下特点：

1. 定义 class 时使用 `final`，无法派生子类；
2. 每个字段使用 `final`，保证创建实例后无法修改任何字段。

从 Java 14 开始，引入了新的 `Record` 类。我们定义 `Record` 类时，使用关键字 `record`

编译器默认按照 `record` 声明的变量顺序自动创建一个构造方法，并在方法内给字段赋值。那么问题来了，如果我们要检查参数，应该怎么办？

假设 `Point` 类的 `x`、`y` 不允许负数，我们就得给 `Point` 的构造方法加上检查逻辑：

```java
public record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
}
```

从 Java 14 开始，提供新的 `record` 关键字，可以非常方便地定义 Data Class：

- 使用 `record` 定义的是不变类；
- 可以编写 Compact Constructor 对参数进行验证；
- 可以定义静态方法。

### BigInteger

- `BigInteger` 用于表示任意大小的整数；
- `BigInteger` 是不变类，并且继承自 `Number`；
- 将 `BigInteger` 转换成基本类型时可使用 `longValueExact()` 等方法保证结果准确。

### BigDecimal

- `BigDecimal` 用于表示精确的小数，常用于财务计算；
- 比较 `BigDecimal` 的值是否相等，必须使用 `compareTo()` 而不能使用 `equals()`。

## 3.3 常用工具类

### Math

顾名思义，`Math` 类就是用来进行数学计算的，它提供了大量的静态方法来便于我们实现数学计算

求绝对值：

```java
Math.abs(-100); // 100
Math.abs(-7.8); // 7.8
```

取最大或最小值：

```java
Math.max(100, 99); // 100
Math.min(1.2, 2.3); // 1.2
```

计算 x 的 y 次方：

```java
Math.pow(2, 10); // 2的10次方=1024
```

计算平方根：

```java
Math.sqrt(2); // 1.414...
```

计算 e 的 x 次方：

```java
Math.exp(2); // 7.389...
```

计算以 e 为底的对数：

```java
Math.log(4); // 1.386...
```

计算以10为底的对数：

```java
Math.log10(100); // 2
```

三角函数：

```java
Math.sin(3.14); // 0.00159...
Math.cos(3.14); // -0.9999...
Math.tan(3.14); // -0.0015...
Math.asin(1.0); // 1.57079...
Math.acos(1.0); // 0.0
```

Math 还提供了几个数学常量：

```java
double pi = Math.PI; // 3.14159...
double e = Math.E; // 2.7182818...
Math.sin(Math.PI / 6); // sin(π/6) = 0.5
```

生成一个随机数 x，x 的范围是 `0 <= x < 1`：

```java
Math.random(); // 0.53907... 每次都不一样
```

### HexFormat

在处理 `byte[]` 数组时，我们经常需要与十六进制字符串转换，自己写起来比较麻烦，用 Java 标准库提供的 `HexFormat` 则可以方便地帮我们转换。

要将 `byte[]` 数组转换为十六进制字符串，可以用 `formatHex()` 方法

```java
import java.util.HexFormat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        byte[] data = "Hello".getBytes();
        HexFormat hf = HexFormat.of();
        String hexData = hf.formatHex(data); // 48656c6c6f
    }
}
```

### Random

`Random` 用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的。

要生成一个随机数，可以使用 `nextInt()`、`nextLong()`、`nextFloat()`、`nextDouble()`：

```java
Random r = new Random();
r.nextInt(); // 2071575453,每次都不一样
r.nextInt(10); // 5,生成一个[0,10)之间的int
r.nextLong(); // 8811649292570369305,每次都不一样
r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
r.nextDouble(); // 0.3716...生成一个[0,1)之间的double
```

有童鞋问，每次运行程序，生成的随机数都是不同的，没看出*伪随机数*的特性来。

这是因为我们创建 `Random` 实例时，如果不给定种子，就使用系统当前时间戳作为种子，因此每次运行时，种子不同，得到的伪随机数序列就不同。

如果我们在创建 `Random` 实例时指定一个种子，就会得到完全确定的随机数序列：

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(100));
        }
        // 51, 80, 41, 28, 55...
    }
}
```

前面我们使用的 `Math.random()` 实际上内部调用了 `Random` 类，所以它也是伪随机数，只是我们无法指定种子。

### SecureRandom

`SecureRandom` 的安全性是通过操作系统提供的安全的随机种子来生成随机数。这个种子是通过 CPU 的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。

在密码学中，安全的随机数非常重要。如果使用不安全的伪随机数，所有加密体系都将被攻破。因此，时刻牢记必须使用 `SecureRandom` 来产生安全的随机数。

> **注意**
>
> 需要使用安全随机数的时候，必须使用 `SecureRandom`，绝不能使用 `Random`！

## 4. 异常处理

程序运行的时候，经常会发生各种错误。

本章我们讨论如何在 Java 程序中处理各种异常情况。

有一些错误是用户造成的，比如，希望用户输入一个 `int` 类型的年龄，但是用户的输入是 `abc`

程序想要读写某个文件的内容，但是用户已经把它删除了

所以，一个健壮的程序必须处理各种各样的错误。

所谓错误，就是程序调用某个函数的时候，如果失败了，就表示出错。

调用方如何获知调用失败的信息？有两种方法：

### 方法一：约定返回错误码

例如，处理一个文件，如果返回 `0`，表示成功，返回其他整数，表示约定的错误码：

```java
int code = processFile("C:\\test.txt");
if (code == 0) {
    // ok:
} else {
    // error:
    switch (code) {
    case 1:
        // file not found:
    case 2:
        // no read permission:
    default:
        // unknown error:
    }
}
```

因为使用 `int` 类型的错误码，想要处理就非常麻烦。这种方式常见于底层 C 函数。

### 方法二：在语言层面上提供一个异常处理机制

Java 内置了一套异常处理机制，总是使用异常来表示错误。

异常是一种 `class`，因此它本身带有类型信息。异常可以在任何地方抛出，但只需要在上层捕获，这样就和方法调用分离了：

```java
try {
    String s = processFile("C:\\test.txt");
    // ok:
} catch (FileNotFoundException e) {
    // file not found:
} catch (SecurityException e) {
    // no read permission:
} catch (IOException e) {
    // io error:
} catch (Exception e) {
    // other error:
}
```

### 异常继承体系

因为 Java 的异常是 `class`，它的继承关系如下：

```text
                     ┌───────────┐
                     │  Object   │
                     └───────────┘
                           ▲
                           │
                     ┌───────────┐
                     │ Throwable │
                     └───────────┘
                           ▲
                 ┌─────────┴─────────┐
                 │                   │
           ┌───────────┐       ┌───────────┐
           │   Error   │       │ Exception │
           └───────────┘       └───────────┘
                 ▲                   ▲
         ┌───────┘              ┌────┴──────────┐
         │                      │               │
┌─────────────────┐    ┌─────────────────┐┌───────────┐
│OutOfMemoryError │... │RuntimeException ││IOException│...
└─────────────────┘    └─────────────────┘└───────────┘
                               ▲
                   ┌───────────┴─────────────┐
                   │                         │
        ┌─────────────────────┐ ┌─────────────────────────┐
        │NullPointerException │ │IllegalArgumentException │...
        └─────────────────────┘ └─────────────────────────┘

```

从继承关系可知：`Throwable` 是异常体系的根，它继承自 `Object`。`Throwable` 有两个体系：`Error` 和 `Exception`，`Error` 表示严重的错误，程序对此一般无能为力

而 `Exception` 则是运行时的错误，它可以被捕获并处理。

`Exception` 又分为两大类：

1. `RuntimeException` 以及它的子类；
2. 非 `RuntimeException`（包括 `IOException`、`ReflectiveOperationException` 等等）

### Checked 与 Unchecked

Java 规定：

- 必须捕获的异常，包括 `Exception` 及其子类，但不包括 `RuntimeException` 及其子类，这种类型的异常称为 Checked Exception。
- 不需要捕获的异常，包括 `Error` 及其子类，`RuntimeException` 及其子类。

### 捕获异常 try-catch

捕获异常使用 `try...catch` 语句，把可能发生异常的代码放到 `try {...}` 中，然后使用 `catch` 捕获对应的 `Exception` 及其子类：

```java
// try...catch
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) {
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
            System.out.println(e); // 打印异常信息
            return s.getBytes(); // 尝试使用默认编码
        }
    }
}
```

如果我们不捕获 `UnsupportedEncodingException`，会出现编译失败的问题：

```java
// try...catch
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) {
        return s.getBytes("GBK");
    }
}
```

- Java 使用异常来表示错误，并通过 `try ... catch` 捕获异常；
- Java 的异常是 `class`，并且从 `Throwable` 继承；
- `Error` 是无需捕获的严重错误，`Exception` 是应该捕获的可处理的错误；
- `RuntimeException` 无需强制捕获，非 `RuntimeException`（Checked Exception）需强制捕获，或者用 `throws` 声明；
- 不推荐捕获了异常但不进行任何处理。

### 多个 catch 的顺序

在多个 `catch` 的时候，`catch` 的顺序非常重要：子类必须写在前面。例如：

```java
public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException e) {
        System.out.println("IO error");
    } catch (UnsupportedEncodingException e) { // 永远捕获不到
        System.out.println("Bad encoding");
    }
}
```

对于上面的代码，`UnsupportedEncodingException` 异常是永远捕获不到的，因为它是 `IOException` 的子类。当抛出 `UnsupportedEncodingException` 异常时，会被 `catch (IOException e) { ... }` 捕获并执行。

因此，正确的写法是把子类放到前面：

```java
public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (UnsupportedEncodingException e) {
        System.out.println("Bad encoding");
    } catch (IOException e) {
        System.out.println("IO error");
    }
}
```

### finally 语句

无论是否有异常发生，如果我们都希望执行一些语句，例如清理工作，怎么写？

Java 的 `try ... catch` 机制还提供了 `finally` 语句，`finally` 语句块保证有无错误都会执行。

```java
public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (UnsupportedEncodingException e) {
        System.out.println("Bad encoding");
    } catch (IOException e) {
        System.out.println("IO error");
    } finally {
        System.out.println("END");
    }
}
```

注意 `finally` 有几个特点：

1. `finally` 语句不是必须的，可写可不写；
2. `finally` 总是最后执行。

如果没有发生异常，就正常执行 `try { ... }` 语句块，然后执行 `finally`。如果发生了异常，就中断执行 `try { ... }` 语句块，然后跳转执行匹配的 `catch` 语句块，最后执行 `finally`。

可见，`finally` 是用来保证一些代码必须执行的。

某些情况下，可以没有 `catch`，只使用 `try ... finally` 结构。例如：

```java
void process(String file) throws IOException {
    try {
        ...
    } finally {
        System.out.println("END");
    }
}
```

- 捕获异常时，多个 `catch` 语句的匹配顺序非常重要，子类必须放在前面；
- `finally` 语句保证了有无异常都会执行，它是可选的；
- 一个 `catch` 语句也可以匹配多个非继承关系的异常，可以把它两用 `|` 合并到一起。

#### 练习：捕获异常

```java
public static void main(String[] args) {  
    try {  
       String a = "12";  
       String b = "x9";  
       int c = stringToInt(a);  
       int d = stringToInt(b);  
       System.out.println(c * d);  
    }catch (Exception e){  
       System.out.println(e);  
    }  
}  
  
static int stringToInt(String s) {  
    return Integer.parseInt(s);  
}
```

### 异常的传播（调用栈）

当某个方法抛出了异常时，如果当前方法没有捕获异常，异常就会被抛到上层调用方法，直到遇到某个 `try ... catch` 被捕获为止

通过 `printStackTrace()` 可以打印出方法的调用栈，类似

```java
java.lang.NumberFormatException: null
    at java.base/java.lang.Integer.parseInt(Integer.java:614)
    at java.base/java.lang.Integer.parseInt(Integer.java:770)
    at Main.process2(Main.java:16)
    at Main.process1(Main.java:12)
    at Main.main(Main.java:5)
```

### 抛出异常 throw

当发生错误时，例如，用户输入了非法的字符，我们就可以抛出异常。

参考 `Integer.parseInt()` 方法，抛出异常分两步：

1. 创建某个 `Exception` 的实例；
2. 用 `throw` 语句抛出。

实际上，绝大部分抛出异常的代码都会合并写成一行：

```java
void process2(String s) {
    if (s==null) {
        throw new NullPointerException();
    }
}
```

### 异常转换与 cause

如果一个方法捕获了某个异常后，又在 `catch` 子句中抛出新的异常，就相当于把抛出的异常类型“转换”了：

```java
void process1(String s) {
    try {
        process2();
    } catch (NullPointerException e) {
        throw new IllegalArgumentException();
    }
}

void process2(String s) {
    if (s==null) {
        throw new NullPointerException();
    }
}
```

当 `process2()` 抛出 `NullPointerException` 后，被 `process1()` 捕获，然后抛出 `IllegalArgumentException()`。

如果在 `main()` 中捕获 `IllegalArgumentException`，我们看看打印的异常栈：

```java
// exception
public class Main {
    public static void main(String[] args) {
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    static void process2() {
        throw new NullPointerException();
    }
}
```

打印出的异常栈类似：

```plain
java.lang.IllegalArgumentException
    at Main.process1(Main.java:15)
    at Main.main(Main.java:5)
```

这说明新的异常丢失了原始异常信息，我们已经看不到原始异常 `NullPointerException` 的信息了。

为了能追踪到完整的异常栈，在构造异常的时候，把原始的 `Exception` 实例传进去，新的 `Exception` 就可以持有原始 `Exception` 信息。

在代码中获取原始异常可以使用 `Throwable.getCause()` 方法。如果返回 `null`，说明已经是“根异常”了。

有了完整的异常栈的信息，我们才能快速定位并修复代码的问题。

**最佳实践**

捕获到异常并再次抛出时，一定要留住原始异常，否则很难定位第一案发现场！

在 `catch` 中抛出异常，不会影响 `finally` 的执行。JVM 会先执行 `finally`，然后抛出异常

### 异常屏蔽（Suppressed Exception）

如果在执行 `finally` 语句时抛出异常，那么，`catch` 语句的异常还能否继续抛出？例如：

```java
// exception
public class Main {
    public static void main(String[] args) {
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
            throw new IllegalArgumentException();
        }
    }
}
```

执行上述代码，发现异常信息如下：

```plain
catched
finally
Exception in thread "main" java.lang.IllegalArgumentException
    at Main.main(Main.java:11)
```

这说明 `finally` 抛出异常后，原来在 `catch` 中准备抛出的异常就“消失”了，因为只能抛出一个异常。没有被抛出的异常称为“被屏蔽”的异常（Suppressed Exception）。

在极少数的情况下，我们需要获知所有的异常。如何保存所有的异常信息？方法是先用 `origin` 变量保存原始异常，然后调用 `Throwable.addSuppressed()`，把原始异常添加进来，最后在 `finally` 抛出：

```java
// exception
public class Main {
    public static void main(String[] args) throws Exception {
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }
}
```

当 `catch` 和 `finally` 都抛出了异常时，虽然 `catch` 的异常被屏蔽了，但是，`finally` 抛出的异常仍然包含了它

绝大多数情况下，在 `finally` 中不要抛出异常。因此，我们通常不需要关心 `Suppressed Exception`

异常打印的详细的栈信息是找出问题的关键，许多初学者在提问时只贴代码，不贴异常，相当于只报案不给线索，福尔摩斯也无能为力。

### Java 常用异常

Java 标准库定义的常用异常包括：

```text
Exception
├─ RuntimeException
│  ├─ NullPointerException
│  ├─ IndexOutOfBoundsException
│  ├─ SecurityException
│  └─ IllegalArgumentException
│     └─ NumberFormatException
├─ IOException
│  ├─ UnsupportedCharsetException
│  ├─ FileNotFoundException
│  └─ SocketException
├─ ParseException
├─ GeneralSecurityException
├─ SQLException
└─ TimeoutException
```

### 自定义异常

在一个大型项目中，可以自定义新的异常类型，但是，保持一个合理的异常继承体系是非常重要的。

一个常见的做法是自定义一个 `BaseException` 作为“根异常”，然后，派生出各种业务类型的异常。

`BaseException` 需要从一个适合的 `Exception` 派生，通常建议从 `RuntimeException` 派生：

```java
public class BaseException extends RuntimeException {
}
```

其他业务类型的异常就可以从 `BaseException` 派生：

```java
public class UserNotFoundException extends BaseException {
}

public class LoginFailedException extends BaseException {
}
```

自定义的 `BaseException` 应该提供多个构造方法：

```java
public class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
```

上述构造方法实际上都是原样照抄 `RuntimeException`。这样，抛出异常的时候，就可以选择合适的构造方法。通过 IDE 可以根据父类快速生成子类的构造方法。

### NullPointerException（NPE）

在所有的 `RuntimeException` 异常中，Java 程序员最熟悉的恐怕就是 `NullPointerException` 了。

`NullPointerException` 即空指针异常，俗称 NPE。如果一个对象为 `null`，调用其方法或访问其字段就会产生 `NullPointerException`，这个异常通常是由 JVM 抛出的，例如：

```java
// NullPointerException
public class Main {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.toLowerCase());
    }
}
```

指针这个概念实际上源自 C 语言，Java 语言中并无指针。我们定义的变量实际上是引用，Null Pointer 更确切地说是 Null Reference，不过两者区别不大。

如果遇到 `NullPointerException`，我们应该如何处理？首先，必须明确，`NullPointerException` 是一种代码逻辑错误，遇到 `NullPointerException`，遵循原则是早暴露，早修复，严禁使用 `catch` 来隐藏这种编码错误

好的编码习惯可以极大地降低 `NullPointerException` 的产生，例如：

- 成员变量在定义时初始化：
- 返回空字符串 `""`、空数组而不是 `null`
- 如果调用方一定要根据 `null` 判断，比如返回 `null` 表示文件不存在，那么考虑返回 `Optional<T>`

```java
public Optional<String> readFromFile(String file) {
    if (!fileExist(file)) {
        return Optional.empty();
    }
    ...
}
```

这样调用方必须通过 `Optional.isPresent()` 判断是否有结果。

#### 定位 NullPointerException

- `NullPointerException` 是 Java 代码常见的逻辑错误，应当早暴露，早修复；
- 可以启用 Java 14 的增强异常信息来查看 `NullPointerException` 的详细错误信息。

### 断言（Assertion）

断言（Assertion）是一种调试程序的方式。在 Java 中，使用 `assert` 关键字来实现断言。

```java
public static void main(String[] args) {
    double x = Math.abs(-123.45);
    assert x >= 0;
    System.out.println(x);
}
```

语句 `assert x >= 0;` 即为断言，断言条件 `x >= 0` 预期为 `true`。如果计算结果为 `false`，则断言失败，抛出 `AssertionError`。

使用 `assert` 语句时，还可以添加一个可选的断言消息：

```java
assert x >= 0 : "x must >= 0";
```

这样，断言失败的时候，`AssertionError` 会带上消息 `x must >= 0`，更加便于调试。

JVM 默认关闭断言指令，即遇到 `assert` 语句就自动忽略了，不执行。

要执行 `assert` 语句，必须给 Java 虚拟机传递 `-enableassertions`（可简写为 `-ea`）参数启用断言。所以，上述程序必须在命令行下运行才有效果：

```plain
$ java -ea Main.java
Exception in thread "main" java.lang.AssertionError
	at Main.main(Main.java:5)
```

实际开发中，很少使用断言。更好的方法是编写单元测试，后续我们会讲解 `JUnit` 的使用。

### 日志

#### 使用 JDK Logging

输出日志，而不是用 `System.out.println()`，有以下几个好处：

1. 可以设置输出样式，避免自己每次都写 `"ERROR: " + var`；
2. 可以设置输出级别，禁止某些级别输出。例如，只输出错误日志；
3. 可以被重定向到文件，这样可以在程序运行结束后查看日志；
4. 可以按包名控制日志级别，只输出某些包打的日志；

#### Commons Logging

和 Java 标准库提供的日志不同，Commons Logging 是一个第三方日志库，它是由 Apache 创建的日志模块

使用 Commons Logging 只需要和两个类打交道，并且只有两步：

第一步，通过 `LogFactory` 获取 `Log` 类的实例；第二步，使用 `Log` 实例的方法打日志。

- Commons Logging 是使用最广泛的日志模块；
- Commons Logging 的 API 非常简单；
- Commons Logging 可以自动检测并使用其他日志模块。

### 日志（补充）

通过 Commons Logging 实现日志，不需要修改代码即可使用 Log4j；

使用 Log4j 只需要把 `log4j2.xml` 和相关 jar 放入 classpath；

如果要更换 Log4j，只需要移除 `log4j2.xml` 和相关 jar；

只有扩展 Log4j 时，才需要引用 Log4j 的接口（例如，将日志加密写入数据库的功能，需要自己开发）。

SLF4J 和 Logback 可以取代 Commons Logging 和 Log4j；

始终使用 SLF4J 的接口写入日志，使用 Logback 只需要配置，不需要修改代码。

## 5. 反射

反射就是 Reflection，Java 的反射是指程序在运行期可以拿到一个对象的所有信息。

正常情况下，如果我们要调用一个对象的方法，或者访问一个对象的字段，通常会传入对象实例：

```java
// Main.java
import com.itranswarp.learnjava.Person;

public class Main {
    String getFullName(Person p) {
        return p.getFirstName() + " " + p.getLastName();
    }
}
```

但是，如果不能获得 `Person` 类，只有一个 `Object` 实例，比如这样：

```java
String getFullName(Object obj) {
    return ???
}
```

这时候，为了解决这个问题，我们就需要用到反射。

反射是为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法。

### 5.1 Class

除了 `int` 等基本类型外，Java 的其他类型全部都是 `class`（包括 `interface`）。例如：

- `String`
- `Object`
- `Runnable`
- `Exception`

可以知道：`class`（包括 `interface`）的本质是数据类型（`Type`）。无继承关系的数据类型无法赋值

而 `class` 是由 JVM 在执行过程中动态加载的。JVM 在第一次读取到一种 `class` 类型时，将其加载进内存。

每加载一种 `class`，JVM 就为其创建一个 `Class` 类型的实例，并关联起来。注意：这里的 `Class` 类型是一个名叫 `Class` 的 `class`。它长这样：

```java
public final class Class {
    private Class() {}
}
```

由于 JVM 为每个加载的 `class` 创建了对应的 `Class` 实例，并在实例中保存了该 `class` 的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个 `Class` 实例，我们就可以通过这个 `Class` 实例获取到该实例对应的 `class` 的所有信息。

这种通过 `Class` 实例获取 `class` 信息的方法称为反射（Reflection）。

如何获取一个 `class` 的 `Class` 实例：

方法一：直接通过一个 `class` 的静态变量 `class` 获取：

```java
Class cls = String.class;
```

方法二：如果我们有一个实例变量，可以通过该实例变量提供的 `getClass()` 方法获取：

```java
String s = "Hello";
Class cls = s.getClass();
```

方法三：如果知道一个 `class` 的完整类名，可以通过静态方法 `Class.forName()` 获取：

```java
Class cls = Class.forName("java.lang.String");
```

通常情况下，我们应该用 `instanceof` 判断数据类型，因为面向抽象编程的时候，我们不关心具体的子类型。只有在需要精确判断一个类型是不是某个 `class` 的时候，我们才使用 `==` 判断 `class` 实例。

因为反射的目的是为了获得某个实例的信息。因此，当我们拿到某个 `Object` 实例时，我们可以通过反射获取该 `Object` 的 `class` 信息：

```java
void printObjectInfo(Object obj) {
    Class cls = obj.getClass();
}
```

如果获取到了一个 `Class` 实例，我们就可以通过该 `Class` 实例来创建对应类型的实例：

```java
// 获取String的Class实例:
Class cls = String.class;
// 创建一个String实例:
String s = (String) cls.newInstance();
```

上述代码相当于 `new String()`。通过 `Class.newInstance()` 可以创建类实例，它的局限是：只能调用 `public` 的无参数构造方法。带参数的构造方法，或者非 `public` 的构造方法都无法通过 `Class.newInstance()` 被调用。

#### 动态加载

JVM 在执行 Java 程序的时候，并不是一次性把所有用到的 class 全部加载到内存，而是第一次需要用到 class 时才加载。

- JVM 为每个加载的 `class` 及 `interface` 创建了对应的 `Class` 实例来保存 `class` 及 `interface` 的所有信息；
- 获取一个 `class` 对应的 `Class` 实例后，就可以获取该 `class` 的所有信息；
- 通过 Class 实例获取 `class` 信息的方法称为反射（Reflection）；
- JVM 总是动态加载 `class`，可以在运行期根据条件来控制加载 class。

动态加载 `class` 的特性对于 Java 程序非常重要。利用 JVM 动态加载 `class` 的特性，我们才能在运行期根据条件加载不同的实现类。例如，Commons Logging 总是优先使用 Log4j，只有当 Log4j 不存在时，才使用 JDK 的 logging。利用 JVM 动态加载特性，大致的实现代码如下：

```java
// Commons Logging优先使用Log4j:
LogFactory factory = null;
if (isClassPresent("org.apache.logging.log4j.Logger")) {
    factory = createLog4j();
} else {
    factory = createJdkLog();
}

boolean isClassPresent(String name) {
    try {
        Class.forName(name);
        return true;
    } catch (Exception e) {
        return false;
    }
}
```

这就是为什么我们只需要把 Log4j 的 jar 包放到 classpath 中，Commons Logging 就会自动使用 Log4j

### 5.2 访问字段

对任意的一个 `Object` 实例，只要我们获取了它的 `Class`，就可以获取它的一切信息。

`Class` 类提供了以下几个方法来获取字段：

- `Field getField(name)`：根据字段名获取某个 public 的 field（包括父类）
- `Field getDeclaredField(name)`：根据字段名获取当前类的某个 field（不包括父类）
- `Field[] getFields()`：获取所有 public 的 field（包括父类）
- `Field[] getDeclaredFields()`：获取当前类的所有 field（不包括父类）

利用反射拿到字段的一个 `Field` 实例只是第一步，我们还可以拿到一个实例对应的该字段的值

例如，对于一个 `Person` 实例，我们可以先拿到 `name` 字段对应的 `Field`，再获取这个实例的 `name` 字段的值：

```java
// reflection
import java.lang.reflect.Field;
public class Main {

    public static void main(String[] args) throws Exception {
        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
```

上述代码先获取 `Class` 实例，再获取 `Field` 实例，然后，用 `Field.get(Object)` 获取指定实例的指定字段的值。

运行代码，如果不出意外，会得到一个 `IllegalAccessException`，这是因为 `name` 被定义为一个 `private` 字段，正常情况下，`Main` 类无法访问 `Person` 类的 `private` 字段。要修复错误，可以将 `private` 改为 `public`，或者，在调用 `Object value = f.get(p);` 前，先写一句：

```java
f.setAccessible(true);
```

调用 `Field.setAccessible(true)` 的意思是，别管这个字段是不是 `public`，一律允许访问。

反射是一种非常规的用法，使用反射，首先代码非常繁琐，其次，它更多地是给工具或者底层框架来使用，目的是在不知道目标实例任何信息的情况下，获取特定字段的值。

此外，`setAccessible(true)` 可能会失败。如果 JVM 运行期存在 `SecurityManager`，那么它会根据规则进行检查，有可能阻止 `setAccessible(true)`。例如，某个 `SecurityManager` 可能不允许对 `java` 和 `javax` 开头的 `package` 的类调用 `setAccessible(true)`，这样可以保证 JVM 核心库的安全。

#### 设置字段值

设置字段值是通过 `Field.set(Object, Object)` 实现的，其中第一个 `Object` 参数是指定的实例，第二个 `Object` 参数是待修改的值。

```java
// reflection
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        Person p = new Person("Xiao Ming");
        System.out.println(p.getName()); // "Xiao Ming"
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p, "Xiao Hong");
        System.out.println(p.getName()); // "Xiao Hong"
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```

Java 的反射 API 提供的 `Field` 类封装了字段的所有信息：

- 通过 `Class` 实例的方法可以获取 `Field` 实例：`getField()`，`getFields()`，`getDeclaredField()`，`getDeclaredFields()`；
- 通过 Field 实例可以获取字段信息：`getName()`，`getType()`，`getModifiers()`；
- 通过 Field 实例可以读取或设置某个对象的字段，如果存在访问限制，要首先调用 `setAccessible(true)` 来访问非 `public` 字段。
- 通过反射读写字段是一种非常规方法，它会破坏对象的封装。

#### 练习：通过反射修改字段内容

```java
public class Main {  
  
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {  
        String name = "Xiao Ming";  
        int age = 20;  
        Person p = new Person();  
        // TODO: 利用反射给name和age字段赋值:  
        // 1.获取class  
        Class c = p.getClass();  
        // 2.获取field  
        Field f = c.getDeclaredField("name");  
        Field fa = c.getDeclaredField("age");  
        // 3.对field使用set进行修改  
        f.setAccessible(true);  
        f.set(p, "Nai Long");  
        fa.setAccessible(true);  
        fa.set(p, 18);  
  
        System.out.println(p.getName()); // "Xiao Ming"  
        System.out.println(p.getAge()); // 20  
    }  
}  
  
class Person {  
    private String name;  
    private int age;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
}
```

### 5.3 调用方法

可以通过 `Class` 实例获取所有 `Method` 信息。`Class` 类提供了以下几个方法来获取 `Method`：

- `Method getMethod(name, Class...)`：获取某个 `public` 的 `Method`（包括父类）
- `Method getDeclaredMethod(name, Class...)`：获取当前类的某个 `Method`（不包括父类）
- `Method[] getMethods()`：获取所有 `public` 的 `Method`（包括父类）
- `Method[] getDeclaredMethods()`：获取当前类的所有 `Method`（不包括父类）

一个 `Method` 对象包含一个方法的所有信息：

- `getName()`：返回方法名称，例如：`"getScore"`；
- `getReturnType()`：返回方法返回值类型，也是一个 Class 实例，例如：`String.class`；
- `getParameterTypes()`：返回方法的参数类型，是一个 Class 数组，例如：`{String.class, int.class}`；
- `getModifiers()`：返回方法的修饰符，它是一个 `int`，不同的 bit 表示不同的含义。

当我们获取到一个 `Method` 对象时，就可以对它进行调用。

如果用反射来调用 `substring` 方法，需要以下代码：

```java
// reflection
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6);
        // 打印调用结果:
        System.out.println(r); // "world"
    }
}
```

注意到 `substring()` 有两个重载方法，我们获取的是 `String substring(int)` 这个方法。

对 `Method` 实例调用 `invoke` 就相当于调用该方法，`invoke` 的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错。

如果获取到的 Method 表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以 `invoke` 方法传入的第一个参数永远为 `null`。

和 Field 类似，对于非 public 方法，我们虽然可以通过 `Class.getDeclaredMethod()` 获取该方法实例，但直接对其调用将得到一个 `IllegalAccessException`。为了调用非 public 方法，我们通过 `Method.setAccessible(true)` 允许其调用

#### 多态

使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。

```java
public class Main {  
    public static void main(String[] args) throws Exception {  
        // 获取Person的hello方法:  
        Method h = Person.class.getMethod("hello");  
        // 对Student实例调用hello方法:  
        h.invoke(new Student());  
        h.invoke(new Person());  
    }  
}  
  
class Person {  
    public void hello() {  
        System.out.println("Person:hello");  
    }  
}  
  
class Student extends Person {  
    public void hello() {  
        System.out.println("Student:hello");  
    }  
}
```

#### 练习：利用反射调用方法

```java
public class Main {  
  
    public static void main(String[] args) throws Exception {  
        String name = "Xiao Ming";  
        int age = 20;  
        Person p = new Person();  
        // TODO: 利用反射调用setName和setAge方法:  
        // 1.获取class  
        Class c = Person.class;  
        // 2.获取method  
        Method m = c.getDeclaredMethod("setName", String.class);  
        Method m2 = c.getDeclaredMethod("setAge", int.class);  
        // 3.进行调用  
        m.invoke(p, name);  
        m2.invoke(p, age);  
        System.out.println(p.getName()); // "Xiao Ming"  
        System.out.println(p.getAge()); // 20  
    }  
}  
  
class Person {  
    private String name;  
    private int age;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
}
```

Java 的反射 API 提供的 Method 对象封装了方法的所有信息：

- 通过 `Class` 实例的方法可以获取 `Method` 实例：`getMethod()`，`getMethods()`，`getDeclaredMethod()`，`getDeclaredMethods()`；
- 通过 `Method` 实例可以获取方法信息：`getName()`，`getReturnType()`，`getParameterTypes()`，`getModifiers()`；
- 通过 `Method` 实例可以调用某个对象的方法：`Object invoke(Object instance, Object... parameters)`；
- 通过设置 `setAccessible(true)` 来访问非 `public` 方法；
- 通过反射调用方法时，仍然遵循多态原则。

### 调用构造方法

我们通常使用 `new` 操作符创建新的实例：

```java
Person p = new Person();
```

如果通过反射来创建新的实例，可以调用 Class 提供的 newInstance() 方法，它只能调用该类的 public 无参数构造方法。如果构造方法带有参数，或者不是 public，就无法直接通过 `Class.newInstance()` 来调用：

```java
Person p = Person.class.newInstance();
```

`Constructor` 对象，它包含一个构造方法的所有信息，可以创建一个实例。`Constructor` 对象和 Method 非常类似，不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例

```java
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
        // 获取构造方法Integer(int):
        Constructor cons1 = Integer.class.getConstructor(int.class);
        // 调用构造方法:
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        // 获取构造方法Integer(String)
        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("456");
        System.out.println(n2);
    }
}
```

通过 Class 实例获取 Constructor 的方法如下：

- `getConstructor(Class...)`：获取某个 `public` 的 `Constructor`；
- `getDeclaredConstructor(Class...)`：获取某个 `Constructor`；
- `getConstructors()`：获取所有 `public` 的 `Constructor`；
- `getDeclaredConstructors()`：获取所有 `Constructor`。

注意 `Constructor` 总是当前类定义的构造方法，和父类无关，因此不存在多态的问题。

调用非 `public` 的 `Constructor` 时，必须首先通过 `setAccessible(true)` 设置允许访问。`setAccessible(true)` 可能会失败。

### 获取继承关系

有了 `Class` 实例，我们还可以获取它的父类的 `Class`

```java
// reflection
public class Main {
    public static void main(String[] args) throws Exception {
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
    }
}
```

由于一个类可能实现一个或多个接口，通过 `Class` 我们就可以查询到实现的接口类型。例如，查询 `Integer` 实现的接口：

```java
// reflection
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
    }
}
```

运行上述代码可知，`Integer` 实现的接口有：

- `java.lang.Comparable`
- `java.lang.constant.Constable`
- `java.lang.constant.ConstantDesc`

要特别注意：`getInterfaces()` 只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型

两个 `Class` 实例，要判断一个向上转型是否成立，可以调用 `isAssignableFrom()`：

```java
// Integer i = ?
Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
// Number n = ?
Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
// Object o = ?
Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
// Integer i = ?
Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
```

### 动态代理

- 可以实例化 `class`（非 `abstract`）；
- 不能实例化 `interface`

所有 `interface` 类型的变量总是通过某个实例向上转型并赋值给接口类型变量的：

```java
CharSequence cs = new StringBuilder();
```

动态代理（Dynamic Proxy）：可以在运行期动态创建某个 `interface` 的实例。

动态代码：先定义接口 `Hello`，但是并不去编写实现类，而是直接通过 JDK 提供的一个 `Proxy.newProxyInstance()` 创建了一个 `Hello` 接口对象。

JDK 提供的动态创建接口对象的方式，就叫动态代理。

一个最简单的动态代理实现如下：

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
            Hello.class.getClassLoader(), // 传入ClassLoader
            new Class[] { Hello.class }, // 传入要实现的接口
            handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}

interface Hello {
    void morning(String name);
}
```

在运行期动态创建一个 `interface` 实例的方法如下：

1. 定义一个 `InvocationHandler` 实例，它负责实现接口的方法调用；
2. 通过 `Proxy.newProxyInstance()` 创建 `interface` 实例，它需要3个参数：
   1. 使用的 `ClassLoader`，通常就是接口类的 `ClassLoader`；
   2. 需要实现的接口数组，至少需要传入一个接口进去；
   3. 用来处理接口方法调用的 `InvocationHandler` 实例。
3. 将返回的 `Object` 强制转型为接口。

- Java 标准库提供了动态代理功能，允许在运行期动态创建一个接口的实例；
- 动态代理是通过 `Proxy` 创建代理对象，然后将接口方法“代理”给 `InvocationHandler` 完成的。

## 6. 注解

注解是放在 Java 源码的类、方法、字段、参数前的一种特殊“注释”：

注释会被编译器直接忽略，注解则可以被编译器打包进入 class 文件，因此，注解是一种用作标注的“元数据”

Java 的注解分为三类：

**第一类**是由编译器使用的注解，例如：

- `@Override`：让编译器检查该方法是否正确地实现了覆写；
- `@SuppressWarnings`：告诉编译器忽略此处代码产生的警告。

这类注解不会被编译进入 `.class` 文件

**第二类**是由工具处理 `.class` 文件使用的注解，比如有些工具会在加载 class 的时候，对 class 做动态修改，实现一些特殊的功能。这类注解会被编译进入 `.class` 文件，但加载结束后并不会存在于内存中。

**第三类**是在程序运行期能够读取的注解，它们在加载后一直存在于 JVM 中，这也是最常用的注解。例如，一个配置了 `@PostConstruct` 的方法会在调用构造方法后自动被调用。

定义注解时，还可以定义配置参数，包括：

- 所有基本类型；
- String；
- 枚举类型；
- 基本类型、String、Class 以及枚举的数组。

- 注解（Annotation）是 Java 语言用于工具处理的标注；
- 注解可以配置参数，没有指定配置的参数使用默认值；
- 如果参数名称是 `value`，且只有一个参数，那么可以省略参数名称。

### 定义注解

Java 语言使用 `@interface` 语法来定义注解

```java
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
```

### 元注解

有一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）。Java 标准库已经定义了一些元注解，我们只需要使用元注解，通常不需要自己去编写元注解。

#### @Target

最常用的元注解是 `@Target`。使用 `@Target` 可以定义 `Annotation` 能够被应用于源码的哪些位置：

- 类或接口：`ElementType.TYPE`；
- 字段：`ElementType.FIELD`；
- 方法：`ElementType.METHOD`；
- 构造方法：`ElementType.CONSTRUCTOR`；
- 方法参数：`ElementType.PARAMETER`。

#### @Retention

另一个重要的元注解 `@Retention` 定义了 `Annotation` 的生命周期：

- 仅编译期：`RetentionPolicy.SOURCE`；
- 仅 class 文件：`RetentionPolicy.CLASS`；
- 运行期：`RetentionPolicy.RUNTIME`。

如果 `@Retention` 不存在，则该 `Annotation` 默认为 `CLASS`。因为通常我们自定义的 `Annotation` 都是 `RUNTIME`，所以，务必要加上 `@Retention(RetentionPolicy.RUNTIME)` 这个元注解

#### @Repeatable

使用 `@Repeatable` 这个元注解可以定义 `Annotation` 是否可重复。

#### @Inherited

使用 `@Inherited` 定义子类是否可继承父类定义的 `Annotation`。`@Inherited` 仅针对 `@Target(ElementType.TYPE)` 类型的 `annotation` 有效，并且仅针对 `class` 的继承，对 `interface` 的继承无效

在使用的时候，如果一个类用到了 `@Report`，则它的子类默认也定义了该注解：

### 定义 Annotation 的步骤

第一步，用 `@interface` 定义注解：

```java
public @interface Report {
}
```

第二步，添加参数、默认值：

```java
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
```

第三步，用元注解配置注解：

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
```

其中，必须设置 `@Target` 和 `@Retention`，`@Retention` 一般设置为 `RUNTIME`，因为我们自定义的注解通常要求在运行期读取。

### 处理注解

如何读取 `RUNTIME` 类型的注解

因为注解定义后也是一种 `class`，所有的注解都继承自 `java.lang.annotation.Annotation`，因此，读取注解，需要使用反射 API。

Java 提供的使用反射 API 读取 `Annotation` 的方法包括：

判断某个注解是否存在于 `Class`、`Field`、`Method` 或 `Constructor`：

- `Class.isAnnotationPresent(Class)`
- `Field.isAnnotationPresent(Class)`
- `Method.isAnnotationPresent(Class)`
- `Constructor.isAnnotationPresent(Class)`

例如：

```java
// 判断@Report是否存在于Person类:
Person.class.isAnnotationPresent(Report.class);
```

使用反射 API 读取 Annotation：

- `Class.getAnnotation(Class)`
- `Field.getAnnotation(Class)`
- `Method.getAnnotation(Class)`
- `Constructor.getAnnotation(Class)`

读取方法参数的 `Annotation` 就比较麻烦一点，因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，所以，一次获取方法参数的所有注解就必须用一个二维数组来表示。例如，对于以下方法定义的注解：

```java
public void hello(@NotNull @Range(max=5) String name, @NotNull String prefix) {
}
```

先用反射获取 `Method` 实例，然后读取方法参数的所有注解：

```java
// 获取Method实例:
Method m = ...
// 获取所有参数的Annotation:
Annotation[][] annos = m.getParameterAnnotations();
// 第一个参数（索引为0）的所有Annotation:
Annotation[] annosOfName = annos[0];
for (Annotation anno : annosOfName) {
    if (anno instanceof Range r) { // @Range注解
        r.max();
    }
    if (anno instanceof NotNull n) { // @NotNull注解
        //
    }
}
```

### 使用注解

```java
void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
    // 遍历所有Field:
    for (Field field : person.getClass().getFields()) {
        // 获取Field定义的@Range:
        Range range = field.getAnnotation(Range.class);
        // 如果@Range存在:
        if (range != null) {
            // 获取Field的值:
            Object value = field.get(person);
            // 如果值是String:
            if (value instanceof String s) {
                // 判断值是否满足@Range的min/max:
                if (s.length() < range.min() || s.length() > range.max()) {
                    throw new IllegalArgumentException("Invalid field: " + field.getName());
                }
            }
        }
    }
}
```

### 练习：使用 `@Range` 注解检查 Java Bean 的字段

使用 `@Range` 注解来检查 Java Bean 的字段。如果字段类型是 `String`，就检查 `String` 的长度，如果字段是 `int`，就检查 `int` 的范围。

```java
public class Main {  
  
    public static void main(String[] args) throws Exception {  
        Person p1 = new Person("Bob", "Beijing", 20);  
        Person p2 = new Person("", "Shanghai", 20);  
        Person p3 = new Person("Alice", "Shanghai", 199);  
        for (Person p : new Person[] { p1, p2, p3 }) {  
            try {  
                check(p);  
                System.out.println("Person " + p + " checked ok.");  
            } catch (IllegalArgumentException e) {  
                System.out.println("Person " + p + " checked failed: " + e);  
            }  
        }  
    }  
  
    static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {  
        for (Field field : person.getClass().getFields()) {  
            Range range = field.getAnnotation(Range.class);  
            if (range != null) {  
                Object value = field.get(person);  
                if(value instanceof String s){  
                    if(s.length() < range.min() || s.length() > range.max()){  
                        throw new IllegalArgumentException("Invalid field: " + field.getName());  
                    }  
                }  
                if(value instanceof Integer i){  
                    if(i < range.min() || i > range.max()){  
                        throw new IllegalArgumentException("Invalid field: " + field.getName());  
                    }  
                }  
            }  
        }  
    }  
}  
  
  
class Person {  
  
    @Range(min = 1, max = 20)  
    public String name;  
  
    @Range(max = 10)  
    public String city;  
  
    @Range(min = 1, max = 100)  
    public int age;  
  
    public Person(String name, String city, int age) {  
        this.name = name;  
        this.city = city;  
        this.age = age;  
    }  
  
    @Override  
    public String toString() {  
        return String.format("{Person: name=%s, city=%s, age=%d}", name, city, age);  
    }  
}  
  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.FIELD)  
@interface Range {  
  
    int min() default 0;  
  
    int max() default 255;  
  
}
```

## 7. 泛型

泛型是一种“代码模板”，可以用一套代码套用各种类型。

为了解决新的问题，我们必须把 `ArrayList` 变成一种模板：`ArrayList<T>`，代码如下：

```java
public class ArrayList<T> {
    private T[] array;
    private int size;
    public void add(T e) {...}
    public void remove(int index) {...}
    public T get(int index) {...}
}
```

`T` 可以是任何 class。这样一来，我们就实现了：编写一次模版，可以创建任意类型的 `ArrayList`：

```java
// 创建可以存储String的ArrayList:
ArrayList<String> strList = new ArrayList<String>();
// 创建可以存储Float的ArrayList:
ArrayList<Float> floatList = new ArrayList<Float>();
// 创建可以存储Person的ArrayList:
ArrayList<Person> personList = new ArrayList<Person>();
```

这样一来，既实现了编写一次，万能匹配，又通过编译器保证了类型安全：这就是泛型。

### 向上转型规则

在 Java 标准库中的 `ArrayList<T>` 实现了 `List<T>` 接口，它可以向上转型为 `List<T>`：

```java
public class ArrayList<T> implements List<T> {
    ...
}

List<String> list = new ArrayList<String>();
```

即类型 `ArrayList<T>` 可以向上转型为 `List<T>`。

要特别注意：不能把 `ArrayList<Integer>` 向上转型为 `ArrayList<Number>` 或 `List<Number>`。

编译器为了避免错误，不允许把 `ArrayList<Integer>` 转型为 `ArrayList<Number>`

> **特别注意**
>
> `ArrayList<Integer>` 和 `ArrayList<Number>` 两者完全没有继承关系。

- 泛型就是编写模板代码来适应任意类型；
- 泛型的好处是使用时不必对类型进行强制转换，它通过编译器对类型进行检查；
- 注意泛型的继承关系：可以把 `ArrayList<Integer>` 向上转型为 `List<Integer>`（`T` 不能变！），但不能把 `ArrayList<Integer>` 向上转型为 `ArrayList<Number>`（`T` 不能变成父类）。

使用 `ArrayList` 时，如果不定义泛型类型时，泛型类型实际上就是 `Object`

当我们定义泛型类型 `<String>` 后，`List<T>` 的泛型接口变为强类型 `List<String>`：

```java
// 无编译器警告:
List<String> list = new ArrayList<String>();
list.add("Hello");
list.add("World");
// 无强制转型:
String first = list.get(0);
String second = list.get(1);
```

编译器如果能自动推断出泛型类型，就可以省略后面的泛型类型。例如，对于下面的代码：

```java
List<Number> list = new ArrayList<Number>();
```

### 泛型接口

除了 `ArrayList<T>` 使用了泛型，还可以在接口中使用泛型。例如，`Arrays.sort(Object[])` 可以对任意数组进行排序，但待排序的元素必须实现 `Comparable<T>` 这个泛型接口：

```java
public interface Comparable<T> {
    /**
     * 返回负数: 当前实例比参数o小
     * 返回0: 当前实例与参数o相等
     * 返回正数: 当前实例比参数o大
     */
    int compareTo(T o);
}
```

按照以下步骤来编写一个泛型类。

首先，按照某种类型，例如：`String`，来编写类：

然后，标记所有的特定类型，这里是 `String`，把特定类型 `String` 替换为 `T`，并申明 `<T>`：

编写泛型类时，要特别注意，泛型类型 `<T>` 不能用于静态方法。

对于静态方法，我们可以单独改写为“泛型”方法，只需要使用另一个类型即可。

### 多类型参数

泛型还可以定义多种类型。例如，我们希望 `Pair` 不总是存储两个类型一样的对象，就可以使用类型 `<T, K>`：

```java
public class Pair<T, K> {
    private T first;
    private K last;
    public Pair(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { ... }
    public K getLast() { ... }
}
```

使用的时候，需要指出两种类型：

```java
Pair<String, Integer> p = new Pair<>("test", 123);
```

### 擦拭法（Type Erasure）

泛型是一种类似“模板代码”的技术，不同语言的泛型实现方式不一定相同。

Java 语言的泛型实现方式是擦拭法（Type Erasure）。

所谓擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的。

Java 的泛型是由编译器在编译时实行的，编译器内部永远把所有类型 `T` 视为 `Object` 处理，但是，在需要转型的时候，编译器会根据 `T` 的类型自动为我们实行安全地强制转型。

#### 泛型的局限

Java 泛型的局限：

局限一：`<T>` 不能是基本类型，例如 `int`，因为实际类型是 `Object`，`Object` 类型无法持有基本类型

局限二：无法取得带泛型的 `Class`。

局限三：无法判断带泛型的类型：

局限四：不能实例化 `T` 类型：这样一来，创建 `new Pair<String>()` 和创建 `new Pair<Integer>()` 就全部成了 `Object`，显然编译器要阻止这种类型不对的代码。

要实例化 `T` 类型，我们必须借助额外的 `Class<T>` 参数：

```java
public class Pair<T> {
    private T first;
    private T last;
    public Pair(Class<T> clazz) {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }
}
```

上述代码借助 `Class<T>` 参数并通过反射来实例化 `T` 类型，使用的时候，也必须传入 `Class<T>`

```java
Pair<String> pair = new Pair<>(String.class);
```

### 泛型继承

一个类可以继承自一个泛型类。

例如：父类的类型是 `Pair<Integer>`，子类的类型是 `IntPair`，可以这么继承：

```java
public class IntPair extends Pair<Integer> {
}
```

### 小结

- Java 的泛型是采用擦拭法实现的；
- 擦拭法决定了泛型 `<T>`：
  - 不能是基本类型，例如：`int`；
  - 不能获取带泛型类型的 `Class`，例如：`Pair<String>.class`；
  - 不能判断带泛型类型的类型，例如：`x instanceof Pair<String>`；
  - 不能实例化 `T` 类型，例如：`new T()`。
- 泛型方法要防止重复定义方法，例如：`public boolean equals(T obj)`；
- 子类可以获取父类的泛型类型 `<T>`。
