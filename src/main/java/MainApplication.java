import com.google.gson.Gson;
import repository.clients.ReqresClient;
import repository.models.SingleUserModel;
import repository.services.ReqresService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainApplication {
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
    }
}
