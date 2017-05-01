package gui;

import java.awt.Color;
import java.util.Observable;

public class CurrentSlot extends Observable{
private SlotLabel slot;

public void set(SlotLabel sl){
	slot = sl;
	notifyObservers();
	addObserver(sl);
}

public void setColor(Color color){
	slot.setBackground(color);
}


}
