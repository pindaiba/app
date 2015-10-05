package activity;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class AppConfig extends Application {
    public static final String PARSE_CHANNEL = "Pindaiba";
    public static final String PARSE_APPLICATION_ID = "nFNZ8Tuer29GijqcGhl1OoJwcrm5oml7QzzH0wZG";
    public static final String PARSE_CLIENT_KEY = "gdybm9pUjQNiOD26X4PqVm6lj6EiAPqdZESxL91X";
    public static final int NOTIFICATION_ID = 100;
    private static String TAG = AppConfig.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, PARSE_APPLICATION_ID, PARSE_CLIENT_KEY);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParsePush.subscribeInBackground(PARSE_CHANNEL, new SaveCallback() {

            @Override
            public void done(ParseException e) {
                Log.e(TAG, "Successfully subscribed to Parse!");
            }
        });

    }

}
