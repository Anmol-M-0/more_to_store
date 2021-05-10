<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<form action='<spring:url value="/register"/>' method="post">
  <div class="imgcontainer">
    <img src='<spring:url value="/image/brand.png"/>' class="avatar">
  </div>

  <div class="container">
  <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Full name" name="name"  maxlength="30"   required>
    
    <label for="email"><b>Email</b></label>
    <input type="email" placeholder="Enter Email" name="email" required>

  <label for="mobile"><b>Mobile</b></label>
    <input type="text" placeholder="Enter Mobile No" name="mobile" pattern="^\d{10}$" title="Enter 10 digit mobile no"
           required>
    
    <label for="password"><b>Password</b></label>
    <input type="text" placeholder="Enter Password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
    
     <label for="password_confirmation"><b>Confirm Password</b></label>
    <input type="password" placeholder="Enter Password" name="password_confirmation" required>
    

    <button style="width: 100%;" type="submit">Register</button>
    <label>
     
    </label>
  </div>
  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    Already Registered User Login <a href='<spring:url value="/customer/login"/>'>Here</a>
 
  </div>
</form>