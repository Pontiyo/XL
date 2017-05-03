package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import expr.Environment;
import gui.CurrentSlot;
import gui.SlotLabels;
import gui.menu.XLBufferedReader;
import gui.menu.XLPrintStream;
import util.XLException;

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

public void setSlot(String address, String input){
	Slot slot = factory.createSlot(input);
	if(input.isEmpty()){
		clearSlot(address);
	} else if (slot.toString(this) == null){
		throw new XLException("Empty Slot Error");
	} else {
	circularCheck(address,slot);
	sheet.put(address, slot);
	
	}
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
	removeCircularCheck(address);
	sheet.remove(address);
}

public void removeCircularCheck(String address){
	Slot slot = sheet.get(address);
	ExceptionSlot es = new ExceptionSlot();
	sheet.put(address,es);
	Iterator itr = sheet.values().iterator();
		while (itr.hasNext()){
		try {
			Slot test = (Slot) itr.next();
			if(test != es) {
				test.getValue(this);
				}
		} catch (XLException e){
		sheet.put(address, slot);
		throw new XLException("Circular Error");
	}
		}
}
@Override
public double value(String address) {
	Slot slot = sheet.get(address);
	if (slot == null) {
		throw new XLException("Empty Slot Error");
	}
	return slot.getValue(this);
}

public String getString(String address){
	if (sheet.get(address) == null){
		return "";
	} 
	return sheet.get(address).toString(this);
}

public String getInput(String address){
	if (sheet.get(address) == null){
		return "";
	} 
	return sheet.get(address).input();
}


public void clearSheet(){
	sheet.clear();
}
	
@Override
public void notifyObservers() {
	setChanged();
	super.notifyObservers();
}

public void saveToFile(String filename)throws FileNotFoundException{
	XLPrintStream save = new XLPrintStream(filename);
	save.save(sheet.entrySet());
}

public void readFromFile(String filename)throws FileNotFoundException{
	XLBufferedReader load = new XLBufferedReader(filename);
	clearSheet();
	load.load(sheet);
	notifyObservers();
}


}
