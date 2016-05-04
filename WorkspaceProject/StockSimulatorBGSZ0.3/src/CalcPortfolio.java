//Graham Simpson
//4/25/16

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalcPortfolio{
	 private String[] holdings;
	 
	 //need to calc total port value
	 //be able to subtract shares of a single stock (sell)
	 // add shares of a single stock (buy)
	 //when the program opens update all the holdings values
	 //error checking
	 //write all the info to the table in the UI
	 
	
	Portfolio p = new Portfolio();{
		
		try {
			p.readFile(GUIroughdraft.pathName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		holdings = p.getHoldings();
		//System.out.println("Ticker= " + holdings[0] + "; NumShares= " 
		//		+ holdings[1] + "; Price= " + holdings[2]);	
	}
	
	public double calcValue(String[] h) throws IOException{
		double cashMoney=0;
		int i=0;
		String[] collectedTickers = new String[h.length];
		while(i<h.length){
			if(i%3 == 0){
				collectedTickers[i] = h[i];
				i++;
			}else{
				i++;
			}
		}	
		
		GetStockData gsd = new GetStockData();
		for(int k=0; i<collectedTickers.length; k++){
			gsd.pullPriceData(collectedTickers[k]);
			double value = gsd.getPrice();
			cashMoney+=value;
		}
		
		return cashMoney;
	}
	


}

