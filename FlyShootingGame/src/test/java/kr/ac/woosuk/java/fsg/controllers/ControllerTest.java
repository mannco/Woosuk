package kr.ac.woosuk.java.fsg.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;

class ControllerTest {

    @Test
    void 蹿磐积己() {
        Controller controller = new Controller();
        Doctor doctor = new DoctorRed();
        controller.addDoctor(doctor);

        assertNotNull(controller.getDoctors());

    }

    @Test
    void 局呈固积己() {
        Controller controller = new Controller();
        Enemy enemy = new Virus();
        controller.addEnemy(enemy);

        assertNotNull(controller.getEnemies());

    }
    @Test
    void 蹿磐家戈() {
        Controller controller = new Controller();
        Doctor doctor = new DoctorRed();
        controller.addDoctor(doctor);
        assertNotNull(controller.getDoctors());

        controller.removeDoctor();

        assertNull(controller.getDoctors());

    }

    @Test
    void 利家戈() {
        Controller controller = new Controller();
        Enemy enemy = new Virus();
        controller.addEnemy(enemy);

        assertNotNull(controller.getEnemies());

        controller.removeEnemy(enemy);

        assertNull(controller.getEnemies());

    }
}