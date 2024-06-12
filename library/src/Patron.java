public class Patron extends User {
    private String contactInfo;

    public Patron(String id, String name, String contactInfo) {
        super(id, name);
        this.contactInfo = contactInfo;
    }

    public void viewStudentDetails(Student student) {
        System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName());
    }

    public void viewBorrowedBooks(Student student) {
        for (Book book : student.viewBorrowedBooks()) {
            System.out.println(book.getDetails());
        }
    }

    public void viewAvailableBooks(Catalog catalog) {
        for (Book book : catalog.listBooks()) {
            if (!book.isBorrowed()) {
                System.out.println(book.getDetails());
            }
        }
    }

    @Override
    public boolean login() {
        // Implement login logic for patron
        return true;
    }
}
