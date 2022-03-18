-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 12, 2021 lúc 08:12 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dangkyphonghoc`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thietbi`
--

CREATE TABLE `thietbi` (
  `Maphong` varchar(20) NOT NULL,
  `Mathietbi` varchar(20) NOT NULL,
  `Tenthietbi` text NOT NULL,
  `Tinhtrang` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thietbi`
--

INSERT INTO `thietbi` (`Maphong`, `Mathietbi`, `Tenthietbi`, `Tinhtrang`) VALUES
('abc123', 'abc1231', 'may chieu', 'tot'),
('abc123', 'abc1232', 'loa', 'tot'),
('abc123', 'abc1233', 'mic', 'tot'),
('abc124', 'abc1241', 'loa', 'tot'),
('abc124', 'abc1242', 'may chieu', 'tot'),
('abc124', 'abc1243', 'mic', 'tot'),
('abc125', 'abc1251', 'pc', 'tot'),
('abc125', 'abc1252', 'pc', 'tot'),
('abc125', 'abc1253', 'pc', 'tot'),
('abc125', 'abc1254', 'pc', 'hong'),
('abc125', 'abc1255', 'pc', 'tot');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thoigianphong`
--

CREATE TABLE `thoigianphong` (
  `Maphong` varchar(20) NOT NULL,
  `Thoigian` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thoigianphong`
--

INSERT INTO `thoigianphong` (`Maphong`, `Thoigian`) VALUES
('abc123', 'ca 1'),
('abc123', 'ca 2'),
('abc123', 'ca 3'),
('abc123', 'ca 4'),
('abc123', 'ca 5'),
('abc124', 'ca 1'),
('abc124', 'ca 2'),
('abc124', 'ca 3'),
('abc124', 'ca 4'),
('abc124', 'ca 5'),
('abc125', 'ca 1'),
('abc125', 'ca 2'),
('abc125', 'ca 3'),
('abc125', 'ca 4'),
('abc125', 'ca 5');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinbaocao`
--

CREATE TABLE `thongtinbaocao` (
  `Mabaocao` int(11) NOT NULL,
  `Ngaybaocao` date NOT NULL,
  `Magiaovien` varchar(20) NOT NULL,
  `Maphong` varchar(20) NOT NULL,
  `Thoigian` varchar(20) NOT NULL,
  `Vande` text NOT NULL,
  `Trangthai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtinbaocao`
--

INSERT INTO `thongtinbaocao` (`Mabaocao`, `Ngaybaocao`, `Magiaovien`, `Maphong`, `Thoigian`, `Vande`, `Trangthai`) VALUES
(1, '2021-12-12', 'ABC123', 'abc123', 'ca 1', 'hong mic', 'closed'),
(2, '2021-12-13', 'ABC123', 'abc124', 'ca 2', 'hong may chieu', 'closed');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinnguoidung`
--

CREATE TABLE `thongtinnguoidung` (
  `Magiaovien` varchar(20) NOT NULL,
  `Ten` text NOT NULL,
  `Chucvu` text NOT NULL,
  `Tuoi` int(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtinnguoidung`
--

INSERT INTO `thongtinnguoidung` (`Magiaovien`, `Ten`, `Chucvu`, `Tuoi`, `username`, `password`, `role`) VALUES
('ABC123', 'nguyen van a', 'giao vien toan', 40, 'asd123', 'asd123', 1),
('ABC124', 'nguyen van b', 'giao vien anh', 39, 'qwe123', 'qwe123', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinphong`
--

CREATE TABLE `thongtinphong` (
  `Maphong` varchar(20) NOT NULL,
  `Loaiphong` text NOT NULL,
  `Succhua` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtinphong`
--

INSERT INTO `thongtinphong` (`Maphong`, `Loaiphong`, `Succhua`) VALUES
('abc123', 'ly thuyet', 75),
('abc124', 'ly thuyet', 80),
('abc125', 'thuc hanh tin', 60);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinphongchitiet`
--

CREATE TABLE `thongtinphongchitiet` (
  `Maphong` varchar(20) NOT NULL,
  `Thoigian` varchar(20) NOT NULL,
  `Trangthaiphong` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtinphongchitiet`
--

INSERT INTO `thongtinphongchitiet` (`Maphong`, `Thoigian`, `Trangthaiphong`) VALUES
('abc123', 'ca 1', 'da dang ky'),
('abc123', 'ca 2', 'da dang ky'),
('abc123', 'ca 3', 'san sang'),
('abc123', 'ca 4', 'san sang'),
('abc123', 'ca 5', 'da dang ky'),
('abc124', 'ca 1', 'dang dung'),
('abc124', 'ca 2', 'san sang'),
('abc124', 'ca 3', 'san sang'),
('abc124', 'ca 4', 'san sang'),
('abc124', 'ca 5', 'san sang'),
('abc125', 'ca 1', 'san sang'),
('abc125', 'ca 2', 'san sang'),
('abc125', 'ca 3', 'san sang'),
('abc125', 'ca 4', 'san sang'),
('abc125', 'ca 5', 'san sang');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinphongdadangky`
--

CREATE TABLE `thongtinphongdadangky` (
  `ngay` date NOT NULL,
  `Thoigian` varchar(20) NOT NULL,
  `Magiaovien` varchar(20) NOT NULL,
  `Maphong` varchar(20) NOT NULL,
  `Trangthai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtinphongdadangky`
--

INSERT INTO `thongtinphongdadangky` (`ngay`, `Thoigian`, `Magiaovien`, `Maphong`, `Trangthai`) VALUES
('2021-12-12', 'ca 1', 'ABC123', 'abc123', 'da su dung'),
('2021-12-12', 'ca 2', 'ABC123', 'abc123', 'dang dung'),
('2021-12-12', 'ca 5', 'ABC123', 'abc123', 'san sang'),
('2021-12-13', 'ca 1', 'ABC123', 'abc123', 'da su dung');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  ADD PRIMARY KEY (`Maphong`,`Mathietbi`);

--
-- Chỉ mục cho bảng `thoigianphong`
--
ALTER TABLE `thoigianphong`
  ADD PRIMARY KEY (`Maphong`,`Thoigian`);

--
-- Chỉ mục cho bảng `thongtinbaocao`
--
ALTER TABLE `thongtinbaocao`
  ADD PRIMARY KEY (`Mabaocao`),
  ADD KEY `magiaovien` (`Magiaovien`),
  ADD KEY `maphonghoc` (`Maphong`);

--
-- Chỉ mục cho bảng `thongtinnguoidung`
--
ALTER TABLE `thongtinnguoidung`
  ADD PRIMARY KEY (`Magiaovien`,`username`);

--
-- Chỉ mục cho bảng `thongtinphong`
--
ALTER TABLE `thongtinphong`
  ADD PRIMARY KEY (`Maphong`);

--
-- Chỉ mục cho bảng `thongtinphongchitiet`
--
ALTER TABLE `thongtinphongchitiet`
  ADD PRIMARY KEY (`Maphong`,`Thoigian`);

--
-- Chỉ mục cho bảng `thongtinphongdadangky`
--
ALTER TABLE `thongtinphongdadangky`
  ADD PRIMARY KEY (`ngay`,`Thoigian`,`Magiaovien`,`Maphong`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `thongtinbaocao`
--
ALTER TABLE `thongtinbaocao`
  MODIFY `Mabaocao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `thongtinbaocao`
--
ALTER TABLE `thongtinbaocao`
  ADD CONSTRAINT `magiaovien` FOREIGN KEY (`Magiaovien`) REFERENCES `thongtinnguoidung` (`Magiaovien`),
  ADD CONSTRAINT `maphonghoc` FOREIGN KEY (`Maphong`) REFERENCES `thongtinphong` (`Maphong`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
