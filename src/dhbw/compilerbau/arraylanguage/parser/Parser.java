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
	
	protected Tree parseToken(TokenType tokenType)
	{
		int tokenPosition = getTokenStreamPosition();
		Token nextToken = nextToken();
		
		if(nextToken.getType() == tokenType)
			return new Tree(nextToken);
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected int getTokenStreamPosition()
	{
		return tokenStreamPosition;
	}
	
	protected void resetTokenStreamToPosition(int position)
	{
		this.tokenStreamPosition = position;
	}
	
	public Tree parse()
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
	
	protected Tree parseAS()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree nodeA,nodeB,nodeC,nodeD;
		
		if((nodeA = parseLBR()) != null && (nodeB = parseElement()) != null && (nodeC = parseElements()) != null && (nodeD = parseRBR()) != null)
		{
			Tree as = new Tree(new Token(TokenType.AS,""));
			as.addChild(nodeA);
			as.addChild(nodeB);
			as.addChild(nodeC);
			as.addChild(nodeD);
			
			return as;
		}
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseElements()
	{	
		Tree elements = new Tree(new Token(TokenType.ELEMENTS,""));
		Tree node;
		
		while((node = parseElementAndComma()) != null)
		{
			elements.addChild(node);
		}
		
		return elements;
	}
	
	protected Tree parseElementAndComma()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree nodeA,nodeB;
		
		if((nodeA = parseComma()) != null && (nodeB = parseElement()) != null)
		{
			Tree element = new Tree(new Token(TokenType.COMMA_AND_ELEMENT,""));
			element.addChild(nodeA);
			element.addChild(nodeB);
			return element;
		}	
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseElement()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		//TODO
		if((node = parseRange()) != null)
		{
			Tree element = new Tree(new Token(TokenType.ELEMENT,""));
			element.addChild(node);
			return element;
		}
		if((node = parseInteger()) != null)
		{
			Tree element = new Tree(new Token(TokenType.ELEMENT,""));
			element.addChild(node);
			return element;
		}	
		if((node = parseFloat()) != null)
		{
			Tree element = new Tree(new Token(TokenType.ELEMENT,""));
			element.addChild(node);
			return element;
		}
		if((node = parseString()) != null)
		{
			Tree element = new Tree(new Token(TokenType.ELEMENT,""));
			element.addChild(node);
			return element;
		}
		if((node = parseNull()) != null)
		{
			Tree element = new Tree(new Token(TokenType.ELEMENT,""));
			element.addChild(node);
			return element;
		}
		
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseInteger()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		if((node = parseToken(TokenType.INTEGER)) != null)
			return node;
					
		resetTokenStreamToPosition(tokenPosition);
		return node;
	}
	
	protected Tree parseString()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		if((node = parseToken(TokenType.STRING)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return node;
	}
	
	protected Tree parseFloat()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		if((node = parseToken(TokenType.FLOAT)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return node;
	}
	
	protected Tree parseRange()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree nodeA,nodeB,nodeC;
		
		if((nodeA = parseInteger()) != null && (nodeB = parseRangeSymbol()) != null  && (nodeC = parseInteger()) != null)
			{
				Tree tree = new Tree(new Token(TokenType.RANGESPAN,""));
				tree.addChild(nodeA);
				tree.addChild(nodeB);
				tree.addChild(nodeC);
				
				return tree;
			}
		
		if((nodeA = parseFloat()) != null && (nodeB = parseRangeSymbol()) != null && (nodeC = parseFloat()) != null)
		{
			Tree tree = new Tree(new Token(TokenType.RANGESPAN,""));
			tree.addChild(nodeA);
			tree.addChild(nodeB);
			tree.addChild(nodeC);
			
			return tree;
		}
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseRangeSymbol()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		
		if((node = parseToken(TokenType.RANGE)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return node;
	}
	
	protected Tree parseLBR()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		if((node = parseToken(TokenType.LBR)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseNull()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		if((node = parseToken(TokenType.NULL)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseRBR()
	{
		int tokenPosition = getTokenStreamPosition();
		
		Tree node;
		if((node = parseToken(TokenType.RBR)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	protected Tree parseComma()
	{
		int tokenPosition = getTokenStreamPosition();
		Tree node;
		
		if((node = parseToken(TokenType.COMMA)) != null)
			return node;
		
		resetTokenStreamToPosition(tokenPosition);
		return null;
	}
	
	

}
