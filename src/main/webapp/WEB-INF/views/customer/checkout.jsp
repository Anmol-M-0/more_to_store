<%@page import="com.app.pojos.Address"%>
<%@page import="com.app.pojos.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="addr"
	value="${sessionScope.customerDetails.additionalDetails.customerAddress}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>More To Store</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->

<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
<link rel="stylesheet" href="<spring:url value='/css/customer.css'/>"/>
<script src="<spring:url value='/js/view_cart.js'/>"> </script>
	
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<!-- Font Awesome CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<!-- jQuery -->

<!-- Bootstrap JS -->
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
	<style>
        table
        { 
        table-layout: fixed;
        padding:10px 10px;
        display: inline-block;
        border:2px solid blue; 
        }  
        input[type="number"] {
        width:100px;
        }      
        </style>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
        $(document).ready(function(){
          
           
           function BillCopy(){
          
           if($("#cbox").is(":checked"))
           {
           
           $('#bcity').val($('#city').val());
           $('#bdistrict').val($('#district').val());
           $('#bstate').val($('#state').val());
           $('#badd_ln_1').val($('#add_ln_1').val());
        
           $('#badd_ln_2').val($('#add_ln_2').val());
           $('#bpost_office').val($('#post_office').val());
           $('#bpin_code').val($('#pin_code').val());
           $('#bcountry').val($('#country').val());
           
           }
           }
           $('#cbox').click( function(){
               
                BillCopy();
           })
        
        });
        </script>
</head>
<body style="background-color: white">

<%@include file="../customer_include/customer_navigation.jsp" %>
 
<%@include file="../customer_include/checkout.jsp" %>
<%@include file="../customer/footer.jsp"%>
</body>
</html>