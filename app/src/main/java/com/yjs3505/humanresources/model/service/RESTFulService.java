package com.yjs3505.humanresources.model.service;

import com.yjs3505.humanresources.model.entity.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Bora SAYINER
 * @version 1.0.0
 * @since 08.04.2018 15:48
 */
public interface RESTFulService {

    @POST("employees")
    Call<Employee> save(@Body Employee employee);

    @PUT("employees/{id}")
    Call<Employee> update(@Path("id") long id, @Body Employee employee);

    @DELETE("employees/{id}")
    Call<Void> delete(@Path("id") long id);

    @GET("employees")
    Call<List<Employee>> findAll();

    @GET("employees/{id}")
    Call<Employee> findById(@Path("id") long id);

}
