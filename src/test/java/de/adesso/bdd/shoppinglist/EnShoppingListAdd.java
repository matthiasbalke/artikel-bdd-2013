package de.adesso.bdd.shoppinglist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import de.adesso.bdd.shoppinglist.ShoppingList;

public class EnShoppingListAdd {

	private ShoppingList list;

	@Given("an empty shopping list")
	public void givenAnEmptyShoppingList() {
		this.list = new ShoppingList();
	}

	@When("I add \"Buy milk\" to the list")
	public void whenIAddBuyMilkToTheList() {
		this.list.add("Buy Milk");
	}

	@Then("the list contains 1 item with the description \"Buy milk\"")
	public void thenTheListContains1ItemWithTheDescriptionBuyMilk() {
		assertThat(this.list.size(), is(1));
		assertThat(this.list.contains("Buy Milk"), is(true));
	}
}
