package restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfull.exeption.RecordNotFoundExeption;
import restfull.model.Note;
import restfull.respository.NotesRepository;

@Service
public class NotesService {
	
	@Autowired
	NotesRepository repository;
	
	public List<Note> getAllNotes() {
		return repository.findAll();
	}
	
	public Note getNoteById(Long id) {
		Optional<Note> note= repository.findById(id);
		if(note.isPresent()) {
			return note.get();
		}else {
			throw new RecordNotFoundExeption("Nota no encontrada", id);
		}
	}
	
	public Note createOrUpdateNote(Note note) {
		if(note.getId()!=null) {
			Optional<Note> n = repository.findById(note.getId());
			if(n.isPresent()) {
				//existe, luego actualizo
				note = repository.save(note);
			}else {
				throw new RecordNotFoundExeption("Nota no encontrada", note.getId());
			}
		}else {
			note = repository.save(note);
		}
		return note;
	}
	
	public void deleteByNote(Long id) {
		Optional<Note> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			//error
		}
	}
}
