package lesson5;

public class Main {

    public static void main(String[] args) {

        Employee[] staff = new Employee[5];
        staff[0] =  new Employee("Брафловский Кайл Эдуардович", "юрист", "brafl@gmail.com", "34455", 600,23);
        staff[1] =  new Employee("Хан Соло", "пилот", "HanSolo@gmail.com", "67784", 1000,56);
        staff[2] =  new Employee("Джон Уэйн", "начальник охраны", "JohnWyane@gmail.com", "78952", 850,40);
        staff[3] =  new Employee("Брюс Уэйн", "ген.директор", "BruceWayne@gmail.com", "12121", 5000,43);
        staff[4] =  new Employee("Мартин Лютер Кинг", "проповедник", "King@gmail.com", "3696", 450,29);

        for (int i = 0;i< staff.length;i++){
            if(staff[i].getAge() >= 40) {staff[i].info();}
        }
    }
}
