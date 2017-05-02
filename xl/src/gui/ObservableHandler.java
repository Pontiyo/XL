package gui;

import java.util.Observable;

public class ObservableHandler extends Observable{
	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}
