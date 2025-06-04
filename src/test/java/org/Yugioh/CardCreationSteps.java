package org.Yugioh;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertEquals;

public class CardCreationSteps {

    private boolean hasPermission;
    private int atk;
    private int def;
    private int level;
    private String resultMessage;


    @Given("{string} opens card creation screen")
    public void opensCardCreationScreen(String hasPerm) {
        this.hasPermission = hasPerm.equals("1");
    }

    @When("enters into atk {string}")
    public void entersIntoAtk(String atk) {
        try {
            this.atk = Integer.parseInt(atk);
        } catch (NumberFormatException e) {
            this.atk = -1;
        }
    }

    @And("enters into def {string}")
    public void entersIntoDef(String def) {
        try {
            this.def = Integer.parseInt(def);
        } catch (NumberFormatException e) {
            this.def = -1;
        }
    }

    @And("enters into level {string}")
    public void entersIntoLevel(String level) {
        try {
            this.level = Integer.parseInt(level);
        } catch (NumberFormatException e) {
            this.level = -1;
        }
    }

    @And("user clicks the create card button")
    public void userClicksTheCreateCardButton()  {
        if (!hasPermission) {
            resultMessage = "Permission denied";
        }else if (atk < 0) {
            resultMessage = "Invalid atk";
        }else if (def < 0) {
            resultMessage = "Invalid def";
        }else if (level > 13 || level <= 0) {
            resultMessage = "Invalid level";
        } else {
            resultMessage = "Card successfully created";
        }
    }

    @Then("user receives message {string}")
    public void userReceivesMessage(String expectedMessage) {
        assertEquals(expectedMessage, resultMessage);
    }



}
