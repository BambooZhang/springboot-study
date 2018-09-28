CREATE TABLE `city` (
`id`  int(11) NULL ,
`province_id`  int(4) NULL ,
`city_name`  varchar(255) NULL ,
`description`  varchar(255) NULL
)

INSERT INTO `city` (`id`, `province_id`, `city_name`, `description`) VALUES ('1', '1', '杭州', '描述')
