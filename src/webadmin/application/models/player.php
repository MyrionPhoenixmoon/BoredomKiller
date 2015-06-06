<?php

/**
 * Model of the tbl_players table
 *
 * @author patrick
 */
class Player extends BK_Model
{

    /**
     * Table name
     */
    const dbTable = 'tbl_players';
    
    /**
     * Player id
     * @var integer
     */
    public $id;
    
    /**
     * Player name
     * @var string
     */
    public $name;
    
    /**
     * Statistic id
     * @var integer
     */
    public $id_statistic;
    
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
     * @return boolean|\Player
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
     * @return type
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Name setter
     * @param string $name
     * @return \Player
     */
    public function setName($name)
    {
        $this->name = $name;
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
     * @return boolean|\Player
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


}
