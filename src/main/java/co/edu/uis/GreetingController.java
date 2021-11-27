package co.edu.uis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();
	private final BookRepository repository;

	private static final String template_not = "%s is not registered.";

	public GreetingController(BookRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/get/{id}")
	public Book get(@PathVariable Long id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID necesario:" + id));
	}

	@GetMapping("/getall")
	public List<Book> getAll() {
		return repository.findAll();
	}

	@PatchMapping("update/{id}")
	public Book updateBook(@PathVariable Long id, @RequestParam(value = "title", defaultValue = "") String title)  
	throws ResourceNotFoundException{
		Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID necesario:" + id));

		if (!title.equals("")){
			book.setTitle(title);
			repository.save(book);
		}
		return book;
	}

	@PostMapping("/register")
	Book newBook(@RequestParam(value = "title", defaultValue = "") String title, @RequestParam(value = "author", defaultValue = "") String author, @RequestParam(value = "lang", defaultValue = "EN") String lang, @RequestParam(value = "genre", defaultValue = "") String genre, @RequestParam(value = "pages", defaultValue = "") int pages) {
		return repository.save(new Book(title, author, lang, genre, pages));
	}

	@DeleteMapping("/delete/{id}")
	public Book deleteBook(@PathVariable Long id) throws ResourceNotFoundException {
		Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID necesario:" + id));
		repository.deleteById(book.getId());
		return book;
	}

}