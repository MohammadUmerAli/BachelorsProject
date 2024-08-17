<?php

	include_once 'dbconn.php';
?>
<?php

$list = array();

$stmt = $mysqli->prepare("SELECT file_name,file_size,file_url FROM fileinfo where course_type = ? AND course = ? AND semester = ?");
$stmt->bind_param("ssi", $_GET["course_type"], $_GET["course"],$_GET["semester"]);
$stmt->execute();
$result = $stmt->get_result();
if($result->num_rows ===0 ) exit('No Rows');
 while ($row = $result->fetch_assoc()) {
$list1 = array(
                'file name' =>$row["file_name"],
                'size' => $row["file_size"], 
                'url'  => $row["file_url"]);
                array_push($list, $list1);
  }
$stmt->close();

echo(json_encode($list));
?>
