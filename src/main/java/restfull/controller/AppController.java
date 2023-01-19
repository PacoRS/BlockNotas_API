package restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restfull.model.Note;
import restfull.model.Usuario;
import restfull.respository.UsuarioRepository;
import restfull.service.NotesService;
import restfull.service.UsuarioServicie;

@RestController
@RequestMapping("/blocknotas")
public class AppController {
	@Autowired
	NotesService service;

	@Autowired
	UsuarioServicie users;

	//Parte de notas
	@GetMapping("/notes")
	public ResponseEntity<List<Note>> getAllNotes() {
		List<Note> result = service.getAllNotes();
		return new ResponseEntity<List<Note>>(result, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
		Note entity = service.getNoteById(id);
		return new ResponseEntity<Note>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	@PostMapping("/notes")
	public HttpStatus CreateOrUpdateNote(@RequestBody Note nt) {
		service.createOrUpdateNote(nt);
		return HttpStatus.OK;
	}
	
	@DeleteMapping("/notes/{id}")
	public HttpStatus DeleteNote(@PathVariable("id") Long id) {
		service.deleteByNote(id);
		return HttpStatus.OK;
	}
	
	
	//Parte de Usuario
	@GetMapping("/users")
	public ResponseEntity<List<Usuario>> getAllUsers() {
		List<Usuario> result = users.getAllUsers();
		return new ResponseEntity<List<Usuario>>(result, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id) {
		Usuario entity = users.getUserById(id);
		return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("users")
	public HttpStatus CreateOrUpdateUser(@RequestBody Usuario us) {
		System.out.println(us);
		users.createOrUpdateUser(us);
		return HttpStatus.OK;
	}
	
	@DeleteMapping("/users/{id}")
	public HttpStatus DeleteUser(@PathVariable("id") Long id) {
		users.deleteByUser(id);
		return HttpStatus.OK;
	}
	
	

}
