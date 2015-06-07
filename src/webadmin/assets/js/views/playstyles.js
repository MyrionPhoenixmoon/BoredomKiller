$(document).ready(function() {
    /* Open Modal to add a new playstyle */
    $('#btn_add_playstyle').bind('click', function() {
        $('#playstyle_form_title').html('Add playstyle');
        $('#modal_playstyle_form').modal('show');
    });
	
    /* Close form modal and reset form */
    $('#modal_playstyle_close').bind('click', function() {
        $('#modal_playstyle_form').modal('hide');
        $('#playstyle_form_title').html('');
        $('#playstyle_id').val(0);
        $('#playstyle_name').val('');
        resetValidation();
    });
    
    /* Add new playstyle or edit existing one */
    $('#btn_save_playstyle').bind('click', function() {
        $.ajax({
            url: baseUrl + 'playstyles/saveAsync',
            type: 'post',
            dataType: 'json',
            data: $('#playstyle_form').serialize(),
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
                    $('#modal_playstyle_form').modal('hide');
                    $('#playstyle_form_title').html('');
                    $('#playstyle_id').val(0);
                    $('#playstyle_name').val('');
                }
            }
        });
    });
    
    /* Load playstyles and show modal with respective data */
    $('.btn_edit_playstyle').click(function(evt) {
        $.ajax({
            url: baseUrl + 'playstyles/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                playstyle_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#playstyle_form_title').html('Edit playstyle');
                $('#playstyle_id').val(data.id);
                $('#playstyle_name').val(data.name);
                $('#modal_playstyle_form').modal('show');
            }
        });
    });
    
    /* Load data and show it to a modal. Give warning to user */
    $('.btn_delete_playstyle').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'playstyles/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                playstyle_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#playstyle_id_delete').val(data.id);
                $('#playstyle_name_delete').html(data.name);
                $('#modal_playstyle_delete').modal('show');
            }
        });
    });
    
    /* Delete a playstyle */
    $('#btn_delete_playstyle').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'playstyles/deleteAsync',
            type: 'post',
            dataType: 'json',
            data: {
                playstyle_id: $('#playstyle_id_delete').val()
            },
            success: function(data) {
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_playstyle_delete').modal('hide');
                    $('#playstyle_id_delete').val(0);
                    $('#playstyle_name_delete').html('');
                }
            }
        });
    });
    
    /* Close warning modal */
    $('.modal_playstyle_delete_close').bind('click', function() {
        $('#modal_playstyle_delete').modal('hide');
        $('#playstyle_id_delete').val(0);
        $('#playstyle_name_delete').html('');
    });
});