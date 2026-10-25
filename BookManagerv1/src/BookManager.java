public class BookManager {
    private final Book[] books = new Book[100];
    private int count = 0;

    public void add(int id, String title, String author, double price) {
        if (count >= books.length) {
            System.out.println("书库已满，未能存入成功！");
            return;
        }
        books[count] = new Book(id, title, author, price);
        count++;
        System.out.println("存入成功！");
    }

    public void add(Book book) {
        if (count >= books.length) {
            System.out.println("书库已满，未能存入成功！");
            return;
        }
        books[count] = book;
        count++;
        System.out.println("存入成功！");
    }

    public void list() {
        if (count == 0) {
            System.out.println("书库为空");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("已经查询到书籍，以下是该书信息：");
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("未查询到本书");
        }
    }

    public void deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                count--;
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("未查询到你要删除的书籍");
    }
}
