package com.asrori.repository.Implementation;

import com.asrori.domain.Produk;
import com.asrori.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProdukRepositoryImpl implements ProdukRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Produk> getAllProduk() {
        Map<String, Object> params = new HashMap<>();
        List<Produk> result = jdbcTemplate.query("select * from produk", params, new ProdukRepositoryImpl.produkMapper());
        return result;
    }

    @Override
    public List<Produk> getProdukByKategori(String kategori) {
        String SQL = "select * from produk where kategori = :kategori";
        Map<String, Object> params = new HashMap<>();
        params.put("kategori", kategori);
        return jdbcTemplate.query(SQL, params, new produkMapper());
    }

    @Override
    public List<Produk> getProdukByFilter(Map<String, List<String>> filterParams) {
        String SQL = "select * from produk where kategori in (:kategories) and manufaktur in (:manufaktur)";
        return jdbcTemplate.query(SQL, filterParams, new produkMapper());
    }

    @Override
    public Produk getProdukById(String produkId) {
        String SQL = "select * from produk where id = :produkId";
        Map<String, Object> params = new HashMap<>();
        params.put("produkId", produkId);
        return jdbcTemplate.queryForObject(SQL, params, new produkMapper());
    }

    @Override
    public void updateStok(String produkId, long banyakUnit) {
        String SQL = "update produk set stok_unit = :banyakUnit where id = :produkId";
        Map<String, Object> params = new HashMap<>();
        params.put("banyakUnit", banyakUnit);
        params.put("id", produkId);
        jdbcTemplate.update(SQL, params);
    }

    private static final class produkMapper implements RowMapper<Produk> {
        @Override
        public Produk mapRow(ResultSet rs, int i) throws SQLException {
            Produk produk = new Produk();
            produk.setProdukId(rs.getString("id"));
            produk.setNamaProduk(rs.getString("nama"));
            produk.setDeskripsi(rs.getString("deskripsi"));
            produk.setHargaUnit(rs.getBigDecimal("harga_unit"));
            produk.setManufaktur(rs.getString("manufaktur"));
            produk.setKategori(rs.getString("kategori"));
            produk.setKondisi(rs.getString("kondisi"));
            produk.setStokUnit(rs.getLong("stok_unit"));
            produk.setOrderUnit(rs.getLong("order_unit"));
            produk.setDiscontinue(rs.getBoolean("diskontinue"));

            return produk;
        }
    }
}
