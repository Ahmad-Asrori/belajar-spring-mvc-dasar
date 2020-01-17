package com.asrori.service;

import com.asrori.domain.Produk;

import java.util.List;
import java.util.Map;

public interface ProdukService {
    List<Produk> getAllProduk();
    List<Produk> getProdukByKategori(String kategori);
    List<Produk> getProdukByFilter(Map<String, List<String>> filterParams);
    Produk getProdukById(String produkId);
    void updateStok();
    void tambahProduk(Produk produk);
}
