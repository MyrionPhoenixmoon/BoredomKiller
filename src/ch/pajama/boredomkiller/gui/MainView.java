package ch.pajama.boredomkiller.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ch.pajama.boredomkiller.db.Connector;
import ch.pajama.boredomkiller.db.QueryHandler;
import ch.pajama.boredomkiller.db.model.Difficulty;
import ch.pajama.boredomkiller.db.model.GameType;
import ch.pajama.boredomkiller.db.model.Platform;
import ch.pajama.boredomkiller.db.model.Playstyle;
import ch.pajama.boredomkiller.roll.Roller;

public class MainView extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 3413030932581242622L;
	
	//GridBagLayout
	private LayoutManager lm = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	//JFrame contents
	private JPanel mainPanel = new JPanel();
	
	//mainPanel contents
	private JPanel filterPanel = new JPanel();
	private JPanel miscPanel = new JPanel();
	private JButton killButton = new JButton("Kill the Boredom!!");
	private RainbowHover rh;
	
	//filterPanel contents
	//Players stuff
	private JLabel playersLabel = new JLabel("Players");
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
	private ArrayList<GameType> genreListData = new ArrayList<GameType>();
	
	//Platform stuff
	private JLabel platformLabel = new JLabel("Platform");
	private JPanel platformPanel = new JPanel();
	private JScrollPane platformScrollPane = new JScrollPane(platformPanel);
	private JButton platformCheck = new JButton("Check All");
	private JButton platformUncheck = new JButton("Uncheck All");
	private ArrayList<Platform> platformListData = new ArrayList<Platform>();
	
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
	private JDialog newPlayer;
	private JTextField newPlayerTf = new JTextField();
	private JButton newPlayerOk = new JButton(" Let's a go! ");
	private JButton newPlayerCancel = new JButton(" Cancel ");
	
	// DB Stuff
	Connector con = new Connector("root", "", "localhost", 3306);
	QueryHandler qh = new QueryHandler(con.getConnection());
	
	public MainView(){
		setup();
	}
	
	public static void main(String[] args) {
		setupTheme();
		new MainView();
	}

	private void setup(){
		this.setSize(350, 600);
		this.setLocation(200, 150);
		this.setTitle("BoredomKiller I");
		this.setResizable(false);
		//TODO Design Icon
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		this.setIconImage(icon);

		
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
		addComponent(mainPanel, filterPanel, 0, 0, 1.0, 8.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 1);
		setupMiscPanel();
		addComponent(mainPanel, miscPanel, 0, 1, 1.0, 2.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1);
		killButton.setBackground(new Color(40, 40, 40));
		killButton.setForeground(new Color(255, 255, 255));
		killButton.addActionListener(this);
		killButton.addMouseListener(this);
		addComponent(mainPanel, killButton, 0, 2, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
	}
	
	private void setupFilterPanel(){
		filterPanel.setLayout(lm);
		filterPanel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 150)), "Filters"));
		//Player
		Color playerColor = new Color(150, 200, 255);
		playersLabel.setForeground(playerColor);
		addComponent(filterPanel, playersLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		playerList.setForeground(playerColor);
		playerList.setListData(playerListData.toArray());
		playerScrollPane.setBorder(new LineBorder(new Color(150, 150, 150)));
		addComponent(filterPanel, playerScrollPane, 1, 0, 1.0, 10.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 3);
		playerAdd.addActionListener(this);
		playerAdd.setBackground(playerColor);
		playerAdd.setForeground(new Color(0, 50, 100));
		addComponent(filterPanel, playerAdd, 2, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		playerRemove.addActionListener(this);
		playerRemove.setBackground(playerColor);
		playerRemove.setForeground(new Color(0, 50, 100));
		addComponent(filterPanel, playerRemove, 2, 2, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		//Modus
		Color modusColor = new Color(220, 170, 255);
		modusLabel.setForeground(modusColor);
		addComponent(filterPanel, modusLabel, 0, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		cbSingleplayer.setForeground(modusColor);
		addComponent(filterPanel, cbSingleplayer, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		cbVersus.setForeground(modusColor);
		addComponent(filterPanel, cbVersus, 1, 4, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		cbCoop.setForeground(modusColor);
		addComponent(filterPanel, cbCoop, 1, 5, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		//Genre
		Color genreColor = new Color(255, 150, 200);
		genreLabel.setForeground(genreColor);
		addComponent(filterPanel, genreLabel, 0, 6, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		genrePanel.setLayout(lm);
		
		genreListData = qh.getGameTypes();
		Iterator<GameType> igt = genreListData.iterator();
		int row = 0;
		while(igt.hasNext()){
			JCheckBox tmp = new JCheckBox(igt.next().getName());
			tmp.setForeground(genreColor);
			addComponent(genrePanel, tmp, 0, row, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1);
			row++;
		}
		
		genreScrollPane.setBorder(new LineBorder(new Color(150, 150, 150)));
		addComponent(filterPanel, genreScrollPane, 1, 6, 1.0, 10.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 3);
		genreCheck.addActionListener(this);
		genreCheck.setBackground(genreColor);
		genreCheck.setForeground(new Color(100, 0, 50));
		addComponent(filterPanel, genreCheck, 2, 7, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		genreUncheck.addActionListener(this);
		genreUncheck.setBackground(genreColor);
		genreUncheck.setForeground(new Color(100, 0, 50));
		addComponent(filterPanel, genreUncheck, 2, 8, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		//Platform
		Color platformColor = new Color(255, 200, 150);
		platformLabel.setForeground(platformColor);
		addComponent(filterPanel, platformLabel, 0, 9, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		platformPanel.setLayout(lm);
		
		
		platformListData = qh.getPlatforms();
		Iterator<Platform> ip = platformListData.iterator();
		row = 0;
		while(ip.hasNext()){
			JCheckBox tmp = new JCheckBox(ip.next().getName());
			tmp.setForeground(platformColor);
			addComponent(platformPanel, tmp, 0, row, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1);
			row++;
		}
		
		platformScrollPane.setBorder(new LineBorder(new Color(150, 150, 150)));
		addComponent(filterPanel, platformScrollPane, 1, 9, 1.0, 10.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 3);
		platformCheck.addActionListener(this);
		platformCheck.setBackground(platformColor);
		platformCheck.setForeground(new Color(100, 50, 0));
		addComponent(filterPanel, platformCheck, 2, 10, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		platformUncheck.addActionListener(this);
		platformUncheck.setBackground(platformColor);
		platformUncheck.setForeground(new Color(100, 50, 0));
		addComponent(filterPanel, platformUncheck, 2, 11, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
	}
	
	private void setupMiscPanel(){
		miscPanel.setLayout(lm);
		miscPanel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 150)), "Misc"));
		
		Color challengeColor = new Color(255, 255, 150);
		challengeLabel.setForeground(challengeColor);
		addComponent(miscPanel, challengeLabel, 0, 0, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 1);
		cbEasy.setForeground(challengeColor);
		addComponent(miscPanel, cbEasy, 1, 0, 1.0, 1.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, 1);
		cbMedium.setForeground(new Color(255, 205, 150));
		addComponent(miscPanel, cbMedium, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 1);
		cbHard.setForeground(new Color(255, 155, 150));
		addComponent(miscPanel, cbHard, 1, 2, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, 1);
		
		challengeSettingLabel.setForeground(challengeColor);
		addComponent(miscPanel, challengeSettingLabel, 0, 3, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 10), 1);
		challengeSettingCb.setForeground(challengeColor);
		addComponent(miscPanel, challengeSettingCb, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 1);
		
		malusLabel.setForeground(challengeColor);
		addComponent(miscPanel, malusLabel, 0, 4, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 10), 1);
		addComponent(miscPanel, cbMalus, 1, 4, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 1);
	}
	
	private static void setupTheme(){
		try {
			//TODO adjust Theme (Dialog Box / ScrollPanes)
			
	        javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
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
	 * @param gridwidth sets the Components width
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
		
		c.insets = new Insets(0, 0, 0, 0);
		
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
	 */
	private void addComponent(Container con, Component toadd, int gridx, int gridy, double weightx, double weighty, int anchor, int fill, Insets insets, int gridheight){
		c.gridx = gridx;
		c.gridy = gridy;
		c.weightx = weightx;
		c.weighty = weighty;
		c.anchor = anchor;
		c.fill = fill;
		c.insets = insets;
		c.gridheight = gridheight;
		
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
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridwidth = 1;
		
		con.add(toadd, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(playerAdd)){
			newPlayer = new JDialog(this);
			newPlayer.setSize(300, 100);
			newPlayer.setLocation(this.getLocation().x + 20, this.getLocation().y + 120);
			newPlayer.setTitle("A Challenger has appeared!");
			newPlayer.setResizable(false);
			newPlayer.setModal(true);
			Color newPlayerColor = new Color(150, 200, 255);
			newPlayerOk.setBackground(newPlayerColor);
			newPlayerTf.setForeground(newPlayerColor);
			newPlayerOk.setForeground(new Color(0, 50, 100));
			newPlayerCancel.setBackground(newPlayerColor);
			newPlayerCancel.setForeground(new Color(0, 50, 100));
			newPlayer.setLayout(lm);
			newPlayer.getRootPane().setDefaultButton(newPlayerOk);

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
				playerListData.add(0, playername);
				playerList.setListData(playerListData.toArray());
				newPlayer.setVisible(false);
				newPlayerTf.setText("");
			}
		} else if (ae.getSource().equals(newPlayerCancel)){
			newPlayer.setVisible(false);
		} else if (ae.getSource().equals(genreCheck)){
			Component[] cbs = genrePanel.getComponents();
			for(int i = 0; i < cbs.length; i++){
				((JCheckBox)cbs[i]).setSelected(true);
			}
		} else if (ae.getSource().equals(genreUncheck)){
			Component[] cbs = genrePanel.getComponents();
			for(int i = 0; i < cbs.length; i++){
				((JCheckBox)cbs[i]).setSelected(false);
			}
		} else if (ae.getSource().equals(platformCheck)){
			Component[] cbs = platformPanel.getComponents();
			for(int i = 0; i < cbs.length; i++){
				((JCheckBox)cbs[i]).setSelected(true);
			}
		} else if (ae.getSource().equals(platformUncheck)){
			Component[] cbs = platformPanel.getComponents();
			for(int i = 0; i < cbs.length; i++){
				((JCheckBox)cbs[i]).setSelected(false);
			}
		} else if (ae.getSource().equals(killButton)){
			ArrayList<Playstyle> playstyles = new ArrayList<Playstyle>();
			if(cbSingleplayer.isSelected()){
				playstyles.add(new Playstyle("Singleplayer"));
			}
			if(cbCoop.isSelected()){
				playstyles.add(new Playstyle("Co-op"));
			}
			if(cbVersus.isSelected()){
				playstyles.add(new Playstyle("Versus"));
			}
			
			ArrayList<GameType> gametypes = new ArrayList<GameType>();
			Component[] cblist = genrePanel.getComponents();
			for(int i = 0; i < cblist.length; i++){
				if(((JCheckBox)cblist[i]).isSelected()){
					gametypes.add(genreListData.get(i));
				}
			}
			
			ArrayList<Platform> platforms = new ArrayList<Platform>();
			cblist = platformPanel.getComponents();
			for(int i = 0; i < cblist.length; i++){
				if(((JCheckBox)cblist[i]).isSelected()){
					platforms.add(platformListData.get(i));
				}
			}
			
			/*Difficulty difficulty;
			String setting;*/
			//TODO difficulty and setting, too lazy for it now
			Roller r = new Roller(playerListData.size(), playstyles.toArray(new Playstyle[]{}), gametypes.toArray(new GameType[]{}), platforms.toArray(new Platform[]{}), new Difficulty("Easy"), "Globally", con.getConnection());
			//Roller r = new Roller(playerListData.size(), (Playstyle[])playstyles.toArray(), (GameType[])gametypes.toArray(), platforms, difficulty, setting, con.getConnection());
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//nothing to do so far...
	}
	
	@Override
	public void mouseEntered(MouseEvent me) {
		if(me.getSource().equals(newPlayerCancel)){
			newPlayerCancel.setText(" YOU PUSSY! ");
		}
		if(me.getSource().equals(killButton)){
			if(rh == null){
				 rh = new RainbowHover();
			}
			rh.go();
		}
	}

	@Override
	public void mouseExited(MouseEvent me) {
		if(me.getSource().equals(newPlayerCancel)){
			newPlayerCancel.setText(" Cancel ");
		}
		if(me.getSource().equals(killButton)){
			rh.halt();
			killButton.setBackground(new Color(40, 40, 40));
			killButton.setForeground(new Color(255, 255, 255));
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//nothing to do so far...
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//nothing to do so far...
	}
	
	private class RainbowHover extends Thread{
		private boolean on = false;
		private int red = 200;
		private int green = 100;
		private int blue = 0;
		boolean redup = false;
		boolean greenup = true;
		boolean blueup = true;
		
		public RainbowHover(){
			start();
		}
		
		public void go(){
			on = true;
		}
		
		public void halt() {
	        on = false;
	        red = 200;
	        green = 100;
	        blue = 0;
	        redup = false;
	        greenup = true;
	        blueup = true;
	    }
		
		public void run(){
			while(true){
				if(on){
					if(red == 0){
						redup = true;
					}
					else if(red == 200){
						redup = false;
					}
					
					if(green == 0){
						greenup = true;
					}
					else if(green == 200){
						greenup = false;
					}
					
					if(blue == 0){
						blueup = true;
					}
					else if(blue == 200){
						blueup = false;
					}
					
					if(redup){
						red++;
					}
					else{
						red--;
					}
					
					if(greenup){
						green++;
					}
					else{
						green--;
					}
					
					if(blueup){
						blue++;
					}
					else{
						blue--;
					}
					
					killButton.setBackground(new Color(red, green, blue));
					killButton.setForeground(new Color(255-red, 255-green, 255-blue));
					try{
						sleep(2);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				else{
					try{
						sleep(2);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}