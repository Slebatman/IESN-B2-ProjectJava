package userInterface;

import javax.swing.*;
import java.util.Objects;

public class AnimationThread extends Thread{
    private JPanel panel;
    private boolean animation;
    private JLabel imageAnimation;

    public AnimationThread(JPanel panel){
        this.panel = panel;
        animation = true;
        Icon imageIcon = new ImageIcon(getClass().getResource("ressources/animation.gif"));
        imageAnimation = new JLabel(imageIcon);
        imageAnimation.setSize(200, 150);
    }

    @Override
    public void run(){
        try{
            panel.add(imageAnimation);
            Thread.sleep(1000);
            animation = false;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
