### app.py

```python
from eng_team_accounts import Account
import Code Interpreter
import json
import getpass

def create_account():
    owner_name = input("Enter your account name: ")
    initial_balance = float(input("Enter the initial deposit amount: "))
    return Account(owner_name, initial_balance)

def main():
    user = create_account()
    while True:
        print("\n1. Deposit funds")
        print("2. Withdraw funds")
        print("3. Record transaction")
        print("4. Get portfolio and balance")
        print("5. List transactions")
        print("6. Exit")

        choice = input("Choose an option: ")

        if choice == "1":
            symbol = input("Enter the share symbol (AAPL, TSLA, GOOGL): ")
            amount = float(input("Enter the deposit amount: "))
            transaction = user.deposit(amount)
            print(transaction.get_portfolio())
            print(user.get_balance())
        elif choice == "2":
            symbol = input("Enter the share symbol (AAPL, TSLA, GOOGL): ")
            while True:
                try:
                    amount = float(input("Enter the withdraw amount: "))
                    if amount > user.initial_balance + sum(user.portfolio.values()):
                        print("Insufficient balance or cannot afford the transaction")
                    else:
                        user.withdraw(amount)
                        break
                except ValueError:
                    print("Invalid input. Please enter a valid amount.")
        elif choice == "3":
            symbol = input("Enter the share symbol (AAPL, TSLA, GOOGL): ")
            quantity = int(input("Enter the transaction quantity: "))
            price = get_share_price(symbol)
            user.record_transaction(symbol, quantity, price)
            print(user.get_portfolio())
            print(user.get_balance())
        elif choice == "4":
            print("Portfolio:", user.get_portfolio())
            print("Balance:", user.get_balance())
        elif choice == "5":
            print("Transactions:")
            print(user.list_transactions())
        elif choice == "6":
            break
        else:
            print("Invalid option. Please try again.")

if __name__ == "__main__":
    main()
```