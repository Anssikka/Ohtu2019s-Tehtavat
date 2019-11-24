package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Miinus extends Komento {
    private int edellinenArvo;
    Miinus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    @Override
    public void suorita() {
        edellinenArvo = Integer.parseInt(tuloskentta.getText());
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }


        sovellus.miinus(arvo);
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + edellinenArvo);
        sovellus.nollaa();
        sovellus.plus(edellinenArvo);
        undo.disableProperty().set(true);
    }
}
