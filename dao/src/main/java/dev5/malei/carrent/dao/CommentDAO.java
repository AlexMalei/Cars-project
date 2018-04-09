package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.Comment;

import java.util.List;

public interface CommentDAO extends CrudDAO<Comment> {
    List<Comment> getCommentsByUser(int userId);

    List<Comment> getCommentsByCar(int carId);
}
