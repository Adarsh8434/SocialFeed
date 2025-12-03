package com.inkle.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.service.BlockService;

@RestController
@RequestMapping("/block")
public class BlockController {
    private final BlockService blockService;

    public BlockController(BlockService blockService) { this.blockService = blockService; }

    @PostMapping
    public String blockUser(@RequestParam Long blockerId,
                            @RequestParam Long blockedId) {

        blockService.blockUser(blockerId, blockedId);
        return "User blocked successfully";
    }

    @DeleteMapping
    public String unblockUser(@RequestParam Long blockerId,
                              @RequestParam Long blockedId) {

        blockService.unblockUser(blockerId, blockedId);
        return "User unblocked successfully";
    }
}
