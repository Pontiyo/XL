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

public void setSlot(String address, String input){
	Slot slot = factory.createSlot(input);
	if(input.isEmpty()){
		sheet.remove(address);
	} else {
	circularCheck(address,slot);
	sheet.put(address, slot);
	}
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
	} 
	Slot slot = sheet.get(address);
	return slot.toString(this);
}

public void circularCheck(String address, Slot slot){
	Slot temp = sheet.get(address);
	sheet.put(address, new ExceptionSlot());
	try {
		slot.getValue(this);
		sheet.put(address, temp);
	} catch (XLException e){
		sheet.put(address, temp);
		throw new XLException("Circular Error");
	}
}

public void clearSlot(String address){
	//Slot slot = sheet.get(address);
	sheet.remove(address);
	notifyObservers();
	setChanged();
}

public void clearSheet(){
	sheet.clear();
	notifyObservers();
	setChanged();
}


	
public void saveToFile(String filename)throws FileNotFoundException{
	XLPrintStream save = new XLPrintStream(filename);
}

public void readFromFile(String filename)throws FileNotFoundException{
	XLBufferedReader load = new XLBufferedReader(filename);
}


}
