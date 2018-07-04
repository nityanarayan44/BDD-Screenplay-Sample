#Yahoo
Feature: Yahoo test
  I want to use this template for my feature file

  @test
  Scenario: Yahoo login
    Given "Tom" is on "yahoo" page
    When he signs in as "yahoouser"
    Then he should see inbox with "Compose" mail button

