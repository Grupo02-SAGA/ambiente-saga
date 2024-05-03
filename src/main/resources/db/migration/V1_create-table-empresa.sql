CREATE TABLE empresa (
    id_empresa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fantasia VARCHAR(45) NOT NULL,
    razao_social VARCHAR(45) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    email VARCHAR(45) NOT NULL,
    endereco VARCHAR(150),
    telefone VARCHAR(20),
    porte VARCHAR(25),
    atividade VARCHAR(30) NOT NULL,
    estado boolean DEFAULT true
)