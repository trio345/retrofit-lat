package repository.services;

import repository.models.TodoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface TodoService {
    @GET("todos")
    Call<List<TodoModel>> getTodos();

    @GET("todos/{id}")
    Call<TodoModel> getTodo(@Path("id") int id);
}
