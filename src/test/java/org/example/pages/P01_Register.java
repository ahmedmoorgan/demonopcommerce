
package org.example.pages;

import net.bytebuddy.asm.Advice;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_Register {
    public WebElement registerLink (){
        return Hooks.driver.findElement(By.className("ico-register"));
    }
    public WebElement firstName (){
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement lastName (){
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public WebElement genderMale (){
        return Hooks.driver.findElement(By.id("gender-male"));
    }
   public WebElement dateOfBirthDay(){
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
   }
   public WebElement dateOfBirthMonth(){
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));

   }
    public WebElement dateOfBirthYear(){
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));

    }
  public WebElement email(){
        return Hooks.driver.findElement(By.id("Email"));
  }
  public WebElement password(){
        return Hooks.driver.findElement(By.id("Password"));
  }
  public WebElement confirmPassword(){
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
  }
  public WebElement registerClick(){
        return Hooks.driver.findElement(By.id("register-button"));
  }
  public WebElement successMessage(){
        return Hooks.driver.findElement(By.className("result"));
  }


}
