import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {

        /*
         * Ini adalah program mengurutkan hasil jumlah angka dari yang terkecil ke yang
         * terbesar. Misal antara 2 dan 10 akan menghasilkan urutan 10, 2karena 10 =
         * 1+0 = 1, sedangkan 2 = 2
         */

        // Input
        Scanner io = new Scanner(System.in);
        String hasil = "";
        System.out.println("Masukkan sederetan angka dan dipisah dengan spasi");
        String input = io.nextLine();

        // Split string untuk memisahkan spasinya dan akan diubah menjadi array
        String[] pisah = input.split(" "); // 10 20 30 -> {10 , 20, 30}
        int[] arrayA = new int[pisah.length]; // -> {10 , 20, 30}

        // Input nilai array dari hasil split string ke array baru
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = Integer.parseInt(pisah[i]);
        }

        // Sort array
        arrayA = bubbleSort(arrayA);

        // Output
        for (int urut : arrayA) {
            hasil += (urut + " ");
        }

        System.out.println("Hasil urut: " + hasil);
        io.close();
    }

    public static int[] bubbleSort(int[] array) {
        int[] hasilUrut = array;
        for (int i = 0; i < hasilUrut.length; i++) {
            for (int j = 0; j < hasilUrut.length - 1; j++) {
                if (jumlahAngka(hasilUrut[j]) > jumlahAngka(hasilUrut[j + 1])) {
                    int temp = hasilUrut[j];
                    hasilUrut[j] = hasilUrut[j + 1];
                    hasilUrut[j + 1] = temp;
                }
            }
        }
        return hasilUrut;
    }

    public static int jumlahAngka(int input) {
        int jumlah = 0; // Misal input 789
        while (input != 0) {
            jumlah += (input % 10); // 0+9 = 9 -> 9 + 8 = 17 -> 17 + 7 = 24
            input /= 10; // 78 -> 7 -> 0
        }
        return jumlah;
    }

}
