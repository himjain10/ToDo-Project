package com.todo.tests;

import com.todo.pages.ToDoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ToDoTest extends BaseTest

{
    private ToDoPage todoPage;
    @BeforeMethod
    public void setUpMethod() {
        todoPage = new ToDoPage(driver);
    }

    @Test
    public void testAddTask() {
        ToDoPage todoPage = new ToDoPage(driver);
        todoPage.addTodoItem("Himanshi Test Task 1");
        List<WebElement> tasks = todoPage.getTodoItems();
        assert tasks.size() == 1 : "Task was not added.";
    }
    @Test
    public void testCompleteTask() throws InterruptedException {
        ToDoPage todoPage = new ToDoPage(driver);
        todoPage.addTodoItem("Himanshi Test Task 2");
        Thread.sleep(1000);
        todoPage.markTaskAsCompleted(0);
        WebElement completedTask = todoPage.getTodoItems().get(0);
        assert completedTask.getAttribute("class").contains("completed") : "Task was not marked as completed.";
    }

    @Test
    public void testDeleteTask() {
        ToDoPage todoPage = new ToDoPage(driver);
        todoPage.addTodoItem(" Himanshi Test Task 3");
        todoPage.deleteTask(0);
        List<WebElement> tasks = todoPage.getTodoItems();
        assert tasks.size() == 0 : "Task was not deleted.";
    }

    @Test
    public void testFilterActiveTasks() {
        ToDoPage todoPage = new ToDoPage(driver);
        todoPage.addTodoItem("Test Task 4");
        todoPage.markTaskAsCompleted(0);
        todoPage.filterTasks("Active");
        List<WebElement> activeTasks = todoPage.getTodoItems();
        assert activeTasks.size() == 0 : "Active tasks are not displayed.";
    }



}