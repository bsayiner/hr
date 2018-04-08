package com.yjs3505.humanresources.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yjs3505.humanresources.R;
import com.yjs3505.humanresources.adapter.EmployeeListViewAdapter;
import com.yjs3505.humanresources.model.DbContext;
import com.yjs3505.humanresources.model.entity.Employee;

import java.net.HttpURLConnection;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_employees);

        DbContext.getInstance().findAll(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                final List<Employee> employees = response.body();
                EmployeeListViewAdapter employeeListViewAdapter = new EmployeeListViewAdapter(MainActivity.this, employees);
                listView.setAdapter(employeeListViewAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, employees.get(position).getSalary()+"", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });


    }

}
