import com.google.gson.Gson;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Cart andrewCart = new Cart("andrew-cart");

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);

        VirtualItem disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(11);
        disk.setSizeOnDisk(20000);

        andrewCart.addRealItem(car);
        andrewCart.addVirtualItem(disk);
        andrewCart.showItems();

        Parser parser = new JsonParser();
        parser.writeToFile(andrewCart);

        Cart eugenCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        eugenCart.showItems();


        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/user-cart.json"));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
