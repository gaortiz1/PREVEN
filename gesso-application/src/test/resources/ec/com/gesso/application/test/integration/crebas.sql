/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     21/03/2015 22:41:26                          */
/*==============================================================*/


drop index COMPANY_HAS_ACTIVITYECONOMIC_FK;

drop index ACTIVITY_ECONOMIC_COMPANY_PK;

drop table ACTIVITY_ECONOMIC_COMPANY;

drop index ADDRESS_PK;

drop table ADDRESS;

drop index BUSINESS_HOUR_PK;

drop table BUSINESS_HOUR;

drop index CV_HAS_CAPACITATION_FK;

drop index CAPACITATION_PK;

drop table CAPACITATION;

drop index GROUPCATALOG_HAS_CATALOG_FK;

drop index CATALOG_PK;

drop table CATALOG;

drop index TYPECOMP_QUALIFY_COMPANY_FK;

drop index COMPANY_PK;

drop table COMPANY;

drop index PERSON_HAS_CONTACTDATA_FK;

drop index EMAIL_IS_PART_CONTACTDATA_FK;

drop index ADDRESS_IS_PART_CONTACTDATA_FK;

drop index PHONE_IS_PART_CONTACTDATA_FK;

drop index COMPANY_HAS_CONTACTDATA_FK;

drop index CONTACT_DATA_PK;

drop table CONTACT_DATA;

drop index PERSON_HAS_CV_FK;

drop index CURRICULUM_VITAE_PK;

drop table CURRICULUM_VITAE;

drop index LEVELEDUCA_HAS_PROFESSION_FK;

drop index DEGREE_PK;

drop table DEGREE;

drop index PERSON_HAS_DISABILITY_FK;

drop index DISABILITY_PK;

drop table DISABILITY;

drop index PERSON_HAS_DOCUMENT_FK;

drop index COMPANY_HAS_DOCUMENT_FK;

drop index DOCUMENT_PK;

drop table DOCUMENT;

drop index EMAIL_PK;

drop table EMAIL;

drop index CV_HAS_EXPERIENCE_FK;

drop index EXPERIENCE_PK;

drop table EXPERIENCE;

drop index GROUP_CATALOG_PK;

drop table GROUP_CATALOG;

drop index JOB_HAS_LEVEL_FK;

drop index SUBPROCESS_HAS_WORKPLACE_FK;

drop index JOB_PK;

drop table JOB;

drop index JOB_HAS_LABOR_CONTRACT_FK;

drop index CV_IS_PART_LABORCONTRACT_FK;

drop index SCHEDWORK_IS_PART_LABORCONTR_FK;

drop index LABOR_CONTRACT_PK;

drop table LABOR_CONTRACT;

drop index LEVELE_DUCATION_PK;

drop table LEVELE_DUCATION;

drop index CATALOG_GENDER_HAS_PERSON_FK;

drop index PERSON_PK;

drop table PERSON;

drop index CATALOGPHONE_IS_PART_PHONE_FK;

drop index PHONE_PK;

drop table PHONE;

drop index PROCESS_HAS_LEVEL_FK;

drop index PROCESS_PK;

drop table PROCESS;

drop index COMPANY_HAS_SCHEDULEWORK_FK;

drop index BUSIN_HOUR_HAS_SCHED_WORK_FK;

drop index SCHEDULE_WORK_PK;

drop table SCHEDULE_WORK;

drop index COMPANY_IS_PART_SUBCOMPANY_FK;

drop index COMPANY_HAS_SUBCOMPANY_FK;

drop index SUBCOMPANY_PK;

drop table SUBCOMPANY;

drop index SUBPROCESS_HAS_LEVEL_FK;

drop index PROCESS_HAS_SUBPROCESS_FK;

drop index SUBPROCESS_PK;

drop table SUBPROCESS;

drop index PERSON_HAS_TITLE_FK;

drop index DEGREE_IS_PART_PERSONDEGR_FK;

drop index TITLE_PK;

drop table TITLE;

drop index TYPE_COMPANY_PK;

drop table TYPE_COMPANY;

drop index TYPE_DOCUMENT_PK;

drop table TYPE_DOCUMENT;

drop sequence SEQUENCE_ID_JOB;

drop sequence SEQUENCE_ID_PROCESS;

drop sequence SEQUENCE_SUBPROCESS;

drop sequence SEQ_NEW_PERSON;

create sequence SEQUENCE_ID_JOB
increment 1
start 1
cycle;

create sequence SEQUENCE_ID_PROCESS
increment 1
start 1
cycle;

create sequence SEQUENCE_SUBPROCESS
increment 1
start 1
cycle;

