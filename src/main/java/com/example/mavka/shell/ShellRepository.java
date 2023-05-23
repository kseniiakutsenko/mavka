package com.example.mavka.shell;

import com.example.mavka.shell.model.Shell;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ShellRepository {
    private static final String CSV_FILE_PATH = "src/main/java/com/example/mavka/shell/weapon_database.csv";
    private List<Shell> shells = new ArrayList<>();

    public Shell loadShellsFromCSV() {

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name_of_weapon = data[1].trim();
                String name_of_shell = data[2].trim();
                float kalibr = Float.parseFloat(data[3].trim());
                int OFS = Integer.parseInt(data[4].trim());
                int APC = Integer.parseInt(data[5].trim());
                float speed = Float.parseFloat(data[6].trim());
                float weight = Float.parseFloat(data[7].trim());
                int start_speed = Integer.parseInt(data[8].trim());
                float Cd = Float.parseFloat(data[9].trim());
                shells.add(new Shell(id, name_of_weapon, name_of_shell, kalibr, OFS, APC, speed, weight, start_speed, Cd));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public Shell returnbuid(long id_weapon) {
        loadShellsFromCSV();
        for (Shell shell : shells) {
            if (shell.id() == id_weapon) {
                return shell;
            }
        }

        return null;
    }

    public List<Shell> returnallshells() {
        loadShellsFromCSV();
        return shells;
    }

}
