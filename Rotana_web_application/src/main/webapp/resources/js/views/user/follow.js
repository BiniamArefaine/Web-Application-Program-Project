$(function () {

    $(document).on('click','a.followUser',function (e) {
        e.preventDefault();
        aId = $(this).attr('id');
        alink = $(this);
        alert(parseInt($(this).attr('id')));
        $.ajax({
            url: "follow",
            type:'POST',
            data:{
                user:parseInt($(this).attr('id'))},
            success : successFunctionFollow,
            error : errorFuctionFollow

        });




    })

    function successFunctionFollow(data){
        console.log(data);
        alink.text("Followed!");
        window.setTimeout(function () {
            location.reload();
        },1000)
    }
    function errorFuctionFollow(en,status,exceptions) {
        console.log(en+status+exceptions);
    }
    
})