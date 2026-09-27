package namelessju.modmenuclicksoundfix.client.mixin;

import com.terraformersmc.modmenu.gui.widget.entries.ModListEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModListEntry.class)
public class ModListEntryMixin
{
    @Shadow @Final protected Minecraft client;

    @Inject(
        method = "mouseClicked",
        at = @At(value = "INVOKE", target = "Lcom/terraformersmc/modmenu/gui/widget/entries/ModListEntry;openConfig()V")
    )
    private void init(CallbackInfoReturnable<Boolean> cir)
    {
        AbstractWidget.playButtonClickSound(this.client.getSoundManager());
    }
}
