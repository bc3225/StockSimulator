import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIroughdraft {

	private JFrame frmBgszStockSimulator;
	/**
	 * @wbp.nonvisual location=53,14
	 */
	//private final JLabel lblBgszStockSimulator = DefaultComponentFactory.getInstance().createTitle("BGSZ Stock Simulator");
	private JTextField txtEnterYourText;
	private JTable table;

	/**
	 * Launch the application. Testing Comment
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIroughdraft window = new GUIroughdraft();
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBgszStockSimulator = new JFrame();
		frmBgszStockSimulator.getContentPane().setBackground(Color.GRAY);
		frmBgszStockSimulator.setTitle("BGSZ Stock Simulator");
		frmBgszStockSimulator.setBounds(100, 100, 775, 510);
		frmBgszStockSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBgszStockSimulator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnFile.add(mntmLoad);
		
		JMenuItem mntmOptions = new JMenuItem("Options");
		mnFile.add(mntmOptions);
		
		JMenu mnActions = new JMenu("Actions");
		menuBar.add(mnActions);
		
		JMenuItem mntmBuy = new JMenuItem("Buy");
		mnActions.add(mntmBuy);
		
		JMenuItem mntmSell = new JMenuItem("Sell");
		mnActions.add(mntmSell);
		
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
		
		JTextArea txtrThisWillBe = new JTextArea();
		txtrThisWillBe.setEditable(false);
		txtrThisWillBe.setLineWrap(true);
		txtrThisWillBe.setWrapStyleWord(true);
		txtrThisWillBe.setText("This will be a text field that displays all your actions and information about stocks, purchases, sales, errors, etc.");
		txtrThisWillBe.setBounds(12, 47, 312, 317);
		frmBgszStockSimulator.getContentPane().add(txtrThisWillBe);
		
		txtEnterYourText = new JTextField();
		txtEnterYourText.setText("Enter your text here");
		txtEnterYourText.setBounds(12, 377, 733, 22);
		frmBgszStockSimulator.getContentPane().add(txtEnterYourText);
		txtEnterYourText.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(75);
		progressBar.setBounds(78, 412, 586, 14);
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
}
