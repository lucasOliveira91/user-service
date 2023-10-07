package br.com.tailorit.user.service;

public class PasswordStrengthMeter {

    public static int calculateStrength(String password) {
        int score = 0;

        if (password == null || password.length() == 0) {
            return 0;
        }

        // Additions
        int numberCount = 0;
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int symbolCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                numberCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else {
                symbolCount++;
            }
        }

        score += password.length() * 4;
        if (upperCaseCount > 0) {
            score += (password.length() - upperCaseCount) * 2;
        }
        if (lowerCaseCount > 0) {
            score += (password.length() - lowerCaseCount) * 2;
        }
        score += numberCount * 4;
        score += symbolCount * 6;

        // Deductions
        if (password.length() > 1 && numberCount == password.length()) {
            score -= password.length(); // Numbers only
        }
        if (password.length() > 1 && (upperCaseCount + lowerCaseCount) == password.length()) {
            score -= password.length(); // Letters only
        }

        // Return as percentage
        return Math.min(100, score);
    }

    public static void main(String[] args) {
        String password = "xpto123@XyZ";
        int strength = calculateStrength(password);
        System.out.println("Password Strength: " + strength + "%");
    }
}
