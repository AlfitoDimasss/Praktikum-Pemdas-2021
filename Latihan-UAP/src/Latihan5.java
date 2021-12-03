import java.util.Scanner;

public class Latihan5 {
    public static void main(String[] args) {

        // Inisialisasi dan Instantiasi
        Scanner io = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int x = io.nextInt();
        String[] namaMahasiswa = new String[x];
        int[] nilaiQuiz = new int[x];
        int[] nilaiUTS = new int[x];
        int[] nilaiUAS = new int[x];
        double rataRataQuiz = 0.00;
        double rataRataUTS = 0.00;
        double rataRataUAS = 0.00;

        /*
         * Input data mahasiswa Nilai mahasiswa terdiri dari tiga nilai Silahkan input
         * ketiganya contoh: 80 90 85
         */
        for (int i = 0; i < x; i++) {
            System.out.print("Masukkan nama dan nilai mahasiswa ke " + (i + 1) + ": ");
            namaMahasiswa[i] = io.next();
            nilaiQuiz[i] = io.nextInt();
            nilaiUTS[i] = io.nextInt();
            nilaiUAS[i] = io.nextInt();
        }

        // Hitung nilai rata-rata
        rataRataQuiz += rataRata(nilaiQuiz);
        rataRataUTS += rataRata(nilaiUTS);
        rataRataUAS += rataRata(nilaiUAS);

        // Output nilai rata-rata
        System.out.println("");
        System.out.printf("Rata Rata Nilai Quiz : %.2f\n", rataRataQuiz);
        System.out.printf("Rata Rata Nilai UTS  : %.2f\n", rataRataUTS);
        System.out.printf("Rata Rata Nilai UAS  : %.2f\n", rataRataUAS);

        // Output nilai akhir mahasiswa
        System.out.printf("\n------------Nilai Mahasiswa------------\n");
        for (int i = 0; i < x; i++) {
            double nilaiEnd = nilaiAkhir(nilaiQuiz[i], nilaiUTS[i], nilaiUAS[i]);
            System.out.printf("%-10s %.2f (%c)\n", namaMahasiswa[i], nilaiEnd, labelNilaiAkhir(nilaiEnd));
        }
        io.close();
    }

    // Method menghitung nilai rata-rata
    public static double rataRata(int[] nilai) {
        double nilaiRata = 0.00;
        for (int i = 0; i < nilai.length; i++) {
            nilaiRata += nilai[i];
        }
        nilaiRata /= nilai.length;
        return nilaiRata;
    }

    // Method menghitung nilai akhir setiap mahasiswa
    public static double nilaiAkhir(int quiz, int uts, int uas) {
        double nilaiAkhir;
        nilaiAkhir = (quiz * 0.25) + (uts * 0.35) + (uas * 0.4);
        return nilaiAkhir;
    }

    // Method konversi nilai akhir mahasiswa ke dalam bentuk huruf
    public static char labelNilaiAkhir(double nilai) {
        char labelNilaiAkhir;
        if (nilai > 79) {
            labelNilaiAkhir = 'A';
        } else if (nilai >= 70 && nilai <= 79) {
            labelNilaiAkhir = 'B';
        } else if (nilai >= 60 && nilai <= 69) {
            labelNilaiAkhir = 'C';
        } else if (nilai >= 50 && nilai <= 59) {
            labelNilaiAkhir = 'D';
        } else {
            labelNilaiAkhir = 'E';
        }
        return labelNilaiAkhir;
    }
}
