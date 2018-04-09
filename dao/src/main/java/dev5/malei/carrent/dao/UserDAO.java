package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.User;

public interface UserDAO extends CrudDAO<User> {
    User getUserByLogin(String login);
}
