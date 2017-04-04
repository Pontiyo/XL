package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;

public class SlotFactory {
	
	public Slot createSlot(String input){
		if(input.charAt(0) == '#'){
			return createExprSlot(input);
		}
		else{
			return createCommentSlot(input);
		}
	}
	
	private ExprParser parser = new ExprParser();
	private Slot createExprSlot(String input){
		Expr expr = null;
		try{
		expr = parser.build(input);
		} catch (IOException e){}
		return new ExpressionSlot(expr);
	}
	
	private Slot createCommentSlot(String input){
		return new CommentSlot(input);
	}
}
