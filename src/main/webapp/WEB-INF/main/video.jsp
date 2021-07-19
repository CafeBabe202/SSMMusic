<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <base href="<%=basePath %>">
    <meta charset="utf-8"/>
    <title>Musik | Web Application</title>
    <meta name="description"
          content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="js/jPlayer/jplayer.flat.css" type="text/css"/>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="css/font.css" type="text/css"/>
    <link rel="stylesheet" href="css/app.css" type="text/css"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
    <![endif]-->
</head>
<body class="">
<section class="vbox">
    <header class="bg-white-only header header-md navbar navbar-fixed-top-xs">
        <div class="navbar-header aside bg-info dk">
            <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
                <i class="icon-list"></i>
            </a>
            <a href="<%= basePath%>user/toIndex" class="navbar-brand text-lt">
                <i class="icon-earphones"></i>
                <img src="images/logo.png" alt="." class="hide">
                <span class="hidden-nav-xs m-l-sm">Musik</span>
            </a>
            <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
                <i class="icon-settings"></i>
            </a>
        </div>
        <ul class="nav navbar-nav hidden-xs">
            <li>
                <a href="#nav,.navbar-header" data-toggle="class:nav-xs,nav-xs" class="text-muted">
                    <i class="fa fa-indent text"></i>
                    <i class="fa fa-dedent text-active"></i>
                </a>
            </li>
        </ul>
        <form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs" role="search">
            <div class="form-group">
                <div class="input-group">
            <span class="input-group-btn">
              <button type="submit" class="btn btn-sm bg-white btn-icon rounded"><i class="fa fa-search"></i></button>
            </span>
                    <input type="text" class="form-control input-sm no-border rounded"
                           placeholder="Search songs, albums...">
                </div>
            </div>
        </form>
        <div class="navbar-right ">
            <c:if test="${not empty user}">
                <ul class="nav navbar-nav m-n hidden-xs nav-user user">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle bg clear" data-toggle="dropdown">
                            <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm"></span>
                            <span class="glyphicon glyphicon-user"></span>&emsp;${user.userName} <b class="caret"></b>
                        </a>

                        <ul class="dropdown-menu animated fadeInRight">
                            <li><a href="<%=basePath%>user/logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;退出登录</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </c:if>
            <c:if test="${empty user}">
                <p></p>
                <a href="<%=basePath%>user/userLogin"><span class="glyphicon glyphicon-log-in"></span>&nbsp;登录</a>
                <span>&emsp;</span>
                <a href="<%=basePath%>signup.jsp"><span class="glyphicon glyphicon-new-window"></span>&nbsp;免费注册</a>
            </c:if>
            <span>&emsp;</span>
            <a target="_blank" href="<%=basePath%>user/toAdminLogin"><span
                    class="glyphicon glyphicon-new-window"></span>&nbsp;管理员登录</a>
        </div>
    </header>
    <section>
        <section class="hbox stretch">
            <!-- .aside -->
            <aside class="bg-black dk aside hidden-print" id="nav">
                <section class="vbox">
                    <section class="w-f-md scrollable">
                        <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0"
                             data-size="10px" data-railOpacity="0.2">
                            <nav class="nav-primary hidden-xs">
                                <ul class="nav bg clearfix">
                                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                                        发现
                                    </li>
                                    <li><a href="<%=basePath%>/music/genres"> <i
                                            class="icon-music-tone-alt icon text-info"></i> <span
                                            class="font-bold">流派</span>
                                    </a></li>
                                    <li><a href="<%=basePath%>/video" data-target="#content"
                                           data-el="#bjax-el" data-replace="true"> <i
                                            class="icon-social-youtube icon  text-primary"></i> <span
                                            class="font-bold">视频</span>
                                    </a></li>
                                    <li class="m-b hidden-nav-xs"></li>
                                </ul>
                        </div>
                    </section>

                    <footer class="footer hidden-xs no-padder text-center-nav-xs">
                        <div class="bg hidden-xs ">
                            <div class="dropdown dropup wrapper-sm clearfix">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <span class="thumb-sm avatar pull-left m-l-xs">                        
                        <img src="images/a3.png" class="dker" alt="...">
                        <i class="on b-black"></i>
                      </span>
                                    <span class="hidden-nav-xs clear">
                        <span class="block m-l">
                          <strong class="font-bold text-lt">John.Smith</strong> 
                          <b class="caret"></b>
                        </span>
                        <span class="text-muted text-xs block m-l">Art Director</span>
                      </span>
                                </a>
                                <ul class="dropdown-menu animated fadeInRight aside text-left">

                                </ul>
                            </div>
                        </div>
                    </footer>
                </section>
            </aside>
            <!-- /.aside -->
            <section id="content">
                <section class="vbox" id="bjax-el">
                    <section class="scrollable padder-lg">
                        <h2 class="font-thin m-b">推荐</h2>
                        <div class="row row-sm">

                            <!-- 获取随机3个视屏 -->
                            <c:if test="${not empty randVideoList }">
                                <c:forEach var="list" items="${randVideoList}">
                                    <div class="col-xs-12 col-sm-4">
                                        <div class="item">
                                            <div class="pos-rlt">
                                                <div class="item-overlay opacity r r-2x bg-black">
                                                    <div class="center text-center m-t-n">

                                                        <a href="<%=basePath%>/video/play?videoid=${list.videoid }"><i
                                                                class="fa fa-play-circle i-2x"></i></a>

                                                    </div>
                                                </div>
                                                <div class="top">
                                                        <%-- <span class="badge bg-dark m-l-sm m-t-sm" pattern="yyyy-MM-dd" >${list.videotime }</span> --%>
                                                </div>
                                                <a href="<%=basePath%>/video/play?videoid=${list.videoid }"><img
                                                        src="/musicfile/${list.videophoto }"
                                                        style="width: 400ox;height: 300px" alt=""
                                                        class="r r-2x img-full"></a>
                                            </div>
                                            <div class="padder-v">
                                                <a href="<%=basePath%>/video/play?videoid=${list.videoid }"
                                                   class="text-ellipsis">${list.videoname }</a>
                                                <a href="<%=basePath%>/video/play?videoid=${list.videoid }"
                                                   class="text-ellipsis text-xs text-muted">${list.videoauthor }</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>


                        <!--  获取视屏列表 -->
                        <h3 class="font-thin m-b">视频列表</h3>
                        <div class="row row-sm">
                            <c:if test="${not empty videoInfo.list }">
                                <c:forEach var="pm" items="${videoInfo.list}" varStatus="st">
                                    <div class="col-xs-6 col-sm-4 col-md-3">
                                        <div class="item">
                                            <div class="pos-rlt">
                                                <div class="item-overlay opacity r r-2x bg-black">
                                                    <div class="center text-center m-t-n">
                                                        <a href="<%=basePath%>video/play?videoid=${pm.videoid }"><i
                                                                class="fa fa-play-circle i-2x"></i></a>
                                                    </div>
                                                </div>
                                                <img src="/musicfile/${pm.videophoto }"
                                                     style="width: 400ox;height: 200px" alt=""
                                                     class="r r-2x img-full"></a>
                                            </div>
                                            <div class="padder-v">
                                                <a href="<%=basePath%>video/play?videoid=${pm.videoid }"
                                                   class="text-ellipsis">${pm.videoname }</a>
                                                <a href="video/play?videoid=${pm.videoid }"
                                                   class="text-ellipsis text-xs text-muted">${pm.videoauthor }</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>


                        <!--   底部页数列表 -->
                        <ul class="pagination pagination">
                            <c:if test="${videoInfo.pageNum-1<1 }">
                                <li><a><i class="fa fa-chevron-left"></i></a></li>
                            </c:if>

                            <c:if test="${videoInfo.pageNum-1>=1 }">
                                <li><a
                                        href="<%=basePath%>/video?typeid=${nowtype}&pageNO=${videoInfo.pageNum-1 }"><i
                                        class="fa fa-chevron-left"></i></a></li>
                            </c:if>

                            <c:if test="${not empty videoInfo.list }">
                                <c:forEach begin="1" end="${videoInfo.pages }" step="1"
                                           var="i">
                                    <c:if test="${i==videoInfo.pageNum}">
                                        <li class="active"><a>${i }</a></li>
                                    </c:if>
                                    <c:if test="${i!=videoInfo.pageNum}">
                                        <li><a
                                                href="<%=basePath%>/video?typeid=${nowtype}&pageNO=${i }">${i }</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </c:if>

                            <c:if test="${videoInfo.pageNum+1<=videoInfo.pages }">
                                <li><a
                                        href="<%=basePath%>/video?typeid=${nowtype}&pageNO=${videoInfo.pageNum+1 }"><i
                                        class="fa fa-chevron-right"></i></a></li>
                            </c:if>
                            <c:if test="${videoInfo.pageNum+1>videoInfo.pages }">
                                <li><a><i class="fa fa-chevron-right"></i></a></li>
                            </c:if>
                        </ul>

                    </section>
                </section>
                <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open"
                   data-target="#nav,html"></a>
            </section>
        </section>
    </section>
</section>
<script src="js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.js"></script>
<!-- App -->
<script src="js/app.js"></script>
<script src="js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/app.plugin.js"></script>
<script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
<script type="text/javascript" src="js/jPlayer/demo.js"></script>

</body>
</html>