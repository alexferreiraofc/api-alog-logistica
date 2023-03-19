create table delivery(

                         id bigint not null auto_increment,
                         customer_id bigint not null,
                         tax decimal(10,2) not null,
                         status varchar(20) not null,
                         order_date datetime not null,
                         order_delivered datetime,

                         receipient_name varchar (60) not null,
                         receipient_address varchar (255) not null,
                         receipient_number varchar (30) not null,
                         receipient_complement varchar (60) not null,
                         receipient_neighborhood varchar (30) not null,

                         primary key(id)
);

alter table delivery add constraint fk_delivery_receipient
    foreign key (customer_id) references customer(id);