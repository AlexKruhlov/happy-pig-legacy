INSERT INTO public.funds (id, name, start_date) VALUES ('GROCERY_FUND', 'Grocery', '2019-01-09 06:28:46.870217');
INSERT INTO public.funds (id, name, start_date) VALUES ('RENTAL_FUND', 'Rental', '2019-01-09 06:28:46.870217');
INSERT INTO public.funds (id, name, start_date) VALUES ('DRESS_FUND', 'Dress', '2019-01-09 06:28:46.870217');

INSERT INTO public.products (id, name) VALUES ('POTATO', 'Potato');
INSERT INTO public.products (id, name) VALUES ('SALT', 'Salt');
INSERT INTO public.products (id, name) VALUES ('BALL', 'Ball');

INSERT INTO public.items (id, type, amount, date, fund_id, product_id) VALUES ('ITEM_0000001', 'INCOME', 100000, '2019-01-09 06:28:46.881589', 'GROCERY_FUND', 'POTATO');
INSERT INTO public.items (id, type, amount, date, fund_id, product_id) VALUES ('ITEM_0000002', 'EXPENSE', 50000, '2019-01-09 06:28:46.881589', 'GROCERY_FUND', 'BALL');
INSERT INTO public.items (id, type, amount, date, fund_id, product_id) VALUES ('ITEM_0000003', 'INCOME', 100000, '2019-01-09 06:28:46.881589', 'DRESS_FUND', 'SALT');
INSERT INTO public.items (id, type, amount, date, fund_id, product_id) VALUES ('ITEM_0000004', 'EXPENSE', 200000, '2019-01-09 06:28:46.881589', 'DRESS_FUND', 'POTATO');
INSERT INTO public.items (id, type, amount, date, fund_id, product_id) VALUES ('ITEM_0000005', 'INCOME', 100000, '2019-01-09 06:28:46.881589', 'DRESS_FUND', 'BALL');
INSERT INTO public.items (id, type, amount, date, fund_id, product_id) VALUES ('ITEM_0000006', 'EXPENSE', 80000, '2019-01-09 06:28:46.881589', 'RENTAL_FUND', 'SALT');
