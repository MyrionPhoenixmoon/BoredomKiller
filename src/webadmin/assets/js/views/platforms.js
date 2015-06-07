$(document).ready(function() {
    /* Open Modal to add a new platform */
    $('#btn_add_platform').bind('click', function() {
        $('#platform_form_title').html('Add platform');
        $('#modal_platform_form').modal('show');
    });
	
    /* Close form modal and reset form */
    $('#modal_platform_close').bind('click', function() {
        $('#modal_platform_form').modal('hide');
        $('#platform_form_title').html('');
        $('#platform_id').val(0);
        $('#platform_name').val('');
        resetValidation();
    });
	
    /* Add new platform or edit existing one */
    $('#btn_save_platform').bind('click', function() {
        $.ajax({
            url: baseUrl + 'platforms/saveAsync',
            type: 'post',
            dataType: 'json',
            data: $('#platform_form').serialize(),
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
                    $('#modal_platform_form').modal('hide');
                    $('#platform_form_title').html('');
                    $('#platform_id').val(0);
                    $('#platform_name').val('');
                }
            }
        });
    });
    
    /* Load platforms and show modal with respective data */
    $('.btn_edit_platform').click(function(evt) {
        $.ajax({
            url: baseUrl + 'platforms/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                platform_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#platform_form_title').html('Edit platform');
                $('#platform_id').val(data.id);
                $('#platform_name').val(data.name);
                $('#modal_platform_form').modal('show');
            }
        });
    });
    
    /* Load data and show it to a modal. Give warning to user */
    $('.btn_delete_platform').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'platforms/loadDataAsync',
            type: 'post',
            dataType: 'json',
            data: {
                platform_id: $(evt.target).attr('data-id')
            },
            success: function(data) {
                $('#platform_id_delete').val(data.id);
                $('#platform_name_delete').html(data.name);
                $('#modal_platform_delete').modal('show');
            }
        });
    });
    
    /* Delete a platform */
    $('#btn_delete_platform').bind('click', function(evt) {
        $.ajax({
            url: baseUrl + 'platforms/deleteAsync',
            type: 'post',
            dataType: 'json',
            data: {
                platform_id: $('#platform_id_delete').val()
            },
            success: function(data) {
                if (typeof data.failure !== 'undefined') {
                    showMessage(data.failure, 'error');
                }
                if (typeof data.success !== 'undefined') {
                    showMessage(data.success, 'success');
                    $('#modal_platform_delete').modal('hide');
                    $('#platform_id_delete').val(0);
                    $('#platform_name_delete').html('');
                }
            }
        });
    });
    
    /* Close warning modal */
    $('.modal_platform_delete_close').bind('click', function() {
        $('#modal_platform_delete').modal('hide');
        $('#platform_id_delete').val(0);
        $('#platform_name_delete').html('');
    });
});