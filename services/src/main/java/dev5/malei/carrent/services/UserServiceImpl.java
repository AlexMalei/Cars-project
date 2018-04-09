package dev5.malei.carrent.services;


import dev5.malei.carrent.dao.UserDAO;
import dev5.malei.carrent.daoImpl.UserDAOImpl;
import dev5.malei.carrent.entities.User;

public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {

    private UserDAO userDAO = (UserDAOImpl) DaoFactory.getDao(UserServiceImpl.class);

    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }
}
