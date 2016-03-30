import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
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
	private final JLabel lblBgszStockSimulator = DefaultComponentFactory.getInstance().createTitle("BGSZ Stock Simulator");
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
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mnHelp.add(mntmInfo);
		
		JMenuItem mntmAbout = new JMenuItem("How to Use");
		mnHelp.add(mntmAbout);
		frmBgszStockSimulator.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.LIGHT_GRAY);
		scrollBar.setBounds(303, 47, 21, 317);
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
		txtEnterYourText.setBounds(12, 377, 312, 22);
		frmBgszStockSimulator.getContentPane().add(txtEnterYourText);
		txtEnterYourText.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(78, 412, 146, 14);
		frmBgszStockSimulator.getContentPane().add(progressBar);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(562, 339, 97, 25);
		frmBgszStockSimulator.getContentPane().add(btnBuy);
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSell.setBounds(562, 376, 97, 25);
		frmBgszStockSimulator.getContentPane().add(btnSell);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(387, 339, 97, 25);
		frmBgszStockSimulator.getContentPane().add(btnSearch);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(387, 376, 97, 25);
		frmBgszStockSimulator.getContentPane().add(btnView);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Stock Name", "Stock Value", "Amount Owned", "Total Value"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(350, 51, 395, 254);
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
