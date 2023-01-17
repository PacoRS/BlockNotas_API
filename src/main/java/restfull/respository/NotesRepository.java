package restfull.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restfull.model.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

}
