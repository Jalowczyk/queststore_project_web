package com.school.models;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WalletTest {

    private Wallet wallet;

    @BeforeEach
    public void before() {
        ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
        artifacts.add(new Artifact("artifact1"));
        artifacts.add(new Artifact("artifact2"));

        this.wallet = new Wallet(1, 100, 100, artifacts);
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

}