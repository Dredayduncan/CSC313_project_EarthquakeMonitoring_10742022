create database Galamsey_data;

use Galamsey_data;

create table Observatory(
	obs_name varchar(255) not null,
    country varchar(255),
    area_in_sqkm decimal,
    startYear smallint not null,
    averageColValue decimal,
    primary key (obs_name)
);

create table Galamsey(
	veg_color enum("GREEN", "'YELLOW", "BROWN"),
    col_value tinyint not null,
    longitude decimal,
    latitude decimal,
    year smallint not null,
    obs_name varchar(255),
    foreign key (obs_name) references Observatory(obs_name)
    
);


    
