package de.adesso.bdd.shoppinglist;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import de.adesso.bdd.shoppinglist.ShoppingList;

public class DeShoppingListAdd {

	private ShoppingList list;

	@Given("eine leere Einkaufsliste")
	public void givenEineLeereEinkaufsliste() {
		this.list = new ShoppingList();
	}

	@When("ich \"Milch kaufen\" zu der Liste hinzufüge")
	public void whenIchMilchKaufenZuDerListeHinzufuege() {
		this.list.add("Milch kaufen");
	}

	@Then("enthält die Liste 1 Eintrag mit der Beschreibung \"Milch kaufen\"")
	public void thenEnthaeltDieListe1EintragMitDerBeschreibungMilchKaufen() {
		assertThat(this.list.size(), is(1));
		assertThat(this.list.contains("Milch kaufen"), is(true));
	}

}
