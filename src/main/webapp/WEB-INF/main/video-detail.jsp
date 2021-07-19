<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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
</head>
<body class="">
<section class="vbox">
    <header
            class="bg-white-only header header-md navbar navbar-fixed-top-xs">
        <div class="navbar-header aside bg-info nav-xs">
            <a class="btn btn-link visible-xs"
               data-toggle="class:nav-off-screen,open" data-target="#nav,html">
                <i class="icon-list"></i>
            </a> <a href="<%=basePath%>" class="navbar-brand text-lt"> <i
                class="icon-earphones"></i> <img src="<%=basePath%>images/logo.png" alt="."
                                                 class="hide"> <span class="hidden-nav-xs m-l-sm">Music</span>
        </a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
                data-target=".user"> <i class="icon-settings"></i>
        </a>
        </div>
        <ul class="nav navbar-nav hidden-xs">
            <li><a href="#nav,.navbar-header"
                   data-toggle="class:nav-xs,nav-xs" class="text-muted"> <i
                    class="fa fa-indent text"></i> <i class="fa fa-dedent text-active"></i>
            </a></li>
        </ul>
        <form
                class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs"
                role="search">
            <div class="form-group">
                <div class="input-group">
						<span class="input-group-btn">
							<button type="submit"
                                    class="btn btn-sm bg-white btn-icon rounded">
								<i class="fa fa-search"></i>
							</button>
						</span> <input type="text"
                                       class="form-control input-sm no-border rounded"
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
                            <li><a href="<%=basePath%>/user/logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;退出登录</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </c:if>
            <c:if test="${empty user}">
                <p></p>
                <a href="<%=basePath%>/login.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp;登录</a>
                <span>&emsp;</span>
                <a href="<%=basePath%>/signup.jsp"><span class="glyphicon glyphicon-new-window"></span>&nbsp;免费注册</a>
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
                        <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="10px" data-railOpacity="0.2">
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
                <section class="vbox">
                    <section class="scrollable wrapper-lg">
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="panel">
                                    <!-- video player -->
                                    <div id="jp_container_1">
                                        <div class="jp-type-single pos-rlt">
                                            <div id="jplayer_1" class="jp-jplayer jp-video"></div>
                                            <div class="jp-gui">
                                                <div class="jp-video-play">
                                                    <a class="fa fa-5x text-white fa-play-circle"></a>
                                                </div>
                                                <div class="jp-interface bg-info padder">
                                                    <div class="jp-controls">
                                                        <div>
                                                            <a class="jp-play"><i
                                                                    class="icon-control-play i-2x"></i></a>
                                                            <a class="jp-pause hid"><i
                                                                    class="icon-control-pause i-2x"></i></a>
                                                        </div>
                                                        <div class="jp-progress">
                                                            <div class="jp-seek-bar dker">
                                                                <div class="jp-play-bar dk">
                                                                </div>
                                                                <div class="jp-title text-lt">
                                                                    <ul>
                                                                        <li></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="hidden-xs hidden-sm jp-current-time text-xs text-muted"></div>
                                                        <div class="hidden-xs hidden-sm jp-duration text-xs text-muted"></div>
                                                        <div class="hidden-xs hidden-sm">
                                                            <a class="jp-mute" title="mute"><i
                                                                    class="icon-volume-2"></i></a>
                                                            <a class="jp-unmute hid" title="unmute"><i
                                                                    class="icon-volume-off"></i></a>
                                                        </div>
                                                        <div class="hidden-xs hidden-sm jp-volume">
                                                            <div class="jp-volume-bar dk">
                                                                <div class="jp-volume-bar-value lter"></div>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <a class="jp-full-screen" title="full screen"><i
                                                                    class="fa fa-expand"></i></a>
                                                            <a class="jp-restore-screen" title="restore screen"><i
                                                                    class="fa fa-compress text-lt"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="jp-no-solution hide">
                                                <span>Update Required</span>
                                                To play the media you will need to either update your browser to a
                                                recent version or update your <a
                                                    href="http://get.adobe.com/flashplayer/" target="_blank">Flash
                                                plugin</a>.
                                            </div>
                                        </div>
                                    </div>
                                    <!-- / video player -->
                                    <div class="wrapper-lg">
                                        <h2 class="m-t-none text-black">${video.videoname} </br><i
                                                class="fa fa-user icon-muted"></i><!--  作者: --> <a href="#"
                                                                                                   class="m-r-sm">${video.videoauthor }</a>
                                        </h2>
                                        <div class="line b-b"></div>
                                    </div>
                                </div>


                                <h4 class="m-t-lg m-b">最新6条评论</h4>
                                <!--  评论 -->
                                <section class="comment-list block" id="changemes">
                                    <article id="comment-id-1" class="comment-item">
                                        <c:if test="${not empty message}">
                                            <c:forEach items="${message }" var="msg">
                                                <section class="comment-body m-b">
                                                    <header>
                                                        <a href="#"><strong>${msg.user.userName} </strong></a>
                                                        <span class="text-muted text-xs block m-t-xs">
                  		<fmt:formatDate value='${msg.messagetime }' type="date"/>
                          </span>
                                                    </header>
                                                    <div class="m-t-sm">${msg.messagecomment}</div>
                                                </section>
                                            </c:forEach>
                                        </c:if>
                                    </article>
                                </section>


                                <h4 class="m-t-lg m-b">评论</h4>
                                <div class="form-group pull-in clearfix">
                                    <c:if test="${empty user}">
                                        <h2 class="m-t-lg m-b">请登录后发表评论</h2>
                                        <a class="btn btn-success " onclick="toLogin()">登录</a>
                                    </c:if>

                                    <c:if test="${not empty user}">
                                        <form action="<%=basePath%>video/fbMsg" id="fmt" method="post">
                                            <input type="hidden" name="videoid" id="vid" value="${video.videoid}">
                                            <div class="form-group">
                                                <label>评论</label>
                                                <div><font style="red" id="font"></font></div>
                                                <textarea class="form-control" name="messagecomment" rows="5"
                                                          placeholder="请畅所欲言" id="comment"></textarea>
                                            </div>
                                            <div class="form-group">
                                                <!-- <button type="button" class="btn btn-success" onclick="sub()">发布评论</button>  -->
                                                <button type="button" class="btn btn-success" onclick="sub()"> 发布评论
                                                </button>
                                                <!--  <button type="submit" class="btn btn-success ">Submit comment</button>   -->
                                            </div>
                                        </form>
                                    </c:if>
                                </div>
                            </div>


                            <!-- 推荐视屏 -->
                            <div class="col-sm-4">
                                <div class="panel panel-default">
                                    <div class="panel-heading">推荐</div>
                                    <div class="panel-body">
                                        <c:forEach var="lit" items="${randomVideoList}">
                                            <article class="media">
                                                <a href="<%=basePath%>/video/play?videoid=${lit.videoid }"
                                                   class="pull-left thumb-lg m-t-xs">
                                                    <img src="/musicfile/${lit.videophoto }">
                                                </a>
                                                <div class="media-body">
                                                    <a href="<%=basePath%>/video/play?videoid=${lit.videoid }"
                                                       class="font-semibold">${lit.videoname }</a>
                                                    <div class="text-xs block m-t-xs"><a
                                                            href="<%=basePath%>/video/play?videoid=${lit.videoid }">作者：</a>${lit.videoauthor}
                                                    </div>
                                                </div>
                                            </article>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
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
<script type="text/javascript">
    $(document).ready(function () {

        $("#jplayer_1").jPlayer({
            ready: function () {
                $(this).jPlayer("setMedia", {

                    title: "${video.videoname}",
                    m4v: "/musicfile/${video.videourl}",
                    poster: "/musicfile/${video.videophoto}"
                });
            },
            swfPath: "js",
            supplied: "webmv,mkv, m4v",
            size: {
                width: "100%",
                height: "auto",
                cssClass: "jp-video-360p"
            },
            globalVolume: true,
            smoothPlayBar: true,
            keyEnabled: true
        });

    });


    function sub() {
        if ($("#comment").val().length < 10) {
            $("#font").html("发布评论最少要10个以上的字符！");
            return false;
        } else {
            $("#font").html("");
            $("#fmt").submit();
        }
    }

    function toLogin() {
        window.location.href = "<%=basePath%>login.jsp";
    }

</script>
</body>
</html>