package com.goura.test;

import java.io.Serializable;
import java.util.Random;

public class NDGPasswordPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean _pPolicyCheck;

    private int minLength;

    private int maxLength;

    private boolean _pStringRule;

    private NDGCharactersticRule charactersticRule = new NDGCharactersticRule();

    private int minCharacteristics;

    public static class NDGCharactersticRule {

        private boolean upperCaseRule;

        private boolean lowerCaseRule;

        private boolean digitRule;

        private boolean splCharRule;

        /**
         * @return the upperCaseRule
         */
        public boolean isUpperCaseRule() {
            return upperCaseRule;
        }

        /**
         * @param upperCaseRule
         *            the upperCaseRule to set
         */
        public void setUpperCaseRule(boolean upperCaseRule) {
            this.upperCaseRule = upperCaseRule;
        }

        /**
         * @return the lowerCaseRule
         */
        public boolean isLowerCaseRule() {
            return lowerCaseRule;
        }

        /**
         * @param lowerCaseRule
         *            the lowerCaseRule to set
         */
        public void setLowerCaseRule(boolean lowerCaseRule) {
            this.lowerCaseRule = lowerCaseRule;
        }

        /**
         * @return the digitRule
         */
        public boolean isDigitRule() {
            return digitRule;
        }

        /**
         * @param digitRule
         *            the digitRule to set
         */
        public void setDigitRule(boolean digitRule) {
            this.digitRule = digitRule;
        }

        /**
         * @return the splCharRule
         */
        public boolean isSplCharRule() {
            return splCharRule;
        }

        /**
         * @param splCharRule
         *            the splCharRule to set
         */
        public void setSplCharRule(boolean splCharRule) {
            this.splCharRule = splCharRule;
        }

    }

    /**
     * @return the passwordPolicyCheck
     */
    public boolean isPasswordPolicyCheck() {
        return _pPolicyCheck;
    }

    /**
     * @param passwordPolicyCheck
     *            the passwordPolicyCheck to set
     */
    public void setPasswordPolicyCheck(boolean _pPolicyCheck) {
        this._pPolicyCheck = _pPolicyCheck;
    }

    /**
     * @return the minLength
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * @param minLength
     *            the minLength to set
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * @return the maxLength
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength
     *            the maxLength to set
     */
    public void setMaxLength(int minLength) {
        this.maxLength = minLength;
    }

    /**
     * @return the passwordStringRule
     */
    public boolean isPasswordStringRule() {
        return _pStringRule;
    }

    /**
     * @param passwordStringRule
     *            the passwordStringRule to set
     */
    public void setPasswordStringRule(boolean _pStringRule) {
        this._pStringRule = _pStringRule;
    }

    /**
     * @return the charactersticRule
     */
    public NDGCharactersticRule getCharactersticRule() {
        return charactersticRule;
    }

    /**
     * @param charactersticRule
     *            the charactersticRule to set
     */
    public void setCharactersticRule(NDGCharactersticRule charactersticRule) {
        this.charactersticRule = charactersticRule;
    }

    /**
     * @return the minCharacteristics
     */
    public int getMinCharacteristics() {
        return minCharacteristics;
    }

    /**
     * @param minCharacteristics
     *            the minCharacteristics to set
     */
    public void setMinCharacteristics(int minCharacteristics) {
        this.minCharacteristics = minCharacteristics;
    }

    /**
     * Validate the bean attributes against the rule.
     * 1. minLength must be between 6 to 15 (both inclusive).
     * 2. maxLength must be between 10 to 50 (both inclusive).
     * 3. maxLength must be greater then minLength.
     * 4. minCharacteristics must be positive and must not be greater than number of charactersticRule set.
     *
     * @throws IllegalArgumentException
     */
    public void validate() throws IllegalArgumentException {
        // Check if passwordPolicy flag is set.
        if (!_pPolicyCheck) {
            return; // No validation needed
        }

        // Validate the min/max length
        if (minLength < 6 || minLength > 15) {
            throw new IllegalArgumentException("minLength must be between 6 to 15 (both inclusive).");
        }

        if (maxLength < 10 || maxLength > 50) {
            throw new IllegalArgumentException("maxLength must be between 10 to 50 (both inclusive).");
        }

        if (minLength >= maxLength) {
            throw new IllegalArgumentException("maxLength must be greater then minLength.");
        }

        // Validate the minimum characteristics.
        int charsCount = 0;
        if (charactersticRule.lowerCaseRule) {
            charsCount++;
        }
        if (charactersticRule.upperCaseRule) {
            charsCount++;
        }
        if (charactersticRule.digitRule) {
            charsCount++;
        }
        if (charactersticRule.splCharRule) {
            charsCount++;
        }

        if (minCharacteristics <= 0 || minCharacteristics > charsCount) {
            throw new IllegalArgumentException(
                    "minCharacteristics must be positive and must not be greater than number of charactersticRule set.");
        }
    }

    public String generateRandomPassword() {
        int min = this.getMinLength();
        int max = this.getMaxLength();
        char[] _p = new char[randomize(min, max)];

        System.out.println("length: " + _p.length);
        int count = 0;
        if (this.getCharactersticRule().isUpperCaseRule()) {
            _p[count++] = randomUppercaseChar();
        }
        if (this.getCharactersticRule().isLowerCaseRule()) {
            _p[count++] = randomLowercaseChar();
        }
        if (this.getCharactersticRule().isDigitRule()) {
            _p[count++] = randomDigitChar();
        }
        if (this.getCharactersticRule().isSplCharRule()) {
            _p[count++] = randomSpecialChar();
        }

        for (int i = count; i < _p.length; i++) {
            int r = randomize(i, _p.length - 1);
            switch (r%4) {
            case 0:
                _p[i] = randomUppercaseChar();
                break;
            case 1:
                _p[i] = randomLowercaseChar();
                break;
            case 2:
                _p[i] = randomDigitChar();
                break;
            default:
                _p[i] = randomSpecialChar();
                break;
            }
        }
        return new String(_p);
    }

    private static char randomUppercaseChar() {
        return (char) randomize(65, 90);
    }

    private static char randomLowercaseChar() {
        return (char) randomize(97, 122);
    }

    private static char randomDigitChar() {
        return (char) randomize(48, 57);
    }

    private static char randomSpecialChar() {
        String splCharString = "`~!@#$%^&*()-_=+[{]}\\|;:'\"<,>./?";
        int pos = randomize(1, splCharString.length());
        return splCharString.charAt(pos - 1);
    }

    private static int randomize(int min, int max) {
        int i = (new Random()).nextInt(max - min + 1) + min;
        return i;
    }
}