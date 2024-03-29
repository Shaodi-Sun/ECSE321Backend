package ca.mcgill.ecse321.intercityridesharingsystem;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

public class HttpUtils {
   //public static final String DEFAULT_BASE_URL = "https://t04-backend.herokuapp.com/";
   public static final String DEFAULT_BASE_URL = "http://10.0.2.2:8080/";
    private static String baseUrl;
    private static AsyncHttpClient client = new AsyncHttpClient();
    //final int DEFAULT_TIMEOUT = 20 * 1000;
    //client.setTimeout(5000);

    static {
        baseUrl = DEFAULT_BASE_URL;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        HttpUtils.baseUrl = baseUrl;
    }

    public static void get(String url, RequestParams params, TextHttpResponseHandler response) {
        client.get(getAbsoluteUrl(url), params, response);
    }
  

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return baseUrl + relativeUrl;
    }
}


