package proxy;

import java.io.File;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.network.IGuiHandler;

public class ClientProxy extends CommonProxy implements IGuiHandler
{

	@Override
	public File getDir()
	{
		return Minecraft.getMinecraft().mcDataDir;
	}
}
