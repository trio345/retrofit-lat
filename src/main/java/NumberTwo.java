import com.google.gson.Gson;
import repository.clients.ReqresClient;
import repository.clients.TodoClient;
import repository.models.ListUsersModel;
import repository.models.TodoModel;
import repository.services.ReqresService;
import repository.services.TodoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.FileOutputStream;
import java.util.List;

public class NumberTwo {
    public static void main(String[] args) {
        TodoClient.todoClient(TodoService.class, "https://jsonplaceholder.typicode.com/")
                .getTodos()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<TodoModel> call, Response<TodoModel> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            var data = new Gson().toJson(response.body());
                            System.out.println(data);
                            try {
                                var file = new FileOutputStream("src/main/java/file.json");
                                file.write(data.getBytes());
                                file.flush();
                                file.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Response error with results  " +
                                    response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<TodoModel> call, Throwable t) {
                            t.printStackTrace();
                    }
                });



    }

}
