package Smart_Hub;

import java.io.*;
import java.util.Map;

public class FileStorage {

  private static final String FILENAME = "warehouseReport.txt";

  public void saveToFile(Map<String,Integer> inventory){
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))){
          writer.write(" -- My Smart Hub -- \n");
          writer.write(" - Inventory - \n");
          for(Map.Entry<String,Integer> entry : inventory.entrySet()){
              writer.write(entry.getKey() + "," + entry.getValue() + "\n");
          }

      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }

  private void splitAndParsing(Map<String, Integer> inventory,String line){
      if (line.contains(",")) {
          String [] parts = line.split(",");
          String product = parts[0].trim();
          Integer quantity = Integer.parseInt(parts[1].trim());
          inventory.put(product,quantity);
      }
  }

  public void loadFromFile(Map<String, Integer> inventory){
      try(BufferedReader reader = new BufferedReader(new FileReader(FILENAME)) ){
          reader.readLine();
          reader.readLine();
          String line;
          while ((line = reader.readLine()) != null){
              splitAndParsing(inventory,line);
              }
          System.out.println("successfully data loaded to the Inventory ! ");
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }


}