package mvpdemo.notemvp.com.tungvuong.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesProvider {
    private static final String SHARED_PREFERENCES = "mvpPreferences";
    private static SharedPreferences sPreferences;

    static SharedPreferences providePreferences() {
        return sPreferences;
    }

    public static void init(Context context) {
        sPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

}
