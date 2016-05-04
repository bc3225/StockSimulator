import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class GUIroughdraft {

	private JFrame frmBgszStockSimulator;
	/**
	 * @wbp.nonvisual location=53,14
	 */
	//private final JLabel lblBgszStockSimulator = DefaultComponentFactory.getInstance().createTitle("BGSZ Stock Simulator");
	private  JTextField searchBar;
	private JTextField buyBar;
	private JTextField sellBar;
	private JTable table;
	private  JTextField displayBox;
	private  JButton searchButton;
	public static String pathName;

	/**
	 * Launch the application. Testing Comment
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUIroughdraft window = new GUIroughdraft();
				try {
					window = new GUIroughdraft();
					window.frmBgszStockSimulator.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIroughdraft() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmBgszStockSimulator = new JFrame();
		frmBgszStockSimulator.getContentPane().setBackground(Color.GRAY);
		frmBgszStockSimulator.setTitle("BGSZ Stock Simulator");
		frmBgszStockSimulator.setBounds(100, 100, 802, 510);
		frmBgszStockSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBgszStockSimulator.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frmBgszStockSimulator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		mntmSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser saveFile = new JFileChooser(new File("c:\\"));
                saveFile.setFileFilter(new FileTypeFilter(".csv", "Comma-separated values"));
                int result = saveFile.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION) {
                	File fi = new File(saveFile.getSelectedFile() +".csv");
                	try {
                		TableModel model = table.getModel();
                        FileWriter excel = new FileWriter(fi);

                        for(int i = 0; i < model.getColumnCount(); i++){
                            excel.write(model.getColumnName(i) + "\t");
                        }

                        excel.write("\n");

                        for(int i=0; i< model.getRowCount(); i++) {
                            for(int j=0; j < model.getColumnCount(); j++) {
                                excel.write(model.getValueAt(i,j).toString()+"\t");
                            }
                            excel.write("\n");
                        }

                        excel.close();
                	} catch (Exception e2) {
                		JOptionPane.showMessageDialog(null, e2.getMessage());
                	}
                }
                
                
            }
        });
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnFile.add(mntmLoad);
		mntmLoad.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                JFileChooser openFile = new JFileChooser();
	                int option = openFile.showOpenDialog(null);
	                if (option == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = openFile.getSelectedFile();
	                    pathName = selectedFile.getAbsolutePath();
	                }
	            }
	        });
		
		JMenuItem mntmOptions = new JMenuItem("Options");
		mnFile.add(mntmOptions);
		
		JMenu mnActions = new JMenu("Actions");
		menuBar.add(mnActions);
		
		JMenuItem mntmBuy = new JMenuItem("Buy");
		mnActions.add(mntmBuy);
		mntmBuy.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent arg0)
	            {
	                JFrame frmBgszStockSimulatorBuy = new JFrame();
	                frmBgszStockSimulatorBuy.getContentPane().setBackground(Color.GRAY);
	                frmBgszStockSimulatorBuy.setTitle("Buy Stocks");
	                frmBgszStockSimulatorBuy.setVisible(true);
	                frmBgszStockSimulatorBuy.setBounds(100, 100, 350, 250);
	                frmBgszStockSimulatorBuy.setResizable(false);
	                
	                JMenuBar menuBuyBar = new JMenuBar();
	                frmBgszStockSimulatorBuy.setJMenuBar(menuBuyBar);
	                
	                JMenu mnFile = new JMenu("File");
	                menuBuyBar.add(mnFile);
	                
	                JMenuItem mntmWhatever = new JMenuItem("Do what you want here");
	                mnFile.add(mntmWhatever);
	                

	                searchBar = new JTextField();
	                searchBar.setText("Enter the stock ticker here");
	                searchBar.setBounds(5, 50, 205, 22);
	                frmBgszStockSimulatorBuy.add(searchBar, BorderLayout.PAGE_START);
	                searchBar.setColumns(10);
	                
	                buyBar = new JTextField();
	                buyBar.setText("How much stock would you like to buy?");
	                buyBar.setBounds(5, 100,  205,  22);
	                frmBgszStockSimulatorBuy.add(buyBar, BorderLayout.PAGE_START);
	                buyBar.setColumns(10);
	                

	                JTextArea displayBoxBuy = new JTextArea();
	                displayBoxBuy.setEditable(false);
	                displayBoxBuy.setLineWrap(true);
	                displayBoxBuy.setWrapStyleWord(true);
	                displayBoxBuy.setText("This will be a text field that displays" + "\n" + "all your actions and information about stocks, purchases, sales, errors, etc.");
	//
	                displayBoxBuy.setBounds(12, 47, 300, 150);
	                
	                JButton buyStockButton = new JButton();
	                buyStockButton.setText("Buy Stock");
	                buyStockButton.setBounds(215,100,93,22);
	                frmBgszStockSimulatorBuy.getContentPane().add(buyStockButton, BorderLayout.PAGE_START);
	                
	                JButton searchButton = new JButton();
	                searchButton.setText("Search");
	                searchButton.setBounds(215, 50, 93, 22);
	                frmBgszStockSimulatorBuy.getContentPane().add(searchButton,BorderLayout.PAGE_START);
	                searchButton.addActionListener(new ActionListener() 
	                {
	                     public void actionPerformed(ActionEvent e) 
	                     {

	                         String userInput = searchBar.getText();

	                                GetStockData gd = new GetStockData();
	                                try 
	                                {
	                                    gd.pullPriceData(userInput);
	            
	                                } 
	                                catch (IOException er) 
	                                {
	                                    er.printStackTrace();
	            
	                                }
	            
	                                String output = Double.toString(gd.getPrice());;
	                                if(output == "0")
	                                {
	                                    displayBoxBuy.setText("NO STOCK FOUND");
	                                }
	                                displayBoxBuy.setText("The Price for " + userInput + ": $" + output);
	                                //get to print in the table.
	                                //userInput = stock ticker 
	                                //ouput = price
	                        }
	                  });

	                frmBgszStockSimulatorBuy.getContentPane().add(displayBoxBuy, BorderLayout.PAGE_START);   //This is where BorderLayout.PAGE_START is added.       
	            }


	        }); 
		
		JMenuItem mntmSell = new JMenuItem("Sell");
		mnActions.add(mntmSell);
		mntmSell.addActionListener(new ActionListener()
	    {
	        @Override
	        public void actionPerformed(ActionEvent arg0)
	        {
	            JFrame frmBgszStockSimulatorSell = new JFrame();
	            frmBgszStockSimulatorSell.getContentPane().setBackground(Color.GRAY);
	            frmBgszStockSimulatorSell.setTitle("Sell Stocks");
	            frmBgszStockSimulatorSell.setVisible(true);
	            frmBgszStockSimulatorSell.setBounds(100, 100, 350, 250);
	            frmBgszStockSimulatorSell.setResizable(false);
	            
	            JMenuBar menuSellBar = new JMenuBar();
	            frmBgszStockSimulatorSell.setJMenuBar(menuSellBar);
	            
	            JMenu mnFile = new JMenu("File");
	            menuSellBar.add(mnFile);
	            
	            JMenuItem mntmWhatever = new JMenuItem("Do what you want here");
	            mnFile.add(mntmWhatever);

	            searchBar = new JTextField();
	            searchBar.setText("Enter the stock ticker here");
	            searchBar.setBounds(5, 50, 205, 22);
	            frmBgszStockSimulatorSell.add(searchBar, BorderLayout.PAGE_START);
	            searchBar.setColumns(10);
	            
	            sellBar = new JTextField();
	            sellBar.setText("How much stock would you like to sell?");
	            sellBar.setBounds(5, 100,  205,  22);
	            frmBgszStockSimulatorSell.add(sellBar, BorderLayout.PAGE_START);
	            sellBar.setColumns(10);

	            JTextArea displayBoxSell = new JTextArea();
	            displayBoxSell.setEditable(false);
	            displayBoxSell.setLineWrap(true);
	            displayBoxSell.setWrapStyleWord(true);
	            displayBoxSell.setText("This will be a text field that displays all your actions and information about stocks, purchases, sales, errors, etc.");

	            displayBoxSell.setBounds(12, 47, 300, 150);
	            
	            JButton sellStockButton = new JButton();
                sellStockButton.setText("Buy Stock");
                sellStockButton.setBounds(215,100,93,22);
                frmBgszStockSimulatorSell.getContentPane().add(sellStockButton, BorderLayout.PAGE_START);
	            
	            JButton searchButton = new JButton();
	            searchButton.setText("Search");
	            searchButton.setBounds(215, 50, 93, 22);
	            frmBgszStockSimulatorSell.getContentPane().add(searchButton, BorderLayout.PAGE_START);
	            searchButton.addActionListener(new ActionListener() 
	            {
	                 public void actionPerformed(ActionEvent e) 
	                 {

	                     String userInput = searchBar.getText();

	                            GetStockData gd = new GetStockData();
	                            try 
	                            {
	                                gd.pullPriceData(userInput);
	        
	                            } 
	                            catch (IOException er) 
	                            {
	                                er.printStackTrace();
	        
	                            }
	        
	                            String output = Double.toString(gd.getPrice());;
	                            if(output == "0")
	                            {
	                                displayBoxSell.setText("NO STOCK FOUND");
	                            }
	                            displayBoxSell.setText("The Price for " + userInput + ": $" + output);
	                            //get to print in the table.
	                            //userInput = stock ticker 
	                            //ouput = price
	                    }
	              });
	            

	            frmBgszStockSimulatorSell.getContentPane().add(displayBoxSell, BorderLayout.PAGE_START);   
	        }


	    });
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mnHelp.add(mntmInfo);
		
		JMenuItem mntmAbout = new JMenuItem("How to Use");
		mnHelp.add(mntmAbout);
		frmBgszStockSimulator.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.LIGHT_GRAY);
		scrollBar.setBounds(323, 47, 21, 317);
		frmBgszStockSimulator.getContentPane().add(scrollBar);
		
		JTextArea displayBox = new JTextArea();
		displayBox.setEditable(false);
		displayBox.setLineWrap(true);
		displayBox.setWrapStyleWord(true);
		displayBox.setText("This will be a text field that displays all your actions and information about stocks, purchases, sales, errors, etc.");
		
		displayBox.setBounds(12, 47, 312, 317);
		frmBgszStockSimulator.getContentPane().add(displayBox);
		
		searchBar = new JTextField();
		searchBar.setText("Enter your text here");
		searchBar.setBounds(12, 377, 637, 22);
		frmBgszStockSimulator.getContentPane().add(searchBar);
		searchBar.setColumns(10);
		
		JButton searchButton = new JButton();
		searchButton.setText("Search");
		searchButton.setBounds(654, 377, 93, 22);
		frmBgszStockSimulator.getContentPane().add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 String userInput = searchBar.getText();
		       	
						GetStockData gd = new GetStockData();
						try {
							gd.pullPriceData(userInput);
							
						} catch (IOException er) {
							er.printStackTrace();
							
						}
						
						String output = Double.toString(gd.getPrice());;
						System.out.println(output);
						if(output == "0"){
							displayBox.append("NO STOCK FOUND");
						}
						displayBox.append("\n The Price for " + userInput + ": $" + output);
						//get to print in the table.
						//userInput = stock ticker 
						//ouput = price
		        }
	      });
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(75);
		progressBar.setBounds(50, 412, 586, 14);
		frmBgszStockSimulator.getContentPane().add(progressBar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Stock Name", "Stock Value", "Amount Owned", "Total Value"},
					{" BAC", "$13.48", "4", "$53.92"},
					{" RIG", "$8.89", "0", "$0.00"},
					{" SUNE", "$0.59", "12", "$7.08"},
					{" FCX", "$10.29", "2", "$20.58"},
					{" PBR", "$5.86", "0", "$0.00"},
					{" GE", "$31.83", "0", "$0.00"},
					{" VALE", "$4.24", "24", "$101.76"},
					{" VRX", "$27.07", "0", "$0.00"},
					{" PFE", "$30.07", "0", "$0.00"},
					{" CRC", "$1.05", "8", "$8.40"},
					{" GGB", "$1.82", "0", "$0.00"},
					{" CHK", "$4.01", "6", "$24.06"},
					{" T", "$39.37", "0", "$0.00"},
					{" F", "$13.35", "5", "$66.75"},
					{" WLL", "$7.66", "0", "$0.00"},
				},
				new String[] {
					"New column", "New column", "New column", "New column"
				}
			));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(350, 51, 395, 313);
		frmBgszStockSimulator.getContentPane().add(table);
		
		JTextArea txtrValue = new JTextArea();
		txtrValue.setText("Displays Cash Value");
		txtrValue.setLineWrap(true);
		txtrValue.setEditable(false);
		txtrValue.setBounds(99, 12, 172, 22);
		frmBgszStockSimulator.getContentPane().add(txtrValue);
		
		JTextArea txtrCurrentPortfolioValue = new JTextArea();
		txtrCurrentPortfolioValue.setText("Display Portfolio Value");
		txtrCurrentPortfolioValue.setLineWrap(true);
		txtrCurrentPortfolioValue.setEditable(false);
		txtrCurrentPortfolioValue.setBounds(376, 12, 206, 22);
		frmBgszStockSimulator.getContentPane().add(txtrCurrentPortfolioValue);
		
		JLabel lblCashValue = new JLabel("Cash Value:");
		lblCashValue.setBounds(24, 15, 111, 16);
		frmBgszStockSimulator.getContentPane().add(lblCashValue);
		
		JLabel lblPortfolioValue = new JLabel("Portfolio Value:");
		lblPortfolioValue.setBounds(283, 15, 123, 16);
		frmBgszStockSimulator.getContentPane().add(lblPortfolioValue);
	}
	
/*	private class customListener implements ActionListener {
	    private GUIroughdraft window;

	    public customListener(GUIroughdraft window) {
	        this.window = window;
	    }

	    public void actionPerformed(ActionEvent e) {
       	 String userInput = window.searchBar.getText();
				GetStockData gd = new GetStockData();
				try {
					gd.pullPriceData(userInput);
				} catch (IOException er) {
					er.printStackTrace();
				}
				String output = Double.toString(gd.getPrice());
				window.displayBox.setText("The Price for " + userInput + ":" + output);
        }
	}*/
}
