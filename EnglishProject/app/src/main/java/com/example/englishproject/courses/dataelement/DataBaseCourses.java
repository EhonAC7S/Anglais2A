package com.example.englishproject.courses.dataelement;

/*
 * Created by jorda on 27/04/2017.
 *
 */
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * DataBase of all Courses that can be Displayed and referenced
 */
public class DataBaseCourses extends SQLiteOpenHelper{
    //Ici on met les constantes des noms de nos Cours
    public static final String COMMON_MISSPELLINGS = "Common Misspellings"; // Fait
    public static final String COMMON_MISSPELLINGS_2 = "Common Misspellings 2"; // Fait
    public static final String COMMON_MISSPELLINGS_3 = "Common Misspellings 3"; // Fait
    public static final String COMMON_MISSPELLINGS_4 = "Common Misspellings 4"; // Fait
    public static final String COMMON_MISSPELLINGS_5 = "Common Misspellings 5"; // Fait
    public static final String SUFFIXES = "Suffixes"; // Fait
    public static final String APOSTROPHES_FOR_POSSESSION = "Apostrophes for possession"; // Fait
    public static final String THOUGH_THOUGHT_THOROUGH_THROUGH = "Though/Thought/Thorough/Through"; // Fait
    public static final String NEGATIVE_PREFIXES = "Negative Prefixes"; // Fait
    public static final String ACTIVE_VOICE = "Active Voice"; // Fait
    public static final String PASSIVE_VOICE = "Passive Voice"; // Fait
    public static final String CONJUNCTIONS = "Conjunctions"; // Fait
    public static final String COMMA = "Comma"; // Fait
    public static final String SEMICOLON = "Semicolon"; // Fait
    public static final String SIMPLE_PRESENT = "Simple Present"; // Fait
    public static final String PRESENT_PROGRESSIVE = "Present Progressive"; // Fait
    public static final String ED_RULE = "-ed rule"; // Fait
    public static final String PRESENT_PERFECT = "Present Perfect"; // Fait
    public static final String PRESENT_PERFECT_PROG = "Present Perfect Progressive";// Fait
    public static final String PAST_PERFECT = "Past Perfect"; // Fait
    public static final String FORMING_PLURALS = "Forming Plural"; // Fait
    public static final String THEIR_THERE_THEYRE = "Their/There/They re";// Fait
    public static final String BIGHT_BITE_BYTE = "Bight/Bite/Byte";
    public static final String CENSER_CENSOR_SENSOR = "Censer/Censor/Sensor";
    public static final String CITE_SIGHT_SITE = "Cite/Sight/Site";
    public static final String FOR_FORE_FOUR = "For/Fore/Four";
    public static final String HEAL_HEEL_HE_LL = "Heal/Heel/He ll";
    public static final String PALATE_PALETTE_PALLET = "Palate/Palette/Pallet";
    public static final String PEAK_PEEK_PEKE_PIQUE = "Peak/Peek/Peke/Pique";
    public static final String RAIN_REIGN_REIN = "Rain/Reign/Rein";
    public static final String TE_TEA_TEE = "Tea/Tee";
    public static final String TO_TOO_TWO = "To/Too/Two";

    // STRING FOR DATACALL
    private static final String CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS ";
    private static final String INTEGER_PRIMARY_KEY_AUTOINCREMENT = " INTEGER PRIMARY KEY AUTOINCREMENT, ";
    private static final String SELECT_FROM = "SELECT * FROM ";
    private static final String TEXT = " TEXT, ";
    private static final String WHERE = " WHERE ";
    private static final String BIGTAB = "      ";
    private static final String TAB = "   ";
    private static final String LINEJUMP = "\n";
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Courses";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCR = "descr";
    private static final String KEY_EX1 = "example1";
    private static final String KEY_RULE = "rule";
    private static final String KEY_EX2 ="example2";

