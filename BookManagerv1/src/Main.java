import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bm = new BookManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入以下数字进行书库测试：");
        System.out.println("1.添加图书  2.查看全部  3.按书名搜索  4.按id删除  0.退出");

        while (sc.hasNextLine()) {
            String str = sc.nextLine().trim();

            if (str.equals("1")) {
                System.out.println("请按照以下格式输入：id,title,author,price");
                String bookinfo = sc.nextLine();
                String[] parts = bookinfo.split(",", 4);

                if (parts.length != 4) {
                    System.out.println("格式不对，需要 4 个字段");
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    bm.add(id, title, author, price);
                } catch (NumberFormatException e) {
                    System.out.println("id 和 price 必须是数字");
                }
            } else if (str.equals("2")) {
                System.out.println("以下是书库所有图书信息：");
                bm.list();
            } else if (str.equals("3")) {
                System.out.println("请输入书籍书名");
                String booktitle = sc.nextLine().trim();
                bm.searchByTitle(booktitle);
            } else if (str.equals("4")) {
                System.out.println("请输入想删除的书籍编号id");
                String bookid = sc.nextLine().trim();
                try {
                    bm.deleteById(Integer.parseInt(bookid));
                } catch (NumberFormatException e) {
                    System.out.println("id 必须是数字");
                }
            } else if (str.equals("0")) {
                System.out.println("你选择了退出系统！");
                break;
            } else {
                System.out.println("请输入0-4中的数字以选择功能！！不允许其他输入");
            }
        }

        sc.close();
    }
}
