<?php

/**
 * Playstyle controller
 *
 * @author patrick
 */
class Playstyles extends CI_Controller
{

    /**
     * Controller constructor
     */
    public function __construct()
    {
        parent::__construct();
        $this->load->model(array(
            'playstyle',
            'challenge',
            'game',
            'map',
            'mode',
        ));
    }

    /**
     * Index action
     */
    public function index()
    {
        $data['js'] = array(
            'views/playstyles.js',
        );
        $data['playstyles'] = Playstyle::find();
        View::render('playstyles/index', $data);
    }

    /**
     * Asynchronous method to save playstyles
     * @return void
     */
    public function saveAsync()
    {
        $id = intval($this->input->post('playstyle_id'));
        $this->form_validation->set_rules('playstyle_name', 'Name', 'trim|required');
        if (!$this->form_validation->run()) {
            echo json_encode(array('error' => $this->form_validation->getErrorArray()));
            return;
        }
        if ($id == 0) { // add new playstyle
            $playstyle = new Playstyle();
            $playstyle->setName($this->input->post('playstyle_name'));
            if (!$playstyle->insert()) {
                echo json_encode(array('failure' => 'Something went wrong. The playstyle could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Playstyle successfully added.'));
            }
        } else { // edit existing playstyle
            $playstyle = Playstyle::find(array('id' => $id), true);
            $playstyle->setName($this->input->post('playstyle_name'));
            if (!$playstyle->update(true)) {
                echo json_encode(array('failure' => 'Something went wrong. The playstyle could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Playstyle successfully edited.'));
            }
        }
    }

    /**
     * Asynchronous method to delete a playstyle
     * @return void
     */
    public function deleteAsync()
    {
        $id = intval($this->input->post('playstyle_id'));
        if ($id < 1) {
            echo json_encode(array('failure' => 'Wrong ID.'));
            return;
        }
        $challenges = Challenge::findInTable(array('id_playstyle' => $id), Challenge::$dbRelTablePlaystyles);
        $games = Game::findInTable(array('id_playstyle' => $id), Game::$dbRelTablePlaystyles);
        $maps = Map::findInTable(array('id_playstyle' => $id), Map::$dbRelTablePlaystyle);
        $modes = Mode::findInTable(array('id_playstyle' => $id), Mode::$dbRelTablePlaystyles);
        if (count($challenges) > 0) {
            $this->db->delete(Challenge::$dbRelTablePlaystyles, array('id_playstyle' => $id));
        }
        if (count($games) > 0) {
            $this->db->delete(Game::$dbRelTablePlaystyles, array('id_playstyle' => $id));
        }
        if (count($maps) > 0) {
            $this->db->delete(Map::$dbRelTablePlaystyles, array('id_playstyle' => $id));
        }
        if (count($modes) > 0) {
            $this->db->delete(Mode::$dbRelTablePlaystyles, array('id_playstyle' => $id));
        }
        $playstyle = Playstyle::find(array('id' => $id), true);
        if (!$playstyle->delete()) {
            echo json_encode(array('failure' => 'The playstyle could not be deleted'));
        } else {
            echo json_encode(array('success' => 'Playstyle successfully deleted.'));
        }
    }

    /**
     * Asynchronous method to load playstyles
     */
    public function loadDataAsync()
    {
        $id = intval($this->input->post('playstyle_id'));
        $playstyle = Playstyle::find(array('id' => $id), true);
        echo json_encode($playstyle);
    }

}
