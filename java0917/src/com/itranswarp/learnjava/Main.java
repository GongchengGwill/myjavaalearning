package com.itranswarp.learnjava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

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





//public class Main {
//
//    public static void main(String[] args) {
//        HelloImpl hmpl = new HelloImpl();
//
//        InvocationHandler handler = new InvocationHandler(){
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("before " + method.getName());
//                Object result = method.invoke(hmpl, args);
//                System.out.println("after " + method.getName());
//                return result;
//            }
//        };
//
//        Hello hello = (Hello) Proxy.newProxyInstance(
//                Hello.class.getClassLoader(),
//                new Class[]{Hello.class},
//                handler
//        );
//
//        System.out.println(hello.hello("Java"));
//
//    }
//
//}
//
//class HelloImpl implements Hello {
//    public String hello(String name) {
//        return "Hello, " + name;
//    }
//}
//
//interface Hello {
//    String hello(String name);
//}

//    public static void main(String[] args) throws Exception {
//        String name = "Xiao Ming";
//        int age = 20;
//        Person p = new Person();
//        // TODO: 利用反射调用setName和setAge方法:
//        // 1.获取class
//        Class c = Person.class;
//        // 2.获取method
//        Method m = c.getDeclaredMethod("setName", String.class);
//        Method m2 = c.getDeclaredMethod("setAge", int.class);
//        // 3.进行调用
//        m.invoke(p, name);
//        m2.invoke(p, age);
//        System.out.println(p.getName()); // "Xiao Ming"
//        System.out.println(p.getAge()); // 20
//    }

//class Person {
//    private String name;
//    private int age;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//}


//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        int a = 0, b = 0, c = 0;
//        int n = nums.length;
//        Arrays.sort(nums);
//        for(a = 0; a < n; a++){
//            if(a > 0 && nums[a] == nums[a - 1]) continue;
//            c = n - 1;
//            int target = -nums[a];
//            for(b = a + 1; b < n; b++){
//                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
//                while(b < c && nums[b] + nums[c] > target){
//                    c--;
//                }
//                if(b == c) break;
//                if(nums[b] + nums[c] == target){
//                    List<Integer> ansp = new ArrayList<>();
//                    ansp.add(nums[a]);
//                    ansp.add(nums[b]);
//                    ansp.add(nums[c]);
//                    ans.add(ansp);
//                }
//            }
//        }
//        return ans;
//    }

//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 获取Person的hello方法:
//        Method h = Person.class.getMethod("hello");
//        // 对Student实例调用hello方法:
//        h.invoke(new Student());
//        h.invoke(new Person());
//    }
//}
//
//class Person {
//    public void hello() {
//        System.out.println("Person:hello");
//    }
//}
//
//class Student extends Person {
//    public void hello() {
//        System.out.println("Student:hello");
//    }
//}
//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 获取Integer.parseInt(String)方法，参数为String:
//        Method m = Integer.class.getMethod("parseInt", String.class);
//        // 调用该静态方法并获取结果:
//        Integer n = (Integer) m.invoke(null, "12345");
//        // 打印调用结果:
//        System.out.println(n);
//    }
//}


//public class Main {
//    public static void main(String[] args) throws Exception {
//        Class stdClass = Student.class;
//        // 获取public方法getScore，参数为String:
//        System.out.println(stdClass.getMethod("getScore", String.class));
//        // 获取继承的public方法getName，无参数:
//        System.out.println(stdClass.getMethod("getName"));
//        // 获取private方法getGrade，参数为int:
//        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
//        System.out.println(Arrays.toString(stdClass.getMethods()));
//        System.out.println(Arrays.toString(stdClass.getDeclaredMethods()));
//    }
//}
//
//class Student extends Person {
//    public int getScore(String type) {
//        return 99;
//    }
//    private int getGrade(int year) {
//        return 1;
//    }
//}
//
//class Person {
//    public String getName() {
//        return "Person";
//    }
//}


//public class Main {
//
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String name = "Xiao Ming";
//        int age = 20;
//        Person p = new Person();
//        // TODO: 利用反射给name和age字段赋值:
//        // 1.获取class
//        Class c = p.getClass();
//        // 2.获取field
//        Field f = c.getDeclaredField("name");
//        Field fa = c.getDeclaredField("age");
//        // 3.对field使用set进行修改
//        f.setAccessible(true);
//        f.set(p, "Nai Long");
//        fa.setAccessible(true);
//        fa.set(p, 18);
//
//        System.out.println(p.getName()); // "Xiao Ming"
//        System.out.println(p.getAge()); // 20
//    }
//}
//
//class Person {
//    private String name;
//    private int age;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//}

