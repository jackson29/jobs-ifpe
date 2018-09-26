// Importa as bibliotecas necessárias
// import static org.junit.Assert.*;
// import static org.hamcrest.CoreMatchers.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.junit.Rule;
import org.junit.rules.TestName;


// Classe com os métodos de teste
public class Testes {

    @Rule
    public TestName name = new TestName();

    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest(){
        driver = new FirefoxDriver();
        System.out.println("--");
    }

    @AfterClass
    public static void tearDownTest(){
        System.out.println("--");
        driver.quit();
    }

    @Before
    public void init() {
        System.out.println(name.getMethodName());
        driver.get("http://localhost:9990/index.php");
    }

    public static void clear() {
        driver.get("http://localhost:9990/_base/clear.php");
    }

    public static String rgb(String hex) {
        String p1 = hex.substring(1, 3);
        String p2 = hex.substring(3, 5);
        String p3 = hex.substring(5, 7);

        return "rgb(" + Long.parseLong(p1, 16) + ", " + Long.parseLong(p2, 16) + ", " + Long.parseLong(p3, 16) + ")";
    }

    public static void wait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void fillForm(String title, String description) {
        List<WebElement> inputs = driver.findElements(By.name("title"));
        assertThat(inputs).as("Cadê o input[name=\"title\"]?").hasSize(1);
        WebElement titleInput = inputs.get(0);

        inputs = driver.findElements(By.name("description"));
        assertThat(inputs).as("Cadê o input[name=\"description\"]?").hasSize(1);
        WebElement descInput = inputs.get(0);

        titleInput.sendKeys(title);
        descInput.sendKeys(description);

    }

    public static void submitForm() {
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    }


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------



    // Testa se há um css externo
    @Test
    public void link_para_css() {
        List<WebElement> links = driver.findElements(By.tagName("link"));
        assertThat(links).as("deve ter apenas um <link>").hasSize(1);

        WebElement link = links.get(0);
        assertThat(link.getAttribute("href")).as("deve apontar para test.css").endsWith("tasks.css");
    }

    // Testa se o formulário é evniado via método post
    @Test
    public void post_method_form() {
        WebElement form = driver.findElement(By.tagName("form"));
        assertThat(form.getAttribute("method").toUpperCase()).as("o método deve ser POST").isEqualTo("POST");
    }

    // Testa se o formulário está sendo enviado para "add.php"
    @Test
    public void action_hello() {
        WebElement form = driver.findElement(By.tagName("form"));
        assertThat(form.getAttribute("action")).as("deve ser enviado para add.php").endsWith("add.php");
    }

    // Testa se o formulário tem dois inputs, com os atributos "name" corretos
    @Test
    public void input_name() {
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        assertThat(inputs).as("3 inputs -> 2 texto e 1 submit").hasSize(3);

        List<String> names = inputs.stream().map(e -> e.getAttribute("name")).collect(Collectors.toList());
        assertThat(names).as("input 'title'").contains("title");
        assertThat(names).as("input 'description'").contains("description");
    }

    // Testa se o envio está sendo feito corretamente
    @Test
    public void send_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");

        submitForm();

        assertThat(driver.getCurrentUrl()).endsWith("index.php");
    }

    // Testa se a tarefa está sendo escrito na página
    @Test
    public void receive_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");

        submitForm();

        wait(By.tagName("body"));

        WebElement tasksList = driver.findElement(By.className("tasks"));
        assertThat(tasksList).isNotNull();
        assertThat(tasksList.getText()).as("cadê a tarefa?").contains("Derrotar Thanos");
        assertThat(tasksList.getText()).as("deveria ser só o título?").doesNotContain("Chamar os vingadores");
    }

    // Testa se a tarefa está sendo colocada num link com o endereço correto
    @Test
    public void get_link_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");

        submitForm();

        wait(By.tagName("body"));

        WebElement taskLink = driver.findElement(By.cssSelector(".tasks a"));
        assertThat(taskLink).as("Deveria ter um <a>").isNotNull();
    }

    // Testa se o link está enviando para o lugar correto
    @Test
    public void link_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");

        submitForm();

        wait(By.tagName("body"));

        WebElement taskLink = driver.findElement(By.cssSelector(".tasks a"));
        assertThat(taskLink.getAttribute("href")).as("Deveria enviar para task.php").contains("task.php?id=0");
    }

    @Test
    public void multiple_links_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");
        submitForm();

        wait(By.tagName("body"));

        fillForm("Destruir a manopla", "Levar pro planeta dos anões");
        submitForm();

        wait(By.tagName("body"));


        List<WebElement> taskLinks = driver.findElements(By.cssSelector(".tasks a"));
        assertThat(taskLinks).as("Deveria ter dois links!").hasSize(2);
        assertThat(taskLinks.get(0).getAttribute("href")).as("Deveria enviar para task.php").contains("task.php?id=0");
        assertThat(taskLinks.get(1).getAttribute("href")).as("Deveria enviar para task.php").contains("task.php?id=1");
    }

    @Test
    public void get_title_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");

        submitForm();

        wait(By.tagName("body"));

        fillForm("Destruir a manopla", "Levar pro planeta dos anões");

        submitForm();

        wait(By.tagName("body"));


        driver.get("http://localhost:9990/task.php?id=0");

        WebElement body = driver.findElement(By.tagName("body"));
        assertThat(body.getText()).as("Deveria ter o título da tarefa").contains("Derrotar Thanos");
        assertThat(body.getText()).as("Deveria ter o título da tarefa").doesNotContain("Destruir a manopla");

        driver.get("http://localhost:9990/task.php?id=1");

        body = driver.findElement(By.tagName("body"));
        assertThat(body.getText()).as("Deveria ter o título da tarefa").doesNotContain("Derrotar Thanos");
        assertThat(body.getText()).as("Deveria ter o título da tarefa").contains("Destruir a manopla");
    }

    @Test
    public void get_description_test() {
        clear();

        fillForm("Derrotar Thanos", "Chamar os vingadores");

        submitForm();

        wait(By.tagName("body"));

        fillForm("Destruir a manopla", "Levar pro planeta dos anões");

        submitForm();

        wait(By.tagName("body"));


        driver.get("http://localhost:9990/task.php?id=0");

        WebElement body = driver.findElement(By.tagName("body"));
        assertThat(body.getText()).as("Deveria ter a descrição da tarefa").contains("Chamar os vingadores");
        assertThat(body.getText()).as("Deveria ter a descrição da tarefa").doesNotContain("Levar pro planeta dos anões");

        driver.get("http://localhost:9990/task.php?id=1");

        body = driver.findElement(By.tagName("body"));
        assertThat(body.getText()).as("Deveria ter a descrição da tarefa").doesNotContain("Chamar os vingadores");
        assertThat(body.getText()).as("Deveria ter a descrição da tarefa").contains("Levar pro planeta dos anões");
    }

}
