package com.school.models;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WalletTest {

    private Wallet wallet;
    private static ArrayList<Artifact> artifacts;

    @BeforeAll
    public static void setup() {
        artifacts = new ArrayList<Artifact>();
        artifacts.add(new Artifact("artifact1"));
        artifacts.add(new Artifact("artifact2"));
    }

    @BeforeEach
    public void before() {
        this.wallet = new Wallet(1, 100, 100, this.artifacts);
    }

    @Test
    public void testGetWalletIdReturnsExpectedValue() {

        int actual = this.wallet.getWalletId();
        assertEquals(1, actual);

    }

    @Test
    public void testSetWalletIdChangesValueToExpected() {

        this.wallet.setWalletId(2);
        int actual = this.wallet.getWalletId();
        assertEquals(2, actual);

    }

    @Test
    public void testGetExperienceReturnsExpectedValue() {

        int actual = this.wallet.getExperience();
        assertEquals(100, actual);

    }

    @Test
    public void testSetExperienceChangesValueToExpected() {

        this.wallet.setExperience(200);
        int actual = this.wallet.getExperience();
        assertEquals(200, actual);

    }

    @Test
    public void testSetExperienceThrowsExcpetionIfValueBelow0() {

        assertThrows(IllegalArgumentException.class, () -> {
            this.wallet.setExperience(-100);
        });

    }

    @Test
    public void testGetBalanceReturnsExpectedValue() {

        int actual = this.wallet.getBalance();
        assertEquals(100, actual);

    }

    @Test
    public void testSetBalanceChangesValueToExpected() {

        this.wallet.setBalance(200);
        int actual = this.wallet.getBalance();
        assertEquals(200, actual);

    }

    @Test
    public void testSetBalanceThrowsExcpetionIfValueBelow0() {

        assertThrows(IllegalArgumentException.class, () -> {
            this.wallet.setBalance(-100);
        });

    }

    @Test
    public void testGetArtifactsReturnsExpectedValue() {

        ArrayList<Artifact> actual = this.wallet.getArtifacts();
        assertIterableEquals(this.artifacts, actual);

    }

    @Test
    public void testAddArtifactIsAddByReference() {

        Artifact newArtifact = new Artifact("artifact3");
        ArrayList<Artifact> expected = artifacts;
        expected.add(newArtifact);
        this.wallet.addArtifact(newArtifact);
        assertIterableEquals(expected, this.wallet.getArtifacts());

    }

    @Test
    public void testAddCoolcoinsChangesExperience() {

        this.wallet.addCoolcoins(100);
        int actual = this.wallet.getExperience();
        assertEquals(200, actual);

    }

    @Test
    public void testAddCoolcoinsChangesBalance() {

        this.wallet.addCoolcoins(100);
        int actual = this.wallet.getBalance();
        assertEquals(200, actual);

    }

    @Test
    public void testCalculateLevelReturnsExpectedValue() {

        this.wallet.setExperience(2795);
        int actual = this.wallet.calculateLevel();
        assertEquals(2, actual);

    }

    @Test
    public void testCalculateLevelNeverReturns0() {

        int actual = this.wallet.getExperience();
        assertEquals(1, actual);

    }

    
}