package com.cs.home234;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author LH
 * @ClassName ImageServlet
 * @Description
 * @date 2019/5/12 20:38
 */
public class ImageServlet  extends HttpServlet {
    @Override
    public void service(ServletRequest re, ServletResponse rr) throws ServletException, IOException {
            HttpServletResponse res=(HttpServletResponse)rr;
        HttpServletRequest req=(HttpServletRequest)re;
            BufferedImage image = new BufferedImage(120, 40,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) image.getGraphics();
            g2d.setColor(Color.gray);
            g2d.drawRect(0, 0, 120, 40);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(0, 0, 120, 40);
            int x = 15, y = 26;
            String str = "ABCDEFGHIGKLMNOPQRSTUVWSYZabcdefghijklmnopqrstuvwsyz0123456789";
            g2d.setFont(new Font("宋体", Font.BOLD, 29));
            Random r = new Random();
            String msg = "";
            for (int i = 0; i < 4; i++) {
                g2d.setColor(Color.red);
                int n = r.nextInt(60) - 30;
                double hudu = n * Math.PI / 180;
                int index = r.nextInt(str.length());
                char ch = str.charAt(index);
                g2d.rotate(hudu, x, y);
                g2d.drawString(ch + "", x, y);
                msg = msg + ch;
                if (i <= 2) {
                    g2d.setColor(Color.blue);
                    g2d.drawLine(0, 8, 180, 26);
                    g2d.setColor(Color.yellow);
                    g2d.drawLine(0, 27, 180, 2);
                }
                g2d.rotate(-hudu, x, y);
                x += 23;
            }
             req.getSession().setAttribute("image", msg);
            try {
                ImageIO.write(image, "png", res.getOutputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
