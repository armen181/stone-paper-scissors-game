$(document).ready(function(){
    $("#inputButtonPaper").click(function(){
        var bla = $('#inputButtonPaper').val();

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
        });
    });

    $("#inputButtonRock").click(function(){
        var bla = $('#inputButtonRock').val();

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
        });
    });
    $("#inputButtonScissors").click(function(){
        var bla = $('#inputButtonScissors').val();

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
        });
    });
});