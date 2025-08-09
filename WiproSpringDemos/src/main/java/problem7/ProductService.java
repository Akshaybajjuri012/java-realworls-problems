package problem7;

public class ProductService {
	private ProductDAO productDAO;

    public void setProductDao(ProductDAO productDao) {
        this.productDAO = productDao;
    }

    public Product getProductDetails(int product_code) {
        return productDAO.getProductDetails(product_code);
    }

    public double calculatePrice(int quantity, double product_price) {
        return quantity * product_price;
    }

    public boolean validateProductCode(int product_code) {
        return (product_code > 0 && String.valueOf(product_code).length() == 4);
    }
    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }

}
