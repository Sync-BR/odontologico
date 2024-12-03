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

CREATE TABLE IF NOT EXISTS Exam (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    type_exam VARCHAR(255) NOT NULL,
    date_exam DATE NOT NULL,
    note_exam TEXT NOT NULL,
    exam_doctor VARCHAR(255) NOT NULL,
    client_id INT NOT NULL,  -- Alteração para client_id, mais claro
    FOREIGN KEY (client_id) REFERENCES clientes(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS doctor (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      doctor_name VARCHAR(255) NOT NULL,
    doctor_cpf VARCHAR(14) NOT NULL UNIQUE,
    doctor_specialization VARCHAR(255) NOT NULL,
    doctor_telephone VARCHAR(15) NOT NULL,
    doctor_email VARCHAR(255) NOT NULL
    );

-- Inserção de dados de exemplo na tabela `doctor`
INSERT INTO doctor (doctor_name, doctor_cpf, doctor_specialization, doctor_telephone, doctor_email)
VALUES
    ('Dr. Pedro Lima', '123.456.789-00', 'Clínico Geral', '(71) 91234-5678', 'pedro.lima@example.com'),
    ('Dr. Ana Costa', '987.654.321-00', 'Dentista', '(71) 97654-3210', 'ana.costa@example.com');
