package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.BlockDetails;

public interface BlockDetailsDAO extends CrudDAO<BlockDetails> {
    BlockDetails blockUser(int userId, String comment);
}
