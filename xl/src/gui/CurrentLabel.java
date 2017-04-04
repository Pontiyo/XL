package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Slot;

public class CurrentLabel extends ColoredLabel implements Observer{
	Slot currentslot;
    public CurrentLabel() {
        super("A1", Color.WHITE);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}