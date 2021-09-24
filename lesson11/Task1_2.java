package lesson11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1_2 {

    public static void main(String[] args) {

        String[] s = {"A","B","C","D","E"};
        Integer[] i = {1,2,3,4,5};

        print(s);
        print(i);
        swapElem(s,0,4);
        swapElem(i,0,4);
        print(s);
        print(i);
        System.out.println();
        print(converterArrList(s));
        print(converterArrList(i));
    }

    public static <T> void swapElem(T[] arr, int fr, int sc){
            T value = arr[fr];
            arr[fr] = arr[sc];
            arr[sc] = value;
    }

    public static <T> List<T> converterArrList(T[] arr){
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }
    public static <T> void print(T[] arr){
        for ( T val: arr) {
            System.out.print(val + "; ");
        }
        System.out.println();
    }
    public static <T> void print(List<T> list){
        for ( T val: list) {
            System.out.print(val + "; ");
        }
        System.out.println();
    }
}
