package recruitmentcode.model;

/**
 * Class Product DOCUMENTEZ_MOI.
 */
public class Product
{
    /** item. */
    private int id; 
    /** item. */
    private String item;
    
    /** price. */
    private double price;
    
    /** offer. */
    private double offer;
    
    /**
     * Instanciation de product.
     */
    public Product()
    {
        super();    
        
    }

    public Product(int id, String item, double price, double offer)
    {
        this.id = id;
        this.item = item;
        this.price = price;
        this.offer = offer;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getItem()
    {
        return item;
    }

    public void setItem(String item)
    {
        this.item = item;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getOffer()
    {
        return offer;
    }

    public void setOffer(double offer)
    {
        this.offer = offer;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
    
}
