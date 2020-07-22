SELECT 'Upgrading MetaStore schema from 2.3.0 to 3.0.0' AS MESSAGE;

-- SOURCE 041-HIVE-16556.mysql.sql;
--
-- Table structure for table METASTORE_DB_PROPERTIES
--
CREATE TABLE IF NOT EXISTS `METASTORE_DB_PROPERTIES` (
  `PROPERTY_KEY` varchar(255) NOT NULL,
  `PROPERTY_VALUE` varchar(1000) NOT NULL,
  `DESCRIPTION` varchar(1000),
 PRIMARY KEY(`PROPERTY_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- SOURCE 042-HIVE-16575.mysql.sql;
CREATE INDEX `CONSTRAINTS_CONSTRAINT_TYPE_INDEX` ON KEY_CONSTRAINTS (`CONSTRAINT_TYPE`) USING BTREE;

-- SOURCE 043-HIVE-16922.mysql.sql;
UPDATE SERDE_PARAMS
SET PARAM_KEY='collection.delim'
WHERE PARAM_KEY='colelction.delim';

-- SOURCE 044-HIVE-16997.mysql.sql;
ALTER TABLE PART_COL_STATS ADD COLUMN BIT_VECTOR BLOB;
ALTER TABLE TAB_COL_STATS ADD COLUMN BIT_VECTOR BLOB;

-- SOURCE 045-HIVE-16886.mysql.sql;
INSERT INTO `NOTIFICATION_SEQUENCE` (`NNI_ID`, `NEXT_EVENT_ID`) SELECT * from (select 1 as `NNI_ID`, 1 as `NOTIFICATION_SEQUENCE`) a WHERE (SELECT COUNT(*) FROM `NOTIFICATION_SEQUENCE`) = 0;

-- SOURCE 046-HIVE-17566.mysql.sql;
CREATE TABLE IF NOT EXISTS WM_RESOURCEPLAN (
    `RP_ID` bigint(20) NOT NULL,
    `NAME` varchar(128) NOT NULL,
    `QUERY_PARALLELISM` int(11),
    `STATUS` varchar(20) NOT NULL,
    `DEFAULT_POOL_ID` bigint(20),
    PRIMARY KEY (`RP_ID`),
    UNIQUE KEY `UNIQUE_WM_RESOURCEPLAN` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS WM_POOL
(
    `POOL_ID` bigint(20) NOT NULL,
    `RP_ID` bigint(20) NOT NULL,
    `PATH` varchar(767) NOT NULL,
    `ALLOC_FRACTION` DOUBLE,
    `QUERY_PARALLELISM` int(11),
    `SCHEDULING_POLICY` varchar(767),
    PRIMARY KEY (`POOL_ID`),
    UNIQUE KEY `UNIQUE_WM_POOL` (`RP_ID`, `PATH`),
    CONSTRAINT `WM_POOL_FK1` FOREIGN KEY (`RP_ID`) REFERENCES `WM_RESOURCEPLAN` (`RP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `WM_RESOURCEPLAN` ADD CONSTRAINT `WM_RESOURCEPLAN_FK1` FOREIGN KEY (`DEFAULT_POOL_ID`) REFERENCES `WM_POOL`(`POOL_ID`);

CREATE TABLE IF NOT EXISTS WM_TRIGGER
(
    `TRIGGER_ID` bigint(20) NOT NULL,
    `RP_ID` bigint(20) NOT NULL,
    `NAME` varchar(128) NOT NULL,
    `TRIGGER_EXPRESSION` varchar(1024),
    `ACTION_EXPRESSION` varchar(1024),
    `IS_IN_UNMANAGED` bit(1) NOT NULL DEFAULT 0,
    PRIMARY KEY (`TRIGGER_ID`),
    UNIQUE KEY `UNIQUE_WM_TRIGGER` (`RP_ID`, `NAME`),
    CONSTRAINT `WM_TRIGGER_FK1` FOREIGN KEY (`RP_ID`) REFERENCES `WM_RESOURCEPLAN` (`RP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS WM_POOL_TO_TRIGGER
(
    `POOL_ID` bigint(20) NOT NULL,
    `TRIGGER_ID` bigint(20) NOT NULL,
    PRIMARY KEY (`POOL_ID`, `TRIGGER_ID`),
    CONSTRAINT `WM_POOL_TO_TRIGGER_FK1` FOREIGN KEY (`POOL_ID`) REFERENCES `WM_POOL` (`POOL_ID`),
    CONSTRAINT `WM_POOL_TO_TRIGGER_FK2` FOREIGN KEY (`TRIGGER_ID`) REFERENCES `WM_TRIGGER` (`TRIGGER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS WM_MAPPING
(
    `MAPPING_ID` bigint(20) NOT NULL,
    `RP_ID` bigint(20) NOT NULL,
    `ENTITY_TYPE` varchar(128) NOT NULL,
    `ENTITY_NAME` varchar(128) NOT NULL,
    `POOL_ID` bigint(20),
    `ORDERING` int,
    PRIMARY KEY (`MAPPING_ID`),
    UNIQUE KEY `UNIQUE_WM_MAPPING` (`RP_ID`, `ENTITY_TYPE`, `ENTITY_NAME`),
    CONSTRAINT `WM_MAPPING_FK1` FOREIGN KEY (`RP_ID`) REFERENCES `WM_RESOURCEPLAN` (`RP_ID`),
    CONSTRAINT `WM_MAPPING_FK2` FOREIGN KEY (`POOL_ID`) REFERENCES `WM_POOL` (`POOL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Upgrades for Schema Registry objects
ALTER TABLE `SERDES` ADD COLUMN `DESCRIPTION` VARCHAR(4000);
ALTER TABLE `SERDES` ADD COLUMN `SERIALIZER_CLASS` VARCHAR(4000);
ALTER TABLE `SERDES` ADD COLUMN `DESERIALIZER_CLASS` VARCHAR(4000);
ALTER TABLE `SERDES` ADD COLUMN `SERDE_TYPE` INTEGER;

CREATE TABLE `I_SCHEMA` (
  `SCHEMA_ID` BIGINT PRIMARY KEY,
  `SCHEMA_TYPE` INTEGER NOT NULL,
  `NAME` VARCHAR(256),
  `DB_ID` BIGINT,
  `COMPATIBILITY` INTEGER NOT NULL,
  `VALIDATION_LEVEL` INTEGER NOT NULL,
  `CAN_EVOLVE` bit(1) NOT NULL,
  `SCHEMA_GROUP` VARCHAR(256),
  `DESCRIPTION` VARCHAR(4000),
  FOREIGN KEY (`DB_ID`) REFERENCES `DBS` (`DB_ID`),
  KEY `UNIQUE_NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `SCHEMA_VERSION` (
  `SCHEMA_VERSION_ID` bigint primary key,
  `SCHEMA_ID` BIGINT,
  `VERSION` INTEGER NOT NULL,
  `CREATED_AT` BIGINT NOT NULL,
  `CD_ID` BIGINT, 
  `STATE` INTEGER NOT NULL,
  `DESCRIPTION` VARCHAR(4000),
  `SCHEMA_TEXT` mediumtext,
  `FINGERPRINT` VARCHAR(256),
  `SCHEMA_VERSION_NAME` VARCHAR(256),
  `SERDE_ID` bigint, 
  FOREIGN KEY (`SCHEMA_ID`) REFERENCES `I_SCHEMA` (`SCHEMA_ID`),
  FOREIGN KEY (`CD_ID`) REFERENCES `CDS` (`CD_ID`),
  FOREIGN KEY (`SERDE_ID`) REFERENCES `SERDES` (`SERDE_ID`),
  KEY `UNIQUE_VERSION` (`SCHEMA_ID`, `VERSION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 048-HIVE-14498
CREATE TABLE IF NOT EXISTS `MV_CREATION_METADATA` (
  `MV_CREATION_METADATA_ID` bigint(20) NOT NULL,
  `CAT_NAME` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `DB_NAME` varchar(128) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `TBL_NAME` varchar(256) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `TXN_LIST` TEXT DEFAULT NULL,
  PRIMARY KEY (`MV_CREATION_METADATA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE INDEX MV_UNIQUE_TABLE ON MV_CREATION_METADATA (TBL_NAME, DB_NAME) USING BTREE;

CREATE TABLE IF NOT EXISTS `MV_TABLES_USED` (
  `MV_CREATION_METADATA_ID` bigint(20) NOT NULL,
  `TBL_ID` bigint(20) NOT NULL,
  CONSTRAINT `MV_TABLES_USED_FK1` FOREIGN KEY (`MV_CREATION_METADATA_ID`) REFERENCES `MV_CREATION_METADATA` (`MV_CREATION_METADATA_ID`),
  CONSTRAINT `MV_TABLES_USED_FK2` FOREIGN KEY (`TBL_ID`) REFERENCES `TBLS` (`TBL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `COMPLETED_TXN_COMPONENTS` ADD `CTC_TIMESTAMP` timestamp;

UPDATE `COMPLETED_TXN_COMPONENTS` SET `CTC_TIMESTAMP` = CURRENT_TIMESTAMP;

ALTER TABLE `COMPLETED_TXN_COMPONENTS` MODIFY COLUMN `CTC_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP;

CREATE INDEX COMPLETED_TXN_COMPONENTS_IDX ON COMPLETED_TXN_COMPONENTS (CTC_DATABASE, CTC_TABLE, CTC_PARTITION) USING BTREE;

-- 049-HIVE-18489.mysql.sql
UPDATE FUNC_RU
  SET RESOURCE_URI = CONCAT('s3a', SUBSTR(RESOURCE_URI, 4, LENGTH(RESOURCE_URI)))
  WHERE RESOURCE_URI LIKE 's3n://%' ;

UPDATE SKEWED_COL_VALUE_LOC_MAP
  SET LOCATION = CONCAT('s3a', SUBSTR(LOCATION, 4, LENGTH(LOCATION)))
  WHERE LOCATION LIKE 's3n://%' ;

UPDATE SDS
  SET LOCATION = CONCAT('s3a', SUBSTR(LOCATION, 4, LENGTH(LOCATION)))
  WHERE LOCATION LIKE 's3n://%' ;

UPDATE DBS
  SET DB_LOCATION_URI = CONCAT('s3a', SUBSTR(DB_LOCATION_URI, 4, LENGTH(DB_LOCATION_URI)))
  WHERE DB_LOCATION_URI LIKE 's3n://%' ;

-- HIVE-18192
CREATE TABLE TXN_TO_WRITE_ID (
  T2W_TXNID bigint NOT NULL,
  T2W_DATABASE varchar(128) NOT NULL,
  T2W_TABLE varchar(256) NOT NULL,
  T2W_WRITEID bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE UNIQUE INDEX TBL_TO_TXN_ID_IDX ON TXN_TO_WRITE_ID (T2W_DATABASE, T2W_TABLE, T2W_TXNID);
CREATE UNIQUE INDEX TBL_TO_WRITE_ID_IDX ON TXN_TO_WRITE_ID (T2W_DATABASE, T2W_TABLE, T2W_WRITEID);

CREATE TABLE NEXT_WRITE_ID (
  NWI_DATABASE varchar(128) NOT NULL,
  NWI_TABLE varchar(256) NOT NULL,
  NWI_NEXT bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE UNIQUE INDEX NEXT_WRITE_ID_IDX ON NEXT_WRITE_ID (NWI_DATABASE, NWI_TABLE);

ALTER TABLE COMPACTION_QUEUE CHANGE `CQ_HIGHEST_TXN_ID` `CQ_HIGHEST_WRITE_ID` bigint;

ALTER TABLE COMPLETED_COMPACTIONS CHANGE `CC_HIGHEST_TXN_ID` `CC_HIGHEST_WRITE_ID` bigint;

-- Modify txn_components/completed_txn_components tables to add write id.
ALTER TABLE TXN_COMPONENTS ADD TC_WRITEID bigint;
ALTER TABLE COMPLETED_TXN_COMPONENTS ADD CTC_WRITEID bigint;

-- HIVE-18726
-- add a new column to support default value for DEFAULT constraint
ALTER TABLE `KEY_CONSTRAINTS` ADD COLUMN `DEFAULT_VALUE` VARCHAR(400);

ALTER TABLE `KEY_CONSTRAINTS` CHANGE COLUMN `PARENT_CD_ID` `PARENT_CD_ID` bigint NULL;

ALTER TABLE `HIVE_LOCKS` CHANGE COLUMN `HL_TXNID` `HL_TXNID` bigint NOT NULL;

CREATE TABLE REPL_TXN_MAP (
  RTM_REPL_POLICY varchar(256) NOT NULL,
  RTM_SRC_TXN_ID bigint NOT NULL,
  RTM_TARGET_TXN_ID bigint NOT NULL,
  PRIMARY KEY (RTM_REPL_POLICY, RTM_SRC_TXN_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- HIVE-18755, add catalogs
-- new catalogs table
CREATE TABLE `CTLGS` (
    `CTLG_ID` BIGINT PRIMARY KEY,
    `NAME` VARCHAR(256),
    `DESC` VARCHAR(4000),
    `LOCATION_URI` VARCHAR(4000) NOT NULL,
    UNIQUE KEY `UNIQUE_CATALOG` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Insert a default value.  The location is TBD.  Hive will fix this when it starts
INSERT INTO `CTLGS` VALUES (1, 'hive', 'Default catalog for Hive', 'TBD');

-- Drop the unique index on DBS
ALTER TABLE `DBS` DROP KEY `UNIQUE_DATABASE`;

-- Add the new column to the DBS table, can't put in the not null constraint yet
ALTER TABLE `DBS` ADD COLUMN `CTLG_NAME` VARCHAR(256);

-- Update all records in the DBS table to point to the Hive catalog
UPDATE `DBS` 
  SET `CTLG_NAME` = 'hive';

-- Add the not null constraint and default value
ALTER TABLE `DBS` CHANGE COLUMN `CTLG_NAME` `CTLG_NAME` varchar(256) NOT NULL DEFAULT 'hive';

-- Put back the unique index 
ALTER TABLE `DBS` ADD UNIQUE KEY `UNIQUE_DATABASE` (`NAME`, `CTLG_NAME`);

-- Add the foreign key
ALTER TABLE `DBS` ADD CONSTRAINT `CTLG_FK1` FOREIGN KEY (`CTLG_NAME`) REFERENCES `CTLGS` (`NAME`);

-- Add columns to table stats and part stats
ALTER TABLE `TAB_COL_STATS` ADD COLUMN `CAT_NAME` varchar(256);
ALTER TABLE `PART_COL_STATS` ADD COLUMN `CAT_NAME` varchar(256);

-- Set the existing column names to Hive
UPDATE `TAB_COL_STATS`
  SET `CAT_NAME` = 'hive';
UPDATE `PART_COL_STATS`
  SET `CAT_NAME` = 'hive';

-- Add the not null constraint
ALTER TABLE `TAB_COL_STATS` CHANGE COLUMN `CAT_NAME` `CAT_NAME` varchar(256) NOT NULL;
ALTER TABLE `PART_COL_STATS` CHANGE COLUMN `CAT_NAME` `CAT_NAME` varchar(256) NOT NULL;

-- Rebuild the index for Part col stats.  No such index for table stats, which seems weird
DROP INDEX `PCS_STATS_IDX` ON `PART_COL_STATS`;
CREATE INDEX `PCS_STATS_IDX` ON `PART_COL_STATS` (`CAT_NAME`, `DB_NAME`, `TABLE_NAME`, `COLUMN_NAME`, `PARTITION_NAME`);

-- Add column to partition events
ALTER TABLE `PARTITION_EVENTS` ADD COLUMN `CAT_NAME` varchar(256);
UPDATE `PARTITION_EVENTS`
  SET `CAT_NAME` = 'hive' WHERE `DB_NAME` IS NOT NULL;

-- Add column to notification log
ALTER TABLE `NOTIFICATION_LOG` ADD COLUMN `CAT_NAME` varchar(256);
UPDATE `NOTIFICATION_LOG`
  SET `CAT_NAME` = 'hive' WHERE `DB_NAME` IS NOT NULL;

INSERT INTO `SEQUENCE_TABLE` (`SEQUENCE_NAME`, `NEXT_VAL`) SELECT * from (select 'org.apache.hadoop.hive.metastore.model.MNotificationLog' as `SEQUENCE_NAME`, 1 as `NEXT_VAL`) a WHERE (SELECT COUNT(*) FROM `SEQUENCE_TABLE` where SEQUENCE_NAME = 'org.apache.hadoop.hive.metastore.model.MNotificationLog') = 0;

-- HIVE-18747
CREATE TABLE MIN_HISTORY_LEVEL (
  MHL_TXNID bigint NOT NULL,
  MHL_MIN_OPEN_TXNID bigint NOT NULL,
  PRIMARY KEY(MHL_TXNID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE INDEX MIN_HISTORY_LEVEL_IDX ON MIN_HISTORY_LEVEL (MHL_MIN_OPEN_TXNID);

CREATE TABLE RUNTIME_STATS (
  RS_ID bigint primary key,
  CREATE_TIME bigint NOT NULL,
  WEIGHT bigint NOT NULL,
  PAYLOAD blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE INDEX IDX_RUNTIME_STATS_CREATE_TIME ON RUNTIME_STATS(CREATE_TIME);

-- HIVE-18193
-- Populate NEXT_WRITE_ID for each Transactional table and set next write ID same as next txn ID
INSERT INTO NEXT_WRITE_ID (NWI_DATABASE, NWI_TABLE, NWI_NEXT)
    SELECT * FROM
        (SELECT DB.NAME, TBL_INFO.TBL_NAME FROM DBS DB,
            (SELECT TBL.DB_ID, TBL.TBL_NAME FROM TBLS TBL,
                (SELECT TBL_ID FROM TABLE_PARAMS WHERE PARAM_KEY='transactional' AND PARAM_VALUE='true') TBL_PARAM
            WHERE TBL.TBL_ID=TBL_PARAM.TBL_ID) TBL_INFO
        where DB.DB_ID=TBL_INFO.DB_ID) DB_TBL_NAME,
        (SELECT NTXN_NEXT FROM NEXT_TXN_ID) NEXT_WRITE;

-- Populate TXN_TO_WRITE_ID for each aborted/open txns and set write ID equal to txn ID
INSERT INTO TXN_TO_WRITE_ID (T2W_DATABASE, T2W_TABLE, T2W_TXNID, T2W_WRITEID)
    SELECT * FROM
        (SELECT DB.NAME, TBL_INFO.TBL_NAME FROM DBS DB,
            (SELECT TBL.DB_ID, TBL.TBL_NAME FROM TBLS TBL,
                (SELECT TBL_ID FROM TABLE_PARAMS WHERE PARAM_KEY='transactional' AND PARAM_VALUE='true') TBL_PARAM
            WHERE TBL.TBL_ID=TBL_PARAM.TBL_ID) TBL_INFO
        where DB.DB_ID=TBL_INFO.DB_ID) DB_TBL_NAME,
        (SELECT TXN_ID, TXN_ID as WRITE_ID FROM TXNS) TXN_INFO;

-- Update TXN_COMPONENTS and COMPLETED_TXN_COMPONENTS for write ID which is same as txn ID
UPDATE TXN_COMPONENTS SET TC_WRITEID = TC_TXNID;
UPDATE COMPLETED_TXN_COMPONENTS SET CTC_WRITEID = CTC_TXNID;

ALTER TABLE TXN_COMPONENTS MODIFY COLUMN TC_TABLE varchar(128) NULL;

ALTER TABLE `TBLS` ADD COLUMN `OWNER_TYPE` VARCHAR(10) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL;

-- These lines need to be last.  Insert any changes above.
UPDATE VERSION SET SCHEMA_VERSION='3.0.0', VERSION_COMMENT='Hive release version 3.0.0' where VER_ID=1;
SELECT 'Finished upgrading MetaStore schema from 2.3.0 to 3.0.0' AS MESSAGE;
