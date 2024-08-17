-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2019 at 10:45 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `college`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `courseinfo`
-- (See below for the actual view)
--
CREATE TABLE `courseinfo` (
`course_type` varchar(30)
,`course` varchar(30)
,`Eligibility_Criteria` varchar(250)
);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `type_id` int(1) NOT NULL,
  `course` varchar(30) NOT NULL,
  `Eligibility_Criteria` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`type_id`, `course`, `Eligibility_Criteria`) VALUES
(3, 'Arabic', ''),
(4, 'B. Com', 'Passed 10+2 class in Commerce Stream Or 45% marks in non-commerce 7 stream or its equivalent on grading scale of respective Boards/ Universities. (40% marks for SC/ST/OBC/PWD candidates).'),
(4, 'B.A', 'Passed 10+2 class in any stream.'),
(4, 'B.Sc. Medical', 'Passed 10+2 class in Science (Medical) with at least 45% marks or its on grading scale of respective boards/universities.(40% marks for SC/ST/OBC/PWD candidates).'),
(4, 'B.Sc. Non-Medical', 'Passed 10+2 class in Science (Non-Medical) with at least 45% marks or its on grading scale of respective boards/universities.(40% marks for SC/ST/OBC/PWD candidates).'),
(4, 'BCA', '10+2 with Mathematics as main subject and at least 45% marks or its equivalent on grading scale of respective Boards/Universities (40% marks for SC/ST/OBC/PWD candidates).'),
(1, 'Commerce', '10+2 in any Stream with at least, 45% marks or its equivalent on Grading Scale of respective Boards/Universities (40% marks for SC/ST/OBC/PWD candidates).'),
(2, 'Economics', '10+2 in any Stream with at least 45% marks or its equivalent on Grading Scale of respective Boards/Universities (40% marks for SC/ST/OBC/PWD candidates).'),
(2, 'English', '10+2 in any Stream with at least 45% marks or its equivalent on Grading Scale of respective Boards/Universities (40% marks for SC/ST/OBC/PWD candidates).'),
(1, 'History', '10+2 in any Stream with at least, 45% marks or its equivalent on Grading Scale of respective Boards/Universities (40% marks for SC/ST/OBC/PWD candidates).'),
(3, 'M.Sc. Geography', 'BA/BSc with Geography as main subject and at least 45% marks or its equivalent on grading scale of respective Boards/Universities (40% marks for SC/ST/OBC/PWD candidates).');

-- --------------------------------------------------------

--
-- Table structure for table `course_type`
--

CREATE TABLE `course_type` (
  `course_type` varchar(30) NOT NULL,
  `type_id` int(1) NOT NULL,
  `semester_count` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_type`
--

INSERT INTO `course_type` (`course_type`, `type_id`, `semester_count`) VALUES
('Honor’s Courses', 1, 6),
('Integrated Courses', 2, 10),
('Postgraduate Courses', 3, 0),
('Undergraduate Courses', 4, 6);

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `department` varchar(30) NOT NULL,
  `department_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`department`, `department_id`) VALUES
('Principal', 1),
('Botany', 2),
('Chemistry', 3),
('Zoology', 4),
('Commerce', 5),
('Computer Application', 6),
('Economics', 7),
('Physics', 8),
('Engineering', 9),
('English', 10),
('Environmental Science', 11),
('Functional English', 12),
('Geography', 13),
('Geology', 14),
('Hindi', 15),
('History', 16),
('Islamic Studies', 17),
('Kashmiri', 18),
('Mathematics', 19),
('Philosophy', 20),
('Education', 21),
('Political Science', 22),
('Psychology', 23),
('PTI', 24),
('Sociology', 25),
('Statistics', 26),
('Tourism', 27),
('Urdu', 28),
('Library', 29),
('Arabic', 30);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `teacher_name` varchar(30) NOT NULL,
  `teacher_qualification` varchar(30) NOT NULL,
  `teacher_email` varchar(50) NOT NULL,
  `position_held` varchar(30) NOT NULL,
  `image_url` varchar(150) NOT NULL,
  `department_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`teacher_name`, `teacher_qualification`, `teacher_email`, `position_held`, `image_url`, `department_id`) VALUES
('Dr. Zahida Akhtar', 'Ph.D', 'affasfsfsdfsf@gmail.com', 'prof', 'http://10.0.2.2/college/Faculty/Arabic/Dr.ZahidaAkhtar/pic.jpeg', 30),
('Dr. Muzaffer Hussain Nadvi', 'Ph.D', 'ajdasdjasjkd@gmail.com', 'HOD', 'http://10.0.2.2/college/Faculty/Arabic/Dr.MuzafferHussainNadvi/pic2.jpeg', 30);

-- --------------------------------------------------------

--
-- Stand-in structure for view `facultyinfo`
-- (See below for the actual view)
--
CREATE TABLE `facultyinfo` (
`department` varchar(30)
,`department_id` int(2)
,`teacher_name` varchar(30)
,`teacher_qualification` varchar(30)
,`teacher_email` varchar(50)
,`position_held` varchar(30)
,`image_url` varchar(150)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `fileinfo`
-- (See below for the actual view)
--
CREATE TABLE `fileinfo` (
`course_type` varchar(30)
,`course` varchar(30)
,`semester` int(2)
,`file_name` varchar(200)
,`file_size` varchar(15)
,`file_url` varchar(200)
);

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `course` varchar(30) NOT NULL,
  `semester` int(2) NOT NULL,
  `syllabus_code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`course`, `semester`, `syllabus_code`) VALUES
