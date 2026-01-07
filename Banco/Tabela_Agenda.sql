CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contato(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nome TEXT NOT NULL,
telefone TEXT NOT NULL,
endereco TEXT NOT NULL,
complemento TEXT,
cidade TEXT NOT NULL,
estado TEXT NOT NULL
);

INSERT INTO contato (nome, telefone, endereco, complemento, cidade, estado) VALUES (
"Murilo", "1199738008", "Rua Alface, 194", "", "Jandira", "SP"
);
INSERT INTO contato (nome, telefone, endereco, complemento, cidade, estado) VALUES (
"João", "11988563007", "Rua Visconde, 154", "casa 2", "Barueri", "SP"
);
INSERT INTO contato (nome, telefone, endereco, complemento, cidade, estado) VALUES (
"Pedro", "11975864218", "Rua Virgilho, 189", "", "Osasco", "SP"
);
INSERT INTO contato (nome, telefone, endereco, complemento, cidade, estado) VALUES (
"Matheus", "11988526110", "Avenida Alergia, 1008", "Prédio 1, casa 5", "Itapevi", "SP"
);

SELECT * FROM contato;
#DELETE FROM contato WHERE id = 3;
#DROP TABLE contato;
#DROP DATABASE agenda;
