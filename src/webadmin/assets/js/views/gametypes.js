$(document).ready(function() {
    /* Open modal to add a new gametype */
    $('#btn_add_gametype').bind('click', function() {
        $('#gametype_form_title').html('Add new gametype');
        $('#modal_gametype_form').modal('show');
    });
    
    /* Close form modal and reset form */
    $('#modal_gametype_close').bind('click', function() {
        $('#modal_gametype_form').modal('hide');
        $('#gametype_form_title').html('');
        $('#gametype_id').val(0);
        $('#gametype_name').val('');
        resetValidation();
    });
    
    /* Add new gametype or edit existing one */
    $('#btn_save_gametype').bind('click', function() {
        $.ajax({
            url: baseUrl + 'gametypes/saveAsync',
            type: 'post',
            dataType: 'json',
            data: $('#gametype_form').serialize(),
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
                    $('#modal_gametype_form').modal('hide');
                    $('#gametype_form_title').html('');
                    $('#gametype_id').val(0);
                    $('#gametype_name').val('');
                }
            }
        });
    });
    
    /* Load gametypes and show modal with respective data */
    $('.btn_edit_gametype').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'gametypes/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                gametype_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#gametype_form_title').html('Edit gametype');
                $('#gametype_id').val(data.id);
                $('#gametype_name').val(data.name);
                $('#modal_gametype_form').modal('show');
            }
        });
    });
    
    /* Load gametypes and show a modal with a warning message */
    $('.btn_delete_gametype').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'gametypes/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                gametype_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#gametype_id_delete').val(data.id);
                $('#gametype_name_delete').html(data.name);
                $('#modal_gametype_delete').modal('show');
            }
        });
    });
    
    /* Delete a gametype */
    $('#btn_delete_gametype').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'gametypes/deleteAsync',
            type: 'post',
            dataType: 'json',
            data: {
                gametype_id: $('#gametype_id_delete').val()
            },
            success: function(data) {
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_gametype_delete').modal('hide');
                    $('#gametype_id_delete').val(0);
                    $('#gametype_name_delete').html('');
                }
            }
        });
    });
    
    /* Close warning modal */
    $('.modal_gametype_delete_close').bind('click', function() {
        $('#modal_gametype_delete').modal('hide');
        $('#gametype_id_delete').val(0);
        $('#gametype_name_delete').html('');
    });
});