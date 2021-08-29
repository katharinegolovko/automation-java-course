package parser;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.Assert;
import shop.Cart;
import shop.RealItem;

import java.io.*;

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
    @DisplayName("Data was successfully saved in JSON file")
    void getDataFromFile() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/user-cart.json"));
        Cart cartFromFile = new Gson().fromJson(reader, Cart.class);
        double actualResult = cartFromFile.getTotalPrice();
        double expectedResult = realItem.getPrice() + realItem.getPrice()*0.2;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    @DisplayName("Data can be successfully read from JSON file")
    void readDataFromFile() {
        Cart testCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        double actualResult = testCart.getTotalPrice();
        double expectedResult = 26560.68;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = { "src/main/resources/user-cart1.json", "src/main/resources/user-cart2.json", "src/main/resources/user-cart3.json", " ", "src/main/resources/user-cart5.json"})
    @DisplayName("Nonexistent File can not be read: Exception is shown")
    void readFromFile(String pathName) {
        NoSuchFileException exception = assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(pathName));
        });
        assertEquals("File " + pathName + ".json not found!", exception.getMessage());
    }

    @AfterEach
    void cleanUpAfterTest(){
        File testFile = new File("src/main/resources/user-cart.json");
        testFile.delete();
    }
}
