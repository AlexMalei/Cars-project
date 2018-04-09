package dev5.malei.carrent.services;

import dev5.malei.carrent.entities.Comment;

import java.util.List;

public interface CommentService extends CrudService<Comment> {
    List<Comment> getCommentsByUser(int userId);

    List<Comment> getCommentsByCar(int carId);
}
