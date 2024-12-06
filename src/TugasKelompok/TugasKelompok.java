package TugasKelompok;

import java.util.Scanner;

public class TugasKelompok {
    static String namaPelanggan;

    static int nomorMeja;

    static void tambahkanPesanan(Scanner sc) {
        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        nomorMeja = sc.nextInt();
        sc.nextLine();
        String[] menu = { "Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng" };
        int[] harga = { 15000, 22000, 12000, 18000 };
        System.out.println("===== Menu Kafe =====");
        System.out.println("1. Kopi Hitam - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Teh Tarik - Rp 12000");
        System.out.println("4. Mie Goreng - Rp 18000");
        System.out.println();
        int input, jmlItem, totalHarga = 0;
        while (true) {
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai) : ");
            input = sc.nextInt();
            if (input == 0)
                break;
            System.out.print("Masukkan jumlah item untuk " + menu[input - 1] + ": ");
            jmlItem = sc.nextInt();
            totalHarga += jmlItem * harga[input - 1];
        }
        System.out.println("Pesanan berhasil ditabahkan.");
        System.out.println("Total harga pesanan: Rp " + totalHarga);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihanMenu;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihanMenu = sc.nextInt();
            sc.nextLine();
            switch (pilihanMenu) {
                case 1:
                    tambahkanPesanan(sc);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    }
}