import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		
		Game game = new Game();
		game.getNumPlayersInput();
		game.getSuppliesInput();
		
		while(!game.isOver()){
			Scanner scan = new Scanner(System.in);
			System.out.println("Take a turn (type 'help' for options)");
			String input = scan.nextLine();
			if(!game.getLocationFromDistance().equals("(Road)"))
				System.out.println("Welcome to " + game.getLocationFromDistance());
			game.takeATurn(input);
		}
		
		
		System.out.println("Game Over");
	}
	
}
