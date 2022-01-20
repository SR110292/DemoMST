Feature: BuyProducts 

Scenario Outline: Validation of buying multiple least expensive products successfully 
	Given I verify the Current temperature is displayed with values 
	And I click on the buy button (moisturizers or sunscreens) based on the temperature
	And I verify the corresponding product header displayed in the next page 
	And I add the least expensive product that contains (aloe & almond) or (spf-30 & spf-50) based on the product page
	When I click on Cart Items button 
	Then I verify the corresponding Checkout header displayed in the next page 
	And I verify the two selected items and their prices are displayed 
	And I also validate the total price is displayed as expected 
	When I click on Pay with Card button 
	Then the payment window should be displayed 
	And I get the test card number from seperate window 
	And I enter the test data in the Email, Card number, Expiry, CVC and Zip code fields 
	And I validate the same total price is displayed in the Pay button as well 
	When I click on Pay button 
	Then the payment window should be closed automatically after few seconds 
	And I validate the successful confirmation page with the data from given sheetName "<SheetName>" and <RowNumber> 
	
	Examples: 
		|SheetName|RowNumber|	
		|data|0|