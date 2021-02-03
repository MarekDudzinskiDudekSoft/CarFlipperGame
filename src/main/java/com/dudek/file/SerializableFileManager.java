package com.dudek.file;

import com.dudek.exceptions.DataExportException;
import com.dudek.exceptions.DataImportException;
import com.dudek.model.GameState.GameState;

import java.io.*;

public class SerializableFileManager implements Serializable{
    private static final String FILE_NAME = "GameState.o";

    public static void save(GameState state) {
        try (
                FileOutputStream fs = new FileOutputStream(FILE_NAME);
                ObjectOutputStream os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(state);
            System.out.println("Zapisano obiekt do pliku");
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }

    public static GameState load() {
        GameState gameState;
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            gameState = (GameState) ois.readObject();
            System.out.println("Wczytano plik zapisu!");
            return gameState;
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }
    }
}