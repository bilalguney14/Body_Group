package project02;

import java.util.Scanner;
public class CafeBillGenerate {

    CafeService cafeService = new CafeService();
    public void getSelectionCafeMenu(CafeService cafeService, OrderService orderService) {

        int select = -1;
        Scanner inp = new Scanner(System.in);
        while (select != 0) {
            System.out.println("------------------------------------------------");
            System.out.println("************Cafe Bolumune Hosgeldiniz***********");
            System.out.println("1-Menu\n" +
                    "2-Siparis Olusturma\n" +
                    "3-Siparis Iptal Etme\n" +
                    "4-Hesap Olustur\n" +
                    "0-CIKIS\n" +
                    "SECIMINIZ:");
            System.out.println("-------------------------------------------------");
            select = inp.nextInt();
            switch (select) {
                case 1:
                    cafeService.showCafeMenu();
                    break;
                case 2:
                    //cafe list
                    orderService.createOrder(cafeService);
                    break;
                case 3:
                    //sepetten silme
                    orderService.deleteOrder();
                    break;
                case 4:
                    //hesap olusturma
                    orderService.printBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatali Giris");
                    break;
            }
        }
        System.out.println("Iyi Gunler...");
    }
}

