package ch.pajama.boredomkiller.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class MainView extends JFrame implements ActionListener{

	//GridBagLayout
	private LayoutManager lm = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	//JFrame contents
	private JPanel mainPanel = new JPanel();
	
	//mainPanel contents
	private JPanel filterPanel = new JPanel();
	private JPanel miscPanel = new JPanel();
	private JButton killButton = new JButton("Kill the Boredom!!");
	
	//filterPanel contents
	//Players stuff
	private JLabel playersLabel = new JLabel("Players");
	private JPanel playerListPanel = new JPanel();
	private JList playerList = new JList();
	private JScrollPane playerScrollPane = new JScrollPane(playerList);
	private JButton playerAdd = new JButton("Add");
	private JButton playerRemove = new JButton("Remove");
	
	//Modus stuff
	private JLabel modusLabel = new JLabel("Modus");
	private JCheckBox cbSingleplayer = new JCheckBox("Singleplayer");
	private JCheckBox cbVersus = new JCheckBox("Versus");
	private JCheckBox cbCoop = new JCheckBox("Co-op");
	
	//Genre stuff
	private JLabel genreLabel = new JLabel("Genre");
	private JPanel genrePanel = new JPanel();
	private JScrollPane genreScrollPane = new JScrollPane(genrePanel);
	private JButton genreCheck = new JButton("Check All");
	private JButton genreUncheck = new JButton("Uncheck All");
	//Placeholders
	//TODO delete those
	private JCheckBox cb1 = new JCheckBox("Genre 1");
	private JCheckBox cb2 = new JCheckBox("Genre 2");
	private JCheckBox cb3 = new JCheckBox("Genre 3");
	private JCheckBox cb4 = new JCheckBox("Genre 4");
	private JCheckBox cb5 = new JCheckBox("Genre 5");
	private JCheckBox cb6 = new JCheckBox("Genre 6");
	private JCheckBox cb7 = new JCheckBox("Genre 7");
	private JCheckBox cb8 = new JCheckBox("Genre 8");
	private JCheckBox cb9 = new JCheckBox("Genre 9");
	
	//Platform stuff
	private JLabel platformLabel = new JLabel("Platform");
	private JPanel platformPanel = new JPanel();
	private JScrollPane platformScrollPane = new JScrollPane(platformPanel);
	private JButton platformCheck = new JButton("Check All");
	private JButton platformUncheck = new JButton("Uncheck All");
	//Placeholders
	//TODO delete those
	private JCheckBox cbA = new JCheckBox("Platform 1");
	private JCheckBox cbB = new JCheckBox("Platform 2");
	private JCheckBox cbC = new JCheckBox("Platform 3");
	private JCheckBox cbD = new JCheckBox("Platform 4");
	private JCheckBox cbE = new JCheckBox("Platform 5");
	private JCheckBox cbF = new JCheckBox("Platform 6");
	private JCheckBox cbG = new JCheckBox("Platform 7");
	private JCheckBox cbH = new JCheckBox("Platform 8");
	private JCheckBox cbI = new JCheckBox("Platform 9");
	
	//miscPanel contents
	private JLabel challengeLabel = new JLabel("Challenge Difficulty");
	private JCheckBox cbEasy = new JCheckBox("Easy");
	private JCheckBox cbMedium = new JCheckBox("Medium");
	private JCheckBox cbHard = new JCheckBox("Hard");
	
	private JLabel malusLabel = new JLabel("Malus Enabled");
	private JCheckBox cbMalus = new JCheckBox();
	
	public MainView(){
		setup();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainView();
	}

	private void setup(){
		this.setSize(350, 500);
		this.setLocation(200, 150);
		this.setTitle("BoredomKiller I");
		this.setResizable(false);
		
		this.add(mainPanel);
		setupMainPanel();
		
		//Exit program on pressing the "X"
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		this.setVisible(true);
	}
	
	private void setupMainPanel(){
		mainPanel.setLayout(lm);
		setupFilterPanel();
		addComponent(mainPanel, filterPanel, 0, 0, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 1);
		setupMiscPanel();
		addComponent(mainPanel, miscPanel, 0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1);
		addComponent(mainPanel, killButton, 0, 2, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
	}
	
	private void setupFilterPanel(){
		filterPanel.setLayout(lm);
		filterPanel.setBorder(new TitledBorder("Filters"));
		//Player
		addComponent(filterPanel, playersLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		//TODO remove sample data
		playerList.setListData(new String[]{"Pincer", "Kero", "Myrion", "Amorpheus", "Tschoppi"});
		addComponent(filterPanel, playerScrollPane, 1, 0, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 3);
		addComponent(filterPanel, playerAdd, 2, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		addComponent(filterPanel, playerRemove, 2, 2, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		//Modus
		addComponent(filterPanel, modusLabel, 0, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		addComponent(filterPanel, cbSingleplayer, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		addComponent(filterPanel, cbVersus, 1, 4, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		addComponent(filterPanel, cbCoop, 1, 5, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		//Genre
		addComponent(filterPanel, genreLabel, 0, 6, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		genrePanel.setLayout(new BoxLayout(genrePanel, BoxLayout.PAGE_AXIS));
		genrePanel.add(cb1);
		genrePanel.add(cb2);
		genrePanel.add(cb3);
		genrePanel.add(cb4);
		genrePanel.add(cb5);
		genrePanel.add(cb6);
		genrePanel.add(cb7);
		genrePanel.add(cb8);
		genrePanel.add(cb9);
		addComponent(filterPanel, genreScrollPane, 1, 6, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 3);
		addComponent(filterPanel, genreCheck, 2, 7, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		addComponent(filterPanel, genreUncheck, 2, 8, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		//Platform
		addComponent(filterPanel, platformLabel, 0, 9, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		platformPanel.setLayout(new BoxLayout(platformPanel, BoxLayout.PAGE_AXIS));
		platformPanel.add(cbA);
		platformPanel.add(cbB);
		platformPanel.add(cbC);
		platformPanel.add(cbD);
		platformPanel.add(cbE);
		platformPanel.add(cbF);
		platformPanel.add(cbG);
		platformPanel.add(cbH);
		platformPanel.add(cbI);
		addComponent(filterPanel, platformScrollPane, 1, 9, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 3);
		addComponent(filterPanel, platformCheck, 2, 10, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		addComponent(filterPanel, platformUncheck, 2, 11, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
	}
	
	private void setupMiscPanel(){
		miscPanel.setLayout(lm);
		miscPanel.setBorder(new TitledBorder("Misc"));
		
		addComponent(miscPanel, challengeLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbEasy, 1, 0, 1.0, 1.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbMedium, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbHard, 1, 2, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, 1);
		
		addComponent(miscPanel, malusLabel, 0, 3, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbMalus, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
	}
	
	/**
	 * Adds a Component to given Container
	 * @param con Container to add the Component to
	 * @param toadd Component to add
	 * @param gridx where to add the Component on the x-axis
	 * @param gridy	where to add the Component on the y-axis
	 * @param weightx weight of the Component on the x-axis
	 * @param weighty weight of the Component on the y-axis
	 * @param anchor where the anchor is set for the Component
	 * @param fill how the Component fills
	 * @param gridheight sets the Components height
	 */
	private void addComponent(Container con, Component toadd, int gridx, int gridy, double weightx, double weighty, int anchor, int fill, int gridheight){
		c.gridx = gridx;
		c.gridy = gridy;
		c.weightx = weightx;
		c.weighty = weighty;
		c.anchor = anchor;
		c.fill = fill;
		c.gridheight = gridheight;
		
		con.add(toadd, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
