package gui;

import java.awt.Color;
import java.util.Observable;

import model.Sheet;

public class CurrentSlot extends Observable{
private SlotLabel slot;
private Sheet sheet;

public void set(SlotLabel sl, Sheet sheet){
	slot = sl;
	this.sheet = sheet;
	notifyObservers();
	addObserver(sl);
}

public void setColor(Color color){
	slot.setBackground(color);
}

public String getAddress(){
	return slot.getAddress();
}
@Override
public void notifyObservers(){
	setChanged();
	super.notifyObservers();
}

}
