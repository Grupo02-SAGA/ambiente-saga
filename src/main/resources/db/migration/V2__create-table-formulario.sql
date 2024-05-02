CREATE TABLE formulario(
    id_formulario INT AUTO_INCREMENT PRIMARY KEY UNIQUE NOT NULL,
    titulo VARCHAR(45),
    base BOOLEAN,
    estado BOOLEAN
);

INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 1', TRUE, FALSE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 2', FALSE, TRUE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 3', TRUE, FALSE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 4', FALSE, TRUE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 5', TRUE, FALSE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 6', FALSE, TRUE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 7', TRUE, FALSE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 8', FALSE, TRUE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 9', TRUE, FALSE);
INSERT INTO formulario (titulo, base, estado) VALUES ('Formulário 10', FALSE, TRUE);