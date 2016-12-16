<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
        <title>Lunar Landing in HTML5</title>
        <!-- Stylesheets -->
        <link rel="stylesheet" href="css/styles.css" type="text/css" media="screen, projection" />
        <!-- Javascripts -->
        <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
        <script language="javascript" type="text/javascript" src="js/nav2.2.js"></script>
        <script language="javascript" type="text/javascript">
    		$(document).ready(function(){
				$("#JqueryMenu").navPlugin();
			});
    </script>
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/lunar.js"></script>
    </head>
    <body>
        
        <div class="content">
            <div id="dropdown">
                <ul id="JqueryMenu">
                    <li><a href="#">Mis partidas</a></li>
                    <li><a href="#">Top 10</a></li>
                    <li><a href="#">Jugadores online</a></li>
                    <li><a href="login.jsp">Salir</a></li>
                </ul>

            </div>  <!-- end of navmenu -->
        </div>





    </div>
    <div id="state">
        <div class="container">
            <h1></h1>
            <h2></h2>
            <a href="#" onclick="reset();">Play again</a>
        </div>
    </div>
    <div id="game">
        <div id="gauge"><div></div></div>
        <div id="ship"></div>
        <div id="explode"></div>
        <div id="moon">
            <div id="landing-pad"><div id="ms">-</div></div>
        </div>
    </div>

</body>
</html>