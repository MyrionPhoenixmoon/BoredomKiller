$(document).ready(function() {
    /* Open Modal to add a new player */
    $('#btn_add_player').bind('click', function() {
        $('#player_form_title').html('Add player');
        $('#modal_player_form').modal('show');
    });
	
    /* Close form modal and reset form */
    $('#modal_player_close').bind('click', function() {
        $('#modal_player_form').modal('hide');
        $('#player_form_title').html('');
        $('#player_id').val(0);
        $('#player_name').val('');
        resetValidation();
    });
    
    /* Add new player or edit existing one */
    $('#btn_save_player').bind('click', function() {
        $.ajax({
            url: baseUrl + 'players/saveAsync',
            type: 'post',
            dataType: 'json',
            data: $('#player_form').serialize(),
            success: function(data) {
                resetValidation();
                if (typeof data.error !== 'undefined') {
                    renderValidation(data.error);
                }
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_player_form').modal('hide');
                    $('#player_form_title').html('');
                    $('#player_id').val(0);
                    $('#player_name').val('');
                }
            }
        });
    });
    
    /* Load players and show modal with respective data */
    $('.btn_edit_player').click(function(evt) {
        $.ajax({
            url: baseUrl + 'players/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                player_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#player_form_title').html('Edit player');
                $('#player_id').val(data.id);
                $('#player_name').val(data.name);
                $('#modal_player_form').modal('show');
            }
        });
    });
    
    /* Load data and show it to a modal. Give warning to user */
    $('.btn_delete_player').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'players/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                player_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#player_id_delete').val(data.id);
                $('#player_name_delete').html(data.name);
                $('#modal_player_delete').modal('show');
            }
        });
    });
    
    /* Delete a player */
    $('#btn_delete_player').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'players/deleteAsync',
            type: 'post',
            dataType: 'json',
            data: {
                player_id: $('#player_id_delete').val()
            },
            success: function(data) {
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_player_delete').modal('hide');
                    $('#player_id_delete').val(0);
                    $('#player_name_delete').html('');
                }
            }
        });
    });
    
    /* Close warning modal */
    $('.modal_player_delete_close').bind('click', function() {
        $('#modal_player_delete').modal('hide');
        $('#player_id_delete').val(0);
        $('#player_name_delete').html('');
    });
});