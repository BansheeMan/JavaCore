public class Task2 {

    private static int[] arr = {1,4,1,4,1,4,1};

    public static void main(String[] args) {
        arrWithOneAndFour(arr);
    }

    public static boolean arrWithOneAndFour(int[] arr){
        boolean four = false;
        boolean one = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 4){
                if(arr[i] == 1){one = true;}
                else if(arr[i] == 4){four = true;}
            }
            else {
                System.out.print("В массиве должны быть только значения 1 и 4");
                return false;
            }
        }
        return one && four;
    }
}
