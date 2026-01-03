SELECT 
p.product_name  , s.year  , s.price
FROM Product p
inner join Sales s
ON s.product_id = p.product_id;