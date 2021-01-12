<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto ASR</title>
</head>
<body>
<h1>Proyecto de ASR Candela Janeiro</h1>
<h2>Integración con Servicios Cloudant con Watson Language Translator, Watson Text to Speech y Watson Speech to Text</h2>
<hr />
<p>Opciones:</p>
<ul>

<li><a href="listar">Listar</a></li>

<li>
<form action="/insertar" method="get">
Palabra en español para traducir: <input type="text" name="palabra" id="palabra">
<input type="submit" name="guardar" value="Traducir y guardar en Cloudant">
</form>
</li>

<li>
<form action="/escuchar" method="get">
Inserte el texto que desea escuchar <input type="text" name="texto" id="texto">
<input type="submit" name="a_escuchar" value="Generar audio">
</form>
</li>

<li><a href="leer">Transcripción audio descargado</a></li>


</ul>
</body>
</html>