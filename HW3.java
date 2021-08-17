package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HW3 {

    public static void main(String[] args) {

        //task2();
        //task1();
    }

    public static void task2(){
        //Задание 2 - Создать массив из слов: String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
        // "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
        // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        //apple – загаданное, apricot - ответ игрока; ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        //Для сравнения двух слов посимвольно можно пользоваться: String str = "apple";  char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        //Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                          "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                          "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        char[] guessed_letters = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',};
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int n = rand.nextInt(words.length);
        System.out.println("Программа загадала слово, отгадайте его (" + words[n] +")");
        do {
            String word = scan.nextLine();
            int length_loop = words[n].length() <= word.length() ? words[n].length() : word.length();
            if(word.equals(words[n])) {
                System.out.println("Вы отгадали слово \"" + words[n] + "\"");
                break;
            }
            else {
                for(int i = 0; i < length_loop; i++) {
                    if (words[n].charAt(i) == word.charAt(i)) {
                        guessed_letters[i] = words[n].charAt(i);
                    }
                }
                arrPrint(guessed_letters);
                System.out.println("Ваш вариант неверный, попробуйте еще раз");
            }
        } while (true);

    }

    public static  void task1(){
        //Задание 1 - Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int n = rand.nextInt(10);
        int attempt = 0;
        System.out.println("Программа загадала слово, отгадайте его (" + n +")");
        while(attempt<3) {
            int num = scan.nextInt();
            if (num == n) {
                System.out.println("Вы выиграли!!! Вы отгадали число с " + (attempt+1) + "-й попытки");
                break;
            } else if (num > n) {
                attempt++;
                System.out.println("Загаданное число меньше, введенного вами. Количество ваших оставшихся попыток: " + (3-attempt));
            } else if (num < n) {
                attempt++;
                System.out.println("Загаданное число больше, введенного вами. Количество ваших оставшихся попыток: " + (3-attempt));
            }
            if (attempt >= 3) {
                System.out.println("Вы использовали все свои попытки, вы проиграли!!!");
            }
        }
        System.out.println("Хотите сыграть еще раз? Нажмите [Yes/No] для ответа");
        while (true){
            String answer = scan.next();
            if(answer.equals("Yes")){
                task1();
            }
            else if(answer.equals("No")){
                System.out.println("Game Over");
                break;
            }
            else {System.out.println("Вы некорректно ввели данные");}
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void arrPrint(char[] arr){
        for (char a : arr) System.out.print(a);
        System.out.println();
    }
}
