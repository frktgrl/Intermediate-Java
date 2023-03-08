public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House.");
        System.out.println("Health renewed.");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }
}
