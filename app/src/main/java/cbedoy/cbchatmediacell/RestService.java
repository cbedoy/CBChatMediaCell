package cbedoy.cbchatmediacell;

import android.os.AsyncTask;
import android.util.Log;

import com.embedly.api.Api;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bedoy on 5/5/16.
 */
public class RestService extends AsyncTask<Void, Void, HashMap<String, Object>>
{
    private Api mApi;
    private HashMap<String, Object> parameters;
    private EmbedlyService.IEmbedlyCallback callback;


    public void setApi(Api mApi) {
        this.mApi = mApi;
    }

    public void setParameters(HashMap<String, Object> parameters)
    {
        this.parameters = parameters;
    }

    public void setCallback(EmbedlyService.IEmbedlyCallback callback) {
        this.callback = callback;
    }

    @Override
    protected HashMap<String, Object> doInBackground(Void... params)
    {
        try
        {
            JSONArray oembed = mApi.oembed(parameters);

            return (HashMap<String, Object>) decorateResponse(oembed);
        }
        catch (Exception e)
        {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(HashMap<String, Object> hashMap)
    {
        super.onPostExecute(hashMap);

        if (hashMap == null)
            callback.onFailure();
        else
            callback.onSuccess(hashMap);
    }

    private Map<String, Object> decorateResponse(JSONArray response) throws JSONException
    {
        JSONObject rawResponse = response.getJSONObject(0);
        String type = rawResponse.getString("type");
        StringBuffer embedBuf = new StringBuffer();

        if ("photo".equals(type)) {
            if (!rawResponse.isNull("url")) {
                embedBuf.append("<div>");
                embedBuf.append("<center><img width=\"100%25\" src=\"");
                embedBuf.append(rawResponse.getString("url"));
                embedBuf.append("\"/></center></div>");
            }
        } else if ("video".equals(type)) {
            if (!rawResponse.isNull("html")) {
                embedBuf.append(rawResponse.getString("html"));
            }
        } else if ("rich".equals(type)) {
            if (!rawResponse.isNull("html")) {
                embedBuf.append(rawResponse.getString("html"));
            }
        } else if ("link".equals(type)) {
            embedBuf.append("<a href=\"");
            embedBuf.append(rawResponse.getString("url"));
            embedBuf.append("\">");
            if (!rawResponse.isNull("title")) {
                embedBuf.append(rawResponse.getString("title"));
            } else {
                embedBuf.append(rawResponse.getString("url"));
            }
            embedBuf.append("</a>");
        } else if ("error".equals(type)) {
            embedBuf.append("<p>");
            embedBuf.append(rawResponse.getString("error_message"));
            embedBuf.append("</p>");
        }

        return Utils.toMap(rawResponse);
    }
}
