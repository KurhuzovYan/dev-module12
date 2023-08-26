package global.goit.repo;

import global.goit.entity.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
    private Map<Long, Note> notes;

    public NoteService() {
        notes = new HashMap<>();
    }

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (notes.remove(id) == null) {
            throw new RuntimeException("Note with id = " + id + " doesn't exist!");
        }
    }

    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            Note currentNote = notes.get(note);
            currentNote.setTitle(note.getTitle());
            currentNote.setContent(note.getContent());
        } else {
            throw new RuntimeException("Note with id = " + note.getId() + " doesn`t exist!");
        }
    }

    public Note getById(long id) {
        return notes.get(id);
    }
}
