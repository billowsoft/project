<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/recorder/resources/core/image/favicon.png">

    <title>杏花村</title>

    <!-- Bootstrap core CSS -->
    <link href="/recorder/resources/core/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/recorder/resources/core/css/blog.css" rel="stylesheet">
    <link rel="stylesheet" href="/recorder/resources/core/css/buttons.css">
    

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/recorder/resources/core/js/ie-emulation-modes-warning.js"></script>

  </head>

  <body>

    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item" href="/recorder/web/">首页</a>
          <a class="blog-nav-item active" href="/recorder/web/post">创建</a>
        </nav>
      </div>
    </div>

    <div class="container">

      <div class="row">

        <div class="col-sm-8 blog-main">

          <div class="blog-post">
    		<br/>
            <h2 class="blog-post-meta">创建信息</h2>
            <form:form action="/recorder/web/doPost" id="postForm"  method="post"  modelAttribute="article">
            <br/>
    	    标题：<form:input class="form-control" rows="5" id="title"  path="title" size="100"></form:input>
            <br/>
    	    内容：<form:textarea class="form-control" rows="5" id="content"  path="content"></form:textarea>
    		<br/>
    		类型：<form:select class="form-control" id="type"  path="type">
    			    <option value="blog">博客</option>
    			    <option value="message">消息</option>
    			    <option value="other">其他</option>
    		</form:select>
    		<br/>
            <a class="button button-raised button-primary button-pill" id="postButton">提交</a>
            </form:form>
          </div><!-- /.blog-post -->

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>关于</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->

    <footer class="blog-footer">
      <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/recorder/resources/core/js/jquery.min.js"></script>
    <script src="/recorder/resources/core/js/bootstrap.min.js"></script>
    <script src='/recorder/resources/core/js/tinymce.min.js'></script>
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/recorder/resources/core/js/ie10-viewport-bug-workaround.js"></script>
    <script>
		$( "#postButton" ).click(function( ) {
			$('#postForm').submit();
		});
 	   tinymce.init({
			    selector: '#content'
		});

</script>
 
  </body>
  
</html>
