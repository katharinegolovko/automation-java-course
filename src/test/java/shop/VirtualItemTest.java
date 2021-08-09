package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {

    VirtualItem virtualItem;

    @BeforeEach
    public void setUpForTest() {
        virtualItem = new VirtualItem();
        virtualItem.setName("Notion");
        virtualItem.setPrice(15);
        virtualItem.setSizeOnDisk(1045);
    }

    @Test
    @DisplayName("Virtual item was successfully created")
    void realItemCreation() {
        String actualName = virtualItem.getName();
        String expectedName = "Notion";
        Double actualSizeOnDisk = virtualItem.getSizeOnDisk();
        Double expectedSizeOnDisk = 1045.0;
        Double actualPrice = virtualItem.getPrice();
        Double expectedPrice = 15.0;
        assertEquals(actualName, expectedName);
        assertEquals(actualSizeOnDisk, expectedSizeOnDisk);
        assertEquals(actualPrice, expectedPrice);
    }

}