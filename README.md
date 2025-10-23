# Restaurant Order System

A simple restaurant ordering system built with Java to manage food and beverage orders with discount and promotion calculations.

## Features

- Food and beverage menu with prices
- Interactive ordering system
- 10% discount for purchases above Rp 100,000
- Buy 1 get 1 free promotion for beverages (if total after discount > Rp 50,000)
- 10% tax calculation and Rp 20,000 service fee

## System Requirements

- Java Development Kit (JDK) 8 or newer
- Command Prompt or Terminal

## How to Run

### 1. Compile the Program

Open Command Prompt and navigate to the project directory:

```bash
cd restaurant-order-system-java/src
```

Compile all Java files:

```bash
javac *.java
```

### 2. Run the Program

Execute the main program:

```bash
java Main
```

## How to Use

1. **View Menu**: The program will display a list of food and beverage menus with their prices

2. **Place Order**: Enter orders with the format:

   ```
   menu name=quantity
   ```

   Example:

   ```
   nasi padang=2
   es teh=3
   ayam bakar=1
   ```

3. **Finish Order**: Type `selesai` to complete the order

4. **View Receipt**: The program will display a complete receipt with total calculations, discounts, tax, and service fee

## Available Menu

### Food:

- Nasi Padang: Rp 25,000
- Ayam Bakar: Rp 30,000
- Gado-gado: Rp 20,000
- Soto Ayam: Rp 22,000

### Beverages:

- Es Teh: Rp 8,000
- Jus Jeruk: Rp 12,000
- Kopi: Rp 10,000
- Air Mineral: Rp 5,000

## Usage Example

```
=== DAFTAR MENU ===

MAKANAN:
- Nasi Padang : Rp 25000
- Ayam Bakar : Rp 30000
- Gado-gado : Rp 20000
- Soto Ayam : Rp 22000

MINUMAN:
- Es Teh : Rp 8000
- Jus Jeruk : Rp 12000
- Kopi : Rp 10000
- Air Mineral : Rp 5000

Masukkan pesanan Anda (ketik 'selesai' untuk mengakhiri):
Pesanan 1: nasi padang=2
Pesanan 2: es teh=3
Pesanan 3: ayam bakar=1
Pesanan 4: selesai

=== STRUK PESANAN ===
Nasi Padang x2 = Rp 50000
Es Teh x3 = Rp 24000
Ayam Bakar x1 = Rp 30000
---------------------
Subtotal: Rp 104000
Diskon 10%: -Rp 10400
Promo Beli 1 Gratis 1 Minuman: -Rp 8000
Pajak 10%: Rp 8560
Biaya Pelayanan: Rp 20000
=====================
TOTAL BAYAR: Rp 114160
```

## File Structure

```
restaurant-order-system-java/
├── src/
│   ├── Main.java          # Main program file
│   └── Menu.java          # Menu item class
└── README.md              # Usage guide
```