    private SQLiteDatabase dbase;
    public DataBaseCourses(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        System.out.println("On est dans le OnCreate()");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        String sql = CREATE_TABLE_IF_NOT_EXISTS + DATABASE_NAME + " ( "
                + KEY_ID + INTEGER_PRIMARY_KEY_AUTOINCREMENT + KEY_RULE + TEXT +KEY_TITLE + TEXT
                + KEY_DESCR +TEXT+ KEY_EX1 +TEXT+ KEY_EX2 +" TEXT)";
        db.execSQL(sql);
        addCourses();
        //db.close();
    }
    private void addCourses()
    {
        //Ajouter les contenus des cours ici
        //template :
        //addCourse(new CourseContents(
        //      RULE, // Rule
        //      TITLE, // Title
        //      DESCRIPTION, // Desc
        //      EXAMPLE1, // Example1
        //      EXAMPLE2) // Example2
        //);
        // COMMON_MISSPELLINGS :

        addCourse(new CourseContents(
                COMMON_MISSPELLINGS, // Rule
                "Words often badly spelled", // Title
                TAB + "The following words are often misspelled, remember them : " + LINEJUMP +
                        BIGTAB + "Achieve" + LINEJUMP +
                        BIGTAB + "Accidentally" + LINEJUMP +
                        BIGTAB + "Adrenaline" + LINEJUMP +
                        BIGTAB + "Address" + LINEJUMP +
                        BIGTAB + "Agreement" + LINEJUMP +
                        BIGTAB + "Appropriate" + LINEJUMP +
                        BIGTAB + "Atheist" + LINEJUMP +
                        BIGTAB + "Beginning" + LINEJUMP +
                        BIGTAB + "Bureau" + LINEJUMP +
                        BIGTAB + "Believe" + LINEJUMP +
                        BIGTAB + "Belief" + LINEJUMP +
                        BIGTAB + "Business" + LINEJUMP +
                        BIGTAB + "Breathe" + LINEJUMP +
                        BIGTAB + "Commitment" + LINEJUMP +
                        BIGTAB + "Category" + LINEJUMP +
                        BIGTAB + "Conceive" + LINEJUMP +
                        BIGTAB + "Copyright" + LINEJUMP +
                        BIGTAB + "Decaffeinated" + LINEJUMP +
                        BIGTAB + "Decathlon" + LINEJUMP +
                        BIGTAB + "Definitely" + LINEJUMP +
                        BIGTAB + "Desirable" + LINEJUMP +
                        BIGTAB + "Diarrhea" + LINEJUMP +
                        BIGTAB + "Deity" + LINEJUMP

                , // Desc
                "", // Example1
                "") // Example2
        );
        // COMMON_MISSPELLINGS_2
        addCourse(new CourseContents(
                COMMON_MISSPELLINGS_2,
                "Words often badly spelled",
                TAB + "The following words are often misspelled, remember them : " +
                        BIGTAB + "Disappoint" + LINEJUMP +
                        BIGTAB + "Dispel" + LINEJUMP +
                        BIGTAB + "Ecstasy" + LINEJUMP +
                        BIGTAB + "Embarrass" + LINEJUMP +
                        BIGTAB + "Environment" + LINEJUMP +
                        BIGTAB + "Extremely" + LINEJUMP+
                        BIGTAB + "Fascist" + LINEJUMP +
                        BIGTAB + "February" + LINEJUMP +
                        BIGTAB + "Fluorescent" + LINEJUMP +
                        BIGTAB + "Forty" + LINEJUMP +
                        BIGTAB + "Gauge" + LINEJUMP +
                        BIGTAB + "Government" + LINEJUMP +
                        BIGTAB + "Grievous" + LINEJUMP +
                        BIGTAB + "Harass" + LINEJUMP +
                        BIGTAB + "Hemorrhage" + LINEJUMP +
                        BIGTAB + "Heroes" + LINEJUMP +
                        BIGTAB + "Height" + LINEJUMP +
                        BIGTAB + "Hymn" + LINEJUMP +
                        BIGTAB + "Independence" + LINEJUMP +
                        BIGTAB + "Innate" + LINEJUMP +
                        BIGTAB + "Inoculate" + LINEJUMP +
                        BIGTAB + "Knowledge" + LINEJUMP +
                        BIGTAB + "Laser" + LINEJUMP +

                        "",
                "",
                ""
        ));
        // COMMON_MISSPELLINGS_3
        addCourse(new CourseContents(
                COMMON_MISSPELLINGS_3, // Rule
                "Words often badly spelled",
                TAB + "The following words are often misspelled, remember them : " +
                        BIGTAB + "Leprechaun" + LINEJUMP +
                        BIGTAB + "Library" + LINEJUMP +
                        BIGTAB + "Lightning" + LINEJUMP +
                        BIGTAB + "Maintenance" + LINEJUMP +
                        BIGTAB + "Manageable" + LINEJUMP +
                        BIGTAB + "Millennium" + LINEJUMP +
                        BIGTAB + "Mischievous" + LINEJUMP +
                        BIGTAB + "Misspell" + LINEJUMP +
                        BIGTAB + "Mitt" + LINEJUMP +
                        BIGTAB + "Monastery" + LINEJUMP +
                        BIGTAB + "Monkeys" + LINEJUMP +
                        BIGTAB + "Mortgage" + LINEJUMP +
                        BIGTAB + "Mountain" + LINEJUMP +
                        BIGTAB + "Necessary" + LINEJUMP +
                        BIGTAB + "Niece" + LINEJUMP +
                        BIGTAB + "Nickel" + LINEJUMP +
                        BIGTAB + "Ninth" + LINEJUMP +
                        BIGTAB + "Ninety" + LINEJUMP +
                        BIGTAB + "Noticeable" + LINEJUMP +
                        BIGTAB + "Nuptuals" + LINEJUMP +
                        BIGTAB + "Occurred" + LINEJUMP +
                        BIGTAB + "Occurrence" + LINEJUMP +
                        BIGTAB + "Opportunity" + LINEJUMP +

                        "",
                "", // Example1
                "")
        );
        // COMMON_MISSPELLINGS_4
        addCourse(new CourseContents(
                COMMON_MISSPELLINGS_4, // Rule
                "Words often badly spelled",
                TAB + "The following words are often misspelled, remember them : " +
                        BIGTAB + "Parallel" + LINEJUMP +
                        BIGTAB + "Pastime" + LINEJUMP +
                        BIGTAB + "Pavilion" + LINEJUMP +
                        BIGTAB + "Perseverance" + LINEJUMP +
                        BIGTAB + "Possession" + LINEJUMP +
                        BIGTAB + "Potato" + LINEJUMP +
                        BIGTAB + "Preceding" + LINEJUMP +
                        BIGTAB + "Pronunciation" + LINEJUMP +
                        BIGTAB + "Privilege" + LINEJUMP +
                        BIGTAB + "Receive" + LINEJUMP +
                        BIGTAB + "Recommend" + LINEJUMP +
                        BIGTAB + "Ridiculous" + LINEJUMP +
                        BIGTAB + "Regardless" + LINEJUMP +
                        BIGTAB + "Remember" + LINEJUMP +
                        BIGTAB + "Restraint" + LINEJUMP +
                        BIGTAB + "Roommate" + LINEJUMP +
                        BIGTAB + "Rhythm" + LINEJUMP +
                        BIGTAB + "Sacrilegious" + LINEJUMP +
                        BIGTAB + "Siege" + LINEJUMP +
                        BIGTAB + "Sentence" + LINEJUMP +
                        BIGTAB + "Separate" + LINEJUMP +
                        BIGTAB + "Seize" + LINEJUMP +
                        "",
                "", // Example1
                ""
        ));// COMMON_MISSPELLINGS_5
        addCourse(new CourseContents(
                COMMON_MISSPELLINGS_5, // Rule
                "Words often badly spelled",
                TAB + "The following words are often misspelled, remember them : " +

                        BIGTAB + "Similar" + LINEJUMP +
                        BIGTAB + "Sincerely" + LINEJUMP +
                        BIGTAB + "Souvenir" + LINEJUMP +
                        BIGTAB + "Speech" + LINEJUMP +
                        BIGTAB + "Stationary" + LINEJUMP +
                        BIGTAB + "Strategy" + LINEJUMP +
                        BIGTAB + "Suggestible" + LINEJUMP +
                        BIGTAB + "Supersede" + LINEJUMP +
                        BIGTAB + "Supposedly" + LINEJUMP +
                        BIGTAB + "Surprise" + LINEJUMP +
                        BIGTAB + "Thoroughly" + LINEJUMP +
                        BIGTAB + "Tomorrow" + LINEJUMP +
                        BIGTAB + "Tongue" + LINEJUMP +
                        BIGTAB + "Triathlon" + LINEJUMP +
                        BIGTAB + "Ukulele" + LINEJUMP +
                        BIGTAB + "Vacuum" + LINEJUMP +
                        BIGTAB + "Vegetarian" + LINEJUMP +
                        BIGTAB + "Villain" + LINEJUMP +
                        BIGTAB + "Wednesday" + LINEJUMP +
                        BIGTAB + "Weird" + LINEJUMP +
                        BIGTAB + "Writing" + LINEJUMP +
                        BIGTAB + "Presentation" + LINEJUMP +"",
                "", // Example1
                ""
        ));
        // SUFFIXES
        addCourse(new CourseContents(
                SUFFIXES, // Rule
                "Vowel and consonant suffixes", // Title
                TAB + "Vowel suffix : -ance/" +" -er/" + "-ing/" + "-able/" + "-ible/" + "-est/" + "-ed/" + "-ation." + LINEJUMP +
                        TAB + "Consonant suffix : -ly/" + "-less/" + "-y/" + "-ship/" + "-ment/" + "-ness/" + "-ful/" + "-s. " + LINEJUMP +
                        "Some rules : " + LINEJUMP +
                        BIGTAB + "Change the y to i before suffixes (except -ing)." + LINEJUMP +
                        BIGTAB + "Drop the 'e' before a vowel suffix. " + LINEJUMP +
                        BIGTAB + "Double the last L." + LINEJUMP +
                        BIGTAB + "Words of 1 syllable ending in 1 vowel+ 1 consonant - double the last letter before a vowel suffix" + LINEJUMP +
                        TAB + "There are many exceptions on keeping '-e' and '-y' to learn, see this in a next lesson.", // Desc
                "carry + er = carrier, beauty + ful = beautiful, happy + ness = happiness" + LINEJUMP +
                "love + ing = loving, use + ing = using, adore + able = adorable, care + ed = cared", // Example1
                "cancel + ed =  cancelling, signal + ly = signally" + LINEJUMP +
                "regret + able = regrettable, commit + ing = committing, begin + er = beginner") // Example2
        );
        // APOSTROPHES_FOR_POSSESSION
        addCourse(new CourseContents(
                APOSTROPHES_FOR_POSSESSION, // Rule
                "Forming possessives", // Title
                TAB + "The general rule is that the possessive of a singular noun is formed by adding an apostrophe and s, " +
                        "whether the singular noun ends in s or not." + LINEJUMP +
                        TAB + "The possessive of a plural noun is formed by adding only an apostrophe when the noun ends in s, " +
                        "and by adding both an apostrophe and s when it ends in a letter other than s." + LINEJUMP +
                        TAB + "Exceptions : " + LINEJUMP +
                        BIGTAB + "Use only an apostrophe for places or names that are singular but have a final word " +
                        "in plural form and ending with an s." + LINEJUMP +
                        BIGTAB + "A proper noun that is already in possessive form is left as is." + LINEJUMP +
                        BIGTAB + "Nouns that end in an s sound take only an apostrophe when they are followed by sake." +
                        TAB + "Shared or individual possessives : " + LINEJUMP +
                        BIGTAB + "Joint possession is indicated by a single apostrophe. Individual possession is " +
                                "indicated by apostrophes for each possessor", // Desc
                "the lawyer’s fee" + LINEJUMP +
                " excessive lawyers’ fees" + LINEJUMP +
                "Beverly Hills’ current mayor" + LINEJUMP +
                "for goodness’ sake", // Example1
                "Stanley and Scarlett’s house." + LINEJUMP +
                "France’s and Italy’s domestic policies are diverging.") // Example2
        );
        // THOUGH_THOUGHT_THOROUGH_THROUGH
        addCourse(new CourseContents(
                THOUGH_THOUGHT_THOROUGH_THROUGH, // Rule
                "Meaning of these similar words", // Title
                TAB + "THROUGH : " + TAB + "It means in one side out and the other: go through a door, walk through the park, struggle " +
                        "through until pay day. We’ve also got throughout. He checks stock throughout the warehouse." +
                        TAB + "THOUGH : " + TAB + "Though means in spite of the fact that; however, but, and we have even though and although " +
                        "which is more formal" + LINEJUMP +
                        TAB + "THOROUGH : " + TAB + "done with great care and completeness: Planners need a thorough understanding of " +
                        "the subjectIt would be great if everyone had a thorough knowledge of English spelling." + LINEJUMP +
                        "We can also add ly and make thoroughly. She examined it thoroughly." + LINEJUMP +
                        TAB + "THOUGHT : " + TAB + "Thought is the most common word of the lot. It’s the past tense of think – " +
                        "I thought this was the end but it’s not. And also a noun a thought , an idea.", // Desc
                "Work stopped half-way through the project when the funding ran out." + LINEJUMP +
                "The sun was shining though it wasn’t that warm. Even though it’s small , the room has a spacious feel.", // Example1
                "She has a thorough understanding of the business." + LINEJUMP +
                "George was in high glee at the thought of going.") // Example2
        );
        // NEGATIVE_PREFIXES
        addCourse(new CourseContents(
                NEGATIVE_PREFIXES, // Rule
                "Which prefixe in the list : 'in-, un-, non-, de-, dis-, a-, anti-, im-, il-, and ir-'", // Title
                TAB + "The most common negative prefixes in English are in-, un-, non-, de-, dis-, a-, anti-, im-, il-, and ir-. " +
                        BIGTAB + "The in- prefix (from which im-, il-, and ir- are derived) is generally the least useful of the negative prefixes, " +
                        "as it only goes with certain Latin-derived stems (e.g., intolerant, inarticulate, impenetrable), is highly conventionalized, " +
                        "and is identical to morphemes used in words that are not negative" + LINEJUMP +
                        BIGTAB + "The un- prefix is commonly attached to Latin derivatives that end in suffixes such as -ed and -able, resulting " +
                        "in adjectives such as unfounded, unassailable, and unbelievable." + LINEJUMP +
                        BIGTAB + "The prefix non- is the most useful negative prefix, as it can be attached to virtually any noun, verb, adjective, " +
                        "or adverb and is not confusable with other common morphemes. Unlike in-, and un-, which often create nonabsolute negatives, " +
                        "non- is generally used to create a word that describes the complete opposite of its nonnegative form. " + LINEJUMP +
                        "When affixing non- to a word, no hyphen is needed unless the stem is a proper noun. The prefix dis- is similar in some " +
                        "uses to de- and in other uses to un-. A- is affixed to adjectives ending in -al. Anti- means against.", // Desc
                "unable, inability, (to) disable, unable, unacknowledged, nonconformist or nonconformity", // Example1
                "illegal, illegible, illiterate, illogical, immature, disable/ disabled/ disability, disagree, " +
                        "deactivate, decode, decommission, decompose ") // Example2
        );
        // ACTIVE_VOICE
        addCourse(new CourseContents(
                ACTIVE_VOICE, // Rule
                "Active Voice Usage", // Title
                TAB + "Someone (the subject) is doing something (the verb). The subject performs the action." + LINEJUMP +
                        "Active Voice can add impact to your writing", // Desc
                "We are going to watch a movie tonight.", // Example1
                "Mom read the novel in one day.") // Example2
        );
        // PASSIVE_VOICE
        addCourse(new CourseContents(
                PASSIVE_VOICE, // Rule
                "Focus on the action", // Title
                TAB + "Someone (the subject) is having something (the verb) done to them. The subject receives the action", // Desc
                "She had been murdered.", // Example1
                "Everyone was startled by the power outage.") // Example2
        );
        // CONJUNCTIONS
        addCourse(new CourseContents(
                CONJUNCTIONS, // Rule
                "To coordinate clauses", // Title
                TAB + "Sometimes you want to link two ideas with a second S+V+O combination. " +
                        "When you do, you need a coordinating conjunction." + LINEJUMP +
                        TAB + "Coordinating conjunctions are easy to remember with an acronymic mnemonic device: FANBOYS : " + LINEJUMP +
                        "For-And-Nor-But-Or-Yet-So", // Desc
                "She hasn't taken dance lessons, nor does she need to.", // Example1
                "Other dancers try to imitate her style, yet they have not succeeded.") // Example2
        );
        // COMMA
        addCourse(new CourseContents(
                COMMA, // Rule
                "Serial Comma for listing", // Title
                TAB + "The serial, or Oxford, comma is a controversial rule of grammar. Some want to eliminate it " +
                        "altogether while others just don't know how to use it." +
                        TAB + "The serial comma is the last comma in a list, usually appearing before 'and.'" + LINEJUMP +
                        TAB + "Commas separate units in a list. In the above case, each unit only has one part, so it's easy. " +
                        "Where people get confused is when the units are bigger" + LINEJUMP +
                        TAB + "Notice that the serial comma comes before 'and' but not the last 'and' in the sentence. " +
                        "The 'and' that follows the comma is only there because it sounds better. Grammatically, " +
                        "'and' is irrelevant. Only units matter.",
                "Pets are Us has lizards, dogs, and birds.",
                "Pets are Us has lizards and frogs, dogs and cats, and parakeets and macaws.") // Example2
        );
        // SEMICOLON
        addCourse(new CourseContents(
                SEMICOLON, // Rule
                "Close connection, two as one!", // Title
                TAB + "A list of grammar rules has to include the scariest of punctuation marks. It might look funny, " +
                        "but don't be afraid of the semicolon; it's the easiest thing in the world to use! " +
                        TAB + "Say you want to join two ideas but can't figure out or can't be bothered to use a " +
                        "coordinating conjunction. The two ideas can be separate sentences," +
                        " but you think that they are so closely connected; they really should be one. " +
                        "Use a semicolon.", // Desc
                "Mary's dog is hyperactive; it won't stop barking or sit still.",
                "My heart is like a cup of Lapsang Souchong tea; it's bitter and smoky.") // Example2
        );
        // SIMPLE_PRESENT
        addCourse(new CourseContents(
                SIMPLE_PRESENT, // Rule
                "Habitual Actions", // Title
                TAB + "The simple present is the tense you use for any habitual action. " +
                        "The things you always do or do every Tuesday are described with " +
                        "the simple present, which just means you pick the first form of any verb.", // Desc
                "Mary likes dogs.", // Example1
                "Mary is playing with her hyperactive dog.")  // Example2
        );
        // PRESENT_PROGRESSIVE
        addCourse(new CourseContents(
                PRESENT_PROGRESSIVE,
                "Tense for current action",
                TAB + "The present progressive tense is for anything that is happening right now. " +
                        "All of the progressive tenses are easy to spot because their verbs always " +
                        "end with '-ing' and get a helping verb. " +
                        TAB + "A helping verb is just so we know who and when we're talking about. " +
                        TAB + "In the present progressive, the helping verbs are the present tense " +
                        "conjugations of 'to be.'",
                "I am drinking Lapsang Souchong tea.",
                "Mary is playing with her hyperactive dog.")
        );
        // ED_RULE
        addCourse(new CourseContents(
                ED_RULE,
                "Past tense for regular verbs",
                TAB + "When we talk about the past, we have to add an '-ed' to regular verbs to make the second form. " +
                        TAB + "Irregular verbs are tricky and have their own sets of rules. Drink, for example, turns to 'drank.' " +
                        TAB + "Most of the time, though, '-ed' will do.",
                "The dogs stopped barking two seconds ago, and I am feeling better.",
                "Mary played fetch with her hyperactive dog.")
        );
        // PRESENT_PERFECT
        addCourse(new CourseContents(
                PRESENT_PERFECT,
                "The Unfinished Past",
                TAB + "The present perfect can be confusing for some, but it is one of the most important rules of grammar. " +
                        TAB + "When people talk about things that have already happened but consider the time in which they " +
                        "occurred to be unfinished, " +
                        "they use the third form of the verb with a helping verb. The helping verb for the present perfect " +
                        "is the present tense conjugation of 'to have.'",
                "I have drunk three cups of Lapsang Souchong tea today.",
                "Mary has walked her hyperactive poodle 100 times this week.")
        );
        // PRESENT_PERFECT_PROG
        addCourse(new CourseContents(
                PRESENT_PERFECT_PROG,
                "The Unfinished Actions of Past",
                TAB + "When the action as well as the time is considered unfinished, the verb loads up on third " +
                        "form helping verbs ('to be' and 'to have') and changes to the progressive form.",
                "Western countries have been waging wars in the Middle East for thousands of years.",
                "I have been drinking tea all day.")
        );
        // PAST_PERFECT
        addCourse(new CourseContents(
                PAST_PERFECT,
                "Past for Past in the Past",
                TAB + "When two things happen in the past, we have to mark which one happened first. " +
                        "The one that happened first changes to third form and gets the helping verb, 'had.'",

                "By the time I drank one cup of Lapsang Souchong, Mary's dog had barked a million times.",
                "I had not yet eaten breakfast when Mary walked her dog.")
        );
        // FORMING_PLURALS
        addCourse(new CourseContents(
                FORMING_PLURALS,
                "Plural of noun",
                TAB + "There is many rule, you have to choose the appropriate one : " + LINEJUMP +
                        BIGTAB + "1) Add -s to most nouns." + LINEJUMP +
                        BIGTAB + "2) Add -es to nouns ending is s, x, z, ch, or sh." + LINEJUMP +
                        BIGTAB + "3) For nouns ending in y preceded by a consonant, change y to i and add es." + LINEJUMP +
                        BIGTAB + "4) For nouns ending in y preceded by a vowel, add s. " + LINEJUMP +
                        BIGTAB + "5) For nouns ending in f or fe, usually change the f or fe to ves" + LINEJUMP +
                        BIGTAB + "6) Add s to the end of singular nouns ending in ful" + LINEJUMP +
                        BIGTAB + "7) Add s to the most important noun in a hyphenated word.",
                "With these rules : Boy, boys - Brush, brushes - Hero, heroes - Piano, pianos - Lady, ladies - Shelf, shelves",
                "Some exceptions : " + LINEJUMP + BIGTAB +
                        "Foot (singular), feet (plural)" + LINEJUMP + BIGTAB +
                        "Man, men" + LINEJUMP + BIGTAB +
                        "Woman, women" + LINEJUMP + BIGTAB +
                        "Tooth, teeth" + LINEJUMP + BIGTAB +
                        "Mouse, mice" + LINEJUMP + BIGTAB +
                        "Goose, geese")
        );
        // THEIR_THERE_THEYRE
        addCourse(new CourseContents(
                THEIR_THERE_THEYRE,
                "Homophone : There/Their/They're",
                TAB + "THERE : There is the opposite of Here. It means 'in that place' not here. " +
                        "There is/There are = to show that something exists." + LINEJUMP + LINEJUMP +
                        TAB + "THEIR : Their is a possessive adjective which is used before a noun. " +
                        "It shows possession, that something belongs to them." + LINEJUMP + LINEJUMP +
                        TAB + "THEY'RE : They're is a simple contraction of they are.",
                "They're playing their video games over there.",
                "All of their friends were crazy.")
        );// BIGHT_BITE_BYTE
        addCourse(new CourseContents(
                BIGHT_BITE_BYTE,
                "Homophone : Bight/Bite/Byte",
                TAB + "BIGHT : refers to the middle part of a rope."  + LINEJUMP + LINEJUMP +
                        TAB + "BITE : Bite is something you do with your teeth. " + LINEJUMP + LINEJUMP +
                        TAB + "BYTE : (made up of bits) is a unit of information processed by a computer.",
                "But the pizza compels your attention to the last bite.",
                "Point Old stood at an angle to the smashing seas, making a sheltered bight behind it, " +
                        "and into this bight the flooding tide set in a slow eddy.")
        );// CENSER_CENSOR_SENSOR
        addCourse(new CourseContents(
                CENSER_CENSOR_SENSOR,
                "Homophone : " + CENSER_CENSOR_SENSOR,
                TAB + "CENSER : A censer is an object used to hold incense, usually with holes so the smoke " +
                        "may escape and sometimes on a chain to be swung during religious ceremonies." + LINEJUMP + LINEJUMP +
                        TAB + "CENSOR : To censor something is to remove content from media which is deemed to be " +
                        "hurtful or offensive. This is usually governed by a government or " +
                        "ruling body. A censor is someone who censors." + LINEJUMP + LINEJUMP +
                        TAB + "SENSOR : The noun sensor denotes a detector of a stimulus " +
                        "(such as heat, light, motion, pressure). ",

                "How did that statement end up on the streets? I censored the article myself.",
                "An infrared sensor designed to detect movement triggered the roadside bomb.")
        );// CITE_SIGHT_SITE
        addCourse(new CourseContents(
                CITE_SIGHT_SITE,
                "Homophone : " + CITE_SIGHT_SITE,
                TAB + "SIGHT : Sight relates to vision. It is the power of seeing (i.e., perception by the eyes). " +
                        "It can also be something that is seen (e.g., What a beautiful sight.) "+ LINEJUMP + LINEJUMP +
                        TAB + "SITE : The noun site refers to a piece of land (e.g., building site). " +
                        "As a verb, to site means to position in a place (e.g., I will site the slide " +
                        "near the swings.) " + LINEJUMP + LINEJUMP +
                        TAB + "CITE : The verb to cite means to quote, to refer to, to summon to appear " +
                        "before a court of law or simply to mention.",
                "The newborn foal was an emotional sight for all of us.",
                "Mr Dodds claimed his tools had been stolen from the archaeological site." + LINEJUMP +
                        "The lecturer cited several instances of illegal behaviour.")
        );// FOR_FORE_FOUR
        addCourse(new CourseContents(
                FOR_FORE_FOUR,
                "Homophone : " + FOR_FORE_FOUR,
                TAB + "FOR : is a preposition meaning \"because of,\" \"directed to,\" or \"in favor of.\"  "+ LINEJUMP + LINEJUMP +
                        TAB + "FORE : As an adjective, fore means \"earlier\" or \"forward\". As a noun, it means \"the front.\"" + LINEJUMP + LINEJUMP +
                        TAB + "FOUR : Four is the number 4",
                "For pity's sake, move to the fore of the boat before this thing capsizes and the four of us take a cold dip!",
                "")
        );// HEAL_HEEL_HE_LL
        addCourse(new CourseContents(
                HEAL_HEEL_HE_LL,
                "Homophone : " + HEAL_HEEL_HE_LL,
                TAB + "HEAL : To become whole and sound; return to health. "+ LINEJUMP + LINEJUMP +
                        TAB + "HEEL : the lower rear part of the foot, plus many other definitions " +
                        "relating to the bottom and rear portions of things. " + LINEJUMP + LINEJUMP +
                        TAB + "HE'LL : Contraction of he will.",
                "The man smashed his heel onto her already wounded arm.",
                "He'll heal you.")
        );// PALATE_PALETTE_PALLET
        addCourse(new CourseContents(
                PALATE_PALETTE_PALLET,
                "Homophone : " + PALATE_PALETTE_PALLET,
                TAB + "PALATE : The palate is (1) the roof of the mouth, and (2) the sense " +
                        "of taste, and it’s also a fancy word for flavor, especially in writing " +
                        "on food wine. "+ LINEJUMP + LINEJUMP +
                        TAB + "PALETTE : A palette is the board painters use to hold and mix their" +
                        " colors. By extension, it sometimes denotes the range of colors used in" +
                        " a design or work of art. " + LINEJUMP + LINEJUMP +
                        TAB + "PALLET : Pallet usually refers to a platform used for moving " +
                        "cargo or freight, but the word has several other rare definitions in industry and shipping.",
                "Rosy-toned table linens, napkin rings and utensils sweeten up a palette heavy on black and gold.",
                "Then it is dried, wrapped in plastic, placed atop a pallet, and driven northeast on Interstate 59.")
        );// PEAK_PEEK_PEKE_PIQUE
        addCourse(new CourseContents(
                PEAK_PEEK_PEKE_PIQUE,
                "Homophone : " + PEAK_PEEK_PEKE_PIQUE,
                TAB + "PEAK : A peak is (1) a maximum, (2) to achieve a maximum, and (3) to bring " +
                        "to a maximum. "+ LINEJUMP + LINEJUMP +
                        TAB + "PEEK : peek, means (1) to glance quickly, (2) to look furtively, " +
                        "or (3) a quick or furtive look. " + LINEJUMP + LINEJUMP +
                        TAB + "PIQUE : Its homophone pique, which appears mostly in the phrase pique " +
                        "[one’s] interest, means (1) to provoke or arouse, or (2) to provoke resentment" +
                        " or indignation. It also works as a noun referring to a feeling of resentment or " +
                        "indignation resulting from wounded pride."+ LINEJUMP + LINEJUMP +
                        TAB + "PEKE : A Pekinese dog. " ,
                "It peaked with Della famously being photographed dancing to I Will Survive in a skin-tight red dress.",
                "Like a sneak peek into old age, I grunt when I bend and climb stairs in slow motion.")
        );// RAIN_REIGN_REIN
        addCourse(new CourseContents(
                RAIN_REIGN_REIN,
                "Homophone : " + RAIN_REIGN_REIN,
                TAB + "RAIN : Water falling in drops condensed from vapor in the atmosphere "+ LINEJUMP + LINEJUMP +
                        TAB + "REIGN :  royal authority, the power or rule of a monarch; the " +
                        "dominion, sway, or influence of one resembling or held to resemble a monarch " + LINEJUMP + LINEJUMP +
                        TAB + "REIN : a line (as a leather strap) which is fastened to a bit on each side and through" +
                        " which a rider or driver exerts pressure on the bit for governing or guiding an animal (as a horse)",
                "The jockey pulled on the horse’s reins to make it go faster.",
                "The queen’s reign lasted forty years.")
        );// TE_TEA_TEE
        addCourse(new CourseContents(
                TE_TEA_TEE,
                "Homophone : " + TE_TEA_TEE,
                TAB + "TEA : an aromatic beverage prepared from tea leaves by soaking them in boiling water "+ LINEJUMP + LINEJUMP +

                        TAB + "TEE : A mark aimed at in bowls, quoits, curling, and other similar games.",
                "I drink some tea",
                "I carry three tees in my pocket")
        );// TO_TOO_TWO
        addCourse(new CourseContents(
                TO_TOO_TWO,
                "Homophone : " + TO_TOO_TWO,
                TAB + "TWO : Two is the number 2. "+ LINEJUMP + LINEJUMP +
                        TAB + "TOO : Too' is used as a synonym for 'also.' It can also mean a degree of excess. " + LINEJUMP + LINEJUMP +
                        TAB + "TO : used to indicate the place, person, or thing that someone or something moves toward" + LINEJUMP +
                        BIGTAB + "used to indicate the place where someone participates in a particular activity" + LINEJUMP +
                        BIGTAB + "used to indicate the direction of something",
                "Luke wanted to go to the Tachi Station to pick up some power converters. Uncle Owen, knowing this was a" +
                        " cheap teen code word for 'heroin,' kept his smack-addicted ass on the moisture farm. Aunt Beru smiled " +
                        "wistfully in the kitchen. \"I want to get some 'power converters,' too,\" she thought. \"Mama needs her" +
                        " fix!\"",
                "")
        );



    }

