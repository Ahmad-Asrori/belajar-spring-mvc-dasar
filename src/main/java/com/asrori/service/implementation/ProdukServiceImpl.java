package com.asrori.service.implementation;

import com.asrori.domain.Produk;
import com.asrori.repository.ProdukRepository;
import com.asrori.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProdukServiceImpl implements ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    @Override
    public void updateStok() {
        List<Produk> semuaProduk = produkRepository.getAllProduk();
        for (Produk produk : semuaProduk){
            if (produk.getStokUnit() < 500){
                produkRepository.updateStok(produk.getProdukId(), produk.getStokUnit() + 1000);
            }
        }
    }

    @Override
    public List<Produk> getProdukByKategori(String kategori) {
        return produkRepository.getProdukByKategori(kategori);
    }

    @Override
    public List<Produk> getAllProduk() {
        return produkRepository.getAllProduk();
    }

    @Override
    public List<Produk> getProdukByFilter(Map<String, List<String>> filterParams) {
        return produkRepository.getProdukByFilter(filterParams);
    }

    @Override
    public Produk getProdukById(String produkId) {
        return produkRepository.getProdukById(produkId);
    }
}