('B.A', 1, 'B.A_semester_1'),
('B.A', 2, 'B.A_semester_2'),
('B.A', 3, 'B.A_semester_3'),
('B.A', 4, 'B.A_semester_4'),
('B.A', 5, 'B.A_semester_5'),
('B.A', 6, 'B.A_semester_6'),
('B. Com', 1, 'B.Com_semester_1'),
('B. Com', 2, 'B.Com_semester_2'),
('B. Com', 3, 'B.Com_semester_3'),
('B. Com', 4, 'B.Com_semester_4'),
('B. Com', 5, 'B.Com_semester_5'),
('B. Com', 6, 'B.Com_semester_6'),
('B.Sc. Medical', 1, 'B.Sc. Medical_semester_1'),
('B.Sc. Medical', 2, 'B.Sc. Medical_semester_2'),
('B.Sc. Medical', 3, 'B.Sc. Medical_semester_3'),
('B.Sc. Medical', 4, 'B.Sc. Medical_semester_4'),
('B.Sc. Medical', 5, 'B.Sc. Medical_semester_5'),
('B.Sc. Medical', 6, 'B.Sc. Medical_semester_6'),
('B.Sc. Non-Medical', 1, 'B.Sc. Non-Medical_semester_1'),
('B.Sc. Non-Medical', 2, 'B.Sc. Non-Medical_semester_2'),
('B.Sc. Non-Medical', 3, 'B.Sc. Non-Medical_semester_3'),
('B.Sc. Non-Medical', 4, 'B.Sc. Non-Medical_semester_4'),
('B.Sc. Non-Medical', 5, 'B.Sc. Non-Medical_semester_5'),
('B.Sc. Non-Medical', 6, 'B.Sc. Non-Medical_semester_6'),
('BCA', 1, 'BCA_semester_1'),
('BCA', 2, 'BCA_semester_2'),
('BCA', 3, 'BCA_semester_3'),
('BCA', 4, 'BCA_semester_4'),
('BCA', 5, 'BCA_semester_5'),
('BCA', 6, 'BCA_semester_6'),
('Commerce', 1, 'Commerce_semester_1'),
('Commerce', 2, 'Commerce_semester_2'),
('Commerce', 3, 'Commerce_semester_3'),
('Commerce', 4, 'Commerce_semester_4'),
('Commerce', 5, 'Commerce_semester_5'),
('Commerce', 6, 'Commerce_semester_6'),
('Economics', 1, 'Economics_semester_1'),
('Economics', 10, 'Economics_semester_10'),
('Economics', 2, 'Economics_semester_2'),
('Economics', 3, 'Economics_semester_3'),
('Economics', 4, 'Economics_semester_4'),
('Economics', 5, 'Economics_semester_5'),
('Economics', 6, 'Economics_semester_6'),
('Economics', 7, 'Economics_semester_7'),
('Economics', 8, 'Economics_semester_8'),
('Economics', 9, 'Economics_semester_9'),
('English', 1, 'English_semester_1'),
('English', 10, 'English_semester_10'),
('English', 2, 'English_semester_2'),
('English', 3, 'English_semester_3'),
('English', 4, 'English_semester_4'),
('English', 5, 'English_semester_5'),
('English', 6, 'English_semester_6'),
('English', 7, 'English_semester_7'),
('English', 8, 'English_semester_8'),
('English', 9, 'English_semester_9'),
('History', 1, 'History_semester_1'),
('History', 2, 'History_semester_2'),
('History', 3, 'History_semester_3'),
('History', 4, 'History_semester_4'),
('History', 5, 'History_semester_5'),
('History', 6, 'History_semester_6');

-- --------------------------------------------------------

--
-- Table structure for table `syllabus`
--

