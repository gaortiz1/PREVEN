insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (1, null, 'ECUADOR', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (2, null, 'ESTADOS UNIDOS', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (3, 1, 'PICHINCHA', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (4, 1, 'GUAYAS', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (5, 1, 'AZUAY', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (6, 3, 'QUITO', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (7, 3, 'SANGOLQUI', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (8, 4, 'GUAYAQUIL', 't');
insert into GEOPOLITICAL_DIVISION (ID_GEOPOLITICAL_DIVISION, ID_ROOT_GEOPOLITICAL_DIVISION, NAME_GEOPOLITICAL_DIVISION, STATE_GEOPOLITICAL_DIVISION) values (9, 4, 'DURAN', 't');

--GROUP_CATALOG
INSERT INTO GROUP_CATALOG VALUES('SP', 'SECTOR PRODUCTIVO', 't');
INSERT INTO GROUP_CATALOG VALUES('TD', 'TIPO DOCUMENTO', 't');
INSERT INTO GROUP_CATALOG VALUES('HT', 'HORARIO DE TRABAJO', 't');
INSERT INTO GROUP_CATALOG VALUES('TP', 'TIPO COMPAÑIA', 't');
INSERT INTO GROUP_CATALOG VALUES('TT', 'TIPO TELEFONO', 't');

INSERT INTO group_catalog(id_groupcatalog, name_groupcatalog, status_group_catalog)
    VALUES ('NVUL', 'Nivel vulnerabilidad', TRUE);

INSERT INTO group_catalog(id_groupcatalog, name_groupcatalog, status_group_catalog)
    VALUES ('PRO', 'Profesion', TRUE);

INSERT INTO group_catalog(id_groupcatalog, name_groupcatalog, status_group_catalog)
    VALUES ('SEX', 'Sexo', TRUE);

INSERT INTO group_catalog(id_groupcatalog, name_groupcatalog, status_group_catalog)
    VALUES ('NEDU', 'Nivel educacion', TRUE);

INSERT INTO group_catalog(id_groupcatalog, name_groupcatalog, status_group_catalog)
    VALUES ('PROBA', 'Probabilidad', TRUE);
	
INSERT INTO group_catalog(id_groupcatalog, name_groupcatalog, status_group_catalog)
    VALUES ('CONSE', 'Consecuencia', TRUE);


--CATALOG
INSERT INTO CATALOG VALUES('BR','SP', 'BAJO RIESGO', 't');
INSERT INTO CATALOG VALUES('MR','SP', 'MEDIANO RIESGO', 't');
INSERT INTO CATALOG VALUES('AR','SP', 'ALTO RIESGO', 't');
INSERT INTO CATALOG VALUES('CI','TD', 'CEDULA', 'T');
INSERT INTO CATALOG VALUES('RUC','TD', 'RUC', 'T');
INSERT INTO CATALOG VALUES('J8','HT', 'JORNADA 8 HORAS', 't');
INSERT INTO CATALOG VALUES('JC','HT', 'JORNADA CONTINUA', 't');
INSERT INTO CATALOG VALUES('MICRO','TP', 'MICRO[1-9]', 'T');
INSERT INTO CATALOG VALUES('PEQ','TP', 'PEQUEÑA[10-49]', 'T');
INSERT INTO CATALOG VALUES('MED','TP', 'MEDIANA[50-199]', 'T');
INSERT INTO CATALOG VALUES('GRAN','TP', 'GRANDE[200 Y MAS]', 'T');
INSERT INTO CATALOG VALUES('CEL','TT', 'CELULAR', 'T');
INSERT INTO CATALOG VALUES('TEL','TT', 'TELEFONO', 'T');

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('NIG', 'NVUL', 'Ninguna', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('EMB', 'NVUL', 'Embarazada', TRUE);


INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('DIS', 'NVUL', 'Discapacidad', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('3EDAD', 'NVUL', '3ra Edad', TRUE);

    INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('SIS', 'PRO', 'Sistemas', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('LIC', 'PRO', 'Licenciado', TRUE);


INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('M', 'SEX', 'Masculino', TRUE);


INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('F', 'SEX', 'Femenino', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('PRI', 'NEDU', 'Primaria', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('SEC', 'NEDU', 'Secundaria', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('UNI', 'NEDU', 'Universitaria', TRUE);
	
INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('LOW', 'PROBA', 'Baja', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('MEDI', 'PROBA', 'Media', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('HIGH', 'PROBA', 'Alta', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('LD', 'CONSE', 'Ligeramente dañino', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('D', 'CONSE', 'Dañino', TRUE);

INSERT INTO catalog(id_catalog, id_groupcatalog, name_catalog, status_catalog)
    VALUES ('ED', 'CONSE', 'Extremadamente dañino', TRUE);


--Seguridades

INSERT INTO seg_system(sys_id, sys_name, sys_status)
    VALUES (1, 'GESSO', true);

INSERT INTO seg_profile(
            prf_id, prf_name, status)
    VALUES (1, 'Administrador', TRUE);

INSERT INTO seg_menu(
            sys_id, men_id, men_name, men_status)
    VALUES (1, 1, 'Administracion', TRUE);

INSERT INTO seg_menu(
            sys_id, men_id, men_name, men_status)
    VALUES (1, 2, 'Edicion', TRUE);

INSERT INTO seg_option(
            men_id, opt_id, opt_name)
    VALUES (1, 1, 'Usuario');

INSERT INTO seg_option(
            men_id, opt_id, opt_name)
    VALUES (1, 2, 'Persona');


INSERT INTO seg_option(
            men_id, opt_id, opt_name)
    VALUES (1, 3, 'Proceso');


INSERT INTO seg_option(
            men_id, opt_id, opt_name)
    VALUES (1, 4, 'Empresa');

INSERT INTO seg_option(
            men_id, opt_id, opt_name)
    VALUES (2, 5, 'Edicion persona');