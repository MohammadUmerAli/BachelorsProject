<?php

$dbServerName = "localhost";
$dbUsername = "root";
$dbPassword = "";
$dbName = "college";

$mysqli = new mysqli ($dbServerName,$dbUsername,$dbPassword,$dbName);
$mysqli->set_charset("utf8mb4");
?>