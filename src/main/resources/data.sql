--INSERT INTO etiquetas(id, nombre, creador, createdat) VALUES (1, "php", "", "2020/1/1");
--INSERT INTO etiquetas(id, nombre, creador, createdat) VALUES (2, "java", "", "2020/1/1");
--INSERT INTO etiquetas(id, nombre, creador, createdat) VALUES (3, "kotlin", "", "2020/1/1");
--
--INSERT INTO expertos(id, nombre, telefono, email, modalidad, estado) VALUES (1, "antonio", "666 111 111", "antonio@gmail.com", "online", "pendiente");
--INSERT INTO expertos(id, nombre, telefono, email, modalidad, estado) VALUES (2, "jose", "666 222 222", "jose@gmail.com", "presencial", "verificado");
--INSERT INTO expertos(id, nombre, telefono, email, modalidad, estado) VALUES (3, "alberto", "666 333 333", "alberto@gmail.com", "online", "verificado");
--
--INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (1, 1);
--INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (1, 2);
--INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (2, 1);
--INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (2, 2);
--INSERT INTO experto_etiqueta(experto_id, etiqueta_id) VALUES (2, 3);

INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo) VALUES (1, "23984238947", "Corriente", 0);
INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo) VALUES (2, "65165778947", "Pensiones", 1000);
INSERT INTO cuentas(id, numero_cuenta, tipo_cuenta, saldo) VALUES (3, "16116515947", "Pensiones", 2000);

INSERT INTO users(id, username, email, direccion, telefono) VALUES (1, "rafa", "rafa@email.com", "Calle Falsa 123 Malaga", "654123987");
INSERT INTO users(id, username, email, direccion, telefono) VALUES (2, "andres", "andres@email.com", "Calle Loquesea 268 Malaga", "665165187");

INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (1, 1);
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (1, 2);
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (2, 2);
INSERT INTO cuentas_users(cuenta_id, user_id) VALUES (3, 2);