create sequence SEQ_NEW_PERSON
cycle;

/*==============================================================*/
/* Table: ACTIVITY_ECONOMIC_COMPANY                             */
/*==============================================================*/
create table ACTIVITY_ECONOMIC_COMPANY (
   ID_ACTIVITY_ECONOMIC INT4                 not null,
   ID_COMPANY           INT8                 null,
   NAME_ACTIVITY_ECONOMIC VARCHAR(255)         not null,
   STATUS_ACTIVITYECONOMIC BOOL                 not null,
   constraint PK_ACTIVITY_ECONOMIC_COMPANY primary key (ID_ACTIVITY_ECONOMIC)
);

/*==============================================================*/
/* Index: ACTIVITY_ECONOMIC_COMPANY_PK                          */
/*==============================================================*/
create unique index ACTIVITY_ECONOMIC_COMPANY_PK on ACTIVITY_ECONOMIC_COMPANY (
ID_ACTIVITY_ECONOMIC
);

/*==============================================================*/
/* Index: COMPANY_HAS_ACTIVITYECONOMIC_FK                       */
/*==============================================================*/
create  index COMPANY_HAS_ACTIVITYECONOMIC_FK on ACTIVITY_ECONOMIC_COMPANY (
ID_COMPANY
);

/*==============================================================*/
/* Table: ADDRESS                                               */
/*==============================================================*/
create table ADDRESS (
   ID_ADDRESS           INT8                 not null,
   NAME_ADDRESS         VARCHAR(255)         not null,
   STATUS_ADDRESS       BOOL                 not null,
   constraint PK_ADDRESS primary key (ID_ADDRESS)
);

/*==============================================================*/
/* Index: ADDRESS_PK                                            */
/*==============================================================*/
create unique index ADDRESS_PK on ADDRESS (
ID_ADDRESS
);

/*==============================================================*/
/* Table: BUSINESS_HOUR                                         */
/*==============================================================*/
create table BUSINESS_HOUR (
   ID_BUSINESS_HOUR     INT4                 not null,
   NAME_BUSINESS_HOUR   VARCHAR(255)         not null,
   STATE_BUSINESS_HOUR  BOOL                 not null,
   constraint PK_BUSINESS_HOUR primary key (ID_BUSINESS_HOUR)
);

/*==============================================================*/
/* Index: BUSINESS_HOUR_PK                                      */
/*==============================================================*/
create unique index BUSINESS_HOUR_PK on BUSINESS_HOUR (
ID_BUSINESS_HOUR
);

/*==============================================================*/
/* Table: CAPACITATION                                          */
/*==============================================================*/
create table CAPACITATION (
   ID_CV                INT8                 not null,
   ID_PERSON            INT8                 not null,
   ID_CAPACITATION      INT4                 not null,
   DESCRIPTION_CAPACITATION VARCHAR(255)         not null,
   STATUS_CAPACITATION  BOOL                 not null,
   HOURS                DATE                 null,
   constraint PK_CAPACITATION primary key (ID_CV, ID_PERSON, ID_CAPACITATION)
);

/*==============================================================*/
/* Index: CAPACITATION_PK                                       */
/*==============================================================*/
create unique index CAPACITATION_PK on CAPACITATION (
ID_CV,
ID_PERSON,
ID_CAPACITATION
);

/*==============================================================*/
/* Index: CV_HAS_CAPACITATION_FK                                */
/*==============================================================*/
create  index CV_HAS_CAPACITATION_FK on CAPACITATION (
ID_CV,
ID_PERSON
);

/*==============================================================*/
/* Table: CATALOG                                               */
/*==============================================================*/
create table CATALOG (
   ID_CATALOG           INT8                 not null,
   ID_GROUPCATALOG      INT4                 not null,
   NAME_CATALOG         VARCHAR(255)         not null,
   STATUS               BOOL                 not null,
   constraint PK_CATALOG primary key (ID_CATALOG)
);

/*==============================================================*/
/* Index: CATALOG_PK                                            */
/*==============================================================*/
create unique index CATALOG_PK on CATALOG (
ID_CATALOG
);

/*==============================================================*/
/* Index: GROUPCATALOG_HAS_CATALOG_FK                           */
/*==============================================================*/
create  index GROUPCATALOG_HAS_CATALOG_FK on CATALOG (
ID_GROUPCATALOG
);

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
create table COMPANY (
   ID_COMPANY           INT8                 not null,
   ID_TYPECOMPANY       INT4                 not null,
   NAME_COMPANY         VARCHAR(255)         not null,
   STATE_COMPANY        BOOL                 not null,
   constraint PK_COMPANY primary key (ID_COMPANY)
);

