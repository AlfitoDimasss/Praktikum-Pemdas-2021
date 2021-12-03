import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {

        /*
         * Program penjumlahan setiap digit angka yang diinputkan hingga menjadi satu
         * digit saja. Contoh: 567 = 9, didapat dari 5+6+7 = 18, lalu 1+8 = 9.
         */
        Scanner io = new Scanner(System.in);

        // Input
        System.out.print("Silahkan input sederet angka tanpa spasi: ");
        long input = io.nextLong();

        // Proses jumlah tiap digit angka
        long jumlah = jumlahAngka(input);

        // Output
        System.out.println(jumlah);
        io.close();
    }

    // Method untuk menjumlahkan setiap digit angka
    public static long jumlahAngka(long i) {
        long input = i;
        long jumlah = 0;
        String angka = "";
        String angkaSekarang = "" + input; // Input 1
        if (angkaSekarang.length() == 1) {
            return input;
        }
        while (true) {
            if (input == 0) {
                input = jumlah; // input = 1
                jumlah = 0;
                angka = "";
            }
            while (input != 0) { // misal input 10 -> 1
                jumlah = jumlah + (input % 10); // jumlah sementara 0 -> 1 -> 1
                input /= 10; // input 1 -> 0 -> 0
                angka += jumlah; // "0" -> "01" -> "1"
            }
            if (angka.length() == 1) {
                break;
            }
        }
        return jumlah;
    }
}