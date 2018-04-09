package dev5.malei.carrent.daoImpl;


import dev5.malei.carrent.dao.BlockDetailsDAO;
import dev5.malei.carrent.dao.UserDAO;
import dev5.malei.carrent.entities.BlockDetails;
import dev5.malei.carrent.entities.User;

import java.util.List;

public class UserDAOImpl extends CrudDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User add(User entity) {
        BlockDetailsDAO blockDetailsDAO = new BlockDetailsDAOImpl();
        entity = super.add(entity);
        BlockDetails blockDetails = new BlockDetails();
        blockDetails.setBlocked(false);
        blockDetails.setComment(null);
        blockDetails.setUserId(entity.getId());
        blockDetailsDAO.add(blockDetails);
        return entity;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList = list();
        for (User user : userList){
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