//class Student extends Person {
//    public int score;
//    private int grade;
//}
//
//class Person {
//    public String name;
//}

//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        Object p = new Person("Xiao Ming");
//        Class c = p.getClass();
//        Field f = c.getDeclaredField("name");
//        f.setAccessible(true);
//        Object value = f.get(p);
//        System.out.println(value); // "Xiao Ming"
//    }
//
//
//}
//
//class Person {
//    private String name;
//
//    public Person(String name) {
//        this.name = name;
//    }
//}





//public class Main {
//    public static void main(String[] args) throws Exception {
//        Class stdClass = Student.class;
//        // 获取public字段"score":
//        System.out.println(stdClass.getField("score"));
//        // 获取继承的public字段"name":
//        System.out.println(stdClass.getField("name"));
//        // 获取private字段"grade":
//        System.out.println(stdClass.getDeclaredField("grade"));
//
//        Field f = String.class.getDeclaredField("value");
//        f.getName(); // "value"
//        f.getType(); // class [B 表示byte[]类型
//        int m = f.getModifiers();
//        Modifier.isFinal(m); // true
//        Modifier.isPublic(m); // false
//        Modifier.isProtected(m); // false
//        Modifier.isPrivate(m); // true
//        Modifier.isStatic(m); // false
//    }
//}

//class Student extends Person {
//    public int score;
//    private int grade;
//}
//
//class Person {
//    public String name;
//}

// reflection
//public class Main {
//	public static void main(String[] args) {
//		printClassInfo("".getClass());
//		printClassInfo(Runnable.class);
//		printClassInfo(java.time.Month.class);
//		printClassInfo(String[].class);
//		printClassInfo(int.class);
//	}
//
//
//
//	static void printClassInfo(Class cls) {
//		System.out.println("Class name: " + cls.getName());
//		System.out.println("Simple name: " + cls.getSimpleName());
//		if (cls.getPackage() != null) {
//			System.out.println("Package name: " + cls.getPackage().getName());
//		}
//		System.out.println("is interface: " + cls.isInterface());
//		System.out.println("is enum: " + cls.isEnum());
//		System.out.println("is array: " + cls.isArray());
//		System.out.println("is primitive: " + cls.isPrimitive());
//	}
//}


//public class Main {
//	public static void main(String[] args) throws ClassNotFoundException {
//		Class cls1 = String.class;
//
//		String s = "Hello";
//		Class cls2 = s.getClass();
//
//		Class cls = Class.forName("java.lang.String");
//
//		boolean sameClass = cls1 == cls2; // true
//		boolean sameClass2 = cls == cls1;
//		System.out.println(sameClass);
//		System.out.println(sameClass2);
//	}
//}

//class Person implements Comparable<Person> {
//	String name;
//	int score;
//	Person(String name, int score) {
//		this.name = name;
//		this.score = score;
//	}
//	public int compareTo(Person other) {
//		return this.score - other.score;
//	}
//	public String toString() {
//		return this.name + "," + this.score;
//	}
//}









//public class Main {
//	public static void main(String[] args) {
//		Logger logger = Logger.getLogger(Main.class.getName());
//		logger.info("Start process...");
//		try {
//			"".getBytes("invalidCharsetName");
//		} catch (UnsupportedEncodingException e) {
//			// TODO: 使用logger.severe()打印异常
//			logger.severe(e.getMessage());
//		}
//		logger.info("Process end.");
//	}



//	class Solution {
//		public int maxArea(int[] height) {
//			int left = 0, right = height.length - 1;
//			int ans = 0;
//			while(right > left){
//				ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
//				if(height[left] <= height[right]){
//					left++;
//				}else{
//					right--;
//				}
//			}
//			return ans;
//		}
//	}


//	public void moveZeroes(int[] nums) {
//		int first = 0;
//		int second = 0;
//		while(first < nums.length){
//			if(nums[first] != 0){
//				nums[second] = nums[first];
//				second++;
//			}
//			first++;
//		}
//		while(second < nums.length){
//			nums[second] = 0;
//			second++;
//		}
//	}

//}

