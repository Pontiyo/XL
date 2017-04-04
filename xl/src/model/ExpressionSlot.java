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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

}
