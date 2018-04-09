package dev5.malei.carrent.services;

import dev5.malei.carrent.entities.BlockDetails;

public interface BlockDetailsService extends CrudService<BlockDetails> {
    BlockDetails blockUser(int userId, String comment);
}
