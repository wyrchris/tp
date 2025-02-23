package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.ALL_PREFIXES;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.ScheduleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

/**
 * Parses input arguments and creates a new ScheduleCommand object
 */
public class ScheduleCommandParser implements Parser<ScheduleCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ScheduleCommand
     * and returns an ScheduleCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     * @return
     */
    @Override
    public ScheduleCommand parse(String args, Model model) throws ParseException {
        if (args.isBlank()) {
            return new ScheduleCommand(null);
        }

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, ALL_PREFIXES);

        // Throws error if invalid date is inputted
        if (!StringUtil.isValidDate(argMultimap.getPreamble())) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ScheduleCommand.MESSAGE_INVALID_DATE_FAILURE));
        }

        LocalDate givenDate = LocalDate.parse(argMultimap.getPreamble(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return new ScheduleCommand(givenDate);
    }
}
