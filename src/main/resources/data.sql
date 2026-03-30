CREATE TABLE Transaction (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL,
  merchant_id UUID NOT NULL,
  gateway VARCHAR NOT NULL,         -- e.g., 'stripe', 'paypal'
  method VARCHAR NOT NULL,          -- e.g., 'card', 'ideal'
  status VARCHAR NOT NULL,          -- 'pending', 'authorized', 'captured', 'refunded'
  amount_cents INTEGER NOT NULL,
  currency VARCHAR NOT NULL,
  description TEXT,
  metadata JSONB,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP
);


 `TransactionEvent`
Captures lifecycle events: authorization, capture, refund.
```sql
CREATE TABLE TransactionEvent (
  id UUID PRIMARY KEY,
  transaction_id UUID REFERENCES Transaction(id),
  event_type VARCHAR NOT NULL,      -- 'authorization', 'capture', 'refund'
  gateway_event_id VARCHAR,
  amount_cents INTEGER,
  timestamp TIMESTAMP NOT NULL,
  metadata JSONB
);



`User`
```sql
CREATE TABLE User (
  id UUID PRIMARY KEY,
  email VARCHAR NOT NULL,
  phone VARCHAR,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  balance_cents INTEGER DEFAULT 0
);
```


 `Merchant`
```sql
CREATE TABLE Merchant (
  id UUID PRIMARY KEY,
  name VARCHAR NOT NULL,
  email VARCHAR,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  balance_cents INTEGER DEFAULT 0
);



### 5. `PaymentMethod`
```sql
CREATE TABLE PaymentMethod (
  id UUID PRIMARY KEY,
  user_id UUID REFERENCES User(id),
  method_type VARCHAR NOT NULL,     -- 'card', 'bank_account'
  details JSONB NOT NULL,           -- encrypted or tokenized
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


## 📜 **Audit & Logging**

### 6. `TransactionLog`
```sql
CREATE TABLE TransactionLog (
  id UUID PRIMARY KEY,
  transaction_id UUID REFERENCES Transaction(id),
  event VARCHAR NOT NULL,           -- 'initiated', 'authorized', 'captured', 'refunded'
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  metadata JSONB
);


## 🔄 **Relationships & Lifecycle**

- One `User` → many `Transactions`
- One `Merchant` → many `Transactions`
- One `Transaction` → many `TransactionEvents` and `TransactionLogs`
- One `User` → many `PaymentMethods`

