--AppUser mock data
insert into "AppUser" ("id", "email", "firstName", "lastName") 
values ('964f5532-e63c-441b-8289-322d9a0f1cb6', 'niksa@gmail.com', 'Niksa', 'Kovacevic');
insert into "AppUser" ("id", "email", "firstName", "lastName") 
values ('aa2daf27-7bf8-4b1c-ad3e-5f6873a8351a', 'mark@gmail.com', 'Mark', 'Mitchell');
insert into "AppUser" ("id", "email", "firstName", "lastName") 
values ('65f49bfd-b2e5-424f-baec-48d27e2d9492', 'sam@gmail.com', 'Samuel', 'Web');
insert into "AppUser" ("id", "email", "firstName", "lastName") 
values ('8cab1389-e857-47f7-b037-dc711e5cfb80', 'john@gmail.com', 'John', 'Scott');
insert into "AppUser" ("id", "email", "firstName", "lastName") 
values ('aa8983dd-52cf-4c21-b238-66ab585a3e39', 'stella@gmail.com', 'Stella', 'Jones');
insert into "AppUser" ("id", "email", "firstName", "lastName") 
values ('e107158d-5730-4f68-8f5b-27485f1b4586', 'chloe@gmail.com', 'Chloe', 'Scully');

--Store mock data
insert into "Store" (id, "simpleStoreId", "storeName", "storeInfo") 
values ('00000000-0000-0000-0000-000000001001', 1001, 'Bilka Tilst', '{
    "zip": "8381",
    "city": "Tilst",
    "address": "Powell Ave 2",
    "country": "USA"
}');
insert into "Store" (id, "simpleStoreId", "storeName", "storeInfo") 
values ('00000000-0000-0000-0000-000000001002', 1002, 'Bilka Randers', '{
    "zip": "5276",
    "city": "Randers",
    "address": "St. Jones 7",
    "country": "USA"
}');
insert into "Store" (id, "simpleStoreId", "storeName", "storeInfo") 
values ('00000000-0000-0000-0000-000000001003', 1003, 'Bilka Marakesh', '{
    "zip": "3968",
    "city": "Marakesh",
    "address": "Selman walk 10",
    "country": "USA"
}');
insert into "Store" (id, "simpleStoreId", "storeName", "storeInfo") 
values ('00000000-0000-0000-0000-000000001004', 1004, 'Bilka Capetown', '{
    "zip": "4415",
    "city": "Capetown",
    "address": "Spring plaza",
    "country": "USA"
}');

--Basket mock data
insert into "Basket" ("appUserId", "items", "paymentRefId", "storeId", "totalPrice") 
values ('964f5532-e63c-441b-8289-322d9a0f1cb6', '[
    {
        "ean13": "7322541027685",
        "itemName": "Ananas",
        "quantity": 2,
        "unitPrice": 120,
        "totalPrice": 240
    },
	{
        "ean13": "4000980423307",
        "itemName": "Heinz ketchup",
        "quantity": 1,
        "unitPrice": 250,
        "totalPrice": 250
    }
]',
'BID000000109', 1002, 490);
insert into "Basket" ("appUserId", "items", "paymentRefId", "storeId", "totalPrice") 
values ('aa2daf27-7bf8-4b1c-ad3e-5f6873a8351a', '[
    {
        "ean13": "8410762872081",
        "itemName": "Yogurt",
        "quantity": 3,
        "unitPrice": 100,
        "totalPrice": 300
    },
	{
        "ean13": "5712870653167",
        "itemName": "Coca Cola",
        "quantity": 1,
        "unitPrice": 160,
        "totalPrice": 160
    }
]',
'BID000000115', 1003, 460);
insert into "Basket" ("appUserId", "items", "paymentRefId", "storeId", "totalPrice") 
values ('e107158d-5730-4f68-8f5b-27485f1b4586', '[
    {
        "ean13": "7311310027070",
        "itemName": "Milk",
        "quantity": 1,
        "unitPrice": 145,
        "totalPrice": 145
    },
	{
        "ean13": "5712870653167",
        "itemName": "Coca Cola",
        "quantity": 1,
        "unitPrice": 160,
        "totalPrice": 160
    }
]',
'BID000000219', 1004, 305);