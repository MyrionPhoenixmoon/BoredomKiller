$(document).ready(function() {
    /* Open Modal to add a new malus */
    $('#btn_add_malus').bind('click', function() {
        $('#malus_form_title').html('Add malus');
        $('#modal_malus_form').modal('show');
    });
	
    /* Close form modal and reset form */
    $('#modal_malus_close').bind('click', function() {
        $('#modal_malus_form').modal('hide');
        $('#malus_form_title').html('');
        $('#malus_id').val(0);
        $('#malus_name').val('');
        $('#malus_rating').val('');
        $('#malus_description').val('');
        resetValidation();
    });
    
    /* Add new malus or edit existing one */
    $('#btn_save_malus').bind('click', function() {
        $.ajax({
            url: baseUrl + 'maluses/saveAsync',
            type: 'post',
            dataType: 'json',
            data: $('#malus_form').serialize(),
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
                    $('#modal_malus_form').modal('hide');
                    $('#malus_form_title').html('');
                    $('#malus_id').val(0);
                    $('#malus_name').val('');
                    $('#malus_rating').val('');
                    $('#malus_description').val('');
                }
            }
        });
    });
    
    /* Load maluses and show modal with respective data */
    $('.btn_edit_malus').click(function(evt) {
        $.ajax({
            url: baseUrl + 'maluses/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                malus_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#malus_form_title').html('Edit malus');
                $('#malus_id').val(data.id);
                $('#malus_name').val(data.name);
                $('#malus_rating').val(data.rating);
                $('#malus_description').val(data.description);
                $('#modal_malus_form').modal('show');
            }
        });
    });
    
    /* Load data and show it to a modal. Give warning to user */
    $('.btn_delete_malus').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'maluses/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                malus_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#malus_id_delete').val(data.id);
                $('#malus_name_delete').html(data.name);
                $('#modal_malus_delete').modal('show');
            }
        });
    });
    
    /* Delete a malus */
    $('#btn_delete_malus').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'maluses/deleteAsync',
            type: 'post',
            dataType: 'json',
            data: {
                malus_id: $('#malus_id_delete').val()
            },
            success: function(data) {
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_malus_delete').modal('hide');
                    $('#malus_id_delete').val(0);
                    $('#malus_name_delete').html('');
                }
            }
        });
    });
    
    /* Close warning modal */
    $('.modal_malus_delete_close').bind('click', function() {
        $('#modal_malus_delete').modal('hide');
        $('#malus_id_delete').val(0);
        $('#malus_name_delete').html('');
    });
});