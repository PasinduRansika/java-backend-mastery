package Smart_Hub;

public class DigitalProduct extends Product{

    public DigitalProduct(int productId, String productName, double pricePerUnit) {
        super(productId, productName, pricePerUnit);
    }

    @Override
    public void delivery(WarehouseService service) {
        System.out.println("Link Sent To Email ");
        service.updateStock(this, -1);
        WarehouseAnalytics.successDelivery();
    }
}
