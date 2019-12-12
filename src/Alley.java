import java.util.*;
import java.io.*;

public class Alley{
    private List<Lane> lanes = new LinkedList<Lane> ();

    private HashMap<Lane, String> bookedLanes = new HashMap<Lane, String>();
    
    public Alley(){
        try{
            String line;
            
//            Map<Integer,Integer> laneIdToPlayerMap = new HashMap<>();
//            laneIdToPlayerMap.put(1234,4);
//            laneIdToPlayerMap.put(1231,3);
//            laneIdToPlayerMap.put(123,4);
            //BufferedReader br = new BufferedReader(new FileReader(new File("lanes.txt")));
//            while((line = br.readLine()) != null){
//                String[] buffer = line.split(":");
//
//                int id = Integer.parseInt(buffer[0]);
//                int numOfPlayers = Integer.parseInt(buffer[1]);
//
//                lanes.add(new Lane(id, numOfPlayers));
//            }
            
            for (int i = 0; i<3; i++) {
            	lanes.add(new Lane(5000+i, i+3));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public Lane getLaneById(int id) throws GameException{
        Boolean isPresent = false;

        Lane lane = null;
        for (Lane laneNow: lanes){
            if(laneNow.getId() == id){
                lane = laneNow;
                isPresent = true;
            }
        }

        if (!isPresent){
            throw new GameException("Invalid lane id");
        }

        return lane;
    }

    public void printLanes()
	{
		for (Iterator<Lane> iterator = lanes.iterator(); iterator.hasNext(); ) {
			Lane lane = (Lane)iterator.next();
			System.out.println(lane.getId() + "  " + lane.getMaxPlayers());
		}
    }
    
    public Boolean reserveLane(int laneId, String token) throws GameException{
        boolean isPresent = false;

        Lane lane = null;

        for (Iterator<Lane> iterator = lanes.iterator(); iterator.hasNext(); ) {
			lane = (Lane)iterator.next();
			if ( lane.getId() == laneId ) {
				isPresent = true;
				break;
			}
        }
        
        if(!isPresent){
            throw new GameException("Invalid lane id");	
        }

        if (bookedLanes.containsKey(lane)) {
            throw new GameException("Lane with id is already booked.");    
        }
        bookedLanes.put(lane, token);
        return true;
    }

}