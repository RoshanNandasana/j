import java.util.*;

class Book implements Comparable<Book> {
    private int bookId;   
    private String title;   
    private String author;   
    private String publisher;  

    public Book(int bookId, String title, String author, String publisher) {   
        this.bookId = bookId;  
        this.title = title;   
        this.author = author;   
        this.publisher = publisher;  
    }  

    public int getBookId() {   
        return bookId;  
    }  

    public String getTitle() {   
        return title;  
    }  

    public String getAuthor() {   
        return author;  
    }  

    public String getPublisher() {   
        return publisher;  
    } 

    public int compareTo(Book other) {   
        return this.title.compareTo(other.title);  
    }  

    public String toString() {  
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Publisher: " + publisher;  
    }  
}  

class AuthorComparator implements Comparator<Book> {   
    public int compare(Book b1, Book b2) {  
        return b1.getAuthor().compareTo(b2.getAuthor());  
    }  
}  

public class Sort{  
    public static void main(String[] args) {   
        List<Book> books = new ArrayList<>();  
          
        // One-word titles and authors
        books.add(new Book(401, "Java", "John", "Tech"));
        books.add(new Book(402, "Code", "Mike", "Soft"));
        books.add(new Book(403, "Data", "Anna", "Info"));
        books.add(new Book(404, "Web", "Lisa", "Net"));

        Collections.sort(books);   
        System.out.println("Books sorted by Title:");
        for (Book book : books) {  
            System.out.println(book);  
        } 

        Collections.sort(books, new AuthorComparator());   
        System.out.println("\nBooks sorted by Author:");
        for (Book book : books) {  
            System.out.println(book);  
        }  
    }  
}