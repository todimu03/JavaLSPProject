# CRC Cards

## CRC Card 1

**Class:** Order

**Responsibilities:**
- Store customer names, their email, the items selected and pre tax prices
- Provide access to order data (getters)
- Represent a single customer purchase

**Collaborators:**
- None

## CRC Card 2

**Class:** PricingService

**Responsibilities:**
- Calculate tax on a given price
- Apply applicable discounts (e.g., orders over $500)
- Return the final total price

**Collaborators:**
- Order


## CRC Card 3

**Class:** OrderRepository

**Responsibilities:**
- Keep order records to a file or other storage after program has shut down
- Handle I/O exceptions and report failures

**Collaborators:**
- Order

## CRC Card 4

**Class:** NotificationService

**Responsibilities:**
- Send a confirmation email to the customer
- Print a receipt to the console

**Collaborators:**
- Order


## CRC Card 5

**Class:** OrderProcessor

**Responsibilities:**
- Order processing workflow
- Make sure pricing is in PricingService 
- Make sure data in OrderRepository is persisted
- Put notification responsibility in NotificationService

**Collaborators:**
- Order
- PricingService
- OrderRepository
- NotificationService
