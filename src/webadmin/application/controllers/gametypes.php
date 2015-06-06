<?php

/**
 * Gametype controller
 *
 * @author patrick
 */
class Gametypes extends CI_Controller
{

    /**
     * Controller constructor
     */
    public function __construct()
    {
        parent::__construct();
        $this->load->model(array(
            'gametype',
            'game',
        ));
    }
    
    /**
     * Index action
     */
    public function index()
    {
        $data['js'] = array(
            'views/gametypes.js',
        );
        $data['gametypes'] = Gametype::find();
        View::render('gametypes/index', $data);
    }
    
    /**
     * Asynchronous method to save gametypes
     * @return void
     */
    public function saveAsync()
    {
        $id = intval($this->input->post('gametype_id'));
        $this->form_validation->set_rules('gametype_name', 'Name', 'trim|required');
        if (!$this->form_validation->run()) {
            echo json_encode(array('error' => $this->form_validation->getErrorArray()));
            return;
        }
        if ($id == 0) { // add new gametype
            $gametype = new Gametype();
            $gametype->setName($this->input->post('gametype_name'));
            if (!$gametype->insert()) {
                echo json_encode(array('failure' => 'Something went wrong. The gametype could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Gametype successfully added.'));
            }
        } else { // edit existing platform
            $gametype = Gametype::find(array('id' => $id), true);
            $gametype->setName($this->input->post('gametype_name'));
            if (!$gametype->update(true)) {
                echo json_encode(array('failure' => 'Something went wrong. The gametype could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Gametype successfully edited.'));
            }
        }
    }
    
    /**
     * Asynchronous method to delete a gametype
     * @return void
     */
    public function deleteAsync()
    {
        $id = intval($this->input->post('gametype_id'));
        if ($id < 1) {
            echo json_encode(array('failure' => 'Wrong ID.'));
            return;
        }
        $games = Game::findInTable(array('id_game_type' => $id), Game::$dbRelTableTypes);
        if (count($games) > 0) {
            $this->db->delete(Game::$dbRelTableTypes, array('id_gametype' => $id));
        }
        $gametype = Gametype::find(array('id' => $id), true);
        if (!$gametype->delete()) {
            echo json_encode(array('failure' => 'The gametype could not be deleted'));
        } else {
            echo json_encode(array('success' => 'Gametype successfully deleted'));
        }
    }
    
    /**
     * Asynchronous method to load gametypes
     */
    public function loadDataAsync()
    {
        $id = intval($this->input->post('gametype_id'));
        $gametype = Gametype::find(array('id' => $id), true);
        echo json_encode($gametype);
    }
}
