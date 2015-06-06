<?php

/**
 * Model for the tbl_platforms table
 *
 * @author patrick
 */
class Platform extends BK_Model
{

    /**
     * Table name
     */
    const dbTable = 'tbl_platforms';
    
    /**
     * Platform id
     * @var integer
     */
    public $id;
    
    /**
     * Platform name
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
     * @return boolean|\Platform
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
     * @return \Platform
     */
    public function setName($name)
    {
        $this->name = $name;
        return $this;
    }


}
