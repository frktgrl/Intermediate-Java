public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {

        System.out.println("Welcome to the Tool Store");
        boolean showMenu = true;
        while (showMenu) {

            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3 - EXIT");
            System.out.print("Seçiniz:");

            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {

                System.out.println("You entered an invalid value. Please , Again.");
                selectCase = input.nextInt();

            }

            switch (selectCase) {

                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("You logged out.");
                    showMenu = false;
                    break;


            }
        }
        return true;
    }

    public void printWeapon(){

        System.out.println("-----------------Weapons-----------------");
        for (Weapon w: Weapon.weapons()) {

            System.out.println(w.getId() +"-"+w.getName() +"< Damage : "+w.getDamage()+"Price : "+w.getPrice()+" >");

        }
        System.out.println("0 - Exit ");
    }


    public void buyWeapon(){
        System.out.print("Choose your weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){

            System.out.print("You entered an invalid value. Please , Again.");
            selectWeaponID = input.nextInt();

        }
        //------------------------------- Satın alma gerçekleşen alan-----------------------------------
        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if(selectedWeapon != null){

                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){

                    System.out.println("Insufficient balance.");

                }else {

                    System.out.println(selectedWeapon.getName()+" You bought it.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Balance "+ this.getPlayer().getMoney());
                    System.out.println("Old Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New Weapon : "+getPlayer().getInventory().getWeapon().getName());


                }
            }
        }

    }

    public void printArmor(){


        System.out.println("-----------------Armors-----------------");
        for (Armor a: Armor.armors()) {

            System.out.println(a.getId() +"-"+a.getName() +" < Block : "+a.getBlock()+" Price : "+a.getPrice()+" >");

        }
        System.out.println("0 - Exit ");
    }

    public void buyArmor(){
        System.out.print("Choose your armor: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Weapon.weapons().length){

            System.out.println("You entered an invalid value. Please , Again.");
            selectArmorID = input.nextInt();

        }
        //------------------------------- Satın alma gerçekleşen alan-----------------------------------

        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if(selectedArmor != null){

                if(selectedArmor.getPrice()>this.getPlayer().getMoney()){

                    System.out.println("Insufficient balance.");

                }else {

                    System.out.println(selectedArmor.getName()+" You bought it.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Balance "+ this.getPlayer().getMoney());
                    System.out.println("Old Armor : "+this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("New Armor : "+getPlayer().getInventory().getArmor().getName());


                }
            }



        }



    }


}


