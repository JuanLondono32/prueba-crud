package co.edu.uis;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GreetingControllerTests {

    @Mock
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;
    private List<Book> books;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        book1 = new Book("El Principito", "Antoine de Saint-Exupéry", "FR", "Ficción", 180);
        book2 = new Book("Rebelión en la Granja", "George Orwell", "EN", "Sátira Política", 200);
        books = Arrays.asList(book1, book2);
    }

    @Test
    public void getAll(){
        final GreetingController greetingController = new GreetingController(bookRepository);
        when(bookRepository.findAll()).thenReturn(books);
        assertTrue(greetingController.getAll().size() == books.size());
    }

    @Test
    public void get(){
        try {
            final GreetingController greetingController = new GreetingController(bookRepository);
            when(bookRepository.findById(book1.getId())).thenReturn(Optional.of(book1));
            Book b;
            b = greetingController.get(book1.getId());
            assertTrue(b.getTitle().equals(book1.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try {
            final GreetingController greetingController = new GreetingController(bookRepository);
            when(bookRepository.findById(book1.getId())).thenReturn(Optional.of(book1));
            Book b;
            b = greetingController.deleteBook(book1.getId());
            assertTrue(b.getTitle().equals(book1.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        try {
            final GreetingController greetingController = new GreetingController(bookRepository);
            when(bookRepository.findById(book1.getId())).thenReturn(Optional.of(book1));
            Book b;
            String updatedName = "Harry Potter";
            b = greetingController.updateBook(book1.getId(), updatedName);
            assertTrue(b.getTitle().equals(updatedName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void register(){
        try {
            Book newBook = new Book("El Perfume", "Patrick Süskind", "FR", "Ficción", 250);
            when(bookRepository.save(newBook)).thenReturn(newBook);
            final GreetingController greetingController = new GreetingController(bookRepository);
            Book b = greetingController.newBook(newBook.getTitle(), newBook.getAuthor(), newBook.getLang(), newBook.getGenre(), newBook.getPages());
            assertTrue(b.getTitle().equals(newBook.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
