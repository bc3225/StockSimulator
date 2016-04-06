//Graham Simpson 4/6/2016
//Yahoo tool: http://www.jarloo.com/yahoo_finance/
import java.net.*;
import java.io.*;

public class GetStockData{
	private double price;
	private double avgDailyVol;
	
	public void setPrice(double p){
		p=price;
	}
	public double getPrice(){
		return price;
	}
	public void pullPriceData(String t) throws IOException{
	    URL yahoofinancePrice = new URL("http://finance.yahoo.com/d/quotes.csv?s="+t+"+"+"&f=p");
	    URLConnection yahooConnection = yahoofinancePrice.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(yahooConnection.getInputStream()));
	    String inputLine=in.readLine();
	    price = Double.parseDouble(inputLine);
    	setPrice(price);	    //NOTE price=previous close in USD
    	
    	URL yahoofinanceAvgDailyVol = new URL("http://finance.yahoo.com/d/quotes.csv?s="+t+"+"+"&f=a2");
    	URLConnection yahooConnection2 = yahoofinanceAvgDailyVol.openConnection();
    	BufferedReader in2 = new BufferedReader(new InputStreamReader(yahooConnection2.getInputStream()));
 	    String inputLine2=in2.readLine();
	    avgDailyVol = Double.parseDouble(inputLine2);
	    setAvgDailyVol(avgDailyVol);
	}
	public double getAvgDailyVol() {
		return avgDailyVol;
	}
	public void setAvgDailyVol(double avgDailyVol) {
		this.avgDailyVol = avgDailyVol;
	}
}