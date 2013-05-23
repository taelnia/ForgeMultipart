package codechicken.multipart.minecraft;

import net.minecraftforge.common.MinecraftForge;
import codechicken.core.asm.CodeChickenCorePlugin;
import codechicken.core.packet.PacketCustom;
import codechicken.core.packet.PacketCustom.CustomTinyPacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name="Minecraft Multipart", version="1.0.0.0", useMetadata = false, modid = "McMultipart", acceptedMinecraftVersions=CodeChickenCorePlugin.mcVersion)
@NetworkMod(clientSideRequired = true, serverSideRequired = true, tinyPacketHandler=CustomTinyPacketHandler.class)
public class MinecraftMultipartMod
{
    @Instance("McMultipart")
    public static MinecraftMultipartMod instance;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        new Content().init();
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        PacketCustom.assignHandler(this, new McMultipartSPH());
    }
}
