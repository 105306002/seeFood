import java.io.IOException;
import java.util.ArrayList;


public class WebPage {
    public String URL;
    public String name;
    public WordCounter counter;
    public double score;
    public String nam;
    
    public WebPage(String URL, String name){
    	this.URL = URL;
    	this.name = name;
    	this.counter = new WordCounter(URL);
    }
    
    public double setScore(ArrayList<Keyword> keywords) throws IOException{
    	Keyword reserveK1 = new Keyword("折價", 10);
    	Keyword reserveK2 = new Keyword("餐廳", 10);
    	Keyword reserveK3 = new Keyword("優惠", 10);
    	Keyword reserveK4 = new Keyword("折底", 10);
    	Keyword reserveK5 = new Keyword("折扣", 10);
    	Keyword reserveK6 = new Keyword("打折", 10);
    	Keyword reserveK7 = new Keyword("生日", 10);
    	Keyword reserveK8 = new Keyword("壽星", 10);
    	Keyword reserveK9 = new Keyword("學生", 10);
    	Keyword reserveK10 = new Keyword("特約", 10);
    	
    	score = 0;
    	score = counter.countKeyword(reserveK1.name) * reserveK1.weight 
 		      + counter.countKeyword(reserveK2.name) * reserveK2.weight 
 		      + counter.countKeyword(reserveK3.name) * reserveK3.weight 
 		      + counter.countKeyword(reserveK4.name) * reserveK4.weight 
 		      + counter.countKeyword(reserveK5.name) * reserveK5.weight 
 		      + counter.countKeyword(reserveK6.name) * reserveK6.weight
 		      + counter.countKeyword(reserveK7.name) * reserveK7.weight
 		      + counter.countKeyword(reserveK8.name) * reserveK8.weight
 		      + counter.countKeyword(reserveK9.name) * reserveK9.weight
 		      + counter.countKeyword(reserveK10.name) * reserveK10.weight;
    	
    	for(Keyword keyword : keywords){
    		score += counter.countKeyword(keyword.name) * keyword.weight;
    	}
    	return score;
    }
}
