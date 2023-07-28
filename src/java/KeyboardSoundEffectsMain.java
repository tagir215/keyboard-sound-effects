
import java.io.File;
import java.net.URL;
import java.util.Timer;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;


public class KeyboardSoundEffectsMain{
	Player player;
	File folder;
	GlobalKeyboardHook keyboardhook;
	GlobalMouseHook mousehook;
	boolean ctrlPressed;
	double lastClickTime = 0;
	final int DOUBLE_CLICK_DELAY = 300; 
	
	KeyboardSoundEffectsMain(){
		player = new Player();
		URL s_ctrl_z = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_ZTarget_Cancel.wav");
		URL s_ctrl_x = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_Dialogue_Done.wav");
		URL s_ctrl_c = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_Arrow_Select.wav");
		URL s_ctrl_v = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_PauseMenu_Close.wav");
		URL s_ctrl_s = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_PressStart.wav");
		URL s_ctrl_y = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_ZTarget_Object.wav");
		URL s_return = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_MainMenu_Letter.wav");
		URL s_tab = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_MainMenu_Cursor.wav");
		URL s_shift = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_MiniMap_Off.wav");
		URL s_back = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_Ticktock3.wav");
		URL s_arrows = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_MainMenu_Cursor.wav");
		URL s_alt = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_Arrow_Select_Ice.wav");
		URL leftClick = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_Dialogue_Next.wav");
		URL rightClick = KeyboardSoundEffectsMain.class.getResource("/resources/effects/OOT_PauseMenu_Select.wav");

		mousehook = new GlobalMouseHook();
        mousehook.addMouseListener(new GlobalMouseAdapter() {
           

            @Override
            public void mouseReleased(GlobalMouseEvent event) {
            	 long currentTime = System.currentTimeMillis();
            	 if (currentTime - lastClickTime <= DOUBLE_CLICK_DELAY) {
            		 return;
            	 }
            	
            	 switch (event.getButton()) {
            	 
                 case GlobalMouseEvent.BUTTON_LEFT:
                     player.play(leftClick);
                     break;
                 case GlobalMouseEvent.BUTTON_RIGHT:
                     player.play(rightClick);
                     break;
            	 }
            	 lastClickTime = System.currentTimeMillis();
            }
        });

		keyboardhook = new GlobalKeyboardHook(true);
		keyboardhook.addKeyListener(new GlobalKeyAdapter(){
			@Override
			public void keyPressed(GlobalKeyEvent event){
				if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_CONTROL)
					ctrlPressed = true;
				
			}
			@Override
			public void keyReleased(GlobalKeyEvent event){
				 
				
				
				switch(event.getVirtualKeyCode()){
					 
					case GlobalKeyEvent.VK_CONTROL: ctrlPressed = false; 
						break;
					case GlobalKeyEvent.VK_C:
						if(ctrlPressed){player.play(s_ctrl_c);}
						break;
					case GlobalKeyEvent.VK_V:
						if(ctrlPressed){player.play(s_ctrl_v);}
						break;
					case GlobalKeyEvent.VK_S:
						if(ctrlPressed){player.play(s_ctrl_s);}
						break;
					case GlobalKeyEvent.VK_Z:
						if(ctrlPressed){player.play(s_ctrl_z);}
						break;
					case GlobalKeyEvent.VK_Y:
						if(ctrlPressed){player.play(s_ctrl_y);}
						break;
					case GlobalKeyEvent.VK_X:
						if(ctrlPressed){player.play(s_ctrl_x);}
						break;
					case GlobalKeyEvent.VK_7:
					case GlobalKeyEvent.VK_0:
						if(ctrlPressed){player.play(s_ctrl_x);}
						break;
					case GlobalKeyEvent.VK_ESCAPE:
						if(ctrlPressed){System.exit(0);}
						break;
					case GlobalKeyEvent.VK_MENU:
						if(ctrlPressed){player.play(s_alt);}
						break;
					case GlobalKeyEvent.VK_TAB:
						player.play(s_tab);
						break;
					case GlobalKeyEvent.VK_LSHIFT:
					case GlobalKeyEvent.VK_SHIFT:
						player.play(s_shift);
						break;
					case GlobalKeyEvent.VK_RETURN:
						player.play(s_return);
						break;
					case GlobalKeyEvent.VK_DELETE:
					case GlobalKeyEvent.VK_BACK:
						player.play(s_back);
						break;
					case GlobalKeyEvent.VK_UP:
					case GlobalKeyEvent.VK_DOWN:
					case GlobalKeyEvent.VK_LEFT:
					case GlobalKeyEvent.VK_RIGHT:
						player.play(s_arrows);
						break;

				}
			}
		});
	}


	public static void main(String[] args){
		new KeyboardSoundEffectsMain();		
	}
	
	
}

