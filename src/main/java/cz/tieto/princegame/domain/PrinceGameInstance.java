package cz.tieto.princegame.domain;

import cz.tieto.princegame.common.gameobject.Prince;
import cz.tieto.princegame.domain.prince.PrinceDTO;
import cz.tieto.princegame.domain.scene.Scene;
import cz.tieto.princegame.domain.scene.SceneImpl;

public class PrinceGameInstance {

    private static PrinceGameInstance princeGameInstance;

    private PrinceDTO princeDto;

    private Scene scene;

    private PrinceGameInstance() {

    }

    public static PrinceGameInstance getInstance() {

        return princeGameInstance;

    }

    public static void setInstance(PrinceGameInstance aPrinceGameInstance) {

        princeGameInstance = aPrinceGameInstance;

    }

    public static void initInstance(Prince prince) {

        princeGameInstance = new PrinceGameInstance();

        princeGameInstance.princeDto = new PrinceDTO(prince);
        princeGameInstance.scene = new SceneImpl();

    }

    public PrinceDTO getPrinceDto() {

        return princeDto;

    }

    public Scene getScene() {

        return scene;

    }

}
