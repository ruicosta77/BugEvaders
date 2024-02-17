package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.positions.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class McBullet {
        private static final int BULLET_SPEED = 10;
        private Position position;
        private Picture bulletImage;

        public McBullet(Position position) {
            this.position = position;
            this.bulletImage = new Picture(position.getX(), position.getY(), "BugEvaders/resources/mcBullet.png");
            this.bulletImage.draw();
        }

        public void moveDown() {
            position.setY(position.getY() + BULLET_SPEED);
            bulletImage.translate(0, +BULLET_SPEED);
        }

        public boolean checkCollision(Player player) {
            //return player.getPlayerX() >= (this.getPosition().getX()) && ((player.getPlayerX())  + (player.getPlayerImage().getWidth()) >= this.getPosition().getX() && player.getPlayerY() == this.getPosition().getY());
            return player.getPlayerX() <= (this.getPosition().getX()) && ((player.getPlayerX())  + (player.getPlayerImage().getWidth()) <= this.getPosition().getX() && player.getPlayerY() == this.getPosition().getY());

        }

        public void delete() {
            bulletImage.delete();
        }

        public Position getPosition() {
            return position;
        }


        @Override
        public String toString() {
            return "BugProjectile{" +
                    "position=" + position +
                    ", projectileImage=" + bulletImage +
                    '}';
        }


}
