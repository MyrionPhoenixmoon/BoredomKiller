<?php

/**
 * Model for the tbl_game table
 *
 * @author patrick
 */
class Game extends BK_Model
{
    
    /**
     * Table name
     */
    const dbTable = 'tbl_games';
    
    /**
     * Relation to type table
     * @var string
     */
    public static $dbRelTableTypes = 'tbl_game_has_game_type';
    
    /**
     * Relation to playstyles table
     * @var string
     */
    public static $dbRelTablePlaystyles = 'tbl_game_has_playstyle';
    
    /**
     * Id of the game
     * @var integer
     */
    public $id;
    
    /**
     * Name of the game
     * @var string
     */
    public $name;
    
    /**
     * Path to the game theme
     * @var string
     */
    public $theme_loc;
    
    /**
     * Id of the game's statistic
     * @var integer
     */
    public $id_statistic;
    
    /**
     * Id of the platform
     * @var integer
     */
    public $id_platform;
    
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
     * @return boolean|\Game
     */
    public function setId($id)
    {
        $id = intval($id);
        if ($id < 1) {
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
     * @return \Game
     */
    public function setName($name)
    {
        $this->name = $name;
        return $this;
    }

    /**
     * Theme location getter
     * @return string
     */
    public function getThemeLoc()
    {
        return $this->theme_loc;
    }

    /**
     * Theme location setter
     * @param string $theme_loc
     * @return \Game
     */
    public function setThemeLoc($theme_loc)
    {
        $this->theme_loc = $theme_loc;
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
     * @return boolean|\Game
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
     * Platform id getter
     * @return integer
     */
    public function getIdPlatform()
    {
        return $this->id_platform;
    }

    /**
     * PLatform id setter
     * @param integer $id_platform
     * @return boolean|\Game
     */
    public function setIdPlatform($id_platform)
    {
        $id_platform = intval($id_platform);
        if ($id_platform < 0) {
            return FALSE;
        }
        $this->id_platform = $id_platform;
        return $this;
    }

}
