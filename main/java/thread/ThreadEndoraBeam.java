package thread;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.MathHelper;
import TF.entity.EntityBeam;



public class ThreadEndoraBeam extends Thread{

	private EntityDragon dragon;

	public ThreadEndoraBeam(EntityDragon par1)
	{
		this.dragon = par1;
	}

	public void run()
	{
		Random rand = new Random();

		float adjustX = 0.0F;
		float adjustY = -6.0F;
		float adjustZ = -15.0F;

		EntityBeam beam = new EntityBeam(dragon.worldObj, dragon, false);
		//beam.posY = beam.posY - 180F;
		beam.setDamage((double)(rand.nextInt(5) + 10));
		//beam.setArrowHeading(beam.motionX, beam.motionY, beam.motionZ, 4.0F, 1.0F);
		beam.setLocationAndAngles(dragon.posX, dragon.posY + (double)dragon.getEyeHeight(), dragon.posZ,
				dragon.rotationYaw, dragon.rotationPitch + 180.0F);

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

	}

}
