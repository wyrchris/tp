package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ScheduleCommand;

class ScheduleCommandParserTest {

    private ScheduleCommandParser parser = new ScheduleCommandParser();

    @Test
    public void parse_validDate_returnsScheduleCommand() {
        LocalDate meetingDate = LocalDate.of(2021, 9, 10);
        assertParseSuccess(parser, " 10-09-2021", new ScheduleCommand(meetingDate));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        //invalid date format
        assertParseFailure(parser, " 2021-09-31", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleCommand.MESSAGE_INVALID_DATE_FAILURE));

        //empty input
        assertParseFailure(parser, " ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleCommand.MESSAGE_INVALID_DATE_FAILURE));
    }
}