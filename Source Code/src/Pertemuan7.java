import java.util.Scanner;

public class Pertemuan7 {
    public static void main(String[] args) throws Exception {

        Scanner io = new Scanner(System.in);

        // While Loop
        // Akan terus mengulang selama kondisi bernilai true
        // int i = 0;
        // boolean lanjut = true;
        while (true) {
            int g = io.nextInt();
            if (g == 0) {
                break;
            }
        }

        System.out.println("---------------------------------------------------------------------------");

        // Do-While Loop
        // Sama seperti while loop namun akan menjalankan perulangan minimal sekali
        // walaupun kondisi bernilai false.
        int a = 8;
        do {
            System.out.println("a = " + a);
            a++;
        } while (a < 7);

        System.out.println("---------------------------------------------------------------------------");

        // For Loop
        // Gunakan apabila kita sudah tahu berapa kali perulangan atau iterasi
        // int b = 5;
        String ab = "FITO";
        for (int j = 0, y = 2; y < ab.length(); j += 2, y++) {
            System.out.println(ab.substring(j, y));
        }

        System.out.println("---------------------------------------------------------------------------");

        // Break and Continue
        for (int g = 0; g < 10; g++) {
            if (g == 8) {
                break;
            } else if (g % 2 == 0) {
                System.out.println("Perulangan ke-" + g);
            } else {
                continue;
            }
        }

        System.out.println("---------------------------------------------------------------------------");

        // Nested Loop
        for (int t = 0; t < 5; t++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
                if (t == j) {
                    break;
                }
            }
            System.out.print("\n");
        }

        io.close();
    }
}