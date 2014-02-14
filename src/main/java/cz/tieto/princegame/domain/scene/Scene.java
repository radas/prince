package cz.tieto.princegame.domain.scene;

public interface Scene {

    boolean isAtSceneEnd();

    boolean isAtSceneStart();

    void appendSceneElement();

    void prependSceneElement();

    int currentScenePosition();

    boolean isPathClearForJumpForward(int currentScenePosition);

    boolean isPathClearForJumpBackward(int currentScenePosition);

}