/*==============================================================*/
/* Index: COMPANY_PK                                            */
/*==============================================================*/
create unique index COMPANY_PK on COMPANY (
ID_COMPANY
);

/*==============================================================*/
/* Index: TYPECOMP_QUALIFY_COMPANY_FK                           */
/*==============================================================*/
create  index TYPECOMP_QUALIFY_COMPANY_FK on COMPANY (
ID_TYPECOMPANY
);

/*==============================================================*/
/* Table: CONTACT_DATA                                          */
/*==============================================================*/
create table CONTACT_DATA (
   ID_CONTACTDATA       INT8                 not null,
   ID_COMPANY           INT8                 null,
   ID_PERSON            INT8                 null,
   ID_EMAIL             INT8                 null,
   ID_ADDRESS           INT8                 null,
   ID_PHONE             INT8                 null,
   STATUS_CONTACTDATA   BOOL                 null,
   constraint PK_CONTACT_DATA primary key (ID_CONTACTDATA)
);

/*==============================================================*/
/* Index: CONTACT_DATA_PK                                       */
/*==============================================================*/
create unique index CONTACT_DATA_PK on CONTACT_DATA (
ID_CONTACTDATA
);

/*==============================================================*/
/* Index: COMPANY_HAS_CONTACTDATA_FK                            */
/*==============================================================*/
create  index COMPANY_HAS_CONTACTDATA_FK on CONTACT_DATA (
ID_COMPANY
);

/*==============================================================*/
/* Index: PHONE_IS_PART_CONTACTDATA_FK                          */
/*==============================================================*/
create  index PHONE_IS_PART_CONTACTDATA_FK on CONTACT_DATA (
ID_PHONE
);

/*==============================================================*/
/* Index: ADDRESS_IS_PART_CONTACTDATA_FK                        */
/*==============================================================*/
create  index ADDRESS_IS_PART_CONTACTDATA_FK on CONTACT_DATA (
ID_ADDRESS
);

/*==============================================================*/
/* Index: EMAIL_IS_PART_CONTACTDATA_FK                          */
/*==============================================================*/
create  index EMAIL_IS_PART_CONTACTDATA_FK on CONTACT_DATA (
ID_EMAIL
);

/*==============================================================*/
/* Index: PERSON_HAS_CONTACTDATA_FK                             */
/*==============================================================*/
create  index PERSON_HAS_CONTACTDATA_FK on CONTACT_DATA (
ID_PERSON
);

/*==============================================================*/
/* Table: CURRICULUM_VITAE                                      */
/*==============================================================*/
create table CURRICULUM_VITAE (
   ID_CV                INT8                 not null,
   ID_PERSON            INT8                 not null,
   OCCUPATION           VARCHAR(255)         not null,
   PHOTO                CHAR(254)            not null,
   STATUS_CURRICULUM_VITAE BOOL                 not null,
   constraint PK_CURRICULUM_VITAE primary key (ID_CV, ID_PERSON)
);

/*==============================================================*/
/* Index: CURRICULUM_VITAE_PK                                   */
/*==============================================================*/
create unique index CURRICULUM_VITAE_PK on CURRICULUM_VITAE (
ID_CV,
ID_PERSON
);

/*==============================================================*/
/* Index: PERSON_HAS_CV_FK                                      */
/*==============================================================*/
create  index PERSON_HAS_CV_FK on CURRICULUM_VITAE (
ID_PERSON
);

/*==============================================================*/
/* Table: DEGREE                                                */
/*==============================================================*/
create table DEGREE (
   ID_DEGREE            INT4                 not null,
   ID_LEVELEDUCATION    INT4                 not null,
   NAME_DEGREE          VARCHAR(255)         not null,
   STATUS_DEGREE        BOOL                 not null,
   constraint PK_DEGREE primary key (ID_DEGREE, ID_LEVELEDUCATION)
);

/*==============================================================*/
/* Index: DEGREE_PK                                             */
/*==============================================================*/
create unique index DEGREE_PK on DEGREE (
ID_DEGREE,
ID_LEVELEDUCATION
);

/*==============================================================*/
/* Index: LEVELEDUCA_HAS_PROFESSION_FK                          */
/*==============================================================*/
create  index LEVELEDUCA_HAS_PROFESSION_FK on DEGREE (
ID_LEVELEDUCATION
);

/*==============================================================*/
/* Table: DISABILITY                                            */
/*==============================================================*/
create table DISABILITY (
   ID_DISABILITY        INT8                 not null,
   ID_PERSON            INT8                 not null,
   NAME_DISABILITY      VARCHAR(255)         not null,
   STATUS_DISABILITY    BOOL                 not null,
   constraint PK_DISABILITY primary key (ID_DISABILITY, ID_PERSON)
);

