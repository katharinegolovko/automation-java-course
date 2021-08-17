package shop;

import org.junit.jupiter.api.*;
import org.testng.Assert;

class CartTest {

    RealItem realItem;
    Cart userCart;

    @BeforeEach
    public void setUpForTest(){
        userCart = new Cart("user-cart");
        realItem = new RealItem();
        realItem.setName("Pen");
        realItem.setWeight(6);
        realItem.setPrice(2);
        userCart.addRealItem(realItem);
    }

    @Test
    @DisplayName("Total price was calculated successfully for 1 Item")
    public void getTotalPriceForOneItem() {
        double actualResult = userCart.getTotalPrice();
        double expectedResult = realItem.getPrice() + realItem.getPrice()*0.2;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Total price was calculated successfully for 2 Items")
    public void getTotalPriceForTwoItems() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("Notion");
        virtualItem.setPrice(15);
        virtualItem.setSizeOnDisk(1045);
        userCart.addVirtualItem(virtualItem);
        double actualResult = userCart.getTotalPrice();
        double expectedResult = realItem.getPrice() + realItem.getPrice()*0.2 + virtualItem.getPrice() + virtualItem.getPrice()*0.2;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Real item was successfully removed")
    public void deleteRealItem() {
        userCart.deleteRealItem(realItem);
        double actualResult = userCart.getTotalPrice();
        double expectedResult = 0.0;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Virtual item was successfully removed")
    public void deleteVirtualItem() {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName("Notion");
        virtualItem.setPrice(15);
        virtualItem.setSizeOnDisk(1045);
        userCart.addVirtualItem(virtualItem);
        userCart.deleteVirtualItem(virtualItem);
        double actualResult = userCart.getTotalPrice();
        double expectedResult = realItem.getPrice() + realItem.getPrice()*0.2;;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Cart name was saved successfully")
    public void getCartName() {
        String actualResult = userCart.getCartName();
        String expectedResult = "user-cart";
        Assert.assertEquals(actualResult, expectedResult);
    }
}