SELECT * FROM paradigmasClinica.pesajes; -- SELECCION

INSERT INTO pesajes VALUES(123,"Marcelo",75,1.74); -- ALTA
INSERT INTO pesajes VALUES(456,"Pepe",75,1.74); -- ALTA

DELETE FROM pesajes WHERE pesajes.dni = 123; -- BAJA


UPDATE pesajes SET nombre="Jose" WHERE  pesajes.dni = 456; -- ACTUALIZACION
