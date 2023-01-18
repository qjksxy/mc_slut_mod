package org.slut.mcmod.items.weapon;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HumoZhiZhang extends SwordItem {
    public HumoZhiZhang(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    // 护摩之杖右键使用时，玩家会受到6点穿透伤害
    // 同时获得持续400游戏刻（20s），1级力量状态效果（近战伤害+3）
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.damage((new DamageSource("humozhizhang")).setBypassesArmor(), 6F);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1));
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    // 使用护摩之杖攻击后，若玩家处于力量状态下，会获得以下状态效果：
    // 生命恢复 1级 50刻: 每秒恢复0.2生命值
    // 生命提升 1级 50刻: 增加4点生命上限
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity user = (PlayerEntity) attacker;
        if (user.hasStatusEffect(StatusEffects.STRENGTH)) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 50, 1));
        }
        return super.postHit(stack, target, attacker);
    }
}
