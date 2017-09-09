
package supstats.Game_Stats;

import java.util.ArrayList;


public class Player {
    String Tag1;
    String Tag2;
    ArrayList<Stock> Play = new ArrayList<>();
    Player(){
 
    }
    public String getDiedTo(int i){
    
        Stock s = Play.get(i);
        return s.DiedTo;
    
}
    public String getPercent(int i){
    Stock s = Play.get(i);
    return s.Percent;
    }
    
    public String getNote(int i){
    Stock s = Play.get(i);
    return s.Note;
    
    }
    public void addStocks(String DiedTo, String Percent, String Notes){
    Play.add(new Stock(DiedTo,Percent,Notes));
    }
}

