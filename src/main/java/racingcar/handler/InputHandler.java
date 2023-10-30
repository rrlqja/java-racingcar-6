package racingcar.handler;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constants.ExceptionMessageConstants.*;

public class InputHandler {

    private static final int MAX_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";

    public List<String> toNameList(String names) {
        validateNull(names);

        String[] nameArray = names.split(NAME_DELIMITER);
        List<String> nameList = new ArrayList<>();

        for (String name : nameArray) {
            String trimName = name.trim();

            validateName(trimName, nameList);

            nameList.add(trimName);
        }

        return nameList;
    }

    public int parseToInt(String inputAttempts) {
        validateNull(inputAttempts);

        try {
            return Integer.parseInt(inputAttempts);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }

    private void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED);
        }
    }

    private void validateName(String trimName, List<String> nameList) {
        validateNull(trimName);

        if (nameList.contains(trimName)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_NOT_ALLOWED);
        }
        if (trimName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
