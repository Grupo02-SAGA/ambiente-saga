CREATE TABLE usuario (
                    id_usuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                    nome VARCHAR(45) NOT NULL,
                    sobrenome VARCHAR(45) NOT NULL,
                    cpf VARCHAR(11) UNIQUE NOT NULL,
                    email VARCHAR(45) NOT NULL,
                    cidade VARCHAR(45),
                    telefone VARCHAR(20) NOT NULL,
                    senha VARCHAR(45) NOT NULL,
                    estado BOOLEAN DEFAULT true
)