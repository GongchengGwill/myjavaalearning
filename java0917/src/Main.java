import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calbmi();
    }

    public static void sum(){
        int n = 100;
        int sum = (1 + n) * n / 2;
        System.out.println(sum);
        System.out.println(sum == 5050 ? "测试通过" : "测试失败");
    }

    public static void qiufangcheng(){
        double a = 1.0;
        double b = 3.0;
        double c = -4.0;
        double r1 = 0;
        double r2 = 0;
        r1 = (Math.sqrt(Math.pow(b, 2) - 4 * a * c) - b) / 2 * a;
        r2 = (-Math.sqrt(Math.pow(b, 2) - 4 * a * c) - b) / 2 * a;
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1 == 1 && r2 == -4 ? "测试通过" : "测试失败");
    }

    // 布尔运算
    public static void booltest() {
        int age = 5;
        // primary student的定义: 6~12岁
        boolean isPrimaryStudent = (age <= 12 && age >= 6) ? true : false;
        System.out.println(isPrimaryStudent ? "Yes" : "No");
    }

    public static void stringtest(){
        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
        int a = 72;
        int b = 105;
        int c = 65281;
        // FIXME:
        char a1 = (char)a;
        char b1 = (char)b;
        char c1 = (char)c;
        String s = "" + a1+ b1 + c1;
        System.out.println(s);
    }

    //请帮小明同学设计一个程序，输入上次考试成绩（int）和本次考试成绩（int），然后输出成绩提高的百分比，保留两位小数位（例如，21.75%）。
    public static void iotest(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入上次考试成绩:");
        double g1 = sc.nextDouble();
        System.out.print("请输入本次考试成绩:");
        double g2 = sc.nextDouble();
        double ans = (g2 - g1) * 100 / g1;
        System.out.printf("本次成绩提升的百分比为%.2f%%", ans);
    }

    //请用if ... else编写一个程序，用于计算体质指数BMI，并打印结果
    public static void calbmi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入体重(KG):");
        double weight = sc.nextDouble();
        System.out.println("请输入身高(M):");
        double height = sc.nextDouble();
        double bmi = weight/Math.pow(height, 2);
        if(bmi < 18.5){
            System.out.println("过轻");
        }else if(bmi >= 18.5 && bmi < 25){
            System.out.println("正常");
        }else if(bmi >= 25 && bmi < 28){
            System.out.println("过重");
        }else if(bmi >= 28 && bmi < 32){
            System.out.println("肥胖");
        }else{
            System.out.println("高于32");
        }

    }



}