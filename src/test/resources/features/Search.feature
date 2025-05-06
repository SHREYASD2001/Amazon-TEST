@search
Feature: Check Search Feature

  @test @abcg
  Scenario: Search Any Iphone in Amazon
    Given User searches "iPhone 16 Pro Max" in Amazon Portal
    And User selects and adds the random phone in Cart
    And User removes the phone from cart
    And User validates the price of product

  @test
  Scenario: Search Any Galaxy in Amazon
    Given User searches "Samsung Galaxy S24 Ultra" in Amazon Portal
    And User selects and adds the random phone in Cart
    And User removes the phone from cart
    And User validates the price of product

