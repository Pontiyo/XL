package model;

import expr.Environment;
import util.XLException;

public class ExceptionSlot implements Slot{

	@Override
	public double getValue(Environment e) {
		throw new XLException("Circular Exception");
	}

	@Override
	public String toString(Environment e) {
		throw new XLException("Circular Exception");
	}

	@Override
	public String input(Environment e) {
		throw new XLException("Circular Exception");
	}
	

}
