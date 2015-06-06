<?php

/**
 * Players controller
 *
 * @author patrick
 */
class Players extends CI_Controller
{

    /**
     * Controller constructor
     */
    public function __construct()
    {
        parent::__construct();
        $this->load->model(array(
            'player',
            'statistic',
        ));
    }
    
    /**
     * Index action
     */
    public function index()
    {
        $data['js'] = array(
            'views/players.js',
        );
        $data['players'] = Player::find();
        View::render('players/index', $data);
    }
    
    /**
     * Asynchronous method to add or edit players
     * @return void
     */
    public function saveAsync()
    {
        $id = intval($this->input->post('player_id'));
        $this->form_validation->set_rules('player_name', 'Name', 'trim|required');
        if (!$this->form_validation->run()) {
            echo json_encode(array('error' => $this->form_validation->getErrorArray()));
            return;
        }
        if ($id == 0) { // add new player
            $statistic = new Statistic();
            $statistic->setTimesPlayed(0)
                      ->setTotalPlaytime(0);
            if (!$statistic->insert()) {
                echo json_encode(array('failure' => 'Could not create a statistic entry for player ' . $this->input->post('player_name') . '. Aborting.'));
                return;
            }
            $idStatistic = $this->db->insert_id();
            $player = new Player();
            $player->setName($this->input->post('player_name'))
                   ->setIdStatistic($idStatistic);
            if (!$player->insert()) {
                echo json_encode(array('failure' => 'Something went wrong. Could not save player.'));
            } else {
                echo json_encode(array('success' => 'Successfully saved player'));
            }
        } else { // edit existing player
            $player = Player::find(array('id' => $id), true);
            $player->setName($this->input->post('player_name'));
            if (!$player->update(true)) {
                echo json_encode(array('failure' => 'Something went wrong. Could not save player.'));
            } else {
                echo json_encode(array('success' => 'Player successfully edited'));
            }
        }
    }
    
    /**
     * Asynchronous method to delete a player
     * @return void
     */
    public function deleteAsync()
    {
        $id = intval($this->input->post('player_id'));
        if ($id < 1) {
            echo json_encode(array('failure' => 'Wrong ID.'));
            return;
        }
        $player = Player::find(array('id' => $id), true);
        $statistic = Statistic::find(array('id' => $player->id_statistic), true);
        if (!$player->delete()) {
            echo json_encode(array('failure' => 'The player could not be deleted'));
        } else {
            echo json_encode(array('success' => 'Player successfully deleted.'));
        }
        $statistic->delete();
    }

    /**
     * Asynchronous method to load players
     */
    public function loadDataAsync()
    {
        $id = intval($this->input->post('player_id'));
        $player = Player::find(array('id' => $id), true);
        echo json_encode($player);
    }
}
