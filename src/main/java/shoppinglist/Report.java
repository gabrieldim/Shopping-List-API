package shoppinglist;

import shoppinglist.model.Product;

import java.util.Comparator;
import java.util.List;

public class Report {

    /**
     * Creates a report for home made products list received as a parameter.
     *
     * @param productList the product list.
     * @return {@link String} the report of home made products in string format.
     */
    public static String getReport(List<Product> productList){

        StringBuilder sb = new StringBuilder();
        sb.append("Show all home made products that the customer wants to buy:");
        productList.stream()
                .filter(product -> product
                        .getHomeMade()
                        .equals(true))
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(product -> {
                    sb.append("\n... " + product.getName());
                    sb.append("\n    " + splitDescription(product.getDescription()));
                    if(product.getPrice() > 700){
                        sb.append("\nToo expensive, probably not worth it." );
                    }else{
                        sb.append("\nPrice: " + product.getPrice() + "eur");
                    }
                });

        Double costHomeMadeProduct = 0.0;
        Long countHomeMadeProduct = 0L;

        costHomeMadeProduct = productList
                .stream()
                .filter(product -> product.getHomeMade()
                        .equals(true))
                .mapToDouble(Product::getPrice)
                .sum();

        countHomeMadeProduct = productList
                .stream()
                .filter(product -> product.getHomeMade()
                        .equals(true))
                .count();

        sb.append("\nHomeMade cost: " + costHomeMadeProduct + "eur");
        sb.append("\nHomeMade count: " + countHomeMadeProduct);


        return sb.toString();
    }

    /**
     * Truncates the description if it's longer than 50 characters, else returns the description without changes.
     *
     * @param description
     * @return {@link String}
     */
    public static String splitDescription(String description){
        String splitDescription;

        if(description.length() < 50){
            return description;
        }
        splitDescription = description.substring(0, 50) + " etc.";
        return splitDescription;
    }

}
