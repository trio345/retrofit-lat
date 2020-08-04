package repository.services;

import repository.models.ListUsersModel;
import repository.models.PostModelReq;
import repository.models.PostsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ThreeService {

    @GET("posts")
    Call<PostsModel> getPosts();

    @GET("users")
    Call<ListUsersModel> getUsers();


}
