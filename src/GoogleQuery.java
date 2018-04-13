import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

////test
public class GoogleQuery{
    public String searchKeyword;
	public String url;
	public String content;

	private ArrayList<Keyword> keywords;
	public ArrayList<Rerank> origin = new ArrayList<Rerank>();
	
	public HashMap<String, String> retVal = new HashMap<String, String>();

	    
	public GoogleQuery(String searchKeyword){
    	
		this.searchKeyword = searchKeyword;
<<<<<<< .mine
	    this.url = "https://www.google.com/search?q=" + searchKeyword +"&oe=utf8&num=60";
=======
	    this.url = "https://www.google.com/search?q=" + "intitle:" + searchKeyword + "~�u�f " + "&oe=utf8&num=50";
>>>>>>> .r60
	    
	}
	
	public ArrayList<Keyword> disjointKeyword(String connectKeyword){
        ArrayList<Keyword> keywords = new ArrayList<Keyword>();
        String[] input =connectKeyword.split("\\s+");
		
        for (int i = 0; i < input.length; i++){
        	    //for(int j = 5; j > 0; j--){      
        	    Keyword k = new Keyword(input[i], (input.length - i) * 5);
        	    keywords.add(k);
        }
        return keywords;
	}
	
	public ArrayList<Rerank> query() throws IOException{
		HashMap<String, String> retVal = new HashMap<String, String>();
	    Document doc = Jsoup.connect(this.url).get();
	    //System.out.println(doc);
	    
	    //ArrayList<Rerank> origin=new ArrayList<Rerank>();
	    Elements div_rcs = doc.select("div.rc");
	    	
	    for(Element div_rc : div_rcs){
	    	Element h3 = div_rc.select("h3.r").get(0);
	    	String title = h3.text();
	    		
	    	Element cite = div_rc.select("cite").get(0);
	    	String citeUrl = cite.text();
	    	//System.out.println(citeUrl);
	    	
	    	
	    	
	    	//
	    	//System.out.println(title + ", " + citeUrl);
	    	WebPage rootPage= new WebPage(citeUrl, title);;
	    	
	    	
	        WebTree tree = new WebTree(rootPage);
	        
	        //Elements manysubcite = div_rc.select("a[href]"); //��l���� <a href> <link href>??? 
 
	        Elements manysubcite = div_rc.getElementsByTag("a"); //��l���� <a herf> <link href>??? 

	    	for (Element u : manysubcite){
//	    		Element subh3 = u.select("h3.r").get(0);
//	    		String subtitle = subh3.text();
//	    		
//	    		Element subcite = u.select("cite").get(0);
//	    		String subciteUrl = subcite.text();
		        String subciteUrl = u.attr("href");
	    		
	    		Document subdoc = Jsoup.parse(subciteUrl);
	    		Elements subtitle_HTML = subdoc.getElementsByTag("title");
	    		String subtitle = subtitle_HTML.text();
	    		
	    		WebPage childPage;
	    		if(subciteUrl.startsWith("/") || subciteUrl.startsWith("#")){
		    		 childPage = new WebPage(citeUrl+subciteUrl, subtitle);
		    	}else{
		    	  childPage = new WebPage("Invalid url", "no title");
		    	}
	    		
	    		tree.root.addChild(new WebNode(childPage));
	    		
	        }
	    	

	    	//�Ƨ�
//	    	String correctSearch="https://www.google.com/search?q=" + disjointKeyword(searchKeyword) + "&oe=utf8&num=1";
//	    	double treeScore = tree.setPostOrderScore(disjointKeyword(correctSearch));
	    	double treeScore = tree.setPostOrderScore(disjointKeyword(searchKeyword));
	    	Rerank superRank = new Rerank(title, citeUrl ,treeScore);
	    	
	    	
	    	if(superRank.finalScore != 0){
	    		origin.add(superRank);
	    	}	
	    	
	
//	    	ArrayList<Keyword> kw = disjointKeyword(searchKeyword);
//	    	tree.setPostOrderScore(kw);

	    	//tree.eularPrintTree();
	        retVal.put(title, citeUrl);
	    }
	    
	    //�Ƨ�
  		origin = quickSort(origin);
	    //System.out.println("end");
	    return origin;
	   
	}
	
	//�Ƨ�
	public ArrayList<Rerank> quickSort(ArrayList<Rerank> original){
		if(original.size() <= 1){ 
			return original;
		}else{
			ArrayList<Rerank> result = new ArrayList<Rerank>();
			int pivotIndex = original.size() / 2;
			Rerank pivotKeyword = original.get(pivotIndex);
			
			ArrayList<Rerank> lessList = new ArrayList<Rerank>();
			ArrayList<Rerank> equalList = new ArrayList<Rerank>();
			ArrayList<Rerank> greaterList = new ArrayList<Rerank>();
			
			for(int i = 0;i < original.size(); i++){
				Rerank k = original.get(i);
				if(k.finalScore > pivotKeyword.finalScore){
					greaterList.add(k);
				}else if(k.finalScore < pivotKeyword.finalScore){
					lessList.add(k);
				}else{
					equalList.add(k);
				}
			}
			
			result.addAll(quickSort(greaterList));
			result.addAll(equalList);
			result.addAll(quickSort(lessList));
			
		    return result;
		}
	}
	//�Ƨ�
}