/*==============================================================*/
/* Index: DISABILITY_PK                                         */
/*==============================================================*/
create unique index DISABILITY_PK on DISABILITY (
ID_DISABILITY,
ID_PERSON
);

/*==============================================================*/
/* Index: PERSON_HAS_DISABILITY_FK                              */
/*==============================================================*/
create  index PERSON_HAS_DISABILITY_FK on DISABILITY (
ID_PERSON
);

/*==============================================================*/
/* Table: DOCUMENT                                              */
/*==============================================================*/
create table DOCUMENT (
   ID_TYPE_DOCUEMENT    INT4                 not null,
   ID_COMPANY           INT8                 null,
   ID_PERSON            INT8                 null,
   VALUE_DOCUMENT       VARCHAR(255)         not null,
   STATE_DOCUMENT       BOOL                 not null,
   constraint PK_DOCUMENT primary key (ID_TYPE_DOCUEMENT)
);

/*==============================================================*/
/* Index: DOCUMENT_PK                                           */
/*==============================================================*/
create unique index DOCUMENT_PK on DOCUMENT (
ID_TYPE_DOCUEMENT
);

/*==============================================================*/
/* Index: COMPANY_HAS_DOCUMENT_FK                               */
/*==============================================================*/
create  index COMPANY_HAS_DOCUMENT_FK on DOCUMENT (
ID_COMPANY
);

/*==============================================================*/
/* Index: PERSON_HAS_DOCUMENT_FK                                */
/*==============================================================*/
create  index PERSON_HAS_DOCUMENT_FK on DOCUMENT (
ID_PERSON
);

/*==============================================================*/
/* Table: EMAIL                                                 */
/*==============================================================*/
create table EMAIL (
   ID_EMAIL             INT8                 not null,
   EMAILADDESS          VARCHAR(255)         not null,
   STATUS_EMAIL         BOOL                 not null,
   constraint PK_EMAIL primary key (ID_EMAIL)
);

/*==============================================================*/
/* Index: EMAIL_PK                                              */
/*==============================================================*/
create unique index EMAIL_PK on EMAIL (
ID_EMAIL
);

/*==============================================================*/
/* Table: EXPERIENCE                                            */
/*==============================================================*/
create table EXPERIENCE (
   ID_CV                INT8                 not null,
   ID_PERSON            INT8                 not null,
   ID_EXPERIENCE        INT8                 not null,
   DESCRIPTION          VARCHAR(255)         not null,
   START_DATE           DATE                 not null,
   END_DATE             DATE                 not null,
   constraint PK_EXPERIENCE primary key (ID_CV, ID_PERSON, ID_EXPERIENCE)
);

/*==============================================================*/
/* Index: EXPERIENCE_PK                                         */
/*==============================================================*/
create unique index EXPERIENCE_PK on EXPERIENCE (
ID_CV,
ID_PERSON,
ID_EXPERIENCE
);

/*==============================================================*/
/* Index: CV_HAS_EXPERIENCE_FK                                  */
/*==============================================================*/
create  index CV_HAS_EXPERIENCE_FK on EXPERIENCE (
ID_CV,
ID_PERSON
);

/*==============================================================*/
/* Table: GROUP_CATALOG                                         */
/*==============================================================*/
create table GROUP_CATALOG (
   ID_GROUPCATALOG      INT4                 not null,
   NAME_GROUPCATALOG    VARCHAR(255)         not null,
   STATUS               BOOL                 not null,
   constraint PK_GROUP_CATALOG primary key (ID_GROUPCATALOG)
);

/*==============================================================*/
/* Index: GROUP_CATALOG_PK                                      */
/*==============================================================*/
create unique index GROUP_CATALOG_PK on GROUP_CATALOG (
ID_GROUPCATALOG
);

/*==============================================================*/
/* Table: JOB                                                   */
/*==============================================================*/
create table JOB (
   ID_JOB               INT8                 not null,
   ID_SUBPROCESS        INT8                 not null,
   ID_JOB_ROOT          INT8                 null,
   NAME_JOB             VARCHAR(255)         not null,
   DESCRIPTION_JOB      VARCHAR(255)         not null,
   STATUS_JOB           BOOL                 not null,
   constraint PK_JOB primary key (ID_JOB)
);

/*==============================================================*/
/* Index: JOB_PK                                                */
/*==============================================================*/
create unique index JOB_PK on JOB (
ID_JOB
);

