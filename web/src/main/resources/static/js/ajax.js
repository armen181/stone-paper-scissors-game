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



    }
      else {
        document.getElementById("yourWinID").innerText =response.yourWinBalance;
        $('#exampleModal').modal({
            backdrop: 'static',
            keyboard: false
        }, 'show');

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
        $("#resetGame").click(function () {
            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "game",
                "method": "GET",
                "headers": {
                }
            }

            $.ajax(settings).done(function (response) {

                parseJSON(response);
                $('#result').text(response.message);
                $('#exampleModal').modal('hide');

            });
        });
        $("#saveNameBtn").click(function () {
            var bla = document.getElementById("yourWinID").innerText;
            var name = $('#nameForTable').val();//document.getElementById("nameForTable").innerText
            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "db",
                "method": "POST",
                "headers": {
                    "value": bla,
                    "name":name,
                }
            }

            $.ajax(settings).done(function (response) {

               parseJSON(response);
               $('#result').text(response.message);
               $('#exampleModal').modal('hide');
                var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "db",
                    "method": "GET",
                    "headers": {
                    }
                }
                $.ajax(settings).done(function (data) {

                    var table = $('#table');
                    $.each(data, function (name, score) {console.log('name '+data[name].name+' score '+data[name].score);
                        $(table).append($('<tr>').append($('<td>').text(data[name].name)).append($('<td>').text(data[name].score)));

                    });

                });


            });
        });


    });