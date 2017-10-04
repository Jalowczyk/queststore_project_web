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
    public void testGetExperienceReturnsExpectedValue() {

        int actual = this.wallet.getExperience();
        assertEquals(100, actual);

    }

    @Test
    public void testGetBalanceReturnsExpectedValue() {

        int actual = this.wallet.getBalance();
        assertEquals(100, actual);

    }

    @Test
    public void testGetArtifactsReturnsExpectedValue() {

        ArrayList<Artifact> actual = this.wallet.getArtifacts();
        assertIterableEquals(this.artifacts, actual);

    }

}