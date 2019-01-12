$(document).on('click', '.navbar-collapse.in', function (e) {
    if ($(e.target).is('a:not(".dropdown-toggle")')) {
        $(this).collapse('hide');
    }
});

$('#addBranchBth').submit(function (e) {
    e.preventDefault();
    // Coding
    $('#addBranch').modal('toggle'); //or  $('#IDModal').modal('hide');
    return false;
});

$(document).on('change', 'select', function () {
    $('option[value="disabled"]').prop('disabled', false);
    $(this).addClass('exception');
    $('option[value="' + this.value + '"]:not(.exception *)').prop('disabled', true);
    $(this).removeClass('exception');
});

$(document).ready(function () {
    $("form#startMatch").submit(function () {

        var clikedForm = $(this); // Select Form
        console.log(clikedForm.find($("#playerOne")).val());
        console.log(clikedForm.find($("#playerTwo")).val());

        if (clikedForm.find($("#playerOne")).val() == clikedForm.find($("#playerTwo")).val()) {
            alert('Technically it is not possible to play with oneself!');
            return false;
        }

    });
});