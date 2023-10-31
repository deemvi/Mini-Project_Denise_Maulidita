package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Products.CreateNewProducts;
import starter.Products.DeleteProductByID;


public class DeleteProductByIDSteps {
    @Steps
    DeleteProductByID deleteProductByID;

    @Given("I set API endpoint for delete product By valid ID")
    public void setAPIForDeleteProductByID(){
        deleteProductByID.setAPIForDeleteProductByID();
    }
    @When("I send a request to delete the product with the valid ID")
    public void sendDeleteRequestForDeleteProductByID(){
        deleteProductByID.sendDeleteRequestForDeleteProductByID();
    }

    @Then("I received a message indicating that the product was successfully removed")
    public void receiveSuccessfullyMessage(){
        deleteProductByID.receiveSuccessfullyMessage();
    }



    @Given("I set API endpoint for delete product By invalid ID")
    public void setInvalidAPIForDeleteProductByID(){
        deleteProductByID.setInvalidAPIForDeleteProductByID();
    }
    @When("I send a request to delete the product with the invalid ID")
    public void sendDeleteRequestInvalidForDeleteProductByID(){
        deleteProductByID.sendDeleteRequestInvalidForDeleteProductByID();
    }



}
