<?php

	include_once 'dbconn.php';
?>
<?php

$list = array();

$stmt = $mysqli->prepare("SELECT course, Eligibility_Criteria FROM courseinfo where course_type = ?");
$stmt->bind_param("s", $_GET["course_type"]);
$stmt->execute();
$result = $stmt->get_result();
if($result->num_rows ===0 ) exit('No Rows');
 while ($row = $result->fetch_assoc()) {
$list1 = array(
                'course' =>$row["course"],
                'Eligibility_Criteria' => $row["Eligibility_Criteria"]);
                array_push($list, $list1);
  }
$stmt->close();

echo(json_encode($list));
?>
