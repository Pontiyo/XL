package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import expr.Environment;

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

@Override
public double value(String name) {
	// TODO Auto-generated method stub
	return 0;
}

public void clearSheet(){
	
}
	
public void saveToFile(String filename){
	
}

public void readFromFile(String filename){
	
}


}
