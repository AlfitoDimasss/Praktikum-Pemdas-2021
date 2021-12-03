import java.util.Scanner;

/**
 * @author PietroManjiro
 */
public class SIAM {
    static final int MAX_MHS = 10;
    static final int MAX_SEM = 2;
    static final int MAX_MK = 2;

    static String[] siswa = new String[MAX_MHS];
    static String[] nim = new String[MAX_MHS];
    static String[] prodi = new String[MAX_MHS];
    static String[][][] matkul = new String[MAX_MHS][MAX_SEM][MAX_MK];
    static String[][][] kodeMatkul = new String[MAX_MHS][MAX_SEM][MAX_MK];
    static String[][][] nilai = new String[MAX_MHS][MAX_SEM][MAX_MK];
    static double[][][] nilaiAngka = new double[MAX_MHS][MAX_SEM][MAX_MK];
    static int[][][] sks = new int[MAX_MHS][MAX_SEM][MAX_MK];

    static final Scanner IO = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        header();
        menu();
        footer();
    }

    /**
     * Method menu untuk menampilkan menu aplikasi
     */
    static void menu() {
        boolean lanjut = true;
        do {
            System.out.println("Pilihan Menu:");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Input Data KRS");
            System.out.println("3. Edit Data KRS");
            System.out.println("4. Input Nilai Mata Kuliah");
            System.out.println("5. Edit Nilai Mata Kuliah");
            System.out.println("6. Cetak KRS");
            System.out.println("7. Cetak KHS");
            System.out.println("8. Keluar");
            System.out.println(
                    "-------------------------------------------------------------------------------");
            System.out.print("Input Menu\t: ");
            int a = IO.nextInt();
            IO.nextLine();
            switch (a) {
                case 1:
                    inputDataMahasiswa();
                    break;
                case 2:
                    inputKRS();
                    break;
                case 3:
                    editKRS();
                    break;
                case 4:
                    inputNilaiMatkul();
                    break;
                case 5:
                    editNilaiMatkul();
                    break;
                case 6:
                    cetakKRS();
                    break;
                case 7:
                    cetakKHS();
                    break;
                case 8:
                    lanjut = false;
                    break;
                default:
                    System.out.println("Input Tidak Valid");
            }
        } while (lanjut);
    }

    /**
     * Method untuk menginputkan data mahasiswa
     */
    static void inputDataMahasiswa() {
        System.out.println(
                "===============================================================================");
        System.out.println("                           INPUT DATA MAHASISWA");
        System.out.println(
                "-------------------------------------------------------------------------------");
        int index = cariIndexKosong();
        System.out.print("Input Nama\t: ");
        siswa[index] = IO.nextLine();
        System.out.print("Input NIM\t: ");
        nim[index] = IO.nextLine();
        System.out.print("Input Prodi\t: ");
        prodi[index] = IO.nextLine();
        System.out.println(
                "===============================================================================");
    }

    /**
     * Method untuk mencari index mahasiswa yang masih kosong
     * 
     * @return Index mahasiswa yang kosong
     */
    static int cariIndexKosong() {
        int index = -1;
        for (int i = 0; i < siswa.length; i++) {
            if (siswa[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Method untuk mencari index mahasiswa berdasarkan nim
     * 
     * @param nims NIM mahasiswa
     * @return Index mahasiswa sesuai parameter NIM
     */
    static int cariIndexMahasiswa(String nims) {
        int index = -1;
        for (int i = 0; i < nim.length; i++) {
            if (nims.equalsIgnoreCase(nim[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Method untuk mencari index mata kuliah
     * 
     * @param kodeMK Kode mata kuliah yang akan dicari
     * @param indexMhs Index mahasiswa yang memiliki kodeMK
     * @param sem Semester dimana kodeMK itu berada
     * @return Index Mata Kuliah sesuai parameter
     */
    static int cariIndexMatkul(String kodeMK, int indexMhs, int sem) {
        int index = -1;
        for (int i = 0; i < kodeMatkul[0][0].length; i++) {
            if (kodeMK.equalsIgnoreCase(kodeMatkul[indexMhs][sem][i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Method untuk melakukan input KRS Mahasiswa
     */
    static void inputKRS() {
        System.out.println(
                "===============================================================================");
        System.out.println("                                INPUT KRS");
        System.out.println(
                "-------------------------------------------------------------------------------");
        System.out.print("Masukkan NIM Mahasiswa\t: ");
        String nims = IO.nextLine();
        int index = cariIndexMahasiswa(nims);
        if (index >= 0) {
            System.out.print("Input Semester\t\t: ");
            String sem = IO.nextLine();
            int sems = 1;
            if (sem.equalsIgnoreCase("Ganjil")) {
                sems = 0;
            }
            for (int i = 0; i < matkul[0][0].length; i++) {
                System.out.print("Input Kode Matkul Ke-" + (i + 1) + "\t: ");
                kodeMatkul[index][sems][i] = IO.nextLine();
                System.out.print("Input Matkul Ke-" + (i + 1) + "\t: ");
                matkul[index][sems][i] = IO.nextLine();
                System.out.print("Input SKS Matkul Ke-" + (i + 1) + "\t: ");
                sks[index][sems][i] = IO.nextInt();
                IO.nextLine();
            }
        } else {
            System.out.println(
                    "Data Mahasiswa Tidak Ditemukan, Silahkan Input Data Mahasiswa Terlebih Dahulu");
        }
        System.out.println(
                "===============================================================================");
    }

    /**
     * Method untuk melakukan edit KRS Mahasiswa
     */
    static void editKRS() {
        System.out.println(
                "===============================================================================");
        System.out.println("                                EDIT KRS");
        System.out.println(
                "-------------------------------------------------------------------------------");
        System.out.print("Masukkan NIM Mahasiswa\t\t\t: ");
        String nims = IO.nextLine();
        int indexMhs = cariIndexMahasiswa(nims);
        if (indexMhs >= 0) {
            System.out.print("Input Semester\t\t\t\t: ");
            String sem = IO.nextLine();
            int sems = 1;
            if (sem.equalsIgnoreCase("Ganjil")) {
                sems = 0;
            }
            System.out.print("Masukkan Kode Matkul Yang Akan Diedit\t: ");
            String kode = IO.nextLine();
            int idxMatkul = cariIndexMatkul(kode, indexMhs, sems);
            if (idxMatkul >= 0) {
                System.out.print("Input Kode Matkul Baru\t\t\t: ");
                kodeMatkul[indexMhs][sems][idxMatkul] = IO.nextLine();
                System.out.print("Input Nama Matkul Baru\t\t\t: ");
                matkul[indexMhs][sems][idxMatkul] = IO.nextLine();
                System.out.print("Input SKS Matkul Baru\t\t\t: ");
                sks[indexMhs][sems][idxMatkul] = IO.nextInt();
                IO.nextLine();
            } else {
                System.out.println(
                        "Data Mata Kuliah Tidak Ditemukan, Silahkan Input KRS Terlebih Dahulu");
            }
        } else {
            System.out.println(
                    "Data Mahasiswa Tidak Ditemukan, Silahkan Input Data Mahasiswa Terlebih Dahulu");
        }
        System.out.println(
                "===============================================================================");
    }

    /**
     * Method untuk melakukan cetak KRS Mahasiswa
     */
    static void cetakKRS() {
        System.out.println(
                "===============================================================================");
        System.out.println("                                CETAK KRS");
        System.out.println(
                "-------------------------------------------------------------------------------");
        System.out.print("Masukkan NIM Mahasiswa\t: ");
        String nims = IO.nextLine();
        int indexMhs = cariIndexMahasiswa(nims);
        if (indexMhs >= 0) {
            System.out.print("Input Semester\t\t: ");
            String sem = IO.nextLine();
            int sems = 1;
            if (sem.equalsIgnoreCase("Ganjil")) {
                sems = 0;
            }
            if (matkul[indexMhs][sems][0] != null) {
                System.out.println(
                        "===============================================================================");
                System.out.println("Nama\t\t: " + siswa[indexMhs]);
                System.out.println("NIM\t\t: " + nim[indexMhs]);
                System.out.println("Program Studi\t: " + prodi[indexMhs]);
                System.out.println("Semster\t\t: " + sem);
                System.out.println(
                        "-------------------------------------------------------------------------------");
                System.out.printf("No %2c Kode Mata Kuliah %c Nama Mata Kuliah %25c SKS\n", ' ',
                        ' ', ' ');
                System.out.println(
                        "-------------------------------------------------------------------------------");
                for (int i = 0; i < matkul[0][0].length; i++) {
                    System.out.printf("%d %3c %s %11c %-40s %c %d\n", (i + 1), ' ',
                            kodeMatkul[indexMhs][sems][i], ' ', matkul[indexMhs][sems][i], ' ',
                            sks[indexMhs][sems][i]);
                }
                System.out.println(
                        "-------------------------------------------------------------------------------");
                System.out.printf("%5c Jumlas SKS %50c %d\n", ' ', ' ',
                        hitungTotalSks(indexMhs, sems));
            } else {
                System.out.println("KRS Belum Tersedia Untuk Semster Ini");
            }
        } else {
            System.out.println(
                    "Data Mahasiswa Tidak Ditemukan, Silahkan Input Data Mahasiswa Terlebih Dahulu");
        }
        System.out.println(
                "===============================================================================");
    }

    /**
     * Method untuk melakukan input Nilai Mata Kuliah Mahasiswa
     */
    static void inputNilaiMatkul() {
        System.out.println(
                "===============================================================================");
        System.out.println("                          INPUT NILAI MATA KULIAH");
        System.out.println(
                "-------------------------------------------------------------------------------");
        System.out.print("Masukkan NIM Mahasiswa\t: ");
        String nims = IO.nextLine();
        int indexMhs = cariIndexMahasiswa(nims);
        if (indexMhs >= 0) {
            System.out.print("Input Semester\t\t: ");
            String sem = IO.nextLine();
            int sems = 1;
            if (sem.equalsIgnoreCase("Ganjil")) {
                sems = 0;
            }
            if (matkul[indexMhs][sems][0] != null) {
                for (int i = 0; i < matkul[0][0].length; i++) {
                    System.out.printf("Masukkan Nilai Mata Kuliah %s: ", matkul[indexMhs][sems][i]);
                    double val = IO.nextDouble();
                    System.out.print("\n");
                    nilai[indexMhs][sems][i] = konversiNilai(val);
                    nilaiAngka[indexMhs][sems][i] = val;
                }
            } else {
                System.out.println("List Mata Kuliah Untuk Semster " + sem + " Belum Ada");
            }
        } else {
            System.out.println(
                    "Data Mahasiswa Tidak Ditemukan, Silahkan Input Data Mahasiswa Terlebih Dahulu");
        }
        System.out.println(
                "===============================================================================");
    }

    /**
     * Method untuk melakukan edit Nilai Mata Kuliah Mahasiswa
     */
    static void editNilaiMatkul() {
        System.out.println(
                "===============================================================================");
        System.out.println("                          EDIT NILAI MATA KULIAH");
        System.out.println(
                "-------------------------------------------------------------------------------");
        System.out.print("Masukkan NIM Mahasiswa\t: ");
        String nims = IO.nextLine();
        int indexMhs = cariIndexMahasiswa(nims);
        if (indexMhs >= 0) {
            System.out.print("Input Semester\t\t: ");
            String sem = IO.nextLine();
            int sems = 0;
            if (sem.equalsIgnoreCase("Ganjil")) {
                sems = 0;
            } else {
                sems = 1;
            }
            if (matkul[indexMhs][sems][0] != null) {
                System.out.print("Masukkan Kode Matkul Yang Akan Diedit: ");
                String kode = IO.nextLine();
                int idxMatkul = cariIndexMatkul(kode, indexMhs, sems);
                if (idxMatkul >= 0) {
                    System.out.printf("Masukkan Nilai Mata Kuliah %s Baru: ",
                            matkul[indexMhs][sems][idxMatkul]);
                    double val = IO.nextDouble();
                    matkul[indexMhs][sems][idxMatkul] = konversiNilai(val);
                } else {
                    System.out.println("Mata Kuliah Tidak Ditemukan");
                }
            } else {
                System.out.println("List Mata Kuliah Untuk Semester " + sem + " Masih Kosong");
            }

        } else {
            System.out.println(
                    "Data Mahasiswa Tidak Ditemukan, Silahkan Input Data Mahasiswa Terlebih Dahulu");
        }
        System.out.println(
                "===============================================================================");
    }

    /**
     * Method untuk melakukan cetak KHS Mahasiswa
     */
    static void cetakKHS() {
        System.out.println(
                "===============================================================================");
        System.out.println("                                CETAK KHS");
        System.out.println(
                "-------------------------------------------------------------------------------");
        System.out.print("Masukkan NIM Mahasiswa\t: ");
        String nims = IO.nextLine();
        int indexMhs = cariIndexMahasiswa(nims);
        if (indexMhs >= 0) {
            System.out.print("Input Semester\t\t: ");
            String sem = IO.nextLine();
            int sems = 1;
            if (sem.equalsIgnoreCase("Ganjil")) {
                sems = 0;
            }
            if (matkul[indexMhs][sems][0] != null) {
                System.out.println(
                        "===============================================================================");
                System.out.println("Nama\t\t: " + siswa[indexMhs]);
                System.out.println("NIM\t\t: " + nim[indexMhs]);
                System.out.println("Program Studi\t: " + prodi[indexMhs]);
                System.out.println("Semster\t\t: " + sem);
                System.out.println(
                        "-------------------------------------------------------------------------------");
                System.out.printf("No %2c Kode Mata Kuliah %c Nama Mata Kuliah %25c SKS %c Nilai\n",
                        ' ', ' ', ' ', ' ');
                System.out.println(
                        "-------------------------------------------------------------------------------");
                for (int i = 0; i < matkul[0][0].length; i++) {
                    System.out.printf("%d %3c %s %11c %-40s %c %d %3c %s\n", (i + 1), ' ',
                            kodeMatkul[indexMhs][sems][i], ' ', matkul[indexMhs][sems][i], ' ',
                            sks[indexMhs][sems][i], ' ', nilai[indexMhs][sems][i]);
                }
                System.out.println(
                        "-------------------------------------------------------------------------------");
                System.out.printf("%5c Jumlas SKS %50c %d\n", ' ', ' ',
                        hitungTotalSks(indexMhs, sems));
                System.out.println(
                        "-------------------------------------------------------------------------------");
                System.out.printf("IP Semester\t: %.2f\n", hitungIP(indexMhs, sems));
                System.out.println(
                        "Beban Studi\t: maksimum " + hitungMaksSks(indexMhs, sems) + " sks");
            } else {
                System.out.println("KHS Untuk Semester " + sem + " Belum Tersedia");
            }
        } else {
            System.out.println(
                    "Data Mahasiswa Tidak Ditemukan, Silahkan Input Data Mahasiswa Terlebih Dahulu");
        }
        System.out.println(
                "===============================================================================");

    }

    /**
     * Method untuk mengkonversi nilai angka menjadi huruf
     * 
     * @param val Nilai Angka mahasiswa
     * @return Nilai huruf mahasiswa
     */
    static String konversiNilai(double val) {
        String nilai = "";
        if (val >= 3.5) {
            nilai += "A";
        } else if (val > 2.99) {
            nilai += "B+";
        } else if (val > 2.49) {
            nilai += "B";
        } else if (val > 1.99) {
            nilai += "C";
        } else if (val > 1.49) {
            nilai += "D";
        } else {
            nilai += "E";
        }
        return nilai;
    }

    /**
     * Method untuk menghitung total sks yang diambil mahasiswa
     * 
     * @param idxMhs Index mahasiswa yang akan dihitung sksnya
     * @param sem Semester mahasiswa yang akan dihitung sksnya
     * @return Jumlah sks yang diambil mahasiswa
     */
    static int hitungTotalSks(int idxMhs, int sem) {
        int totalSks = 0;
        for (int i = 0; i < matkul[0][0].length; i++) {
            totalSks += sks[idxMhs][sem][i];
        }
        return totalSks;
    }

    /**
     * Method untuk menghitung total IP yang diperoleh mahasiswa
     * 
     * @param idxMhs Index mahasiswa yang akan dihitung total IPnya
     * @param sem Semester mahasiswa yang akan dihitung total IPnya
     * @return Total IP yang diperoleh mahasiswa
     */
    static double hitungIP(int idxMhs, int sem) {
        double totalIp = 0;
        int totalSks = hitungTotalSks(idxMhs, sem);
        for (int i = 0; i < matkul[0][0].length; i++) {
            totalIp += (nilaiAngka[idxMhs][sem][i] * sks[idxMhs][sem][i]);
        }
        totalIp /= totalSks;
        return totalIp;
    }

    /**
     * Method untuk menghitung jumlah sks yang dapat diambil mahasiswa di semester selanjutnya
     * 
     * @param idxMhs Index mahasiswa yang akan dihitung jumlah maks SKSnya
     * @param sem Semester mahasiswa yang akan dihitung jumlah maks SKSnya
     * @return Jumlah maks SKS yang dapat diambil mahasiswa
     */
    static int hitungMaksSks(int idxMhs, int sem) {
        int maksSks = 0;
        double ip = hitungIP(idxMhs, sem);
        if (ip > 2.99) {
            maksSks = 24;
        } else if (ip > 2.49) {
            maksSks = 21;
        } else if (ip > 1.99) {
            maksSks = 18;
        } else if (ip > 1.49) {
            maksSks = 15;
        } else {
            maksSks = 12;
        }
        return maksSks;
    }

    /**
     * Method untuk menampilkan header
     */
    static void header() {
        System.out.println(
                "===============================================================================");
        System.out.println("                    APLIKASI KRS/KHS MAHASISWA FILKOM UB");
        System.out.println(
                "===============================================================================");
    }

    /** Method untuk menampilkan footer */
    static void footer() {
        System.out.println(
                "===============================================================================");
        System.out.println("                 TERIMA KASIH SUDAH MENGGUNAKAN APLIKASI INI");
        System.out.println("                   Copyright © 2021 Praktikum Pemdas SI-B");
        System.out.println(
                "===============================================================================");
    }
}
