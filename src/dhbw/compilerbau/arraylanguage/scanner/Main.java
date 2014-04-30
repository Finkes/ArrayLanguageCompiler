package dhbw.compilerbau.arraylanguage.scanner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	{
		 InputStream stream = new ByteArrayInputStream("[1...a,1.0^223,12,12,1as1,12.12..12.12,null,..,NULL,12..12.....]".getBytes());

	        Scanner scanner = new Scanner(stream);

	        ArrayList<Token> tokens = new ArrayList<Token>();

	        Token token;

	        try {
	            while ((token = scanner.getNextToken()) != null)
	            {
	                System.out.print(token.toString()+" ");
	                tokens.add(token);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
