public class BookManager {
    private final Book[] books = new Book[100];
    private int count = 0;

    public void add(int id, String title, String author, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("id 必须大于 0");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("书名不能为空");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("作者不能为空");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("价格必须大于 0");
        }
        if (findIndexById(id) >= 0) {
            throw new IllegalArgumentException("id 已存在");
        }
        if (count >= books.length) {
            System.out.println("书库已满，未能存入成功！");
            return;
        }
        books[count] = new Book(id, title, author, price);
        count++;
        System.out.println("存入成功！");
    }

    public void add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book 不能为空");
        }
        add(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
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
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("书名不能为空");
        }

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

    public void deleteById(int id) throws BookNotFoundException {
        int index = findIndexById(id);
        if (index < 0) {
            throw new BookNotFoundException("未找到 id=" + id + " 的书籍");
        }

        for (int j = index; j < count - 1; j++) {
            books[j] = books[j + 1];
        }
        books[count - 1] = null;
        count--;
        System.out.println("删除成功！");
    }

    private int findIndexById(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
