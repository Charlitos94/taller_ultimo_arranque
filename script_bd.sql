CREATE TABLE personas (
    id_persona VARCHAR2(20) NOT NULL,
    nombre VARCHAR2(100) NOT NULL,
    telefono VARCHAR2(15),
    correo VARCHAR2(100),
    CONSTRAINT pk_personas PRIMARY KEY (id_persona)
);


CREATE TABLE clientes (
    id_persona VARCHAR2(20) NOT NULL,
    nit VARCHAR2(15),
    direccion VARCHAR2(150),
    CONSTRAINT pk_clientes PRIMARY KEY (id_persona),
    CONSTRAINT fk_clientes_personas FOREIGN KEY (id_persona) REFERENCES personas(id_persona)
);

CREATE TABLE mecanicos (
    id_persona VARCHAR2(20) NOT NULL,
    especialidad VARCHAR2(50),
    CONSTRAINT pk_mecanicos PRIMARY KEY (id_persona),
    CONSTRAINT fk_mecanicos_personas FOREIGN KEY (id_persona) REFERENCES personas(id_persona)
);

CREATE TABLE vehiculos (
    placa VARCHAR2(10) NOT NULL,
    id_cliente VARCHAR2(20) NOT NULL,
    marca VARCHAR2(50) NOT NULL,
    modelo VARCHAR2(50) NOT NULL,
    anio NUMBER(4) NOT NULL,
    color VARCHAR2(30),
    CONSTRAINT pk_vehiculos PRIMARY KEY (placa),
    CONSTRAINT fk_vehiculos_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id_persona)
);

CREATE TABLE repuestos (
    id_repuesto VARCHAR2(20) NOT NULL,
    nombre VARCHAR2(100) NOT NULL,
    descripcion VARCHAR2(200),
    precio NUMBER(10, 2) NOT NULL,
    existencia NUMBER(6) NOT NULL,
    CONSTRAINT pk_repuestos PRIMARY KEY (id_repuesto),
    CONSTRAINT chk_repuesto_precio CHECK (precio >= 0),
    CONSTRAINT chk_repuesto_existencia CHECK (existencia >= 0)
);

CREATE TABLE servicios (
id_servicio VARCHAR(20) NOT NULL,
descripcion VARCHAR(150) NOT NULL,
costo_mano_obra NUMBER(10, 2) NOT NULL,
CONSTRAINT pk_servicios PRIMARY KEY (id_servicio),
CONSTRAINT chk_servicio_costo CHECK (costo_mano_obra >= 0)
);