/*==============================================================*/
/* Index: SUBPROCESS_HAS_WORKPLACE_FK                           */
/*==============================================================*/
create  index SUBPROCESS_HAS_WORKPLACE_FK on JOB (
ID_SUBPROCESS
);

/*==============================================================*/
/* Index: JOB_HAS_LEVEL_FK                                      */
/*==============================================================*/
create  index JOB_HAS_LEVEL_FK on JOB (
ID_JOB_ROOT
);

/*==============================================================*/
/* Table: LABOR_CONTRACT                                        */
/*==============================================================*/
create table LABOR_CONTRACT (
   ID_COMPANY           INT8                 not null,
   ID_BUSINESS_HOUR     INT4                 not null,
   ID_CV                INT8                 not null,
   ID_PERSON            INT8                 not null,
   ID_JOB               INT8                 not null,
   START_DATE           DATE                 not null,
   END_DATE             DATE                 null,
   constraint PK_LABOR_CONTRACT primary key (ID_COMPANY, ID_BUSINESS_HOUR, ID_CV, ID_PERSON, ID_JOB)
);

/*==============================================================*/
/* Index: LABOR_CONTRACT_PK                                     */
/*==============================================================*/
create unique index LABOR_CONTRACT_PK on LABOR_CONTRACT (
ID_COMPANY,
ID_BUSINESS_HOUR,
ID_CV,
ID_PERSON,
ID_JOB
);

/*==============================================================*/
/* Index: SCHEDWORK_IS_PART_LABORCONTR_FK                       */
/*==============================================================*/
create  index SCHEDWORK_IS_PART_LABORCONTR_FK on LABOR_CONTRACT (
ID_COMPANY,
ID_BUSINESS_HOUR
);

/*==============================================================*/
/* Index: CV_IS_PART_LABORCONTRACT_FK                           */
/*==============================================================*/
create  index CV_IS_PART_LABORCONTRACT_FK on LABOR_CONTRACT (
ID_CV,
ID_PERSON
);

/*==============================================================*/
/* Index: JOB_HAS_LABOR_CONTRACT_FK                             */
/*==============================================================*/
create  index JOB_HAS_LABOR_CONTRACT_FK on LABOR_CONTRACT (
ID_JOB
);

/*==============================================================*/
/* Table: LEVELE_DUCATION                                       */
/*==============================================================*/
create table LEVELE_DUCATION (
   ID_LEVELEDUCATION    INT4                 not null,
   NAME_LEVEL           VARCHAR(255)         not null,
   STATUS               BOOL                 not null,
   constraint PK_LEVELE_DUCATION primary key (ID_LEVELEDUCATION)
);

/*==============================================================*/
/* Index: LEVELE_DUCATION_PK                                    */
/*==============================================================*/
create unique index LEVELE_DUCATION_PK on LEVELE_DUCATION (
ID_LEVELEDUCATION
);

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
create table PERSON (
   ID_PERSON            INT8                 not null,
   ID_CATALOG           INT8                 not null,
   FIRST_NAME           VARCHAR(255)         not null,
   MIDDLE_NAME          VARCHAR(255)         null,
   LAST_NAME            VARCHAR(255)         not null,
   SECOND_LAST_NAME     VARCHAR(255)         null,
   DATE_OF_BIRTH        DATE                 not null,
   STATUS_PERSON        BOOL                 not null,
   constraint PK_PERSON primary key (ID_PERSON)
);

/*==============================================================*/
/* Index: PERSON_PK                                             */
/*==============================================================*/
create unique index PERSON_PK on PERSON (
ID_PERSON
);

/*==============================================================*/
/* Index: CATALOG_GENDER_HAS_PERSON_FK                          */
/*==============================================================*/
create  index CATALOG_GENDER_HAS_PERSON_FK on PERSON (
ID_CATALOG
);

/*==============================================================*/
/* Table: PHONE                                                 */
/*==============================================================*/
create table PHONE (
   ID_PHONE             INT8                 not null,
   ID_CATALOG_PHONE     INT8                 not null,
   NUMEBER              VARCHAR(100)         not null,
   STATUS_PHONE         BOOL                 not null,
   constraint PK_PHONE primary key (ID_PHONE)
);

/*==============================================================*/
/* Index: PHONE_PK                                              */
/*==============================================================*/
create unique index PHONE_PK on PHONE (
ID_PHONE
);

/*==============================================================*/
/* Index: CATALOGPHONE_IS_PART_PHONE_FK                         */
/*==============================================================*/
create  index CATALOGPHONE_IS_PART_PHONE_FK on PHONE (
ID_CATALOG_PHONE
);

