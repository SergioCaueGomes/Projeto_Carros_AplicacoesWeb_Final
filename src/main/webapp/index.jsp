<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Carros</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<form action="CarrosServeletController" method="post" style="border: 2px solid black; padding: 10px; margin-top: 100px">
					<label>Modelo</label>
					<input class="form-control form-control-sm" type="text" name="modelo" placeholder="Digite o Meodelo do carro" aria-label=".form-control-sm example">
					
					<label style="margin-top: 10px">Ano</label>
					<input class="form-control form-control-sm" type="text" name="ano" placeholder="Digite o ano" aria-label=".form-control-sm example" style="margin-top: 5px">
					<button type="submit" class="btn btn-success" name="option" id="option" style="margin-top: 10px">/button>
				</form>
			</div>
			<div class="col-8">
				<form type="form" action="CarrosServelet" name="option" id="option" style="border: 2px solid black; margin-top: 100px">
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">Modelo</th>
					      <th scope="col">Ano</th>
					      <th scope="col">Paga IPVA</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">${requestScope.id}</th>
					      <td>${requestScope.modelo}</td>
					      <td>${requestScope.ano}</td>
					      
					    </tr>
					  </tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>