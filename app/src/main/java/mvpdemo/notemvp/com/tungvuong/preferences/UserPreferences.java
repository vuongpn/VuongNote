package mvpdemo.notemvp.com.tungvuong.preferences;

import java.util.List;

import mvpdemo.notemvp.com.tungvuong.models.Note;

public interface UserPreferences { String NOTES_LIST = "notes_list";

    void addNote(Note note);

    void removeNote(Note note);

    List<Note> getNotes();

}
