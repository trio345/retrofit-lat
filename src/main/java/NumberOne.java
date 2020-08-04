import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import repository.clients.ReqresClient;
import repository.services.ReqresService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

public class NumberOne {
    public static void main(String[] args) {
//        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
//                .getUserDetails(2)
//                .enqueue(new Callback<>() {
//                    @Override
//                    public void onResponse(Call<SingleUserModel> call, Response<SingleUserModel> response) {
//                        if (response.code() >= 200 & response.code() < 300){
//                            System.out.println(new Gson().toJson(response.body()));
//                        }else {
//                            System.out.println("Error response code " + response.code());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<SingleUserModel> call, Throwable t) {
//                        System.out.println(t.getMessage());
//                    }
//                });

//        System.out.println("-----POST DATA----\n");
        // post data
//        System.out.println(params);
        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                .postUser()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

//        System.out.println("-----GET ALL DATA----\n");
        // get all data
//        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
//                    .getListUsers(3)
//                    .enqueue(new Callback<>() {
//                        @Override
//                        public void onResponse(Call<ListUsersModel> call, Response<ListUsersModel> response) {
//                            if (response.code() >= 200 & response.code() < 300){
//                                System.out.println(new Gson().toJson(response.body()));
//                            }else {
//                                System.out.println("Error response code " + response.code());
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ListUsersModel> call, Throwable t) {
//                            t.printStackTrace();
//                        }
//                    });
    }
}
