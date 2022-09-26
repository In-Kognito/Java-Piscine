INSERT INTO chat.users (login, pass, list_created, list_room) values ('jinigo', 'jinigo', '{1, 2}', '{1, 2, 3, 4, 5}'),
                                                                     ('cyuuki', 'cyuuki', '{3}', '{1, 3, 4}'),
                                                                     ('vasya', 'vasya', '{5}', '{1, 2, 5}'),
                                                                     ('petya', 'petya', '{}', '{1, 2, 3, 4, 5}'),
                                                                     ('cheburashka', '1234', '{4}', '{3}');

INSERT INTO chat.chatroom(chat_name, chat_owner, list_msg) values ('Kitchen', 3, '{4}'),
                                                                  ('Toilet', 2, '{1}'),
                                                                  ('Livingroom', 1, '{4}'),
                                                                  ('Bathroom', 5, '{3}'),
                                                                  ('Cabinet', 4, '{5}');

INSERT INTO chat.message(msg_author, msg_room, msg_text, msg_date) values (1, 2, 'I am here', to_timestamp('28 Oct 2020', 'DD MON YYYY')),
                                                                          (3, 1, 'I am reading IDIOT', to_timestamp('28 Oct 2020', 'DD MON YYYY')),
                                                                          (4, 4, 'SLEEEP', to_timestamp('28 Oct 2020', 'DD MON YYYY')),
                                                                          (4, 3, 'YOU shall not pass!', to_timestamp('28 Oct 2020', 'DD MON YYYY')),
                                                                          (2, 5, 'Please, take me five', to_timestamp('28 Oct 2020', 'DD MON YYYY'));


