<?php

/**
 * Custom Form Validation class extending the core class
 * @copyright (c) 2013
 * @author Patrick Manser <pat.manser@gmail.ch>
 */
class BK_Form_validation extends CI_Form_validation {
  
  /**
   * Call parent constructor
   * @param Array $config
   */
  function __construct($config = array()) {
    parent::__construct($config);
  }
  
  /**
   * Returns an Array with all error messages
   * @return boolean|Array FALSE on error, Array with all error messages if success
   */
  public function getErrorArray() {
    if (count($this->_error_array) === 0) {
      return FALSE;
    }
    return $this->_error_array;
  }
  
}