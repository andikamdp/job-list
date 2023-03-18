# job-list

Java Developer Test
Please create below REST API using Java - SpringBoot framework:
1. Login API
    The API should validate username and password
    List of valid username and password should be stored on a DBMS
    Any DBMS is allowed
    It is recommended to use JPA as ORM to manage relational data in Java
   application
2. Get job list API
   The API should make http request to
   http://dev3.dansmultipro.co.id/api/recruitment/positions.json and return jobs data as
   response payload.
3. Get job detail API
   The API should make http request
   http://dev3.dansmultipro.co.id/api/recruitment/positions/{ID} and return job detail
   data as response payload.
4. Download job list API
   The API should make http request
   http://dev3.dansmultipro.co.id/api/recruitment/positions.json and return job list data
   as CSV file.




Structured Query Language (SQL)


Note:
UNN	:	Unique, Not Null PK	:		Primary Key
FK	:	Foreign Key NN	:	Not Null

Table description:
1.CUSTOMER: contains all bank customer data
The column CUST_GENDER is set to 1 for male and 2 for female.
2.ACCOUNT: contains all customer accounts

The column ACC_OWNER is the Foreign Key which refers to the column CUST_ID of the table CUSTOMER.
3.TRANSACTION: records all transactions.
The column TRS_TYPE contains the transaction type with possible values:
a.DB: for debit transaction.
b.CR: for credit transaction.
c.TF: for money transfer. The column TRS_FROM_ACCOUNT contains the source account.
4.TRANSACTION_TRANSFER: contains additional information if the transaction is money transfer.
The column TRS_STATUS contains one of the following values:
a.0: if transaction is not executed yet
b.1: if transaction is executed successfully
c.-1: if transaction is failed (e.g. the balance of source account (TRS_FROM_ACCOUNT) is not available)

Questions

Create SQL queries for the following requirements:
1.Recapitulation of number of accounts owned by every customer.
Answer:

Select CUST_ID, CUST_FIRSTNAME, COUNT_ACC_OWNER
From CUSTOMER
Join (
select ACC_OWNER , COUNT(ACC_OWNER)  AS COUNT_ACC_OWNER
from CUSTOMER
join ACCOUNT on CUST_ID = ACC_OWNER
group by ACC_OWNER
) count_acc on CUST_ID = ACC_OWNER


2.All transactions created by John Michael sorted by account number and transaction date
Answer:

select TRS_ID, TRS_FROM_ACCOUNT, TRS_AMOUNT, TRS_DATE, TRS_TYPE
from TRANSACTION
join ACCOUNT on TRS_FROM_ACCOUNT = ACC_NUMBER
join CUSTOMER on ACC_OWNER = CUST_ID
where CONCAT(CustomerName, ContactName) = ‘John Michael’;

