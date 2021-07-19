<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta content="" name="description"/>
    <meta content="webthemez" name="author"/>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>

    <title>歌手管理</title>
    <jsp:include page="/part/manager.css.jsp"></jsp:include>
</head>
<body>
<div id="wrapper">
    <!--头部：页面标题栏-->
    <jsp:include page="/part/manager.header.jsp"></jsp:include>
    <!--导航栏：页面菜单栏-->
    <jsp:include page="/part/manager.menu.jsp"></jsp:include>
    <!--表格-->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!-- start dataTables -->
                    <!-- 表格格式：面板中嵌套表格 -->
                    <div class="panel panel-default">
                        <!-- 面板头放：页面标题，刷新按钮，添加按钮 -->
                        <div class="panel-heading">
                            <font size="4">歌手管理</font> <a href="#"> <span
                                class="glyphicon glyphicon-repeat"></span>
                        </a>
                            <span style="float: right">
                                <button type="button" class="btn btn-default btn-sm"
                                        data-toggle="modal" onclick="download()">
										<span class="glyphicon glyphicon-plane"></span>导出名单
                                </button>

                                <button type="button" class="btn btn-default btn-sm"
                                        data-toggle="modal" data-target="#myModal" onclick="editInfo(this,0)">
                                    <span class="glyphicon glyphicon-plane"></span> 添加操作
                                </button>
                            </span>
                        </div>
                        <!-- 面板体放：表格内容，按照dataTable格式来构造-->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover dataTables-example "
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>歌手编号</th>
                                        <th>歌手名称</th>
                                        <th>歌手图片</th>
                                        <th>歌手热度</th>
                                        <th>歌手类型</th>
                                        <th>歌手地址</th>
                                        <th>修改</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${not empty info }">
                                        <c:forEach var="s" items="${info.list }">
                                            <tr>
                                                <td>${s.singerid}</td>
                                                <td>${s.singername}</td>
                                                <td><img src="/musicfile/${s.singerphotourl}" width="50px"
                                                         height="50px"></td>
                                                <td>${s.singerhot}</td>
                                                <td>${s.singerType.typename}</td>
                                                <td>${s.address}</td>
                                                <td>
                                                    <a href="#" data-toggle="modal" data-target="#myModal"
                                                       onclick="editInfo(this,1)">
                                                        <span class="glyphicon glyphicon-edit"></span>
                                                    </a>
                                                </td>
                                                <td>
                                                    <a href="javascript:doRemove(${s.singerid},'${s.singername}')"
                                                       style="color:rgb(212,106,64)">
                                                        <span class="glyphicon glyphicon-remove"></span>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    </tbody>
                                </table>

                                <table class="table table-bordered table-hover definewidth m10">
                                    <tr>
                                        <th colspan="5">
                                            <div class="inline pull-right page">
                                                <a href="<%=basePath%>/singer/toSingerManager?pageNO=1">第一页</a>

                                                <c:if test="${info.isFirstPage}">
                                                    上一页
                                                </c:if>
                                                <c:if test="${!info.isFirstPage}">
                                                    <a href="<%=basePath%>/singer/toSingerManager?pageNO=${info.prePage}">上一页</a>
                                                </c:if>

                                                <c:if test="${info.isLastPage}">
                                                    下一页
                                                </c:if>
                                                <c:if test="${!info.isLastPage}">
                                                    <a href="<%=basePath%>/singer/toSingerManager?pageNO=${info.nextPage}">下一页</a>
                                                </c:if>
                                                <a href="<%=basePath%>//singer/toSingerManager?pageNO=${info.pages}">最后一页</a>
                                                &nbsp;&nbsp;&nbsp;
                                                共<span class='current'>${info.total}</span>条记录<span
                                                    class='current'>${info.pageNum}/${info.pages}</span>页
                                            </div>
                                        </th>
                                    </tr>
                                </table>


                            </div>
                        </div>
                    </div>
                    <!--End dataTables -->
                    <!-- 按钮触发模态框 -->
                    <!-- 模态框（Modal） myModal-->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">×
                                    </button>
                                    <!-- 表单嵌套表格：规范表单格式 -->
                                    <form action="" id="form" method="post" role="form"
                                          enctype="multipart/form-data">
                                        <input type="hidden" id="op" name="op">
                                        <input type="hidden" id="singerId" name="singerid">
                                        <div class="form-group">
                                            <table class="table" style="font: '黑体';">
                                                <thead>
                                                <tr>
                                                    <th>歌手信息：</th>
                                                    <th></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td><b>歌手名称:</b></td>
                                                    <td>
                                                        <input type="text" id="singerName" name="singername"
                                                               class="form-control"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                <tr>
                                                    <td><b>歌手图片：</b></td>
                                                    <td>
                                                        <p><span class="fileDefault" style="font-size:3px"></span>
                                                            <input type="file" name="myFile" class="form-control"/>
                                                        </p>
                                                    </td>
                                                </tr>
                                                <td><b>歌手热度:</b></td>
                                                <td><input type="number" id="singerHot" name="singerhot"
                                                           class="form-control"/>
                                                </td>
                                                </tr>
                                                <tr>
                                                    <td><b>歌手类型:</b></td>
                                                    <td>
                                                        <input type="text" id="type" name="singerType.typename"
                                                               class="form-control"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><b>歌手地址:</b></td>
                                                    <td>
                                                        <input type="text" id="address" name="address"
                                                               class="form-control"/>
                                                    </td>
                                                </tr>

                                                </tbody>
                                            </table>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <input type="submit" value="提交" class="btn btn-primary">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/part/manager.js.jsp"></jsp:include>
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<script type="text/javascript">
    function editInfo(obj, type) {
        if (type == 0) {
            $("#form").attr("action", "<%=basePath%>singer/saveSinger");
            $("#op").val("add");
            $("#singerId").val("");
            $("#singerName").val("");
            $("#singerHot").val("");
            $("#type").val("");
            $(".fileDefault").text("不选择则为初始文件");
        } else {
            $("#form").attr("action", "<%=basePath%>singer/editSinger");
            $("#op").val("edit");
            var musicInfo = obj.parentNode.parentNode.childNodes;
            $("#singerId").val(musicInfo[1].innerText);
            $("#singerName").val(musicInfo[3].innerText);
            $("#singerHot").val(musicInfo[7].innerText);
            $("#type").val(musicInfo[9].innerText);
            $("#address").val(musicInfo[11].innerText);
            $(".fileDefault").text("不选择则为初始文件");
        }
    }

    function doRemove(videoId, name) {
        if (confirm("您确定删除 " + name + " 吗？")) {
            $.post("<%=basePath%>singer/delSingerById", {"singerId": videoId}, function (data) {
                alert("删除成功");
                window.location.reload();
            });
        }
    }

    function download(){
        if (confirm("您确定要下载吗？")) {
            window.location.href="<%=basePath%>singer/download";
        }
    }

    $(".glyphicon-repeat").click(function () {
        window.location.reload();
    });
</script>
</body>
</html>