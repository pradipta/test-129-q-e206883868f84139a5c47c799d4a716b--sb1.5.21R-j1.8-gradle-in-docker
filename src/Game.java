import java.util.*;
import java.io.*;

public class Game{
    private Lane lane;
    private List<Player> players;

    private static final int numOfSets = 10;
    private static final int chances = 2;

    private int setCounter = 0;

    public Game(Lane lane, List<Player> players){
        this.lane = lane;
        this.players = players;
    }

    public void begin(){
        while (setCounter<numOfSets){
            for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();){
                Player nowPlaying = (Player)iterator.next();

                int standingPins =  10;
                int downPins = 0;

                for (int i = 0; i<chances; i++){
                    int pinDown = shot(standingPins);
                    downPins+=pinDown;
                    standingPins-=pinDown;

                    //TODO: check for0
                    if(i==0 && downPins == 10){
                        //All down case
                        System.out.println("All down in first chance by player "+nowPlaying.getName());
                        nowPlaying.increaseScore(20);
                        standingPins = 10;
                    }else if(i == 1 && standingPins == 0){
                        //all down in second throw
                        System.out.println("All down in second chance by player "+nowPlaying.getName());
                        nowPlaying.increaseScore(downPins+5);
                    }else{
                        System.out.println(nowPlaying.getName()+" scored "+downPins);
                        nowPlaying.increaseScore(downPins);
                    }
                }
            }
            setCounter++;
        }
    }


    public void getWinner(){
        int maxScore = -1;
        int score;
		String name = null;
		for ( Player player : players )
		{
			score = player.getScore();
			if ( score > maxScore )
			{
				maxScore = player.getScore();
				name = player.getName();
			}
		}
		System.out.println("The winner is: "+name);
    }

    private int shot(int standingPins)
	{
		return (int)(Math.random() * ((standingPins - 0) + 1));
	}

}