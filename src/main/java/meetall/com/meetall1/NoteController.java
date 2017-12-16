package meetall.com.meetall1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    // Create a new Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }
    // Get a Single Note
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long id) {
        Note note = noteRepository.findOne(id);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }
    // Update a Note
    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findOne(id);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        note.setUsername(noteDetails.getUsername());
        note.setRandomkey(noteDetails.getRandomkey());
        note.setVkid(noteDetails.getVkid());
        note.setFacebookid(noteDetails.getFacebookid());
        note.setInstlogin(noteDetails.getInstlogin());

        Note updatedNote = noteRepository.save(note);
        return ResponseEntity.ok(updatedNote);
    }
    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }

}