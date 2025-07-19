-- Insertar clientes
INSERT INTO clientes (apellido, nombre, dni, mail, domicilio, cuit, empresa, activo) VALUES
('Gomez', 'Juan', '41383494', 'juangomez@gmail.com', 'Calle 1', '20-41383494-4', 'Tech SA', true);
INSERT INTO clientes (apellido, nombre, dni, mail, domicilio, cuit, empresa, activo) VALUES
('Lopez', 'Maria', '32456789', 'mlopez@yahoo.com', 'Calle 2', '27-32456789-5', 'Soluciones SRL', true);
INSERT INTO clientes (apellido, nombre, dni, mail, domicilio, cuit, empresa, activo) VALUES
('Rodriguez', 'Carlos', '30222444', 'carlos.r@gmail.com', 'Calle 3', '20-30222444-2', 'RodCar', true);
INSERT INTO clientes (apellido, nombre, dni, mail, domicilio, cuit, empresa, activo) VALUES
('Fernandez', 'Laura', '33455666', 'laura.f@hotmail.com', 'Calle 4', '27-33455666-8', 'Mercados SRL', true);
INSERT INTO clientes (apellido, nombre, dni, mail, domicilio, cuit, empresa, activo) VALUES
('Martinez', 'Diego', '30111222', 'diegomartinez@gmail.com', 'Calle 5', '20-30111222-1', 'DMTech', true);

-- Insertar productos
INSERT INTO productos (nombre, precio, stock, descripcion, activo) VALUES
('Perfume', 660.00, 7, 'Perfume fragancia fresca', true);
INSERT INTO productos (nombre, precio, stock, descripcion, activo) VALUES
('Shampoo', 350.00, 20, 'Shampoo anti caída', true);
INSERT INTO productos (nombre, precio, stock, descripcion, activo) VALUES
('Notebook', 120000.00, 5, 'Notebook HP 14', true);
INSERT INTO productos (nombre, precio, stock, descripcion, activo) VALUES
('Mouse Gamer', 4500.00, 10, 'Mouse con luces LED', true);
INSERT INTO productos (nombre, precio, stock, descripcion, activo) VALUES
('Cable HDMI', 900.00, 30, 'Cable de 2 metros', true);

-- Insertar pedidos (asumiendo cliente_id del 1 al 5)
INSERT INTO pedidos (cliente_id, monto, descuento, acuerdo_cliente, detalle_pedido) VALUES
(1, 15000.00, 0.00, true, 'Compra online #1');
INSERT INTO pedidos (cliente_id, monto, descuento, acuerdo_cliente, detalle_pedido) VALUES
(2, 18000.00, 0.00, false, 'Compra local #2');
INSERT INTO pedidos (cliente_id, monto, descuento, acuerdo_cliente, detalle_pedido) VALUES
(3, 25000.00, 0.00, true, 'Compra mayorista');
INSERT INTO pedidos (cliente_id, monto, descuento, acuerdo_cliente, detalle_pedido) VALUES
(4, 3000.00, 0.00, true, 'Prueba producto');
INSERT INTO pedidos (cliente_id, monto, descuento, acuerdo_cliente, detalle_pedido) VALUES
(5, 11000.00, 0.00, false, 'Pack escolar');

-- Insertar items del pedido
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(1, 1, 2);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(1, 2, 1);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(2, 4, 1);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(2, 2, 2);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(3, 3, 1);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(4, 5, 1);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(5, 2, 1);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(5, 4, 1);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(5, 5, 2);
INSERT INTO pedido_items (pedido_id, producto_id, cantidad) VALUES
(5, 3, 1);
