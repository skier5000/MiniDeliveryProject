/************************************************************
 =====================================================
 날짜				|	작성자	|	내용
 =====================================================
 2021. 07. 22	|	이영우	|	js 작성

 ************************************************************/

/* nav - 관리자메뉴 탭 메뉴 토글  */
$(function(){
    $(".list-group-item").click(function(){
        $(this).toggleClass('far fa-folder far fa-folder-open list-group-item-primary');
        $(this).siblings().slideToggle();
        $(this).css("background", "white");
        $(this).css("color", "black");
    });

    $("#toggle-nav").click(function(){
        // $(this).removeClass("fas fa-angle-right fa-lg");
        // $(this).addClass("fas fa-angle-left fa-lg");

        if($("nav").hasClass("nav-slide")){
            $("nav").css("left", "-250px");
            $("nav").removeClass("nav-slide");

            $("section").css("margin-left", "0px");
            $("#list").css("width", "100%");

            $(".header-menu").css("padding-left", "10px");

            // $(this).removeClass("fas fa-angle-left fa-lg");
            // $(this).addClass("fas fa-angle-right fa-lg");
        }else{
            $("nav").css("left", "250px");
            $("nav").addClass("nav-slide");

            $("section").css("margin-left", "250px");

            $(".header-menu").css("padding-left", "260px");

            // $(this).removeClass("fas fa-angle-right fa-lg");
            // $(this).addClass("fas fa-angle-left fa-lg");
        }





    });

});