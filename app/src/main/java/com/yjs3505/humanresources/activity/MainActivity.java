package com.yjs3505.humanresources.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yjs3505.humanresources.R;
import com.yjs3505.humanresources.model.DbContext;
import com.yjs3505.humanresources.model.entity.Employee;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Employee employee = new Employee();
        employee.setFirstName("Ali");
        employee.setLastName("VELİ");
        employee.setSalary(2500d);
        employee.setHiredDate(new Date());
        DbContext.getInstance().save(employee, new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Log.e(TAG, "onFailure: Error", t);
            }
        });
    }
}
