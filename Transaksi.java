// Kelas transaksi dengan implementasi HitungTotalBayar dan Exception Handling
import java.text.SimpleDateFormat;
import java.util.Date;

class Transaksi implements HitungTotalBayar {
    private String namaSupermarket;
    private Date tanggalTransaksi;
    private String namaPelanggan;
    private String noHP;
    private String alamatPelanggan;
    private Barang barang;
    private int jumlahBeli;
    private String kasir;

    public Transaksi(String namaSupermarket, Date tanggalTransaksi, String namaPelanggan, String noHP,
                     String alamatPelanggan, Barang barang, int jumlahBeli, String kasir) {
        this.namaSupermarket = namaSupermarket;
        this.tanggalTransaksi = tanggalTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.noHP = noHP;
        this.alamatPelanggan = alamatPelanggan;
        this.barang = barang;
        this.jumlahBeli = jumlahBeli;
        this.kasir = kasir;
    }

    public String getNamaSupermarket() {
        return namaSupermarket;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public Barang getBarang() {
        return barang;
    }

     public int getJumlahBeli() {
        return jumlahBeli;
    }

    public String getKasir() {
        return kasir;
    }

    // Implementasi dari interface HitungTotalBayar
    @Override
    public double hitungTotalBayar() {
        return barang.getHargaBarang() * jumlahBeli;
    }

    // Method untuk format tanggal dan waktu
    public String formatTanggalWaktu() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy HH:mm:ss z");
        return dateFormat.format(tanggalTransaksi);
    }
}