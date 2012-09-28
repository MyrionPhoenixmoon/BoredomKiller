-- BoredomKiller Database V0.2
--
-- Warning:  This .sql file has not been tested yet.
--
-- Author: Patrick Manser
-- --------------------------------------------------
-- ----------------- Change log ---------------------
-- --------------------------------------------------
-- 28.09.12 - V0.2 - Changed some primary keys to foreign keys (pm)
-- 28.09.12 - V0.1 - Added the create database command (pm)
-- 28.09.12 - V0.1 - Added relations (pm)
-- 28.09.12 - V0.1 - Created all main tables (pm)

-- Drop database and then create it
drop database if exists boredomkiller;
create database if not exists boredomkiller;


-- Statistics table
create table if not exists tbl_statistics (
    id int not null auto_increment,
    times_played int,
    total_playtime int,
    primary key (id)
);

-- Platforms table
create table if not exists tbl_platforms (
    id int not null auto_increment,
    name varchar(45) not null,
    primary key (id)
);

-- Playstyles table (game modes e.g. Singleplayer, Co-op, Versus)
create table if not exists tbl_playstyles (
    id int not null auto_increment,
    name varchar(45) not null,
    primary key (id)
);

-- Game Types table
create table if not exists tbl_game_types (
    id int not null auto_increment,
    name varchar(50) not null,
    primary key (id)
);

-- Maluses table
create table if not exists tbl_maluses (
    id int not null auto_increment,
    name varchar(50) not null,
    description text not null,
    rating varchar(45) not null,
    primary key (id)
);

-- Players table
create table if not exists tbl_players (
    id int not null auto_increment,
    name varchar(20) not null,
    id_statistic int,
    primary key (id),
    foreign key (id_statistic) references tbl_statistics (id)
);

-- Games table
create table if not exists tbl_games (
    id int not null auto_increment,
    name varchar(100) not null,
    min_players int not null,
    max_players int not null,
    theme_loc varchar(200),
    id_statistic int not null,
    id_platform int not null,
    primary key (id),
    foreign key (id_statistic) references tbl_statistics (id),
    foreign key (id_platform) references tbl_platforms (id)
);

-- Difficulties table
create table if not exists tbl_difficulties (
    id int not null auto_increment,
    difficulty varchar(30) not null,
    primary key (id)
);

-- Challenges table
create table if not exists tbl_challenges (
    id int not null auto_increment,
    name varchar(50) not null,
    description text not null,
    id_difficulty int not null,
    id_statistic int not null,
    id_game_type int,
    id_game int,
    primary key (id),
    foreign key (id_difficulty) references tbl_difficulties (id),
    foreign key (id_statistic) references tbl_statistics (id),
    foreign key (id_game_type) references tbl_game_types (id),
    foreign key (id_game) references tbl_games (id)
);

-- Modes table
create table if not exists tbl_modes (
    id int not null auto_increment,
    name varchar(50) not null,
    id_game int not null,
    primary key (id),
    foreign key (id_game) references tbl_games (id)
);

-- Maps table
create table if not exists tbl_maps (
    id int not null auto_increment,
    name varchar(50) not null,
    id_game int not null,
    primary key (id),
    foreign key (id_game) references tbl_games (id)
);

-- Relation Map - Playstyle
create table if not exists tbl_map_has_playstyle (
    id_map int not null,
    id_playstyle not null,
    primary key (id_map, id_playstyle)
);

-- Relation Mode - Playstyle
create table if not exists tbl_mode_has_playstyle (
    id_mode int not null,
    id_playstyle int not null,
    primary key (id_mode, id_playstyle)
);

-- Relation Game - Playstyle
create table if not exists tbl_game_has_playstyle (
    id_game int not null,
    id_playstyle int not null,
    primary key (id_game, id_playstyle)
);

-- Relation Game - Game type
create table if not exists tbl_game_has_game_type (
    id_game int not null,
    id_game_type int not null,
    primary key (id_game, id_game_type)
);

-- Relation Challenge - Playstyle
create table if not exists tbl_challenge_has_playstyle (
    id_challenge int not null,
    id_playstyle int not null,
    primary key (id_challenge, id_playstyle)
);
