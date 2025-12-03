package com.inkle.service.implementation;

import org.springframework.stereotype.Service;

import com.inkle.entity.Block;
import com.inkle.entity.User;
import com.inkle.repository.BlockRepository;
import com.inkle.service.BlockService;
@Service
public class BlockServiceImpl implements BlockService{
     private final BlockRepository blockRepository;
     public BlockServiceImpl(BlockRepository blockRepository) {
         this.blockRepository = blockRepository;
     }
    public void blockUser(Long blockerId, Long blockedId) {
        Block block = new Block();
        block.setBlocker(new User(blockerId));
        block.setBlocked(new User(blockedId));
        blockRepository.save(block);
    }  

    public void unblockUser(Long blockerId, Long blockedId) {
        blockRepository.deleteByBlockerIdAndBlockedId(blockerId, blockedId);
    }
}
