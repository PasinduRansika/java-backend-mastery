package Smart_Hub;

import java.util.Objects;

public abstract class Product {

    private final String productName;
    private final int productId;
    private final double pricePerUnit;

    public Product(int productId,String productName,double pricePerUnit){
        this.productId = productId;
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
    }

    public abstract void delivery(WarehouseService service);

    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }

    }
