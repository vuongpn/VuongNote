package mvpdemo.notemvp.com.tungvuong.view;

import java.util.List;

import mvpdemo.notemvp.com.tungvuong.models.Note;

public interface MainActivityView {

    void showError(String msg);

    void setAdapter(List<Note> notes);

    void clearEdittext();

}
