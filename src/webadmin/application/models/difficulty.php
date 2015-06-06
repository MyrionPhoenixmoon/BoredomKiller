<?php

/**
 * Model for the tbl_difficulty table
 *
 * @author patrick
 */
class Difficulty extends BK_Model
{
    
    /**
     * Table name
     */
    const dbTable = 'tbl_difficulties';
    
    /**
     * Difficulty id
     * @var integer
     */
    public $id;
    
    /**
     * Difficulty name
     * @var string
     */
    public $difficulty;
    
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
     * @return boolean|\Difficulty
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
     * Difficulty getter
     * @return string
     */
    public function getDifficulty()
    {
        return $this->difficulty;
    }

    /**
     * Difficulty setter
     * @param string $difficulty
     * @return \Difficulty
     */
    public function setDifficulty($difficulty)
    {
        $this->difficulty = $difficulty;
        return $this;
    }


}