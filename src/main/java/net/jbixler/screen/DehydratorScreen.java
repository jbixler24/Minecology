//package net.jbixler.screen;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.jbixler.Minecology;
//import net.minecraft.client.gl.ShaderProgramKeys;
//import net.minecraft.client.gui.DrawContext;
//import net.minecraft.client.gui.screen.ingame.HandledScreen;
//import net.minecraft.client.render.RenderLayer;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//
//public class DehydratorScreen extends HandledScreen<DehydratorScreenHandler> {
//
//    private static final Identifier TEXTURE = Identifier.of(Minecology.MOD_ID, "textures/gui/dehydrator.png");
//
//    public DehydratorScreen(DehydratorScreenHandler handler, PlayerInventory inventory, Text title) {
//        super(handler, inventory, title);
//    }
//
//    @Override
//    protected void init() {
//        super.init();
//        this.titleY = 1000;
//        this.playerInventoryTitleY = 1000;
//    }
//
//    @Override
//    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
//        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX);
//        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int x = (this.width - this.backgroundWidth) / 2;
//        int y = (this.height - this.backgroundHeight) / 2;
//        context.drawGuiTexture(id -> RenderLayer.getGuiOverlay(), TEXTURE, x, y, 0, 0);
//
////        renderProgressMethod(context, x, y);
//    }
//
//    // TODO: implement
////    private void renderProgressMethod(DrawContext context, int x, int y) {
////        if (handler.isCrafting()) {
////            context.drawGuiTexture(id -> RenderLayer.getGuiOverlay(), TEXTURE, x+85, y+30, 176, 0, 8, handler.getScaledProgress());
////        }
////    }
//
//    @Override
//    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
//        renderBackground(context, mouseX, mouseY, delta);
//        super.render(context, mouseX, mouseY, delta);
//        drawMouseoverTooltip(context, mouseX, mouseY);
//    }
//}
