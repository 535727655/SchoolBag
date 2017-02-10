<%@ page language="java" import="java.util.*,H_entity.Infomation"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/void.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="js/magiczoomplus.js" type="text/javascript"></script>
<script src="js/jquery-ui/jquery-ui.min.js"></script>
<link rel="stylesheet" href="js/jquery-ui/jquery-ui.min.css" />
<link rel="stylesheet" href="js/jquery-ui/jquery-ui.theme.min.css" />

<link rel="stylesheet" href="css/aa.css" />
<link rel="stylesheet" href="css/ni.css" />


</head>
<body>
	<div id="first">
		<div id="first-one">
			<img src="img/1.png" />
		</div>
		<div id="first-two">
			<div style="color: red; font-size: 20px; float: left;">校帮</div>
			<span id="first-three">-更专业的二手交易平台</span> <b
				style="font-size: 15px; color: #DBDBDB;">二手全新升级，新品牌，新服务 
		</div>
		<div id="first-forth" />
		<img src="img/2.png" />
	</div>
	<div id="first-fifth">
		<input type="text" placeholder="请输入类别名称或关键字" />
	</div>
	<div id="first-sixth">
		<input type="button" name="name" id="name" value="搜索" /></span>
	</div>
	<div id="first-seventh">
		<a href="first.html"
			style="color: #FFFAE8; padding-left: 10px; padding-top: 10px; padding-buttom: 10px; float: left; text-decoration: none;">免费发布信息</a>
	</div>
	</div>
	<div id="second-first">
		<ol id="tttt">
			<li id="test1"><a href="index.html"></a>首页</li>
			<li><a href="new_file.html">淘九块</a></li>
			<li>跳蚤市场</li>
			<li>兼职招聘</li>
		</ol>
	</div>

	<div id="abc">
		<div>
			<c:forEach var="b" items="${requestScope.li}">
				<div id="nm">${b.biaoti }<a href="image/first.png" title=""
						class="MagicZoomPlus"><img
						src='/xiaobang/image/${b.pricture }' width="455" height="420" /></a>
				</div>
				<div id="qndyd">
					<div class="smar">联系人:${b.lxr }</div>
					<div class="smar">联系电话:${b.phone }</div>
					<div class="smar">商品价格:${b.price }元</div>
					<div class="smar">商品新旧程度:${b.cd }</div>
					<div class="smar">发布时间:${b.time }</div>
					<div id="tom">
						<input class="hwq2button " type="button" value="立即购买" />
					</div>
					<div id="insert">抢购倒计时:</div>
					<div id="a"></div>
					<div style="width:100xp;height:100px;"></div>
				</div>
			</c:forEach>
		</div>	
	<div id="tabs">
					<ul>
						<li><a href="#tabs-1">商品详情</a></li>
						<li><a href="#tabs-2">留言板</a></li>
						
					</ul>
					<div id="tabs-1">
					<c:forEach var="v" items="${requestScope.li}">
						<p>${v.content }</p>
					</c:forEach>
					</div>
					<div id="tabs-2">
						<p>为了提供给大家更好的体验和服务，您可以给卖家提建议哦！请点击<a href="lyb.jsp"><input type="button " value="留言板" /></a>给卖家留言， 您提出的宝贵建议卖家将会收到哦！</p>
					</div>
					
				</div>	

					<script type="text/javascript">
						$(function() {
							$("#tabs").tabs();
						});
					</script>




			
	
</div>	
</body>
</html>