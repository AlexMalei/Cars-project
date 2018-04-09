package dev5.malei.carrent.daoImpl;

import dev5.malei.carrent.dao.BlockDetailsDAO;
import dev5.malei.carrent.entities.BlockDetails;
import java.util.List;


public class BlockDetailsDAOImpl extends CrudDAOImpl<BlockDetails> implements BlockDetailsDAO {

    public BlockDetailsDAOImpl() {
        super(BlockDetails.class);
    }

    @Override
    public BlockDetails blockUser(int userId, String comment) {
        List<BlockDetails> blockDetailsList = list();
        BlockDetails blockDetails = null;
        for (BlockDetails bd : blockDetailsList) {
            if (bd.getUserId() == userId) {
                blockDetails = bd;
                break;
            }
        }
        blockDetails.setBlocked(true);
        blockDetails.setComment(comment);
        return update(blockDetails);
    }


}
