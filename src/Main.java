import java.util.Scanner;

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

    private static Menu[] orders = new Menu[4];
    private static int[] quantities = new int[4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayMenu();

        System.out.println("\nMasukkan pesanan Anda (ketik 'selesai' untuk mengakhiri):");

        if (inputOrder(scanner, 1, 0)) return;
        if (inputOrder(scanner, 2, 1)) return;
        if (inputOrder(scanner, 3, 2)) return;
        if (inputOrder(scanner, 4, 3)) return;

        printReceipt();
        scanner.close();
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

        public static boolean inputOrder(Scanner scanner, int orderNumber, int index) {
        System.out.print("Pesanan " + orderNumber + ": ");
        String input = scanner.nextLine();
        
        if (input.equalsIgnoreCase("selesai")) {
            printReceipt();
            scanner.close();
            return true;
        } else if (input.trim().isEmpty()) {
            System.out.println("Input tidak boleh kosong!");
            return inputOrder(scanner, orderNumber, index);
        } else if (!processInput(input, index)) {
            return inputOrder(scanner, orderNumber, index);
        }
        return false;
    }

        public static boolean processInput(String input, int index) {
        final String[] parts = input.split("=");
        final String menuName = parts[0].trim().toLowerCase();
        final int quantity = Integer.parseInt(parts[1].trim());
        
        if (quantity <= 0) {
            System.out.println("Jumlah harus lebih dari 0!");
            return false;
        }

        switch (menuName) {
            case "nasi padang":
                orders[index] = menuList[0];
                break;
            case "ayam bakar": 
                orders[index] = menuList[1];
                break;
            case "gado-gado": 
                orders[index] = menuList[2];
                break;
            case "soto ayam": 
                orders[index] = menuList[3];
                break;
            case "es teh": 
                orders[index] = menuList[4];
                break;
            case "jus jeruk": 
                orders[index] = menuList[5];
                break;
            case "kopi": 
                orders[index] = menuList[6];
                break;
            case "air mineral": 
                orders[index] = menuList[7];
                break;
            default:
                System.out.println("Menu tidak ditemukan! Silakan coba lagi.");
                return false;
        }
        
        quantities[index] = quantity;
        return true;
    }

    public static void printReceipt() {
        System.out.println("\n=== STRUK PESANAN ===");
        
        int subtotal = 0;
        
        subtotal += displayOrderItem(0);
        subtotal += displayOrderItem(1);
        subtotal += displayOrderItem(2);
        subtotal += displayOrderItem(3);
        
        System.out.println("---------------------");
        System.out.println("Subtotal: Rp " + subtotal);
        
        final int[] calculationResult = calculateTotalCost(subtotal);
        final int drinkDiscount = calculationResult[0];
        final int tax = calculationResult[1];
        final int serviceFee = calculationResult[2];
        final int discount = calculationResult[3];
        final int finalTotal = calculationResult[4];
        
        if (drinkDiscount > 0) {
            System.out.println("Promo Beli 1 Gratis 1 Minuman: -Rp " + drinkDiscount);
        }
        
        if (discount > 0) {
            System.out.println("Diskon 10%: -Rp " + discount);
        }
        
        System.out.println("Pajak 10%: Rp " + tax);
        System.out.println("Biaya Pelayanan: Rp " + serviceFee);
        
        System.out.println("=====================");
        System.out.println("TOTAL BAYAR: Rp " + finalTotal);
    }

    public static int displayOrderItem(int index) {
        if (orders[index] != null) {
            final int total = orders[index].getPrice() * quantities[index];
            System.out.println(orders[index].getName() + " x" + quantities[index] + " = Rp " + total);
            return total;
        }
        return 0;
    }
    
    public static int[] calculateTotalCost(int subtotal) {
        int drinkDiscount = 0;
        
        if (subtotal > 50000) {
            int cheapestPrice = Integer.MAX_VALUE;
            boolean hasEligibleDrink = false;
            
            if (isDrink(0)) {
                if (quantities[0] > 1) {
                    cheapestPrice = Math.min(cheapestPrice, orders[0].getPrice());
                    hasEligibleDrink = true;
                }
            }
            if (isDrink(1)) {
                if (quantities[1] > 1) {
                    cheapestPrice = Math.min(cheapestPrice, orders[1].getPrice());
                    hasEligibleDrink = true;
                }
            }
            if (isDrink(2)) {
                if (quantities[2] > 1) {
                    cheapestPrice = Math.min(cheapestPrice, orders[2].getPrice());
                    hasEligibleDrink = true;
                }
            }
            if (isDrink(3)) {
                if (quantities[3] > 1) {
                    cheapestPrice = Math.min(cheapestPrice, orders[3].getPrice());
                    hasEligibleDrink = true;
                }
            }
            
            if (hasEligibleDrink) {
                drinkDiscount = cheapestPrice;
            }
        }
        
        final int totalAfterPromo = subtotal - drinkDiscount;
        
        int discount = 0;
        if (totalAfterPromo > 100000) {
            discount = (int)(totalAfterPromo * 0.1);
        } 
        
        final int totalAfterDiscount = totalAfterPromo - discount;
        final int tax = (int)(totalAfterDiscount * 0.1);
        final int serviceFee = 20000;
        final int finalTotal = totalAfterDiscount + tax + serviceFee;
        
        return new int[]{drinkDiscount, tax, serviceFee, discount, finalTotal};
    }
    
    
    public static boolean isDrink(int index) {
        Menu order = orders[index];
        return order != null && order.getCategory().equals("minuman");
    }
}