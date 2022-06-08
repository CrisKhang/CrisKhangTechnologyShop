use master
create database J5Shop
use J5Shop
create table Accounts(
	Username nvarchar(50),
	Password nvarchar(50),
	Fullname nvarchar(50),
	Email nvarchar(50),
	Photo nvarchar(50),
	Activated bit,
	Admin bit,
	Primary key(Username)
)

create table Categories(
	category_Id char(4),
	category_Name nvarchar(50),
	Primary key(category_Id)
)

create table Products(
	product_Id int identity(1,1),
	Name nvarchar(50),
	Image nvarchar(50),
	Price float,
	Create_Date date,
	Available bit,
	category_Id char(4),
	Primary key(product_Id),
	constraint fk_Products_CategoryId
	foreign key(category_Id) references Categories(category_Id)
)

create table Orders(
	order_Id bigint identity(1,1),
	Username nvarchar(50),
	Create_Date date,
	Address nvarchar(100),
	Primary key (order_Id),
	constraint fk_Orders_Username
	foreign key (Username) references Accounts(Username)
)

create table Order_Details(
	order_Detail_Id bigint identity(1,1),
	order_Id bigint,
	product_Id int,
	Price float,
	Quantity int,
	Primary key (order_Detail_Id),
	constraint fk_OrderDetails_orderId
	foreign key (order_Id) references Orders(order_Id),
	constraint fk_OrderDetails_productId
	foreign key (product_Id) references Products(product_Id)
)

insert into Accounts
VALUES('admin','admin','Admin','admin@gmail.com','admin.png',0,0),
	  ('tienthinh15048','123456','Do Tien Thinh','thinhdtps15048@fpt.edu.vn','user.png',0,1)

insert into Categories
Values('NOOD','Noodle'),
	  ('SMPH','Smart phone'),
	  ('PC','Computer'),
	  ('LAP','Laptop')

insert into Products(Name,Image,Price,Create_Date,Available,category_Id)
Values('Rog Strix','laptoprogstrix.png',1000,'04-26-2022',0,'LAP'),
	  ('iPhone13','iPhone13.png',900,'04-26-2022',0,'SMPH'),
	  ('HaoHao','HaoHao.png',20,'04-26-2022',0,'NOOD'),
	  ('PC200','PC200.png',1200,'04-26-2022',0,'PC')

insert into Orders(Username, Create_Date, Address)
values('admin','04-26-2022','Ho Chi Minh city'),
	  ('tienthinh15048','04-23-2022','Dong Nai'),
	  ('tienthinh15048','04-22-2022','Dong Nai')

select * from Products

insert into Order_Details(order_Id,product_Id, Price, Quantity)
values(1,3,2000,2),
	  (2,4,900,1),
	  (3,3,1000,1)

/*Insert more products*/

insert into Products(Name,Image,Price,Create_Date,Available,category_Id)
values('iPhone12','iPhone12.png',800,'02-26-2022',0,'SMPH'),
	  ('Gau do','gaudo.png',15,'03-26-2022',0,'NOOD'),
	  ('De Nhat','denhat.png',25,'01-26-2022',0,'NOOD'),
	  ('Lau Thai','lauthai.png',25,'04-26-2022',0,'NOOD'),
	  ('Omachi','omachi.png',30,'03-26-2022',0,'NOOD'),
	  ('iPhone10','iPhone10.png',700,'03-26-2022',0,'SMPH'),
	  ('Dell Latitude E5540','latitude5540.png',1500,'04-14-2022',0,'LAP'),
	  ('Acer nitro 5','acernitro5.png',1600,'04-21-2022',0,'LAP'),
	  ('PC core i3','pccorei3.png',800,'02-26-2022',0,'PC'),
	  ('PC core i5','pccorei5.png',1200,'04-01-2022',0,'PC'),
	  ('PC core i7','pcocrei7.png',1500,'04-06-2022',0,'PC')