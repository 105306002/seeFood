import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
    public WebNode root;
    
    public WebTree(WebPage rootPage){
    	this.root = new WebNode(rootPage);
    }
    //recursive
    public double setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
    	setPostOrderScore(root, keywords);
    	return root.nodeScore;
    }
    
    private double setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords)throws IOException{
    	for(WebNode child : startNode.children){
    		setPostOrderScore(child, keywords);
    	}
    	
    	startNode.setNodeScore(keywords);
    	return root.nodeScore;
    }
    
    public void eularPrintTree(){
    	eularPrintTree(root);
    }
    
    private void eularPrintTree(WebNode startNode){

    	
    	

    	System.out.print("(");

    	System.out.println(startNode.webPage.name + "," + Math.round(startNode.nodeScore * 100.00) / 100.00 + "," + startNode.webPage.URL);

       	System.out.print(")");


    	System.out.println();

    }
    
    
}
