package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.account.Account;
import seedu.address.testutil.TypicalEntries;

public class JsonAdaptedAccountTest {
    private static final Path TEST_DATA_FOLDER = Paths.get(
        "src", "test", "data", "JsonCommonCentsAccountTest");
    private static final Path INVALID_ACCOUNT_NAME_FILE = TEST_DATA_FOLDER.resolve(
        "invalidAccountNameCommonCents.json");

    @Test
    public void toModelType_validTypicalAccount_returnAccount() throws IllegalValueException {
        Account typicalAccount = TypicalEntries.getTypicalAccount();
        JsonAdaptedAccount jsonAdaptedAccount = new JsonAdaptedAccount(typicalAccount);
        assertEquals(typicalAccount, jsonAdaptedAccount.toModelType());
    }

    @Test
    public void toModelType_invalidAccountName_throwsIllegalValueException() throws DataConversionException {
        JsonAdaptedAccount jsonAdaptedAccount = JsonUtil.readJsonFile(INVALID_ACCOUNT_NAME_FILE,
            JsonAdaptedAccount.class).get();
        assertThrows(IllegalValueException.class, jsonAdaptedAccount::toModelType);
    }

}
