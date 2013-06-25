Remove an item from the shopping list

Narrative:
In order to show the shopping list functionality
As a user
I want to remove an item from the shopping list

Scenario: 
Given an shopping list with 3 items including "Buy milk"
When I remove "Buy milk" from the list
Then the list contains 2 item and does not contain "Buy milk" anymore