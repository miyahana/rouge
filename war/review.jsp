<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
	<center>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ストア</title>
    </head>
    
    <body>
    <h1>レビュー</h1>
    レビューを書き込む商品を選択してください
    	<br>
    	<br>
		<form action ="/review" method="post">
			<input type="radio" name="rouge" value="CANMAKE">CANMAKE(550円)
			<input type="radio" name="rouge" value="MAYBELLINE">MAYBELLINE(1200円)
			<input type="radio" name="rouge" value="ANNASUI">ANNASUI(2800円)
			<input type="radio" name="rouge" value="MAC">MAC(3300円)
			<input type="radio" name="rouge" value="CHANEL">CHANEL(4500円)
			<input type="radio" name="rouge" value="KiSHiORiGiNAL">KiSHiORiGiNAL(12000円)
			<br>
			<br>
			<input type="submit" value="レビューを書き込む">
		</form>
    </body>
    </center>
</html>