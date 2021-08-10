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
});