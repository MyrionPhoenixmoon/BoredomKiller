-- BoredomKiller Database Testdata

-- Use database
use boredomkiller;

-- Add some platforms
INSERT INTO tbl_platforms SET name="PC";
INSERT INTO tbl_platforms SET name="NES";
INSERT INTO tbl_platforms SET name="SNES";
INSERT INTO tbl_platforms SET name="N64";
INSERT INTO tbl_platforms SET name="NGC";
INSERT INTO tbl_platforms SET name="Wii";
INSERT INTO tbl_platforms SET name="PSX";
INSERT INTO tbl_platforms SET name="PS2";
INSERT INTO tbl_platforms SET name="PS3";
INSERT INTO tbl_platforms SET name="XBox";
INSERT INTO tbl_platforms SET name="XBox 360";

-- Add some playstyles
INSERT INTO tbl_playstyles SET name="Singleplayer";
INSERT INTO tbl_playstyles SET name="Co-op";
INSERT INTO tbl_playstyles SET name="Versus";

-- Add some game types
INSERT INTO tbl_game_types SET name="Shooter";
INSERT INTO tbl_game_types SET name="Platformer";
INSERT INTO tbl_game_types SET name="Fighting";
INSERT INTO tbl_game_types SET name="RPG";
INSERT INTO tbl_game_types SET name="Racing";
INSERT INTO tbl_game_types SET name="Party";
INSERT INTO tbl_game_types SET name="Rhythm";
INSERT INTO tbl_game_types SET name="Horror";

-- Add some maluses
INSERT INTO tbl_maluses SET name="Would you kindly...", description="Refresh everyone's drinks.", rating="Easy";
INSERT INTO tbl_maluses SET name="The cake is a lie", description="Refill the snacks. If they're empty, bring new ones.", rating="Easy";
INSERT INTO tbl_maluses SET name="CHUG! CHUG! CHUG!", description="Drink a bottle of beer/cider in one go.(May also be a non-alcoholic, carbonated drink.)", rating="Medium";
INSERT INTO tbl_maluses SET name="Spin It Right 'Round", description="Play the next game you play, with the controlling peripheral upside down.", rating="Medium";
INSERT INTO tbl_maluses SET name="Oh Edward... <3", description="Read a chapter of twilight. You may not play another game, until you're finished.", rating="Hard";
INSERT INTO tbl_maluses SET name="Hold it", description="You may not go to the bathroom for the next two hours.", rating="Hard";

-- Add some Players
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_players SET id_statistic="1", name="Pincer";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_players SET id_statistic="2", name="Kero";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_players SET id_statistic="3", name="Myrion";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_players SET id_statistic="4", name="Tschoppi";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_players SET id_statistic="5", name="Amorpheus";

-- Add some Games
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="1", id_statistic="6", name="Team Fortress 2";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="2", id_statistic="7", name="The Legend of Zelda";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="3", id_statistic="8", name="Goof Troop";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="4", id_statistic="9", name="Mario Party";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="5", id_statistic="10", name="Super Smash Bros. Melee";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="6", id_statistic="11", name="Mario Kart Wii";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="7", id_statistic="12", name="Final Fantasy IX";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="8", id_statistic="13", name="Champions: Return to Arms";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="9", id_statistic="14", name="Soul Calibur IV";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="10", id_statistic="15", name="Halo";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="11", id_statistic="16", name="Guitar Hero III";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="1", id_statistic="17", name="Call of Duty: World at War";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="2", id_statistic="18", name="Megaman 2";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="3", id_statistic="19", name="Kirby Super Star";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="4", id_statistic="20", name="Lylat Wars";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="5", id_statistic="21", name="Final Fantasy: Crystal Chronicles";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="6", id_statistic="22", name="Wii Sports";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="7", id_statistic="23", name="Crash Bandicoot";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="8", id_statistic="24", name="Ratchet: Gladiator";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="9", id_statistic="25", name="God of War III";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="10", id_statistic="26", name="Fable";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_games SET id_platform="11", id_statistic="27", name="Left 4 Dead 2";

-- Add some difficulties
INSERT INTO tbl_difficulties SET difficulty="Easy";
INSERT INTO tbl_difficulties SET difficulty="Medium";
INSERT INTO tbl_difficulties SET difficulty="Hard";

