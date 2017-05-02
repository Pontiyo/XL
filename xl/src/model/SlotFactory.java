package model;


import expr.Expr;
import expr.ExprParser;
import util.XLException;

public class SlotFactory {
	
	public Slot createSlot(String input){
		if(input.charAt(0) == '#'){
			return createCommentSlot(input);
		}
		else{
			return createExprSlot(input);
		}
	}
	
	private ExprParser parser = new ExprParser();
	
	private Slot createExprSlot(String input){
		Expr expr = null;
		try{
		expr = parser.build(input);
		return new ExpressionSlot(expr);
		} catch (Exception e){}
		throw new XLException("Input Error");
	}
	
	private Slot createCommentSlot(String input){
		return new CommentSlot(input);
	}
}
