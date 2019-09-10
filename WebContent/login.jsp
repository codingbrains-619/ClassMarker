<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<link href="css/style.css" rel ="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script>
window.addEventListener("load", init);
function init() {
	let message = document.getElementById('alert');
	console.log("Message is ",message.innerText);
	if (message.innerText == "Invalid") {
		message.innerText = " ";
		alert("Invalid Userid or Password....");
	}
}
</script>
</head>
<body>
<div class="container-fluid">
	 <section class="sign-in">
            <div class="container">
            <h6 id="alert" class="text-center"><s:property value="message"/></h6>
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/signin-image.jpg" alt="sign in image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign In</h2>
                        <form action="login" method="post">
                            <div class="form-group">
                            	<s:textfield type="text" name="userid" id="userid" placeholder="Your Name"/>
                            </div>
                            <div class="form-group">
                            	<s:textfield type="password" name="password" id="password" placeholder="Your Password"/>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </section>
</div>
</body>
</html>