package dhbw.compilerbau.arraylanguage.parser;

import java.util.ArrayList;

import dhbw.compilerbau.arraylanguage.scanner.Token;

public class Tree 
{
	protected Token nodeToken;
	
	protected ArrayList<Tree> children;
	
	public Tree(Token token)
	{
		this.nodeToken = token;
		this.children = new ArrayList<Tree>();
	}
	
	public void addChild(Tree child)
	{
		this.children.add(child);
	}
	
	public Token getNode()
	{
		return this.nodeToken;
	}
	
	public ArrayList<Tree> getChildren()
	{
		return this.children;
	}
	
	public String toGraphvizDotEdge(Tree parent)
	{

		return parent.getNode().hashCode()+"->"+this.getNode().hashCode()+";\n";

	}
	
	public static String toGraphvizDotString(Tree tree, Tree parent)
	{
		String output = "";
		
		output += tree.toGraphvizDotEdge();
		
		for()
	}
}
