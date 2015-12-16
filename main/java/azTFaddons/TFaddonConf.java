package azTFaddons;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

public class TFaddonConf {

	Configuration cfg_core = new Configuration(new File(TFaddon.proxy.getDir(), "config/TacticalFrame_Add_Chaos.cfg"));

	//public String rejectBiome = "14, 15";
	//public HashMap<Integer, Boolean> rejectBiomeHT = new HashMap<Integer, Boolean>();
	public int endoraFix = 3;

	public boolean spawnMobMechaFix = true;
	public double spawnMobMechaFixMax  = 1.5D;
	public double spawnMobMechaFixMin = 1.0D;
	public double spawnMobMechaFixRate = 3.0D;
	public String rejectBiomeMecha = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeMechaHT = new HashMap<Integer, Boolean>();


	public boolean spawnMobTMFix = true;
	public double spawnMobTMFixMax = 1.5D;
	public double spawnMobTMFixMin = 1.0D;
	public double spawnMobTMFixRate = 3.0D;
	public String rejectBiomeTM = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeTMHT = new HashMap<Integer, Boolean>();


	public boolean spawnMobTF08Fix = true;
	public double spawnMobTF08FixMax = 1.5D;
	public double spawnMobTF08FixMin = 1.0D;
	public double spawnMobTF08FixRate = 3.0D;
	public String rejectBiomeTF08 = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeTF08HT = new HashMap<Integer, Boolean>();


	public boolean spawnMobTF11Fix = true;
	public double spawnMobTF11FixMax = 1.5D;
	public double spawnMobTF11FixMin = 1.0D;
	public double spawnMobTF11FixRate = 3.0D;
	public String rejectBiomeTF11 = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeTF11HT = new HashMap<Integer, Boolean>();


	public boolean spawnMobTF18Fix = true;
	public double spawnMobTF18FixMax = 1.5D;
	public double spawnMobTF18FixMin = 1.0D;
	public double spawnMobTF18FixRate = 3.0D;
	public String rejectBiomeTF18 = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeTF18HT = new HashMap<Integer, Boolean>();


	public boolean spawnMobTF21Fix = true;
	public double spawnMobTF21FixMax = 1.5D;
	public double spawnMobTF21FixMin = 1.0D;
	public double spawnMobTF21FixRate = 3.0D;
	public String rejectBiomeTF21 = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeTF21HT = new HashMap<Integer, Boolean>();


	public boolean spawnMobTF24Fix = true;
	public double spawnMobTF24FixMax = 1.5D;
	public double spawnMobTF24FixMin = 1.0D;
	public double spawnMobTF24FixRate = 3.0D;
	public String rejectBiomeTF24 = "14, 15";
	public HashMap<Integer, Boolean> rejectBiomeTF24HT = new HashMap<Integer, Boolean>();


