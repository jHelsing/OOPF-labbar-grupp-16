package orig2011.v6;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReversiScoreView implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("sadsa");
		if((evt.getSource()) instanceof ReversiModel) {
			ReversiModel temp =  (ReversiModel) evt.getSource();
			int blackscore = temp.getBlackScore();
			int whitescore = temp.getWhiteScore();
			
			System.out.println("------------------------");
			System.out.println("Player Turn: " + temp.getTurnColor());
			System.out.println("Black Score: " + blackscore);
			System.out.println("White Score: " + whitescore);
			System.out.println("------------------------");
			
			
			
		}
		
	}
	
}
