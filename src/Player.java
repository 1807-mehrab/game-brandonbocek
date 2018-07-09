import java.util.Random;

public class Player {

	private String name = "";
	private boolean isAlive = true;
	private boolean isSick = false;
	private int health = 0;
	private int food = 0;
	private int ammo = 0;
	private int water = 0;
	
	public Player(String name){
		this.name = name;
		isAlive = true;
		health = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	
	public void shootAnAnimal(){
		this.ammo--;
		Random rand = new Random();
		if(rand.nextInt(2) == 1){
			System.out.println(name + " got some food!");
			this.food++;
		}else{
			System.out.println(name + " missed their shot");
		}
	}
	
	public void takeRest(){
		if(health < 100 && isAlive){
			health++;
		}
		
		Random rand = new Random();
		
		if(isSick && (rand.nextInt(10) == 1)){
			isSick = false;
			System.out.println(name + " is no longer sick.");
		}
	}
	
	public void timePassesToHurtPlayer(){
		if(food <= 0){
			health--;
		}else{
			food--;
		}
		if(water <= 0){
			health--;
		}else{
			water--;
		}
		if(isSick){
			health -= 3;
		}
		if(health <= 0){
			isAlive = false;
			System.out.println(name + " has died.");
		}
		Random rand = new Random();
		if(rand.nextInt(health) < 7){
			isSick = true;
			System.out.println(name + " is sick.");
		}
		
	}
	
	public void giveFood(){
		food++;
	}
	public void giveWater(){
		water++;
	}
	public void giveAmmo(){
		ammo++;
	}
}
