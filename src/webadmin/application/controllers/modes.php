<?php

/**
 * Description of modes
 *
 * @author patrick
 */
class Modes extends CI_Controller
{

    /**
     * Controller constructor
     */
    public function __construct()
    {
        parent::__construct();
        $this->load->model(array(
            'mode',
            'playstyle',
            'game',
        ));
    }

    /**
     * Index action
     */
    public function index()
    {
        $data['js'] = array(
            'views/modes.js',
        );
        $data['modes'] = Mode::find();
        foreach ($data['modes'] as $mode) {
            $data['mode_games'][$mode->id] = Game::find(array('id' => $mode->id_game));
        }
        $data['playstyles'] = Playstyle::find();
        $data['games'] = Game::find();
        View::render('modes/index', $data);
    }

    /**
     * Asynchronous method to add new modes or edit existing ones
     * @return void
     */
    public function saveAsync()
    {
        $id = intval($this->input->post('mode_id'));
        $this->form_validation->set_rules('mode_name', 'Name', 'trim|required')
                              ->set_rules('mode_playstyle', 'Playstyle', 'required')
                              ->set_rules('mode_game', 'Game', 'trim|required');
        if (!$this->form_validation->run()) {
            echo json_encode(array('error' => $this->form_validation->getErrorArray()));
            return;
        }
        if ($id == 0) { // add new mode
            $mode = new Mode();
            $mode->setName($this->input->post('mode_name'))
                 ->setIdGame($this->input->post('mode_game'));
            if (!$mode->insert()) {
                echo json_encode(array('failure' => 'Something went wrong. Mode could not be saved.'));
                return;
            } else {
                echo json_encode(array('success' => 'Mode successfully saved.'));
            }
            $idMode = $this->db->insert_id();
            foreach ($this->input->post('mode_playstyle') as $playstyle) {
                $this->db->insert(Mode::$dbRelTablePlaystyles, array(
                    'id_mode' => $idMode,
                    'id_playstyle' => $playstyle,
                ));
            }
        } else { // edit existing mode
            $mode = Mode::find(array('id' => $id), true);
            $mode->setName($this->input->post('mode_name'))
                 ->setIdGame($this->input->post('mode_game'));
            if (!$mode->update(true)) {
                echo json_encode(array('failure' => 'Something went wrong. Mode could not be saved.'));
                return;
            } else {
                echo json_encode(array('success' => 'Mode successfully saved.'));
            }
            $this->db->delete(Mode::$dbRelTablePlaystyles, array('id_mode' => $id));
            foreach ($this->input->post('mode_playstyle') as $playstyle) {
                $this->db->insert(Mode::$dbRelTablePlaystyles, array(
                    'id_mode' => $id,
                    'id_playstyle' => $playstyle,
                ));
            }
        }
    }

}
