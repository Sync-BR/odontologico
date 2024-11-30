CREATE DATABASE IF NOT EXISTS odontologicodb;

USE odontologicodb;

CREATE TABLE IF NOT EXISTS clientes (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        cliente_name VARCHAR(255) NOT NULL,
    cliente_cpf VARCHAR(14) NOT NULL UNIQUE,
    cliente_date DATE NOT NULL,
    cliente_telephone VARCHAR(15) NOT NULL,
    cliente_email VARCHAR(255) NOT NULL,
    cliente_cep VARCHAR(10) NOT NULL,
    cliente_house_number INT NOT NULL,
    cliente_residence_letter CHAR(1) NOT NULL
    );


CREATE TABLE IF NOT EXISTS historical (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          historical_doctor_name VARCHAR(255) NOT NULL,
    historical_doctor_service VARCHAR(255) NOT NULL,
    historical_doctor_date DATE NOT NULL,
    client_id INT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clientes(id) ON DELETE CASCADE
    );
