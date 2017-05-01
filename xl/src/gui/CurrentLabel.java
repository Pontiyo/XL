package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Slot;

public class CurrentLabel extends ColoredLabel implements Observer{
	CurrentSlot cs;

    public CurrentLabel(CurrentSlot cs) {
        super("A1", Color.WHITE);
        this.cs = cs;
        cs.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		setText(cs.toString());
		
	}
}