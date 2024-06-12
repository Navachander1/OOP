import javax.swing.*;

public class LibraryUI {
    private Library library;

    public LibraryUI(Library library) {
        this.library = library;
    }

    public void showMainMenu() {
        String[] options = {"Student Login", "Patron Login"};
        int choice = JOptionPane.showOptionDialog(null, "Select your role:", "Library System",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showStudentMenu();
        } else if (choice == 1) {
            showPatronMenu();
        }
    }

    private void showStudentMenu() {
        String[] studentOptions = {"100", "101", "102"};
        String studentId = (String) JOptionPane.showInputDialog(null, "Enter your Student ID:",
                "Student Login", JOptionPane.QUESTION_MESSAGE, null, studentOptions, studentOptions[0]);
        Student student = library.findStudentById(studentId);
        if (student != null) {
            String[] options = {"Borrow Book", "Return Book", "View Borrowed Books"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Student Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                String bookId = JOptionPane.showInputDialog("Enter Book ID to borrow:");
                Book book = library.findBookById(bookId);
                if (book != null) {
                    student.borrowBook(book);
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            } else if (choice == 1) {
                String bookId = JOptionPane.showInputDialog("Enter Book ID to return:");
                Book book = library.findBookById(bookId);
                if (book != null) {
                    student.returnBook(book);
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            } else if (choice == 2) {
                StringBuilder borrowedBooks = new StringBuilder("Borrowed Books:\n");
                for (Book book : student.viewBorrowedBooks()) {
                    borrowedBooks.append(book.getDetails()).append("\n");
                }
                JOptionPane.showMessageDialog(null, borrowedBooks.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Student not found.");
        }
    }

    private void showPatronMenu() {
        Patron patron = library.getPatron();
        if (patron != null) {
            String[] options = {"View Student Details", "View Borrowed Books", "View Available Books"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Patron Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                String[] studentOptions = {"100", "101", "102"};
                String studentId = (String) JOptionPane.showInputDialog(null, "Enter Student ID to view details:",
                        "View Student Details", JOptionPane.QUESTION_MESSAGE, null, studentOptions, studentOptions[0]);
                Student student = library.findStudentById(studentId);
                if (student != null) {
                    patron.viewStudentDetails(student);
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found.");
                }
            } else if (choice == 1) {
                String[] studentOptions = {"100", "101", "102"};
                String studentId = (String) JOptionPane.showInputDialog(null, "Enter Student ID to view borrowed books:",
                        "View Borrowed Books", JOptionPane.QUESTION_MESSAGE, null, studentOptions, studentOptions[0]);
                Student student = library.findStudentById(studentId);
                if (student != null) {
                    patron.viewBorrowedBooks(student);
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found.");
                }
            } else if (choice == 2) {
                patron.viewAvailableBooks(library.getCatalog());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Patron not found.");
        }
    }
}
