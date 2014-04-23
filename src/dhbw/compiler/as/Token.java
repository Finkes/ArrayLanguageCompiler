package dhbw.compiler.as;
/**
 * Created by dominik on 08/04/14.
 */
public class Token {
    public enum TokenType
    {
        WS,
        LBR,
        RBR,
        STRING,
        INTEGER,
        FLOAT,
        COMMA,
        NULL,
        EOF,
        RANGE,
        INVALID
    }

    private TokenType type;
    private String data;
    private int symbol;
    private int sourceRow;
    private int sourceColumn;

    public Token(TokenType type, String data)
    {
        this.data = data;
        //this.symbol = SymbolTable.getInstance().put(data);
        this.type = type;
        //this.sourcePosition = sourcePosition;
    }
    
    public Token(TokenType type, String data, int row, int column)
    {
    	this.type = type;
    	this.data = data;
    }

    public String getData() {
        return data;
    }

    public TokenType getType() {
        return type;
    }
/*
    @Override
    public String toString() {
        return "<"+type.toString()+">";
    }
*/
    @Override
    public String toString() {
        return type.toString();
    }
}


