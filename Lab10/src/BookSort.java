import java.util.ArrayList;
import java.util.List;

public class BookSort {
  public static void main(String args[] ){
    Person john = new Person("John", "Doe", 1945);
    Person sally = new Person("Sally", "Ride", 1951);
    Person rowling = new Person("J.K.", "Rowling", 1965);

    Book python = new Book("Python",john, 15, TypeOfBook.PAPERBACK, GenreOfBook.TECHNICAL);
    Book java = new Book("Java", sally, 16, TypeOfBook.PAPERBACK, GenreOfBook.TECHNICAL);
    Book clanguage = new Book("CLanguage",john, 10, TypeOfBook.PAPERBACK, GenreOfBook.TECHNICAL);
    Book harryPotter = new Book("Harry Potter", rowling, 20, TypeOfBook.HARDCOVER, GenreOfBook.ADVENTURE);

    List<Book> listOfBooks = new ArrayList<>();
    System.out.println("The empty list of books is: ");
    listOfBooks.sort(Book::compareByAlphabet);
    listOfBooks.forEach(System.out::println);

    listOfBooks.add(python);
    listOfBooks.add(java);
    listOfBooks.add(clanguage);
    listOfBooks.add(harryPotter);

    System.out.println("The original list of books is: ");
    listOfBooks.forEach(System.out::println);

    // Sorted alphabetically
    listOfBooks.sort(Book::compareByAlphabet);
    System.out.println("The list of books sorted alphabetically is: ");
    listOfBooks.forEach(System.out::println);

    // Check if the sorting is case sensitive
    Book clanguage2 = new Book("cLanguage",john, 10, TypeOfBook.PAPERBACK, GenreOfBook.TECHNICAL);
    listOfBooks.add(clanguage2);
    listOfBooks.sort(Book::compareByAlphabet);
    System.out.println("The list of books sorted alphabetically is: ");
    listOfBooks.forEach(System.out::println);


    // Sorted by price
    listOfBooks.sort(Book::compareByPrice);
    System.out.println("The list of books sorted by price is: ");
    listOfBooks.forEach(System.out::println);


  }

}
