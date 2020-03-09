<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

       <html>
       <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <title>Insert title here</title>
       </head>
       <body>
       <h2>添加</h2>
       <fieldset>
              <form method="post"  action="/resume/add">
                     姓名：<input type="text" name="name"/><br>
                     地址：<input type="text" name="address"/><br>
                     手机号：<input type="text" name="phone"/><br>
                     <input type="submit" value="添加"/>
              </form>
       </fieldset>
       </body>
       </html>