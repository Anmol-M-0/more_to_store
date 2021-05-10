<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<form action='<spring:url value="/login"/>' method="post">
  <div class="imgcontainer">
    <img src='<spring:url value="/image/brand.png"/>' class="avatar">
  </div>

  <div class="container">
    <label for="email"><b>Email</b></label>
    <input type="email" placeholder="Enter Email" name="email" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button style="width: 100%;" type="submit">Login</button>
    <label>
     
    </label>
  </div>
  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    New user Register <a href='<spring:url value="/customer/register"/>'>Here</a>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>