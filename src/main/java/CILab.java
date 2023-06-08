public class CILab implements CILabInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public boolean detectCapitalUse() {
        if (myString.isEmpty() || myString.length() == 1) {
            return true;
        }

        char firstChar = myString.charAt(0);
        char secondChar = myString.charAt(1);
        boolean isUpper = Character.toUpperCase(secondChar) == secondChar;

        if (Character.toUpperCase(firstChar) != firstChar && isUpper) {
            return false;
        }

        for (int i = 2; i < myString.length(); i++) {
            char currentChar = myString.charAt(i);
            boolean charIsUpperCase = Character.toUpperCase(currentChar) == currentChar;
            if (isUpper && !charIsUpperCase ||
                    !isUpper && charIsUpperCase) {
                return false;
            }
        }

        return true;
    }

}

