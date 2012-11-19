package ch.pajama.boredomkiller.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
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
	private JLabel descriptionLabel;
	
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
		this.setLocation(300, 300);
		
		gameLabel = new JLabel(game.getName());
		gameLabel.setForeground(new Color(150, 200, 255));
		mapLabel = new JLabel(map.getName());
		mapLabel.setForeground(new Color(220, 170, 255));
		modeLabel = new JLabel(mode.getName());
		modeLabel.setForeground(new Color(255, 150, 200));
		
		challengeLabel = new JLabel(challenge.getName());
		descriptionLabel = new JLabel("<html><p>" + challenge.getDescription() + "</p></html>");
		if(challenge.getDifficulty().getDifficulty().equals("Easy")){
			challengeLabel.setForeground(new Color(255, 255, 150));
			descriptionLabel.setForeground(new Color(255, 255, 150));
		} else if(challenge.getDifficulty().getDifficulty().equals("Medium")){
			challengeLabel.setForeground(new Color(255, 205, 150));
			descriptionLabel.setForeground(new Color(255, 205, 150));
		} else if(challenge.getDifficulty().getDifficulty().equals("Hard")){
			challengeLabel.setForeground(new Color(255, 155, 150));
			descriptionLabel.setForeground(new Color(255, 155, 150));
		}
		
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 150)), "You Play"));
		mainPanel.setLayout(lm);
		((MainView)this.getParent()).addComponent(mainPanel, gameLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		((MainView)this.getParent()).addComponent(mainPanel, mapLabel, 0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		((MainView)this.getParent()).addComponent(mainPanel, modeLabel, 0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 1);
		
		challengePanel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 150)), "With Challenge"));
		challengePanel.setLayout(lm);
		((MainView)this.getParent()).addComponent(challengePanel, challengeLabel, 0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1);
		((MainView)this.getParent()).addComponent(challengePanel, descriptionLabel, 0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1);
		
		this.setLayout(lm);
		((MainView)this.getParent()).addComponent(this, mainPanel, 0, 0, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, 1);
		((MainView)this.getParent()).addComponent(this, challengePanel, 0, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, 1);
		
		this.pack();
		this.setSize(250, this.getSize().height + 50);
		this.setVisible(true);
	}
}