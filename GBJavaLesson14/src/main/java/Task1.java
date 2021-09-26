public class Task1 {

    private static int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};

    public static void main(String[] args) {
        copyArrPastFour(arr);
    }
    public static int[] copyArrPastFour(int[] arr){
        int[] arrNew = null;
        try {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == 4) {
                    arrNew = new int[(arr.length-1)-i];
                    System.arraycopy(arr, i+1, arrNew, 0, (arr.length-1)-i);
                    break;
                }
            }
            if (arrNew == null) {throw new ExceptionFromFour("В исходном массиве нет значения 4");}
        }catch (NullPointerException e){
            System.out.print("Вам необходимо создать и заполнить массив");
        }
        return arrNew;
    }
}

class ExceptionFromFour extends RuntimeException {
    public ExceptionFromFour(String message) {
        super(message);
    }
}

