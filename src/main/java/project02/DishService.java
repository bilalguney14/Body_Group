package project02;

import java.util.ArrayList;
import java.util.List;
public class DishService {
    static List<DishMenu> dishList = new ArrayList<>();
    public void fillDishList(){
        DishMenu dish1 = new DishMenu(100,"Adana Kebabi",220.0);
        DishMenu dish2=new DishMenu(101,"Urfa Kebabı",200.0);
        DishMenu dish3=new DishMenu(102,"Çökertme Kebabı",200.0);
        DishMenu dish4=new DishMenu(200,"Baklava",100.0);
        DishMenu dish5=new DishMenu(201,"Kadayıf",85.0);
        DishMenu dish6=new DishMenu(202,"Künefe",75.0);
        DishMenu dish7=new DishMenu(300,"Yayık Ayranı",30.0);
        DishMenu dish8=new DishMenu(301,"Kola",35.0);
        DishMenu dish9=new DishMenu(302,"Çay",15.0);
        DishMenu dish10=new DishMenu(303,"Su",7.5);
        //Her yemek icin bir object olusturmaliyiz
        //Normalde yemek eklemek icin ayri bir method olmali ve buna sadece yoneticiler ulasabilmeli
        //Burda oyle yapmadik?
        this.dishList.add(dish1);
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);
    }

    public void showDishMenu(){

        System.out.println("                  LEZETLERIMIZ                ");
        System.out.printf("%-3s     %-20s     %-5s\n","Kod","Adi","Fiyat");
        System.out.printf("%-3s     %-20s     %-5s\n","---","---","-----");
        for (DishMenu dishMenu : dishList){
            System.out.printf("%-3s     %-20s     %-5s Lira\n",dishMenu.getCode(),dishMenu.getName(),dishMenu.getPrice());
        }
    }

    public DishMenu findDishMenuByCode(int code){
        if (code == 0){
            System.out.println("Ana menuye yonlendiriliyorsunuz");
        }else {
            for (DishMenu dishMenu : this.dishList){

                if (dishMenu.getCode() == code){
                    return dishMenu;
                }

                }
            System.out.println("Urun Bulunamadi");
            }
        return new DishMenu(0,"",0);
        }
    }


