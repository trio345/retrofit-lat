import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import repository.clients.ReqresClient;
import repository.models.ListUsersModel;
import repository.models.PostModelReq;
import repository.models.SingleUserModel;
import repository.models.UpdateModelReq;
import repository.services.ReqresService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

public class NumberOne {
    public static void main(String[] args) {
        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                .getUserDetails(2)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<SingleUserModel> call, Response<SingleUserModel> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<SingleUserModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

//        System.out.println("-----POST DATA----\n");
        // post data
//        System.out.println(params);
        PostModelReq newUser = new PostModelReq();
        newUser.setName("trio");
        newUser.setJob("student");
//
        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                .postUser(newUser)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<PostModelReq> call, Response<PostModelReq> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostModelReq> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

//        System.out.println("-----GET ALL DATA----\n");
        // get all data
        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                    .getListUsers(3)
                    .enqueue(new Callback<>() {
                        @Override
                        public void onResponse(Call<ListUsersModel> call, Response<ListUsersModel> response) {
                            if (response.code() >= 200 & response.code() < 300){
                                System.out.println(new Gson().toJson(response.body()));
                            }else {
                                System.out.println("Error response code " + response.code());
                            }
                        }

                        @Override
                        public void onFailure(Call<ListUsersModel> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });

        // Put data
        UpdateModelReq updateUser = new UpdateModelReq();
        updateUser.setName("trio");
        updateUser.setJob("karyawan");

        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                .putUser(updateUser, 888)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UpdateModelReq> call, Response<UpdateModelReq> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateModelReq> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });


        // patch data
        UpdateModelReq newData = new UpdateModelReq();
        newData.setName("trio");
        newData.setJob("student");

        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                .patchUser(newData, 888)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UpdateModelReq> call, Response<UpdateModelReq> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.body()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateModelReq> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        ReqresClient.userDetails(ReqresService.class, "https://reqres.in/")
                .deleteUser(12)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<ListUsersModel> call, Response<ListUsersModel> response) {
                        if (response.code() >= 200 & response.code() < 300){
                            System.out.println(new Gson().toJson(response.code()));
                        }else {
                            System.out.println("Error response code " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ListUsersModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
    }
}
