//Graham Simpson 
//4/25/16

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Portfolio{
	private double cash;
	private double holdingsValue;
	private String[] holdings;
	
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
	public void calcHoldings(){
		String[] holdings = getHoldings();
			
	}
	public void readFile(String filePath) throws IOException{
		//String testFile = "C:\\Code Workspace\\StockSimulator\\WorkspaceProject\\StockSimulatorBGSZ0.3\\bgszExchangePortfolio.csv";
		BufferedReader br = null;
		String line = "";
		String delimiter = ",";
		
		br = new BufferedReader(new FileReader(filePath));
		while ((line = br.readLine()) != null) {

			String[] stocks = line.split(delimiter);
			System.out.println("Ticker= " + stocks[0] + "; NumShares= " 
									+ stocks[1] + "; Price= " + stocks[2]);
		}
	}
}