package de.adesso.bdd.shoppinglist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import de.adesso.bdd.shoppinglist.ShoppingList;

public class DeShoppingListRemove {

	private ShoppingList list;

	@Given("eine Einkaufsliste mit 3 Eintraegen inklusive \"Milch kaufen\"")
	public void givenEineEinkaufslisteMit3EintraegenInklusiveMilchKaufen() {
		this.list = new ShoppingList();
		this.list.add("Wurst kaufen");
		this.list.add("Milch kaufen");
		this.list.add("Brot kaufen");
	}

	@When("ich \"Milch kaufen\" von der Liste lösche")
	public void whenIchMilchKaufenVonDerListeLoesche() {
		this.list.remove("Milch kaufen");
	}

	@Then("enthält die Liste nur noch 2 Einträge und nicht mehr \"Milch kaufen\"")
	public void thenEnthaeltDieListeNurNoch2EintraegeUndNichtMehrMilchKaufen() {
		assertThat(this.list.size(), is(2));
		assertThat(this.list.contains("Buy milk"), is(false));
	}
}
