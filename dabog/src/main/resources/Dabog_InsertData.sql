--User mock data
insert into "User" ("id","email")  values ('aa2daf27-7bf8-4b1c-ad3e-5f6873a8351a','mark@gmail.com');
insert into "User" ("id","email")  values ('65f49bfd-b2e5-424f-baec-48d27e2d9492','sam@gmail.com');
insert into "User" ("id","email")  values ('8cab1389-e857-47f7-b037-dc711e5cfb80','john@gmail.com');
insert into "User" ("id","email")  values ('aa8983dd-52cf-4c21-b238-66ab585a3e39','stella@gmail.com');
insert into "User" ("id","email")  values ('e107158d-5730-4f68-8f5b-27485f1b4586','chloe@gmail.com');

--Card mock data
insert into "Card" ("userId", "cardType", "cardBinNumber", "lastFourDigits") 
values ('aa2daf27-7bf8-4b1c-ad3e-5f6873a8351a', 'Mastercard', '521978', '9523');
insert into "Card" ("userId", "cardType", "cardBinNumber", "lastFourDigits") 
values ('65f49bfd-b2e5-424f-baec-48d27e2d9492', 'Visa', '449059', '1660');
insert into "Card" ("userId", "cardType", "cardBinNumber", "lastFourDigits")
values ('8cab1389-e857-47f7-b037-dc711e5cfb80', 'Mastercard', '514266', '3859');
insert into "Card" ("userId", "cardType", "cardBinNumber", "lastFourDigits")
values ('aa8983dd-52cf-4c21-b238-66ab585a3e39', 'Visa', '431921', '5939');
insert into "Card" ("userId", "cardType", "cardBinNumber", "lastFourDigits")
values ('e107158d-5730-4f68-8f5b-27485f1b4586', 'Mastercard', '555819', '0190');