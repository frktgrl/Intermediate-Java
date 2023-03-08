import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;

public abstract class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award =award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("You are here now "+ this.getName());
        System.out.println("Be Careful ! "+ obsNumber+" pieces "+this.getObstacle().getName()+" lives !");
        System.out.print("<W>ar or <E>scape : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if ( selectCase.equals("W") && combat(obsNumber)){

                System.out.println(this.getName()+" You have defeated all the enemies.");
                return true;

        }
        if (this.getPlayer().getHealth() <= 0){

            System.out.println("You Died !");
            return false;


        }


        return true;
    }
    public boolean combat (int obsNumber){

        for (int i = 1 ; i <= obsNumber ; i++){

            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obsatcleStats(i);

            while (this.getPlayer().getHealth() >0 && this.getObstacle().getHealth()>0){
                System.out.println("");
                System.out.print("<H>it or <R>un : ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")){
                    System.out.println("You Shot !!");

                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0){
                        System.out.println("");
                        System.out.println(this.getObstacle().getName()+" Shot !");
                        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }


                }else{
                    return false;
                }
            }

            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("You are Win !");
                System.out.println(this.getObstacle().getAward()+" You made money.");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Current Balance : "+this.getPlayer().getMoney());
            }else{
                return false;
            }
        }

        return true;
    }
    public void afterHit(){

        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Health : "+this.getObstacle().getHealth());
    }





    public void playerStats(){

        System.out.println("Player Status");
        System.out.println("---------------------------");
        System.out.println(" Health : "+this.getPlayer().getHealth());
        System.out.println(" Damage : "+this.getPlayer().getTotalDamage());
        System.out.println(" Money : "+this.getPlayer().getMoney());
        System.out.println(" Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println(" Armor : "+this.getPlayer().getInventory().getArmor().getName());


    }

    public void obsatcleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" Stats");
        System.out.println("----------------------------");
        System.out.println(" Health : "+this.getObstacle().getHealth());
        System.out.println(" Damage : "+this.getObstacle().getDamage());
        System.out.println(" Award : "+this.getObstacle().getAward());
    }


    public int randomObstacleNumber(){

        Random r = new Random();
        return r.nextInt(getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
