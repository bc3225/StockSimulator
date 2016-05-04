//Graham Simpson 
//5/4/16

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Portfolio{
	private double cash;
	private double holdingsValue;
	private String[] holdings;
	private String[] heldTickers;
	
	public double getCash(){
		return cash;
	}
	
	public void setCash( double c){
		cash=c;
	}
	
	public void setHoldings(String[] h){
		holdings=h;
		
	}
	public String[] getHoldings(){
		return holdings;
	}
	public void setHoldingsValue( double hv){
		holdingsValue=hv;
		
	}
	public double getHoldingsValue(){
		return holdingsValue;
	}
	public void setHeldTickers(String[] tics){
		heldTickers = tics;
	}
	public String[] getHeldTickers(){
		return heldTickers;
	}
	public void collectHeldTickers(){
		String[] h = getHoldings();
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
		setHeldTickers(collectedTickers);
	}
	
	public void sellStock(String s){
		String[] ticker = getHoldings();
		GetStockData gsd = new GetStockData();
		for(int i=0; i<ticker.length; i++){
			if(holdings[i] == s){
				try {
					gsd.pullPriceData(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				double value = gsd.getPrice();
				double cash = getCash(); 
				double portfolioValue = getHoldingsValue();
				cash+=value;
				portfolioValue -=value;
				setCash(cash);	
				setHoldingsValue(portfolioValue);
			}
		}
	}
	
	public void buyStock(String s){
		String[] ticker = getHoldings();
		GetStockData gsd = new GetStockData();
		for(int i=0; i<ticker.length; i++){
			if(holdings[i] == s){
				try {
					gsd.pullPriceData(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				double value = gsd.getPrice();
				double cash = getCash(); 
				double portfolioValue = getHoldingsValue();
				cash-=value;
				portfolioValue +=value;
				setCash(cash);	
				setHoldingsValue(portfolioValue);
			}
		}
		
	}
	
	public void calcHoldings(){
		String[] h = getHoldings();
		double cashMoney=0;
		String[] collectedTickers = getHeldTickers();
		GetStockData gsd = new GetStockData();
		for(int k=0; k<collectedTickers.length; k++){
			try {
				gsd.pullPriceData(collectedTickers[k]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double value = gsd.getPrice();
			cashMoney+=value;
		}		
		setHoldingsValue(cashMoney);		
	}
	public void readFile(String filePath){
		//String testFile = "C:\\Code Workspace\\StockSimulator\\WorkspaceProject\\StockSimulatorBGSZ0.3\\bgszExchangePortfolio.csv";
		BufferedReader br = null;
		String line = "";
		String delimiter = ",";
		
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((line = br.readLine()) != null) {

				String[] stocks = line.split(delimiter);
				/*System.out.println("Ticker= " + stocks[0] + "; NumShares= " 
										+ stocks[1] + "; Price= " + stocks[2]);*/
				setHoldings(stocks);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


