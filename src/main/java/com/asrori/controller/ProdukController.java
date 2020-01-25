package com.asrori.controller;

import com.asrori.domain.Produk;
import com.asrori.exception.TidakAdaProdukDiKategoriException;
import com.asrori.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @InitBinder
    public void inisialisasiBinder(WebDataBinder binder){
        binder.setAllowedFields(
                "produkId",
                "namaProduk",
                "hargaUnit",
                "deskripsi",
                "manufaktur",
                "kategori",
                "stokUnit",
                "orderUnit",
                "kondisi",
                "diskontinu",
                "gambarProduk");
    }

    @ExceptionHandler(TidakAdaProdukDiKategoriException.class)
    public ModelAndView handleError(HttpServletRequest req, TidakAdaProdukDiKategoriException exception){
        ModelAndView view = new ModelAndView();

        view.addObject("invalidProdukId", exception.getProdukId());
        view.addObject("exception", exception);
        view.addObject("url", req.getRequestURL()+ "?" +req.getQueryString());
        view.setViewName("tidakadaproduk");

        return view;
    }

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

    @RequestMapping(value = "/produk/tambah", method = RequestMethod.GET)
    public String getFormTambahProduk(Model model){
        Produk produkBaru = new Produk();
        model.addAttribute("produkBaru", produkBaru);
        return "tambahProduk";
    }

    @RequestMapping(value = "/produk/tambah", method = RequestMethod.POST)
    public String prosesFormTambahProduk(@ModelAttribute("produkBaru") Produk produk, BindingResult result){
        MultipartFile file = produk.getGambarProduk();
        String direktori = "/home/asrori/oficiona/";

        System.out.println(produk.getProdukId());

        if (file != null && !file.isEmpty()){
            try {
                file.transferTo(new File(direktori + produk.getProdukId() + ".png"));
            }catch (Exception e){
                throw new RuntimeException("gagal menyimpan gambar");
            }
        }

        produkService.tambahProduk(produk);
        return "redirect:produks";
    }


}
