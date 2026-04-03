package Smart_Hub;

public class PhysicalProduct extends Product{

    public PhysicalProduct(int productId,String productName,double pricePerUnit){
        super(productId,productName,pricePerUnit);
    }

    @Override
    public void delivery(WarehouseService ws) {
        System.out.println("Handing " + this.getProductName() + " to the Delivery Truck!");
        ws.updateStock(this, -1);
        WarehouseAnalytics.successDelivery();
    }




}


