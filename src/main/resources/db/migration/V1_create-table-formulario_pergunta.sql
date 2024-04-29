CREATE TABLE    Formulario_pergunta (
                id_formulario INT,
                id_pergunta INT,
                PRIMARY KEY (id_formulario, id_pergunta),
                FOREIGN KEY (id_formulario) REFERENCES Formulario(id_formulario),
                FOREIGN KEY (id_pergunta) REFERENCES Pergunta(id_pergunta)
                )