CREATE TABLE `branch`
(
  `id` int not null auto_increment,
  `branchName` varchar(255),
  primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `player`
(
	`id` int not null auto_increment,
	`firstName` varchar(255),
	`lastName` varchar(255),
	`branchId` int,
	`createdAt` datetime default current_timestamp,
  `updatedAt` datetime on update current_timestamp,
	primary key (id),
	FOREIGN KEY (`branchId`) REFERENCES `branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `playerMatch`
(
	`id` int not null auto_increment,
	`playerOneId` int,
	`playerTwoId` int,
	`playerOneScore` int default 0,
	`playerTwoScore` int default 0,
	`status` ENUM('DONE', 'PENDING', 'CANCELLED') default 'PENDING',
	`createdAt` datetime default current_timestamp,
  primary key (id),
  FOREIGN KEY (`playerOneId`) REFERENCES `player` (`id`),
  FOREIGN KEY (`playerTwoId`) REFERENCES `player` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `playerWin`
(
  `id` int not null auto_increment,
  `matchId` int,
  `winnerId` int,
  `loserId` int,
  `winnerScore` int,
  `loserScore` int,
  `createdAt` datetime default current_timestamp,
  `updatedAt` datetime on update current_timestamp,
  primary key (id),
  FOREIGN KEY (`winnerId`) REFERENCES `player` (`id`),
  FOREIGN KEY (`loserId`) REFERENCES `player` (`id`),
  FOREIGN KEY (`matchId`) REFERENCES `playerMatch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `playerLevel`
(
	`id` int not null auto_increment,
	`playerId` int,
	`wins` int,
	`defeats` int,
	primary key (id),
  FOREIGN KEY (`playerId`) REFERENCES `player` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

