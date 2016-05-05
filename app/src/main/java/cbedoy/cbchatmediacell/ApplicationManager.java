package cbedoy.cbchatmediacell;

import android.app.Application;

/**
 * Created by bedoy on 5/5/16.
 */
public class ApplicationManager extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        Utils.init(this);
    }
}