/*==============================================================*/
/* Table: PROCESS                                               */
/*==============================================================*/
create table PROCESS (
   ID_PROCESS           INT8                 not null,
   ID_PROCESS_ROOT      INT8                 null,
   NAME_PROCESS         VARCHAR(255)         not null,
   DESCRIPTION_PROCESS  VARCHAR(255)         not null,
   STATUS_PROCESS       BOOL                 not null,
   constraint PK_PROCESS primary key (ID_PROCESS)
);

/*==============================================================*/
/* Index: PROCESS_PK                                            */
/*==============================================================*/
create unique index PROCESS_PK on PROCESS (
ID_PROCESS
);

/*==============================================================*/
/* Index: PROCESS_HAS_LEVEL_FK                                  */
/*==============================================================*/
create  index PROCESS_HAS_LEVEL_FK on PROCESS (
ID_PROCESS_ROOT
);

/*==============================================================*/
/* Table: SCHEDULE_WORK                                         */
/*==============================================================*/
create table SCHEDULE_WORK (
   ID_COMPANY           INT8                 not null,
   ID_BUSINESS_HOUR     INT4                 not null,
   STATE_COMPANY_SCHEDULE_WORK BOOL                 not null,
   constraint PK_SCHEDULE_WORK primary key (ID_COMPANY, ID_BUSINESS_HOUR)
);

/*==============================================================*/
/* Index: SCHEDULE_WORK_PK                                      */
/*==============================================================*/
create unique index SCHEDULE_WORK_PK on SCHEDULE_WORK (
ID_COMPANY,
ID_BUSINESS_HOUR
);

/*==============================================================*/
/* Index: BUSIN_HOUR_HAS_SCHED_WORK_FK                          */
/*==============================================================*/
create  index BUSIN_HOUR_HAS_SCHED_WORK_FK on SCHEDULE_WORK (
ID_BUSINESS_HOUR
);

/*==============================================================*/
/* Index: COMPANY_HAS_SCHEDULEWORK_FK                           */
/*==============================================================*/
create  index COMPANY_HAS_SCHEDULEWORK_FK on SCHEDULE_WORK (
ID_COMPANY
);

/*==============================================================*/
/* Table: SUBCOMPANY                                            */
/*==============================================================*/
create table SUBCOMPANY (
   ID_COMPANY           INT8                 not null,
   ID_SUBCOMPANY        INT8                 not null,
   STATUS_SUBCOMPANY    BOOL                 not null,
   constraint PK_SUBCOMPANY primary key (ID_COMPANY, ID_SUBCOMPANY)
);

/*==============================================================*/
/* Index: SUBCOMPANY_PK                                         */
/*==============================================================*/
create unique index SUBCOMPANY_PK on SUBCOMPANY (
ID_COMPANY,
ID_SUBCOMPANY
);

/*==============================================================*/
/* Index: COMPANY_HAS_SUBCOMPANY_FK                             */
/*==============================================================*/
create  index COMPANY_HAS_SUBCOMPANY_FK on SUBCOMPANY (
ID_COMPANY
);

/*==============================================================*/
/* Index: COMPANY_IS_PART_SUBCOMPANY_FK                         */
/*==============================================================*/
create  index COMPANY_IS_PART_SUBCOMPANY_FK on SUBCOMPANY (
ID_SUBCOMPANY
);

/*==============================================================*/
/* Table: SUBPROCESS                                            */
/*==============================================================*/
create table SUBPROCESS (
   ID_SUBPROCESS        INT8                 not null,
   ID_PROCESS           INT8                 not null,
   ID_SUBPROCESS_ROOT   INT8                 null,
   NAME_SUBPROCESS      VARCHAR(255)         not null,
   DESCRIPTION_SUBPROCESS VARCHAR(255)         not null,
   STATUS_SUBPROCESS    BOOL                 not null,
   constraint PK_SUBPROCESS primary key (ID_SUBPROCESS)
);

/*==============================================================*/
/* Index: SUBPROCESS_PK                                         */
/*==============================================================*/
create unique index SUBPROCESS_PK on SUBPROCESS (
ID_SUBPROCESS
);

/*==============================================================*/
/* Index: PROCESS_HAS_SUBPROCESS_FK                             */
/*==============================================================*/
create  index PROCESS_HAS_SUBPROCESS_FK on SUBPROCESS (
ID_PROCESS
);

/*==============================================================*/
/* Index: SUBPROCESS_HAS_LEVEL_FK                               */
/*==============================================================*/
create  index SUBPROCESS_HAS_LEVEL_FK on SUBPROCESS (
ID_SUBPROCESS_ROOT
);