    public CourseContents getCourseContents(String rule) {
        String selectQuery = SELECT_FROM + DATABASE_NAME + WHERE + KEY_RULE +" = '" + rule + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        CourseContents course = new CourseContents();
        course.setRULE(cursor.getString(1));
        course.setTitle(cursor.getString(2));
        course.setDesc(cursor.getString(3));
        course.setExemple1(cursor.getString(4));
        course.setExemple2(cursor.getString(5));
        cursor.close();
        return course;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        // Create tables again
        onCreate(db);
    }
    // Adding new sentence
    private void addCourse(CourseContents sent) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RULE, sent.getRULE());
        values.put(KEY_TITLE, sent.getTitle());
        values.put(KEY_DESCR, sent.getDesc());
        values.put(KEY_EX1, sent.getExemple1());
        values.put(KEY_EX2, sent.getExemple2());
        // Inserting Row
        dbase.insert(DATABASE_NAME, null, values);
    }
    public ArrayList<CourseContents> getAllCourses() {
        ArrayList<CourseContents> sentList = new ArrayList<>();
        // Select All Query
        String selectQuery = SELECT_FROM + DATABASE_NAME;
        dbase=this.getReadableDatabase();
        this.rowcount();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
                // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                CourseContents course = new CourseContents();
                course.setRULE(cursor.getString(1));
                //System.out.println(cursor.getString(1));
                course.setTitle(cursor.getString(2));
                course.setDesc(cursor.getString(3));
                course.setExemple1(cursor.getString(4));
                course.setExemple2(cursor.getString(5));
                sentList.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return sentList;
    }

    public int rowcount()
    {
        int row;
        String selectQuery = SELECT_FROM + DATABASE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        cursor.close();
        return row;
    }
}
