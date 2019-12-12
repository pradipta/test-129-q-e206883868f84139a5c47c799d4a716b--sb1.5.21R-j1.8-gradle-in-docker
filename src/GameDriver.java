import java.util.*;
import java.io.*;
import java.lang.*;

public class GameDriver{
    public static void main(String[] args){
        Alley alley = new Alley();
        Lane lane = null;

        boolean booked = false;

        while(!booked){

            try {
                Scanner scanner = new Scanner(System.in);
                //TODO Token token = Token.id1;
                
                alley.printLanes();

                System.out.println("Choose the lane id:");
                int laneId = scanner.nextInt();

                lane = alley.getLaneById(laneId);

                booked = alley.reserveLane(laneId, "id1");
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e);
            }

            System.out.println("Enter player details.");
		    ArrayList<Player> players = GameDriver.getPlayers();
		    Game game = new Game(lane, players);
		    game.begin();;
            game.getWinner();
            
        }
    }

    private static ArrayList<Player> getPlayers()
    {
        ArrayList<Player> players = new ArrayList<Player>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter num of players: ");
		int numOfPlayers = scanner.nextInt();
		scanner.nextLine();
		
		for ( int i = 0; i < numOfPlayers; i++ )
		{
			System.out.println("Player name? ");
			String name = scanner.nextLine();
			
			players.add(new Player(1111+i, name));
		}
		
		return players;	
    }
}