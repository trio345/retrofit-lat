import com.google.gson.Gson;

import com.google.gson.JsonObject;
import repository.clients.TodoClient;

import repository.models.*;
import repository.services.TodoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberTwo {
    public static void main(String[] args) {
        TodoClient.todoClient(TodoService.class, "https://online-course-todo.herokuapp.com/api/v1/")
                .getTodos()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<TodoModel> call, Response<TodoModel> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            var data = new Gson().toJson(response.body());
                            final Gson gson = new Gson();
                            final TodoModel obj = gson.fromJson(data, TodoModel.class);

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

        TodoClient.todoClient(TodoService.class, "https://online-course-todo.herokuapp.com/api/v1/")
                .getTodo(19)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<TodoModel> call, Response<TodoModel> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            var data = new Gson().toJson(response.body());
                            System.out.println(data);
                        } else {
                            System.out.println("Response error with results  " +
                                    response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<TodoModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        // adding new data

        Data newData = new Data();
        newData.setTask("Makan nasi");
        newData.setStatus(false);


        TodoClient.todoClient(TodoService.class, "https://online-course-todo.herokuapp.com/api/v1/")
                .postTodo(newData)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<CreateTodo> call, Response<CreateTodo> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            var data = new Gson().toJson(response.body());
                            System.out.println(data);
                        } else {
                            System.out.println("Response error with results  " +
                                    response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<CreateTodo> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        Data updateData = new Data();
        updateData.setTask("Makan nasi");
        updateData.setStatus(false);

        TodoClient.todoClient(TodoService.class, "https://online-course-todo.herokuapp.com/api/v1/")
                .putTodo(updateData, 24)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<UpdateTodo> call, Response<UpdateTodo> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            var data = new Gson().toJson(response.body());
                            System.out.println(data);
                        } else {
                            System.out.println("Response error with results  " +
                                    response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateTodo> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });

        TodoClient.todoClient(TodoService.class, "https://online-course-todo.herokuapp.com/api/v1/")
                .deleteTodo(12)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<DeleteTodo> call, Response<DeleteTodo> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            var data = new Gson().toJson(response.body());
                            System.out.println(data);
                        } else {
                            System.out.println("Response error with results  " +
                                    response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<DeleteTodo> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
    }

}
