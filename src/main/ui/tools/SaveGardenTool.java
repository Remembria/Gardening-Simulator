package ui.tools;

import model.Garden;
import persistence.JsonWriter;
import ui.DrawingCanvas;
import ui.GameApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// A class for saving the garden to JSON format
public class SaveGardenTool extends GameButton implements ActionListener {

    //private GameApp mainGame;
    //private Garden mainGarden;
    //private DrawingCanvas drawing;
    private JsonWriter jsonWriter;

    // EFFECT: Initializes the save garden tool
    public SaveGardenTool(JPanel parent, GameApp gameApp) {
        super("Save Garden", parent, gameApp);
        initializeButton(700, 40, this);
        //this.mainGame = gameApp;
        //this.mainGarden = gameApp.getMainGarden();
        //this.drawing = gameApp.getDrawing();
        this.jsonWriter = new JsonWriter(gameApp.JSON_STORE);
    }

    // EFFECTS: Responsible for saving the garden to a JSON directory
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame jframe = new JFrame();
        try {
            jsonWriter.open();
            jsonWriter.write(mainGarden);
            jsonWriter.close();
        } catch (FileNotFoundException error) {
            JOptionPane.showMessageDialog(jframe,
                    "ERROR: File not found at " + mainGame.JSON_STORE, "Groundskeeper:",
                    JOptionPane.PLAIN_MESSAGE);
        }
        JOptionPane.showMessageDialog(jframe,
                "Garden checkpoint saved to " + mainGame.JSON_STORE, "Groundskeeper:",
                JOptionPane.PLAIN_MESSAGE);
    }


//    // A private ActionListener class to handle saving the garden  when the given button is pressed
//    private class SaveGarden implements ActionListener {
//
//        // EFFECTS: Responsible for saving the garden to a JSON directory
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JFrame jframe = new JFrame();
//            try {
//                jsonWriter.open();
//                jsonWriter.write(mainGarden);
//                jsonWriter.close();
//            } catch (FileNotFoundException error) {
//                JOptionPane.showMessageDialog(jframe,
//                        "ERROR: File not found at " + mainGame.JSON_STORE, "Groundskeeper:",
//                        JOptionPane.PLAIN_MESSAGE);
//            }
//            JOptionPane.showMessageDialog(jframe,
//                    "Garden checkpoint saved to " + mainGame.JSON_STORE, "Groundskeeper:",
//                    JOptionPane.PLAIN_MESSAGE);
//        }
//    }
}
