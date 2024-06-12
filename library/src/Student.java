import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Book> borrowedBooks;

    public Student(String id, String name) {
        super(id, name);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public List<Book> viewBorrowedBooks() {
        return borrowedBooks;
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found in borrowed list.");
        }
    }

    @Override
    public boolean login() {
        // Implement login logic for student
        return true;
    }
}
