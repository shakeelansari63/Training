package ed.java.p004.Arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Arrays are fixed sid list in Java and once allocated, their size does not change
        // 1D array
        int[] arr1D = new int[5];
        arr1D[0] = 10;
        arr1D[1] = 20;
        arr1D[2] = 30;
        arr1D[3] = 40;
        arr1D[4] = 50;
        System.out.println(Arrays.toString(arr1D));

        // There is smaller syntax if we know values
        int[] arr1DNew = { 10, 20, 30, 40, 50 };
        System.out.println(Arrays.toString(arr1DNew));

        // 2D array
        int[][] arr2D = new int[3][4];
        arr2D[0][0] = 1;
        arr2D[0][1] = 2;
        arr2D[0][2] = 3;
        arr2D[0][3] = 4;
        arr2D[1][0] = 5;
        arr2D[1][1] = 6;
        arr2D[1][2] = 7;
        arr2D[1][3] = 8;
        arr2D[2][0] = 9;
        arr2D[2][1] = 10;
        arr2D[2][2] = 11;
        arr2D[2][3] = 12;
        System.out.println(Arrays.deepToString(arr2D));

        // There is smaller syntax if we know values
        int[][] arr2DNew = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
        };
        System.out.println(Arrays.deepToString(arr2DNew));
    }
}
