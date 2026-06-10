package com.stonercraft.stonercraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GrowPotBlock extends Block {

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(3, 0, 3, 13, 2, 13),
            Block.box(2, 2, 2, 14, 10, 14),
            Block.box(3, 10, 3, 13, 12, 13),
            Block.box(4, 12, 4, 12, 14, 12),
            Block.box(4, 10, 4, 12, 13, 12)
    );

    public GrowPotBlock() {
        super(BlockBehaviour.Properties.of(Material.DECORATION)
                .strength(0.3F)
                .sound(SoundType.STONE)
                .noOcclusion());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
