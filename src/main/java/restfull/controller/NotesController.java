package restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restfull.model.Note;
import restfull.service.NotesSerivice;

@RestController
@RequestMapping("/notes")
public class NotesController {
	@Autowired
	NotesSerivice service;

	@GetMapping
	public ResponseEntity<List<Note>> getAllNotes() {
		List<Note> result = service.getAllNotes();
		return new ResponseEntity<List<Note>>(result, new HttpHeaders(), HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Note> getItemById(@PathVariable("id") Long id) {
		Note entity = service.getNoteById(id);

		return new ResponseEntity<Note>(entity, new HttpHeaders(), HttpStatus.OK);
	}

}
