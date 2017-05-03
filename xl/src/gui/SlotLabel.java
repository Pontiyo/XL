package gui;

import java.awt.Color;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer{
	private String address;
	private CurrentSlot cs;
	private StatusLabel sl;
	private Sheet sheet;
	private Handler h = new Handler();
	
    public SlotLabel(StatusLabel sl, CurrentSlot cs, Sheet sheet, String address) {
        super("                    ", Color.WHITE, RIGHT);
        this.sheet = sheet;
        this.address = address;
        this.cs = cs;
        this.sl = sl;
        addMouseListener(h);
    }

	@Override
	public void update(Observable o, Object arg) {
		String str = sheet.getString(address);
		this.setText(str);
	}
	
	public String getAddress(){
		return address;
	}
	
	private class Handler extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent arg0) {
		cs.setColor(Color.WHITE);
		setBackground(Color.YELLOW);
		cs.set(SlotLabel.this,sheet);
		cs.notifyObservers();
		sl.clear();
		}
	}

}