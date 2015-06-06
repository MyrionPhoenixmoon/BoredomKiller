<?php

/**
 * Returns the base URL + 'assets/'. If provided, it also
 * returns additional Subfolders
 * 
 * @param string $subFolder Additional Subfolders to return
 * @return string The URL to assets/ + additional Subfolders
 */
function asset_url($subFolder = '')
{
  if ('' != $subFolder) {
    return base_url().'assets/'.$subFolder;
  }
  return base_url().'assets/';
}