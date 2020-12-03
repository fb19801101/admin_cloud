<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/3/4
  Time:    11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>拉动式生产后台管理框架</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/layui-2.5.6/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/js/layui-2.5.6/ext/modules/admin/style/admin.css" media="all">

  <style>
  /*扩展三级菜单*/
  .child-margin{margin-left: 12px;}
  </style>
</head>
<body class="layui-layout-body">
  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
            <li data-name="toolDemo" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:" lay-tips="拉动式生产 ★ 辅助类" lay-direction="2">
                <i class="layui-icon layui-icon-util"></i>
                <cite>坐标计算转转</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="measure" class="layui-nav-itemed">
                  <a href="javascript:"><i class="fa fa-money fa-fw" aria-hidden="true"></i>&nbsp;测量计算工具</a>
                  <dl class="layui-nav-child">
                    <dd data-name="template" class="layui-nav-itemed">
                      <a href="javascript:"><i class="fa fa-money fa-fw" aria-hidden="true"></i>&nbsp;平曲线计算</a>
                      <dl class="layui-nav-child child-margin">
                        <dd data-name="template"><a layadmin-href="/software/toolMeasure">
                          <i class="fa fa-file-excel-o fa-fw" aria-hidden="true"></i>&nbsp;曲线要素录入</a></dd>
                        <dd data-name="template"><a layadmin-href="/software/toolMeasure">
                          <i class="fa fa-file-excel-o fa-fw" aria-hidden="true"></i>&nbsp;逐桩坐标计算</a></dd>
                        <dd data-name="template"><a layadmin-href="/software/toolMeasure">
                          <i class="fa fa-file-excel-o fa-fw" aria-hidden="true"></i>&nbsp;坐标正反算</a></dd>
                      </dl>
                      <dl class="layui-nav-child">
                        <dd data-name="template">
                          <a href="javascript:"><i class="fa fa-money fa-fw" aria-hidden="true"></i>&nbsp;竖曲线计算</a>
                          <dl class="layui-nav-child child-margin">
                            <dd data-name="template"><a layadmin-href="/software/toolMeasure">
                              <i class="fa fa-file-excel-o fa-fw" aria-hidden="true"></i>&nbsp;曲线要素录入</a></dd>
                            <dd data-name="template"><a layadmin-href="/software/toolMeasure">
                              <i class="fa fa-file-excel-o fa-fw" aria-hidden="true"></i>&nbsp;逐桩高程计算</a></dd>
                            <dd data-name="template"><a layadmin-href="/software/toolMeasure">
                              <i class="fa fa-file-excel-o fa-fw" aria-hidden="true"></i> 高程正反算</a></dd>
                          </dl>
                  </dl>
                </dd>
              </dl>
            </li>
          </ul>
      </div>

      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body" style="margin-top: -50px">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="toolMeasure" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
      </div>
    </div>
  </div>

  <script src="${pageContext.request.contextPath}/res/js/layui-2.5.6/layui.js"></script>
  <script>
  layui.config({
    base: '${pageContext.request.contextPath}/res/js/layui-2.5.6/ext/modules/admin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'layer', 'form', 'layedit','element', 'upload', 'table', 'jquery'], function(){
    var layer = layui.layer //layer弹层
        ,index = layui.index //index模块
        ,$ = layui.$; //jQuery

    //页面跳转
    $('body').on('click', '*[layadmin-href]', function(){
      var othis = $(this)
          ,href = othis.attr('layadmin-href')
          ,text = othis.attr('lay-text');

      //执行跳转
      index.openTabsPage(href, text || othis.text());
    });
  });
  </script>
</body>
</html>


