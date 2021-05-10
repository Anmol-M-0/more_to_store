<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if ((session.getAttribute("vendorDetails") == null) || (session.getAttribute("vendorDetails") == "")) {
%>
 <c:redirect url="../"></c:redirect>
<%}else{%>

<%@include file="../vendor_include/vendor_template.jsp" %>
<%@include file="../vendor_include/product_i_list.jsp" %>
<%@include file="../vendor_include/vendor_footer.jsp" %>
<%@include file="../vendor_include/vendor_logout_alert.jsp" %>
<%}%>