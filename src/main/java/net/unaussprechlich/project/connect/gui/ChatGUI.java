package net.unaussprechlich.project.connect.gui;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.unaussprechlich.managedgui.lib.event.EnumDefaultEvents;
import net.unaussprechlich.managedgui.lib.event.util.Event;
import net.unaussprechlich.managedgui.lib.gui.GUI;
import net.unaussprechlich.managedgui.lib.handler.MouseHandler;
import net.unaussprechlich.managedgui.lib.templates.defaults.container.DefBackgroundContainerFrame;
import net.unaussprechlich.managedgui.lib.templates.tabs.containers.TabContainer;
import net.unaussprechlich.managedgui.lib.templates.tabs.containers.TabListElementContainer;
import net.unaussprechlich.managedgui.lib.templates.tabs.containers.TabManager;
import net.unaussprechlich.managedgui.lib.util.DisplayUtil;
import net.unaussprechlich.managedgui.lib.util.EnumRGBA;

/**
 * ChatGUI Created by Alexander on 24.02.2017.
 * Description:
 **/
public class ChatGUI extends GUI{

    private final TabManager tabManager = new TabManager();

    private static final int WIDTH  = 500;
    private static final int HEIGHT = 200;


    public ChatGUI(){

        registerChild(tabManager);





        tabManager.registerTab(new TabContainer(new TabListElementContainer("ALL", EnumRGBA.WHITE.get(), tabManager),  new DefBackgroundContainerFrame(WIDTH, HEIGHT, EnumRGBA.WHITE.get()), tabManager));
        tabManager.registerTab(new TabContainer(new TabListElementContainer("Party", EnumRGBA.BLUE.get(), tabManager), new DefBackgroundContainerFrame(WIDTH, HEIGHT, EnumRGBA.BLUE.get()), tabManager));
        tabManager.registerTab(new TabContainer(new TabListElementContainer("Guild", EnumRGBA.GREEN.get(), tabManager), new DefBackgroundContainerFrame(WIDTH, HEIGHT, EnumRGBA.GREEN.get()), tabManager));
        tabManager.registerTab(new TabContainer(new TabListElementContainer("Private", EnumRGBA.RED.get(), tabManager), new DefBackgroundContainerFrame(WIDTH, HEIGHT, EnumRGBA.RED.get()), tabManager));

        updatePosition();
    }

    private void updatePosition(){
        tabManager.setXOffset(5);
        tabManager.setYOffset(DisplayUtil.getScaledMcHeight() - HEIGHT - 17 - 5);
    }


    @Override
    public boolean doClientTick() {
        System.out.println();
        return true;
    }

    @Override
    public boolean doRender(int xStart, int yStart) {
        return true;
    }

    @Override
    public boolean doChatMessage(ClientChatReceivedEvent e) {
        return true;
    }

    @Override
    public boolean doMouseMove(int mX, int mY) {
        return true;
    }

    @Override
    public boolean doScroll(int i) {
        return true;
    }

    @Override
    public boolean doClick(MouseHandler.ClickType clickType) {
        return true;
    }

    @Override
    public <T extends Event> boolean doEventBus(T event) {
        if(event.getID() == EnumDefaultEvents.SCREEN_RESIZE.get()){
            updatePosition();
        }
        return true;
    }

    @Override
    public boolean doOpenGUI(GuiOpenEvent e) {
        return true;
    }
}
