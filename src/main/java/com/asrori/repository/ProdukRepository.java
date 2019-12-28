package com.asrori.repository;

import com.asrori.domain.Produk;

import java.util.List;
import java.util.Map;

public interface ProdukRepository {
    List<Produk> getAllProduk();
    List<Produk> getProdukByKategori(String kategori);
    List<Produk> getProdukByFilter(Map<String, List<String>> filterParams);
    Produk getProdukById(String produkId);
    void updateStok(String produkId, long banyakUnit);
}
