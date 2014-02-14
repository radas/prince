package cz.tieto.princegame.domain.scene;

public interface Scene {

    boolean isPathClearForJumpForward();

    boolean isPathClearForJumpBackward();

    void setPathClearForJumpForward(boolean pathClearForJumpForward);

    void setPathClearForJumpBackward(boolean pathClearForJumpBackward);

}
