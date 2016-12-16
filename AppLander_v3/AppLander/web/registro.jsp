<%-- 
    Document   : login
    Created on : 12-dic-2016, 18:59:58
    Author     : luciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
		<title>Lunar Landing in HTML5</title>
		<link rel="stylesheet" href="css/style.css">
                <link rel="stylesheet" href="css/estilos.css">
	</head>
	<body>
            
            <div id="box">
            <h1>Regístrate</h1>
            <div id="formulario">
                <form id="register" action="ServletRegistro" method="post">
                    <label for="name_usuario">Usuario:</label>
                    <input type="text" name="name_usuario" /><hr/>
                    <label for="password">Contraseña:</label>
                    <input type="password" name="password" /><hr/>
                    <input type="submit" id="button" value="Registrar"/>
                    
                </form>
                
            </div>
            </div>
		
	</body>
</html>
