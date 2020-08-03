package repository.services;

import repository.models.ListUsersModel;
import repository.models.SingleUserModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ReqresService {
    @GET("api/users")
    Call<List<ListUsersModel>> getListUsers();

    @GET("api/users/{id}")
    Call<SingleUserModel> getUserDetails(@Path("id") int id);




}
