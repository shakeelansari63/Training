# eng-team-accounts.py

## Classes

### Account
The `Account` class represents an individual account in the trading simulation platform. It encapsulates all the data and functionality related to the account.

#### Attributes

*   `id`: A unique identifier for the account.
*   `owner_name`: The name of the account owner.
*   `initial_balance`: The initial deposit amount.
*   `portfolio`: A dictionary mapping share symbols to their current prices.
*   `transactions`: A list of transactions (buy/sell) with quantities and timestamps.

#### Methods

*   `__init__(owner_name, initial_balance)`: Initializes an empty account with the given owner name and initial balance.
*   `deposit(amount)`: Deposits a specified amount into the account.
*   `withdraw(amount)`: Withdraws a specified amount from the account if sufficient funds are available.
*   `record_transaction(symbol, quantity, price)`: Records a transaction (buy/sell) with the given symbol, quantity, and price.
*   `get_portfolio()`: Retrieves the current portfolio holdings.
*   `get_balance()`: Retrieves the current account balance.

## Functions

### get_share_price(symbol)
The function `get_share_price` returns the current price of a share for a given symbol. It is used to fetch the prices from an external data source (e.g., a stock exchange API).

#### Test Implementation
```python
import unittest

class TestSharePrice(unittest.TestCase):
    def test AAPL_price(self):
        return 100.0

    def test TSLA_price(self):
        return 200.0

    def test GOOGL_price(self):
        return 300.0

if __name__ == '__main__':
    unittest.main()
```

### get_portfolio
The function `get_portfolio` retrieves the current portfolio holdings for a given account.

#### Test Implementation
```python
import json

def test_get_portfolio():
    # Create an account with initial balance of $100
    account = Account("John Doe", 100)
    
    # Record some transactions
    account.record_transaction("AAPL", 10, get_share_price("AAPL"))
    account.record_transaction("GOOGL", 20, get_share_price("GOOGL"))
    
    # Get the portfolio holdings
    portfolio = json.loads(account.get_portfolio())
    
    # Check if the prices are correct and there are no negative balances
    self.assertEqual(portfolio["AAPL"], 10.0)
    self.assertGreater(portfolio["GOOGL"], 0.0)
```

### get_balance
The function `get_balance` retrieves the current account balance.

#### Test Implementation
```python
import unittest

class TestGetBalance(unittest.TestCase):
    def test_get_balance(self):
        # Create an account with initial balance of $100
        account = Account("John Doe", 100)
        
        # Record some transactions
        account.record_transaction("AAPL", 10, get_share_price("AAPL"))
        account.record_transaction("GOOGL", 20, get_share_price("GOOGL"))
        
        # Get the balance
        balance = json.loads(account.get_balance())
        
        # Check if the price is correct and there are no negative balances
        self.assertEqual(balance["AAPL"], 10.0)
        self.assertGreater(balance["GOOGL"], 0.0)

if __name__ == '__main__':
    unittest.main()
```