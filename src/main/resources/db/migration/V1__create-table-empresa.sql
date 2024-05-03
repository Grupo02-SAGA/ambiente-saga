CREATE TABLE empresa (
    id_empresa INT AUTO_INCREMENT PRIMARY KEY UNIQUE NOT NULL,
    fantasia VARCHAR(45),
    razao_social VARCHAR(45),
    cnpj VARCHAR(14),
    email VARCHAR(45),
    endereco VARCHAR(150),
    telefone VARCHAR(20),
    porte VARCHAR(20),
    atividade VARCHAR(30),
    estado BOOLEAN
)