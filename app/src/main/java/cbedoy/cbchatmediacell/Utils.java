package cbedoy.cbchatmediacell;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by bedoy on 5/5/16.
 */
public class Utils
{

    private static Handler mHandler;
    private static LayoutInflater mLayoutInflater;
    private static Context mContext;

    public static void init(Context context)
    {
        mHandler = new Handler(context.getMainLooper());

        mContext = context;

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static void deInit() {
        mHandler = null;
    }

    public static void postRunnable(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static void postRunnableAtFrontOfQueue(Runnable runnable) {
        mHandler.postAtFrontOfQueue(runnable);
    }

    public static void postDelayedRunnable(Runnable runnable, long delay) {
        mHandler.postDelayed(runnable, delay);
    }

    public static View viewFromResource(int resource)
    {
        return mLayoutInflater.inflate(resource, null);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap();
        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, fromJson(object.get(key)));
        }
        return map;
    }

    private static Object fromJson(Object json) throws JSONException {
        if (json == JSONObject.NULL) {
            return null;
        } else {
            if (json instanceof JSONObject) {
                return toMap((JSONObject) json);
            } else {
                if (json instanceof JSONArray) {
                    return toList((JSONArray) json);
                } else {
                    return json;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List toList(JSONArray array) throws JSONException {
        List list = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
            list.add(fromJson(array.get(i)));
        }
        return list;
    }

    public static Bitmap takeScreenShot(Activity activity)
    {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap bitmap = Bitmap.createBitmap(drawingCache, 0, statusBarHeight, width, height  - statusBarHeight);
        view.destroyDrawingCache();
        return bitmap;
    }


}