/*==============================================================*/
/* Table: TITLE                                                 */
/*==============================================================*/
create table TITLE (
   ID_DEGREE            INT4                 not null,
   ID_LEVELEDUCATION    INT4                 not null,
   ID_PERSON            INT8                 not null,
   STATUS_TITLE         BOOL                 not null,
   constraint PK_TITLE primary key (ID_DEGREE, ID_LEVELEDUCATION, ID_PERSON)
);

/*==============================================================*/
/* Index: TITLE_PK                                              */
/*==============================================================*/
create unique index TITLE_PK on TITLE (
ID_DEGREE,
ID_LEVELEDUCATION,
ID_PERSON
);

/*==============================================================*/
/* Index: DEGREE_IS_PART_PERSONDEGR_FK                          */
/*==============================================================*/
create  index DEGREE_IS_PART_PERSONDEGR_FK on TITLE (
ID_DEGREE,
ID_LEVELEDUCATION
);

/*==============================================================*/
/* Index: PERSON_HAS_TITLE_FK                                   */
/*==============================================================*/
create  index PERSON_HAS_TITLE_FK on TITLE (
ID_PERSON
);

/*==============================================================*/
/* Table: TYPE_COMPANY                                          */
/*==============================================================*/
create table TYPE_COMPANY (
   ID_TYPECOMPANY       INT4                 not null,
   NAME_TYPECOMPANY     VARCHAR(255)         not null,
   STATUS_TYPECOMPANY   BOOL                 not null,
   constraint PK_TYPE_COMPANY primary key (ID_TYPECOMPANY)
);

/*==============================================================*/
/* Index: TYPE_COMPANY_PK                                       */
/*==============================================================*/
create unique index TYPE_COMPANY_PK on TYPE_COMPANY (
ID_TYPECOMPANY
);

/*==============================================================*/
/* Table: TYPE_DOCUMENT                                         */
/*==============================================================*/
create table TYPE_DOCUMENT (
   ID_TYPE_DOCUEMENT    INT4                 not null,
   NAME_TYPE_DOCUEMENT  VARCHAR(200)         not null,
   STATE_TYPE_DOCUEMENT BOOL                 not null,
   constraint PK_TYPE_DOCUMENT primary key (ID_TYPE_DOCUEMENT)
);

/*==============================================================*/
/* Index: TYPE_DOCUMENT_PK                                      */
/*==============================================================*/
create unique index TYPE_DOCUMENT_PK on TYPE_DOCUMENT (
ID_TYPE_DOCUEMENT
);

alter table ACTIVITY_ECONOMIC_COMPANY
   add constraint FK_ACTIVITY_COMPANY_H_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table CAPACITATION
   add constraint FK_CAPACITA_CV_HAS_CA_CURRICUL foreign key (ID_CV, ID_PERSON)
      references CURRICULUM_VITAE (ID_CV, ID_PERSON)
      on delete restrict on update restrict;

alter table CATALOG
   add constraint FK_CATALOG_GROUPCATA_GROUP_CA foreign key (ID_GROUPCATALOG)
      references GROUP_CATALOG (ID_GROUPCATALOG)
      on delete restrict on update restrict;

alter table COMPANY
   add constraint FK_COMPANY_TYPECOMP__TYPE_COM foreign key (ID_TYPECOMPANY)
      references TYPE_COMPANY (ID_TYPECOMPANY)
      on delete restrict on update restrict;

alter table CONTACT_DATA
   add constraint FK_CONTACT__ADDRESS_I_ADDRESS foreign key (ID_ADDRESS)
      references ADDRESS (ID_ADDRESS)
      on delete restrict on update restrict;

alter table CONTACT_DATA
   add constraint FK_CONTACT__COMPANY_H_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table CONTACT_DATA
   add constraint FK_CONTACT__EMAIL_IS__EMAIL foreign key (ID_EMAIL)
      references EMAIL (ID_EMAIL)
      on delete restrict on update restrict;

alter table CONTACT_DATA
   add constraint FK_CONTACT__PERSON_HA_PERSON foreign key (ID_PERSON)
      references PERSON (ID_PERSON)
      on delete restrict on update restrict;

alter table CONTACT_DATA
   add constraint FK_CONTACT__PHONE_IS__PHONE foreign key (ID_PHONE)
      references PHONE (ID_PHONE)
      on delete restrict on update restrict;

alter table CURRICULUM_VITAE
   add constraint FK_CURRICUL_PERSON_HA_PERSON foreign key (ID_PERSON)
      references PERSON (ID_PERSON)
      on delete restrict on update restrict;

alter table DEGREE
   add constraint FK_DEGREE_LEVELEDUC_LEVELE_D foreign key (ID_LEVELEDUCATION)
      references LEVELE_DUCATION (ID_LEVELEDUCATION)
      on delete restrict on update restrict;

