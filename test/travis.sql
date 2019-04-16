# https://andidittrich.de/2017/06/travisci-setup-mysql-tablesdata-before-running-tests.html
# Create eeviluser
CREATE USER 'eeviluser'@'' IDENTIFIED BY 'eevilchess';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'dev'@'';
# Create DB
CREATE DATABASE IF NOT EXISTS `db_eevilchess` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db_eevilchess`;