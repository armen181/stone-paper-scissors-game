$(document).ready(function(){
    $("button").click(function(){
        var bla = $('#number').val();

        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "test",
            "method": "POST",
            "headers": {
                "guess": bla,
            }
        }

        $.ajax(settings).done(function (response) {
            $('#result').text(response);
            console.log(response);
        });
    });
});