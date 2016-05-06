package cbedoy.cbchatmediacell;

import android.util.Log;

import com.embedly.api.Api;

import java.util.HashMap;

import cbedoy.cbchatmediacell.models.Metadata;

/**
 * Created by bedoy on 5/5/16.
 */
public class EmbedlyService
{
    private static Api mAPI;
    public static void init()
    {
        mAPI = new Api("Embedly-Demo", "e33332a0146045eea14b082e9f39e90e");
    }

    public static void scrappingWithUrl(String url)
    {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("url", url);

        RestService restService = new RestService();
        restService.setParameters(params);
        restService.setApi(mAPI);
        restService.setCallback(new IEmbedlyCallback() {
            @Override
            public void onSuccess(HashMap<String, Object> response) {

                Metadata metadata = new Metadata();

            }

            @Override
            public void onFailure() {
                Log.e("Error", "Error");
            }
        });
        restService.execute();

    }



    interface IEmbedlyCallback
    {
        void onSuccess(HashMap<String, Object> response);

        void onFailure();
    }
}
