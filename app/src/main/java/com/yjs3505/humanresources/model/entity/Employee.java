package com.yjs3505.humanresources.model.entity;

import java.util.Date;

/**
 * @author Bora SAYINER
 * @version 1.0.0
 * @since Apr 7, 2018 4:13:11 PM
 */
public class Employee extends AbstractEntity {

    private String firstName;
    private String lastName;
    private Double salary;
    private Date hiredDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

}
