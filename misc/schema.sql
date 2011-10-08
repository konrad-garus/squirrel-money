create table expense (
	expense_id int primary key not null,
	category varchar,
	subcategory varchar,
	detail varchar,
	value numeric(8,2),
	date timestamp
);