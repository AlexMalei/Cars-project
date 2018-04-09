package dev5.malei.carrent.daoImpl;

import dev5.malei.carrent.dao.CommentDAO;
import dev5.malei.carrent.entities.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentDAOImpl extends CrudDAOImpl<Comment> implements CommentDAO {
    public CommentDAOImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> getCommentsByUser(int userId) {
        List<Comment> allCommentList = list();
        List<Comment> commentsByUserList = allCommentList.
                stream().
                filter((comment -> comment.getUserId() == userId)).
                collect(Collectors.toList());
        return commentsByUserList;
    }

    @Override
    public List<Comment> getCommentsByCar(int carId) {
        List<Comment> allCommentList = list();
        List<Comment> commentsByCarList = allCommentList.
                stream().
                filter((comment -> comment.getCarId() == carId)).
                collect(Collectors.toList());
        return commentsByCarList;
    }
}
