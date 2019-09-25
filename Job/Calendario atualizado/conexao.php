<?php
/* @author Cesar Szpak - Celke - cesar@celke.com.br
 * @pagina desenvolvida usando FullCalendar e Bootstrap 4,
 * o código é aberto e o uso é free,
 * porém lembre-se de conceder os créditos ao desenvolvedor.
 */
$host = "mysql:dbname=jobs;host=localhost";
$usuariobd="teste";
$senhabd="123456"

	try{
		$pdo=new PDO($host, $usuariobd, $senhabd);
	}

	catch(PDOExecption $e){
		echo "Falha: ". $e->getMessage();
	}


?>