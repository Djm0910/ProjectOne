package demo.example.com.pandalive.ui.acctivity.Button1.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 郝可心 on 2017/12/22.
 */
 //后半部分拼接
public interface interfase {
    @GET("PAGE14501767715521482/index.json")
    Call<ResponseBody> getURL();
}
