create extension if not exists "uuid-ossp";

create table if not exists categories(
    id              UUID            primary key unique not null default uuid_generate_v4(),
    category_name   varchar(256)    unique not null,
    accessible      boolean         not null
);

insert into categories( category_name, accessible) values ('smart-phones', true);
insert into categories(category_name, accessible) values ('smart-phone-cases', true);
insert into categories(category_name, accessible) values ('smart-phone-protectors', true);
insert into categories(category_name, accessible) values ('smart-phone-chargers', true);
insert into categories(category_name, accessible) values ('smart-phone-cables', true);
insert into categories(category_name, accessible) values ('smart-phone-powerbank', true);
insert into categories(category_name, accessible) values ('smart-phone-other-accessories', true);
insert into categories(category_name, accessible) values ('tablets', true);
insert into categories(category_name, accessible) values ('tablet-cases', true);
insert into categories(category_name, accessible) values ('tablet-charges', true);
insert into categories(category_name, accessible) values ('tablet-cables', true);
insert into categories(category_name, accessible) values ('tablet-other-accessories', true);
insert into categories(category_name, accessible) values ('laptops', true);
insert into categories(category_name, accessible) values ('laptop-bags', true);
insert into categories(category_name, accessible) values ('laptop-cables', true);
insert into categories(category_name, accessible) values ('laptop-battery', true);
insert into categories(category_name, accessible) values ('laptop-other-accessories', true);
insert into categories(category_name, accessible) values ('computers', true);
insert into categories(category_name, accessible) values ('processors', true);
insert into categories(category_name, accessible) values ('video-cards', true);
insert into categories(category_name, accessible) values ('motherboards', true);
insert into categories(category_name, accessible) values ('ram', true);
insert into categories(category_name, accessible) values ('hdd', true);
insert into categories(category_name, accessible) values ('computer-cases', true);
insert into categories(category_name, accessible) values ('power-supplies', true);
insert into categories(category_name, accessible) values ('ssd', true);
insert into categories(category_name, accessible) values ('sound-cards', true);
insert into categories(category_name, accessible) values ('pc-other-components', true);
insert into categories(category_name, accessible) values ('monitors', true);
insert into categories(category_name, accessible) values ('monitor-accessories', true);
insert into categories(category_name, accessible) values ('software-office', true);
insert into categories(category_name, accessible) values ('software-desktop', true);
insert into categories(category_name, accessible) values ('software-os', true);
insert into categories(category_name, accessible) values ('software-antivirus', true);
insert into categories(category_name, accessible) values ('software-others', true);
insert into categories(category_name, accessible) values ('laser-printers', true);
insert into categories(category_name, accessible) values ('inject-printers', true);
insert into categories(category_name, accessible) values ('scanners', true);
insert into categories(category_name, accessible) values ('printer-consumables', true);
insert into categories(category_name, accessible) values ('pc-mouses', true);
insert into categories(category_name, accessible) values ('pc-keyboards', true);
insert into categories(category_name, accessible) values ('routers', true);
insert into categories(category_name, accessible) values ('switch', true);
insert into categories(category_name, accessible) values ('usb', true);
insert into categories(category_name, accessible) values ('external-hdd', true);
insert into categories(category_name, accessible) values ('external-ssd', true);
insert into categories(category_name, accessible) values ('pc-speakers', true);
insert into categories(category_name, accessible) values ('headphones', true);
insert into categories(category_name, accessible) values ('web-camera', true);
