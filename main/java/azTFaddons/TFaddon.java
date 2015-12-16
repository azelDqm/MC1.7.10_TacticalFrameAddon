package azTFaddons;

import handler.EndoraHandler;
import net.minecraftforge.common.MinecraftForge;
import proxy.CommonProxy;
import azTFaddons.entity.MobSpawnRegister;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "TacticalFramesAddonTypeC", name = "TacticalFramesAddonTypeC", version = "1.0.0", useMetadata = true, dependencies = "after:TacticalFrame")
public class TFaddon {

	public static TFaddonConf conf;

	@SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance("TacticalFramesAddonTypeC")
	public static TFaddon instance;
	public static int debug = 1;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		conf = new TFaddonConf();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// MinecraftForge.EVENT_BUS.register(new DqmEventHandler());
		instance = this;
		new MobSpawnRegister();

		if(this.conf.endoraFix > 0)
		{
			MinecraftForge.EVENT_BUS.register(new EndoraHandler());
		}

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
