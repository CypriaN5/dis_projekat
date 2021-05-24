CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists "User" cascade;
drop table if exists "Card" cascade;
drop table if exists "PaymentTransaction" cascade;

create table "User" (
id uuid primary key default uuid_generate_v4(),
email varchar(250) not null,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
);

create table "Card" (
id uuid primary key default uuid_generate_v4(),
"userId" uuid references "User" (id) not null,
"cardType" varchar(250) not null,
"cardBinNumber" varchar(250) not null,
"lastFourDigits" varchar(250) not null,
"isDeleted" boolean default false,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
)

create table "PaymentTransaction" (
id uuid primary key default uuid_generate_v4(),
"userId" uuid references "User" (id) not null,
"cardId" uuid references "Card" (id) not null,
"paymentRefId" varchar(250) not null,
"amount" integer not null,
"currency" varchar(10) not null,
"invoiceData" jsonb not null,
"createdAt" timestamp not null default now(),
"updatedAt" timestamp not null default now()
)
