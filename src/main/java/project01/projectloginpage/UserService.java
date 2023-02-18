package project01.projectloginpage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> usernames = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ad-soyad");
        String name = input.nextLine();

        String username;
        boolean exitsUsername;
        do {
            System.out.println("Kullanici adi giriniz");
            username = input.nextLine();
            exitsUsername = this.usernames.contains(username);
            if (exitsUsername) {
                System.out.println("Bu username kullanilamaz. farkli bir username deneyiniz");
            }

        } while (exitsUsername);

        String email;
        boolean existemail;
        boolean isValid;

        do {
            System.out.println("Email giriniz");
            email = input.nextLine().trim();
            isValid = validateEmail(email);
            existemail = this.emails.contains(email);
            if (existemail) {
                System.out.println("Bu email kullanilmis, tekrar deneyiniz");
                isValid = false;
            }
        } while (!isValid);

        String password;
        boolean isValidPsw;
        do {
            System.out.println("Password giriniz");
            password = input.nextLine().trim();
            isValidPsw=validatePassword(password);

        } while (!isValidPsw);

        this.passwords.add(password);
        this.emails.add(email);
        this.usernames.add(username);
        System.out.println("Tebrikler isleminiz basariyla gerceklestirildi");
        System.out.println("Kullanici adi veya email adresi ile sisteme giris yapabilirsiniz");
    }

    public void login(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Kullaci adi veya email ile giriniz");
        String usernameOrEmail = inp.nextLine();
        boolean isMail = this.emails.contains(usernameOrEmail);
        boolean isUsername = this.usernames.contains(usernameOrEmail);

        if(isMail || isUsername){

            boolean isWrong = true;
            while (isWrong){
                System.out.println("Sifrenizi giriniz");
                String password = inp.nextLine();

                if((usernameOrEmail.equals(usernames.get(passwords.indexOf(password))) || (usernameOrEmail.equals(emails.get(passwords.indexOf(password)))))){
                    System.out.println("Sisteme basariyla giris yaptiniz");
                    isWrong =false;
                }else{
                    System.out.println("Girdiginiz sifre kullanici adi veya emaille eslesmemektedir, tekrar giriniz");
                }
            }
        }else{
            System.out.println("Sisteme kayitli kullanici bulunamadi");
            System.out.println("Uyeyseniz bilgilerinizi kontrol ediniz, degilseniz lutfen uye olunuz");

        }
    }
    public static boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isConstainAt = email.contains("@");

        if (space) {
            System.out.println("Email bosluk iceremez");
            isValid = false;
        } else if (!isConstainAt) {
            System.out.println("Email @ icermelidir");
            isValid = false;
        } else {
            String first = email.split("@")[0];
            String second = email.split("@")[1];

            int notValid = first.replaceAll("[a-zA-Z0-9-._]", "").length();
            boolean checkStart = notValid == 0;

            boolean checkEnd = second.equals("gmail.com") || second.equals("hotmail.com") || second.equals("yahoo.com");

            if(!checkStart){
                System.out.println("email buyuk harf, kucuk harf, rakam, -._ disinda karakter iceremez!");
            }else if(!checkEnd){
                System.out.println("email gmail.com, hotmail.com, yahoo.com ile bitmelidir");
            }
            isValid=checkStart && checkEnd;
        }
        if(!isValid){
            System.out.println("Gecersiz email, tekrar deneyiniz");
        }
        return isValid;
    }

    public static boolean validatePassword(String password){
        boolean isValid;
        boolean space = password.contains(" ");
        boolean passwordlenght = password.length()>=6;
        boolean upperLetter = password.replaceAll("[^A-Z]","").length()>0;
        boolean lowerLetter = password.replaceAll("[^a-z]","").length()>0;
        boolean digit = password.replaceAll("[^0-9]","").length()>0;
        boolean symbol = password.replaceAll("[\\P{Punct}]","").length()>0;

        if(space){
            System.out.println("Sifre bosluk iceremez");
        }else if(!passwordlenght){
            System.out.println("sifre en az 6 karakter olmalidir");
        }else if(!upperLetter){
            System.out.println("Sifre en az bir tane buyuk harf icermelidir");
        }else if(!lowerLetter){
            System.out.println("Sifre en az bir tane kucuk harf icermelidir");
        }else if(!digit){
            System.out.println("Sifre en az bir tane rakam icermelidir");
        }else if(!symbol){
            System.out.println("Sifre en az bir tane symbol icermelidir");
        }
        isValid=!space && upperLetter && passwordlenght && lowerLetter && digit && symbol;

        if(!isValid){
            System.out.println("Gecersiz sifre girdiniz, tekrar deneyiniz");
        }
        return isValid;
    }
}
