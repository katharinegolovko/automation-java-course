package parser;

import com.google.gson.Gson;
import org.testng.annotations.*;
import shop.Cart;
import shop.RealItem;

import java.io.*;

import static org.testng.Assert.assertEquals;


public class JsonParserTestNG {

    RealItem realItem;
    Parser parser = new parser.JsonParser();
    Cart userCart;

    @DataProvider(name = "provider1")
    public Object[][] createData1() {
        return new Object[][] {
                { "src/main/resources/user-cart1.json"},
                { "src/main/resources/user-cart2.json"},
                { "src/main/resources/user-cart3.json"},
                { "src/main/resources/user-cart4.json"},
                { "src/main/resources/user-cart5.json"},
        };
    }

    @BeforeMethod
    void setUp() {
        userCart = new Cart("user-cart");
        realItem = new RealItem();
        realItem.setName("Book");
        realItem.setWeight(400);
        realItem.setPrice(21.50);
        userCart.addRealItem(realItem);

        parser.writeToFile(userCart);
    }

    @Test
    void getDataFromFile() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/user-cart.json"));
        Cart cartFromFile = new Gson().fromJson(reader, Cart.class);
        double actualResult = cartFromFile.getTotalPrice();
        double expectedResult = realItem.getPrice() + realItem.getPrice()*0.2;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    void readDataFromFile() {
        Cart testCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        double actualResult = testCart.getTotalPrice();
        double expectedResult = 26560.68;
        assertEquals(actualResult, expectedResult);
    }

    @Parameters({ "cart-name" })
    @Test  (expectedExceptions = NoSuchFileException.class)
    void readFromFile(String pathName) {
            parser.readFromFile(new File(pathName));
    }

    @Test  (dataProvider = "provider1",
            expectedExceptions = NoSuchFileException.class)
    void readFromFileDataProvider(String pathName) {
        parser.readFromFile(new File(pathName));
    }

    @AfterMethod
    void cleanUpAfterTest(){
        File testFile = new File("src/main/resources/user-cart.json");
        testFile.delete();
    }
}
