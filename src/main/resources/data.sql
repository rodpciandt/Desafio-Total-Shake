INSERT INTO pedidos(DATA_HORA, STATUS) VALUES
('2022-10-25 08:10:00', 'REALIZADO'),
('2022-10-25 10:00:00', 'CONFIRMADO'),
('2022-10-24 18:15:00', 'PAGO'),
('2022-10-24 06:30:00', 'REALIZADO'),
('2022-10-22 11:10:00', 'REALIZADO');

INSERT INTO item_pedidos (QUANTIDADE, DESCRICAO, PEDIDO_ID) VALUES
(3, 'Sorvete de Banana', 1),
(3, 'Milkshake de Laranja', 1),
(2, 'Sorvete de Chocolate', 1),
(3, 'Milkshake de Ovomaltine', 2),
(1, 'Casquinha', 3),
(1, 'Água', 3),
(3, 'Sorvete de Abacate', 2),
(2, 'Sorvete de Banana', 2);
