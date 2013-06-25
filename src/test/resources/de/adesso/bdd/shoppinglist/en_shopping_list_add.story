Add an item to the shopping list

Narrative:
In order to show the shopping list functionality
As a user
I want to add an item to the shopping list

Scenario: 
Given an empty shopping list
When I add "Buy milk" to the list
Then the list contains 1 item with the description "Buy milk"