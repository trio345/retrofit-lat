package repository.clients;

import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReqresClient {

    public static <T> T userDetails(Class<T> service, String baseUrl){
        var retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(
                                GsonConverterFactory.create(
                                        new GsonBuilder().setLenient().create()
                                )
                        )
                        .build();
        return retrofit.create(service);
    }
}
