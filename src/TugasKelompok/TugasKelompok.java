package TugasKelompok;

import java.util.Scanner;

public class TugasKelompok {
    static String[] namaPelanggan = new String[50];
    static int index = 0;
    static int[] nomorMeja = new int[50];
    static String[] menu = { "Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng" };
    static int[] harga = { 15000, 22000, 12000, 18000 };
    static int[][] pesanan = new int[50][50];
    static int[][] hargaPerPesanan = new int[50][50];
    static int[] totalHargaPesanan = new int[50];
    static int pesananTerbanyak = 0;

    static void tambahkanPesanan(Scanner sc) {
        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan[index] = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        nomorMeja[index] = sc.nextInt();
        sc.nextLine();
        System.out.println("===== Menu Kafe =====");
        System.out.println("1. Kopi Hitam - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Teh Tarik - Rp 12000");
        System.out.println("4. Mie Goreng - Rp 18000");
        System.out.println();
        int input, jmlItem, totalHarga = 0, indexPesanan = 0;

        while (true) {
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai) : ");
            input = sc.nextInt();
            if (input == 0){
                break;
            }
            System.out.print("Masukkan jumlah item untuk " + menu[input-1] + ": ");
            jmlItem = sc.nextInt();
            hargaPerPesanan[index][indexPesanan + 1] = jmlItem * harga[input-1];
            pesanan[index][indexPesanan] = input-1;
            indexPesanan++;
            pesanan[index][indexPesanan] = jmlItem;
            indexPesanan++;
            totalHarga += jmlItem * harga[input-1];
            totalHargaPesanan[index] = totalHarga;
            System.out.println();
        }
        if (indexPesanan > pesananTerbanyak) {
            pesananTerbanyak = indexPesanan;
        }
        indexPesanan = 0;
        System.out.println();
        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp " + totalHarga);
        System.out.println();
        index++;
    }

    static void tampilkanPesanan() {
        System.out.println("===== DAFTAR PESANAN =====");
        for (int i = 0; i < index; i++) {
            System.out.println("Nama Pelanggan: " + namaPelanggan[i]);
            System.out.println("Nomor Meja: " + nomorMeja[i]);
            System.out.println("Detail Pesanan: ");
            for (int j = 0; j < pesananTerbanyak; j += 2) {
                if (pesanan[i][j + 1] < 1)
                    break;
                System.out.println(
                        "- " + menu[pesanan[i][j]] + " x " + pesanan[i][j + 1] + " = Rp " + hargaPerPesanan[i][j + 1]);
            }
            System.out.println("Total Harga Pesanan: Rp " + totalHargaPesanan[i]);
            System.out.println("---------------------");
        }
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
                    tampilkanPesanan();
                    break;
                case 3:
                    System.out.println("Selesai!");
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}