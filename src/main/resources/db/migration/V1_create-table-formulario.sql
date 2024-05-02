CREATE TABLE Formulario(
    id_formulario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(45),
    base BOOLEAN,
    estado BOOLEAN DEFAULT true
)