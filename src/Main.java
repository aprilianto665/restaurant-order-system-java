public class Main {
    private static final Menu[] menuList = {
        new Menu("Nasi Padang", 25000, "makanan"),
        new Menu("Ayam Bakar", 30000, "makanan"),
        new Menu("Gado-gado", 20000, "makanan"),
        new Menu("Soto Ayam", 22000, "makanan"),
        new Menu("Es Teh", 8000, "minuman"),
        new Menu("Jus Jeruk", 12000, "minuman"),
        new Menu("Kopi", 10000, "minuman"),
        new Menu("Air Mineral", 5000, "minuman")
    };

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        System.out.println("=== DAFTAR MENU ===");
        
        System.out.println("\nMAKANAN:");
        System.out.println("- " + menuList[0].getName() + " : Rp " + menuList[0].getPrice());
        System.out.println("- " + menuList[1].getName() + " : Rp " + menuList[1].getPrice());
        System.out.println("- " + menuList[2].getName() + " : Rp " + menuList[2].getPrice());
        System.out.println("- " + menuList[3].getName() + " : Rp " + menuList[3].getPrice());
        
        System.out.println("\nMINUMAN:");
        System.out.println("- " + menuList[4].getName() + " : Rp " + menuList[4].getPrice());
        System.out.println("- " + menuList[5].getName() + " : Rp " + menuList[5].getPrice());
        System.out.println("- " + menuList[6].getName() + " : Rp " + menuList[6].getPrice());
        System.out.println("- " + menuList[7].getName() + " : Rp " + menuList[7].getPrice());
    }
}