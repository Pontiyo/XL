package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentSlot cs, Sheet sheet, StatusLabel statl) {
    	SlotLabels sl = new SlotLabels(rows, columns, cs, sheet, statl);
        add(WEST, new RowLabels(rows));
        add(CENTER, sl);
       // sheet.addSL(sl);
    }
}