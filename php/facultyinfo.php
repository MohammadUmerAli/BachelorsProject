<?php

	include_once 'dbconn.php';
?>
<?php

$list = array();

$stmt = $mysqli->prepare("SELECT teacher_name, teacher_qualification, teacher_email, position_held, image_url FROM facultyinfo where department = ?");
$stmt->bind_param("s", $_GET["department"]);
$stmt->execute();
$result = $stmt->get_result();
if($result->num_rows ===0 ) exit('No Rows');
 while ($row = $result->fetch_assoc()) {
$list1 = array(
                'teacher name' =>$row["teacher_name"],
                'teacher qualification' => $row["teacher_qualification"], 
                'teacher email' => $row["teacher_email"], 
                'positionn held' => $row["position_held"], 
                'image url'  => $row["image_url"]);
                array_push($list, $list1);
  }
$stmt->close();

echo(json_encode($list));
?>
