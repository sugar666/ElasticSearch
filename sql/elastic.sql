DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` int(0) NOT NULL AUTO_INCREMENT,
    `created_at` timestamp not null default current_timestamp comment '创建时间',
    `updated_at` timestamp not null default current_timestamp comment '更新时间',
	`telphone` varchar(40) NOT NULL DEFAULT '',
	`password` varchar(200) NOT NULL DEFAULT '',
	`nick_name` varchar(40) NOT NULL DEFAULT '',
	`salt` varchar(40) NOT NULL DEFAULT '',
	`gender` int NOT NULL DEFAULT 0,
	PRIMARY KEY (`id`),
	UNIQUE `telphone_unique_index` USING BTREE (`telphone`) comment ''
) COMMENT='';

DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '',
  `created_at` timestamp not null default current_timestamp comment '创建时间',
  `updated_at` timestamp not null default current_timestamp comment '更新时间',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `disabled_flag` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp not null default current_timestamp comment '创建时间',
  `updated_at` timestamp not null default current_timestamp comment '更新时间',
  `name` varchar(20) NOT NULL DEFAULT '',
  `icon_url` varchar(200) NOT NULL DEFAULT '',
  `sort` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique_index`(`name`) USING BTREE
);

DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp not null default current_timestamp comment '创建时间',
  `updated_at` timestamp not null default current_timestamp comment '更新时间',
  `name` varchar(80) NOT NULL DEFAULT '',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `price_per_man` int(0) NOT NULL DEFAULT 0,
  `latitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `longitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `category_id` int(0) NOT NULL DEFAULT 0,
  `tags` varchar(2000) NOT NULL DEFAULT '',
  `start_time` varchar(200) NOT NULL DEFAULT '',
  `end_time` varchar(200) NOT NULL DEFAULT '',
  `address` varchar(200) NOT NULL DEFAULT '',
  `seller_id` int(0) NOT NULL DEFAULT 0,
  `icon_url` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);