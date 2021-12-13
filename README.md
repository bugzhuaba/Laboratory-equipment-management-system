# 实验室设备管理系统

## 项目目的

运用Java语言，基于MVC架构，编写实验室设备管理系统，实现对实验室和实验设备的管理

## 项目环境

- jdk版本：jdk-11.0.8

- mysql版本：mysql-8.0.24

- jar包：mysql-connector-java-8.0.25.jar

## 项目开发平台

- IntelliJ IDEA

- SQLyog-64bit

## 项目内容介绍

​     学校的实验室需要建立设备管理系统对实验室设备的使用情况进行统计，该系统的用户为实验室管理人员，同时他也是系统管理员，系统主要功能如下：

- 设备入库管理：管理员对新增加的设备进行登记，包括类别、设备名、型号、规格、单
  价、数量、购置日期、生产厂家、购买人等。当同一品牌与型号的设备入库时，要记录
  设备入库的批次信息。
- 设备运行状况统计：可按照设备名称、机房名称以及日期等统计实验室设备运行状况。
  该功能主要是为了使用户能够实时掌握学校实验室设备的运行状况，主要操作是查询和统计，所以数据以只读形式出现。
- 报修设备管理：对于有严重问题（故障）的需要修理的设备，记录修理日期、设备名、修理厂家、修理费、责任人等，随时对设备修理情况进行统计，并能够按类别、修理厂家和修理日期查询设备修理情况。
- 报废设备管理功能：对已经彻底损坏的设备作报废处理，详细记录报废设备的有关信息，并随时对设备报废情况进行统计和查询，要求能够按类别和时间（年、月或季度）查询。

---

# Laboratory Equipment Management System

##  Project Purpose

The laboratory equipment management system is written to realize the management of laboratory and experimental equipment that using java language and MVC architecture.

##  Project Environment

- jdk-version:  jdk-11.0.8
- mysql-version:  mysql-8.0.24
- jar package:  mysql-connector-java-8.0.25.jar

## Project Development Platform

- IntelliJ IDEA

- SQLyog-64bit

## Project  Introduction

The laboratory of the university needs to establish an equipment management system to make statistics on the use of laboratory equipment. The user of the system is the laboratory manager, who is also the system administrator. The main functions of the system are as follows:

- Equipment warehousing management: the administrator registers the newly added equipment, including category, equipment name, model, specification and list
  Price, quantity, purchase date, manufacturer, purchaser, etc. When the equipment of the same brand and model is warehoused, it shall be recorded
  Batch information of equipment receipt.
- Equipment operation status statistics: the operation status of laboratory equipment can be counted according to equipment name, machine room name and date.
  This function is mainly to enable users to master the operation status of school laboratory equipment in real time. The main operation is query and statistics, so the data appears in read-only form.
- Management of equipment for repair: for the equipment that needs to be repaired with serious problems (faults), record the repair date, equipment name, repair manufacturer, repair cost, responsible person, etc., make statistics on the equipment repair situation at any time, and be able to query the equipment repair situation by category, repair manufacturer and repair date.
- Scrapped equipment management function: scrap the completely damaged equipment, record the relevant information of scrapped equipment in detail, and make statistics and query on the scrapped equipment at any time. It is required to query by category and time (year, month or quarter).





