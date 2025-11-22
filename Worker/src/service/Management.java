package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Worker;
import static main.Menu.sc;

public class Management {

    private List<Worker> w = new ArrayList<>();
    private List<SalaryHistory> histories = new ArrayList<>();

    /*
    //constructor khởi tạo giá trị cho list
    private Management(){
        employee = new ArrayList<>();
        histories = new ArrayList<>();
    }*/
    public boolean isExistedCode(String xCode) {
        for (Worker e : w) {
            if (e.getId().equalsIgnoreCase(xCode)) {
                return true;
            }
        }
        return false;
    }

    public void addWorker() {
        String code;
        while (true) {
            System.out.print("Enter Code: ");
            try {
                code = sc.nextLine();
                if (code == null || code.isEmpty() || isExistedCode(code)) {
                    System.out.println("Code cannot be null or duplicate. "
                            + "PLease create another code");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid code value...");
                sc.nextLine();
            }

        }
        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = sc.nextLine().trim();
            //\\p{L} : p{isLetter}
            if (!name.matches("^[\\p{L} ]+$")) {
                System.out.println("Name cannot contain digits or characters.");
                continue;
            }
            break;
        }

        //tự động viết hoa chữ cái đầu của tên
        //một chiếc thùng để hết tên là chữ thường và ngăn cách bởi dấu space
        String[] words = name.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (w.length() > 0) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                        .append(w.substring(1))
                        .append(" ");
            }
        }
        name = sb.toString().trim();

        int age;
        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = sc.nextInt();
                sc.nextLine(); // clear buffer
                if (age < 18 || age > 50) {
                    System.out.println("Invalid age number. Please enter age between 18 and 50");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid age number");
                sc.nextLine();
            }
        }

        double salary;
        while (true) {
            try {
                System.out.print("Enter Salary: ");
                salary = sc.nextDouble();
                sc.nextLine(); // clear buffer
                if (salary <= 0) {
                    System.out.println("Invalid salary number. Please enter a positive number.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid salary number");
                sc.nextLine();
            }
        }

        String location;
        while (true) {
            System.out.print("Enter work location: ");
            location = sc.nextLine().trim();
            if (!location.matches("^[\\p{L} ]+$")) {
                System.out.println("Invalid location "
                        + "(no numbers or symbols allowed).");
                continue;
            }
            break;
        }

        w.add(new Worker(code, name, age, salary, location));
        histories.add(new SalaryHistory(code, name, age, salary, ""));
        System.out.println("Worker added successfully!!!");

    }

    public Worker searchById(String code) {
        for (Worker e : w) {
            if (e.getId().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return (null);
    }

    public void increaseSalary() {
        if (w.isEmpty()) {
            System.out.println("We have no workers.");
            return;
        }

        String code;
        Worker employee;
        while (true) {
            System.out.print("Enter code: ");
            code = sc.nextLine();
            employee = searchById(code);
            if (employee == null) {
                System.out.println("We don't have that bullshit code");
                continue;
            }
            break;
        }

        double amount;
        while (true) {
            System.out.print("Enter amount to increase: ");
            try {
                String input = sc.nextLine();
                //kiểm tra: cấm kí tự +,- và chữ
                //các số từ 0-9 + (dấu . <escape \\> 0-9)
                //? có (dấu . <escape \\> 0-9) hay không đều chấp nhận
                if (!input.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("Invalid amount. "
                            + "Please enter a positive number");
                    continue;
                }
                amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println("Is that increasing???");
                    continue;
                }
                //sc.nextLine(); -> đã là parseDouble thì không cần dòng này 
                //vì vốn dĩ nó không phải nhập trực tiếp từ người dùng
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid amount number...");
                sc.nextLine();
            }
        }

        if (amount > employee.getSalary() * 0.3) {
            System.out.println("You can only increase up to 30% of current salary.");
            return;
        } else {
            employee.setSalary(employee.getSalary() + amount);
            histories.add(new SalaryHistory(employee.getId(), employee.getName(), employee.getAge(), employee.getSalary(), "UP"));
            System.out.println("Increase salary successfully!!!");
        }
    }

    public void decreaseSalary() {
        if (w.isEmpty()) {
            System.out.println("We have no workers.");
            return;
        }

        String code;
        Worker employee;
        while (true) {
            System.out.print("Enter code: ");
            code = sc.nextLine();
            employee = searchById(code);
            if (employee == null) {
                System.out.println("We don't have that bullshit code");
                continue;
            }
            break;
        }

        double amount;
        while (true) {
            System.out.print("Enter amount to decrease: ");
            try {
                String input = sc.nextLine();
                if (!input.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("Invalid amount. Please enter a positive number");
                    continue;
                }
                amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println("Is that decreasing???");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid amount number...");
                sc.nextLine();
            }

        }
        if (amount >= employee.getSalary() * 0.9) {
            System.out.println("Cannot reduce more than 90% of salary.");
            return;
        }
        employee.setSalary(employee.getSalary() - amount);
        histories.add(new SalaryHistory(employee.getId(), employee.getName(), employee.getAge(), employee.getSalary(), "DOWN"));
        System.out.println("Decrease salary successfully!!!");
    }

    public void displayInfo() {
        if (histories.isEmpty()) {
            System.out.println("We have no bullshit lists");
            return;
        }

        histories.sort((h1, h2) -> h1.getCode().compareToIgnoreCase(h2.getCode()));

        System.out.printf("%-5s %-8s %-5s %-10s %-6s %10s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");

        for (SalaryHistory h : histories) {
            System.out.println(h);
        }

        System.out.println("-----------------------------------------------------------------");
        
        Map<String, SalaryHistory> latest = new LinkedHashMap<>();
        for (SalaryHistory h : histories) {
            latest.put(h.getCode(), h);
        }

        for (SalaryHistory h : latest.values()) {
            System.out.println(h);
        }
    }
}
