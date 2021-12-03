import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {

        /*
         * Program untuk mengurutkan harga mainan dari yang terendah ke yang tertinggi
         * dan nantinya akan mencetak selisih harga mainan termurah pertama dan kedua
         */

        // Input
        Scanner io = new Scanner(System.in);
        System.out.print("Masukkan jumlah mainan yang ada\t\t: ");
        int x = io.nextInt();
        int[] hargaMainan = new int[x];
        for (int i = 0; i < hargaMainan.length; i++) {
            System.out.print("Masukkan harga mainan ke-" + (i + 1) + "\t\t: ");
            hargaMainan[i] = io.nextInt();
        }

        // Cara 1: Cari harga termurah dua kali pakai loop
        int mainanMurah1 = cariHargaMurahSatu(hargaMainan);
        int mainanMurah2 = cariHargaMurahDua(mainanMurah1, hargaMainan);
        int selisihMainan = mainanMurah2 - mainanMurah1;
        System.out.println("Selisih harga mainan pertama dan kedua\t: Rp" + selisihMainan);

        // Cara 2: Di sorting dulu
        // Sortir harga mainan
        hargaMainan = bubbleSort(hargaMainan);

        // Hitung selisih harga mainan termurah pertama dan kedua
        int selisihHarga = hargaMainan[1] - hargaMainan[0];

        // Output
        System.out.println("Selisih harga mainan pertama dan kedua\t: Rp" + selisihHarga);
        io.close();
    }

    // Method untuk mensortir angka dari yang terkecil ke yang terbesar
    public static int[] bubbleSort(int[] array) {
        int[] hasilUrut = array;
        for (int i = 0; i < hasilUrut.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < hasilUrut.length - i - 1; j++) {
                if (hasilUrut[j] > hasilUrut[j + 1]) {
                    int temp = hasilUrut[j];
                    hasilUrut[j] = hasilUrut[j + 1];
                    hasilUrut[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped = false) {
                break;
            }
        }
        return hasilUrut;
    }

    static int cariHargaMurahSatu(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int cariHargaMurahDua(int min, int[] arr) {
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min && arr[i] < min2) {
                min2 = arr[i];
            }
        }
        return min2;
    }

}