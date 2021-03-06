<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Chat</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="/resources/css/chat.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function(){

            var n = 1;

            $("#msg").keydown(function (e){
                if(/*e.ctrlKey && */e.keyCode == 13){
                    $("#submit").click();
                }
            })
                       
            getMsg(n);
        });
    </script>

    <script type="text/javascript">

        var list;

        function getMsg(n){
            $.ajax({
                url: "getMsg/" + n,
                datatype: "JSON",
                success: function(data){
                    //if(data.users == null)
                        //$("#receivedMsg").append("<tr><td>" + data.msg + "<td><tr>");
                    //else
                        list = data.list;
                        document.getElementById('listdiv').innerHTML = list;
                },
                complete: function(){
                    //if(data.users == null)
                        n = n + 1;
                    getMsg(n);
                }
            });
        }
    </script>

    
    <script type="text/javascript">
        function sendMsg(){
            $.ajax({
                type: "POST",
                url: "sendMsg",
                data: {author: $("#author").val(), message: $("#msg").val()},
                success: function(){
                    $("#msg").val("")
                }
            });
        }
    </script>



</head>
<body>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <div class="btn-panel btn-panel-conversation">
                <a href="" class="btn  col-lg-6 send-message-btn " role="button"><i class="fa fa-search"></i> Search</a>
                <a href="" class="btn  col-lg-6  send-message-btn pull-right" role="button"><i class="fa fa-plus"></i> New Message</a>
            </div>
        </div>
            <input type="hidden" name="author" id="author" value="Антон">   <!-- value="${author}" -->
        <div class="col-lg-offset-1 col-lg-7">
            <div class="btn-panel btn-panel-msg">

                <a href="" class="btn  col-lg-3  send-message-btn pull-right" role="button"><i class="fa fa-gears"></i> Settings</a>
            </div>
        </div>
    </div>
    <div class="row">

        <div id = "listdiv" class="conversation-wrap col-lg-3">


            <c:forEach items="${list}" var="user">
                
                <div class="media conversation">
                    <a class="pull-left" href="#">
                        <img class="media-object" data-src="holder.js/64x64" alt="64x64" style="width: 50px; height: 50px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAACqUlEQVR4Xu2Y60tiURTFl48STFJMwkQjUTDtixq+Av93P6iBJFTgg1JL8QWBGT4QfDX7gDIyNE3nEBO6D0Rh9+5z9rprr19dTa/XW2KHl4YFYAfwCHAG7HAGgkOQKcAUYAowBZgCO6wAY5AxyBhkDDIGdxgC/M8QY5AxyBhkDDIGGYM7rIAyBgeDAYrFIkajEYxGIwKBAA4PDzckpd+322243W54PJ5P5f6Omh9tqiTAfD5HNpuFVqvFyckJms0m9vf3EY/H1/u9vb0hn89jsVj8kwDfUfNviisJ8PLygru7O4TDYVgsFtDh9Xo9NBrNes9cLgeTybThgKenJ1SrVXGf1WoVDup2u4jFYhiPx1I1P7XVBxcoCVCr1UBfTqcTrVYLe3t7OD8/x/HxsdiOPqNGo9Eo0un02gHkBhJmuVzC7/fj5uYGXq8XZ2dnop5Mzf8iwMPDAxqNBmw2GxwOBx4fHzGdTpFMJkVzNB7UGAmSSqU2RoDmnETQ6XQiOyKRiHCOSk0ZEZQcUKlU8Pz8LA5vNptRr9eFCJQBFHq//szG5eWlGA1ywOnpqQhBapoWPfl+vw+fzweXyyU+U635VRGUBOh0OigUCggGg8IFK/teXV3h/v4ew+Hwj/OQU4gUq/w4ODgQrkkkEmKEVGp+tXm6XkkAOngmk4HBYBAjQA6gEKRmyOL05GnR99vbW9jtdjEGdP319bUIR8oA+pnG5OLiQoghU5OElFlKAtCGr6+vKJfLmEwm64aosd/XbDbbyIBSqSSeNKU+HXzlnFAohKOjI6maMs0rO0B20590n7IDflIzMmdhAfiNEL8R4jdC/EZIJj235R6mAFOAKcAUYApsS6LL9MEUYAowBZgCTAGZ9NyWe5gCTAGmAFOAKbAtiS7TB1Ng1ynwDkxRe58vH3FfAAAAAElFTkSuQmCC">
                    </a>
                    <div class="media-body">
                        <h5 class="media-heading">${user}</h5>
                        <small>Hello</small>
                    </div>
                </div>

            </c:forEach>

          
        </div>



        <div class="message-wrap col-lg-8">
            <div class="msg-wrap">


                <div class="media msg">
                
                    <table id="receivedMsg"></table>

                </div>
            
            <!--    
                <div class="alert alert-info msg-date">
                    <strong>Today</strong>
                </div>
            -->

            </div>

            <div class="send-wrap ">

                <textarea id="msg" class="form-control send-message" rows="3" placeholder="Write a reply..."></textarea>


            </div>
            <div class="btn-panel">
                <a href="" class=" col-lg-3 btn   send-message-btn " role="button"><i class="fa fa-cloud-upload"></i> Add Files</a>
            <!--
                <a href="" class=" col-lg-4 text-right btn   send-message-btn pull-right" role="button"><i class="fa fa-plus"></i> Send Message</a>
            -->
                <button id="submit" onclick="sendMsg()" class="col-lg-4 text-right btn send-message-btn pull-right" role="button"><i class="fa fa-plus"></i> Send Message</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>
