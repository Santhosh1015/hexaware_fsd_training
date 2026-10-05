package com.repository;

import com.Mapper.VendorMapper;
import com.model.Vendor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendorRepo {
    private final VendorMapper vendorMapper;
    private final JdbcTemplate jdbcTemplate;

    public VendorRepo(VendorMapper vendorMapper, JdbcTemplate jdbcTemplate) {
        this.vendorMapper = vendorMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vendor> getAllVendors() {
        String sql = "select * from vendor";
        return jdbcTemplate.query(sql , vendorMapper);

    }

    public List<Vendor> getVendorsById(int vendorId) {
        String sql = "select * from vendor where id = ?";
        return jdbcTemplate.query(sql , vendorMapper, vendorId);
    }
}
