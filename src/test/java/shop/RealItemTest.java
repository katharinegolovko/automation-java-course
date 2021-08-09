package shop;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

    RealItem realItem;

    @BeforeEach
    public void setUpForTest(){
        realItem = new RealItem();
        realItem.setName("Book");
        realItem.setWeight(400);
        realItem.setPrice(21.50);
    }

    @Test
    @DisplayName("Real item was successfully created")
    void realItemCreation() {
        String actualName = realItem.getName();
        String expectedName = "Book";
        Double actualWeight = realItem.getWeight();
        Double expectedWeight = 400.0;
        Double actualPrice = realItem.getPrice();
        Double expectedPrice = 21.50;
        assertAll("realItemFields",
                () -> assertEquals(actualName, expectedName),
                () -> assertEquals(actualWeight, expectedWeight),
                () -> assertEquals(actualPrice, expectedPrice)
        );
        //assertEquals(actualName, expectedName);
       // assertEquals(actualWeight, expectedWeight);
        //assertEquals(actualPrice, expectedPrice);
    }
}