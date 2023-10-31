import java.util.Scanner;

public class BioskopWithScanner21_4 {


    public static void main(String[] args) {
        Scanner sc21 = new Scanner(System.in);
        int baris, kolom;
        String nama, next;
        String[][] penonton = new String[4][2];

        while (true) {
            System.out.println("======================================");
            System.out.println("     Selamat Datang Di Bioskop ");
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
            
                int selectedBaris, selectedKolom;
                boolean validSeat = false;
            
                do {
                    System.out.print("Masukkan Baris : ");
                    selectedBaris = sc21.nextInt();
                    System.out.print("Masukkan Kolom : ");
                    selectedKolom = sc21.nextInt();
            
                    sc21.nextLine();
            
                    validSeat = isValidSeat(selectedBaris, selectedKolom, penonton);
            
                    if (!validSeat) {
                        System.out.println("Kursi sudah terisi. Silakan pilih kursi lain.");
                    }
                } while (!validSeat);
            
                penonton[selectedBaris - 1][selectedKolom - 1] = nama;
                break;
            
                case 2:
                System.out.println("Daftar Penonton:");
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (penonton[i][j] != null) {
                            System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": " + penonton[i][j]);
                        } else {
                            System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": *");
                        }
                    }
                }
                break;
            
                case 3:
                    System.out.println("Terima kasih!");
                    return;
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
    
    private static boolean isValidSeat(int baris, int kolom, String[][] penonton) {
        if (baris >= 1 && baris <= 4 && kolom >= 1 && kolom <= 2 && penonton[baris - 1][kolom - 1] == null) {
            return true;
        }
        return false;
    }
}