alter table DISABILITY
   add constraint FK_DISABILI_PERSON_HA_PERSON foreign key (ID_PERSON)
      references PERSON (ID_PERSON)
      on delete restrict on update restrict;

alter table DOCUMENT
   add constraint FK_DOCUMENT_COMPANY_H_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table DOCUMENT
   add constraint FK_DOCUMENT_PERSON_HA_PERSON foreign key (ID_PERSON)
      references PERSON (ID_PERSON)
      on delete restrict on update restrict;

alter table DOCUMENT
   add constraint FK_DOCUMENT_TYPEDOC_I_TYPE_DOC foreign key (ID_TYPE_DOCUEMENT)
      references TYPE_DOCUMENT (ID_TYPE_DOCUEMENT)
      on delete restrict on update restrict;

alter table EXPERIENCE
   add constraint FK_EXPERIEN_CV_HAS_EX_CURRICUL foreign key (ID_CV, ID_PERSON)
      references CURRICULUM_VITAE (ID_CV, ID_PERSON)
      on delete restrict on update restrict;

alter table JOB
   add constraint FK_JOB_JOB_HAS_L_JOB foreign key (ID_JOB_ROOT)
      references JOB (ID_JOB)
      on delete restrict on update restrict;

alter table JOB
   add constraint FK_JOB_SUBPROCES_SUBPROCE foreign key (ID_SUBPROCESS)
      references SUBPROCESS (ID_SUBPROCESS)
      on delete restrict on update restrict;

alter table LABOR_CONTRACT
   add constraint FK_LABOR_CO_CV_IS_PAR_CURRICUL foreign key (ID_CV, ID_PERSON)
      references CURRICULUM_VITAE (ID_CV, ID_PERSON)
      on delete restrict on update restrict;

alter table LABOR_CONTRACT
   add constraint FK_LABOR_CO_JOB_HAS_L_JOB foreign key (ID_JOB)
      references JOB (ID_JOB)
      on delete restrict on update restrict;

alter table LABOR_CONTRACT
   add constraint FK_LABOR_CO_SCHEDWORK_SCHEDULE foreign key (ID_COMPANY, ID_BUSINESS_HOUR)
      references SCHEDULE_WORK (ID_COMPANY, ID_BUSINESS_HOUR)
      on delete restrict on update restrict;

alter table PERSON
   add constraint FK_PERSON_CATALOG_G_CATALOG foreign key (ID_CATALOG)
      references CATALOG (ID_CATALOG)
      on delete restrict on update restrict;

alter table PHONE
   add constraint FK_PHONE_CATALOGPH_CATALOG foreign key (ID_CATALOG_PHONE)
      references CATALOG (ID_CATALOG)
      on delete restrict on update restrict;

alter table PROCESS
   add constraint FK_PROCESS_PROCESS_H_PROCESS foreign key (ID_PROCESS_ROOT)
      references PROCESS (ID_PROCESS)
      on delete restrict on update restrict;

alter table SCHEDULE_WORK
   add constraint FK_SCHEDULE_BUSIN_HOU_BUSINESS foreign key (ID_BUSINESS_HOUR)
      references BUSINESS_HOUR (ID_BUSINESS_HOUR)
      on delete restrict on update restrict;

alter table SCHEDULE_WORK
   add constraint FK_SCHEDULE_COMPANY_H_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table SUBCOMPANY
   add constraint FK_SUBCOMPA_COMPANY_H_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table SUBCOMPANY
   add constraint FK_SUBCOMPA_COMPANY_I_COMPANY foreign key (ID_SUBCOMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table SUBPROCESS
   add constraint FK_SUBPROCE_PROCESS_H_PROCESS foreign key (ID_PROCESS)
      references PROCESS (ID_PROCESS)
      on delete restrict on update restrict;

alter table SUBPROCESS
   add constraint FK_SUBPROCE_SUBPROCES_SUBPROCE foreign key (ID_SUBPROCESS_ROOT)
      references SUBPROCESS (ID_SUBPROCESS)
      on delete restrict on update restrict;

alter table TITLE
   add constraint FK_TITLE_DEGREE_IS_DEGREE foreign key (ID_DEGREE, ID_LEVELEDUCATION)
      references DEGREE (ID_DEGREE, ID_LEVELEDUCATION)
      on delete restrict on update restrict;

alter table TITLE
   add constraint FK_TITLE_PERSON_HA_PERSON foreign key (ID_PERSON)
      references PERSON (ID_PERSON)
      on delete restrict on update restrict;

