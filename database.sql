CREATE DATABASE  shop_mobile character set UTF8 collate utf8_swedish_ci;
USE shop_mobile
;
CREATE TABLE `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `amount` int NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci ROW_FORMAT=DYNAMIC
;
USE shop_mobile
;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `age` int NOT NULL,
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci ROW_FORMAT=DYNAMIC