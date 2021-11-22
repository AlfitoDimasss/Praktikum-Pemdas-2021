import java.util.Scanner;

public class Pertemuan2 {
    public static void main(String[] args) {

        /** ===== TIPE DATA PADA JAVA ===== */
        int a = 9; // Integer untuk menyimpan nilai bilangan bulat
        double b = 5.5; // Double untuk menyimpan nilai bilangan desimal
        float f = 5.7f; // Float untuk menyimpan nilai bilangan desimal
        char c = '9'; // Char untuk menyimpan nilai karakter
        boolean g = true; // Boolean untuk menyimpan nilai kebenaran
        String s = "Hallo dunia"; // String untuk menyimpan kumpulan nilai char
        byte x = 8; // Byte untuk menyimpan nilai bilangan bulat
        short y = 10; // Short untuk menyimpan nilai bilangan bulat
        long i = 7; // Long untuk menyimpan nilai bilangan bulat

        // Keyword Final untuk nilai data yang bersifat tetap
        final double PHI = 3.14;

        /**
         * Untuk pendeklarasian beberapa variabel yang memiliki tipe data sama dapat
         * dilakukan seperti ini
         */
        int angka1, angka2, angka3;
        String str1, str2, str3;

        /**
         * Untuk penamaan variabel disarankan menggunakan lowercase untuk satu kata dan
         * CamelCase apabila lebih dari satu kata. Tidak disarankan menggunakan karakter
         * seperti simbol karena akan aneh dilihatnya. Kalian juga dapat menambahkan
         * angka untuk penamaan variabel dengan ketentuan angka tidak berada di awal.
         */

        /** ===== Operasi Aritmatika ===== */
        // Pertambahan
        angka1 = 9 + 4;
        System.out.println(angka1);

        // Pengurangan
        angka2 = 10 - 5;
        System.out.println(angka2);

        // Perkalian
        angka3 = angka1 * angka2;
        System.out.println(angka1 + " * " + angka2 + " = " + angka3);

        // Pembagian
        int angka4 = angka3 / angka2;

        // Pangkat
        double desimal1 = Math.pow(angka4, 2); // Ket. Parameter = (Angka yang ingin dipangkatkan, pangkat berapanya)

        // Akar 2
        desimal1 = Math.sqrt(desimal1);

        // Akar 3
        double desimal2 = Math.cbrt(27);

        // Modulo (Sisa Bagi)
        angka1 = 4 % 2;
        angka1 = 4 % 3;

        /**
         * Operasi aritmatika ini dapat diterapkan pada tipe data bilangan lainnya tidak
         * hanya untuk Integer, tinggal disesuaikan saja konteksnya
         */

        /** ===== OUTPUT ===== */

        // println() = Menampilkan output dengan memberikan new line disetiap akhir
        // kalimatnya
        System.out.println("Hello World");
        System.out.println("Saya belajar Java");

        // print() = Menampilkan output tanpa memberikan new line disetiap akhir
        // kalimatnya
        System.out.print("Hello World");
        System.out.print("Saya belajar Java");

        // printf() = Menampilkan output dengan formatting
        // %s digunakan untuk String
        // %f digunakan untuk double dan float
        // %d digunakan untuk integer
        // %c digunakan untuk char
        System.out.printf("Nama %7c Kelas %4c Nilai\n", '|', '|');
        System.out.println("--------------------------------");
        System.out.printf("Farrel %5c SI-B %5c %.1f\n", '|', '|', 88.5);
        System.out.printf("%s %5c SI-E %5c %d\n", "Alfito", '|', '|', 86);
        String nama1 = "Agus";
        String kelas1 = "SI-C";
        double desimal3 = 87.5;
        char karakter1 = '|';
        System.out.printf("%s %7c %s %5c %.1f\n", nama1, karakter1, kelas1, karakter1, desimal3);

        /** ===== ESCAPE SEQUENCE ===== */
        System.out.println("Hello\tWorld"); // \t untuk Tab
        System.out.println("Hello\nWorld"); // \n untuk New Line
        System.out.println("\"Hello World\""); // \" untuk memberi kutip
        System.out.println("\\Hello World\\"); // \\ untuk memberi backslash

        /** ===== USER INPUT ===== */

        /**
         * Untuk meminta input dari user kalian perlu mengimport library Scanner Java.
         * Sintaks import: import java.util.Scanner;
         */

        // Instantiasi Objek Scanner
        Scanner io = new Scanner(System.in); // io merupakan nama objek dari Scanner, dapat denan bebas diganti namanya

        // Meminta inputan data String
        str1 = io.next(); // Hanya satu kata yang akan diambil
        str2 = io.nextLine(); // Dapat meminta satu kalimat penuh
        angka1 = io.nextInt(); // Untuk meminta inputan bertipe Integer
        desimal1 = io.nextDouble(); // Untuk meminta inputan bertipe Double
        f = io.nextFloat(); // Untuk meminta inputan bertipe float
        i = io.nextLong(); // Untuk meminta inputan bertipe long
        y = io.nextShort(); // Untuk meminta inputan bertipe short
        x = io.nextByte(); // Untuk meminta inputan bertipe byte

        /** ===== PROGRAM INPUT OUTPUT SEDERHANA ===== */
        System.out.print("Masukkan Nama\t\t: ");
        String nama = io.nextLine();
        System.out.print("Masukkan NIM\t\t: ");
        String NIM = io.nextLine();
        System.out.print("Masukkan Jurusan\t: ");
        String jurusan = io.nextLine();
        System.out.print("Masukkan Angkatan\t: ");
        int angkatan = io.nextInt();
        io.nextLine();
        System.out.print("Masukkan Fakultas\t: ");
        String fakultas = io.nextLine();

        System.out.println("Halo! Nama saya " + nama + " dengan NIM " + NIM + " dari jurusan " + jurusan + " angkatan "
                + angkatan + " fakultas " + fakultas + ".");

        io.close();

    }
}