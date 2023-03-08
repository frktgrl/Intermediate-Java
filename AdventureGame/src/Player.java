import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    private Scanner input = new Scanner(System.in);


    public Player(String name){

        this.name = name;
        this.inventory = new Inventory();

    }
    // ----------------------------------------   Karakter Seçme  ----------------------------------
    public void selectChar(){

        GameChar charlist[] = {new Samurai(),new Archer(),new Knight()};



        System.out.println("---------------------------------------------------------");
        for (GameChar gamechar:charlist) {

            System.out.println("Karakter  " + gamechar.getId()+": " + gamechar.getName() +
                    "\t Damage "+gamechar.getDamage()+
                    "\t Health "+gamechar.getHealth()+
                    "\t Money "+gamechar.getMoney());

        }
        System.out.println("---------------------------------------------------------");

        System.out.print("Lütfen Karakter ID'si giriniz:");
        int selectChar = input.nextInt();


        switch(selectChar){

            case 1: initPlayer(new Samurai());
            break;
            case 2: initPlayer(new Archer());
            break;
            case 3: initPlayer(new Knight());
            break;
            default: initPlayer(new Samurai());
            break;


        }


    }

    public void initPlayer(GameChar gameChar){

        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
        this.setOrjinalHealth(gameChar.getHealth());

    }

    public void printInfo(){
        System.out.println("Seçilen karakter: "+this.getCharName()+"\t Damage: "+this.getTotalDamage()+"\t Health: "+this.getHealth()+"\t Money: "+this.getMoney());
    }


// ----------------------------------------   Lokasyon Seçme ----------------------------------
    public void selectLoc(){


    }



    public int getTotalDamage(){

        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
