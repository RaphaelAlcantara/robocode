package ifpe.edu.robocode;

import robocode.Robot;

import java.awt.*;

public class Ttinha extends Robot {

    @Override
    public void run() {

        setColors(Color.black,Color.red, Color.black); // body,gun,radar

          while(true){
              ahead(125);
              turnGunRight(360);
              back(125);
              turnGunRight(360);
          }
    }

    //onScannedRobot: O que fazer quando você vê um outro robô
    @Override
    public void onScannedRobot(robocode.ScannedRobotEvent inimigo) {
        double distancia = inimigo.getDistance();
        double angulo = inimigo.getBearing();

        if(distancia < 100){
            turnGunLeft(angulo);
            fire(3);
        }

            fire(1);
    }


    //onHitByBullet: O que fazer quando você for atingido por uma munição
    @Override
    public void onHitByBullet(robocode.HitByBulletEvent event) {
        back(125);
    }

    //onHitWall: O que fazer quando você atingir uma parede
    @Override
    public void onHitWall(robocode.HitWallEvent event) {
        turnRight(150);
        back(100);
    }

}
