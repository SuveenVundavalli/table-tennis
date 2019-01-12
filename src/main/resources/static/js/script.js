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