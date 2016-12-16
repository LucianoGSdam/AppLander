<%-- 
    Document   : index
    Created on : 11-dic-2016, 13:22:23
    Author     : luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body onload='redirect()'>
        
        <%
        System.out.println("Actualmente en index.jsp");
        
        %>
        <script>
        function redirect(){
            window.location="${pageContext.request.contextPath}/ServletCookies";           
        }       
        </script>
    </body>
</html>
