<?php

/**
 * Maluses controller
 *
 * @author patrick
 */
class Maluses extends CI_Controller
{

    /**
     * Controller constructor
     */
    public function __construct()
    {
        parent::__construct();
        $this->load->model(array(
            'malus',
        ));
    }
    
    /**
     * Index action
     */
    public function index()
    {
        $data['js'] = array(
            'views/maluses.js',
        );
        $data['maluses'] = Malus::find();
        View::render('maluses/index', $data);
    }
    
    /**
     * Asynchronous method to add new maluses
     * @return void
     */
    public function saveAsync()
    {
        $id = intval($this->input->post('malus_id'));
        $this->form_validation->set_rules('malus_name', 'Name', 'trim|required')
                              ->set_rules('malus_description', 'Description', 'trim|required')
                              ->set_rules('malus_rating', 'Rating', 'trim|required');
        if (!$this->form_validation->run()) {
            echo json_encode(array('error' => $this->form_validation->getErrorArray()));
            return;
        }
        if ($id == 0) { // add new malus
            $malus = new Malus();
            $malus->setName($this->input->post('malus_name'))
                  ->setDescription($this->input->post('malus_description'))
                  ->setRating($this->input->post('malus_rating'));
            if (!$malus->insert()) {
                echo json_encode(array('failure' => 'Something went wrong. The malus could not be saved'));
            } else {
                echo json_encode(array('success' => 'Malus successfully saved.'));
            }
        } else { // edit existing malus
            $malus = Malus::find(array('id' => $id), true);
            $malus->setName($this->input->post('malus_name'))
                  ->setDescription($this->input->post('malus_description'))
                  ->setRating($this->input->post('malus_rating'));
            if (!$malus->update(true)) {
                echo json_encode(array('failure' => 'Something went wrong. The malus could not be saved.'));
            } else {
                echo json_encode(array('success' => 'Successfully edited malus'));
            }
        }
    }
    
    /**
     * Asynchronous method to delete a malus
     * @return void
     */
    public function deleteAsync()
    {
        $id = intval($this->input->post('malus_id'));
        if ($id < 1) {
            echo json_encode(array('failure' => 'Wrong ID.'));
            return;
        }
        $malus = Malus::find(array('id' => $id), true);
        if (!$malus->delete()) {
            echo json_encode(array('failure' => 'The malus could not be deleted.'));
        } else {
            echo json_encode(array('success' => 'Malus successfully deleted.'));
        }
    }
    
    /**
     * Asynchronous method to load malus
     */
    public function loadDataAsync()
    {
        $id = intval($this->input->post('malus_id'));
        $malus = Malus::find(array('id' => $id), true);
        echo json_encode($malus);
    }
}
