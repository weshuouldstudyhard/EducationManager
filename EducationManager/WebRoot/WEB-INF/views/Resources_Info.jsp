<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>资源区</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" href="css/navigation.css" rel="stylesheet" /><!--导航-->

<link rel="stylesheet" type="text/css" href="css/bookshelf_slider.css" />
<link rel="stylesheet" type="text/css" href="css/skin01.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />

<style type="text/css">
body {margin:0;padding:0; background:#cccccc url(assets/bg_texture_11.png) repeat; margin-top:87px; } /* #54493e */
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>

<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.bookshelfslider.min.js"></script>

<script type="text/javascript" src="js/navigationuse.js"></script> <!-- 导航引用的script -->
</head>

<body>
<!--引入导航栏 -->
<%@include file="/WEB-INF/views/head.jsp" %>
	
<script type="text/javascript">

jQuery(document).ready(function() {

	// default parameters
	//$.bookshelfSlider('#bookshelf_slider');
	
	//$.bookshelfSlider.config.item_width = 200;
	//$.bookshelfSlider('#bookshelf_slider');
	
	//define custom parameters
	
	$.bookshelfSlider('#bookshelf_slider', {
		'item_width': 845, //385
		'item_height': 320, //320
		'products_box_margin_left': 30,
		'product_title_textcolor': '#ffffff',
		'product_title_bgcolor': '#c33b4e',
		'product_margin': 30,
		'product_show_title': true,
		'show_title_in_popup': true,
		'show_selected_title': true,
		'show_icons': true,
		'buttons_margin': 15,
		'slide_duration': 1000,
		'slide_easing': 'easeOutQuart',
		'arrow_duration': 800,
		'arrow_easing': 'easeOutQuart',
		'video_width_height': [500,290],
		'iframe_width_height': [500,330]
		}
	);
	
	
});//ready

</script>

<div id="bookshelf_slider">

    <div class="panel_title">
        <div id="selected_title_box"><div id="selected_title">Selected Title</div></div>
        
        <div id="menu_top">
            <ul>
                <li id="show_hide_titles" class="menutop_btn"><a href="#">Titles</a></li>
                <li id="show_hide_icons" class="menutop_btn"><a href="#">Icons</a></li>
            </ul>
        </div>

    </div><!-- .panel_title -->
    
    <div class="panel_slider">
    	<div id="panel_items" class="panel_items">

            <div class="slide_animate">
            	<div class="products_box" id="products_box_1">
                     <a href="#" class="product" data-type="book" data-popup="true" data-url=".NET_Resources_Info__download1.html" title="ASP.NET本质论"><img src="images/Res-rar1.png" alt="" width="80" height="80" /></a><!--data-url中显示的就是最终的结果，网页啊什么的。-->
                    <a href="#" class="product" data-type="book" data-popup="true" data-url=".NET_Resources_Info__download2.html" title="ssh搭建说明文档"><img src="images/Res_txt.png" alt="" width="80" height="80" /></a>
                    <a href="#" class="product" data-type="book" data-popup="true" data-url="" title="C++ primer中文版"><img src="images/Res_C++ primer-chinese.jpg" alt="images/Res_magazine_03.png" width="95" height="107" /></a>
                   </div>
            </div>
            
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_2">
                    <a href="#" class="product" data-type="magazine" data-popup="true" data-url="images/Res-book-01.png" title="info"><img src="images/Res-book-01.png" alt="" width="71" height="93" /></a>            	</div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_3">
                    <a href=".NET_Resources_Info__download1.html" class="product" data-type="book" data-popup="true" data-url=".NET_Resources_Info__download1.html" title="ASP.NET本质论"><img src="images/Res-rar1.png" alt="" width="80" height="80" /></a>
                    <a href=".NET_Resources_Info__download2.html" class="product" data-type="book" data-popup="true" data-url=".NET_Resources_Info__download2.html" title="ssh搭建说明文档"><img src="images//Res_txt.png" alt="" width="80" height="80" /></a>
                    </div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_4">
                    <a href="#" class="product" data-type="magazine" data-popup="true" data-url="images/Res_magazine_01.png" title="Info"><img src="images/Res_magazine_01.png" alt="" width="77" height="107" /></a>
                    </div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_5">
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="47" height="89" /></a>
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="45" height="88" /></a>            	</div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_6">
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="88" height="115" /></a>
                   <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="88" height="115" /></a>            	</div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_7">
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="81" height="107" /></a>
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="100" height="107" /></a> 
			
				</div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_8">
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="80" height="80" /></a>
 					<a href="#" class="product" data-type="" data-popup="false" data-url="" title=""><img src="" alt="" width="80" height="80" /></a>            	</div>
            </div>
            
            <div class="slide_animate">
            	<div class="products_box" id="products_box_9">
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="" alt="" width="174" height="95" /></a>
					<a href="#" class="product" data-type="" data-popup="false" data-url="" title=""><img src="" alt="" width="71" height="107" /></a>
                    
			  </div>
            </div>
			
			<div class="slide_animate">
            	<div class="products_box" id="products_box_10">
                    <a href="#" class="product" data-type="" data-popup="true" data-url="" title=""><img src="images/105-photo-effects-bundle-thumb.jpg" alt="" width="80" height="80" /></a>
 					<a href="#" class="product" data-type="" data-popup="false" data-url="" title=""><img src="images/3d-book-006.jpg" alt="" width="80" height="80" /></a>            	</div>
            </div>
        </div><!-- panel_items -->
    </div>
    <!-- panel_slider -->
    
    <div class="panel_bar">
    	<div id="arrow_box"><div id="arrow_menu"></div>
    	</div>
        <div class="button_items">
            <div id="btn1" class="button_bar"><a href="#">C++</a></div>
            <div id="btn2" class="button_bar"><a href="#">数据结构</a></div>
            <div id="btn3" class="button_bar"><a href="#">Java</a></div>
            <div id="btn4" class="button_bar"><a href="#">Web开发</a></div>
            <div id="btn5" class="button_bar"><a href="#">移动开发</a></div>
            <div id="btn6" class="button_bar"><a href="#">.NET</a></div>
            <div id="btn7" class="button_bar"><a href="#">嵌入式</a></div>
            <div id="btn8" class="button_bar"><a href="#">云计算</a></div>
            <div id="btn9" class="button_bar"><a href="#">Linux</a></div>
			<div id="btn10" class="button_bar"><a href="#"> 数据库</a></div>
			
        </div>
    </div>
    
    <!-- <div id="debug"></div> -->
    
</div><!-- bookshelf_slider -->


<!-- DEMO PANEL -->

<div id="bookshelf_options">
        <div id="menu_btm">
            <ul>
              <!--<li id="dowmload_file" class="menutop_btn" ><a href="#">Download</a></li>-->
              <li >fl    </li>
            </ul>
        </div>
<!--添加一个 输出文件信息的框，和下载按钮。？？-->
	 <p align="left">本站资源提供学习使用，如有疑问，请<a href="" >联系我们</a></p>
	
</div>

<br><br><br><br>


</body>
</html>





