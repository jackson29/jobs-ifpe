<?php 

session_start();
include 'cabecalho.php';
include 'conexao.php';
?>
<main>

  <div class="container">
   
    <form action="form-login.php" method="post">
      <div class="form-row">
        <div class="form-group col-md-12">
          <h2>Login</h2>
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="nomeFan">Email:</label>
          <input type="text" class="form-control" id="nomeFan" placeholder="Email" name="Email" required>
        </div>

      </div>

      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="fone">senha:</label>
          <input type="text" class="form-control" id="fone" placeholder="senha" name="senha">
        </div>
        </div>
        </div>
        </div>
      
      <div class="form-row">
        <div class="form-group col-md-2">
         <center> <button type="submit" class="btn btn-primary">Cadastrar</button></center>
        </div>
      </div>
    </form>
  </div>
</main>