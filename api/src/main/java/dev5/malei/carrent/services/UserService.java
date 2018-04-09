package dev5.malei.carrent.services;


import dev5.malei.carrent.entities.User;

public interface UserService extends CrudService<User>{
    User getUserByLogin(String login);
}
