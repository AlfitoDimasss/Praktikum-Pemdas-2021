public class Pertemuan4 {
    public static void main(String[] args) throws Exception {

        // ===== PERCABANGAN =====
        /**
         * Percabangan digunakan apabila terdapat kode program yang ingin dijalankan
         * membutuhkan suatu kondisi tertentu yang harus terpenuhi. Terdapat 3 jenis
         * percabangan yang ada di Java yaitu ternary operator, if-else statement, dan
         * switch case.
         */

        // // ===== TERNARY OPERATOR =====
        // int a = 10;
        // int b = 8;
        // int z = (a < b) ? 12 : 5;
        // System.out.println(z);
        // String x = "fito";
        // String y = (x.equalsIgnoreCase("fito")) ? "dimas" : "prasetyo";
        // System.out.println(y);

        // // ===== IF STATEMENT =====
        // // If-Else Statement
        // int c = 7;
        // if (c % 2 == 0) {
        // System.out.println(c + " adalah bilangan genap");
        // } else {
        // System.out.println(c + " adalah bilangan ganjil");
        // }

        // // If - Else If - Else Statement
        // if (c > 5 && c % 2 == 0) {
        // System.out.println(c + " lebih besar dari 5 dan merupakan bilangan genap");
        // } else if (c < 0) {
        // System.out.println(c + " kurang dari 0 dan merupakan angka negatif");
        // } else {
        // System.out.println(c + " lebih besar dari 0");
        // }

        // // Nested If Statement
        // String penilaian = "UTS";
        // int nilai = 80;
        // if (penilaian.equalsIgnoreCase("UTS")) {
        // if (nilai > 75) {
        // System.out.println("Selamat kamu lulus UTS gan!");
        // } else {
        // System.out.println("Mohon maaf kamu belum lulus UTS");
        // }
        // } else if (penilaian.equalsIgnoreCase("UAS")) {
        // if (nilai > 88) {
        // System.out.println("Selamat kamu lulus UAS gan!");
        // } else {
        // System.out.println("Mohon maaf kamu belum lulus UAS");
        // }
        // }

        // int x = 160;
        // if (x == 100) {
        // System.out.println("Jackpot, nilaimu 100");
        // }
        // if (x % 2 == 0) {
        // System.out.println("Angkamu bernilai genap");
        // } else {
        // System.out.println("Angkamu bernilai ganjil");
        // }

        // ===== SWITCH CASE =====
        String nama = "ALFITO";
        switch (nama.charAt(0)) {
        case 'A':
        case 'I':
        case 'E':
            System.out.println("Namamu berawalan huruf vokal");
            break;
        case 'C':
            System.out.println("Wah namamu berawalan huruf C, gokilll");
            break;
        default:
            System.out.println("Namamu tidak berawalan huruf vokal tapi keren");
        }
    }
}