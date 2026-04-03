package Smart_Hub;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WarehouseAnalytics {
    private final static AtomicInteger totalShipped = new AtomicInteger(0);

    public static void successDelivery() {
        totalShipped.incrementAndGet();
    }

    public static int getTotalShipments() {
        return totalShipped.get();
    }

    public static void lowStockAlert(Map<String, Integer> inventory,int alertLevel){
         long count = inventory.entrySet().stream()
         .filter(p -> p.getValue() < alertLevel)
         .count();

         if(count == 0){
             System.out.println(" All are good !");
         }

        inventory.entrySet().stream()
                .filter(p -> p.getValue() < alertLevel)
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue() + " left !"));
    }

}
