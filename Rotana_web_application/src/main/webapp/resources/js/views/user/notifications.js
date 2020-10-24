$(function () {

    window.setInterval(function () {
        $.ajax({
            url:'notifications',
            type: 'post',
            data:{
                not:""
            },
            success:notificationSuccessFunction,
            error:notificationErrorFunction
        })

    },2000);

    function notificationSuccessFunction(data) {
        console.log(data)
        $('#noOfNotifications').text(data.length);
    }
    function notificationErrorFunction(err) {
        console.log(err);
    }

})