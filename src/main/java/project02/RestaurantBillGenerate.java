package project02;

import java.util.Scanner;

/*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/
/*
ODEV: Sirket buyudu, cafe kismi acildi.
      Ayni uygulamayi cafe kisminda da kullanilsin.
      Cafede farkli menu var.
/*
ÖDEV: Şirket büyüdü, cafe kısmı açıldı.
      Aynı uygulama cafe kısmında da kullanılsın.
      Cafede farklı menü var.
        Dish dish1=new Dish(401,"Tiramisu",35.0);
        Dish dish2=new Dish(402,"Dondurma",25.0);
        Dish dish3=new Dish(402,"Profiterol",25.0);
        Dish dish4=new Dish(403,"Kahve",17.5);
        Dish dish5=new Dish(404,"Çay",7.5);
        Dish dish6=new Dish(405,"Portakal Suyu",25.5);
      Uygulama başladığında restaurant/cafe seçeneği olsun.1

*/
public class RestaurantBillGenerate {
    public static void main(String[] args) {

        RestaurantBillGenerate rst = new RestaurantBillGenerate();
        rst.start();


    }

    CafeBillGenerate cfe = new CafeBillGenerate();

    public void start() {
        Scanner inp =new Scanner(System.in);
        DishService dishService = new DishService();
        dishService.fillDishList();
        CafeService cafeService = new CafeService();
        cafeService.fillCafeList();
        OrderService orderService = new OrderService();
        System.out.println("**********LEZZET RESTAURAN/CAFE ONLINE SIPARIS UYGULAMASINA HOSGELDINIZ***********");
        System.out.println("Restaurant menusu icin 1'e cafe menusu icin 2'ye basiniz");
        int secim = inp.nextInt();
        if (secim==1){
            getSelectionMenu(dishService,orderService);


        } else if (secim==2) {
            cfe.getSelectionCafeMenu(cafeService,orderService);

        }else {
            System.out.println("Gecersiz secim, tekrar deneyiniz.");
            start();
        }
    }

    public void getSelectionMenu(DishService dishService,OrderService orderService) {
        int select=-1;
        //Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
        //oluşturma için seçim menüsü gösterilsin.
        Scanner inp = new Scanner(System.in);
        while (select!=0){
            System.out.println("------------------------------------------------------");
            System.out.println("************Restaurant Bolumune Hosgeldiniz***********");
            System.out.println("1-Menu\n" +
                    "2-Siparis Olusturma\n" +
                    "3-Siparis Iptal Etme\n" +
                    "4-Hesap Olustur\n" +
                    "0-CIKIS\n" +
                    "SECIMINIZ:");
            System.out.println("-------------------------------------------------------");
            select = inp.nextInt();
            switch (select){
                case 1:
                    dishService.showDishMenu();
                    break;

                case 2:
                    //dish list
                    orderService.createOrder(dishService);
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
