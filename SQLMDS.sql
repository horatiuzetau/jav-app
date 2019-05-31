#Tabel de categorii
create table mds.categorii(
	nume varchar(30) primary key
);

#Tabel de roluri
create table mds.user_roles(
	nume varchar(30) primary key
);

#Inseram rolurile in tabel
insert into mds.user_roles values('USER'),( 'ADMIN'),( 'VIP');

#Tabel de useri
create table mds.useri(
	id_user int primary key auto_increment,
    nume varchar(30) not null default 'NoName',
    prenume varchar(30) not null default 'NoName',
    telefon varchar(30),
    parola varchar(128) not null,
    username varchar(30) not null,
    oras varchar(30) not null,
    data_inscriere timestamp not null default CURRENT_TIMESTAMP
);

#Bagam in tabel de useri coloana FK pentru roluri
alter table mds.useri
add rol varchar(30) not null default 'USER',
add foreign key (rol) references mds.user_roles(nume);


#Tabel anunturi
create table mds.anunturi(
	id_anunt int primary key auto_increment,
    id_user int not null,
    foreign key (id_user) references mds.useri(id_user),
    descriere varchar(300),
    titlu varchar(30) not null,
    pret_inceput float not null,
    pret_actual float not null,
    data_incepere timestamp not null default current_timestamp,
    data_sfarsit timestamp not null,
    activ boolean not null default True,
    id_user_top_bid int,
    foreign key(id_user_top_bid) references mds.useri(id_user)
);

#Tabel checkout
create table mds.checkout(
	id_checkout int primary key auto_increment,
    id_anunt int not null,
    foreign key(id_anunt) references mds.anunturi(id_anunt),
    id_vanzator int not null,
    foreign key(id_vanzator) references mds.useri(id_user),
    id_cumparator int not null,
    foreign key(id_cumparator) references mds.useri(id_user),
    data_checkout timestamp not null default current_timestamp,
    pret float not null,
    oras varchar(30) not null
);

#Gata!