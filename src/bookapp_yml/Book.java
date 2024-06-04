/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookapp_yml;


import javax.swing.JOptionPane;

public class Book {
   private String name; // Name of the book
    private String author; // Author of the book
    int numPages; // Number of pages in the book
    private static int totalNumPages = 0; // Static variable to keep track of total number of pages of all books

    // Constructor to initialize a book object with its name, author, and number of pages
    public Book(String name, String author, int numPages) {
        this.name = name;
        this.author = author;
        this.numPages = numPages;
        totalNumPages += numPages; // Increment the total number of pages by the pages of the new book
    }
    // Getter methods for the fields
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }
    // Static method to create books based on user input
    public static void createFromUserInput() {
        StringBuilder allDetails = new StringBuilder(); // StringBuilder to accumulate details of all books

        // Prompt user for the number of books to add
        int numBooksToAdd = Integer.parseInt(JOptionPane.showInputDialog("How many books do you want to add?"));

        // Loop to get details for each book
        for (int booksAdded = 0; booksAdded < numBooksToAdd; booksAdded++) {
            String name = JOptionPane.showInputDialog("Enter a book's name: ");
            String author = JOptionPane.showInputDialog("Enter author's name: ");
            int numPages = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of pages: ")); 
            Book book = new Book(name, author, numPages); // Create a new book with the input details
            allDetails.append(String.format("Book Details:\nName: %s\nAuthor: %s\nNumber of Pages: %d\n\n", 
                book.name, book.author, book.numPages)); // Append the book details to the StringBuilder
        }

        // Display the formatted book details in a message dialog
        JOptionPane.showMessageDialog(null, formatBookDetails(allDetails.toString()), "Book Details", JOptionPane.INFORMATION_MESSAGE);
        totalNumPages = calculateTotalNumPages(allDetails.toString()); // Update the total number of pages (although this step is redundant here)
    }

    // Private static method to format the book details for display
    private static String formatBookDetails(String details) {
        StringBuilder formattedDetails = new StringBuilder(); // StringBuilder for formatted details
        for (String line : details.split("\n\n")) 
        { // Split the details by double newline to separate books
            formattedDetails.append("------------------------\n").append(line).append("\n");
        }
        formattedDetails.append("------------------------\n");
        formattedDetails.append("Total Number of Pages: ").append(totalNumPages).append("\n"); // Append total number of pages
        return formattedDetails.toString(); // Return the formatted string
    }

    // Private static method to calculate total number of pages (not actually used effectively here)
    private static int calculateTotalNumPages(String details) {
        return totalNumPages; // Simply return the already calculated total
    }

    // Static method to display a placeholder message for book list display
    public static void displayBookList() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }

    // Override toString method to provide a string representation of a book object
    @Override
    public String toString() {
        return String.format("Name: %s\nAuthor: %s\nNumber of Pages: %d\n", 
                             name, author, numPages);
    }
}
