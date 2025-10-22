/**
 * Represents a menu item in the restaurant with name, price, and category
 */
public class Menu {
    private String name;
    private int price;
    private String category;

    /**
     * Creates a new menu item
     * @param name The name of the menu item
     * @param price The price of the menu item in rupiah
     * @param category The category of the item ("makanan" or "minuman")
     */
    public Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Gets the name of the menu item
     * @return The menu item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the menu item
     * @return The price in rupiah
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the category of the menu item
     * @return The category ("makanan" for food, "minuman" for drinks)
     */
    public String getCategory() {
        return category;
    }
}
