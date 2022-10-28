package de.frostforge.backend.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    /**
     * If you Start the application after a database drop activate this method to seed the database.
     * Important: If you want to use the findGameByID() method in the game Domain you have to deactivate this method for now
     * otherwise the rating to game_id mapping will break and return no data
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

    }

    /**
     * Build privat classes for every table that should be seeded ! later switch to migrations
     */
}
