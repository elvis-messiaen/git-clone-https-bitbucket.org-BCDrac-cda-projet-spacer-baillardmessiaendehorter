package fr.afpa.cda.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.afpa.cda.services.TestGameBusiness;

@RunWith(Suite.class)
@SuiteClasses({ TestGameController.class, TestPlayerController.class, TestGameBusiness.class })
public class TestSuiteController {

}