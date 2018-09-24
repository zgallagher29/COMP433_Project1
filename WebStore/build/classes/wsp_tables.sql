CREATE TABLE Customer (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE Seller (
    ID int NOT NULL,
    Name varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE Product (
    ID int NOT NULL,
    Category varchar(255) NOT NULL,
    Name varchar(255) NOT NULL,
    Quantity int NOT NULL,
    SellerId int NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (SellerId) REFERENCES Seller(ID)
);

CREATE TABLE Orders (
    ID int NOT NULL,
    OrderDate DATETIME NOT NULL,
    CustomerId int NOT NULL,
    FOREIGN KEY (CustomerId) REFERENCES Customer(ID),
    ProductId int NOT NULL,
    FOREIGN KEY (ProductId) REFERENCES Product(ID),
    SellerId int NOT NULL,
    FOREIGN KEY (SellerId) REFERENCES Seller(ID),
    PRIMARY KEY (ID)
);

create table Address (
    ID int NOT NULL,
    Street varchar(255) NOT NULL,
    StreetTwo varchar(255) NULL,
    City varchar(255) NOT NULL,
    State varchar(255) NOT NULL,
    Zip int NOT NULL,
    Country varchar(255) NOT NULL,
    CustomerId int NOT NULL,
    FOREIGN KEY (CustomerId) REFERENCES Customer(ID)
);

create table BillingInformation (
    ID int NOT NULL,
    CustomerId int NOT NULL,
    FOREIGN KEY (CustomerId) REFERENCES Customer(ID),
    CreditCardNumber int NOT NULL,
    SecurityCode int NOT NULL,
    NameOnCard varchar(255) NOT NULL,
    ExpirationDate Date NOT NULL
);
