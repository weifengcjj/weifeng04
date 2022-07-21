package com.wxjsxy.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class CW extends JDialog {
    public void Cw()
    {
        setVisible(true);
        setBounds(700,400,300,200);
        Container container=getContentPane();
        container.add(new JLabel("账户或密码错误了"));
    }
}
