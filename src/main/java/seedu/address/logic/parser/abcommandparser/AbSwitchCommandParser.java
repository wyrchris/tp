package seedu.address.logic.parser.abcommandparser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.util.FileUtil.convertToAddressBookPathString;
import static seedu.address.commons.util.FileUtil.isFileExists;
import static seedu.address.logic.commands.abcommand.AbSwitchCommand.MESSAGE_ADDRESSBOOK_NOT_FOUND;

import java.nio.file.Path;

import seedu.address.logic.commands.abcommand.AbSwitchCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and create a new AbSwitchCommand object.
 */
public class AbSwitchCommandParser implements Parser<AbSwitchCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AbSwitchCommand
     * and returns an AbSwitchCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public AbSwitchCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String trimmedArgs = args.trim();
        String lowercaseArgs = trimmedArgs.toLowerCase();

        if (lowercaseArgs.isBlank()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AbSwitchCommand.MESSAGE_USAGE));
        }

        String filePathName = convertToAddressBookPathString(lowercaseArgs);
        Path filePath = Path.of(filePathName);

        if (!isFileExists(filePath)) {
            throw new ParseException(String.format(MESSAGE_ADDRESSBOOK_NOT_FOUND, trimmedArgs));
        }

        return new AbSwitchCommand(filePath);
    }
}
