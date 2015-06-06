<?php

/**
 * View rendering class
 *
 * @author patrick
 */
class View
{

    public static function render($view, $data = array())
    {
        $ci = & get_instance();
        is_array($data) OR $data = (array) $data;

        $ci->output->set_header('Expires: Sat, 01 Jan 2000 00:00:01 GMT');
        $ci->output->set_header('Cache-Control: no-store, no-cache, must-revalidate');
        $ci->output->set_header('Cache-Control: post-check=0, pre-check=0, max-age=0');
        $ci->output->set_header('Last-Modified: ' . gmdate('D, d M Y H:i:s') . ' GMT');
        $ci->output->set_header('Pragma: no-cache');

        $ci->load->view('header', $data);
        $ci->load->view($view, $data);
        $ci->load->view('footer', $data);
    }

}