-- Add some challenges
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Cheap Gear", description="Play with the worst controlling peripheral you can find, that works with the platform.", id_difficulty="1", id_statistic="28";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Take a seat... NOT", description="Play while standing.", id_difficulty="2", id_statistic="29";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Cpt. Hook", description="Play using only one hand.", id_difficulty="3", id_statistic="30";
-- game type related challenges
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Good enough...", description="Only use pistols.", id_difficulty="2", id_statistic="31", id_game_type="1";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="JUMPNSITMAN", description="Everytime the character jumps, you have to jump up in your seat too.", id_difficulty="3", id_statistic="32", id_game_type="2";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="THAT guy...", description="Play as the character you dislike most.", id_difficulty="1", id_statistic="33", id_game_type="3";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Talentless Priest", description="Don't use healing abilities.(Healing Items are permitted though.)", id_difficulty="2", id_statistic="34", id_game_type="4";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Full Throttle", description="During the race, you may not let go of the gas button.", id_difficulty="1", id_statistic="35", id_game_type="5";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Ahm de Besht!!", description="When you gain points, you have to drink.", id_difficulty="1", id_statistic="36", id_game_type="6";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Flawless Victory", description="Complete a song without missing a note.", id_difficulty="2", id_statistic="37", id_game_type="7";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Set the mood...", description="Play in the dark, crank up the volume.(Nonparticipating people are to be silent/silenced)", id_difficulty="1", id_statistic="38", id_game_type="8";
-- game related challenges
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Equality", description="Play as the class you've played least so far.", id_difficulty="1", id_statistic="39", id_game="1";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game within 2 days.", id_difficulty="2", id_statistic="40", id_game="2";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="No Items", description="Only pick up items you need to progress.", id_difficulty="2", id_statistic="41", id_game="3";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="The One and Only", description="Only the first star may be bought. Afterwards a star can only be obtained by stealing it.", id_difficulty="3", id_statistic="42", id_game="4";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Final Destination", description="Items off. Three stocks. Fox only. Final Destination.", id_difficulty="1", id_statistic="43", id_game="5";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Which one's the gas?", description="Drive one track backwards.", id_difficulty="3", id_statistic="44", id_game="6";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game in a week.", id_difficulty="2", id_statistic="45", id_game="7";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="MEDIC!", description="Don't use health potions.", id_difficulty="3", id_statistic="46", id_game="8";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Why do you do this to me?", description="Your opponent chooses your character.(If you play Singleplayer, choose Random)", id_difficulty="1", id_statistic="47", id_game="9";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game within 3 days.", id_difficulty="2", id_statistic="48", id_game="10";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="POWAHSLIIIIDE!!!", description="Do a powerslide during the song.", id_difficulty="2", id_statistic="49", id_game="11";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Never bring a gun to a gunfight.", description="Only use the knife.", id_difficulty="3", id_statistic="50", id_game="12";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game within 2 days.", id_difficulty="2", id_statistic="51", id_game="13";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Spitting, not swallowing", description="Finish the game, without using powers.", id_difficulty="3", id_statistic="52", id_game="14";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Why do it the easy way, when...", description="Finish the hard route.", id_difficulty="2", id_statistic="53", id_game="15";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game within a week.", id_difficulty="2", id_statistic="54", id_game="16";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Herp Derp Durr", description="Use your 'Bad Hand'.", id_difficulty="1", id_statistic="55", id_game="17";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Untouchable", description="Complete the first world, without dying.", id_difficulty="1", id_statistic="56", id_game="18";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godpeed", description="Finish the game within 2 hours.", id_difficulty="2", id_statistic="57", id_game="19";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game within a week.", id_difficulty="2", id_statistic="58", id_game="20";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Godspeed", description="Finish the game within 5 hours.", id_difficulty="2", id_statistic="59", id_game="21";
INSERT INTO tbl_statistics SET times_played="0";
INSERT INTO tbl_challenges SET name="Ouchie :(", description="Don't use pills or bandages.", id_difficulty="1", id_statistic="60", id_game="22";

-- Add some modes
INSERT INTO tbl_modes SET name="25 turns", id_game="4";
INSERT INTO tbl_modes SET name="40 turns", id_game="4";
INSERT INTO tbl_modes SET name="55 turns", id_game="4";
INSERT INTO tbl_modes SET name="Arena", id_game="1";
INSERT INTO tbl_modes SET name="Domination", id_game="1";
INSERT INTO tbl_modes SET name="Mann vs. Machine", id_game="1";
INSERT INTO tbl_modes SET name="1 Stock", id_game="5";
INSERT INTO tbl_modes SET name="3 Stock", id_game="5";
INSERT INTO tbl_modes SET name="6 Stock", id_game="5";
INSERT INTO tbl_modes SET name="12 Stock", id_game="5";
INSERT INTO tbl_modes SET name="1 Minute", id_game="5";
INSERT INTO tbl_modes SET name="3 Minutes", id_game="5";
INSERT INTO tbl_modes SET name="6 Minutes", id_game="5";
INSERT INTO tbl_modes SET name="12 Minutes", id_game="5";

-- Add some maps
INSERT INTO tbl_maps SET name="Final Destination", id_game="5";
INSERT INTO tbl_maps SET name="Mushroom Kingdom", id_game="5";
INSERT INTO tbl_maps SET name="Hyrule Field", id_game="5";

-- Relation Map - Playstyle
INSERT INTO tbl_map_has_playstyle SET id_map="1", id_playstyle="3";
INSERT INTO tbl_map_has_playstyle SET id_map="2", id_playstyle="3";
INSERT INTO tbl_map_has_playstyle SET id_map="3", id_playstyle="3";

