package net.jbixler.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jbixler.Minecology;
import net.minecraft.client.RunArgs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DehydratorScreen extends HandledScreen<DehyratorScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(Minecology.MOD_ID, "textures/gui/dehydrator.png");

    public DehydratorScreen(DehyratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;

    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderLayer layer = RenderLayer.getGui();
//        context.drawTexture((TEXTURE) -> Registries., this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta); // Render the default background
        super.render(context, mouseX, mouseY, delta); // Render the screen
        this.drawMouseoverTooltip(context, mouseX, mouseY); // Handle tooltips
    }
}
