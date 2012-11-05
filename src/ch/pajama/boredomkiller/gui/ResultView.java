package ch.pajama.boredomkiller.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.pajama.boredomkiller.db.model.Challenge;
import ch.pajama.boredomkiller.db.model.Game;
import ch.pajama.boredomkiller.db.model.Map;
import ch.pajama.boredomkiller.db.model.Mode;

public class ResultView extends JDialog{
	private LayoutManager lm = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	
	private Game game;
	private Map map;
	private Mode mode;
	private Challenge challenge;
	
	private JPanel mainPanel = new JPanel();
	private JPanel challengePanel = new JPanel();
	
	private JLabel gameLabel;
	private JLabel mapLabel;
	private JLabel modeLabel;
	private JLabel challengeLabel;
	
	public ResultView(MainView parent, Game game, Map map, Mode mode, Challenge challenge){
		super(parent);
		
		this.game = game;
		this.map = map;
		this.mode = mode;
		this.challenge = challenge;
		
		setup();
	}
	
	private void setup(){
		this.setTitle("Know thine destiny!");
		this.setResizable(false);
		this.setSize(300, 170);
		this.setLocation(300, 300);
		
		gameLabel = new JLabel(game.getName());
		mapLabel = new JLabel(map.getName());
		modeLabel = new JLabel(mode.getName());
		challengeLabel = new JLabel(challenge.getName());
		
		mainPanel.setBorder(new TitledBorder("You Play"));
		mainPanel.setLayout(lm);
		((MainView)this.getParent()).addComponent(mainPanel, gameLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		((MainView)this.getParent()).addComponent(mainPanel, mapLabel, 0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		((MainView)this.getParent()).addComponent(mainPanel, modeLabel, 0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		
		challengePanel.setBorder(new TitledBorder("With Challenge"));
		challengePanel.setLayout(lm);
		((MainView)this.getParent()).addComponent(challengePanel, challengeLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		
		this.setLayout(lm);
		((MainView)this.getParent()).addComponent(this, mainPanel, 0, 0, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 1);
		((MainView)this.getParent()).addComponent(this, challengePanel, 0, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		
		this.setVisible(true);
	}
}