package project02;

import java.util.ArrayList;
import java.util.List;

public class CafeService {
    static List<CafeMenu> cafeList = new ArrayList<>();
    public void fillCafeList() {
        CafeMenu cafe1=new CafeMenu(400,"Tiramisu",35.0);
        CafeMenu cafe2=new CafeMenu(401,"Dondurma",25.0);
        CafeMenu cafe3=new CafeMenu(402,"Profiterol",25.0);
        CafeMenu cafe4=new CafeMenu(403,"Kahve",17.5);
        CafeMenu cafe5=new CafeMenu(404,"Çay",7.5);
        CafeMenu cafe6=new CafeMenu(405,"Portakal Suyu",25.5);

        this.cafeList.add(cafe1);
        this.cafeList.add(cafe2);
        this.cafeList.add(cafe3);
        this.cafeList.add(cafe4);
        this.cafeList.add(cafe5);
        this.cafeList.add(cafe6);
    }
    public void showCafeMenu() {

        System.out.println("                  LEZETLERIMIZ                ");
        System.out.printf("%-3s     %-20s     %-5s\n", "Kod", "Adi", "Fiyat");
        System.out.printf("%-3s     %-20s     %-5s\n", "---", "---", "-----");
        for (CafeMenu cafeMenu : cafeList) {
            System.out.printf("%-3s     %-20s     %-5s Lira\n", cafeMenu.getCode(), cafeMenu.getName(), cafeMenu.getPrice());
        }
    }
    public CafeMenu findCafeMenuByCode(int code){
        if (code == 0){
            System.out.println("Ana menuye yonlendiriliyorsunuz");
        }else {
            for (CafeMenu cafeMenu : this.cafeList){

                if (cafeMenu.getCode() == code){
                    return cafeMenu;
                }

            }
            System.out.println("Urun Bulunamadi");
        }
        return new CafeMenu(0,"",0);
    }
}