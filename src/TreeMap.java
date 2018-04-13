//import java.io.IOException;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class TreeMap 
//{
//	Map<String, Double> TitleAndScore=new TreeMap<>();
//	public String[][][] data = new String[10000][10000][10000];
//	public void treeMap() throws IOException
//	{
//		
//	
//		for (String key : retVal.keySet()) 
//		{  
//             Double score = null;		
//			 TitleAndScore.put(key,score);
//        }
//		for(Map.Entry<String, Double> entry:TitleAndScore.entrySet())
//		{
//			System.out.println(entry.getKey());//print key
//		}
//		
//		
//	}
//	
//	public String[][][] box()
//	{
//		
//		for (Object key : retVal.keySet()) 
//		{
//            System.out.println(key + " : " + retVal.get(key));
//            for(int i=1;i<10000;i++)
//            {
//            	//i 這裡裝分數
//            	data[0][0][i]= Integer.toString(0);
//            }
//
//          for(int j=1;j<10000;j++)
//          {
//          	data[0][j][j]=(String) key;
//          
//          	for(int g=1;g<10000;g++)
//          	{
//          	data[g][g][g]=(String) retVal.get(key);
//          	}
//          }	
//		return data;
//	}
//	
//
//}
