package dhbw.compilerbau.arraylanguage.parser;

import java.util.ArrayList;

import dhbw.compilerbau.arraylanguage.scanner.Token;
import dhbw.compilerbau.arraylanguage.scanner.Token.TokenType;

public class Parser 
{
	protected ArrayList<Token> tokens;
	
	protected int tokenStreamPosition;
	
	
	public Parser(ArrayList<Token> tokens)
	{
		this.tokens = tokens;
	}
	
	protected Token nextToken()
	{
		int currentToken = tokenStreamPosition;
		tokenStreamPosition++;
		
		return this.tokens.get(currentToken);
	}
	
	protected boolean parseToken(TokenType tokenType)
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(nextToken().getType() == tokenType)
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected int getTokenStreamPosition()
	{
		return tokenStreamPosition;
	}
	
	protected void resetTokenStreamToPosition(int position)
	{
		this.tokenStreamPosition = position;
	}
	
	public boolean parse()
	{
		return parseAS();
	}
	
	//template for a function
	protected boolean parseTemplate()
	{
		int tokenPosition = getTokenStreamPosition();
		
		//TODO
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseAS()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseLBR() && parseElement() && parseElements() && parseRBR())
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseElements()
	{	
		while(parseElementAndComma())
		{}
		
		return true;
	}
	
	protected boolean parseElementAndComma()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseComma() && parseElement())
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseElement()
	{
		int tokenPosition = getTokenStreamPosition();
		
		//TODO
		if(parseRange())
			return true;
		if(parseInteger())
			return true;
		if(parseFloat())
			return true;
		if(parseString())
			return true;
		if(parseNull())
			return true;
		
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseInteger()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.INTEGER))
			return true;
					
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseString()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.STRING))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseFloat()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.FLOAT))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseRange()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseInteger() && parseRangeSymbol() && parseInteger())
			return true;
		
		if(parseFloat() && parseRangeSymbol() && parseFloat())
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseRangeSymbol()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.RANGE))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseLBR()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.LBR))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseNull()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.NULL))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseRBR()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.RBR))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	protected boolean parseComma()
	{
		int tokenPosition = getTokenStreamPosition();
		
		if(parseToken(TokenType.COMMA))
			return true;
		
		resetTokenStreamToPosition(tokenPosition);
		return false;
	}
	
	

}
