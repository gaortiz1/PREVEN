INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (1, 'Riesgos Mecánicos', 1, TRUE);
INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (2, 'Riesgos Físicos', 2, TRUE);
INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (3, 'Riesgos Químicos', 3, TRUE);
INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (4, 'Riesgos Biológicos', 4, TRUE);
INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (5, 'Riesgos Ergonómicos', 4, TRUE);
INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (6, 'Riesgos Psicosociales', 5, TRUE);
INSERT INTO factor(id_factor, name_factor, ORDER_FACTOR, state_factor) VALUES (7, 'Accidentes mayores', 6, TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (1, 1, 'Caída de personas a distinto nivel', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (2, 1, 'Trabajo en altura', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (3, 1, 'Caída de personas al mismo nivel', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (4, 1, 'Caída de objetos por desplome o derrumbamiento', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (5, 1, 'Caída de objetos en manipulacion', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (6, 1, 'Pisada sobre objetos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (7, 1, 'Choque contra objetos inmóviles', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (8, 1, 'Choque contra objetos móviles', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (9, 1, 'Golpes/heridas por manipulacion de herramientas o armas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (10, 1, 'Proyeccion de fragmentos o particulas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (11, 1, 'Atrapamiento por o entre objetos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (12, 1, 'Atrapamiento por vuelco de máquinas o vehículos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (13, 1, 'Atropello o golpes por vehículos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (14, 1, 'Máquinas o herramientas defectuosas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (15, 1, 'Superficies de trabajo inadecuadas/irregulares', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (16, 1, 'Peligros en el montaje, instalación o mantenimiento de máquinas y/o equipos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (17, 1, 'Medios izaje alzar', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (18, 1, 'Recipientes de presión', TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (19, 2, 'Incendios', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (20, 2, 'Explosiones', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (21, 2, 'Exposición a temperaturas extremas (altas y bajas)', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (22, 2, 'Contactos térmicos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (23, 2, 'Contactos eléctricos directos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (24, 2, 'Contactos eléctricos indirectos, cortocircuitos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (25, 2, 'Exposición a radiaciones ionizantes', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (26, 2, 'Choque contra objetos móviles', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (27, 2, 'Ruido', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (28, 2, 'Vibraciones', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (29, 2, 'Iluminación', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (30, 2, 'Espacios confinados', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (31, 2, 'Exposición a presiones altas y/o bajas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (32, 2, 'Estrés termico', TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (33, 3, 'Exposición a gases y vapores', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (34, 3, 'Exposición a aerosoles sólidos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (35, 3, 'Exposición a aerosoles líquidos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (36, 3, 'Exposición a sustancias nocivas o tóxicas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (37, 3, 'Contacto son sustancias caústicas y/o corrosivas', TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (38, 4, 'Exposición a virus', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (39, 4, 'Exposición a bacterias', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (40, 4, 'Parásitos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (41, 4, 'Exposición a hongos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (42, 4, 'Exposición a derivados orgánicos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (43, 4, 'Exposición a insectos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (44, 4, 'Exposición a animales selváticos: tarántulas, serpientes, fieras', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (45, 4, 'Exposición a materiales infecto contagiosos', TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (46, 5, 'Diseño del puesto de trabajo', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (47, 5, 'Organización y orden del puesto de trabajo', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (48, 5, 'Sobre-esfuerzo físico / sobre tensión', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (49, 5, 'Manejo manual de cargas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (50, 5, 'Posturas forzadas', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (51, 5, 'Movimientos repetitivos', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (52, 5, 'Disconfort acústico', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (53, 5, 'Disconfort térmico', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (54, 5, 'Disconfort lumínico', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (55, 5, 'Calidad de aire', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (56, 5, 'Operadores de PVD', TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (57, 6, 'Carga Mental', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (58, 6, 'Contenido del Trabajo', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (59, 6, 'Definición del Rol', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (60, 6, 'Supervisión y Participación', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (61, 6, 'Autonomía', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (62, 6, 'Interés por el Trabajador', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (63, 6, 'Desarraigo Familiar', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (64, 6, 'Relaciones Personales', TRUE);

INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (65, 6, 'Amenaza Delincuencial', TRUE);
INSERT INTO risk(id_risk, id_factor, name_risk, state_risk) VALUES (66, 6, 'Desastres naturales', TRUE);





