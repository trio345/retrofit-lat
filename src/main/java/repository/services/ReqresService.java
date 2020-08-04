package repository.services;

import com.google.gson.JsonObject;
import okhttp3.ResponseBody;
import repository.models.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface ReqresService {
//    @GET("api/users?")
//    Call<List<ListUsersModel>> getListUsers(@Query("page") int page);

    @GET("api/users?")
    Call<ListUsersModel> getListUsers(@Query("page") int page);

    @GET("api/users/{id}")
    Call<SingleUserModel> getUserDetails(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("api/users")
    Call<PostModelReq> postUser(@Body PostModelReq add);

    @Headers("Content-Type: application/json")
    @PUT("api/users/{id}")
    Call<UpdateModelReq> putUser(@Body UpdateModelReq update, @Path("id") int id);

    @Headers("Content-Type: application/json")
    @PATCH("api/users/{id}")
    Call<UpdateModelReq> patchUser(@Body UpdateModelReq patch, @Path("id") int id);

    @Headers("Content-Type: application/json")
    @DELETE("api/users/{id}")
    Call<ListUsersModel> deleteUser(@Path("id") int id);



}
