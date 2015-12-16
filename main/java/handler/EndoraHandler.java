package handler;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import TF.entity.EntityBeam;
import TF.entity.EntityGravityGrenade;
import TF.entity.EntityLaser;
import TF.entity.EntityLay;
import TF.entity.monster.EntityMobTF;
import azTFaddons.TFaddon;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EndoraHandler {

	public int beamCnt1 = 0;
	public int beamCnt2 = 0;
	public int beamCnt3 = 0;

	@SubscribeEvent
	public void onLivingUpdateEventt(LivingUpdateEvent event)
	{

		Random rand = new Random();
		if(event.entityLiving instanceof EntityDragon)
		{
			EntityDragon dragon = (EntityDragon)event.entityLiving;

			//エンドラのオートリジェネ
			if((TFaddon.conf.endoraFix >= 3 && dragon.getHealth() < dragon.getMaxHealth() && dragon.getHealth() > dragon.getMaxHealth() / 2)
				|| (TFaddon.conf.endoraFix >= 5 && dragon.getHealth() > 0))
			{
				int overDifficulty;
				if(5 - (TFaddon.conf.endoraFix - 3) < 1)
				{
					overDifficulty = 1;
				}else
				{
					overDifficulty = 5 - (TFaddon.conf.endoraFix - 3);
				}

				//難易度4までは、HPが半分以上の場合のみ回復
				//難易度5以上では、常時自動回復
				if(rand.nextInt(overDifficulty) == 0)
				{
					dragon.heal(0.5F);
				}
			}

			List list2 = dragon.worldObj.getEntitiesWithinAABBExcludingEntity(dragon,
			    		dragon.boundingBox.addCoord(dragon.motionX, dragon.motionY, dragon.motionZ).expand(20.0D, 20.0D, 20.0D));

			//自分の付近に重力場があった場合に消し去る
			for (int l = 0; l < list2.size(); ++l)
			{
				Entity entity2 = (Entity)list2.get(l);
				if(entity2 instanceof EntityGravityGrenade)
				{
					EntityGravityGrenade grav = (EntityGravityGrenade)entity2;
					//System.out.println("TEST3 : " + grav.texsize);
					if(grav.texsize > 2.0F)
					{
						//System.out.println("TEST2");
						grav.setDead();
						grav.setEntityDead();
					}

				}
			}

			//重力弾発射
			int overDifficultyG;
			if(15 - (TFaddon.conf.endoraFix - 2) < 1)
			{
				overDifficultyG = 1;
			}else
			{
				overDifficultyG = 15 - (TFaddon.conf.endoraFix - 2);
			}
			if(TFaddon.conf.endoraFix >= 2 && rand.nextInt(overDifficultyG) == 0)
			{
				 List list = dragon.worldObj.getEntitiesWithinAABBExcludingEntity(dragon,
		            		dragon.boundingBox.addCoord(dragon.motionX, dragon.motionY, dragon.motionZ).expand(6.0D, 30.0D, 6.0D));

	            for (int l = 0; l < list.size(); ++l)
	            {
	                Entity entity1 = (Entity)list.get(l);

	                if(entity1 instanceof EntityPlayer)
	                {

	    				float adjustX = 0.0F;
	    				float adjustY = -9.0F;
	    				float adjustZ = -18.0F;

	    				EntityGravityGrenade beam = new EntityGravityGrenade(dragon.worldObj, dragon, false);
	    				//beam.posY = beam.posY - 180F;
	    				beam.setDamage((double)(rand.nextInt(5) + 10));
	    				//beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);
	    				beam.setLocationAndAngles(dragon.posX, dragon.posY + (double)dragon.getEyeHeight(), dragon.posZ,
	    						dragon.rotationYaw, dragon.rotationPitch);

	    				beam.posX += -(double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
	    				      		- (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
	    				beam.posY += 0.05000000149011612D + adjustY;
	    				beam.posZ += (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
	    				      		- (double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
	    				beam.setPosition(beam.posX, beam.posY, beam.posZ);

	    				      //初速度
	    				beam.motionX = (double)(-MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) *
	    				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
	    				beam.motionZ = (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) *
	    				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
	    				beam.motionY = (double)(-MathHelper.sin(beam.rotationPitch / 180.0F * (float)Math.PI));
	    				  //beam.setThrowableHeading(beam.motionX, beam.motionY, beam.motionZ, speed * 1.5F, speed2);
	    				beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 2.2F, 1.0F);

	    				if(!dragon.worldObj.isRemote)
	    				{
	    					dragon.worldObj.spawnEntityInWorld(beam);
	    				}

						/*
	                	ThreadEndoraGravity attackThread = new ThreadEndoraGravity(dragon);
	                	attackThread.start();
	                	*/
	                	break;
	                }
	            }
			}

			int overDifficulty;
			if(4 - (TFaddon.conf.endoraFix - 5) < 1)
			{
				overDifficulty = 1;
			}else
			{
				overDifficulty = 4 - (TFaddon.conf.endoraFix - 5);
			}

			if(TFaddon.conf.endoraFix >= 5 && rand.nextInt(overDifficulty) == 0 && beamCnt1 == 0)
			{
				float adjustX = 0.0F;
				float adjustY = -9.0F;
				float adjustZ = -18.0F;

				EntityBeam beam = new EntityBeam(dragon.worldObj, dragon, false);
				//beam.posY = beam.posY - 180F;
				beam.setDamage((double)(rand.nextInt(5) + 10));
				//beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);
				beam.setLocationAndAngles(dragon.posX, dragon.posY + (double)dragon.getEyeHeight(), dragon.posZ,
						dragon.rotationYaw, dragon.rotationPitch + 160.0F);

				beam.posX += -(double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam.posY += 0.05000000149011612D + adjustY;
				beam.posZ += (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam.setPosition(beam.posX, beam.posY, beam.posZ);

				      //初速度
				beam.motionX = (double)(-MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
				beam.motionZ = (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
				beam.motionY = (double)(-MathHelper.sin(beam.rotationPitch / 180.0F * (float)Math.PI));
				  //beam.setThrowableHeading(beam.motionX, beam.motionY, beam.motionZ, speed * 1.5F, speed2);
				beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);

				if(!dragon.worldObj.isRemote)
				{
					dragon.worldObj.spawnEntityInWorld(beam);
				}
				//beamCnt1 = beamCnt1 - 1;
				/*
            	ThreadEndoraBeam attackThread = new ThreadEndoraBeam(dragon);
            	attackThread.start();
            	*/
			}

			if(beamCnt1 > 0)
			{
				/*
				beamCnt1 = beamCnt1 - 1;
            	ThreadEndoraBeam attackThread = new ThreadEndoraBeam(dragon);
            	attackThread.start();
				*/
				beamCnt1 = beamCnt1 - 1;
				float adjustX = 0.0F;
				float adjustY = -9.0F;
				float adjustZ = -18.0F;

				EntityBeam beam = new EntityBeam(dragon.worldObj, dragon, false);
				//beam.posY = beam.posY - 180F;
				beam.setDamage((double)(rand.nextInt(5) + 10));
				//beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);
				beam.setLocationAndAngles(dragon.posX, dragon.posY + (double)dragon.getEyeHeight(), dragon.posZ,
						dragon.rotationYaw, dragon.rotationPitch + 160.0F);

				beam.posX += -(double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam.posY += 0.05000000149011612D + adjustY;
				beam.posZ += (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam.setPosition(beam.posX, beam.posY, beam.posZ);

				      //初速度
				beam.motionX = (double)(-MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
				beam.motionZ = (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
				beam.motionY = (double)(-MathHelper.sin(beam.rotationPitch / 180.0F * (float)Math.PI));
				  //beam.setThrowableHeading(beam.motionX, beam.motionY, beam.motionZ, speed * 1.5F, speed2);
				beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);

				if(!dragon.worldObj.isRemote)
				{
					dragon.worldObj.spawnEntityInWorld(beam);
				}

			}else if(beamCnt2 > 0)
			{
				beamCnt2 = beamCnt2 - 1;
				float adjustX = 0.0F;
				float adjustY = -9.0F;
				float adjustZ = -18.0F;

				EntityLaser beam = new EntityLaser(dragon.worldObj, dragon, false);
				//beam.posY = beam.posY - 180F;
				beam.setDamage(40.0D);
				//beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);
				beam.setLocationAndAngles(dragon.posX, dragon.posY + (double)dragon.getEyeHeight(), dragon.posZ,
						dragon.rotationYaw, dragon.rotationPitch + 160.0F);

				beam.posX += -(double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam.posY += 0.05000000149011612D + adjustY;
				beam.posZ += (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam.setPosition(beam.posX, beam.posY, beam.posZ);

				      //初速度
				beam.motionX = (double)(-MathHelper.sin(beam.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
				beam.motionZ = (double)(MathHelper.cos(beam.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam.rotationPitch / 180.0F * (float)Math.PI));
				beam.motionY = (double)(-MathHelper.sin(beam.rotationPitch / 180.0F * (float)Math.PI));
				  //beam.setThrowableHeading(beam.motionX, beam.motionY, beam.motionZ, speed * 1.5F, speed2);
				beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 10.0F, 0.0F);

				EntityLay beam2 = new EntityLay(dragon.worldObj, dragon, false);
				//beam2.posY = beam2.posY - 180F;
				//beam2.setArrowHeading(beam2.motionX, beam2.motionY, beam2.motionZ, 4.0F, 1.0F);
				beam2.setLocationAndAngles(dragon.posX, dragon.posY + (double)dragon.getEyeHeight(), dragon.posZ,
						dragon.rotationYaw, dragon.rotationPitch + 160.0F);

				beam2.posX += -(double)(MathHelper.sin(beam2.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.cos(beam2.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam2.posY += 0.05000000149011612D + adjustY;
				beam2.posZ += (double)(MathHelper.cos(beam2.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
				      		- (double)(MathHelper.sin(beam2.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
				beam2.setPosition(beam2.posX, beam2.posY, beam2.posZ);

				      //初速度
				beam2.motionX = (double)(-MathHelper.sin(beam2.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam2.rotationPitch / 180.0F * (float)Math.PI));
				beam2.motionZ = (double)(MathHelper.cos(beam2.rotationYaw / 180.0F * (float)Math.PI) *
				                     MathHelper.cos(beam2.rotationPitch / 180.0F * (float)Math.PI));
				beam2.motionY = (double)(-MathHelper.sin(beam2.rotationPitch / 180.0F * (float)Math.PI));
				  //beam2.setThrowableHeading(beam2.motionX, beam2.motionY, beam2.motionZ, speed * 1.5F, speed2);
				beam2.setArrowHeading(beam2.motionX, beam2.motionY, beam2.motionZ, 0.01F, 0.0F);

				if(!dragon.worldObj.isRemote)
				{
					dragon.worldObj.spawnEntityInWorld(beam);
					dragon.worldObj.spawnEntityInWorld(beam2);
				}
				/*
            	ThreadEndoraLaser attackThread = new ThreadEndoraLaser(dragon);
            	attackThread.start();
            	*/
			}
			else
			{
				int overDifficultyR;
				if(TFaddon.conf.endoraFix > 2)
				{
					if(120 / (TFaddon.conf.endoraFix - 2) < 5)
					{
						overDifficultyR = 24;
					}else
					{
						overDifficultyR = TFaddon.conf.endoraFix - 2;
					}
				}else
				{
					overDifficultyR = 1;
				}

				int pat = rand.nextInt(120 / overDifficultyR);

				if(TFaddon.conf.endoraFix < 3)
				{
					if(pat < 2)
					{
						beamCnt1 = 5 * TFaddon.conf.endoraFix;
					}else if(pat < 3)
					{
						beamCnt2 = 2;
					}
				}else
				{
					if(pat < 3)
					{
						beamCnt1 = 10;
					}else if(pat < 5)
					{
						beamCnt2 = 2;
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		EntityLivingBase target = event.entityLiving;

		if(event.source.getEntity() instanceof EntityDragon && target instanceof EntityMobTF)
		{
			event.ammount = 0.0F;
			event.setCanceled(true);
			return;
		}

		if((event.source.getSourceOfDamage() instanceof EntityMobTF || event.source.getEntity() instanceof EntityMobTF) && target instanceof EntityDragon)
		{
			event.ammount = 0.0F;
			event.setCanceled(true);
			return;
		}
	}
}
