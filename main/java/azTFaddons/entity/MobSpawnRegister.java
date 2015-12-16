package azTFaddons.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import TF.entity.monster.EntityAssaltWolf;
import TF.entity.monster.EntityCheingirl;
import TF.entity.monster.EntityLauncherSpider;
import TF.entity.monster.EntityMecaCannon;
import TF.entity.monster.EntityMecaCarrier;
import TF.entity.monster.EntityMecaFencer;
import TF.entity.monster.EntityMecaSword;
import TF.entity.monster.EntityRoflauncher;
import TF.entity.monster.EntityTSF1;
import TF.entity.monster.EntityTSF2;
import TF.entity.monster.EntityTSF3;
import TF.entity.monster.EntityTSFfloat;
import TF.entity.monster.EntityTSFkinzhal;
import TF.entity.monster.EntityTSFtake2;
import TF.entity.monster.EntityTSFtake3;
import TF.entity.monster.EntityTSFtank;
import TF.entity.monster.EntityTSFwada;
import azTFaddons.TFaddon;
import cpw.mods.fml.common.registry.EntityRegistry;


public class MobSpawnRegister {

	public static BiomeGenBase[] biomesMecha;
	public static BiomeGenBase[] biomesTM;
	public static BiomeGenBase[] biomesTF08;
	public static BiomeGenBase[] biomesTF11;
	public static BiomeGenBase[] biomesTF18;
	public static BiomeGenBase[] biomesTF21;
	public static BiomeGenBase[] biomesTF24;

	public MobSpawnRegister()
	{
		//if (spawnMob) {
		int biomeCntMecha = 0;
		int biomeCntTM = 0;
		int biomeCntTF08 = 0;
		int biomeCntTF11 = 0;
		int biomeCntTF18 = 0;
		int biomeCntTF21 = 0;
		int biomeCntTF24 = 0;

		for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
			if(biome != null)
			{
				if(!TFaddon.conf.rejectBiomeMechaHT.containsKey(biome.biomeID))
				{
					biomeCntMecha++;
				}
				if(!TFaddon.conf.rejectBiomeTMHT.containsKey(biome.biomeID))
				{
					biomeCntTM++;
				}
				if(!TFaddon.conf.rejectBiomeTF08HT.containsKey(biome.biomeID))
				{
					biomeCntTF08++;
				}
				if(!TFaddon.conf.rejectBiomeTF11HT.containsKey(biome.biomeID))
				{
					biomeCntTF11++;
				}
				if(!TFaddon.conf.rejectBiomeTF18HT.containsKey(biome.biomeID))
				{
					biomeCntTF18++;
				}
				if(!TFaddon.conf.rejectBiomeTF21HT.containsKey(biome.biomeID))
				{
					biomeCntTF21++;
				}
				if(!TFaddon.conf.rejectBiomeTF24HT.containsKey(biome.biomeID))
				{
					biomeCntTF24++;
				}
			}
		}
		biomesMecha = new BiomeGenBase[biomeCntMecha];
		biomesTM = new BiomeGenBase[biomeCntTM];
		biomesTF08 = new BiomeGenBase[biomeCntTF08];
		biomesTF11 = new BiomeGenBase[biomeCntTF11];
		biomesTF18 = new BiomeGenBase[biomeCntTF18];
		biomesTF21 = new BiomeGenBase[biomeCntTF21];
		biomesTF24 = new BiomeGenBase[biomeCntTF24];

		biomeCntMecha = 0;
		biomeCntTM = 0;
		biomeCntTF08 = 0;
		biomeCntTF11 = 0;
		biomeCntTF18 = 0;
		biomeCntTF21 = 0;
		biomeCntTF24 = 0;

