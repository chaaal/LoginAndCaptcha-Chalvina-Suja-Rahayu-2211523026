import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Date tanggalTransaksi;
    private static String namaPelanggan;
    private static String noHP;
    private static String kasir;
    private static int jumlahBeli;
    private static String alamatPelanggan;
    public static String username = "admin";
    public static String password = "password";
    public static String captcha;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Transaksi transaksi = null;

        try {
            System.out.println("====================================");
            System.out.println("STORE");

            // Inisialisasi tanggalTransaksi
            tanggalTransaksi = new Date();
            System.out.println("Tanggal: " + new SimpleDateFormat("EEE, dd/MM/yyyy").format(tanggalTransaksi));
            System.out.println("Waktu: " + new SimpleDateFormat("HH:mm:ss z").format(tanggalTransaksi));

            System.out.println("====================================");
            System.out.println("LOGIN");
            System.out.println("------------------");

            //Login
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Password: ");
            String inputPassword = scanner.nextLine();

            if (login(inputUsername, inputPassword)) {
                // Generate and display captcha
                captcha = generateCaptcha();
                System.out.println("Captcha: " + captcha);

                // Validate captcha
                 System.out.println("Enter Captcha: ");
                 String enteredCaptcha = scanner.nextLine();

                 if (validateCaptcha(enteredCaptcha)) {
                    // Continue with the transaction

                    System.out.println("\n====================================");
                    System.out.println("DATA PELANGGAN");
                    System.out.println("------------------");

                    System.out.print("Nama Pelanggan: ");
                    namaPelanggan = scanner.nextLine();

                    System.out.print("No. HP : ");
                    noHP = scanner.nextLine();

                    System.out.print("Alamat: ");
                    alamatPelanggan = scanner.nextLine();

                    // Input data pembelian barang
                    System.out.println("++++++++++++++++++++++++++++++");
                    System.out.println("DATA PEMBELIAN BARANG");
                    System.out.println("-----------------------");

                    System.out.print("Kode Barang : ");
                    String kodeBarang = scanner.nextLine();

                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();

                    System.out.print("Harga Barang: ");
                    double hargaBarang = scanner.nextDouble();

                    System.out.print("Jumlah Beli : ");
                    jumlahBeli = scanner.nextInt();

                    // Membuat objek barang elektronik
                    BarangElektronik barang = new BarangElektronik(kodeBarang, namaBarang, hargaBarang);

                    // Input kasir
                    scanner.nextLine(); // membersihkan newline
                    System.out.print("Kasir : ");
                    kasir = scanner.nextLine();

                    // Membuat objek transaksi
                    transaksi = new Transaksi("Supermarket ABC", tanggalTransaksi, namaPelanggan, noHP,
                            alamatPelanggan, barang, jumlahBeli, kasir);

                    // Menampilkan hasil transaksi
                    System.out.println("\n====================================");
                    System.out.println("Detail Transaksi:");
                    System.out.println("Nama Supermarket: " + transaksi.getNamaSupermarket());
                    System.out.println("Tanggal dan Waktu: " + transaksi.formatTanggalWaktu());
                    System.out.println("\nDATA PELANGGAN");
                    System.out.println("Nama Pelanggan: " + transaksi.getNamaPelanggan());
                    System.out.println("No. HP : " + transaksi.getNoHP());
                    System.out.println("Alamat: " + transaksi.getAlamatPelanggan());
                    System.out.println("\nDATA PEMBELIAN BARANG");
                    System.out.println("Kode Barang : " + transaksi.getBarang().getKodeBarang());
                    System.out.println("Nama Barang: " + transaksi.getBarang().getNamaBarang());
                    System.out.println("Harga Barang: " + transaksi.getBarang().getHargaBarang());
                    System.out.println("Jumlah Beli : " + transaksi.getJumlahBeli());
                    System.out.println("TOTAL BAYAR: " + transaksi.hitungTotalBayar());
                    System.out.println("\nKasir : " + transaksi.getKasir());
                 } else {
                    System.out.println("Invalid Captcha. Exiting...");
                 }
            } else {
                System.out.println("Invalid username or password. Exiting...");
            }
        } catch (InputMismatchException e) {
            if (transaksi != null) {
                System.out.println("\nKasir : " + transaksi.getKasir());
            }
            System.out.println("Terjadi kesalahan pada input data. Pastikan input sesuai dengan format yang benar.");
        } finally {
            scanner.close();
        }
    }
    private static boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    private static String generateCaptcha() {
        // Generate a random 4-digit captcha
        Random random = new Random();
        int captchaNumber = random.nextInt(9000) + 1000;
        return String.valueOf(captchaNumber);
    }

    private static boolean validateCaptcha(String enteredCaptcha) {
        // Validate captcha case-insensitively
        return captcha.equalsIgnoreCase(enteredCaptcha);
    }
}
