<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Input data</title>
  </head>
  <body>

    <form method="get" action="main" >
        <input type="hidden" name="command" value="authorization"/>
        <label> Name: </label> <br/>
        <input type="text" name="name" placeholder="Name" /> <br/>
        <label> Surname: </label> <br/>
        <input type="text" name="surname" placeholder="Surname" /><br/>
        <input type="submit" name="Submit"/>
    </form>

  </body>
</html>
