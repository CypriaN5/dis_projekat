CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists "Vendor" cascade;
drop table if exists "Site" cascade;
drop table if exists "Item" cascade;

create table "Vendor" (
id uuid primary key default uuid_generate_v4(),
"simpleVendorId" integer not null,
"vendorName" varchar(250) unique not null,
"vendorInfo" jsonb not null,
"representativeInfo" jsonb not null,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
);

create table "Site" (
id uuid primary key default uuid_generate_v4(),
"simpleSiteId" integer not null,
"city" varchar(250) not null,
"postalCode" varchar(25) not null,
"streetName" varchar(250) not null,
"streetNumber" varchar(250),
"surfaceArea" integer,
"surfaceAreaUnit" varchar(10),
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
);

create table "Item" (
id uuid primary key default uuid_generate_v4(),
"vendor" varchar(250) references "Vendor" ("vendorName"),
"ean13" varchar(13) unique not null,
"itemName" varchar(250) not null,
"unitPrice" integer not null,
"discounted" boolean default false,
"discountAmount" integer,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
)