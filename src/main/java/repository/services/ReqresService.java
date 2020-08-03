package repository.services;

import okhttp3.ResponseBody;
import repository.models.ListUsersModel;
import repository.models.SingleUserModel;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface ReqresService {
//    @GET("api/users?")
//    Call<List<ListUsersModel>> getListUsers(@Query("page") int page);

    @GET("api/users")
    Call<ListUsersModel> getListUsers(@Query("?page") int page);

    @GET("api/users/{id}")
    Call<SingleUserModel> getUserDetails(@Path("id") int id);

    @FormUrlEncoded
    @POST("api/users")
    Call<ResponseBody> postUser(@FieldMap HashMap<String, String> params);




}
