package Smart_Hub;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WarehouseService {

    private Map<String,Integer> inventory  = new ConcurrentHashMap<>();

    public void updateStock(Product product, int quantity) {
        String name = product.getProductName();

        if(!inventory.containsKey(name)){
            System.out.println("Couldnt find in the inventory!");
            return;
        }

        inventory.merge(product.getProductName(),quantity,(oldStock,newStock) -> {
            int updatedStock = oldStock + newStock;
            if(updatedStock < 0){
                System.out.println("Insufficient Stock !");
                return oldStock;
            }
            return updatedStock;
        });

    }

    public void addToInventory(Product product, int quantity) {
        if (product == null)
            throw new NullProductException("Product cannot be null!");
        if (quantity < 0)
            throw new InvalidProductStockException("Cannot add negative stock!");
        inventory.put(product.getProductName(), quantity);
    }

    public Map<String, Integer> showStock(){
        return inventory ;
    }
    public Set<String> getAllProducts(){
        return inventory.keySet();
    }



}
