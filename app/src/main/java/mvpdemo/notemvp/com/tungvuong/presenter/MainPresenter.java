package mvpdemo.notemvp.com.tungvuong.presenter;

import android.content.Intent;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import mvpdemo.notemvp.com.tungvuong.models.Note;
import mvpdemo.notemvp.com.tungvuong.preferences.UserPreferences;
import mvpdemo.notemvp.com.tungvuong.preferences.UserPreferencesImpl;
import mvpdemo.notemvp.com.tungvuong.Adapters.NotesAdapter;
import mvpdemo.notemvp.com.tungvuong.view.MainActivityView;

public class MainPresenter extends AbstractPresenter implements NotesAdapter.NoteDeleteListener {

    private MainActivityView mView;
    UserPreferences mDatabase = new UserPreferencesImpl();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy hh:mm a");

    public MainPresenter(MainActivityView mView) {
        this.mView = mView;
    }


    public void onCreate(Intent intent) {
        mView.setAdapter(mDatabase.getNotes());
    }

    public void addNote(String note) {
        if (TextUtils.isEmpty(note)) {
            mView.showError("Chưa nhập...");
        } else {
            mDatabase.addNote(new Note(System.currentTimeMillis(), note, simpleDateFormat.format(new Date())));
            mView.setAdapter(mDatabase.getNotes());
            mView.clearEdittext();
        }
    }

    @Override
    public void onNoteDeleteClicked(Note note) {
        mDatabase.removeNote(note);
    }
}
