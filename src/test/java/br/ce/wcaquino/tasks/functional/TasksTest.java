package br.ce.wcaquino.tasks.functional;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TasksTest {


    public WebDriver acessarAplicacao(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://localhost:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void deveSalvarTarefaComSucesso(){
        WebDriver driver = acessarAplicacao();
        try{
            driver.findElement(By.id("")).click();

            driver.findElement(By.id("task")).sendKeys("Teste via Selenium");

            driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");

            driver.findElement(By.id("saveButton")).click();

            String message = driver.findElement(By.id("message")).getText();
            Assert.assertEquals("Sucess",message);

        } finally  {
            driver.quit();
        }

    }


    @Test
    public void naodeveSalvarTarefaSemDescricao(){
        WebDriver driver = acessarAplicacao();
        try{
            driver.findElement(By.id("addTodo")).click();

          //  driver.findElement(By.id("task")).sendKeys("Teste via Selenium");

            driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");

            driver.findElement(By.id("saveButton")).click();

            String message = driver.findElement(By.id("message")).getText();
            Assert.assertEquals("Fill the task Description",message);

        } finally  {
            driver.quit();
        }

    }




    @Test
    public void naodeveSalvarTarefaSemData(){
        WebDriver driver = acessarAplicacao();
        try{
            driver.findElement(By.id("")).click();

            driver.findElement(By.id("task")).sendKeys("Teste via Selenium");

           // driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");

            driver.findElement(By.id("saveButton")).click();

            String message = driver.findElement(By.id("message")).getText();
            Assert.assertEquals("Fill the due date",message);

        } finally  {
            driver.quit();
        }

    }

    @Test
    public void naoDeveSalvarTarefaComDataPassada(){
        WebDriver driver = acessarAplicacao();
        try{
            driver.findElement(By.id("")).click();

            driver.findElement(By.id("task")).sendKeys("Teste via Selenium");

            driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");

            driver.findElement(By.id("saveButton")).click();

            String message = driver.findElement(By.id("message")).getText();
            Assert.assertEquals("Sucess",message);

        } finally  {
            driver.quit();
        }

    }
}
