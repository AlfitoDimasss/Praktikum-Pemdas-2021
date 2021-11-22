import java.util.Scanner;

public class Master {
    /**
     * Ini adalah objek dan variabel yang bersifat global. Perlu ditambahkan keyword
     * static agar dapat diakses oleh semua method. Dengan sifatnya yang global,
     * tidak perlu memasukkan variabel tersebut ke dalam parameter method supaya
     * method tersebut dapat mengakses variabel tsb. Berbeda dengan yang bersifat
     * lokal, maka apabila kita ingin membuat method yang dapat mengakses sebuah
     * variabel yang bersifat lokal, maka perlu membuat parameter yang digunakan
     * untuk menampung referensi nilai atau alamat dari variabel yang akan
     * digunakan.
     */
    final static Scanner IO = new Scanner(System.in);
    static int[] arrayA = { 1, 2, 3 };

    public static void main(String[] args) {
        /**
         * Kita dapat memanggil secara langsung method yang bertipe void. Kita tidak
         * dapat memanggil method bertipe void di dalam println()
         */
        tampilkanHalo();

        /**
         * Untuk memanggil method non-void perlu disimpan terlebih dahulu ke dalam
         * variabel penampung, dan barulah lakukan sesuatu terhadap variabel tersebut.
         * Atau jika ingin ditampilkan kita dapat memanggil langsung di dalam println()
         */
        int tampung = getNilaiLima();
        System.out.println("Nilai " + tampung + " ini diambil dari method namun ditampung terlebih dahulu ke variabel");
        System.out.println(
                "Nilai " + getNilaiLima() + " ini diambil dari method tanpa ditampung terlebih dahulu ke variabel");

        /**
         * Jika memanggil method dengan parameter, pastikan parameter terisi semua dan
         * sesuai dengan urutan dan tipe data parameter. Jika tidak, maka akan error.
         * Isi parameter bisa berbentuk nilai langsung atau berbentuk variabel.
         */
        int umur = 19; // Ini contoh dari variabel lokal
        tampilkanNamaDanUmur("Alfito", umur);

        /**
         * Method overload akan dipanggil dan dipilih secara otomatis oleh java,
         * menyesuaikan dengan parameter method yang diinputkan
         */
        double tampung1 = tambahkanDuaAngka(10, 20.5);
        System.out.println("Nilai " + tampung1 + " ini didapat dari method tambahkanDuaAngka dengan dua parameter");
        double tampung2 = tambahkanDuaAngka(10.7);
        System.out.println("Nilai " + tampung2
                + " ini didapat dari method tambahkanDuaAngka dengan satu parameter bertipe double");
        double tampung3 = tambahkanDuaAngka(5);
        System.out.println(
                "Nilai " + tampung3 + " ini didapat dari method tambahkanDuaAngka dengan satu parameter bertipe int");

        /**
         * Contoh apabila kita ingin mencari index arrayA yang menyimpan nilai 2
         */
        int index = cariIndexArray(2);
        for (int i : arrayA) {
            System.out.print(i + " ");
        }
        System.out.println("Index yang menampung nilai 2 adalah index ke-" + index);

        int[] arrayB = { 5, 4, 6 };
        /**
         * Method cari index diatas dipanggil menggunakan variabel arrayA yang bersifat
         * global, jika kita ingin menggunakan variabel lokal maka perlu memasukkan
         * array yang akan kita cari kedalam parameter method cariIndexArray
         */
        int index1 = cariIndexArray(arrayB, 4);
        for (int i : arrayB) {
            System.out.print(i + " ");
        }
        System.out.println("Index yang menampung nilai 4 adalah index ke-" + index1);
    }

    /**
     * Method void digunakan untuk melakukan sesuatu seperti menampilkan sesuatu
     * atau melakukan suatu operasi namun tanpa melakukan return nilai
     */
    static void tampilkanHalo() {
        System.out.println("Masukkan Nama: ");
        String nama = IO.nextLine();
        System.out.println("Halo " + nama);
    }

    /**
     * Method non-void digunakan untuk mengembalikan sebuah nilai dimana nilai
     * tersebut dapat kita definisikan atau dapat dilakukan melalui sebuah proses
     * terlebih dahulu. Tipe non-void bisa berubah sesuai tipe data yang ada pada
     * Java, yang penting ialah nilai yang direturn tipe datanya sesuai dengan tipe
     * data method non-void tsb dan nilai (variabel) yang dapat direturn hanya boleh
     * satu.
     * 
     * @return angka 5
     */
    static int getNilaiLima() {
        return 5;
    }

    /**
     * Method dapat memiliki parameter yang digunakan sebagai referensi apabila akan
     * dilakukan sebuah proses dan supaya method tersebut dapat berjalan secara
     * fleksibel menyesuaikan nilai yang dimasukkan pada parameternya. Jumlah
     * parameter pada method tidak terbatas.
     * 
     * @param nama Nama orang yang akan ditampilkan
     * @param umur Umur orang yang akan ditampilkan
     */
    static void tampilkanNamaDanUmur(String nama, int umur) {
        System.out.println("Halo nama saya " + nama + ", umur saya " + umur + " tahun");
    }

    /**
     * Kita dapat menampung terlebih dahulu sebuah nilai yang akan direturn kedalam
     * sebuah variabel, baru nantinya variabel tersebut yang akan kita return
     * 
     * @param angka1
     * @param angka2
     * @return
     */
    static double tambahkanDuaAngka(int angka1, double angka2) {
        double hasil = angka2 + angka1;
        return hasil;
    }

    /**
     * Ini adalah contoh method overload dari method diatas, dimana method ini
     * mempunyai nama yang sama namun tidak error karena memiliki jumlah parameter
     * yang berbeda. Kita juga dapat membuat overload sebuah method dengan parameter
     * yang sama namun dengan tipe data parameter yang berbeda atau urutan parameter
     * yang berbeda.
     * 
     * @param angka
     * @return
     */
    static double tambahkanDuaAngka(double angka) {
        return angka + 5.5;
    }

    static double tambahkanDuaAngka(int angka) {
        return 2.5 * angka;
    }

    /**
     * Ini merupakan contoh method untuk mencari sebuah index yang memiliki value
     * sama dengan key yang kita inputkan. Apabila dalam array tersebut terdapat
     * nilai yang sama dengan key, maka akan mereturn index array yang menyimpan
     * nilai tersebut. Apabila tidak ada yang sama maka akan mereturn nilai -1;
     * 
     * @param key Nilai yang ingin kita cari di array
     * @return index array yang menyimpan nilai yang sama dengan key
     */
    static int cariIndexArray(int key) {
        int index = -1;
        for (int i = 0; i < arrayA.length; i++) {
            if (key == i) {
                index = i;
                break;
            }
        }
        return index;
    }

    static int cariIndexArray(int[] array, int key) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (key == i) {
                index = i;
                break;
            }
        }
        return index;
    }
}