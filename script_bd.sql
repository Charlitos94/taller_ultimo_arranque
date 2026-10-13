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


CREATE TABLE ordenes_trabajo (
    id_orden VARCHAR2(20) NOT NULL,
    placa_vehiculo VARCHAR2(10) NOT NULL,
    id_mecanico VARCHAR2(20) NOT NULL,
    descripcion_problema VARCHAR2(300) NOT NULL,
    fecha_ingreso DATE DEFAULT SYSDATE NOT NULL,
    fecha_finalizacion DATE,
    estado VARCHAR2(15) DEFAULT 'PENDIENTE' NOT NULL,
    total_mano_obra NUMBER(10, 2) DEFAULT 0.00 NOT NULL,
    total_repuestos NUMBER(10, 2) DEFAULT 0.00 NOT NULL,
    monto_total NUMBER(10, 2) DEFAULT 0.00 NOT NULL,
    CONSTRAINT pk_ordenes PRIMARY KEY (id_orden),
    CONSTRAINT fk_ordenes_vehiculos FOREIGN KEY (placa_vehiculo) REFERENCES vehiculos(placa),
    CONSTRAINT fk_ordenes_mecanicos FOREIGN KEY (id_mecanico) REFERENCES mecanicos(id_persona),
    CONSTRAINT chk_orden_estado CHECK (estado IN ('PENDIENTE', 'EN PROCESO', 'FINALIZADA', 'CANCELADA'))
);

CREATE TABLE detalle_orden_servicios (
    id_orden VARCHAR2(20) NOT NULL,
    id_servicio VARCHAR2(20) NOT NULL,
    costo NUMBER(10, 2) NOT NULL,
    CONSTRAINT pk_det_servicios PRIMARY KEY (id_orden, id_servicio),
    CONSTRAINT fk_detserv_orden FOREIGN KEY (id_orden) REFERENCES ordenes_trabajo(id_orden) ON DELETE CASCADE,
    CONSTRAINT fk_detserv_servicio FOREIGN KEY (id_servicio) REFERENCES servicios(id_servicio)
);

CREATE TABLE detalle_orden_repuestos (
    id_orden VARCHAR2(20) NOT NULL,
    id_repuesto VARCHAR2(20) NOT NULL,
    cantidad NUMBER(6) NOT NULL,
    precio_unitario NUMBER(10, 2) NOT NULL,
    subtotal NUMBER(10, 2) NOT NULL,
    CONSTRAINT pk_det_repuestos PRIMARY KEY (id_orden, id_repuesto),
    CONSTRAINT fk_detrep_orden FOREIGN KEY (id_orden) REFERENCES ordenes_trabajo(id_orden) ON DELETE CASCADE,
    CONSTRAINT fk_detrep_repuesto FOREIGN KEY (id_repuesto) REFERENCES repuestos(id_repuesto),
    CONSTRAINT chk_detrep_cant CHECK (cantidad > 0)
    );
    