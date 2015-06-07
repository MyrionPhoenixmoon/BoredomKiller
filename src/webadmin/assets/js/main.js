var baseUrl = 'http://localhost/BoredomKiller/src/webadmin/';

function resetValidation() {
    $('.control-group').removeClass('error');
    $('.error-span').html('');
}

function renderValidation(data) {
    $.each(data, function(index, value) {
        $('#error_' + index).html(value);
        $('#' + index).parent().addClass('error');
    });
}

function showMessage(msg, level) {
    $('.message-bar').addClass(level);
    $('#alert_text').html(msg);
    $('.message-bar').fadeIn('slow');
    setTimeout(function() {
        $('.message-bar').fadeOut('slow', function() {
            $('.message-bar').removeClass(level)
            $('#alert_text').html('');
        });
    }, 5000);
}