CREATE TABLE `syllabus` (
  `syllabus_code` varchar(50) NOT NULL,
  `file_name` varchar(200) NOT NULL,
  `file_size` varchar(15) NOT NULL,
  `file_url` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `syllabus`
--

INSERT INTO `syllabus` (`syllabus_code`, `file_name`, `file_size`, `file_url`) VALUES
('B.A_semester_1', 'Anthropolo_anthropologyIsemconv.pdf', '105.22 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Anthropolo_anthropologyIsemconv.pdf'),
('B.A_semester_1', 'Arabic Discipline Specific Core-I (DSC-I)_Cluster University Srinagar1243.1.pdf', '620.19 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Arabic Discipline Specific Core-I (DSC-I)_Cluster University Srinagar1243.1.pdf'),
('B.A_semester_1', 'Arabic(Mil)_Arabic MIL Sem-1.pdf', '886.07 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Arabic(Mil)_Arabic MIL Sem-1.pdf'),
('B.A_semester_1', 'Communicat_GeneralEnglish1stSemster.pdf', '766.51 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Communicat_GeneralEnglish1stSemster.pdf'),
('B.A_semester_1', 'Descriptiv_Descriptive Statistics ist sem.pdf', '494.05 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Descriptiv_Descriptive Statistics ist sem.pdf'),
('B.A_semester_1', 'Economics_ECONOMICS.pdf', '589.62 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Economics_ECONOMICS.pdf'),
('B.A_semester_1', 'EducationS_EducationalSociology1stSmester.pdf', '315.36 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/EducationS_EducationalSociology1stSmester.pdf'),
('B.A_semester_1', 'Elements of Physical Geography_Geography.pdf', '165.67 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Elements of Physical Geography_Geography.pdf'),
('B.A_semester_1', 'English Li_Syllabus for sem1.pdf', '508.22 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/English Li_Syllabus for sem1.pdf'),
('B.A_semester_1', 'Environmental Studies_AECC-Environment-Studies.pdf', '392.81 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Environmental Studies_AECC-Environment-Studies.pdf'),
('B.A_semester_1', 'Functional English_Functional-English-Syllabus.pdf', '230.66 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Functional English_Functional-English-Syllabus.pdf'),
('B.A_semester_1', 'Geography_Geography ist sem.pdf', '149.26 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Geography_Geography ist sem.pdf'),
('B.A_semester_1', 'GEOLOGY _GEOLOGY.pdf', '87.47 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/GEOLOGY _GEOLOGY.pdf'),
('B.A_semester_1', 'Hindi(Mil)_Hindi-MIL.pdf', '334.61 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Hindi(Mil)_Hindi-MIL.pdf'),
('B.A_semester_1', 'Hindi_Hindi-Core.pdf', '96.42 KB', 'http://10.0.2.2/college/Syllabus/Undergraduate Courses/B.A/Semester 1/Hindi_Hindi-Core.pdf');

-- --------------------------------------------------------

--
-- Structure for view `courseinfo`
--
DROP TABLE IF EXISTS `courseinfo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `courseinfo`  AS  select `course_type`.`course_type` AS `course_type`,`courses`.`course` AS `course`,`courses`.`Eligibility_Criteria` AS `Eligibility_Criteria` from (`courses` join `course_type`) where (`courses`.`type_id` = `course_type`.`type_id`) ;

-- --------------------------------------------------------

--
-- Structure for view `facultyinfo`
--
DROP TABLE IF EXISTS `facultyinfo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `facultyinfo`  AS  select `departments`.`department` AS `department`,`departments`.`department_id` AS `department_id`,`faculty`.`teacher_name` AS `teacher_name`,`faculty`.`teacher_qualification` AS `teacher_qualification`,`faculty`.`teacher_email` AS `teacher_email`,`faculty`.`position_held` AS `position_held`,`faculty`.`image_url` AS `image_url` from (`departments` join `faculty`) where (`departments`.`department_id` = `faculty`.`department_id`) ;

-- --------------------------------------------------------

--
-- Structure for view `fileinfo`
--
DROP TABLE IF EXISTS `fileinfo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fileinfo`  AS  select `course_type`.`course_type` AS `course_type`,`courses`.`course` AS `course`,`semester`.`semester` AS `semester`,`syllabus`.`file_name` AS `file_name`,`syllabus`.`file_size` AS `file_size`,`syllabus`.`file_url` AS `file_url` from (((`course_type` join `courses`) join `semester`) join `syllabus`) where ((`course_type`.`type_id` = `courses`.`type_id`) and (`semester`.`syllabus_code` = `syllabus`.`syllabus_code`) and (`courses`.`course` = `semester`.`course`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD UNIQUE KEY `courses` (`course`),
  ADD KEY `foreign_key1` (`type_id`);

--
-- Indexes for table `course_type`
--
ALTER TABLE `course_type`
  ADD PRIMARY KEY (`course_type`),
  ADD UNIQUE KEY `type_id` (`type_id`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`department`),
  ADD UNIQUE KEY `department_id` (`department_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`teacher_email`),
  ADD KEY `foreign` (`department_id`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD UNIQUE KEY `syllabus_code` (`syllabus_code`),
  ADD KEY `foreign_key2` (`course`);

--
-- Indexes for table `syllabus`
--
ALTER TABLE `syllabus`
  ADD KEY `foreign_key3` (`syllabus_code`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `foreign_key1` FOREIGN KEY (`type_id`) REFERENCES `course_type` (`type_id`);

--
-- Constraints for table `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`);

--
-- Constraints for table `semester`
--
ALTER TABLE `semester`
  ADD CONSTRAINT `foreign_key2` FOREIGN KEY (`course`) REFERENCES `courses` (`course`);

--
-- Constraints for table `syllabus`
--
ALTER TABLE `syllabus`
  ADD CONSTRAINT `foreign_key3` FOREIGN KEY (`syllabus_code`) REFERENCES `semester` (`syllabus_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
