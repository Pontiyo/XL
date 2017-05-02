package model;

import expr.Environment;
import util.XLException;

public class CommentSlot implements Slot{
	private String comment;

	CommentSlot(String comment){
		this.comment = comment;
	}
	
	@Override
	public double getValue(Environment e) {
		return 0;
	}

	@Override
	public String toString(Environment e) {
		return comment.substring(1);
	}

	@Override
	public String input(Environment e) {
		return comment;
	}
	
	

}
