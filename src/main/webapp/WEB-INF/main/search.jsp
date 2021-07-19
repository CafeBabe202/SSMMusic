<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<title>优就业Music</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="<%=basePath%>js/jPlayer/jplayer.flat.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/animate.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/simple-line-icons.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/font.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/app.css" type="text/css" />
<!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
	<section class="vbox">
		<header
			class="bg-white-only header header-md navbar navbar-fixed-top-xs">
			<div class="navbar-header aside bg-info nav-xs">
				<a class="btn btn-link visible-xs"
					data-toggle="class:nav-off-screen,open" data-target="#nav,html">
					<i class="icon-list"></i>
				</a> <a href="<%=basePath%>user/toIndex" class="navbar-brand text-lt"> <i
					class="icon-earphones"></i> <img src="<%=basePath%>images/logo.png"
					alt="." class="hide"> <span class="hidden-nav-xs m-l-sm">Music</span>
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
						<li class="dropdown"><a href="#"
							class="dropdown-toggle bg clear" data-toggle="dropdown"> <span
								class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm"></span>
								<span class="glyphicon glyphicon-user"></span>&emsp;${user.userName}
								<b class="caret"></b>
						</a>

							<ul class="dropdown-menu animated fadeInRight">
								<li><a href="<%=basePath%>user/logout"><span
										class="glyphicon glyphicon-log-out"></span>&nbsp;退出登录</a></li>
							</ul></li>
					</ul>
				</c:if>
				<c:if test="${empty user}">
					<p></p>
					<a href="<%=basePath%>user/userLogin"><span
						class="glyphicon glyphicon-log-in"></span>&nbsp;登录</a>
					<span>&emsp;</span>
					<a href="<%=basePath%>user/toUserLogon"><span
						class="glyphicon glyphicon-new-window"></span>&nbsp;免费注册</a>
				</c:if>
				<span>&emsp;</span> <a target="_blank"
					href="<%=basePath%>user/toAdminLogin"><span
					class="glyphicon glyphicon-new-window"></span>&nbsp;管理员登录</a>
			</div>
		</header>
		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<aside class="bg-black dk nav-xs aside hidden-print" id="nav">
					<section class="vbox">
						<section class="w-f-md scrollable">
							<div class="slim-scroll" data-height="auto"
								data-disable-fade-out="true" data-distance="0" data-size="10px"
								data-railOpacity="0.2">
								<!-- nav -->
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
									<!-- / nav -->
							</div>
						</section>

						<footer class="footer hidden-xs no-padder text-center-nav-xs">
							<div class="bg hidden-xs ">
								<div class="dropdown dropup wrapper-sm clearfix">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<span class="thumb-sm avatar pull-left m-l-xs"> <img
											src="<%=basePath%>images/a3.png" class="dker" alt="...">
											<i class="on b-black"></i>
									</span> <span class="hidden-nav-xs clear"> <span
											class="block m-l"> <strong class="font-bold text-lt">John.Smith</strong>
												<b class="caret"></b>
										</span> <span class="text-muted text-xs block m-l">Art
												Director</span>
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
					<section class="hbox stretch">
						<section>
							<section class="vbox">
								<section class="scrollable padder-lg w-f-md" id="bjax-target">
									<a href="#" class="pull-right text-muted m-t-lg"
										data-toggle="class:fa-spin"><i
										class="icon-refresh i-lg  inline" id="refresh"></i></a>
									<h2 class="font-thin m-b">
										${msg} <span class="musicbar inline m-l-sm"
											style="width: 20px; height: 20px"> <span
											class="bar1 a1 bg-primary lter"></span> <span
											class="bar2 a2 bg-info lt"></span> <span
											class="bar3 a3 bg-success"></span> <span
											class="bar4 a4 bg-warning dk"></span> <span
											class="bar5 a5 bg-danger dker"></span>
										</span>
									</h2>
									<div class="row row-sm">
										<c:if test="${not empty singerMusicList}">
											<c:forEach var="m" items="${singerMusicList}" varStatus="st">
												<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
													<div class="item">
														<div class="pos-rlt">
															<div class="bottom">
																<span class="badge bg-info m-l-sm m-b-sm"> <!-- 03:20 -->
																</span>
															</div>
															<div class="item-overlay opacity r r-2x bg-black ">
																<!--active-->
																<div class="text-info padder m-t-sm text-sm">
																	<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																		class="fa fa-star"></i> <i
																		class="fa fa-star-o text-muted"></i> <i
																		class="fa fa-star-o text-muted"></i>
																</div>
																<div class="center text-center m-t-n">
																	<a href="#" data-toggle="class"
																	   class="RondomSongs jp-play-me" st="${st.index}"> <i
																			class="icon-control-play i-2x text"></i> <i
																			class="icon-control-pause i-2x text-active"></i>
																	</a>
																</div>
																<div class="bottom padder m-b-sm">
																	<!-- active -->
																	<a href="#" class="pull-right " data-toggle="class">
																		<i class="fa fa-heart-o text"></i> <i
																			class="fa fa-heart text-active text-danger"></i>
																	</a> <a href="#" data-toggle="class"> <i
																		class="fa fa-plus-circle text"></i> <i
																		class="fa fa-check-circle text-active text-info"></i>
																</a>
																</div>
															</div>
															<!-- width="50px" height="200px" -->
															<a href="#"><img src="/musicfile/${m.musicphotourl}"
																			 width="40px" height="230px"
																			 alt="" class="r r-2x img-full"></a>
														</div>
														<div class="padder-v">
															<a href="#" class="text-ellipsis">${paramValues.musicname}</a>
															<a
																	href="#"
																	class="text-ellipsis text-xs text-muted">${m.singerName}</a>
														</div>
													</div>
												</div>
												<div class="clearfix visible-xs"></div>
											</c:forEach>
										</c:if>
									</div>
								</section>
								<footer class="footer bg-dark">
									<div id="jp_container_N">
										<div class="jp-type-playlist">
											<div id="jplayer_N" class="jp-jplayer hide"></div>
											<div class="jp-gui">
												<div class="jp-video-play hide">
													<a class="jp-video-play-icon">play</a>
												</div>
												<div class="jp-interface">
													<div class="jp-controls">
														<div>
															<a class="jp-previous"><i
																class="icon-control-rewind i-lg"></i></a>
														</div>
														<!-- 上一首按钮 -->
														<div>
															<a class="jp-play"><i class="icon-control-play i-2x"></i></a>
															<!-- 暂停按钮 -->
															<a class="jp-pause hid"><i
																class="icon-control-pause i-2x"></i></a>
														</div>
														<div>
															<a class="jp-next"><i
																class="icon-control-forward i-lg"></i></a>
														</div>
														<!-- 下一首按钮 -->
														<div class="hide">
															<a class="jp-stop"><i class="fa fa-stop"></i></a>
														</div>
														<div>
															<a class="" data-toggle="dropdown"
																data-target="#playlist"><i class="icon-list"></i></a>
														</div>
														<!-- 播放列表 -->
														<div class="jp-progress hidden-xs">
															<div class="jp-seek-bar dk">
																<div class="jp-play-bar bg-info"></div>
																<div class="jp-title text-lt">
																	<ul>
																		<li></li>
																	</ul>
																</div>
															</div>
														</div>
														<div
															class="hidden-xs hidden-sm jp-current-time text-xs text-muted"></div>
														<div
															class="hidden-xs hidden-sm jp-duration text-xs text-muted"></div>
														<div class="hidden-xs hidden-sm">
															<a class="jp-mute" title="mute"><i
																class="icon-volume-2"></i></a> <a class="jp-unmute hid"
																title="unmute"><i class="icon-volume-off"></i></a>
														</div>
														<div class="hidden-xs hidden-sm jp-volume">
															<div class="jp-volume-bar dk">
																<div class="jp-volume-bar-value lter"></div>
															</div>
														</div>
														<div>
															<a class="jp-shuffle" title="shuffle"><i
																class="icon-shuffle text-muted"></i></a> <a
																class="jp-shuffle-off hid" title="shuffle off"><i
																class="icon-shuffle text-lt"></i></a>
														</div>
														<div>
															<a class="jp-repeat" title="repeat"><i
																class="icon-loop text-muted"></i></a> <a
																class="jp-repeat-off hid" title="repeat off"><i
																class="icon-loop text-lt"></i></a>
														</div>
														<div class="hide">
															<a class="jp-full-screen" title="full screen"><i
																class="fa fa-expand"></i></a> <a class="jp-restore-screen"
																title="restore screen"><i
																class="fa fa-compress text-lt"></i></a>
														</div>
													</div>
												</div>
											</div>
											<div class="jp-playlist dropup" id="playlist">
												<ul class="dropdown-menu aside-xl dker">
													<!-- The method Playlist.displayPlaylist() uses this unordered list -->
													<li class="list-group-item"></li>
												</ul>
											</div>
											<div class="jp-no-solution hide">
												<span>Update Required</span> To play the media you will need
												to either update your browser to a recent version or update
												your <a href="http://get.adobe.com/flashplayer/"
													target="_blank">Flash plugin</a>.
											</div>
										</div>
									</div>
								</footer>
							</section>
						</section>
						<!-- side content -->
						
						
								
								<aside class="aside-md bg-light dk" id="sidebar">
							<section class="vbox animated fadeInRight">
								<section class="w-f-md scrollable hover">
									<h4 class="font-thin m-l-md m-t">歌手排行</h4>
									<ul class="list-group no-bg no-borders auto m-t-n-xxs">
										<c:if test="${not empty singerRankList }">
											<c:forEach var="s" items="${singerRankList}">
												<li class="list-group-item"><span
														class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
											    <a href="<%=basePath%>music/getMusicBySingerId?sid=${s.singerid}">
														<img src="/musicfile/${s.singerphotourl }" alt="..."
															 class="img-circle listen" singerId="${s.singerid}">
														<i class="on b-light right sm"></i>
												</span>
													<div class="clear">
														<div>
																${s.singername }
														</div>
														<small class="text-muted">${s.address }</small>
													</div>
													</a>
												</li>
											</c:forEach>
										</c:if>
									</ul>
								</section>
								
								<footer class="footer footer-md bg-black">
									<form class="" role="search">
										<div class="form-group clearfix m-b-none">
											<div class="input-group m-t m-b">
												<span class="input-group-btn">
													<button type="submit"
														class="btn btn-sm bg-empty text-muted btn-icon">
														<i class="fa fa-search"></i>
													</button>
												</span> <input type="text"
													class="form-control input-sm text-white bg-empty b-b b-dark no-border"
													placeholder="Search members">
											</div>
										</div>
									</form>
								</footer>
							</section>
						</aside>
						<!-- / side content -->
					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
				</section>
			</section>
		</section>
	</section>
	<%-- <script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.js"></script> --%>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.js"></script>
	<!-- App -->
	<script type="text/javascript" src="<%=basePath%>js/app.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/app.plugin.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jPlayer/jquery.jplayer.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jPlayer/add-on/jplayer.playlist.min.js"></script>
	<!-- 	<script type="text/javascript" src="js/jPlayer/demo.js"></script> -->
	<script type="text/javascript">
	  var myPlaylist; 
	  $(".RondomSongs").click(function(){
		  var r =$(this).attr("class");
		  if(r.indexOf('active')>=0){  
		  }else{
			  myPlaylist.remove();
			  var newSongs = ${singerMusicJson};
			  if(newSongs.length>0){
				 for(var i=0;i<newSongs.length;i++){
					 myPlaylist.add({
						 title: newSongs[i].musicname,
						 artist: newSongs[i].singername,
						 mp3: "/musicfile/" + newSongs[i].songurl,
						 poster: "/musicfile/" + newSongs[i].musicphotourl
					 });
				 }
			  }
		  }
		  opration();
	  });
	 
	  $(document).ready(function(){
		  getlist();
		  opration();
	   });
	   function getlist(){
		      myPlaylist = new jPlayerPlaylist({
			    jPlayer: "#jplayer_N",
			    cssSelectorAncestor: "#jp_container_N"
			  },${singerMusicJson},{
			    playlistOptions: {
			      enableRemoveControls: true,
			      autoPlay: false
			    },
			    swfPath: "js/jPlayer",
			    supplied: "webmv, ogv, m4v, oga, mp3",
			    smoothPlayBar: true,
			    keyEnabled: true,
			    audioFullScreen: false
			  });
  	    }
	   function opration(){
		   $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
				  $('.musicbar').removeClass('animate');
			    $('.jp-play-me').removeClass('active');
			    $('.jp-play-me').parent('li').removeClass('active');
			  });
		
			  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
			    $('.musicbar').addClass('animate');
			  });
		
			 $(document).on('click', '.jp-play-me', function(e){
			    e && e.preventDefault();
			    var $this = $(e.target);
			    if (!$this.is('a')) $this = $this.closest('a');
			    $('.jp-play-me').not($this).removeClass('active');
			    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');		    
			    $('.jp-play-me').not($this).find(".item-overlay").removeClass('active');
			    if( !$this.hasClass('active') ){
			      myPlaylist.pause();
			    }else{
			    	var a = $(this).attr("st");
			    	myPlaylist.play(a);
			    }
			  });
	   }
  </script>
</body>
</html>