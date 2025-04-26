import java.util.*;
interface Category{
    String getCategoryName();
}
class BookCategory implements Category{
    public String getCategoryName(){
        return "books";
    }
}
class ClothingCategory implements Category{
    public String getCategoryName(){
        return "clothing";
    }
}
class GadgetCategory implements Category{
    @Override
    public String getCategoryName() {
        return "gadgets";
    }
}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() { return name; }

    public double getPrice() { return price; }

    public T getCategory() { return category; }

    public void setPrice(double price) {
        this.price = price;
    }
      public void display(){
          System.out.printf("%s - Category: %s | Price: $%.2f\n", name, category.getCategoryName(), price);


      }
}
class DiscountUtil {
    public static<T extends Product<?>>void applyDiscount(T product,double percentage){
        double oldPrice= product.getPrice();
        double discount=oldPrice*(percentage/100);
        product.setPrice(oldPrice-discount);
        System.out.printf("Applied %.1f%% discount to %s. New Price: $%.2f\n",
                percentage, product.getName(), product.getPrice());
    }
}
class MarketplaceApp{
    public static void main(String[]args){
        Product<BookCategory> book = new Product<>("Java Basics", 29.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 15.00, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, new GadgetCategory());

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("===Product Catalog");
        for(Product<? extends Category>p:catalog){
            p.display();
        }
        System.out.println("\n=== Applying Discounts ===");
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(phone, 5);
        System.out.println("\n===updated catalog===");
        for(Product<? extends Category>p:catalog){
            p.display();
        }
    }
}