package com.epam.task6.domain.verifable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by olga on 21.04.15.
 */
public class PreparedJob {
    @NotNull
    @Min(value = 1)
    private int id;

    @NotNull
    @Min(value = 1)
    private int cost;

    @NotNull
    @Size(min = 1)
    private ArrayList<String> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<String> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<String> employees) {
        this.employees = employees;
    }
}
