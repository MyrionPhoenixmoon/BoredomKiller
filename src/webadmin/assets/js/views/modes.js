$(document).ready(function() {
    /* Open Modal to add a new mode */
    $('#btn_add_mode').bind('click', function() {
        $('#mode_form_title').html('Add mode');
        $('#modal_mode_form').modal('show');
    });
	
    /* Close form modal and reset form */
    $('#modal_mode_close').bind('click', function() {
        $('#modal_mode_form').modal('hide');
        $('#mode_form_title').html('');
        $('#mode_id').val(0);
        $('#mode_name').val('');
        $('#mode_game option[value=0]').prop('selected', true);
        $('#mode_description').val('');
        resetValidation();
    });
    
    /* Add new mode or edit existing one */
    $('#btn_save_mode').bind('click', function() {
        $.ajax({
            url: baseUrl + 'modes/saveAsync',
            type: 'post',
            dataType: 'json',
            data: $('#mode_form').serialize(),
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
                    $('#modal_mode_form').modal('hide');
                    $('#mode_form_title').html('');
                    $('#mode_id').val(0);
                    $('#mode_name').val('');
                    $('#mode_game').find('option').prop('value', 0);
                    $('#mode_description').val('');
                }
            }
        });
    });
    
    /* Load modes and show modal with respective data */
    $('.btn_edit_mode').click(function(evt) {
        $.ajax({
            url: baseUrl + 'modes/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                mode_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#mode_form_title').html('Edit mode');
                $('#mode_id').val(data.id);
                $('#mode_name').val(data.name);
                $('#mode_rating').val(data.rating);
                $('#mode_description').val(data.description);
                $('#modal_mode_form').modal('show');
            }
        });
    });
    
    /* Load data and show it to a modal. Give warning to user */
    $('.btn_delete_mode').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'modes/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                mode_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#mode_id_delete').val(data.id);
                $('#mode_name_delete').html(data.name);
                $('#modal_mode_delete').modal('show');
            }
        });
    });
    
    /* Delete a mode */
    $('#btn_delete_mode').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'modes/deleteAsync',
            type: 'post',
            dataType: 'json',
            data: {
                mode_id: $('#mode_id_delete').val()
            },
            success: function(data) {
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_mode_delete').modal('hide');
                    $('#mode_id_delete').val(0);
                    $('#mode_name_delete').html('');
                }
            }
        });
    });
    
    /* Close warning modal */
    $('.modal_mode_delete_close').bind('click', function() {
        $('#modal_mode_delete').modal('hide');
        $('#mode_id_delete').val(0);
        $('#mode_name_delete').html('');
    });
});