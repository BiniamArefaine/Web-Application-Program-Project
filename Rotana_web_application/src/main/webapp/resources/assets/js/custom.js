$(document).ready(function () {

    $('#show_form').click(function () {
        show_form();
    });

    $('#hide_form').click(function () {
       hide_form();
    });

    $('#save_user').submit(function (event) {
        event.preventDefault();
        const password = $('#password').val();
        const confirmPassword = $('#confirmPassword').val();
        if (password === confirmPassword) {
            let form_data = $('#save_user').serialize();
            $.ajax({
                url: '/users',
                method: 'POST',
                data: form_data,
                success: function (response) {
                    $('#save_user')[0].reset();
                    $('#records_table tbody').append(
                        '<tr>' +
                        '<td>' + response.id + '</td>' +
                        '<td>' + response.firstName + '</td>' +
                        '<td>' + response.lastName + '</td>' +
                        '<td>' + response.gender + '</td>' +
                        '<td>' + response.email + '</td>' +
                        '<td id="user_data_'+response.id+'">' + '<a class="btn btn-success btn-sm" href="javascript:void(0)" title="Active" onclick="changeStatus('+response.id+')">' +
                        '<i class="fa fa-check"></i>' +
                        '</a>'+ '</td>' +
                        '</tr>'

                    );
                   // hide_form();
                }
            });
        } else {

        }
    });

});

function changeStatus(param) {
    $.ajax({
        url : '/change-status',
        method : 'GET',
        data : {
            'user_id' : param
        },
        success : function (response) {
            if(!response.active){
                $('#user_data_'+param).html('<a href="javascript:void(0)" class="btn btn-danger btn-sm"\n' +
                    ' title="Inactive" onclick="changeStatus('+response.id+')">\n' +
                    ' <i class="fa fa-times"></i>\n' +
                    ' </a>')
            }else{
                $('#user_data_'+param).html('<a href="javascript:void(0)" class="btn btn-success btn-sm"\n' +
                    ' title="Active" onclick="changeStatus('+response.id+')">\n' +
                    ' <i class="fa fa-check"></i>\n' +
                    ' </a>')
            }
        }
    });
}

function blockAdvert(param) {
    $.ajax({
        url : '/block-advert',
        method : 'GET',
        data : {
            'advert_id' : param
        },
        success : function (data) {
            if(data.blocked){
                $('#advert_data_'+param).html('<a href="javascript:void(0)" class="btn btn-danger btn-sm"\n' +
                    ' title="Blocked" onclick="blockAdvert('+data.id+')">\n' +
                    ' <i class="fa fa-times"></i>\n' +
                    ' </a>')
            }else{
                $('#advert_data_'+param).html('<a href="javascript:void(0)" class="btn btn-success btn-sm"\n' +
                    ' title="Not Blocked" onclick="blockAdvert('+data.id+')">\n' +
                    ' <i class="fa fa-check"></i>\n' +
                    ' </a>')
            }
        }
    });
}

function show_form() {
    $('#view_container').addClass('hidden');
    $('#form_container').removeClass('hidden');
}

function hide_form() {
    $('#view_container').removeClass('hidden');
    $('#form_container').addClass('hidden');
}