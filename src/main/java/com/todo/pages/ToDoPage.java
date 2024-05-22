package com.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ToDoPage{
 public static WebDriver driver;
    public ToDoPage(WebDriver driver) {
        ToDoPage.driver = driver;
    }

    WebElement addToDo= driver.findElement(By.xpath("//input[@class='new-todo']"));
    List<WebElement> toDoList= driver.findElements(By.cssSelector(".todo-list li"));



    public void addTodoItem(String item) {
        addToDo.sendKeys(item + "\n");
    }
    public List<WebElement> getTodoItems() {
        return toDoList;
    }

    public void markTaskAsCompleted(int index) {
        List<WebElement> tasks = getTodoItems();
        tasks.get(index).findElement(By.cssSelector(".toggle")).click();
    }

    public void deleteTask(int index) {
        List<WebElement> tasks = getTodoItems();
        tasks.get(index).findElement(By.cssSelector(".destroy")).click();
    }

    public void filterTasks(String filter) {
        driver.findElement(By.linkText(filter)).click();
    }
}