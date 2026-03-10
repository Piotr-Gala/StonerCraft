package com.stonercraft.stonercraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;


public class GrowPotBlock extends Block {


    public GrowPotBlock() {
        super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.DECORATION)
                .strength(0.8F).noOcclusion());
    }

    private static final VoxelShape SEGMENT_0 = Shapes.or(
            Block.box(6, 13, 15, 10, 16, 16),
            Block.box(10, 13, 14, 11, 16, 16),
            Block.box(5, 13, 14, 6, 16, 16),
            Block.box(13, 13, 13, 14, 16, 14),
            Block.box(11, 13, 13, 12, 16, 15),
            Block.box(4, 13, 13, 5, 16, 15),
            Block.box(2, 13, 13, 3, 16, 14),
            Block.box(12, 13, 12, 13, 16, 15),
            Block.box(3, 13, 12, 4, 16, 15),
            Block.box(13, 13, 11, 15, 16, 13),
            Block.box(1, 13, 11, 3, 16, 13),
            Block.box(15, 13, 5, 16, 16, 11),
            Block.box(0, 13, 5, 1, 16, 11),
            Block.box(14, 13, 3, 15, 16, 6),
            Block.box(12, 13, 3, 13, 16, 4),
            Block.box(3, 13, 3, 4, 16, 4),
            Block.box(1, 13, 3, 2, 16, 6),
            Block.box(13, 13, 2, 14, 16, 5),
            Block.box(2, 13, 2, 3, 16, 5),
            Block.box(11, 13, 1, 13, 16, 3)
    );

    private static final VoxelShape SEGMENT_1 = Shapes.or(
            Block.box(3, 13, 1, 5, 16, 3),
            Block.box(5, 13, 0, 11, 16, 1),
            Block.box(12, 9, 11, 13, 13, 12),
            Block.box(3, 9, 11, 4, 13, 12),
            Block.box(11, 9, 3, 12, 13, 4),
            Block.box(4, 9, 3, 5, 13, 4),
            Block.box(6, 8, 14, 10, 16, 15),
            Block.box(10, 8, 13, 11, 13, 15),
            Block.box(5, 8, 13, 6, 13, 15),
            Block.box(11, 8, 12, 13, 13, 14),
            Block.box(3, 8, 12, 5, 13, 14),
            Block.box(13, 8, 10, 14, 13, 13),
            Block.box(2, 8, 10, 3, 13, 13),
            Block.box(14, 8, 6, 15, 16, 11),
            Block.box(1, 8, 6, 2, 16, 11),
            Block.box(13, 8, 5, 15, 13, 6),
            Block.box(1, 8, 5, 3, 13, 6),
            Block.box(12, 8, 3, 14, 13, 5),
            Block.box(2, 8, 3, 4, 13, 5),
            Block.box(10, 8, 2, 13, 13, 3)
    );

    private static final VoxelShape SEGMENT_2 = Shapes.or(
            Block.box(3, 8, 2, 6, 13, 3),
            Block.box(5, 8, 1, 11, 16, 2),
            Block.box(9, 6, 11, 10, 7, 12),
            Block.box(6, 6, 11, 7, 7, 12),
            Block.box(11, 6, 9, 12, 7, 10),
            Block.box(4, 6, 9, 5, 7, 10),
            Block.box(11, 6, 6, 12, 7, 7),
            Block.box(4, 6, 6, 5, 7, 7),
            Block.box(9, 6, 4, 10, 7, 5),
            Block.box(6, 6, 4, 7, 7, 5),
            Block.box(6, 5, 13, 10, 13, 14),
            Block.box(9, 5, 12, 11, 9, 13),
            Block.box(5, 5, 12, 7, 9, 13),
            Block.box(11, 5, 11, 12, 8, 13),
            Block.box(4, 5, 11, 5, 8, 13),
            Block.box(12, 5, 9, 13, 9, 12),
            Block.box(3, 5, 9, 4, 9, 12),
            Block.box(13, 5, 6, 14, 13, 10),
            Block.box(2, 5, 6, 3, 13, 10),
            Block.box(12, 5, 5, 13, 9, 7)
    );

    private static final VoxelShape SEGMENT_3 = Shapes.or(
            Block.box(3, 5, 5, 4, 9, 7),
            Block.box(11, 5, 4, 13, 8, 5),
            Block.box(3, 5, 4, 5, 8, 5),
            Block.box(9, 5, 3, 12, 9, 4),
            Block.box(4, 5, 3, 7, 9, 4),
            Block.box(6, 5, 2, 10, 13, 3),
            Block.box(7, 3, 11, 9, 6, 12),
            Block.box(9, 3, 10, 10, 6, 12),
            Block.box(6, 3, 10, 7, 6, 12),
            Block.box(10, 3, 9, 11, 6, 11),
            Block.box(5, 3, 9, 6, 6, 11),
            Block.box(10, 3, 6, 11, 6, 7),
            Block.box(5, 3, 6, 6, 6, 7),
            Block.box(9, 3, 5, 11, 6, 6),
            Block.box(5, 3, 5, 7, 6, 6),
            Block.box(6, 3, 4, 10, 6, 5),
            Block.box(7, 2, 12, 9, 9, 13),
            Block.box(10, 2, 11, 11, 7, 12),
            Block.box(5, 2, 11, 6, 7, 12),
            Block.box(11, 2, 10, 12, 7, 11)
    );

    private static final VoxelShape SEGMENT_4 = Shapes.or(
            Block.box(4, 2, 10, 5, 7, 11),
            Block.box(12, 2, 7, 13, 9, 9),
            Block.box(3, 2, 7, 4, 9, 9),
            Block.box(11, 2, 5, 12, 7, 6),
            Block.box(4, 2, 5, 5, 7, 6),
            Block.box(10, 2, 4, 11, 7, 5),
            Block.box(5, 2, 4, 6, 7, 5),
            Block.box(7, 2, 3, 9, 9, 4),
            Block.box(7, 1, 10, 9, 3, 12),
            Block.box(9, 1, 9, 10, 3, 12),
            Block.box(6, 1, 9, 7, 3, 12),
            Block.box(9, 1, 6, 10, 3, 7),
            Block.box(6, 1, 6, 7, 3, 7),
            Block.box(11, 0, 6, 12, 6, 10),
            Block.box(6, 0, 6, 10, 1, 12),
            Block.box(4, 0, 6, 5, 6, 10),
            Block.box(10, 0, 5, 11, 3, 11),
            Block.box(5, 0, 5, 6, 3, 11),
            Block.box(6, 0, 4, 10, 3, 6)
    );

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.or(
                SEGMENT_0,
                SEGMENT_1,
                SEGMENT_2,
                SEGMENT_3,
                SEGMENT_4
        );
    }



}
