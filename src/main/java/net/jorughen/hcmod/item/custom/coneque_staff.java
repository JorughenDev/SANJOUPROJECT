package net.jorughen.hcmod.item.custom;

import net.jorughen.hcmod.entity.HcConequeEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class coneque_staff extends Item {

    EntityType<? extends HcConequeEntity> type;
    public coneque_staff(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        final int KILLER_BUNNY_TYPE = 99;
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        Direction direction = context.getSide();
        BlockPos blockpos = context.getBlockPos();
        String TrueDirection = direction.asString();



        RabbitEntity rabbit = new RabbitEntity(EntityType.RABBIT, world);
        rabbit.setRabbitType(99);
        rabbit.shouldSpawnSprintingParticles();

        if (!world.isClient()){
            if (TrueDirection.equals("down")){
                rabbit.setPosition(blockpos.getX() + 0.5f, blockpos.getY() - 1f, blockpos.getZ() + 0.7f);

            }
            if (TrueDirection.equals("up")){
                rabbit.setPosition(blockpos.getX() + 0.5f, blockpos.getY() + 1f, blockpos.getZ() + 0.7f);

            }
            if (TrueDirection.equals("north")){
                rabbit.setPosition(blockpos.getX() + 0.5f, blockpos.getY(), blockpos.getZ() - 0.3f);

            }
            if (TrueDirection.equals("south")){
                rabbit.setPosition(blockpos.getX() + 0.5f, blockpos.getY(), blockpos.getZ() + 1.3f);

            }
            if (TrueDirection.equals("west")){
                rabbit.setPosition(blockpos.getX() - 0.5f, blockpos.getY(), blockpos.getZ() + 0.7f);

            }
            if (TrueDirection.equals("east")){
                rabbit.setPosition(blockpos.getX() + 1.3f, blockpos.getY(), blockpos.getZ() + 0.5f);

            }
            world.spawnEntity(rabbit);
        }

        return super.useOnBlock(context);
    }
}
