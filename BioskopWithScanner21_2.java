import java.util.Scanner;

public class BioskopWithScanner21_2 {

    public static void main(String[] args) {
        Scanner sc21 = new Scanner(System.in);
        int baris, kolom;
        String nama, next;
        String[][] penonton = new String[4][2];

        while (true) {
            System.out.println("======================================");
            System.out.println("     Selamat Datang Di Bioskop CGV");
            System.out.println("======================================");
            System.out.println("- Menu 1 : Input Data Penonton");
            System.out.println("- Menu 2 : Tampilkan Daftar Penonton");
            System.out.println("- Menu 3 : Exit");
            System.out.println("======================================");
            System.out.print("Masukkan Pilihan Anda : ");
            int choice = sc21.nextInt();
            sc21.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                System.out.print("Masukkan Nama : ");
                nama = sc21.nextLine();
                System.out.print("Masukkan Baris: ");
                baris = sc21.nextInt();
                System.out.print("Masukkan Kolom: ");
                kolom = sc21.nextInt();
                sc21.nextLine();
                if(isValidSeat(baris,kolom,penonton)){
                    penonton [baris - 1][kolom - 1]= nama;
                }else {
                    System.out.println("Nomor baris/kolom kursi tidak tersedia.");
                }
                break;
                case 2:
                System.out.println("Daftar Penonton:");
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (penonton[i][j] != null) {
                            System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": " + penonton[i][j]);
                        }
                    }
                }
                break;
                case 3:
                    System.out.println("Terima kasih!");
                    return; // Exit the program
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang benar.");
            }

            System.out.print("Kembali ke menu? (y/n) : ");
            next = sc21.nextLine();

            if (next.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
  // Fungsi untuk memeriksa apakah nomor baris/kolom kursi valid
    private static boolean isValidSeat(int baris, int kolom, String[][] penonton) {
        if (baris >= 1 && baris <= 4 && kolom >= 1 && kolom <= 2 && penonton[baris - 1][kolom - 1] == null) {
            return true;
        }
        return false;
    }
}