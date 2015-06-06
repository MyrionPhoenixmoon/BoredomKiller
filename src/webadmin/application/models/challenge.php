<?php

/**
 * Model for the tbl_challenge table
 *
 * @author patrick
 */
class Challenge extends BK_Model
{
    
    /**
     * Table name
     */
    const dbTable = 'tbl_challenges';
    
    /**
     * Relation to playstyle table
     * @var string
     */
    public static $dbRelTablePlaystyles = 'tbl_challenge_has_playstyle';
    
    /**
     * Id of the challenge
     * @var integer
     */
    public $id;
    
    /**
     * Name of the challenge
     * @var string
     */
    public $name;
    
    /**
     * Description of the challenge
     * @var string
     */
    public $description;
    
    /**
     * Id of the difficulty
     * @var integer
     */
    public $id_difficulty;
    
    /**
     * Id of the statistic
     * @var integer
     */
    public $id_statistic;
    
    /**
     * Id of the game type
     * @var integer
     */
    public $id_game_type;
    
    /**
     * Id of the game
     * @var integer
     */
    public $id_game;
    
    /**
     * Class constructor
     */
    public function __construct()
    {
        parent::__construct();
    }
    
    /**
     * Id getter
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Id setter
     * @param integer $id
     * @return boolean|\Challenge
     */
    public function setId($id)
    {
        $id = intval($id);
        if ($id < 0) {
            return FALSE;
        }
        $this->id = $id;
        return $this;
    }

    /**
     * Name getter
     * @return string
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Name setter
     * @param string $name
     * @return \Challenge
     */
    public function setName($name)
    {
        $this->name = $name;
        return $this;
    }

    /**
     * Description getter
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Description setter
     * @param string $description
     * @return \Challenge
     */
    public function setDescription($description)
    {
        $this->description = $description;
        return $this;
    }

    /**
     * Difficulty id getter
     * @return integer
     */
    public function getIdDifficulty()
    {
        return $this->id_difficulty;
    }

    /**
     * Difficulty id setter
     * @param integer $id_difficulty
     * @return boolean|\Challenge
     */
    public function setIdDifficulty($id_difficulty)
    {
        $id_difficulty = intval($id_difficulty);
        if ($id_difficulty < 0) {
            return FALSE;
        }
        $this->id_difficulty = $id_difficulty;
        return $this;
    }

    /**
     * Statistic id getter
     * @return integer
     */
    public function getIdStatistic()
    {
        return $this->id_statistic;
    }

    /**
     * Statistic id setter
     * @param integer $id_statistic
     * @return boolean|\Challenge
     */
    public function setIdStatistic($id_statistic)
    {
        $id_statistic = intval($id_statistic);
        if ($id_statistic < 0) {
            return FALSE;
        }
        $this->id_statistic = $id_statistic;
        return $this;
    }

    /**
     * Gametype id getter
     * @return integer
     */
    public function getIdGameType()
    {
        return $this->id_game_type;
    }

    /**
     * Gametype id setter
     * @param integer $id_game_type
     * @return boolean|\Challenge
     */
    public function setIdGameType($id_game_type)
    {
        $id_game_type = intval($id_game_type);
        if ($id_game_type < 0) {
            return FALSE;
        }
        $this->id_game_type = $id_game_type;
        return $this;
    }

    /**
     * Game id getter
     * @return integeer
     */
    public function getIdGame()
    {
        return $this->id_game;
    }

    /**
     * Game id setter
     * @param integer $id_game
     * @return boolean|\Challenge
     */
    public function setIdGame($id_game)
    {
        $id_game = intval($id_game);
        if ($id_game < 0) {
            return FALSE;
        }
        $this->id_game = $id_game;
        return $this;
    }

}