package orig2011.v6;

import java.beans.PropertyChangeListener;

/**
 * A interface for the observable GameModels.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.0
 */
public interface IObservable {
	
	/**
	 * Adds a observer that will listen after when it's
	 * time to update the GameView.
	 * @param observer The observer that will listen.
	 */
	public void addObserver(PropertyChangeListener observer);
	
	/**
	 * Removes a observer that would listen after when
	 * it's time to update the GameView.
	 * @param observer The observer to remove.
	 */
	public void removeObserver(PropertyChangeListener observer);

}
