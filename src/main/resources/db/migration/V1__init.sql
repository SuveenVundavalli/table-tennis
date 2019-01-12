CREATE TABLE `branch`
(
  `id` int not null auto_increment,
  `branch` varchar(255),
  primary key (id)
);

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
);

CREATE TABLE `match` 
(
	`id` int not null auto_increment,
	`playerOneId` int,
	`playerTwoId` int,
	`winnerId` int,
	`loserId` int,
	`winnerScore` int,
	`loserScore` int,
	`createdAt` datetime default current_timestamp,
  `updatedAt` datetime on update current_timestamp,
  primary key (id),
  FOREIGN KEY (`playerOneId`) REFERENCES `player` (`id`),
  FOREIGN KEY (`playerTwoId`) REFERENCES `player` (`id`),
  FOREIGN KEY (`winnerId`) REFERENCES `player` (`id`),
  FOREIGN KEY (`loserId`) REFERENCES `player` (`id`)
);

CREATE TABLE `level` 
(
	`id` int not null auto_increment,
	`playerId` int,
	`wins` int,
	`defeats` int,
	primary key (id),
  FOREIGN KEY (`playerId`) REFERENCES `player` (`id`)
);

