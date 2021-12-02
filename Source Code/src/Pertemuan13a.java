public class Pertemuan13a {
    public static void main(String[] args) {
        System.out.println(array(3, 4, 5, 6));
        test();
        printSort();
        printSort(8, 3, 4, 9, 22, 19, 15);
        System.out.println("fib: " + fib(6));
    }

    // static int array(int angka) {
    //
    // }
    static int array(int... angka) {
        int total = 0;
        for (int a : angka) {
            total += a;
        }
        return total;
    }

    static int b = 20;

    static void test() {
        int b = 10;
        System.out.println("ini lokal: " + b);
        System.out.println("ini global: " + Pertemuan13a.b);
        b = 15;
        System.out.println("ini lokal: " + b);
        Pertemuan13a.b = 25;
        System.out.println("ini global: " + Pertemuan13a.b);
    }

    public static int[] sort(int[] angka) {
        int n = angka.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (angka[i] < angka[j]) {
                    int temp = angka[i];
                    angka[i] = angka[j];
                    angka[j] = temp;
                }
            }
        }
        return angka;
    }

    static void printSort() {
        int[] sortArr = new int[] { 5, 3, 8, 9 };
        System.out.println("Sebelum disort: ");
        for (int s : sortArr) {
            System.out.print(s + " ");
        }
        int[] sorting = sort(sortArr);
        System.out.println("\nSesudah disort: ");
        for (int s : sorting) {
            System.out.print(s + " ");
        }
        System.out.println();
        // kalo mau berantakan
        // for(int s: sort(new int [] {5, 3, 8, 9})) {
        // System.out.print(s + " ");
        // }
    }

    static void printSort(int... sortArr) {
        System.out.println("Sebelum disort: ");
        for (int s : sortArr) {
            System.out.print(s + " ");
        }
        int[] sorting = sort(sortArr);
        System.out.println("\nSesudah disort: ");
        for (int s : sorting) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static int fib(int n) { // 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
        // fib(5) + fib(4)
        // fib(4) + fib(3) + fib(3) + fib(2)
        // fib(3) + fib(2) + fib(2) + fib(1) + fib(2) + fib(1) + fib(1) + fib(0)
        // fib(2) + fib(1) + fib1 + fib0 + fib1 + fib0 + fib1 + fib1 + fib0 + fib1 +
        // fib1 + fib0
        // fib1 + fib0 + fib1 + fib1 + fib0 + fib1 + fib0 + fib1 + fib1 + fib0 + fib1 +
        // fib1 + fib0
    }
}