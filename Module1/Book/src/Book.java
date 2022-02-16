/**
 * This class represents a book. A book has a title, an author and a price
 */
public class Book {
  private String title;
  private Person author;
  private float price;
  private TypeOfBook typeOfBook;
  private GenreOfBook genre;


  /**
   * Construct a Book object that has the provided title, author and price
   *
   * @param title  the title to be given to this book
   * @param author the author to be given to this book
   * @param price  the price to be assigned to this book
   *
   */
  public Book(String title, Person author, float price, TypeOfBook typeOfBook, GenreOfBook genre) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.typeOfBook = typeOfBook;
    this.genre = genre;
  }

  /**
   * Return the title of this book
   * 
   * @return the title of this book
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Return the price of this book
   * 
   * @return the price of this book
   */
  public float getPrice() {
    return this.price;
  }

  /**
   * Return the author of this object
   * 
   * @return the author of this object as a @link{Person}
   */
  public Person getAuthor() {
    return this.author;
  }

  /**
   * Return the discounted price.
   * @param discount
   * @return
   * @throws IllegalArgumentException
   */
  public float salePrice (float discount) throws IllegalArgumentException {
    if (discount<0){
      throw new IllegalArgumentException("Discount cannot be negative");
    }
    float salePrice = this.price - ((this.price* discount)/100);
    return salePrice;
  }

  /**
   * Return discount book.
   * @param discount
   * @return
   */
  public Book discountBook (float discount){
    float discountedPrice = this.salePrice(discount);
    try{
      discountedPrice = this.salePrice(discount);
    }
    catch(IllegalArgumentException e){
      // this will be executed only if an IllegalArgumentException is thrown
    }
    return new Book(this.title,this.author,discountedPrice, this.typeOfBook, this.genre);
  }


  public String toString() {
    String str;

    str = "Title: " + this.title + "\n" +
        "Author: " + this.author.getFullName() + "\n" +
        "Type: ";

    switch (typeOfBook) {
      case PAPERBACK:
        str = str + "Paperback";
        break;
      case HARDCOVER:
        str = str + "Hard Cover";
        break;
      case KINDLE:
        str = str + "Kindle";
        break;
    }
    str = str + "\n"+"Genre: ";

    switch (genre) {
      case ROMANCE:
        str = str + "Romance";
        break;
      case MURDER:
        str = str + "Murder";
        break;
      case HISTORY:
        str = str + "History";
        break;
      case TECHNICAL:
        str = str + "Technical";
        break;
      case ADVENTURE:
        str = str + "Adventure";
        break;
    }

    str = str + "\n";
    str = str + String.format("Price: %.2f", price);

    return str;
  }
}