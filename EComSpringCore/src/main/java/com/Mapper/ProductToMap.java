package com.Mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductToMap implements RowMapper<Map.Entry<String , Integer>> {

    // since we have to declare map
    // we use Map.Entry to convert each row to map entries
    @Override
    public Map.Entry<String , Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Map.entry(rs.getString("vendorName"),
                rs.getInt("productCount"));

    }
}
