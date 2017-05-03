package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;

public class SlotLabels extends GridPanel implements Observer{
    private List<SlotLabel> labelList;
    CurrentSlot cs;
    Sheet sheet;

    public SlotLabels(int rows, int cols, CurrentSlot cs, Sheet sheet, StatusLabel sl) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	String address = ch + Integer.toString(row);
                SlotLabel label = new SlotLabel(sl, cs, sheet,address);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        cs.set(firstLabel,sheet);
        this.cs = cs;
        this.sheet = sheet;
        sheet.addObserver(this);
    }

    @Override
	public void update(Observable o, Object arg) {
		Iterator itr = labelList.iterator();
		while (itr.hasNext()){
		cs.set((SlotLabel)itr.next(), sheet);
		}
		cs.set(labelList.get(0),sheet);
	}

}
