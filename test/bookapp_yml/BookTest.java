/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bookapp_yml;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Book class.
 */
public class BookTest {

    // Default constructor
    public BookTest() {
    }

    @Test
    public void testCreateFromUserInput() {

        // Test input data (individual parameters)
        String bookName1 = "Book 1";  // Name of the first book
        String authorName1 = "Author A";  // Author of the first book
        int pageCount1 = 250;  // Page count of the first book

        String bookName2 = "Book 2";  // Name of the second book
        String authorName2 = "Author B";  // Author of the second book
        int pageCount2 = 380;  // Page count of the second book

        // Call the method under test (with individual book details)
        StringBuilder actualOutput = new StringBuilder();  // StringBuilder to accumulate the output
        actualOutput.append(bookInputLoop(bookName1, authorName1, pageCount1));  // Append details of the first book
        actualOutput.append(bookInputLoop(bookName2, authorName2, pageCount2));  // Append details of the second book

        // Expected output string that matches the format produced by the bookInputLoop method
        String expectedOutput =
                "Book Details:\nName: Book 1\nAuthor: Author A\nNumber of Pages: 250\n\n" +
                "Book Details:\nName: Book 2\nAuthor: Author B\nNumber of Pages: 380\n\n";

        // Verify that the actual output matches the expected output
        assertEquals(expectedOutput, actualOutput.toString());
    }

    // Helper method to create a formatted string with book details
    private StringBuilder bookInputLoop(String name, String author, int numPages) {
        StringBuilder details = new StringBuilder();  // StringBuilder to store book details
        Book book = new Book(name, author, numPages);  // Create a new Book object
        // Append formatted book details to the StringBuilder
        details.append(String.format("Book Details:\nName: %s\nAuthor: %s\nNumber of Pages: %d\n\n",
                book.getName(), book.getAuthor(), book.getNumPages()));

        return details;  // Return the StringBuilder containing the book details
    }
}
