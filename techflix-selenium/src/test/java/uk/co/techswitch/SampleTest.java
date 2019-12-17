package uk.co.techswitch;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {

    @Test
    public void testTechFlixHomepage() {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://localhost:3000/");

        WebElement heroImage = browser.findElement(By.xpath("//*[@data-testId='hero-image']"));
        WebElement heroTitle = browser.findElement(By.xpath("//*[@data-testId='hero-title']"));
        WebElement filmList = browser.findElement(By.xpath("//*[@data-testId='card-grid-list']"));

        System.out.println(filmList.toString());

        assertThat(heroImage).isNotNull();
        assertThat(heroTitle).isNotNull();

        assertTrue(filmList.findElements(By.tagName("li")).size() > 1);
    }

    @Test
    public void testUserStory(){
        WebDriver browser = new FirefoxDriver();
        browser.get("http://localhost:3000/");
        WebElement searchElement = browser.findElement(By.xpath("//*[@data-searchFormId='search-form']"));
        searchElement.sendKeys("Liam Neeson \n");
        searchElement.submit();

    }



}
