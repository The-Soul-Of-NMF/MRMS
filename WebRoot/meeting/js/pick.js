/**
 * Created by Hugh on 2015/6/26 0026.
 */

$(function () {
    $("#meeting_room_choose_btn").click(function () {
        $("#meeting_list").hide();
        $("#meeting_time_choose").show();
    });

    $("#time_choose_ok_btn").click(function () {
        $("#meeting_room_choose_one").show();
    });

    $(".back_to_list_btn").click(function () {
        $("#meeting_list").show();
        $("#meeting_room_choose_one").hide();
        $("#meeting_time_choose").hide();
        $("#meeting_time_success").hide();
    });
    $("#meeting_room_sure_btn").click(function () {
        bootbox.confirm("您确定要在  2015-06-27 09:30   召开  人事部例会？",
            function (choice) {
                if (choice) {
                    $("#meeting_list").hide();
                    $("#meeting_room_choose_one").hide();
                    $("#meeting_time_choose").hide();
                    $("#meeting_one").hide();
                    $("#meeting_time_success").show();
                } else {
                }
            });
    })


});
