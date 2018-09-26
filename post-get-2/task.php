<?php 
$id = $_GET['id']; ?>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
	<title>Document</title>
</head>
<body>
   <div class="task">
<?php
$file = file('tasks.csv');
?>
<h1>
	<?php echo $file[$id];?>
</h1>
	</div>
	
	<?php 
explode(delimiter, 'title')
?>
	
	
	

</body>
</html>