		for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
			if(biome != null)
			{
				if(!TFaddon.conf.rejectBiomeMechaHT.containsKey(biome.biomeID))
				{
					biomesMecha[biomeCntMecha] = biome;
					biomeCntMecha++;
				}
				if(!TFaddon.conf.rejectBiomeTMHT.containsKey(biome.biomeID))
				{
					biomesTM[biomeCntTM] = biome;
					biomeCntTM++;
				}
				if(!TFaddon.conf.rejectBiomeTF08HT.containsKey(biome.biomeID))
				{
					biomesTF08[biomeCntTF08] = biome;
					biomeCntTF08++;
				}
				if(!TFaddon.conf.rejectBiomeTF11HT.containsKey(biome.biomeID))
				{
					biomesTF11[biomeCntTF11] = biome;
					biomeCntTF11++;
				}
				if(!TFaddon.conf.rejectBiomeTF18HT.containsKey(biome.biomeID))
				{
					biomesTF18[biomeCntTF18] = biome;
					biomeCntTF18++;
				}
				if(!TFaddon.conf.rejectBiomeTF21HT.containsKey(biome.biomeID))
				{
					biomesTF21[biomeCntTF21] = biome;
					biomeCntTF21++;
				}
				if(!TFaddon.conf.rejectBiomeTF24HT.containsKey(biome.biomeID))
				{
					biomesTF24[biomeCntTF24] = biome;
					biomeCntTF24++;
				}
			}
		}

		//System.out.println("AAA" + biomes.length);
		//System.out.println("BBB" + biomeCnt);
		if(biomesMecha != null)
		{
			if (TFaddon.conf.spawnMobMechaFix)
			{

				EntityRegistry.addSpawn(EntityMecaSword.class, (int)((10.0D * TFaddon.conf.spawnMobMechaFixRate) + 0.5D), (int)((3.0D * TFaddon.conf.spawnMobMechaFixMin) + 0.5D),  (int)((5.0D * TFaddon.conf.spawnMobMechaFixMax) + 0.5D),  EnumCreatureType.monster, biomesMecha);
				EntityRegistry.addSpawn(EntityMecaCannon.class, (int)((10.0D * TFaddon.conf.spawnMobMechaFixRate) + 0.5D), (int)((3.0D * TFaddon.conf.spawnMobMechaFixMin) + 0.5D),  (int)((5.0D * TFaddon.conf.spawnMobMechaFixMax) + 0.5D),  EnumCreatureType.monster, biomesMecha);
				EntityRegistry.addSpawn(EntityMecaFencer.class, (int)((10.0D * TFaddon.conf.spawnMobMechaFixRate) + 0.5D), (int)((3.0D * TFaddon.conf.spawnMobMechaFixMin) + 0.5D),  (int)((5.0D * TFaddon.conf.spawnMobMechaFixMax) + 0.5D),  EnumCreatureType.monster, biomesMecha);
				EntityRegistry.addSpawn(EntityMecaCarrier.class, (int)((8.0D * TFaddon.conf.spawnMobMechaFixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobMechaFixMin) + 0.5D),  (int)((3.0D * TFaddon.conf.spawnMobMechaFixMax) + 0.5D),  EnumCreatureType.monster, biomesMecha);
			}
		}

		if(biomesTM != null)
		{
			if (TFaddon.conf.spawnMobTMFix)
			{
				EntityRegistry.addSpawn(EntityRoflauncher.class, (int)((8.0D * TFaddon.conf.spawnMobTMFixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTMFixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTMFixMax) + 0.5D),  EnumCreatureType.monster, biomesTM);
				EntityRegistry.addSpawn(EntityCheingirl.class, (int)((8.0D * TFaddon.conf.spawnMobTMFixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTMFixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTMFixMax) + 0.5D),  EnumCreatureType.monster, biomesTM);
				EntityRegistry.addSpawn(EntityAssaltWolf.class, (int)((1.0D * TFaddon.conf.spawnMobTMFixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTMFixMin) + 0.5D),  (int)((1.0D * TFaddon.conf.spawnMobTMFixMax) + 0.5D),  EnumCreatureType.monster, biomesTM);
				EntityRegistry.addSpawn(EntityLauncherSpider.class, (int)((1.0D * TFaddon.conf.spawnMobTMFixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTMFixMin) + 0.5D),  (int)((1.0D * TFaddon.conf.spawnMobTMFixMax) + 0.5D),  EnumCreatureType.monster, biomesTM);
			}
		}

		if(biomesTF08 != null)
		{
			if (TFaddon.conf.spawnMobTF08Fix)
			{
				EntityRegistry.addSpawn(EntityTSF1.class, (int)((8.0D * TFaddon.conf.spawnMobTF08FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF08FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF08FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF08);
				EntityRegistry.addSpawn(EntityTSF2.class, (int)((8.0D * TFaddon.conf.spawnMobTF08FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF08FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF08FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF08);
				EntityRegistry.addSpawn(EntityTSF3.class, (int)((8.0D * TFaddon.conf.spawnMobTF08FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF08FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF08FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF08);
			}
		}

		if(biomesTF11 != null)
		{
			if (TFaddon.conf.spawnMobTF11Fix)
			{
				EntityRegistry.addSpawn(EntityTSFwada.class, (int)((8.0D * TFaddon.conf.spawnMobTF11FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF11FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF11FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF11);
			}
		}

		if(biomesTF18 != null)
		{
			if (TFaddon.conf.spawnMobTF18Fix)
			{
				EntityRegistry.addSpawn(EntityTSFfloat.class, (int)((1.0D * TFaddon.conf.spawnMobTF18FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF18FixMin) + 0.5D),  (int)((1.0D * TFaddon.conf.spawnMobTF18FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF18);
			}
		}

		if(biomesTF21 != null)
		{
			if (TFaddon.conf.spawnMobTF21Fix)
			{
				EntityRegistry.addSpawn(EntityTSFtake2.class, (int)((7.0D * TFaddon.conf.spawnMobTF21FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF21FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF21FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF21);
				EntityRegistry.addSpawn(EntityTSFtake3.class, (int)((7.0D * TFaddon.conf.spawnMobTF21FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF21FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF21FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF21);
			}
		}

		if(biomesTF24 != null)
		{
			if (TFaddon.conf.spawnMobTF24Fix)
			{
				EntityRegistry.addSpawn(EntityTSFkinzhal.class, (int)((7.0D * TFaddon.conf.spawnMobTF24FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF24FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF24FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF24);
				EntityRegistry.addSpawn(EntityTSFtank.class, (int)((7.0D * TFaddon.conf.spawnMobTF24FixRate) + 0.5D), (int)((1.0D * TFaddon.conf.spawnMobTF24FixMin) + 0.5D),  (int)((2.0D * TFaddon.conf.spawnMobTF24FixMax) + 0.5D),  EnumCreatureType.monster, biomesTF24);
			}
		}
	}
}
