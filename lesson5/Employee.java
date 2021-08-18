package lesson5;

public class Employee {

    private String full_name;
    private String position;
    private String email;
    private String phone_number;
    private int salary;
    private int age;

     Employee(String full_name, String position, String email, String phone_number, int salary, int age){
         this.full_name = full_name;
         this.position = position;
         this.email = email;
         this.phone_number = phone_number;
         this.salary = salary;
         this.age = age;
    }

    int getAge(){return age;}

    void info(){
        System.out.printf("ФИО: %s\nДолжность: %s\nemail: %s\nтелефон: %s\nзарплата: %s$\n" + "возраст: %s\n\n",
                full_name,position,email,phone_number,salary,age);
    }
}
