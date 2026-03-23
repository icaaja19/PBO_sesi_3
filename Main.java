import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<hitungNilai> listMhs = new ArrayList<>();
        
        System.out.print("Masukkan jumlah data: ");
        int jumlah = 0;
        
        // Proteksi jika input jumlah bukan angka
        if (input.hasNextInt()) {
            jumlah = input.nextInt();
            input.nextLine(); // PENTING: Membersihkan sisa Enter setelah nextInt()
        }

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData ke-" + (i + 1));
            
            System.out.print("NIM   : "); 
            String nim = input.nextLine(); // Sekarang akan menunggu input dengan benar
            
            System.out.print("Nama  : "); 
            String nama = input.nextLine();
            
            System.out.print("Nilai : "); 
            int nilai = 0;
            if (input.hasNextInt()) {
                nilai = input.nextInt();
                input.nextLine(); // PENTING: Membersihkan sisa Enter lagi
            } else {
                System.out.println("Peringatan: Nilai harus angka! Diatur ke 0.");
                input.nextLine(); // Membersihkan input yang salah
            }

            // Memasukkan ke list menggunakan class hitungNilai (h kecil)
            listMhs.add(new hitungNilai(nim, nama, nilai));
        }

        // --- OUTPUT HASIL ---
        System.out.println("\n==========================================");
        System.out.println("              HASIL OUTPUT              ");
        System.out.println("==========================================");
        
        int total = 0;
        for (hitungNilai mhs : listMhs) {
            mhs.cetakData();
            total += mhs.nilai; 
        }

        if (jumlah > 0) {
            double rata = (double) total / jumlah;
            System.out.println("Jumlah Mahasiswa : " + jumlah);
            System.out.println("Rata-rata Nilai  : " + rata);
            input.close();
        }
    }
}