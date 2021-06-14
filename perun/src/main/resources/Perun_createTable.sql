CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop sequence if exists paymentrefid;

drop table if exists "AppUser" cascade;
drop table if exists "Basket" cascade;
drop table if exists "Transactions" cascade;
drop table if exists "Store" cascade;

create sequence paymentrefid
increment by 1
start with 100000;

create table "AppUser" (
id uuid primary key default uuid_generate_v4(),
email varchar(250) unique not null,
"firstName" varchar(200) not null,
"lastName" varchar(200) not null,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
);

create table "Basket" (
id uuid primary key default uuid_generate_v4(),
"appUserId" uuid references "AppUser" (id) not null,
closed boolean not null default false,
items jsonb not null,
errors jsonb,
"paymentRefId" varchar(250) not null,
"storeId" integer not null references "Store" ("simpleStoreId"),
"totalPrice" integer not null,
"receiptNumber" varchar(250),
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
);

create table "Transactions" (
id uuid primary key default uuid_generate_v4(),
"BasketId" uuid references "Basket" (id) not null,
"storeId" integer not null references "Store" ("simpleStoreId"),
"sentJson" jsonb not null,
"statusCode" varchar(250) not null,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
);

create table "Store" (
id uuid primary key default uuid_generate_v4(),
"simpleStoreId" integer unique not null,
"storeName" varchar(250) unique not null,
"storeInfo" jsonb not null,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now(),
"isDeleted" boolean default false
);