--Vendor mock data
insert into "Vendor" (id, "simpleVendorId", "VendorName", "vendorInfo", "representativeInfo")
values ('00000000-0000-0000-0000-000000005001', 5001, 'Test Vendor', '{
    "zip": "7752",
    "city": "Aarhus",
    "address": "Bronby 7",
    "country": "Denmark"
}', 
	'{
    "phoneNo": "+38169788707",
    "lastName": "Kovacevic",
    "firstName": "Niksa"
}'  );

insert into "Vendor" (id, "simpleVendorId", "vendorName", "vendorInfo", "representativeInfo")
values ('00000000-0000-0000-0000-000000005002', 5002, 'Pepsico', '{
    "zip": "21000",
    "city": "Novi Sad",
    "address": "Ustanička",
    "country": "Serbia"
}', 
	'{
    "phoneNo": "+381694368819",
    "lastName": "Markovic",
    "firstName": "Ivan"
}'  );

--Site mock data
insert into "Site"
values ('00000000-0000-0000-0000-000000001001', 1001, 'Tilst', '8381', 'Powell Ave', '2', 500, 'm2');
insert into "Site"
values ('00000000-0000-0000-0000-000000001002', 1002, 'Randers', '5276', 'St. Jones', '7', 700, 'm2');
insert into "Site"
values ('00000000-0000-0000-0000-000000001003', 1003, 'Marakesh', '3968', 'Selman Walk', '10', 350, 'm2');
insert into "Site"
values ('00000000-0000-0000-0000-000000001004', 1004, 'Capetown', '4415', 'Spring plaza', null, 280, 'm2');

--Item mock data
insert into "Item" ("vendor", "ean13", "itemName", "unitPrice")
values('Pepsico', '7322541027685', 'Ananas', 120);

insert into "Item" ("vendor", "ean13", "itemName", "unitPrice")
values('Chipita', '4000980423307', 'Heinz ketchup', 250);

insert into "Item" ("vendor", "ean13", "itemName", "unitPrice")
values('Pepsico', '8410762872081', 'Yogurt', 100);

insert into "Item" ("vendor", "ean13", "itemName", "unitPrice")
values('Pepsico', '7322541027685', 'Coca cola', 160);

insert into "Item" ("vendor", "ean13", "itemName", "unitPrice")
values('Chipita', '7322541027685', 'Milk', 145);

