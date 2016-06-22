CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q9npl2ty4pngm2cussiul2qj5` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Enabled` bit(1) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tbpk8dt8cn41jgc3c5cjmulf1` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKej3jidxlte0r8flpavhiso3g6` (`role_id`),
  CONSTRAINT `FK7ov27fyo7ebsvada1ej7qkphl` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKej3jidxlte0r8flpavhiso3g6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
