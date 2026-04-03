package Smart_Hub;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static void main(String[] args) {

        WarehouseService ws = new WarehouseService();
        PhysicalProduct p1 = new PhysicalProduct(12233,"Sugar",200);
        PhysicalProduct p2 = new PhysicalProduct(12,"Flour",300);
        PhysicalProduct p3 = new PhysicalProduct(133,"Rice",230);



//        ws.addToInventory(p1,50);
//        ws.addToInventory(p2,4);
//        ws.addToInventory(p3,70);


        System.out.println("Starting Stock: " + ws.showStock());

//        ExecutorService es = Executors.newFixedThreadPool(10);
//
//        try {
//            for (int i = 0; i < 40; i++) {
//                es.execute(() -> p1.delivery(ws));
//            }
//            es.close();
//            es.awaitTermination(5, TimeUnit.SECONDS);
//
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println("The dispatch center was interrupted!");
//        }

        System.out.println("Starting Inventory Stock: " + ws.showStock());
//        System.out.println("Total Successful Deliveries (Analytics): " + WarehouseAnalytics.getTotalShipments());

        FileStorage report = new FileStorage();
//        report.saveToFile(ws.showStock());

        report.loadFromFile(ws.showStock());
        System.out.println("Final Inventory Stock: " + ws.showStock());
        WarehouseAnalytics.lowStockAlert(ws.showStock(),2);
    }
}

