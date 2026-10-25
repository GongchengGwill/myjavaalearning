import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String s1 = "  hello,nihao";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.substring(2, 4));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.trim());

        byte[] utf8 = "你好".getBytes(StandardCharsets.UTF_8);
        byte[] gbk = "你好".getBytes(Charset.forName("GBK"));
        System.out.println(utf8.length); // 6
        System.out.println(gbk.length);  // 4
        System.out.println(new String(utf8, StandardCharsets.UTF_8)); // 你好

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
}