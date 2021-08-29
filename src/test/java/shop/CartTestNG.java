package shop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CartTestNG {

    RealItem realItem;
    Cart userCart;

    @BeforeMethod(alwaysRun = true)
    public void setUpForTest(){
        userCart = new Cart("user-cart");
        realItem = new RealItem();
        realItem.setName("Pen");
        realItem.setWeight(6);
        realItem.setPrice(2);
        userCart.addRealItem(realItem);
    }

    @Test(groups={"getTotalPrice"})
    public void getTotalPriceForOneItem() {
        double actualResult = userCart.getTotalPrice();
        double expectedResult = realItem.getPrice() + realItem.getPrice()*0.2;
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups={"getTotalPrice"})
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

    @Test(groups={"deleteItem"})
    public void deleteRealItem() {
        userCart.deleteRealItem(realItem);
        double actualResult = userCart.getTotalPrice();
        double expectedResult = 0.0;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(groups={"deleteItem"})
    @Ignore
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

    @Test(groups={"getCartName"})
    public void getCartName() {
        String actualResult = userCart.getCartName();
        String expectedResult = "user-cart";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
