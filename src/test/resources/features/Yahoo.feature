#Yahoo
Feature: Yahoo test
  I want to test yahoo emails

  Scenario: Send Yahoo email to Gmail user
    Given "Tom" is on "yahoo" page
    When he signs in as "yahoouser"
    Then he should see inbox with "Compose" mail button
    When he sends email
      | Recipient                | Subject      | Body        |
      | arora.sonali99@gmail.com | Subject| We will win |

  Scenario: Read Yahoo email
    Given "Tom" is on "yahoo" page
    When he signs in as "yahoouser"
    Then he should see inbox with "Compose" mail button
    And read yahoo email with subject "Unexpected sign-in attempt"
