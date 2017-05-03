package gui.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import gui.SlotLabels;
import model.Slot;
import model.SlotFactory;
import util.XLException;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    
    public void load(Map<String, Slot> sheet) {
    	SlotFactory fac = new SlotFactory();
        try {
            while (ready()) {
                String string[] = readLine().split("=");
                String address = string[0];
                Slot slot = fac.createSlot(string[1]);  
                sheet.put(address, slot);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
