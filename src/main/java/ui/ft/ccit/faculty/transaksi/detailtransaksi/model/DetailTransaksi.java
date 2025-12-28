package ui.ft.ccit.faculty.transaksi.detailtransaksi.model;

import jakarta.persistence.*;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;

@Entity
@Table(name = "detail_transaksi")
@IdClass(DetailTransaksiId.class)
public class DetailTransaksi {

    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Id
    @Column(name = "id_barang", length = 4)
    private String idBarang;

    @ManyToOne
    @JoinColumn(name = "kode_transaksi", insertable = false, updatable = false)
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "id_barang", insertable = false, updatable = false)
    private Barang barang;

    @Column(name = "jumlah", nullable = false)
    private Short jumlah;

    protected DetailTransaksi() {}

    public DetailTransaksi(String kodeTransaksi, String idBarang, Short jumlah) {
        this.kodeTransaksi = kodeTransaksi;
        this.idBarang = idBarang;
        this.jumlah = jumlah;
    }

    // Getters and Setters
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }

    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }

    public Transaksi getTransaksi() { return transaksi; }
    public void setTransaksi(Transaksi transaksi) { this.transaksi = transaksi; }

    public Barang getBarang() { return barang; }
    public void setBarang(Barang barang) { this.barang = barang; }

    public Short getJumlah() { return jumlah; }
    public void setJumlah(Short jumlah) { this.jumlah = jumlah; }
}
