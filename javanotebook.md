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

不要怀疑引用参数绑定的机制，试解释为什么上面的代码两次输出都是"Bob"。
