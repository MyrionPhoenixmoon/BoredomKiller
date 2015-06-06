<?php

/**
 * Model for the tbl_malus table
 *
 * @author patrick
 */
class Malus extends BK_Model
{
    
    /**
     * Table name
     */
    const dbTable = 'tbl_maluses';
    
    /**
     * Malus id
     * @var integer
     */
    public $id;
    
    /**
     * Malus name
     * @var string
     */
    public $name;
    
    /**
     * Malus description
     * @var string
     */
    public $description;
    
    /**
     * Malus rating
     * @var string
     */
    public $rating;
    
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
     * @return boolean|\Malus
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
     * @return \Malus
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
     * Description getter
     * @param string $description
     * @return \Malus
     */
    public function setDescription($description)
    {
        $this->description = $description;
        return $this;
    }

    /**
     * Rating getter
     * @return string
     */
    public function getRating()
    {
        return $this->rating;
    }

    /**
     * Rating setter
     * @param string $rating
     * @return \Malus
     */
    public function setRating($rating)
    {
        $this->rating = $rating;
        return $this;
    }


}
