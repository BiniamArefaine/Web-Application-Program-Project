$(function () {
    $(document).on('change','#displayPhoto',function () {
        $('#displayPhotoForm').submit();
    });

    $(document).on('submit','#displayPhotoForm',function(e){
        e.preventDefault();
        $('#editDisplayPhotoLabelSpan').text('Uploading.....');
        var formData = new FormData(this);
        $.ajax({
            url: $(this).attr("action"),
            type: 'POST',
            data: formData,
            success: editDisplayPhotoSuccessFunction,
            error: editDisplayPhotoErrorFunction,
            cache: false,
            contentType: false,
            processData: false
        });
    });

    function editDisplayPhotoSuccessFunction(data){
        console.log(data);
        $('#fileContainer').mousemove();
        $('#editDisplayPhotoLabelSpan').text('Upload Successful');
        location.reload();
    }

    function editDisplayPhotoErrorFunction(err,status,exception) {
        $('#editDisplayPhotoLabelSpan').text('Error Uploading image!!');
        console.log(err + status + exception );
    }

    weatherBallon(4511283);

});

const key = '1d4cc68813415bb7fb25ea28e63b1c5e';
if (key === '') document.getElementById('temp').innerHTML = ('Remember to add your api key!');

function weatherBallon(cityID) {
    fetch('https://api.openweathermap.org/data/2.5/weather?id=' + cityID + '&appid=' + key)
        .then(function (resp) {
            return resp.json()
        }) // Convert data to json
        .then(function (data) {
            drawWeather(data);
        })
        .catch(function () {
            // catch any errors
        });
}

function drawWeather(d) {
    var celcius = Math.round(parseFloat(d.main.temp) - 273.15);
    var fahrenheit = Math.round(((parseFloat(d.main.temp) - 273.15) * 1.8) + 32);
    var description = d.weather[0].description;

    document.getElementById('description').innerHTML = description;
    document.getElementById('temp').innerHTML = celcius + '&deg;';
    document.getElementById('location').innerHTML = d.name;

    if (description.indexOf('rain') > 0) {
        document.body.className = 'rainy';
    } else if (description.indexOf('cloud') > 0) {
        document.body.className = 'cloudy';
    } else if (description.indexOf('sunny') > 0) {
        document.body.className = 'sunny';
    } else {
        document.body.className = 'clear';
    }
}