import java.util.ArrayList;
import java.util.List;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String getCategory();
}
class Electronics extends WarehouseItem{
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
class Groceries extends WarehouseItem{
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}
class Furniture extends WarehouseItem{
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}
class Storage<T extends WarehouseItem>{
    private List<T>items = new ArrayList<>();
    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}
class WarehouseUtils{
    public static void displayItems(List<? extends WarehouseItem>items){
        for(WarehouseItem item:items){
            System.out.println(item.getCategory()+":"+item.getName());
        }
    }
}
 class WarehouseApp{
    public static void main(String[]args){
        Storage<Electronics>electronicsStorage=new Storage<>();
        electronicsStorage.addItem(new Electronics("phone"));
        electronicsStorage.addItem(new Electronics("laptop"));

        Storage<Groceries>groceriesStorage=new Storage<>();
        groceriesStorage.addItem(new Groceries("milk"));
        groceriesStorage.addItem(new Groceries("apple"));


        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());


    }
}