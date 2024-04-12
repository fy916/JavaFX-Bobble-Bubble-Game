module com.fy916.bubblebobble {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.media;


    opens com.fy916.bubblebobble to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements.movingelements;
    opens com.fy916.bubblebobble.gaming.elements.movingelements to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements.mapelements;
    opens com.fy916.bubblebobble.gaming.elements.mapelements to javafx.fxml;
    exports com.fy916.bubblebobble;
    exports com.fy916.bubblebobble.controllers;
    opens com.fy916.bubblebobble.controllers to javafx.fxml;
    exports com.fy916.bubblebobble.utilities;
    opens com.fy916.bubblebobble.utilities to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements.features.die;
    opens com.fy916.bubblebobble.gaming.elements.features.die to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements.features.jump;
    opens com.fy916.bubblebobble.gaming.elements.features.jump to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.world;
    opens com.fy916.bubblebobble.gaming.world to javafx.fxml;
    exports com.fy916.bubblebobble.controllers.renderer;
    opens com.fy916.bubblebobble.controllers.renderer to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements.features.collision;
    opens com.fy916.bubblebobble.gaming.elements.features.collision to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements.features.updater;
    opens com.fy916.bubblebobble.gaming.elements.features.updater to javafx.fxml;
    exports com.fy916.bubblebobble.gaming.elements;
    opens com.fy916.bubblebobble.gaming.elements to javafx.fxml;
}