CREATE TABLE Pergunta (
    id_pergunta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255),
     documento BOOLEAN NOT NULL,
     estado boolean DEFAULT true,
    id_formulario INT NOT NULL,
    FOREIGN KEY (id_formulario) REFERENCES Formulario(id_formulario)
)