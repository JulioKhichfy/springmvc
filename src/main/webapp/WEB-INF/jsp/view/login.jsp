<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form action='<spring:url value="/loginAction"/>' method="post">
    <table>
      <tr>
        <td>Email!</td>
        <td><input type="text" name="email"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="senha"></td>
      </tr>
      <tr>
        <td><button type="submit">Login</button></td>
      </tr>
    </table>
  </form>