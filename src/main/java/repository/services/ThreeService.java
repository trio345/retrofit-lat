package repository.services;

import repository.models.ListUsersModel;
import repository.models.PostModelReq;
import repository.models.PostsModel;
import repository.models.UsersModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ThreeService {

    @GET("posts")
    Call<List<PostsModel>> getPosts();

    @GET("users")
    Call<List<UsersModel>> getUsers();


}
