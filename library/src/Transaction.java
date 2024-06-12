import java.util.Date;

public class Transaction {
    private Student student;
    private Book book;
    private Date borrowDate;
    private Date dueDate;

    public Transaction(Student student, Book book, Date borrowDate, Date dueDate) {
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public void borrowBook() {
        student.borrowBook(book);
    }

    public void returnBook() {
        student.returnBook(book);
    }

    public String getDetails() {
        return "Student: " + student.getName() + ", Book: " + book.getDetails() + ", Borrow Date: " + borrowDate + ", Due Date: " + dueDate;
    }
}
