CREATE TABLE Resposta (
    id_resposta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resposta VARCHAR(10) NOT NULL,
    observacao VARCHAR(500),
    id_usuario INT NOT NULL,
    id_pergunta INT NOT NULL,
    id_formulario INT NOT NULL,
    id_certificado INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_pergunta) REFERENCES Pergunta(id_pergunta),
    FOREIGN KEY (id_formulario) REFERENCES Formulario(id_formulario),
    FOREIGN KEY (id_certificado) REFERENCES Certificado(id_certificado)
)