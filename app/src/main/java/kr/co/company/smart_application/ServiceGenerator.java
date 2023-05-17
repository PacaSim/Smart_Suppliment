package kr.co.company.smart_application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit retrofit;
    private static Gson gson;

    public static Retrofit getRetrofit() {
        gson=new GsonBuilder()
                .create();

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("http://apis.data.go.kr/1471000/HtfsTrgetInfoService02/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
