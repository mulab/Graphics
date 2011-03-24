package com.wolfram.mexprparser;

import com.wolfram.mexpr.IMExprToken;

public interface ErrorListener {
	// ERROR_HANDLING: added this
	// TODO: this should allow for some kind of Error type
	public void errorHappened(String description, String tokenText, int type, IMExprToken start, IMExprToken end);
	
}
