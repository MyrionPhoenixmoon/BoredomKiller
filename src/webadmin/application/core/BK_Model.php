<?php

if (!defined('BASEPATH')) {
  exit('No direct script access allowed');
}

/**
 * Extended Core model loading some basic static variables like DB in the
 * constructor to use in the static context.
 * Now to use the model, you just load the model as you would normally do in
 * CodeIgniter and the access the static functions of the class.
 * Use this class for any model.
 * 
 * @copyright (c) 2013, Patrick Manser
 * @author Patrick Manser <pat.manser@studcom.ch>
 */
class BK_Model extends CI_Model
{
  /**
   * Placeholder for dbTable constant. Should be overridden in every model.
   */

  const dbTable = '';

  /**
   * CodeIgniter Database Driver.
   * @var CI_DB 
   */
  protected static $db;

  /**
   * Constructor. Loads some basic variables and assigns them to the static
   * variables for easy access from within static functions in the models.
   */
  public function __construct()
  {
    parent::__construct();
    $ci = & get_instance();
    self::$db = & $ci->db;
  }

  /**
   * Matches data coming from the DB to an object or an array of objects of this class. 
   * @param array $data DB data
   * @return boolean|array|\Usergroup_Model
   */
  public static function dbToObject($data)
  {
    if (is_array($data)) {
      $arr = array();
      foreach ($data as $row) {
        $arr[] = static::dbToObject($row);
      }
      return $arr;
    }

    $obj = new static();
    foreach (get_object_vars($data) as $key => $value) {
      $obj->$key = $data->$key;
    }
    return $obj;
  }

  /**
   * Finds records in the database. For easier usage, the various find... functions redirect to this
   * function and just add additional arguments.
   * @param string|array $fields An associative array with the fields and their values to use in the WHERE-clause.
   * @param string $table Table name
   * @param boolean $forceObject If TRUE, the result will be a single object (first row only), otherwise this function returns an array of objects.
   * @param boolean $showDeleted If FALSE (default) and the static variable $dbDeletedFlag has been defined in the class records marked as deleted won't be returned.
   * @return boolean|\static|array FALSE on any error, the model object alone or in an array otherwise.
   */
  private static function _find($fields, $table, $forceObject, $show_deleted)
  {
    if ($table == static::dbTable) {
      if (isset(static::$dbOrderBy) && is_array(static::$dbOrderBy)) {
        foreach (static::$dbOrderBy as $field => $dir) {
          self::$db->order_by($field, $dir);
        }
      }
    }
    if ($fields !== NULL) {
      self::$db->where($fields);
    }
    if ((isset(static::$dbDeletedFlag)) && (static::$dbDeletedFlag != '') && ($show_deleted === FALSE) && ($table == static::dbTable)) {
      self::$db->where(static::$dbDeletedFlag, FALSE);
    }
    $query = self::$db->get($table);
    $result = $query->result();
    if ($forceObject === TRUE) {
      if (isset($result[0])) {
        return static::dbToObject($result[0]);
      } else {
        return FALSE;
      }
    }
    return static::dbToObject($result);
  }

  /**
   * Finds records in the database according to the parameters given.
   * @param string|array $fields An associative array with the fields and their values to use in the WHERE-clause.
   * @param boolean $forceObject If TRUE, the result will be a single object (first row only), otherwise this function returns an array of objects.
   * @param boolean $showDeleted If FALSE (default) and the static variable $dbDeletedFlag has been defined in the class records marked as deleted won't be returned.
   * @return boolean|\static|array FALSE on any error, the model object alone or in an array otherwise.
   */
  public static function find($fields = NULL, $forceObject = FALSE, $show_deleted = FALSE)
  {
    return self::_find($fields, static::dbTable, $forceObject, $show_deleted);
  }

  /**
   * Finds a single record in the database.
   * @param string|array $fields An associative array with the fields and their values to use in the WHERE-clause.
   * @param boolean $showDeleted If FALSE (default) and the static variable $dbDeletedFlag has been defined in the class records marked as deleted won't be returned.
   * @return boolean|\static FALSE on any error, the model object otherwise.
   */
  public static function findObject($fields = NULL, $show_deleted = FALSE)
  {
    return self::_find($fields, static::dbTable, TRUE, $show_deleted);
  }

  /**
   * Finds records in a specific table in the database.
   * @param string|array $fields An associative array with the fields and their values to use in the WHERE-clause.
   * @param string $table Table name
   * @param boolean $forceObject If TRUE, the result will be a single object (first row only), otherwise this function returns an array of objects.
   * @param boolean $showDeleted If FALSE (default) and the static variable $dbDeletedFlag has been defined in the class records marked as deleted won't be returned.
   * @return boolean|\static|array FALSE on any error, the model object alone or in an array otherwise.
   */
  public static function findInTable($fields = NULL, $table = NULL, $forceObject = FALSE, $show_deleted = FALSE)
  {
    if ($table == NULL) {
      $table = static::dbTable;
    }
    return self::_find($fields, $table, $forceObject, $show_deleted);
  }

  /**
   * Saves the current object to the database and update the ID property of the object (if it exists).
   * @return integer|boolean The insert id on success, FALSE on any error.
   */
  public function insert()
  {
    if (self::$db->insert(static::dbTable, $this)) {
      if (property_exists(get_called_class(), 'id')) {
        $this->id = self::$db->insert_id();
      }
      return self::$db->insert_id();
    } else {
      return FALSE;
    }
  }

  /**
   * Updates the current object in the database.
   * @param boolean $dropNullValues if TRUE, the Method will unset all NULL Values.
   * @return boolean TRUE on success, FALSE otherwise.
   */
  public function update($dropNullValues = false)
  {
    if (true === $dropNullValues) {
      foreach ($this as $key => $value) {
        if (NULL === $value) {
          unset($this->$key);
        }
      }
    }
    self::$db->where('id', $this->getId());
    return self::$db->update(static::dbTable, $this);
  }

  /**
   * Deletes the current object from the database. If the static variable
   * $dbDeletedFlag has been set in the DB, the record will be marked as deleted
   * instead of being really deleted.
   * @return boolean TRUE on success, FALSE otherwise.
   */
  public function delete()
  {
    if ((isset(static::$dbDeletedFlag)) && (static::$dbDeletedFlag != '')) {
      self::$db->set('deleted', TRUE);
      self::$db->where(array('id' => $this->getId()));
      return self::$db->update(static::dbTable);
    } else {
      return self::$db->delete(static::dbTable, array('id' => $this->getId()));
    }
  }

}