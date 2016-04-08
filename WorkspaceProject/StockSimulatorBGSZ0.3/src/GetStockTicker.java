//Graham Simpson 4/6/2016
//Yahoo tool: http://www.jarloo.com/yahoo_finance/
import java.net.*;
import java.io.*;

public class GetStockTicker{
	private String ticker;
	private boolean exists;
	
	public void setTicker(String t){
		t=ticker;
	}
	public String getTicker(){
		return ticker;
	}
	public void pullPriceData(String t) throws IOException{
	    URL yahoofinancePrice = new URL("http://d.yimg.com/aq/autoc?query=" + t + "&region=US&lang=en-US");
	    URLConnection yahooConnection = yahoofinancePrice.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(yahooConnection.getInputStream()));
	    String inputLine=in.readLine();
	    exists = inputLine.contains(t);
	    if(exists){
	    	System.out.println(inputLine);
	    	//parse the data and get the ticker
	    	//send the ticker to the UI 
	    }
	    else{
	    	//send error message to the UI 
	    }
	    
	    
	    
	}
	
}