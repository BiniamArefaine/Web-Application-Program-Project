$(function () {
    $(document).on('change','#coverPhoto',function () {
        $('#editCoverPhotoForm').submit();
    })

    $(document).on('submit','#editCoverPhotoForm',function(e){
        e.preventDefault();
            $('#editCoverPhotoLabelSpan').text('Uploading.....');
            var formData = new FormData(this);
            $.ajax({
                url: $(this).attr("action"),
                type: 'POST',
                data: formData,
                success: editCoverPhotoSuccessFunction,
                error: editCoverPhotoErrorFunction,
                cache: false,
                contentType: false,
                processData: false
        });
    })

    function editCoverPhotoSuccessFunction(data){
        console.log(data);
        $('#editCoverPhotoLabelSpan').text('Upload Successful');
        window.setTimeout(function () {
            location.reload();
        },1000);

    }

    function editCoverPhotoErrorFunction(err,status,exception) {
        $('#editCoverPhotoLabelSpan').text('Error Uploading image!!');
        console.log(err + status + exception );
    }

})