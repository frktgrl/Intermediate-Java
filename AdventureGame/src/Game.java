import java.io.BufferedReader;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    String playerName;

    public void start(){

        System.out.println("Oyuna Hoş Geldiniz !!");
        System.out.print("Lütfen bir isim giriniz:");
        playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName()+" Oyuna Hoşgeldin ! ");
        System.out.println("Lütfen Karakter seçiniz... ");
        player.selectChar();
        player.printInfo();
// ----------------------------------------   Lokasyon Seçme ----------------------------------

        Location location = null;
       while (true){

           System.out.println("---------------------------------------------------------");
           System.out.println("Gitmek istediğiniz Konumu Seçiniz");
           System.out.println("0 : EXIT ------------>");
           System.out.println("1 : Safe House  -----> ");
           System.out.println("2 : Tool Store  -----> ");
           System.out.println("3 : Cave        -----> ");
           System.out.println("4 : Forest      -----> ");
           System.out.println("5 : River       -----> ");
           System.out.println("---------------------------------------------------------");
           int selectLoc = input.nextInt();
           switch (selectLoc){
               case 0 : location = null;
               break;
               case 1 : location = new SafeHouse(player);
                   player.printInfo();
                   break;
               case 2 : location = new ToolStore(player);
                   break;
               case 3:  location = new Cave(player);
               break;
               case 4:  location = new Forest(player);
               break;
               case 5:  location = new River(player);
               break;
               default:
                   System.out.println("Please enter a valid location.");
                   break;
           }

           if(location == null){
               System.out.println("Exit the game.");
               break;
           }

           System.out.println(location.getName());
           if (!location.onLocation()){

               System.out.println("GAME OVER !");
               break;


           }

       }


    }






}
