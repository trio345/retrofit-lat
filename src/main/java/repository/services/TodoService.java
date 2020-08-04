package repository.services;

import repository.models.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TodoService {
    @GET("todos")
    Call<TodoModel> getTodos();

    @GET("todos/{id}")
    Call<TodoModel> getTodo(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("todos")
    Call<CreateTodo> postTodo(@Body Data add);

    @Headers("Content-Type: application/json")
    @PUT("todos/{id}")
    Call<UpdateTodo> putTodo(@Body Data update, @Path("id") int id);

    @Headers("Content-Type: application/json")
    @DELETE("todos/{id}")
    Call<DeleteTodo> deleteTodo(@Path("id") int id);

}
