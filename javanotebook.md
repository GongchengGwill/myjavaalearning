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
