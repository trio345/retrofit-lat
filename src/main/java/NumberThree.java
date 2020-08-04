import com.google.gson.Gson;
import repository.clients.ReqresClient;
import repository.clients.ThreeClient;
import repository.models.ListUsersModel;
import repository.models.PostsModel;
import repository.models.UsersModel;
import repository.services.ReqresService;
import repository.services.ThreeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class NumberThree {

    public static void main(String[] args) {
        ThreeClient.request(ThreeService.class, "http://jsonplaceholder.typicode.com/")
                .getPosts()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        ThreeClient.request(ThreeService.class, "http://jsonplaceholder.typicode.com/")
                .getUsers()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<List<UsersModel>> call, Response<List<UsersModel>> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UsersModel>> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
    }
}
