package dhbw.compilerbau.arraylanguage.scanner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import dhbw.compilerbau.arraylanguage.parser.Parser;

public class Main {

	public static void main(String[] args)
	{
		    InputStream stream = new ByteArrayInputStream("[12,12,12.0,12.0,test,asjdhk,12..12,12.0..12.0]".getBytes());

		    //InputStream stream = new ByteArrayInputStream("[,1.0^223,12,12,12.12..12..12,null,NULL]".getBytes());

		    
	        Scanner scanner = new Scanner(stream);

	        ArrayList<Token> tokens = new ArrayList<Token>();

	        Token token;

	        try 
	        {
	            while ((token = scanner.getNextToken()) != null)
	            {
	                System.out.print(token.toString()+" ");
	                tokens.add(token);
	            }
	            System.out.println("");
	            System.out.println("starting parser...");
	            
	            //start parsing
	            Parser parser = new Parser(tokens);
	            
	            if(parser.parse())
	            	System.out.println("parsed successfull");
	            else
	            	System.out.println("parsed with failure");
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
