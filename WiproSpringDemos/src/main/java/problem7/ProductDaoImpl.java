package problem7;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductDaoImpl implements ProductDAO{
	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Product getProductDetails(int product_code) {
        String sql = "SELECT * FROM product WHERE product_code = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{product_code}, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getInt("product_code"),
                        rs.getString("product_name"),
                        rs.getString("product_category"),
                        rs.getString("product_description"),
                        rs.getDouble("product_price")
                );
            }
        });
    }
	

}
