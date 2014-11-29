		$(".overturn").hover(function() {
    $(this).children("a").children("img").stop().animate({
        width: 0,
        height: 171
    }, 100, function() {
        var im_id = $(this)[0].id;
        id_arr = im_id.split("im");
        key = id_arr[1].toString();
        var fpic = $("#brand_double_fpic" + key).val();
        $(this)[0].src = fpic;
        $(this).animate({
            width: 218,
            height: 171
        }, 100)
    });
}, function() {
    $(this).children("a").children("img").stop().animate({
        width: 0,
        height: 171
    }, 100, function() {
        var im_id = $(this)[0].id;
        id_arr = im_id.split("im");
        key = id_arr[1].toString();
        var pic = $("#brand_double_pic" + key).val();

        $(this)[0].src = pic;
        $(this).animate({
            width: 218,
            height: 171
        }, 100)
    });
});

