package com.goura.test;

public class PasswordPolicyTest {

    public static void main(String[] args) {
        NDGPasswordPolicy policy = new NDGPasswordPolicy();
        policy.setPasswordPolicyCheck(true);
        policy.setMinLength(12);
        policy.setMaxLength(50);
        policy.setMinCharacteristics(3);
        policy.setPasswordStringRule(true);

        NDGPasswordPolicy.NDGCharactersticRule charactersticRule = new NDGPasswordPolicy.NDGCharactersticRule();
        charactersticRule.setDigitRule(true);
        charactersticRule.setLowerCaseRule(true);
        charactersticRule.setSplCharRule(true);
        charactersticRule.setUpperCaseRule(true);

        policy.setCharactersticRule(charactersticRule);

        for (int i = 0; i < 10; i++) {
            System.out.println(policy.generateRandomPassword());
        }
    }

}
