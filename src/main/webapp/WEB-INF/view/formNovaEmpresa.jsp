<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Adicionar Nova Empresa</title>
	</head>
	<body>
		<form action="${linkNovaEmpresa}" method="post">
			Nome: <input type="text" name="nome"/>
			Data: <input type="text" name="data"/>
			<input type="hidden" name="acao" value="NovaEmpresa"/>
			<input type="submit"/>
		</form>
	
	</body>
</html>