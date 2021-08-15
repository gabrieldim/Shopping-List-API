package shoppinglist.model;

/**
 * Represents a product.
 */
public class Product {

    private String name;

    private Boolean homeMade;

    private Double price;

    private String description;

    public Product() {
    }

    public Product(String name, Boolean homeMade, Double price, Integer weight, String description) {
        this.name = name;
        this.homeMade = homeMade;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHomeMade() {
        return homeMade;
    }

    public void setHomeMade(Boolean homeMade) {
        this.homeMade = homeMade;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", homeMade=" + homeMade +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
