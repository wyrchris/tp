package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {
    /* Prefix definitions */
    public static final Prefix PREFIX_CLIENTID = new Prefix("i/");
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_RISKAPPETITE = new Prefix("r/");
    public static final Prefix PREFIX_DISPOSABLEINCOME = new Prefix("d/");
    public static final Prefix PREFIX_LASTMET = new Prefix("l/");
    public static final Prefix PREFIX_CURRENTPLAN = new Prefix("c/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    public static final Prefix[] ALL_PREFIXES = {
        PREFIX_CLIENTID, PREFIX_NAME, PREFIX_EMAIL, PREFIX_PHONE, PREFIX_ADDRESS, PREFIX_RISKAPPETITE,
        PREFIX_DISPOSABLEINCOME, PREFIX_CURRENTPLAN, PREFIX_LASTMET
    };
}
