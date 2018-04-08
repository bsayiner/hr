package com.yjs3505.humanresources.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yjs3505.humanresources.R;
import com.yjs3505.humanresources.model.entity.Employee;

import java.util.List;

/**
 * @author Bora SAYINER
 * @version 1.0.0
 * @since 08.04.2018 19:06
 */
public class EmployeeListViewAdapter extends ArrayAdapter<Employee> {

    private List<Employee> employeeList;

    public EmployeeListViewAdapter(@NonNull Context context, List<Employee> employeeList) {
        super(context, R.layout.row_employee_list);
        this.employeeList = employeeList;
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_employee_list, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.lbl_first_name);
        Employee employee = employeeList.get(position);
        textView.setText(employee.getFirstName() + " " + employee.getLastName());
        return  convertView;
    }
}
