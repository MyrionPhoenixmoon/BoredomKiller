<?php

/**
 * Model for the tbl_modes table
 *
 * @author patrick
 */
class Mode extends BK_Model
{

    /**
     * Table name
     */
    const dbTable = 'tbl_modes';
    
    /**
     * Relation to the playstyles table
     * @var string
     */
    public static $dbRelTablePlaystyles = 'tbl_mode_has_playstyle';
    
    /**
     * Mode id
     * @var integer
     */
    public $id;
    
    /**
     * Mode name
     * @var string
     */
    public $name;
    
    /**
     * Id of the game to which the mode belongs to
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
     * @return boolean|\Mode
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
     * @return \Mode
     */
    public function setName($name)
    {
        $this->name = $name;
        return $this;
    }

    /**
     * Game id getter
     * @return integer
     */
    public function getIdGame()
    {
        return $this->id_game;
    }

    /**
     * Game id setter
     * @param integer $id_game
     * @return boolean|\Mode
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
