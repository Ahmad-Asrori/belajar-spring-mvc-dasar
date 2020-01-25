package com.asrori.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Produk implements Serializable {
    private static final long serialVersionUID = 3678107792576131001L;
    private String produkId;
    private String namaProduk;
    private BigDecimal hargaUnit;
    private String deskripsi;
    private String manufaktur;
    private String kategori;
    private long stokUnit;
    private long orderUnit;
    private boolean discontinue;
    private String kondisi;

    @JsonIgnore
    private MultipartFile gambarProduk;

    public Produk() {
        super();
    }

    public Produk(String produkId, String namaProduk, BigDecimal hargaUnit) {
        this.produkId = produkId;
        this.namaProduk = namaProduk;
        this.hargaUnit = hargaUnit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProdukId() {
        return produkId;
    }

    public void setProdukId(String produkId) {
        this.produkId = produkId;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public BigDecimal getHargaUnit() {
        return hargaUnit;
    }

    public void setHargaUnit(BigDecimal hargaUnit) {
        this.hargaUnit = hargaUnit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getManufaktur() {
        return manufaktur;
    }

    public void setManufaktur(String manufaktur) {
        this.manufaktur = manufaktur;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public long getStokUnit() {
        return stokUnit;
    }

    public void setStokUnit(long stokUnit) {
        this.stokUnit = stokUnit;
    }

    public long getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(long orderUnit) {
        this.orderUnit = orderUnit;
    }

    public boolean isDiscontinue() {
        return discontinue;
    }

    public void setDiscontinue(boolean discontinue) {
        this.discontinue = discontinue;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public MultipartFile getGambarProduk() {
        return gambarProduk;
    }

    public void setGambarProduk(MultipartFile gambarProduk) {
        this.gambarProduk = gambarProduk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produk produk = (Produk) o;
        return Objects.equals(produkId, produk.produkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produkId);
    }
}
