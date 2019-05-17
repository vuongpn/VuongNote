package mvpdemo.notemvp.com.tungvuong;

import java.util.List;

import mvpdemo.notemvp.com.tungvuong.models.Note;

public interface MainContract {

    interface MainActivityView {

        void showError(String msg);

        void setAdapter(List<Note> notes);

        void clearEdittext();

    }

    interface UserPreferences { String NOTES_LIST = "notes_list";

        void addNote(Note note);

        void removeNote(Note note);

        List<Note> getNotes();

    }
    interface Presenter {

        void onStop();

        void onStart();

    }

}
