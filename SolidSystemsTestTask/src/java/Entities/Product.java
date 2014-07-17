
package Entities;

public class Product {
    private String name;
    private int cost;
    private int id;
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setCost(int cost)
    {
        this.cost=cost;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getCost()
    {
        return cost;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
}
