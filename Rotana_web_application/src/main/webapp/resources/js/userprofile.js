$(function () {

    // $(document).ajaxStart(function() {
    //     $("#loader").show();
    // }).ajaxStop(function() {
    //     $("#loader").hide();
    // });

    $("#loader").hide();
    $("#submit").click(function (e) {
        $("#loader").show();
        $.ajax({
            url : 'users',
            type : 'GET',
            data : {
                fname : $('#fname').val(),
                lname : $('#laname').val(),
                email : $('#Email').val(),
                pass : $('#pass').val(),
                repass : $('#repass').val()
            },
            success : function (data) {

                //  let bookTittle = $("<td>").text(data.bookTittle);
                //  let isbn = $("<td>").text(data.isbn);
                // let row =  $("<tr>").append(bookTittle, isbn);
                // $("#bookTable").append(row);

                // for(Book of data){
                //      let bookTittle = $("<td>").text(bo.bookTittle);
                //      let isbn = $("<td>").text(data.isbn);
                //     let row =  $("<tr>").append(bookTittle, isbn);
                //     $("#bookTable").append(row);
                // }
                if(pass==repass&&fname!=null&&lname!=null&&email!=null){

                    $(document).ajaxSuccess(function(){
                        alert("AJAX request successfully saved new user");
                    });
                }


            },
            error : function (xhr ,status ,exception ) {
                console.log('Error happened');
                alert('can not enter the new user');
            },
            complete : function () {
                $("#loader").hide();
            }
        });
    });
});
