import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {    //Создаем класс с тестом

    @Test // помечаем тестовый метод аннотацией @Test из фреймворка jUnit для того что бы наш метод был распознан как тест
    public void laptopIsPresentOnThePage() {
        WebDriver driver = new ChromeDriver(); //создаем объект ChromeDriver и сохраняем его в переменную. В этот момент будет открыт браузер.
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //используем НЕЯВНЫЕ ожидания в настройке WebDriver. Использован только для примера.
        driver.get("https://rozetka.com.ua"); //открываем в браузере страницу Розетки
        WebElement menuItem = driver.findElement(By.id("2416")); //находим нужный пункт меню и сохраняем найденный элемент в переменную.
        menuItem.click(); // кликаем по найденному элементу
        new WebDriverWait(driver, 5) // создаем объект WebDriverWait дл использования ЯВНОГО ожидания элемента на странице.
                .until(ExpectedConditions.elementToBeClickable( // задаем условие ожидания элемента. В данном случае ждем, пока элемент станет кликабельным.
                        By.xpath("//a[@href='https://rozetka.com.ua/notebooks/c80004/filter/v004/']"))) //указываем локатор для нахождения искомого в условии ожидания элемента
                .click(); //когда условия ожидания будут достигнуты и елемент будет найден, мы по нему кликаем.
        driver.quit(); //по завершению нашего теста закрываем браузер и выключаем драйвер
    }
}
