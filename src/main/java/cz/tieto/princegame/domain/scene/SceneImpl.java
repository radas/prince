package cz.tieto.princegame.domain.scene;

public class SceneImpl implements Scene {

    private boolean pathClearForJumpForward;

    private boolean pathClearForJumpBackward;

    @Override
    public boolean isPathClearForJumpForward() {

        return pathClearForJumpForward;

    }

    @Override
    public void setPathClearForJumpForward(boolean pathClearForJumpForward) {

        this.pathClearForJumpForward = pathClearForJumpForward;

    }

    @Override
    public boolean isPathClearForJumpBackward() {

        return pathClearForJumpBackward;

    }

    @Override
    public void setPathClearForJumpBackward(boolean pathClearForJumpBackward) {

        this.pathClearForJumpBackward = pathClearForJumpBackward;

    }

}
