import java.util.Scanner;

// Exception jika rasa es krim tidak ada
class EskrimNotAvailableException extends Exception {
    public EskrimNotAvailableException(String message) {
        super(message);
    }
}

// Exception jika pesen eskrim melewati batas
class BatasEskrimException extends Exception {
    public BatasEskrimException(String message) {
        super(message);
    }
}

/*
 * mesin eskrim (disini hanya melayani eskrim)
 * (utk pembayaran dikasir )
 * Pengguna memilih rasa. Jika rasa tidak ada, program lempar exception.
 * Maksimal pesan 3 es krim
 */

public class MesinEskrim {

    // Method untuk memproses pilihan rasa dan jumlah
    public static void selectEskrim(String Eskrim, int jumlah) throws EskrimNotAvailableException, BatasEskrimException {
        // jika jumlah eskrim lebih dari 3
        if (jumlah > 3) {
            throw new BatasEskrimException("Maksimal hanya boleh pesan 3 es krim.");
        }

        // validasi rasa
        if (!Eskrim.equalsIgnoreCase("matcha") &&
            !Eskrim.equalsIgnoreCase("cokelat") &&
            !Eskrim.equalsIgnoreCase("stroberi")) {
            // jika rasa yg dipilih tidak ada
            throw new EskrimNotAvailableException("Rasa '" + Eskrim + "' tidak tersedia di mesin.");
        }

        // jika rasa tersedia dan jumlah valid
        System.out.println("Membuat " + jumlah + " es krim rasa " + Eskrim + "... Silakan tunggu.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try { // menangani jika rasa tidak tersedia atau jumlah melebihi batas
            System.out.println("=== Mesin Es Krim ===");
            System.out.print("Pilih rasa (matcha / Cokelat / Stroberi): ");
            String Eskrim = scanner.nextLine();

            System.out.print("Mau pesan berapa es krim? (maksimal 3): ");
            int jumlah = scanner.nextInt();

            selectEskrim(Eskrim, jumlah);

        // menangkap pesan jika rasa tidak ada atau jumlah tidak valid
        } catch (EskrimNotAvailableException | BatasEskrimException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // tutup 
            scanner.close();
        }
    }
}
