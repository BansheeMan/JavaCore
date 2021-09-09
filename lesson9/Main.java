package lesson9;

public class Main {

    public static void main(String[] args) {
        String arr[][] = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "9"}
        };

        System.out.print(arrCheck4x4andCalc(arr));

    }

    public static int arrCheck4x4andCalc(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4 || arr.length != 4) {
                throw new MyArraySizeException("THE ARRAY MUST BE 4X4 SIZE");
            }
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    String m = String.format("The value[%s][%s] is not a digit in the string data type", i, j);
                    throw new MyArrayDataException(m, e);
                }
            }
        }
        return sum;
    }
}




