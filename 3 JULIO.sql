select * from customers
select * from orders
select * from categories
select * from products

select C.firstname, O.totalamount from
(
	select firstname, age, customerid from customers where age between '18' and '28' INTERSECT 
	select  firstname, age, customerid  from customers where state = 'NY' or state ='SD'
)C 
join orders O 
on C.customerid = O.customerid



Select P.title, C.categoryname from
(
	select * from products where category = 7 or category = 8 or category = 10 or category = 11 or category = 12 union
	select * from products where price between '15.00' and '25.99' union
	select * from products where actor ='SCARLETT BASINGER' 
)P
join categories C
on P.category = C.category
