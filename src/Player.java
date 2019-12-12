import java.util.*;
import java.io.*;

public class Player{
    private int id;
    private String name;
    private int totalScore;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        this.totalScore =0;
    }

    public void increaseScore(int points) {
        this.totalScore+=points;
    }

    public int getId(){
        return this.id;
    }

    public String getName()
	{
		return this.name;
	}
	
	public int getScore()
	{
		return this.totalScore;
	}
}