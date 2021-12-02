import java.util.Scanner;

public class Pertemuan13c {
    public static void main(String[] args) {
        int[] deret = input();
        int ganjil = countOdd(deret);
        int genap = countEven(deret);
        int[] hasilGanjil = floorMeanMinMax(deret, true);
        int[] hasilGenap = floorMeanMinMax(deret, false);
        System.out.printf("Banyak angka ganjil %6c %d\n", '=', ganjil);
        System.out.printf("Rata-rata ganjil %9c %d\n", '=', hasilGanjil[0] / ganjil);
        System.out.printf("Minimum ganjil %11c %d\n", '=', hasilGanjil[1]);
        System.out.printf("Maksimum ganjil %10c %d\n", '=', hasilGanjil[2]);
        System.out.println(" ");
        System.out.printf("Banyak angka genap %7c %d\n", '=', genap);
        System.out.printf("Rata-rata genap %10c %d\n", '=', hasilGenap[0] / genap);
        System.out.printf("Minimum genap %12c %d\n", '=', hasilGenap[1]);
        System.out.printf("Maksimum genap %11c %d\n", '=', hasilGenap[2]);
    }

    public static int[] input() {
        Scanner in = new Scanner(System.in);
        int input = 0;
        int[] array = new int[0];
        while (input >= 0) {
            input = in.nextInt();
            if (input <= -1)
                break;
            int[] arr1 = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                arr1[i] = array[i];
            }
            arr1[array.length] = input;
            array = arr1;
        }
        in.close();
        return array;
    }

    public static int countOdd(int[] array) {
        int ganjil = 0;
        for (int angka : array) {
            if (angka % 2 == 1) {
                ganjil++;
            }
        }
        return ganjil;
    }

    public static int countEven(int[] array) {
        int genap = 0;
        for (int angka : array) {
            if (angka % 2 == 0) {
                genap++;
            }
        }
        return genap;
    }

    public static int[] floorMeanMinMax(int[] array, boolean isOdd) {
        int cek = isOdd ? 1 : 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int angka : array) {
            if (angka % 2 == cek) {
                total += angka;
                if (angka < min) {
                    min = angka;
                }
                if (angka > max) {
                    max = angka;
                }
            }
        }
        int arr[] = { total, min, max };
        return arr;
    }
}