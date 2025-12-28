package ui.ft.ccit.faculty.transaksi.transaksi.model;

import jakarta.persistence.*;
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "tgl_transaksi", nullable = false)
    private LocalDateTime tglTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", nullable = false)
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "id_karyawan", nullable = false)
    private Karyawan karyawan;

    protected Transaksi() {}

    public Transaksi(String kodeTransaksi, LocalDateTime tglTransaksi, Pelanggan pelanggan, Karyawan karyawan) {
        this.kodeTransaksi = kodeTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.pelanggan = pelanggan;
        this.karyawan = karyawan;
    }

    // Getters and Setters
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }

    public LocalDateTime getTglTransaksi() { return tglTransaksi; }
    public void setTglTransaksi(LocalDateTime tglTransaksi) { this.tglTransaksi = tglTransaksi; }

    public Pelanggan getPelanggan() { return pelanggan; }
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }

    public Karyawan getKaryawan() { return karyawan; }
    public void setKaryawan(Karyawan karyawan) { this.karyawan = karyawan; }
}
