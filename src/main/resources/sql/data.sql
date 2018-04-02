INSERT INTO public.users(users_id, users_username, users_avatar, users_reg_email, users_reg_date, users_birth_date, users_status)
VALUES ('d1098e96-ca3d-11e7-abc4-cec278b6b50a', 'MatthewPoletin', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLuwbjz8VFLqUiNatBxdfdOm3r7tm2NLhAbjdaSw80NbTLuamvLA', 'mail1@server.com', current_date, to_date('09 Dec 1995', 'DD Mon YYYY'), 'Online');

INSERT INTO public.users(users_id, users_username, users_avatar, users_reg_email, users_reg_date, users_birth_date, users_status)
VALUES ('210e8d5b-8a1b-4b6e-93f4-0af7be69e38f', 'Kormvina', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHR87ete22DZ1wRQU47ugahpU3P99VfIbdP5VRWTXJL70JTYek', 'mail2@server.com', current_date, to_date('07 May 1978', 'DD Mon YYYY'), 'Online');

INSERT INTO public.relations(relations_user_a_id, relations_user_b_id, relations_est_date, relations_type)
VALUES ('d1098e96-ca3d-11e7-abc4-cec278b6b50a', '210e8d5b-8a1b-4b6e-93f4-0af7be69e38f', current_date, 'friend');

INSERT INTO public.relations(relations_user_a_id, relations_user_b_id, relations_est_date, relations_type)
VALUES ('210e8d5b-8a1b-4b6e-93f4-0af7be69e38f', 'd1098e96-ca3d-11e7-abc4-cec278b6b50a', current_date, 'friend');