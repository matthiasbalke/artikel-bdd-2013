package de.adesso.bdd.shoppinglist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import de.adesso.bdd.shoppinglist.ShoppingList;

public class EnShoppingListRemove {

	private ShoppingList list;

	@Given("an shopping list with 3 items including \"Buy milk\"")
	public void givenAnShoppingListWith3ItemsIncludingBuyMilk() {
		this.list = new ShoppingList();
		this.list.add("Buy sausage");
		this.list.add("Buy milk");
		this.list.add("Buy cheese");
	}

	@When("I remove \"Buy milk\" from the list")
	public void whenIRemoveBuyMilkFromTheList() {
		this.list.remove("Buy milk");
	}

	@Then("the list contains 2 item and does not contain \"Buy milk\" anymore")
	public void thenTheShoppingListContains2ItemAndDoesNotContainBuyMilkAnymore() {
		assertThat(this.list.size(), is(2));
		assertThat(this.list.contains("Buy milk"), is(false));
	}
}
