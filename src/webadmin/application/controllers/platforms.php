<?php

/**
 * Platforms controller
 *
 * @author patrick
 */
class Platforms extends CI_Controller
{

    /**
     * Controller constructor
     */
    public function __construct()
    {
        parent::__construct();
        $this->load->model(array(
            'platform',
            'game',
        ));
    }

    /**
     * Index action
     */
    public function index()
    {
        $data['js'] = array(
            'views/platforms.js',
        );
        $data['platforms'] = Platform::find();
        View::render('platforms/index', $data);
    }

    /**
     * Asynchronous method to save platforms
     * @return void
     */
    public function saveAsync()
    {
        $id = intval($this->input->post('platform_id'));
        $this->form_validation->set_rules('platform_name', 'Name', 'trim|required');
        if (!$this->form_validation->run()) {
            echo json_encode(array('error' => $this->form_validation->getErrorArray()));
            return;
        }
        if ($id == 0) { // add new platform
            $platform = new Platform();
            $platform->setName($this->input->post('platform_name'));
            if (!$platform->insert()) {
                echo json_encode(array('failure' => 'Something went wrong. The platform could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Platform successfully added.'));
            }
        } else { // edit existing platform
            $platform = Platform::find(array('id' => $id), true);
            $platform->setName($this->input->post('platform_name'));
            if (!$platform->update(true)) {
                echo json_encode(array('failure' => 'Something went wrong. The platform could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Platform successfully edited.'));
            }
        }
    }

    /**
     * Asynchronous method to delete a platform
     * @return void
     */
    public function deleteAsync()
    {
        $id = intval($this->input->post('platform_id'));
        if ($id < 1) {
            echo json_encode(array('failure' => 'Wrong ID.'));
            return;
        }
        $games = Game::find(array('id_platform' => $id));
        if (count($games) > 0) {
            echo json_encode(array('failure' => 'There are games which use this platform. Please edit/delete those first.'));
            return;
        }
        $platform = Platform::find(array('id' => $id), true);
        if (!$platform->delete()) {
            echo json_encode(array('failure' => 'The platform could not be deleted'));
        } else {
            echo json_encode(array('success' => 'Platform successfully deleted.'));
        }
    }

    /**
     * Asynchronous method to load platforms
     */
    public function loadDataAsync()
    {
        $id = intval($this->input->post('platform_id'));
        $platform = Platform::find(array('id' => $id), true);
        echo json_encode($platform);
    }

}
