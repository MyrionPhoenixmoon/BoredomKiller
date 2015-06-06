<?php

/**
 * Model for the tbl_maps table
 *
 * @author patrick
 */
class Map extends BK_Model
{
    
    /**
     * Table name
     */
    const dbTable = 'tbl_maps';
    
    /**
     * Relation to the playstyle table
     * @var string
     */
    public static $dbRelTablePlaystyle = 'tbl_map_has_playstyle';
    
    /**
     * Map id
     * @var integer
     */
    public $id;
    
    /**
     * Map name
     * @var string
     */
    public $name;
    
    /**
     * Id of the game to which the map belongs to
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
     * @return boolean|\Map
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
     * @return \Map
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
     * @return boolean|\Map
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
