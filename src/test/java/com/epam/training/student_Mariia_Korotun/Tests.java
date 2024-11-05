package com.epam.training.student_Mariia_Korotun;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tests {
    private WebDriver driver;
    @Given("I am on the SauceDemo login page")
    public void loginPage(){
        driver = DriverManagerClass.getWebDriver();
    }
    @When("I type any credentials in the username and password fields")
    public void credentialsInFields(){
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");
    }
    @When("I clear the inputs")
    public void clearInputs(){
        driver.findElement(By.xpath("//*[@id='user-name']")).clear();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
    }
    @When("I click on the login button")
    public void clickOnLoginButton(){
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }
    @When("I leave the password field empty")
    public void passFieldEmpty(){

    }
    @Then("I should see {string} message")
    public void message(String expectedMessage){
        String errorMessage = driver.findElement(By.cssSelector(".error-message-container")).getText();
        assertThat(errorMessage, containsString(expectedMessage));
    }
    @Then("I should see the dashboard page with title {string}")
    public void dashboardPage(String expectedTitle){
        String pageTitle = driver.getTitle();
        assertThat(pageTitle, containsString(expectedTitle));
    }
}
