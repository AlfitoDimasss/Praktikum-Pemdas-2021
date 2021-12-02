import java.util.Scanner;

public class Pertemuan13b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String angka = in.nextLine();
        if (angka.contains(" ")) {
            String[] pecahanCampuran = pecahanCampuran(angka);
            System.out.println("Desimal: " + pecahanCampuran[0]);
            System.out.println("Pecahan campuran: " + pecahanCampuran[1]);
            System.out.println("Pecahan: " + pecahanCampuran[2]);
        } else if (angka.contains("/")) {
            String[] pecahan = pecahan(angka);
            System.out.println("Desimal: " + pecahan[0]);
            System.out.println("Pecahan campuran: " + pecahan[1]);
            System.out.println("Pecahan: " + pecahan[2]);
        } else if (angka.contains(".")) {
            String[] desimal = desimal(angka);
            System.out.println("Desimal: " + desimal[0]);
            System.out.println("Pecahan campuran: " + desimal[1]);
            System.out.println("Pecahan: " + desimal[2]);
        } else {
            System.out.println("Desimal: " + angka);
            System.out.println("Pecahan campuran: " + angka);
            System.out.println("Pecahan: " + angka);
        }
        in.close();
    }

    static String[] desimal(String angka) {
        String[] pisahan = angka.split("[.]");
        String pecahan[] = sederhanakan(pisahan);
        String akhir[] = { angka, pecahan[0], pecahan[1] };
        return akhir;
    }

    static String[] pecahanCampuran(String angka) {
        String[] pisahan = angka.split(" ");
        String depan = pisahan[0];
        String[] belakang = pisahan[1].split("/");
        int angkaDepan = Integer.valueOf(belakang[0]);
        int angkaBelakang = Integer.valueOf(belakang[1]);
        int fpb = euclid(angkaDepan, angkaBelakang);
        while (fpb > 1) {
            angkaDepan /= fpb;
            angkaBelakang /= fpb;
            fpb = euclid(angkaDepan, angkaBelakang);
        }
        belakang[0] = "" + angkaDepan;
        belakang[1] = "" + angkaBelakang;
        pisahan[1] = belakang[0] + "/" + belakang[1];
        double desimalAngka = 0;
        if (Double.parseDouble(depan) > 0) {
            desimalAngka = Double.parseDouble(depan)
                    + Double.parseDouble(belakang[0]) / Double.parseDouble(belakang[1]);
        } else if (Double.parseDouble(depan) < 0) {
            desimalAngka = Double.parseDouble(depan)
                    - Double.parseDouble(belakang[0]) / Double.parseDouble(belakang[1]);
        }
        String desimal = "" + desimalAngka;
        if (angkaDepan % angkaBelakang == 0) {
            String akhir[] = { desimal, desimal, desimal };
            return akhir;
        }
        int pecahanDepan = 0;
        if (Double.parseDouble(depan) > 0) {
            pecahanDepan = Integer.parseInt(depan) * Integer.parseInt(belakang[1]) + Integer.parseInt(belakang[0]);
        } else if (Double.parseDouble(depan) < 0) {
            pecahanDepan = Integer.parseInt(depan) * Integer.parseInt(belakang[1]) - Integer.parseInt(belakang[0]);
        }
        String pecahan = "" + pecahanDepan + "/" + belakang[1];
        angka = pisahan[0] + " " + pisahan[1];
        String akhir[] = { desimal, angka, pecahan };
        return akhir;
    }

    static String[] pecahan(String angka) {
        String[] pisahan = angka.split("/");
        int angkaDepan = Integer.valueOf(pisahan[0]);
        int angkaBelakang = Integer.valueOf(pisahan[1]);
        int fpb = euclid(angkaDepan, angkaBelakang);
        while (fpb > 1) {
            angkaDepan /= fpb;
            angkaBelakang /= fpb;
            fpb = euclid(angkaDepan, angkaBelakang);
        }
        pisahan[0] = "" + angkaDepan;
        pisahan[1] = "" + angkaBelakang;
        angka = pisahan[0] + "/" + pisahan[1];
        double desimalAngka = Double.parseDouble(pisahan[0]) / Double.parseDouble(pisahan[1]);
        String desimal = "" + desimalAngka;
        if (angkaDepan % angkaBelakang == 0) {
            String akhir[] = { desimal, desimal, desimal };
            return akhir;
        }
        int depanAngka = Integer.parseInt(pisahan[0]) / Integer.parseInt(pisahan[1]);
        String depan = "" + depanAngka;
        if (depanAngka == 0)
            depan = "";
        String pembilang = "" + (Integer.parseInt(pisahan[0]) % Integer.parseInt(pisahan[1]));
        String pecahanCampuran = "";
        if (depan.equals("")) {
            pecahanCampuran = pembilang + "/" + pisahan[1];
        } else {
            int pembilang1 = Integer.parseInt(pembilang) * -1;
            pembilang = "" + pembilang1;
            pecahanCampuran = depan + " " + pembilang + "/" + pisahan[1];
        }
        String akhir[] = { desimal, pecahanCampuran, angka };
        return akhir;
    }

    public static String[] sederhanakan(String[] desimal) {
        int depan = Integer.parseInt(desimal[0]);
        int belakang = Integer.parseInt(desimal[1]);
        int penyebut = (int) Math.pow(10, desimal[1].length());
        int fpb = euclid(belakang, penyebut);
        while (fpb > 1) {
            belakang /= fpb;
            penyebut /= fpb;
            fpb = euclid(belakang, penyebut);
        }
        String pecahanMix = "" + depan + " " + belakang + "/" + penyebut;
        if (depan == 0)
            pecahanMix = belakang + "/" + penyebut;
        int pembilang = depan * penyebut + belakang;
        if (depan < 0)
            pembilang = pembilang - belakang * 2;
        String pecahan = pembilang + "/" + penyebut;
        String[] akhir = { pecahanMix, pecahan };
        return akhir;
    }

    public static int euclid(int m, int n) {
        int r = m % n;
        int gcd = 0;
        while (r != 0) {
            r = m % n;
            if (r == 0)
                break;
            m = n;
            n = r;
        }
        gcd = n;
        return gcd;
    }
}