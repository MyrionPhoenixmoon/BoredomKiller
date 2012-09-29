package ch.pajama.boredomkiller.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.PanelUI;

import com.jtattoo.plaf.smart.SmartLookAndFeel;

public class MainView extends JFrame implements ActionListener, MouseListener{

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
	private ArrayList<String> playerListData = new ArrayList<String>();
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
	private ArrayList<JCheckBox> genreListData = new ArrayList<JCheckBox>();
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
	private ArrayList<JCheckBox> platformListData = new ArrayList<JCheckBox>();
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
	
	private JLabel challengeSettingLabel = new JLabel("Challenge Setting");
	private JComboBox<String> challengeSettingCb = new JComboBox<String>(new String[]{"Globally", "Individually"});
	
	private JLabel malusLabel = new JLabel("Malus Enabled");
	private JCheckBox cbMalus = new JCheckBox();
	
	//Dialog to add a Player
	private JDialog newPlayer = new JDialog(this);
	private JTextField newPlayerTf = new JTextField();
	private JButton newPlayerOk = new JButton(" Let's a go! ");
	private JButton newPlayerCancel = new JButton(" Cancel ");
	
	public MainView(){
		setup();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setupTheme();
		new MainView();
	}

	private void setup(){
		this.setSize(350, 500);
		this.setLocation(200, 150);
		this.setTitle("BoredomKiller I");
		this.setResizable(false);
		//this.setUndecorated(true);
		
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
		playerListData.add("Pincer");
		playerListData.add("Kero");
		playerListData.add("Myrion");
		playerListData.add("Tschoppi");
		playerListData.add("Amorpheus");
		playerList.setListData(playerListData.toArray());
		addComponent(filterPanel, playerScrollPane, 1, 0, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 3);
		playerAdd.addActionListener(this);
		addComponent(filterPanel, playerAdd, 2, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		playerRemove.addActionListener(this);
		addComponent(filterPanel, playerRemove, 2, 2, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		//Modus
		addComponent(filterPanel, modusLabel, 0, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		addComponent(filterPanel, cbSingleplayer, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		addComponent(filterPanel, cbVersus, 1, 4, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		addComponent(filterPanel, cbCoop, 1, 5, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		//Genre
		addComponent(filterPanel, genreLabel, 0, 6, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		genrePanel.setLayout(new BoxLayout(genrePanel, BoxLayout.PAGE_AXIS));
		genreListData.add(cb1);
		genreListData.add(cb2);
		genreListData.add(cb3);
		genreListData.add(cb4);
		genreListData.add(cb5);
		genreListData.add(cb6);
		genreListData.add(cb7);
		genreListData.add(cb8);
		genreListData.add(cb9);
		
		Iterator i = genreListData.iterator();
		while(i.hasNext()){
			genrePanel.add((Component)i.next());
		}
		
		addComponent(filterPanel, genreScrollPane, 1, 6, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 3);
		genreCheck.addActionListener(this);
		addComponent(filterPanel, genreCheck, 2, 7, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		genreUncheck.addActionListener(this);
		addComponent(filterPanel, genreUncheck, 2, 8, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		//Platform
		addComponent(filterPanel, platformLabel, 0, 9, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		platformPanel.setLayout(new BoxLayout(platformPanel, BoxLayout.PAGE_AXIS));
		platformListData.add(cbA);
		platformListData.add(cbB);
		platformListData.add(cbC);
		platformListData.add(cbD);
		platformListData.add(cbE);
		platformListData.add(cbF);
		platformListData.add(cbG);
		platformListData.add(cbH);
		platformListData.add(cbI);
		
		i = platformListData.iterator();
		while(i.hasNext()){
			platformPanel.add((Component)i.next());
		}
		
		addComponent(filterPanel, platformScrollPane, 1, 9, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 3);
		platformCheck.addActionListener(this);
		addComponent(filterPanel, platformCheck, 2, 10, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		platformUncheck.addActionListener(this);
		addComponent(filterPanel, platformUncheck, 2, 11, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
	}
	
	private void setupMiscPanel(){
		miscPanel.setLayout(lm);
		miscPanel.setBorder(new TitledBorder("Misc"));
		
		addComponent(miscPanel, challengeLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbEasy, 1, 0, 1.0, 1.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbMedium, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbHard, 1, 2, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, 1);
		
		addComponent(miscPanel, challengeSettingLabel, 0, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, challengeSettingCb, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		
		addComponent(miscPanel, malusLabel, 0, 4, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, 1);
		addComponent(miscPanel, cbMalus, 1, 4, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
	}
	
	private static void setupTheme(){
		try {
	        javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	private void addComponent(Container con, Component toadd, int gridx, int gridy, double weightx, double weighty, int anchor, int fill, int gridheight, int gridwidth){
		c.gridx = gridx;
		c.gridy = gridy;
		c.weightx = weightx;
		c.weighty = weighty;
		c.anchor = anchor;
		c.fill = fill;
		c.gridheight = gridheight;
		c.gridwidth = gridwidth;
		
		con.add(toadd, c);
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
	 * @param gridwidth sets the Components width
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
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(playerAdd)){
			newPlayer.setSize(300, 100);
			newPlayer.setLocation(280, 250);
			newPlayer.setTitle("A Challenger has appeared!");
			newPlayer.setResizable(false);
			newPlayer.setModal(true);
			newPlayer.setLayout(lm);

			newPlayerCancel.addMouseListener(this);
			newPlayerCancel.addActionListener(this);
			newPlayerOk.addActionListener(this);
			
			addComponent(newPlayer, newPlayerTf, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 2);
			addComponent(newPlayer, newPlayerOk, 0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1);
			addComponent(newPlayer, newPlayerCancel, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1);
			
			newPlayer.setVisible(true);
		} else if (ae.getSource().equals(playerRemove)){
			if(playerList.getSelectedIndex() != -1){
				playerListData.remove(playerList.getSelectedIndex());
				playerList.setListData(playerListData.toArray());
			}
		} else if (ae.getSource().equals(newPlayerOk)){
			String playername = newPlayerTf.getText();
			if(!playername.equals("") && !playerListData.contains(playername)){
				playerListData.add(playername);
				playerList.setListData(playerListData.toArray());
				newPlayer.setVisible(false);
				newPlayerTf.setText("");
			}
			else{
				System.out.println("Can't let you do that, maggot!");
			}
		} else if (ae.getSource().equals(newPlayerCancel)){
			newPlayer.setVisible(false);
			newPlayerTf.setText("");
		} else if (ae.getSource().equals(genreCheck)){
			Iterator i = genreListData.iterator();
			while(i.hasNext()){
				((JCheckBox)i.next()).setSelected(true);
			}
		} else if (ae.getSource().equals(genreUncheck)){
			Iterator i = genreListData.iterator();
			while(i.hasNext()){
				((JCheckBox)i.next()).setSelected(false);
			}
		} else if (ae.getSource().equals(platformCheck)){
			Iterator i = platformListData.iterator();
			while(i.hasNext()){
				((JCheckBox)i.next()).setSelected(true);
			}
		} else if (ae.getSource().equals(platformUncheck)){
			Iterator i = platformListData.iterator();
			while(i.hasNext()){
				((JCheckBox)i.next()).setSelected(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		if(me.getSource().equals(newPlayerCancel)){
			newPlayerCancel.setText(" YOU PUSSY! ");
		}
	}

	@Override
	public void mouseExited(MouseEvent me) {
		if(me.getSource().equals(newPlayerCancel)){
			newPlayerCancel.setText(" Cancel ");
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
