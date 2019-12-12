import java.util.*;
import java.io.*;

public class Lane{
    private int id;
    private int numOfPlayers;
    private int maxPlayers;

    public Lane(int id, int numOfPlayers){
        this.id = id;
        this.numOfPlayers = numOfPlayers;
        this.maxPlayers = 10;
    }

    public void setNumOfPlayers(int numOfPlayers) throws GameException{
        if (numOfPlayers>maxPlayers){
            throw new GameException ("Maximum number of players = "+this.maxPlayers);
        }
        this.numOfPlayers = numOfPlayers;
    }

    public int getId() {
		return this.id;
	}
	
	public int getMaxPlayers() {
		return this.maxPlayers;
	}
	
	public int getNumOfPlayers() {
		return this.numOfPlayers;
	}
}