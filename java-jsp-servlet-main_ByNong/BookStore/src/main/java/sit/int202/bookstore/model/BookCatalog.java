package sit.int202.bookstore.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookCatalog {
    private  static  BookCatalog instance;
    private final List<Book> books = new ArrayList<>();
    public static BookCatalog getInstance() {
        if (instance == null) {
            instance = new BookCatalog();
        }
        return instance;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }
    public  Book getBookByTitle(String title){
        for (Book book: books) {
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
}
