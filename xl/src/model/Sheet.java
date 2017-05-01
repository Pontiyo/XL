package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import expr.Environment;
import gui.menu.XLBufferedReader;
import gui.menu.XLPrintStream;

public class Sheet extends Observable implements Environment{
	SlotFactory factory;
	Map<String, Slot> sheet;

public Sheet(){
	 sheet = new HashMap<String, Slot>();
	 factory = new SlotFactory();
}
	
public Sheet(HashMap<String,Slot> sheet){
	this.sheet = sheet;
}

public void setSlot(String address, String txt){
	Slot slot = factory.createSlot(txt);
	sheet.put(address, slot);
	notifyObservers();
}

@Override
public double value(String address) {
	Slot slot = sheet.get(address);
	return slot.getValue(this);
}

public String slotString(String address){
	Slot slot = sheet.get(address);
	return slot.toString();
}

public void clearSlot(String address){
	Slot slot = sheet.get(address);
	sheet.remove(address);
	notifyObservers();
}

public void clearSheet(){
	sheet.clear();
	notifyObservers();
}
	
public void saveToFile(String filename)throws FileNotFoundException{
	XLPrintStream save = new XLPrintStream(filename);
}

public void readFromFile(String filename)throws FileNotFoundException{
	XLBufferedReader load = new XLBufferedReader(filename);
}


}
