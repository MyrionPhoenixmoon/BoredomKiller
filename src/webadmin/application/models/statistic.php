<?php

/**
 * Model for the tbl_statistics table
 *
 * @author patrick
 */
class Statistic extends BK_Model
{

    /**
     * Table name
     */
    const dbTable = 'tbl_statistics';
    
    /**
     * Statistic id
     * @var integer
     */
    public $id;
    
    /**
     * Number of plays
     * @var integer
     */
    public $times_played;
    
    /**
     * Playtime timestamp
     * @var integer
     */
    public $total_playtime;
    
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
     * @return boolean|\Statistic
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
     * Times played getter
     * @return integer
     */
    public function getTimesPlayed()
    {
        return $this->times_played;
    }

    /**
     * Times played setter
     * @param integer $times_played
     * @return \Statistic
     */
    public function setTimesPlayed($times_played)
    {
        $this->times_played = $times_played;
        return $this;
    }

    /**
     * Playtime getter
     * @return integer
     */
    public function getTotalPlaytime()
    {
        return $this->total_playtime;
    }

    /**
     * Playtime setter
     * @param integer $total_playtime
     * @return \Statistic
     */
    public function setTotalPlaytime($total_playtime)
    {
        $this->total_playtime = $total_playtime;
        return $this;
    }

}
