<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

       <html>
       <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <title>Insert title here</title>
       </head>
       <body>
       <h2>编辑</h2>
       <fieldset>
              <form method="post"  action="/resume/edit">
                     姓名：<input type="text" name="name" value="${resume.name}"/><br>
                     地址：<input type="text" name="address" value="${resume.address}"/><br>
                     手机号：<input type="text" name="phone" value="${resume.phone}"/><br>
                     <input type="submit" value="添加"/><input type="hidden" name="id" value="${resume.id}"/>
              </form>
       </fieldset>
       </body>
       </html>