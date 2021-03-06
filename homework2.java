package Java.lesson2;


public class homework2 {
    public static void main(String[] args) {
        //Задание 1 - Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) arr1[i] = 0;
            else arr1[i] = 1;
        }

        //Задание 2 - Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arr2 = new int[8];
        arr2[0] = 0;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] + 3;
        }

        //Задание 3 - Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
        }

        //Задание 4 - Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] arr4 = new int[10][10];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                arr4[i][i] = 1;
                arr4[arr4.length - 1 - i][i] = 1;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        //1 0 0 0 0 0 0 0 0 1
        //0 1 0 0 0 0 0 0 1 0
        //0 0 1 0 0 0 0 1 0 0
        //0 0 0 1 0 0 1 0 0 0
        //0 0 0 0 1 1 0 0 0 0
        //0 0 0 0 1 1 0 0 0 0
        //0 0 0 1 0 0 1 0 0 0
        //0 0 1 0 0 0 0 1 0 0
        //0 1 0 0 0 0 0 0 1 0
        //1 0 0 0 0 0 0 0 0 1

        //--------------------------------------------------------------------------------------------------------------
        //Задание 5 - **Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arr5 = {14, 6, 3, 5, 7, 10, 42};
        int min = arr5[0];
        int max = arr5[0];
        for (int a : arr5) {
            if (a < min) min = a;
            if (a > max) max = a;
        }
        System.out.println(min); //3
        System.out.println(max); //42
        //--------------------------------------------------------------------------------------------------------------

        int[] arr6 = {3, 2, 1, 1, 3};
        System.out.println(task6(arr6));  //TASK6 - true
        //--------------------------------------------------------------------------------------------------------------

        int[] arr7 = {1, 2, 3, 4, 5};
        task7(arr7, -3);  //TASK7
    }

    //Задание 6 - ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean task6(int[] arr) {
        int sum = 0;
        int left_side = 0;
        for (int i : arr) {
            sum += i;
        }
        for (int i = 0; i < arr.length; i++) {
            left_side += arr[i];
            int right_side = sum - left_side;
            if (left_side == right_side) return true;
        }
        return false;
    }

    //Задание 7 - **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void task7(int[] arr, int n) {
        if(n>0){
            for(int i=0;i<n;i++){
                int elem = arr[arr.length-1];
                System.arraycopy(arr,0,arr,1,arr.length-1);
                arr[0] = elem;
            }
        }
        if(n<0){
            for(int i=0;i>n;i--){
                int elem = arr[0];
                System.arraycopy(arr,1,arr,0,arr.length-1);
                arr[arr.length-1] = elem;
            }
        }
    }
}