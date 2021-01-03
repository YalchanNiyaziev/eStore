create table if not exists products(
        id UUID primary key unique not null default uuid_generate_v4(),
        name varchar(256) not null,
        category_id UUID REFERENCES categories not null,
        price decimal not null,
        manufacturer varchar(256) not null,
        product_count int not null,
        made_in varchar (256),
        description text
);
create table if not exists product_pictures(
    pictures text not null,
    product_id UUID REFERENCES products not null
);
create table if not exists product_custom_specifications(
    custom_specifications varchar(256) not null,
    custom_specifications_key varchar(256) not null,
    product_id UUID REFERENCES products not null
);
