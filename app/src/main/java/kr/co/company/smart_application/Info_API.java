package kr.co.company.smart_application;

import java.util.Map;

import kr.co.company.smart_application.data.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Info_API {
    @GET("getHtfsInfoList02?serviceKey=1JgbzODJZasewTpP5o4W%2BzSDvQNemCQ02j6hZ0t8RUeEjGEIDsxhZDJdyH%2F16oFL0cQRyr7K9ueBnRIBMx2KJw%3D%3D&type=json")
    Call<Result> getretrofit(@QueryMap Map<String, String> options);
}
