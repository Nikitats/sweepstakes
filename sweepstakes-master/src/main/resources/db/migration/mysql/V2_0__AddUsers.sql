INSERT INTO roles (`id`, `type`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO users (`id`, `Enabled`, `Username`, `Password`)
VALUES (1, true, 'sa', 'password');
INSERT INTO user_roles (`user_id`, `role_id`) VALUES ('1', '1');