package com.yjs3505.humanresources.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yjs3505.humanresources.model.entity.Employee;
import com.yjs3505.humanresources.model.service.RESTFulService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Bora SAYINER
 * @version 1.0.0
 * @since 08.04.2018 15:45
 */
public final class DbContext {

    private static final DbContext DB_CONTEXT;

    private static final String BASE_URL = "http://37.139.11.7:8081/";

    static {
        DB_CONTEXT = new DbContext();
    }

    private final RESTFulService service;

    private DbContext() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.service = retrofit.create(RESTFulService.class);
    }

    public static DbContext getInstance() {
        return DB_CONTEXT;
    }

    public void save(Employee employee, Callback<Employee> call) {
        service.save(employee).enqueue(call);
    }

    public void delete(long id, Callback<Void> call) {
        service.delete(id).enqueue(call);
    }

    public void findAll(Callback<List<Employee>> callback)  {
        service.findAll().enqueue(callback);
    }
}
