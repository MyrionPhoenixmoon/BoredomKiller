<?php

/**
 * Model for the tbl_playstyles table
 *
 * @author patrick
 */
class Playstyle extends BK_Model
{
    
    /**
     * Table name
     */
    const dbTable = 'tbl_playstyles';
    
    /**
     * Playstyle id
     * @var integer
     */
    public $id;
    
    /**
     * Playstyle name
     * @var string
     */
    public $name;
    
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
     * @return boolean|\Playstyle
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
     * @return \Playstyle
     */
    public function setName($name)
    {
        $this->name = $name;
        return $this;
    }

}
