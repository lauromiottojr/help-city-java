CREATE TABLE estado(
    id_estado serial,
    nome_estado VARCHAR(30) UNIQUE NOT NULL,
    uf_estado VARCHAR(2) UNIQUE NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (id_estado)
);
CREATE TABLE cidade(
    id_cidade serial,
    nome_cidade VARCHAR(100) UNIQUE NOT NULL,
    datacadastro_cidade DATE NOT NULL,
    status_cidade CHAR(1) NOT NULL,
    id_estado INTEGER,
    CONSTRAINT pk_cidade PRIMARY KEY (id_cidade),
    CONSTRAINT fk_estado FOREIGN KEY (id_estado) REFERENCES estado
);
CREATE TABLE secretaria(
    id_secretaria serial,
    nome_secretaria VARCHAR(60) NOT NULL,
    telefone_secretaria VARCHAR(14) NOT NULL,
    email_secretaria VARCHAR(100) UNIQUE NOT NULL,
    datacadastro_secretaria DATE NOT NULL,
    id_cidade INTEGER,
    CONSTRAINT pk_secretaria PRIMARY KEY (id_secretaria),
    CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) REFERENCES cidade
);
CREATE TABLE usuario(
    id_usuario serial,
    nome_usuario VARCHAR(60) NOT NULL,
    cpf_usuario VARCHAR(14) NOT NULL,
    rg_usuario VARCHAR(20) NOT NULL,
    email_usuario VARCHAR(100) NOT NULL,
    telefone_usuario VARCHAR(14) NOT NULL,
    datanascimento_usuario DATE NOT NULL,
    datacadastro_usuario DATE NOT NULL,
    status_usuario CHAR(1) NOT NULL,
    sexo_usuario CHAR(1) NOT NULL,
    tipo_usuario CHAR(1) NOT NULL,
    login_usuario VARCHAR(30) UNIQUE NOT NULL,
    senha_usuario VARCHAR(200) NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);
CREATE TABLE adm(
    id_adm serial,
    id_usuario INTEGER,
    CONSTRAINT pk_adm PRIMARY KEY (id_adm),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario
);
CREATE TABLE admprefeitura(
    id_admprefeitura serial,
    id_usuario INTEGER,
    id_cidade INTEGER,
    CONSTRAINT pk_admprefeitura PRIMARY KEY (id_admprefeitura),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario,
    CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) REFERENCES cidade
);
CREATE TABLE funcionario(
    id_funcionario serial,
    id_usuario INTEGER,
    id_secretaria INTEGER,
    CONSTRAINT pk_funcionario PRIMARY KEY (id_funcionario),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario,
    CONSTRAINT fk_secretaria FOREIGN KEY (id_secretaria) REFERENCES secretaria
);
CREATE TABLE cidadao(
    id_cidadao serial,
    id_usuario INTEGER,
    id_cidade INTEGER,
    CONSTRAINT pk_cidadao PRIMARY KEY (id_cidadao),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario,
    CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) REFERENCES cidade
);
CREATE TABLE categoria(
    id_categoria serial,
    nome_categoria varchar(200) not null,
    id_cidade INTEGER,
    CONSTRAINT pk_categoria PRIMARY KEY (id_categoria),
    CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) REFERENCES cidade
);
CREATE TABLE ocorrencia(
    id_ocorrencia serial,
    localizacao_ocorrencia VARCHAR(150) NOT NULL,
    latitude_ocorrencia VARCHAR(100) NOT NULL,
    longitude_ocorrencia VARCHAR(100) NOT NULL,
    descricao_ocorrencia VARCHAR(500) NOT NULL,
    datacriacao_ocorrencia DATE NOT NULL,
    titulo_ocorrencia VARCHAR(100) NOT NULL,
    status_ocorrencia VARCHAR(100) NOT NULL,
    observacao_ocorrencia VARCHAR(200),
    id_usuario INTEGER,
    id_cidade INTEGER,
    id_secretaria INTEGER,
    id_categoria INTEGER,
    CONSTRAINT pk_ocorrencia PRIMARY KEY (id_ocorrencia),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario,
    CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) REFERENCES cidade,
    CONSTRAINT fk_secretaria FOREIGN KEY (id_secretaria) REFERENCES secretaria,
    CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria
);
CREATE TABLE imagem(
    id_imagem serial,
    nome_imagem VARCHAR(100),
    id_ocorrencia INTEGER,
    CONSTRAINT pk_imagem PRIMARY KEY (id_imagem),
    CONSTRAINT fk_ocorrencia FOREIGN KEY (id_ocorrencia) REFERENCES ocorrencia
);
 INSERT INTO estado (uf_estado,nome_estado) VALUES('AC','Acre');  
 INSERT INTO estado (uf_estado,nome_estado) VALUES('AL','Alagoas');  
 INSERT INTO estado (uf_estado,nome_estado) VALUES('AM','Amazonas');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('AP','Amapá');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('BA','Bahia');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('CE','Ceará');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('DF','Distrito Federal');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('ES','Espírito Santo');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('GO','Goiás');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('MA','Maranhão');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('MG','Minas Gerais');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('MS','Mato Grosso do Sul');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('MT','Mato Grosso');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('PA','Pará');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('PB','Paraíba');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('PE','Pernambuco');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('PI','Piauí');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('PR','Paraná');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('RJ','Rio de Janeiro');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('RN','Rio Grande do Norte');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('RO','Rondônia');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('RR','Roraima');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('RS','Rio Grande do Sul');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('SC','Santa Catarina');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('SE','Sergipe');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('SP','São Paulo');
 INSERT INTO estado (uf_estado,nome_estado) VALUES('TO','Tocantins');