-- Relation Mode - Playstyle
INSERT INTO tbl_mode_has_playstyle SET id_mode="1", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="2", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="3", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="4", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="5", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="6", id_playstyle="2";
INSERT INTO tbl_mode_has_playstyle SET id_mode="7", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="8", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="9", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="10", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="11", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="12", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="13", id_playstyle="3";
INSERT INTO tbl_mode_has_playstyle SET id_mode="14", id_playstyle="3";

-- Relation Game - Playstyle
INSERT INTO tbl_game_has_playstyle SET id_game="1", id_playstyle="2", min_players="1", max_players="6";
INSERT INTO tbl_game_has_playstyle SET id_game="1", id_playstyle="3", min_players="1", max_players="8";
INSERT INTO tbl_game_has_playstyle SET id_game="2", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="3", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="3", id_playstyle="2", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="4", id_playstyle="3", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="5", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="5", id_playstyle="3", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="6", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="6", id_playstyle="3", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="7", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="8", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="8", id_playstyle="2", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="9", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="9", id_playstyle="3", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="10", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="10", id_playstyle="3", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="11", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="11", id_playstyle="2", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="11", id_playstyle="3", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="12", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="12", id_playstyle="2", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="12", id_playstyle="3", min_players="1", max_players="16";
INSERT INTO tbl_game_has_playstyle SET id_game="13", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="14", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="14", id_playstyle="2", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="14", id_playstyle="3", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="15", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="15", id_playstyle="3", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="16", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="16", id_playstyle="2", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="17", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="17", id_playstyle="2", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="17", id_playstyle="3", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="18", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="19", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="19", id_playstyle="2", min_players="1", max_players="2";
INSERT INTO tbl_game_has_playstyle SET id_game="20", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="21", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="22", id_playstyle="1", min_players="1", max_players="1";
INSERT INTO tbl_game_has_playstyle SET id_game="22", id_playstyle="2", min_players="1", max_players="4";
INSERT INTO tbl_game_has_playstyle SET id_game="22", id_playstyle="3", min_players="1", max_players="8";

-- Relation Game - Gametype
INSERT INTO tbl_game_has_game_type SET id_game="1", id_game_type="1";
INSERT INTO tbl_game_has_game_type SET id_game="2", id_game_type="4";
INSERT INTO tbl_game_has_game_type SET id_game="3", id_game_type="4";
INSERT INTO tbl_game_has_game_type SET id_game="4", id_game_type="6";
INSERT INTO tbl_game_has_game_type SET id_game="5", id_game_type="2";
INSERT INTO tbl_game_has_game_type SET id_game="5", id_game_type="3";
INSERT INTO tbl_game_has_game_type SET id_game="6", id_game_type="5";
INSERT INTO tbl_game_has_game_type SET id_game="7", id_game_type="4";
INSERT INTO tbl_game_has_game_type SET id_game="8", id_game_type="4";
INSERT INTO tbl_game_has_game_type SET id_game="9", id_game_type="3";
INSERT INTO tbl_game_has_game_type SET id_game="10", id_game_type="1";
INSERT INTO tbl_game_has_game_type SET id_game="11", id_game_type="7";
INSERT INTO tbl_game_has_game_type SET id_game="12", id_game_type="1";
INSERT INTO tbl_game_has_game_type SET id_game="13", id_game_type="2";
INSERT INTO tbl_game_has_game_type SET id_game="14", id_game_type="2";
INSERT INTO tbl_game_has_game_type SET id_game="16", id_game_type="4";
INSERT INTO tbl_game_has_game_type SET id_game="17", id_game_type="6";
INSERT INTO tbl_game_has_game_type SET id_game="18", id_game_type="2";
INSERT INTO tbl_game_has_game_type SET id_game="19", id_game_type="1";
INSERT INTO tbl_game_has_game_type SET id_game="19", id_game_type="2";
INSERT INTO tbl_game_has_game_type SET id_game="21", id_game_type="4";
INSERT INTO tbl_game_has_game_type SET id_game="22", id_game_type="1";

-- Relation Challenge - Playstyle
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="1", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="1", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="1", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="2", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="2", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="2", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="3", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="3", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="3", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="4", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="4", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="4", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="5", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="5", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="5", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="6", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="6", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="6", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="7", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="7", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="7", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="8", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="8", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="8", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="9", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="9", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="9", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="10", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="10", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="10", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="11", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="11", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="11", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="12", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="12", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="13", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="14", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="14", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="15", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="16", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="16", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="17", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="17", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="18", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="19", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="19", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="20", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="20", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="21", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="22", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="22", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="22", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="23", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="23", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="23", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="24", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="25", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="25", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="26", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="27", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="27", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="28", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="28", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="28", id_playstyle="3";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="29", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="30", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="30", id_playstyle="2";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="31", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="32", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="33", id_playstyle="1";
INSERT INTO tbl_challenge_has_playstyle SET id_challenge="33", id_playstyle="2";