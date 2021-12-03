import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/**
 *
 * @author Illuminare
 */
public class UbJek {

    static final Scanner IO = new Scanner(System.in);
    static String[] pengemudi = new String[10];
    static double[] xPengemudi = new double[10];
    static double[] yPengemudi = new double[10];
    static double[] jarakPengemudi = new double[10];
    static double[][][] koordinatRute;
    static char[][] hurufRute;
    static String[] dataPenumpang;

    static int nPengemudi = 0;
    static int rute = 0;

    public static void main(String[] args) {
        header();
        dataPenumpang = isiDataPenumpang();
        System.out.println("---------------------------------------------------------------------------");
        isiDataPengemudi();
        isiRute();
        tampilkanHasil();
        tampilkanRute();
        footer();
    }

    /**
     * Method menampilkan header Program
     */
    static void header() {
        System.out.println("===========================================================================");
        System.out.println("                            PROGRAM UB-JEK FINAL");
        System.out.println("===========================================================================");
    }

    /**
     * Method menampilkan footer program
     */
    static void footer() {
        System.out.println("===========================================================================");
        System.out.println("                    Copyright Praktikum Pemdas SI-B 2021");
        System.out.println("===========================================================================");
    }

    /**
     * Method untuk mengisi data penumpang
     * 
     * @return Array berisi data penumpang
     */
    static String[] isiDataPenumpang() {
        String[] data = new String[5];
        System.out.print("Masukkan Nama Penumpang\t\t\t\t\t: ");
        data[0] = IO.nextLine();
        System.out.print("Masukkan Titik Koordinat x <spasi> y Penumpang\t\t: ");
        data[1] = IO.next();
        data[2] = IO.next();
        System.out.print("Masukkan Titik Koordinat x <spasi> y Tujuan Penumpang\t: ");
        data[3] = IO.next();
        data[4] = IO.next();
        return data;
    }

    /**
     * Method untuk isi data pengemudi
     */
    static void isiDataPengemudi() {
        System.out.print("Masukkan Banyak Pengemudi yang Tersedia\t\t\t: ");
        nPengemudi = IO.nextInt();
        IO.nextLine();
        for (int i = 0; i < nPengemudi; i++) {
            System.out.print("Masukkan Nama Pengemudi Ke-" + (i + 1) + "\t\t\t\t: ");
            pengemudi[i] = IO.nextLine();
            System.out.print("Masukkan Koordinat x <spasi> y Pengemudi Pengemudi Ke-" + (i + 1) + "\t: ");
            xPengemudi[i] = IO.nextDouble();
            yPengemudi[i] = IO.nextDouble();
            IO.nextLine();
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    /**
     * Method untuk mengisi rute yang ada
     */
    static void isiRute() {
        int nRute;
        System.out.print("Masukkan Banyak Rute yang Tersedia\t\t\t: ");
        nRute = IO.nextInt();

        koordinatRute = new double[nRute][4][2];
        hurufRute = new char[nRute][4];
        for (int i = 0; i < koordinatRute.length; i++) {
            koordinatRute[i][0][0] = 0;
            koordinatRute[i][0][1] = 0;
            koordinatRute[i][3][0] = Double.parseDouble(dataPenumpang[3]);
            koordinatRute[i][3][1] = Double.parseDouble(dataPenumpang[4]);
        }

        for (int i = 0; i < hurufRute.length; i++) {
            hurufRute[i][0] = 'P';
            hurufRute[i][3] = 'X';
        }
        int ascii = 65;
        for (int i = 0; i < koordinatRute.length; i++) {
            for (int j = 1; j < koordinatRute[0].length - 1; j++) {
                System.out.printf("Masukkan Koordinat x <spasi> y Rute %d Titik %d\t\t: ", (i + 1), j);
                double x = IO.nextDouble();
                double y = IO.nextDouble();
                koordinatRute[i][j][0] = x;
                koordinatRute[i][j][1] = y;
                hurufRute[i][j] = (char) ascii;
                ascii++;
            }
        }
    }

    /**
     * Method untuk menghitung jarak antar titik
     * 
     * @param x1 Titik kordinat x1
     * @param y1 Titik kordinat y1
     * @param x2 Titik kordinat x2
     * @param y2 Titik kordinat y2
     * @return Jarak antara dua titik
     */
    public static double hitungJarak(double x1, double y1, double x2, double y2) {
        return (Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2))));
    }

    /**
     * Method untuk mendapatkan index array jarakPengemudi dengan jarak terdekat
     * 
     * @return Index pengemudi dengan jarak terdekat
     */
    public static int getIndexJarakTerkecil() {
        double min = Double.MAX_VALUE;
        int index = 0;
        double xPenumpang = Double.parseDouble(dataPenumpang[1]);
        double yPenumpang = Double.parseDouble(dataPenumpang[2]);
        for (int i = 0; i < nPengemudi; i++) {
            jarakPengemudi[i] = hitungJarak(xPenumpang, yPenumpang, xPengemudi[i], yPengemudi[i]);
            if (jarakPengemudi[i] < min) {
                index = i;
                min = jarakPengemudi[i];
            }
        }
        return index;
    }

    /**
     * Method untuk mendapatkan nilai jarak terdekat dari array jarakPengemudi
     * 
     * @param index Index yang akan digunakan untuk mencari nilai jarak
     * @return Nilai jarak pengemudi terdekat
     */
    public static double getJarakPengemudiTerdekat(int index) {
        return jarakPengemudi[index];
    }

    /**
     * Method untuk menghitung rute yang akan ditempuh
     * 
     * @return Rute yang akan ditempuh
     */
    static String hitungRute() {
        String hasilRute = "P - ";
        double min = Double.MAX_VALUE;
        char temp = ' ';
        double tempX = 0;
        double tempY = 0;
        double x = 0;
        double y = 0;
        for (int j = 1; j < koordinatRute[0].length; j++) {
            for (int k = 0; k < koordinatRute.length; k++) {
                double jarak = hitungJarak(x, y, koordinatRute[k][j][0], koordinatRute[k][j][1]);
                if (jarak < min) {
                    min = jarak;
                    temp = hurufRute[k][j];
                    tempX = koordinatRute[k][j][0];
                    tempY = koordinatRute[k][j][1];
                }
            }
            x = tempX;
            y = tempY;
            if (j == koordinatRute[0].length - 1) {
                hasilRute += temp;
            } else {
                hasilRute += temp + " - ";
            }
            min = Double.MAX_VALUE;
        }
        return hasilRute;
    }

    /**
     * Method untuk menampilkan hasil pengemudi yang akan menjemput penumpang
     */
    static void tampilkanHasil() {
        System.out.println("===========================================================================");
        System.out.println("                            Hasil Perhitungan");
        System.out.println("---------------------------------------------------------------------------");
        int index = getIndexJarakTerkecil();
        double jarakTerdekat = getJarakPengemudiTerdekat(index);
        System.out.printf("Pengemudi %s adalah yang terdekat dengan %s dengan jarak %.2f Km\n", pengemudi[index],
                dataPenumpang[0], jarakTerdekat);
    }

    /**
     * Method untuk menampilkan rute yang akan ditempuh
     */
    static void tampilkanRute() {
        System.out.println("Rute Terdekat Yang Dapat Ditempuh: " + hitungRute());
    }

}
