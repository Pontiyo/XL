package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import expr.Environment;
import gui.SlotLabels;
import gui.menu.XLBufferedReader;
import gui.menu.XLPrintStream;
import util.XLException;

public class Sheet extends Observable implements Environment{
	SlotFactory factory;
	Map<String, Slot> sheet;
	SlotLabels sl;

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
	setChanged();
}

@Override
public double value(String address) {
	Slot slot = sheet.get(address);
	if (slot == null) {
		throw new XLException("Empty Slot: " + address);
	}
	return slot.getValue(this);
}

public String getString(String address){
	if (sheet.get(address) == null){
		return "";
	} else if (sheet.get(address) instanceof CommentSlot) {
		Slot slot = sheet.get(address);
		return slot.toString();
	}
	Slot slot = sheet.get(address);
	return String.valueOf(sheet.get(address).getValue(this));
}

public void clearSlot(String address){
	//Slot slot = sheet.get(address);
	sheet.remove(address);
	notifyObservers();
}

public void clearSheet(){
	sheet.clear();
	notifyObservers();
}

public void addSL(SlotLabels sl){
	this.sl = sl;
}
	
public void saveToFile(String filename)throws FileNotFoundException{
	XLPrintStream save = new XLPrintStream(filename);
}

public void readFromFile(String filename)throws FileNotFoundException{
	XLBufferedReader load = new XLBufferedReader(filename);
}


}
