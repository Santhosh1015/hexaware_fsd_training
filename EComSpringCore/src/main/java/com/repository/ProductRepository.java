package com.repository;

import com.Mapper.ProductMapper;
import com.Mapper.ProductToMap;
import com.dto.ProductDTO;
import com.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private final ProductMapper productMapper;
    private final JdbcTemplate jdbcTemplate;
    private final ProductToMap productToMap;

    public ProductRepository(ProductMapper productMapper, JdbcTemplate jdbcTemplate, ProductToMap productToMap) {
        this.productMapper = productMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.productToMap = productToMap;
    }

    public void insertProduct(Product product) {
        String sql = "insert into product values(?,?,?,?,?,?)";
        Object[] values =
                new Object[]{product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getStockQuantity(),
                        product.getCategory().getId(),
                        product.getVendor().getId()
                };
        jdbcTemplate.update(sql , values);
    }

    public List<ProductDTO> fetchById(int productId) {
        String sql = """
                    select p.id, p.name, p.price, p.stockQuantity, c.name as categoryName , v.name as vendorName
                    from product p
                    join category c
                    on p.category_id = c.id
                    join vendor v
                    on p.vendor_id = v.id
                    where p.id = ?
                    """;
        return jdbcTemplate.query(sql , productMapper , productId);
    }

    public void updateProductStock(int productId, Long newStockQty) throws SQLException {
        // stock is replaced from the original
        //it can add or reduce based on the needs
        String sql = """
                update product
                set stockQuantity = ?
                where id = ?
                """;
        Object[] values = new Object[]{newStockQty ,productId };
        jdbcTemplate.update(sql ,values);
    }

    public List<Map.Entry<String , Integer>> countProductByVendor() {
        String sql = """
                select v.name as vendorName , count(p.id) as productCount
                from product p
                right join vendor v on p.vendor_id = v.id
                group by v.name
                """;
        return jdbcTemplate.query(sql , productToMap);
    }
}
