package mvpdemo.notemvp.com.tungvuong;

import java.util.List;

import mvpdemo.notemvp.com.tungvuong.models.Note;

public interface MainContract {
    interface MainView {

        void startLoading();

        void stopLoading();

    }
    interface MainActivityView {

        void showError(String msg);

        void setAdapter(List<Note> notes);

        void clearEdittext();

    }
    interface Presenter {

        void onStop();

        void onStart();

    }

}
