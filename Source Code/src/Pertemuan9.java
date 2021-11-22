import java.util.Arrays;
import java.util.Scanner;

public class Pertemuan9 {
    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);

        // Deklarasi dan Instantiasi Array
        int[] arrayA = new int[3];
        String arrayB[];
        arrayB = new String[2];

        // Isi Array
        arrayA[0] = 5;
        arrayA[2] = 2;
        arrayA[1] = arrayA[0] - arrayA[2];

        // Tampilkan isi Array
        System.out.print("ArrayA: ");
        for (int i = 0; i < arrayA.length; i++) {
            System.out.print(arrayA[i] + " ");
        }

        System.out.println("\n---------------------------------------------------------------------------");

        // Isi array secara eksplisit
        double[] arrayC = new double[] { 2.5, 3.4, 8.9 };
        int[] arrayD = { 1, 2, 3, 4, 5 };
        System.out.print("ArrayD: ");
        for (int i = 0; i < arrayD.length; i++) {
            System.out.print(arrayD[i] + " ");
        }

        System.out.println("\n---------------------------------------------------------------------------");

        System.out.println("ArrayC: " + Arrays.toString(arrayC));

        System.out.println("---------------------------------------------------------------------------");

        // Isi array pakai for loop
        for (int i = 0; i < arrayB.length; i++) {
            System.out.print("Masukkan value untuk arrayB index ke-" + (i) + ": ");
            arrayB[i] = io.next();
        }

        // Tampilkan isi array pakai for each
        System.out.print("ArrayB: ");
        for (String b : arrayB) {
            System.out.print(b + " ");
        }

        System.out.println("\n---------------------------------------------------------------------------");

        // Reference array
        arrayD = arrayA;
        System.out.print("ArrayD sebelum diubah: ");
        for (int i : arrayD) {
            System.out.print(i + " ");
        }

        System.out.println("\n---------------------------------------------------------------------------");

        arrayD[2] = 4;
        arrayA[0] = 10;
        System.out.print("Isi Array D setelah diubah: ");
        for (int i : arrayD) {
            System.out.print(i + " ");
        }

        System.out.println("\n---------------------------------------------------------------------------");

        System.out.print("Isi Array A setelah diubah: ");
        for (int i : arrayA) {
            System.out.print(i + " ");
        }

        System.out.println("\n---------------------------------------------------------------------------");

        // Array 2 Dimensi
        int[][] array2DSatu = new int[2][4];
        // byte[][] array2DDua = { { 4, 5, 6 }, { 7, 8, 9, 10 } };

        // Isi array 2Dimensi
        for (int i = 0; i < array2DSatu.length; i++) {
            for (int j = 0; j < array2DSatu[0].length; j++) {
                System.out.printf("Masukkan value untuk array2DSatu index [%d][%d]: ", i, j);
                array2DSatu[i][j] = io.nextInt();
            }
        }

        System.out.println("---------------------------------------------------------------------------");

        // Tampilkan isi array 2Dimensi
        System.out.println("Array2DDua: ");
        for (int i = 0; i < array2DSatu.length; i++) {
            for (int j = 0; j < array2DSatu[0].length; j++) {
                System.out.print(array2DSatu[i][j] + " ");
            }
            System.out.print("\n");
        }

        int[] arraySatu = { 1, 2, 3 };
        int[] arrayDua = new int[3];
        for (int i = 0; i < arrayDua.length; i++) {
            arrayDua[i] = arraySatu[(arraySatu.length - 1) - i];
        }
        arrayDua[0] = 10;
        System.out.println(Arrays.toString(arrayDua));
        System.out.println(Arrays.toString(arraySatu));
        Arrays.sort(arrayDua);
        System.out.println(Arrays.toString(arrayDua));
        io.close();

    }
}