import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private String location = "";
	private int distanceTravelled = 0;
	private int weight;
	private boolean isOngoing = true;
	private ArrayList<Player> players;
	
	public Game(){
		players = new ArrayList<Player>();
		location = "Boston";
	}

	public String getLocation() {
		return location;
	}
	
	public String getLocationFromDistance() {
		switch(distanceTravelled){
		case 0: 
			return "Boston";
		case 5:
			return "Hartford";
		case 10:
			return "New York City";
		case 18:
			return "Philly";
		case 30:
			return "Pittsburgh";
		case 35:
			return "Columbus";
		case 40:
			return "Indianapolis";
		case 48:
			return "St. Louis";
		case 59:
			return "Kansas City";
		case 70: 
			return "Denver";
		case 90:
			return "Salt Lake City";
		case 110:
			return "Las Vegas";
		case 120:
			return "Los Angeles";
		default:
			return "(Road)";
		}
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	
	public void iterateDistanceTravelled(){
		this.distanceTravelled++;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public int getWeight(){
		int sum = 0;
		for(Player p: players){
			sum += p.getFood() + p.getWater() + p.getAmmo();
		}
		
		return sum;
	}
	
	public boolean isOver(){
		if(!isOngoing){
			return true;
		}
		return (distanceTravelled >= 120);
	}
	
	public void getNumPlayersInput(){
		Scanner scan = new Scanner(System.in);
		System.out.println("How many players will be playing? (1-5)");
		String tempName = "";
		int numPlayers = scan.nextInt();
		for(int i=0; i<numPlayers; i++){
			System.out.print("Enter the name of player " + (i+1)+ ": ");
			tempName = scan.next();
			System.out.println();
			players.add(new Player(tempName));
		}
		//scan.close();
	}
	
	public void getSuppliesInput(){
		Scanner scan = new Scanner(System.in);
		System.out.println("How much food do you want to buy? (1-1000)");
		int numFood = scan.nextInt();
		for(int i=0; i<numFood; i++){
			for(Player p: players){
				p.giveFood();
				numFood--;
			}
		}
		
		System.out.println("How much water do you want to buy? (1-1000)");
		int numWater = scan.nextInt();
		for(int i=0; i<numWater; i++){
			for(Player p: players){
				p.giveWater();
				numWater--;
			}
		}
		
		System.out.println("How much ammo do you want to buy? (1-1000)");
		int numAmmo = scan.nextInt();
		for(int i=0; i<numAmmo; i++){
			for(Player p: players){
				p.giveAmmo();
				numAmmo--;
			}
		}
		//scan.close();
	}
	
	public void takeATurn(String input) {
		
		switch(input){
		case "help":
			System.out.println("(any input) to walk forward toward LA");
			System.out.println("'hunt' to hunt for food");
			System.out.println("'rest' to stop and rest");
			System.out.println("'quit' to quit the game");
			break;
		case "hunt":
			hunt();
			break;
		case "rest":
			takeRest();
			break;
		case "quit":
			isOngoing = false;
			break;
		default:
			iterateDistanceTravelled();
			break;
		}
		
	}
	
	public void hunt(){
		for(Player p : players){
			if(p.getAmmo() > 0 && p.isAlive()){
				p.shootAnAnimal();
				break;
			}
		}
	}
	
	public void takeRest(){
		for(Player p: players){
			p.takeRest();
		}
	}
	
}
