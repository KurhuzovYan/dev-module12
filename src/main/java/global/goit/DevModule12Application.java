package global.goit;

import global.goit.entity.Note;
import global.goit.repo.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DevModule12Application {


    public static void main(String[] args) {
        SpringApplication.run(DevModule12Application.class, args);

        NoteService noteService = new NoteService();

        System.out.println(noteService.add(new Note("Title", "Context")));
        System.out.println(noteService.add(new Note( "Title2", "Context2")));
        System.out.println(noteService.add(new Note("Title3", "Context3")));
        System.out.println(noteService.add(new Note("Title4", "Context4")));
        System.out.println();
        System.out.println(noteService.getById(3));
        System.out.println(noteService.getById(5));
        System.out.println(noteService.getById(7));
        System.out.println();
        noteService.deleteById(3);
        System.out.println();
        noteService.listAll().stream().forEach(System.out::println);
        System.out.println();
        noteService.update(new Note("Changed title", "Changed context"));
    }
}
