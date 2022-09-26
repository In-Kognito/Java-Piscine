create schema if not exists chat;

drop table chat.users, chat.chatroom, chat.message CASCADE;

create table if not exists chat.users (
    id serial primary key ,
    login text not null ,
    pass text not null ,
    list_created int[] ,
    list_room int[]
);

create table if not exists chat.chatroom (
    id serial primary key ,
    chat_name text not null ,
    chat_owner int not null references chat.users(id) ,
    list_msg int[]
    );

create table if not exists chat.message (
    msg_id serial primary key ,
    msg_author int not null references chat.users(id) ,
    msg_room int not null references chat.chatroom(id) ,
    msg_text text not null ,
    msg_date timestamp
    );

