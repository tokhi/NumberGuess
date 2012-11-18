
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="guessNumber" class="beans.NumberGussBeans" scope="session" />
<jsp:setProperty property="guess" name="guessNumber" param="guess" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guess Game</title>
</head>
<body>
Guess a number:
<form action="NumberView.jsp">
	<input type="text" name = "guess">
	<input type="submit" value="submit Guess" />
</form>
${guessNumber.msg}
</body>
</html>