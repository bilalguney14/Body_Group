package project02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner inp = new Scanner(System.in);
    List<Order> orderList = new ArrayList<>();
    DishService dishService = new DishService();
    CafeService cafeService = new CafeService();
    RestaurantBillGenerate rst = new RestaurantBillGenerate();
    CafeBillGenerate cafe = new CafeBillGenerate();

    public void createOrder(DishService dishService) {

        OrderService orderService = new OrderService();
        int code = -1;
        do {
            System.out.println("Almak istediginiz urunun kodunu giriniz (CIKIS: 0)");
            code = inp.nextInt();
            DishMenu dishMenu = dishService.findDishMenuByCode(code);
            if (dishMenu.getCode() > 0) {
                System.out.println("Kac adet urun alacaginizi giriniz");
                int adet = inp.nextInt();
                Order order = new Order(dishMenu, adet);
                order.setOrderCode(1000 + this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList) {
                if (order.dish == dishMenu) {
                    System.out.printf("Siparis Kodu:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Birim Fiyati:%-5s\n", order.orderCode,
                            order.dish.getCode(), order.dish.getName(), order.numOfProduct, order.dish.getPrice());
                }
            }
            System.out.println("Restaurant'dan urun secmeye devam etmek icin 1'e basiniz." +
                    "Cafe bolumune gecmek istiyorsaniz 2'ye basiniz." +
                    "Cikis icin 0'a basiniz.");
            code = inp.nextInt();
            if (code == 2) {
                cafeService.showCafeMenu();
                createOrder(cafeService);
            } else if (code == 0) {
                break;
            } else if (!(code == 0 || code == 1 || code == 2)) {
                System.out.println("Hatali giris yaptiniz tekrar deneyiniz!");
            }
        } while (code == 1);
    }

    public void createOrder(CafeService cafeService) {
        OrderService orderService = new OrderService();
        int code = -1;
        do {
            System.out.println("Almak istediginiz urunun kodunu giriniz (CIKIS: 0)");
            code = inp.nextInt();
            CafeMenu cafeMenu = cafeService.findCafeMenuByCode(code);
            if (cafeMenu.getCode() > 0) {
                System.out.println("Kac adet urun alacaginizi giriniz");
                int adet = inp.nextInt();
                Order order = new Order(cafeMenu, adet);
                order.setOrderCode(1000 + this.orderList.size());
                this.orderList.add(order);
            }
            for (Order order : this.orderList) {
                if (order.cafe == cafeMenu) {
                    System.out.printf("Siparis Kodu:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Birim Fiyati:%-5s\n", order.orderCode,
                            order.cafe.getCode(), order.cafe.getName(), order.numOfProduct, order.cafe.getPrice());

                }
            }
            System.out.println("Cafe'den urun secmeye devam etmek icin 2'e basiniz." +
                    "Restaurant bolumune gecmek istiyorsaniz 1'e basiniz." +
                    "Cikis icin 0'a basiniz.");
            code = inp.nextInt();
            if (code == 1) {
                dishService.showDishMenu();
                createOrder(dishService);
            } else if (code == 0) {
                break;
            } else if (!(code == 0 || code == 1 || code == 2)) {
                System.out.println("Hatali giris yaptiniz tekrar deneyiniz!");
            }
        } while (code == 2);
    }

    public void deleteOrder() {
        boolean isValid = true;
        if (this.orderList.isEmpty()) {
            System.out.println("Siparisiniz bulunmamaktadir");
        } else {
            for (Order order : orderList) {
                for (DishMenu dishMenu : DishService.dishList) {
                    if (order.dish == dishMenu) {
                        System.out.printf("Siparis Kodu Restaurant:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Birim Fiyat:%-5s\n", order.orderCode,
                                order.dish.getCode(), order.dish.getName(), order.numOfProduct, order.dish.getPrice());
                    }
                }

                for (CafeMenu cafeMenu : CafeService.cafeList) {
                    if (order.cafe == cafeMenu) {
                        System.out.printf("Siparis Kodu Cafe      :%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Birim Fiyat:%-5s\n", order.orderCode,
                                order.cafe.getCode(), order.cafe.getName(), order.numOfProduct, order.cafe.getPrice());
                    }
                }
            }
            System.out.println("Sepete atmis oldugunuz urunler yukaridaki gibidir\n\n" +
                    "Cafe bolumunden sepete eklemis oldugunuz urunlerden silmek icin 2'ye\n\n" +
                    "Restaurant bolumunden sepete eklemis oldugunuz urunlerden silmek icin 1'e basiniz.");
            int secim=inp.nextInt();
            if (secim == 2) {
                System.out.println("Iptal etmek istediginiz siparisin kodunu giriniz:");
                int code = inp.nextInt();
                for (Order order : this.orderList) {
                    if (order.orderCode == code) {
                        System.out.println("Silinecek Urun:");
                        System.out.printf("Siparis Kodu:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Birim Fiyat:%-5s\n", order.orderCode,
                                order.cafe.getCode(), order.cafe.getName(), order.numOfProduct, order.cafe.getPrice());
                        System.out.println("Urunu silmek istediginizden eminseniz 1'e basin, bu urunu silmekten vazgecmek icin 2'ye basiniz.");
                        int select = inp.nextInt();
                        if (select == 1) {
                            this.orderList.remove(order);
                            System.out.println("Siparisiniz iptal edildi " + order.orderCode + "--" + order.cafe.toString());
                            break;
                        } else if (select == 2) {
                            deleteOrder();
                        } else {
                            System.out.println("Gecersiz islem!");
                        }
                    }
                }
            } else if (secim == 1) {
                System.out.println("Iptal etmek istediginiz siparisin kodunu giriniz:");
                int code = inp.nextInt();
                for (Order order : this.orderList) {
                    if (order.orderCode == code) {
                        System.out.println("Silinecek Urun:");
                        System.out.printf("Siparis Kodu:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Birim Fiyat:%-5s\n", order.orderCode,
                                order.dish.getCode(), order.dish.getName(), order.numOfProduct, order.dish.getPrice());
                        System.out.println("Urunu silmek istediginizden eminseniz 1'e basin, bu urunu silmekten vazgecmek icin 2'ye basiniz.");
                        int select = inp.nextInt();
                        if (select == 1) {
                            this.orderList.remove(order);
                            System.out.println("Siparisiniz iptal edildi " + order.orderCode + "--" + order.dish.toString());
                            break;
                        } else if (select == 2) {
                            deleteOrder();
                        } else {
                            System.out.println("Gecersiz islem!");
                            isValid = false;
                        }
                        if (!isValid) {
                            System.out.println("Siparis kodu gecersiz!");
                        }
                    }
                }
            }
        }
    }
    public void printBill(){
        double totalPrice=0.0;
        System.out.println("                 LEZZET FISINIZ                  ");
        for (Order order : orderList) {
            for (DishMenu dishMenu : DishService.dishList) {
                if (order.dish == dishMenu) {
                    System.out.printf("Siparis Kodu:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Siparis Tutari:%-5s Lira\n", order.orderCode,
                            order.dish.getCode(), order.dish.getName(), order.numOfProduct, order.orderPrice);
                }
            }
            for (CafeMenu cafeMenu : CafeService.cafeList) {
                if (order.cafe == cafeMenu) {
                    System.out.printf("Siparis Kodu:%-4s   Lezzet Kodu:%-3s   Adi:%-15s   Adet:%-3s   Siparis Tutari:%-5s Lira\n", order.orderCode,
                            order.cafe.getCode(), order.cafe.getName(), order.numOfProduct, order.orderPrice);
                }
            }
            totalPrice += order.orderPrice;
        }
        System.out.println("Toplam Tutar: " + totalPrice + " Lira");
        System.out.println("Afiyet Olsun...");
        this.orderList = new ArrayList<>();
    }
}


