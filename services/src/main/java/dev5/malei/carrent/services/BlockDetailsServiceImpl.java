package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.BlockDetailsDAO;
import dev5.malei.carrent.daoImpl.BlockDetailsDAOImpl;
import dev5.malei.carrent.entities.BlockDetails;

public class BlockDetailsServiceImpl extends CrudServiceImpl<BlockDetails> implements BlockDetailsService {
    private BlockDetailsDAO blockDetailsDAO = (BlockDetailsDAOImpl) DaoFactory.getDao(BlockDetailsServiceImpl.class);

    public BlockDetails blockUser(int userId, String comment) {
        return blockDetailsDAO.blockUser(userId, comment);
    }
}
