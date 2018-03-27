INSERT INTO public.users(users_username, users_avatar, users_reg_email, users_reg_date, users_birth_date, users_status)
VALUES ('MatthewPoletin', 'https://pp.userapi.com/c626922/v626922567/2429b/IjwJ0ZMRHNo.jpg', 'poletinm@yandex.ru', current_date, to_date('09 Dec 1995', 'DD Mon YYYY'), 'Online');

INSERT INTO public.users(users_username, users_avatar, users_reg_email, users_reg_date, users_birth_date, users_status)
VALUES ('Kormvina', '', 'poletinm@yandex.ru', current_date, to_date('09 Dec 1995', 'DD Mon YYYY'), 'Online');

INSERT INTO public.relations(relations_user_a_id, relations_user_b_id, relations_est_date, relations_type)
VALUES (1, 2, current_date, 'friend');

INSERT INTO public.relations(relations_user_a_id, relations_user_b_id, relations_est_date, relations_type)
VALUES (2, 1, current_date, 'friend');