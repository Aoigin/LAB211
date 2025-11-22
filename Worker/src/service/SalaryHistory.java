package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author LE THI BICH NGAN
 */
public class SalaryHistory {
    private String code;
    private String name;
    private int age;
    private double salary;
    private String status;
    private String date;

    public SalaryHistory(String code, String name, int age, double salary, String status) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-9s %-3d %-15.2f %-8s %-10s", 
                code, name, age, salary,status, date);
    }
}
