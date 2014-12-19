package orig2011.v6;

/**
 * A simple class for displaying player turn and score of a Reversi-Game. 
 * 
 * @author Tobias Alldén
 * @author Jonathan Helsing
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReversiScoreView implements PropertyChangeListener {

	
	/**
	 * {@inheritDoc}
	 * 
	 * Checks id evt is a ReversiModel and the keyWord is "Played",in that case, print out turn and score
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if((evt.getSource()) instanceof ReversiModel) {
			//To stop from writing out score every time board is drawn, check for "played" keyword
			if(evt.getPropertyName() == "Played") {
			ReversiModel temp =  (ReversiModel) evt.getSource();
			int blackscore = temp.getBlackScore();
			int whitescore = temp.getWhiteScore();
			
			System.out.println("Player Turn: " + temp.getTurnColor());
			System.out.println("Black Score: " + blackscore);
			System.out.println("White Score: " + whitescore);
			System.out.println("");
			}
			
			
			
		}
		
	}
	
}
