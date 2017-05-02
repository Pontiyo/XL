package gui;

import java.awt.Color;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer{
	private String address;
	private CurrentSlot cs;
	private Sheet sheet;
	private Handler h;
	
    public SlotLabel(CurrentSlot cs, Sheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
    }

	@Override
	public void update(Observable o, Object arg) {
		String str = sheet.slotString(address);
		this.setText(str);
	}

	private class Handler extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent arg0) {
		cs.setColor(Color.WHITE);
		}
	
	}

}