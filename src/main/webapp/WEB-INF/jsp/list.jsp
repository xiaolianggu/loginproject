<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
       <html>
       <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <title>列表</title>

              <script type="text/javascript" src="/js/jquery.min.js"></script>

              <script>
                     $(function () {

                                   // 发送ajax请求
                                   $.ajax({
                                          url: '/resume/query',
                                          type: 'POST',
                                          data: '{}',
                                          contentType: 'application/json;charset=utf-8',
                                          dataType: 'json',
                                          success: function (data) {
                                                 if(data=='error'){
                                                        window.location.href="/auth/toLogin";
                                                 }else{
                                                        var html ="";
                                                        for (var i=0;i<data.length;i++){
                                                               var id = data[i].id;
                                                              html+=' <tr id="id_"+id>';
                                                               html+='  <td>'+data[i].name+'</td>';
                                                               html+=' <td>'+data[i].address+'</td>';
                                                               html+='  <td>'+data[i].phone+'</td>';
                                                               html+=' <td><a href="/resume/toEdit?id='+id+'">编辑</a> <a href="/resume/delete?id='+id+'">删除</a></td>';
                                                               html+=' </tr>';
                                                        }
                                                        $("#resumeTable").append(html);
                                                 }
                                          }
                                   })



                     })


              </script>


       </head>
       <body>
       <a href="/resume/toAdd">添加</a>
       <table border="1" id="resumeTable">
              <tr>
                     <td>姓名</td>
                     <td>地址</td>
                     <td>手机号</td>
                     <td>操作</td>
              </tr>
       </table>
       </body>
       </html>