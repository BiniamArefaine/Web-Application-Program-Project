$(function () {

    (function () {
        $(document).on('submit','#ads',function(e) {
            e.preventDefault();
            var formData = new FormData(this);
            $.ajax({
                url: $(this).attr("action"),
                type: 'POST',
                data: formData,
                success: addAds,
                error: addAdsFail,
                cache: false,
                contentType: false,
                processData: false
            });
        });

        function addAds(data) {
            alert(data);
        }
        function addAdsFail(err,status,exception){
            console.log(err + status + exception);
        }


    })();

});