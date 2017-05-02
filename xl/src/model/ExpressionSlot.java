package model;

import expr.Environment;
import expr.Expr;

public class ExpressionSlot implements Slot{
	private Expr expr;
	
	ExpressionSlot(Expr expr){
		this.expr = expr;
	}

	@Override
	public double getValue(Environment e) {
		return expr.value(e);
	}

	@Override
	public String toString(Environment e) {
		return String.valueOf(getValue(e));
	}

}
