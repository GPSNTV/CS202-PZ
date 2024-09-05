-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2024 at 12:50 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs202-pz`
--

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `date` varchar(256) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`date`, `type`) VALUES
('2024-09-05 23:44:32', -1),
('2024-09-05 23:44:38', -1),
('2024-09-05 23:44:40', 1),
('2024-09-05 23:44:42', 2),
('2024-09-06 00:28:57', 0),
('2024-09-06 00:29:21', 1),
('2024-09-06 00:29:22', 1),
('2024-09-06 00:29:25', 0),
('2024-09-06 00:29:27', 2),
('2024-09-06 00:29:29', 3),
('2024-09-06 00:29:33', 0),
('2024-09-06 00:32:37', 0),
('2024-09-06 00:32:45', 3),
('2024-09-06 00:32:47', 0),
('2024-09-06 00:33:10', 0),
('2024-09-06 00:33:22', 0),
('2024-09-06 00:33:38', 0),
('2024-09-06 00:33:40', 1),
('2024-09-06 00:33:43', 0),
('2024-09-06 00:33:44', 1),
('2024-09-06 00:33:45', 2),
('2024-09-06 00:33:47', 3),
('2024-09-06 00:33:50', 1),
('2024-09-06 00:33:51', 2),
('2024-09-06 00:33:52', 1),
('2024-09-06 00:33:54', 2),
('2024-09-06 00:33:58', 0),
('2024-09-06 00:34:00', 1),
('2024-09-06 00:44:03', 0),
('2024-09-06 00:44:06', 2),
('2024-09-06 00:44:08', 0),
('2024-09-06 00:44:10', 1),
('2024-09-06 00:44:12', 3),
('2024-09-06 00:44:15', 2),
('2024-09-06 00:44:17', 0),
('2024-09-06 00:49:08', 0),
('2024-09-06 00:49:10', 2),
('2024-09-06 00:49:12', 0);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `type`) VALUES
(1, 0),
(10, 1),
(11, 0),
(12, 0),
(13, 2),
(14, 1),
(15, 2),
(16, 0),
(17, 2),
(18, 1),
(19, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(11, 'Nikola', '123'),
(12, 'Zvezdan', '1234'),
(13, 'Milan', '1234'),
(14, 'Nadja', '1234'),
(15, 'Masa', '1234'),
(16, 'Luka', '1234'),
(17, 'Mihailo', '1234'),
(18, 'Dalibor', '1234'),
(19, 'Milorad', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
