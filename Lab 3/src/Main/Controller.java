package Main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Controller {
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private Label l9;
    @FXML
    private Label l10;
    @FXML
    private Label l11;
    @FXML
    private Label l12;

    @FXML
    private final Label[] tab = new Label[12];

    @FXML
    private ProgressBar pb1;
    @FXML
    private ProgressBar pb2;
    @FXML
    private ProgressBar pb3;
    @FXML
    private ProgressBar pb4;
    @FXML
    private ProgressBar pb5;
    @FXML
    private ProgressBar pb6;
    @FXML
    private ProgressBar pb7;
    @FXML
    private ProgressBar pb8;
    @FXML
    private ProgressBar pb9;
    @FXML
    private ProgressBar pb10;
    @FXML
    private ProgressBar pb11;
    @FXML
    private ProgressBar pb12;

    @FXML
    private final ProgressBar[] tabpb = new ProgressBar[12];

    @FXML
    private Label pos1;

    @FXML
    private Label pos2;

    @FXML
    private Label pos3;

    @FXML
    private Label pos4;

    @FXML
    private Label topka;

    @FXML
    private final Label[] top = new Label[4];

    @FXML
    public void initialize() {
        setLabels();
        setPB();
        setTop();
        Race r = new Race(tab, tabpb, top, topka);
    }

    void setTop() {
        top[0] = pos1;
        top[1] = pos2;
        top[2] = pos3;
        top[3] = pos4;
        for (int i = 0; i < 4; ++i)
            top[i].setVisible(false);
        topka.setVisible(false);
    }


    void setLabels() {
        tab[0] = l1;
        tab[1] = l2;
        tab[2] = l3;
        tab[3] = l4;
        tab[4] = l5;
        tab[5] = l6;
        tab[6] = l7;
        tab[7] = l8;
        tab[8] = l9;
        tab[9] = l10;
        tab[10] = l11;
        tab[11] = l12;
        for (int i = 0; i < 12; ++i)
            tab[i].setVisible(false);
    }

    void setPB() {
        tabpb[0] = pb1;
        tabpb[1] = pb2;
        tabpb[2] = pb3;
        tabpb[3] = pb4;
        tabpb[4] = pb5;
        tabpb[5] = pb6;
        tabpb[6] = pb7;
        tabpb[7] = pb8;
        tabpb[8] = pb9;
        tabpb[9] = pb10;
        tabpb[10] = pb11;
        tabpb[11] = pb12;
        for (int i = 0; i < 12; ++i)
            tabpb[i].setVisible(false);
    }
}
