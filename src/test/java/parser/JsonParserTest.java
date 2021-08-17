package parser;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.testng.Assert;
import shop.Cart;
import shop.RealItem;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    RealItem realItem;
    Parser parser = new parser.JsonParser();
    Cart userCart;

    @BeforeEach
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
    @DisplayName("New File can be successfully created")
    void writeToFile() {
        parser.writeToFile(userCart);
        File expectedFile = new File("src/main/resources/user-cart.json");
        assertTrue(expectedFile.exists());
        assertTrue(expectedFile.isFile());
    }

    @Test
    @DisplayName("Data was successfully saved in JSON file")
    void getDataFromFile() {
        Cart cartFromFile = new Gson().fromJson("src/main/resources/andrew-cart.json", Cart.class);
    }

    @Test
    @DisplayName("Nonexistent File can not be read: Exception is shown")
    void readFromNonexistentFile() {
        NoSuchFileException exception = assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File("src/main/resources/user-cart1.json"));
        });
        assertEquals("File src/main/resources/user-cart1.json.json not found!", exception.getMessage());
    }

    @AfterEach
    void cleanUpAfterTest(){
        File testFile1 = new File("src/main/resources/user-cart.json");
        File testFile2 = new File("src/main/resources/test-file.json");
        testFile1.delete();
        testFile2.delete();
    }
}
