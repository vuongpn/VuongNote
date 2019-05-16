package mvpdemo.notemvp.com.tungvuong;

import android.app.Application;

import mvpdemo.notemvp.com.tungvuong.preferences.PreferencesProvider;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        PreferencesProvider.init(this);
    }
}
