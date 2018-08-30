function parseJSON(response) {
    if(!response.gameEnded) {

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
        document.getElementById("balance").innerText = "Your Balance is " + response.yourBalance + "$";
        document.getElementById("yourWin").innerText = "Your Win " + response.yourWinBalance + "$";

        $('#exampleModal').modal({
            backdrop: 'static',
            keyboard: false
        }, 'show');

    }
      else {


    }



    }

    $(document).ready(function () {


        $("#inputButtonPaper").click(function () {
            var bla = $('#inputButtonPaper').val();
            var radioButton = Number($('[name="optradio"]:checked').closest('label').text());

            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "game",
                "method": "POST",
                "headers": {
                    "guess": bla,
                    "radioButton": radioButton,
                }
            }

            $.ajax(settings).done(function (response) {
                parseJSON(response);
                $('#result').text(response.message);
            });
        });
        $("#inputButtonRock").click(function () {
            var bla = $('#inputButtonRock').val();
            var radioButton = Number($('[name="optradio"]:checked').closest('label').text());

            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "game",
                "method": "POST",
                "headers": {
                    "guess": bla,
                    "radioButton": radioButton,
                }
            }

            $.ajax(settings).done(function (response) {
                parseJSON(response);
                $('#result').text(response.message);
            });
        });
        $("#inputButtonScissors").click(function () {
            var bla = $('#inputButtonScissors').val();
            var radioButton = Number($('[name="optradio"]:checked').closest('label').text());

            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "game",
                "method": "POST",
                "headers": {
                    "guess": bla,
                    "radioButton": radioButton,
                }
            }

            $.ajax(settings).done(function (response) {

                parseJSON(response);
                $('#result').text(response.message);
            });
        });



    });