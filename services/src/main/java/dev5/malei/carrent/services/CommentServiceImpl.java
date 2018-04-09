package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.CommentDAO;
import dev5.malei.carrent.daoImpl.CommentDAOImpl;
import dev5.malei.carrent.entities.Comment;
import dev5.malei.carrent.services.CommentService;
import dev5.malei.carrent.services.CrudServiceImpl;

import java.util.List;

public class CommentServiceImpl extends CrudServiceImpl<Comment> implements CommentService {
    public CommentServiceImpl() {
        super();
    }

    private CommentDAO commentDAO = (CommentDAOImpl) DaoFactory.getDao(CommentServiceImpl.class);

    public List<Comment> getCommentsByUser(int userId) {
        return commentDAO.getCommentsByUser(userId);
    }

    @Override
    public List<Comment> getCommentsByCar(int carId) {
        return commentDAO.getCommentsByCar(carId);
    }
}
