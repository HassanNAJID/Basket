package recruitmentcode.testTDD;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import recruitmentcode.Basket;
import recruitmentcode.model.Product;

public class BasketTest
{

   

    @Test
    public void givenProduct_whenGet_thenThatElementIsReturned()
    {
        Basket basket = new Basket();
        basket.initBasket();
        basket.addOrUpdateProductToBasket(1, 4);

        Product product = basket.getProduct(1);

        assertEquals("Apple", product.getItem());
    }
    
    @Test
    public void givenProductsWithQuantityOffer_whenGet_thenThatElementIsReturned()
    {
        Basket basket = new Basket();
        basket.initBasket();
        basket.addOrUpdateProductToBasket(1, 4);
        Product product = basket.getProduct(1);
        assertEquals(8, basket.getQuantityWithOffer(product, 4));
    }
    @Test
    public void givenProductsWithPrice_whenGet_thenThatElementIsReturned()
    {
        Basket basket = new Basket();
        basket.initBasket();
        basket.addOrUpdateProductToBasket(1, 4);
        Product product = basket.getProduct(1);
        
        System.out.println((4*product.getOffer())*product.getPrice());
        System.out.println(basket.getPriceBasket(product, 4));
        assertEquals(4*product.getOffer()*product.getPrice(), basket.getPriceBasket(product, 4),0.01);
    }
    
    
}
