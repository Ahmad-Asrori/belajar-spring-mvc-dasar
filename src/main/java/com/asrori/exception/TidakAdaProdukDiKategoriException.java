package com.asrori.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Tidak Ada Produk Di Kategori Ini")
public class TidakAdaProdukDiKategoriException extends RuntimeException {

    private static final long serialVersionUID = 3935230281455340039L;
    private String produkId;

    public TidakAdaProdukDiKategoriException(String produkId) {
        this.produkId = produkId;
    }

    public String getProdukId() {
        return produkId;
    }

    public void setProdukId(String produkId) {
        this.produkId = produkId;
    }
}
