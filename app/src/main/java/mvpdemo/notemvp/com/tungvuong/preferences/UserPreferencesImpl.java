package mvpdemo.notemvp.com.tungvuong.preferences;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import mvpdemo.notemvp.com.tungvuong.MainContract;
import mvpdemo.notemvp.com.tungvuong.models.Note;

public class UserPreferencesImpl implements MainContract.UserPreferences {

    protected SharedPreferences mPreferences;

    public UserPreferencesImpl() {
        this.mPreferences = PreferencesProvider.providePreferences();
    }


    @Override
    public void addNote(Note note) {

        ArrayList<Note> dbNotes = getNotes();
        dbNotes.add(0, note);

        String noteAsString = new Gson().toJson(dbNotes);
        mPreferences.edit().putString(NOTES_LIST, noteAsString).apply();
    }

    @Override
    public void removeNote(Note note) {

        ArrayList<Note> dbNotes = getNotes();
        for (int i = 0; i < dbNotes.size(); i++) {
            if (dbNotes.get(i).getId() == note.getId()) {
                dbNotes.remove(i);
                break;
            }
        }

        if (dbNotes.size() > 0) {
            String noteAsString = new Gson().toJson(dbNotes);
            mPreferences.edit().putString(NOTES_LIST, noteAsString).apply();
        } else {
            mPreferences.edit().putString(NOTES_LIST, "").apply();
        }
    }

    @Override
    public ArrayList<Note> getNotes() {

        ArrayList<Note> notes = new ArrayList<>();

        String noteListString = mPreferences.getString(NOTES_LIST, "");
        if (!TextUtils.isEmpty(noteListString)) {
            notes = new Gson().fromJson(noteListString, new TypeToken<List<Note>>() {
            }.getType());
        }

        return notes;
    }

}
