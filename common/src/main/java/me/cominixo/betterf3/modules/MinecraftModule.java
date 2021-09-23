package me.cominixo.betterf3.modules;

import me.cominixo.betterf3.utils.DebugLine;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextColor;

public class MinecraftModule extends BaseModule{

    public MinecraftModule() {
        defaultNameColor = TextColor.fromRgb(0xA0522D);
        defaultValueColor =  TextColor.fromLegacyFormat(ChatFormatting.DARK_GREEN);

        this.nameColor = defaultNameColor;
        this.valueColor = defaultValueColor;

        lines.add(new DebugLine("minecraft", "format.betterf3.default_no_colon", false));
        lines.get(0).inReducedDebug = true;
    }

    public void update(Minecraft client) {
        //TODO Fix ClientBrandRetriever.getClientModName() on forge
        lines.get(0).setValue(SharedConstants.getCurrentVersion().getName() + " (" + client.getLaunchedVersion() +
                "/" + /*ClientBrandRetriever.getClientModName() +*/ ("release".equalsIgnoreCase(client.getVersionType()) ? "" : "/" + client.getVersionType()) + ")");

    }
}
