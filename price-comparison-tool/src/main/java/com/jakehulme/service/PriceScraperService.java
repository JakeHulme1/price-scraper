package com.jakehulme.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Service class for scraping prices from e-commerce websites.
 * 
 * This class uses both Jsoup and Selenium to handle different types of web
 * pages:
 * - Jsoup is used for scraping static content.
 * - Selenium is used for scraping dynamic content that requires JavaScript
 * execution.
 */
@Service // the @Service annotation is used to indicate that this class contains the
         // business logic for scraping prices
public class PriceScraperService {

    /**
     * Scrapes the price of a product from a given URL using Jsoup.
     *
     * @param url the URL of the product page
     * @return the price of the product as a String
     * @throws IOException if an I/O error occurs
     */
    public String scrapePriceWithJsoup(String url) throws IOException {
        // Connect to the URL and parse the HTML document
        Document doc = Jsoup.connect(url).get();
        // Select the element containing the price and return its text
        return doc.select(".price").text();
    }

    /**
     * Scrapes the price of a product from a given URL using Selenium.
     *
     * @param url the URL of the product page
     * @return the price of the product as a String
     */
    public String scrapePriceWithSelenium(String url) {
        // Selenium is used for dynamic content that requires JavaScript execution to
        // display the price.
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement priceElement = driver.findElement(By.className("price"));
        String price = priceElement.getText();
        driver.quit();
        return price;
    }
}