	public TFaddonConf()
	{
		String[] strSplit;

		cfg_core.load();

		cfg_core.setCategoryComment("separatesettingFix", "this setting is magnificate of monster spawn settings");
		/*
		rejectBiome = cfg_core.get("separatesettingFix", "Reject biomes", rejectBiome).getString();

		String[] strSplit = (rejectBiome.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeHT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}
		*/

		endoraFix = cfg_core.get("separatesettingFix", "Endora Fix (0:Disable or 1(VeryEasy) - 5(VeryHard))", endoraFix).getInt();

		spawnMobMechaFix = cfg_core.get("separatesettingFix typeMecha", "Spawn type.Mecha Fix Enable", spawnMobMechaFix).getBoolean();
		spawnMobMechaFixMax = cfg_core.get("separatesettingFix typeMecha", "Spawn type.Mecha Fix(Max)", spawnMobMechaFixMax).getDouble();
		spawnMobMechaFixMin = cfg_core.get("separatesettingFix typeMecha", "Spawn type.Mecha Fix(Min)", spawnMobMechaFixMin).getDouble();
		spawnMobMechaFixRate = cfg_core.get("separatesettingFix typeMecha", "Spawn type.Mecha Fix(Rate)", spawnMobMechaFixRate).getDouble();
		rejectBiomeMecha = cfg_core.get("separatesettingFix typeMecha", "Reject biomes", rejectBiomeMecha).getString();
		strSplit = (rejectBiomeMecha.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeMechaHT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		spawnMobTMFix = cfg_core.get("separatesettingFix typeTM", "Spawn type.TM Fix Enable", spawnMobTMFix).getBoolean();
		spawnMobTMFixMax = cfg_core.get("separatesettingFix typeTM", "Spawn type.TM Fix(Max)", spawnMobTMFixMax).getDouble();
		spawnMobTMFixMin = cfg_core.get("separatesettingFix typeTM", "Spawn type.TM Fix(Min)", spawnMobTMFixMin).getDouble();
		spawnMobTMFixRate = cfg_core.get("separatesettingFix typeTM", "Spawn type.TM Fix(Rate)", spawnMobTMFixRate).getDouble();
		rejectBiomeTM = cfg_core.get("separatesettingFix typeTM", "Reject biomes", rejectBiomeTM).getString();
		strSplit = (rejectBiomeTM.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeTMHT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		spawnMobTF08Fix = cfg_core.get("separatesettingFix typeTF08", "Spawn type.TF08 Fix Enable", spawnMobTF08Fix).getBoolean();
		spawnMobTF08FixMax = cfg_core.get("separatesettingFix typeTF08", "Spawn type.TF08 Fix(Max)", spawnMobTF08FixMax).getDouble();
		spawnMobTF08FixMin = cfg_core.get("separatesettingFix typeTF08", "Spawn type.TF08 Fix(Min)", spawnMobTF08FixMin).getDouble();
		spawnMobTF08FixRate = cfg_core.get("separatesettingFix typeTF08", "Spawn type.TF08 Fix(Rate)", spawnMobTF08FixRate).getDouble();
		rejectBiomeTF08 = cfg_core.get("separatesettingFix typeTF08", "Reject biomes", rejectBiomeTF08).getString();
		strSplit = (rejectBiomeTF08.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeTF08HT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		spawnMobTF11Fix = cfg_core.get("separatesettingFix typeTF11", "Spawn type.TF11 Fix Enable", spawnMobTF11Fix).getBoolean();
		spawnMobTF11FixMax = cfg_core.get("separatesettingFix typeTF11", "Spawn type.TF11 Fix(Max)", spawnMobTF11FixMax).getDouble();
		spawnMobTF11FixMin = cfg_core.get("separatesettingFix typeTF11", "Spawn type.TF11 Fix(Min)", spawnMobTF11FixMin).getDouble();
		spawnMobTF11FixRate = cfg_core.get("separatesettingFix typeTF11", "Spawn type.TF11 Fix(Rate)", spawnMobTF11FixRate).getDouble();
		rejectBiomeTF11 = cfg_core.get("separatesettingFix typeTF11", "Reject biomes", rejectBiomeTF11).getString();
		strSplit = (rejectBiomeTF11.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeTF11HT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		spawnMobTF18Fix = cfg_core.get("separatesettingFix typeTF18", "Spawn type.TF18 Fix Enable", spawnMobTF18Fix).getBoolean();
		spawnMobTF18FixMax = cfg_core.get("separatesettingFix typeTF18", "Spawn type.TF18 Fix(Max)", spawnMobTF18FixMax).getDouble();
		spawnMobTF18FixMin = cfg_core.get("separatesettingFix typeTF18", "Spawn type.TF18 Fix(Min)", spawnMobTF18FixMin).getDouble();
		spawnMobTF18FixRate = cfg_core.get("separatesettingFix typeTF18", "Spawn type.TF18 Fix(Rate)", spawnMobTF18FixRate).getDouble();
		rejectBiomeTF18 = cfg_core.get("separatesettingFix typeTF18", "Reject biomes", rejectBiomeTF18).getString();
		strSplit = (rejectBiomeTF18.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeTF18HT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		spawnMobTF21Fix = cfg_core.get("separatesettingFix typeTF21", "Spawn type.TF21 Fix Enable", spawnMobTF21Fix).getBoolean();
		spawnMobTF21FixMax = cfg_core.get("separatesettingFix typeTF21", "Spawn type.TF21 Fix(Max)", spawnMobTF21FixMax).getDouble();
		spawnMobTF21FixMin = cfg_core.get("separatesettingFix typeTF21", "Spawn type.TF21 Fix(Min)", spawnMobTF21FixMin).getDouble();
		spawnMobTF21FixRate = cfg_core.get("separatesettingFix typeTF21", "Spawn type.TF21 Fix(Rate)", spawnMobTF21FixRate).getDouble();
		rejectBiomeTF21 = cfg_core.get("separatesettingFix typeTF21", "Reject biomes", rejectBiomeTF21).getString();
		strSplit = (rejectBiomeTF21.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeTF21HT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		spawnMobTF24Fix = cfg_core.get("separatesettingFix typeTF24&26", "Spawn type.TF24&26 Fix Enable", spawnMobTF24Fix).getBoolean();
		spawnMobTF24FixMax = cfg_core.get("separatesettingFix typeTF24&26", "Spawn type.TF24&26 Fix(Max)", spawnMobTF24FixMax).getDouble();
		spawnMobTF24FixMin = cfg_core.get("separatesettingFix typeTF24&26", "Spawn type.TF24&26 Fix(Min)", spawnMobTF24FixMin).getDouble();
		spawnMobTF24FixRate = cfg_core.get("separatesettingFix typeTF24&26", "Spawn type.TF24&26 Fix(Rate)", spawnMobTF24FixRate).getDouble();
		rejectBiomeTF24 = cfg_core.get("separatesettingFix typeTF24&26", "Reject biomes", rejectBiomeTF24).getString();
		strSplit = (rejectBiomeTF24.replace(" ", "")).split(",");

		for(int cnt= 0; cnt < strSplit.length; cnt++)
		{
			try
			{
				int biomeId = Integer.parseInt(strSplit[cnt]);
				rejectBiomeTF24HT.put(biomeId, true);
			}catch (Exception e)
			{

			}
		}

		cfg_core.save();
	}
}
