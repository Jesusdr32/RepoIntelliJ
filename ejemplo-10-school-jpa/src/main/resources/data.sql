INSERT INTO students(dni, first_name, last_name, birth_date, has_scholarship) VALUES
                    ('48273645M', 'Lucía', 'García', '2003-05-14', true),
                    ('39582716S', 'David', 'Martínez', '2002-11-02', true),
                    ('61492837R', 'María', 'Sánchez', '2004-01-27', true),
                    ('52839476J', 'Pablo', 'Fernández', '2001-09-18', true),
                    ('73928465C', 'Laura', 'Gómez', '2003-03-09', true),
                    ('28473659L', 'Alejandro', 'Ruiz', '2002-07-21', true),
                    ('91827364F', 'Sara', 'Hernández', '2004-12-05', true),
                    ('46372819D', 'Javier', 'Díaz', '2001-04-30', true),
                    ('57283946A', 'Claudia', 'Moreno', '2003-08-11', true),
                    ('38475629P', 'Daniel', 'Muñoz', '2002-02-19', true),
                    ('62938475E', 'Paula', 'Álvarez', '2004-06-23', true),
                    ('74839265H', 'Adrián', 'Romero', '2001-10-07', true),
                    ('29384756N', 'Marta', 'Navarro', '2003-01-15', true),
                    ('85746392Y', 'Sergio', 'Torres', '2002-09-28', true),
                    ('46829375B', 'Elena', 'Domínguez', '2004-04-03', true),
                    ('73948562Z', 'Iván', 'Vázquez', '2001-12-14', true),
                    ('58273649K', 'Natalia', 'Ramos', '2003-07-26', true),
                    ('39485726T', 'Hugo', 'Gil', '2002-05-08', true),
                    ('62738495W', 'Andrea', 'Serrano', '2004-11-17', true),
                    ('84573926Q', 'Carlos', 'Blanco', '2001-02-01', true);


INSERT INTO department(name, location)
VALUES ('Informatica y comunicaciones', 'Planta baja'),
       ('Administración', 'Segunda planta'),
       ('FOL', 'Planta baja'),
       ('Comercio', 'Primera planta');

INSERT INTO teachers (birth_date, start_date, email, first_name, last_name, department_id)
VALUES ('1980-03-15', '2010-09-01', 'juan.perez@centro.edu', 'Juan', 'Pérez', 1),
       ('1975-07-22', '2005-09-01', 'maria.gomez@centro.edu', 'María', 'Gómez', 2),
       ('1988-01-10', '2015-09-01', 'carlos.lopez@centro.edu', 'Carlos', 'López', 1),
       ('1982-11-05', '2012-09-01', 'ana.martin@centro.edu', 'Ana', 'Martín', 3),
       ('1979-06-30', '2008-09-01', 'david.sanchez@centro.edu', 'David', 'Sánchez', 4),
       ('1990-04-18', '2018-09-01', 'laura.romero@centro.edu', 'Laura', 'Romero', 1),
       ('1985-09-12', '2013-09-01', 'jorge.navarro@centro.edu', 'Jorge', 'Navarro', 2),
       ('1978-02-27', '2006-09-01', 'patricia.ruiz@centro.edu', 'Patricia', 'Ruiz', 4),
       ('1983-12-03', '2011-09-01', 'alberto.molina@centro.edu', 'Alberto', 'Molina', 1),
       ('1992-08-19', '2020-09-01', 'silvia.ortega@centro.edu', 'Silvia', 'Ortega', 3);

INSERT INTO modules (module_id, name, description) VALUES
-- DAM
('DAM01', 'Sistemas Informáticos', 'Instalación, configuración y explotación de sistemas operativos y redes.'),
('DAM02', 'Bases de Datos', 'Diseño, creación y administración de bases de datos relacionales.'),
('DAM03', 'Programación', 'Desarrollo de aplicaciones utilizando programación estructurada y orientada a objetos.'),
('DAM04', 'Lenguajes de Marcas y Sistemas de Gestión de Información', 'Uso de XML, HTML y otros lenguajes de marcas.'),
('DAM05', 'Entornos de Desarrollo', 'Uso de IDEs, control de versiones y herramientas de desarrollo.'),
('DAM06', 'Acceso a Datos', 'Acceso y persistencia de datos en aplicaciones multiplataforma.'),
('DAM07', 'Desarrollo de Interfaces', 'Creación de interfaces gráficas para aplicaciones multiplataforma.'),
('DAM08', 'Programación Multimedia y Dispositivos Móviles', 'Desarrollo de aplicaciones móviles y multimedia.'),
('DAM09', 'Programación de Servicios y Procesos', 'Servicios, procesos e hilos en aplicaciones distribuidas.'),
('DAM10', 'Sistemas de Gestión Empresarial', 'Implantación y personalización de sistemas ERP y CRM.'),
('DAM11', 'Formación y Orientación Laboral', 'Prevención de riesgos y orientación profesional.'),
('DAM12', 'Empresa e Iniciativa Emprendedora', 'Creación y gestión de empresas.'),
('DAM13', 'Proyecto de Desarrollo de Aplicaciones Multiplataforma', 'Proyecto final integrador del ciclo formativo.'),

-- DAW
('DAW01', 'Sistemas Informáticos (Web)', 'Instalación, configuración y explotación de sistemas operativos y redes.'),
('DAW02', 'Bases de Datos (Web)', 'Diseño y administración de bases de datos para aplicaciones web.'),
('DAW03', 'Programación (Web)', 'Fundamentos de programación orientada al desarrollo web.'),
('DAW04', 'Lenguajes de Marcas y Sistemas de Gestión de Información (Web)', 'HTML, CSS, XML y tecnologías relacionadas.'),
('DAW05', 'Entornos de Desarrollo (Web)', 'Herramientas, IDEs y control de versiones.'),
('DAW06', 'Desarrollo Web en Entorno Cliente', 'Aplicaciones web usando JavaScript y frameworks cliente.'),
('DAW07', 'Desarrollo Web en Entorno Servidor', 'Desarrollo de aplicaciones web del lado servidor.'),
('DAW08', 'Despliegue de Aplicaciones Web', 'Configuración y despliegue de aplicaciones web en servidores.'),
('DAW09', 'Diseño de Interfaces Web', 'Diseño visual y experiencia de usuario en aplicaciones web.'),
('DAW10', 'Formación y Orientación Laboral (Web)', 'Prevención de riesgos laborales y orientación profesional.'),
('DAW11', 'Empresa e Iniciativa Emprendedora (Web)', 'Creación y gestión de empresas.'),
('DAW12', 'Proyecto de Desarrollo de Aplicaciones Web', 'Proyecto final integrador del ciclo formativo.');

