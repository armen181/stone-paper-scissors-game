function parseJSON(response) {
    if (response.compValue == 1) {
        $('#compChosen').attr('src', 'pic/rock.jpg');
    } else if (response.compValue == 2) {
        $('#compChosen').attr('src', 'pic/paper.jpg');
    } else if (response.compValue == 3) {
        $('#compChosen').attr('src', 'pic/scissors.jpg');
    }
    if (response.yourValue == 1) {
        $('#yourChosen').attr('src', 'pic/rock.jpg');
    } else if (response.yourValue == 2) {
        $('#yourChosen').attr('src', 'pic/paper.jpg');
    } else if (response.yourValue == 3) {
        $('#yourChosen').attr('src', 'pic/scissors.jpg');

    }
    }

    $(document).ready(function () {


        $("#inputButtonPaper").click(function () {
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
                parseJSON(response);
                $('#result').text(response.message);
            });
        });

        $("#inputButtonRock").click(function () {
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
                parseJSON(response);
                $('#result').text(response.message);
            });
        });
        $("#inputButtonScissors").click(function () {
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
                parseJSON(response);
                $('#result').text(response.message);
            });
        });
    });