package com.asrori.controller;

import com.asrori.domain.Produk;
import com.asrori.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @RequestMapping("/produks/update/stok")
    public String list(Model model){
        produkService.updateStok();
        return "redirect:produks";
    }

    @RequestMapping("/produks")
    public String getProduks(Model model){
        List<Produk> produks = produkService.getAllProduk();
        model.addAttribute("produks", produks);
        return "produk";
    }

    @RequestMapping("/produk/{kategori}")
    public String getKategoriProduk(@PathVariable("kategori") String kategori, Model model){
        List<Produk> produks = produkService.getProdukByKategori(kategori);
        model.addAttribute("produks", produks);
        return "produk";
    }

    @RequestMapping("/produk/filter/{params}")
    public String getFilterProduk(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model){
        model.addAttribute("produks", produkService.getProdukByFilter(filterParams));
        return "produk";
    }

    @RequestMapping("/produk")
    public String getProdukById(@RequestParam("id") String produkId, Model model){
        model.addAttribute("produk", produkService.getProdukById(produkId));
        return "produkId";
    }
}
