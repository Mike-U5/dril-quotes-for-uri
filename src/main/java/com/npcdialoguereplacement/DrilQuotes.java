package com.npcdialoguereplacement;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrilQuotes {
	private static final List<String> drilQuotes = Arrays.asList(
		"no",
		"its fucked up how there are like 1000 christmas songs<br>but only 1 song aboutr the boys being back in town",
		"Food $200 Data $150 Rent $800<br>Candles $3,600 Utility $150<br>someone who is good at the economy please<br>help me budget this. my family is dying",
		"so long suckers! i rev up my motorcylce and create a<br>huge cloud of smoke. when the cloud dissipates im lying<br>completely dead on the pavement",
		"if your grave doesnt say \"rest in peace\" on it you are<br>automatically drafted into the skeleton war",
		"IF THE ZOO BANS ME FOR HOLLERING AT<br>THE ANIMALS I WILL FACE GOD AND<br>WALK BACKWARDS INTO HELL",
		"did they find any water on mars yet. what about<br>catboys",
		"blocked. blocked. blocked. youre all blocked. none of you<br> are free of sin",
		"my friend the only crypto currency you wanna get<br>your hands on is this: bird seed. There is a lot of birds<br>and they all gotta eat",
		"go ahead. keep screaming \"Shut The Fuck Up \" at me.<br>it only makes my opinions Worse",
		"drunk driving may kill a lot of people, but it also helps a<br>lot of people get to work on time, so, it;s impossible to<br>say if its bad or not,",
		"mean while, while you were \"Gaming \",<br>i tasted 100 different wines in a cave behind a waterfall<br>and cried into a shaman's arms",
		"the wise man bowed his head solemnly and spoke:<br>\"theres actually zero difference between good & bad<br>things. you imbecile. you fucking moron\"",
		"the doctor reveals my blood pressure is 420 over 69. i<br>oot & holler outta the building while a bunch of losers<br>try to tell me that im dying",
		"im afraid i must say that i do not find the mysteries<br>featured on \"scooby-doo\" challenging enough .",
		"\"im not owned! im not owned!!\", i continue to insist as i<br>slowly shrink and transform into a corn cob",
		"THERAPIST: your problem is, that youre perfect, and<br>everyone is jealous of your good posts, and that makes<br>you rightfully upset.<br>ME: I agree",
		"it is with a heavy heart that i must announce that the<br>celebs are at it again",
		"Politic's is back baby. It's good again.<br>Awoouu (wolf Howl)",
		"i regret to inform you, that by resorting to<br>Swear language, you have forfeit this debate.<br>Farewell my bitch",
		"peoplr would rather see macDonald's, than macbeth. and<br>that's why all of this is going on",
		"THE COP GROWLS \"TAKE OFF TH OSE<br>JEANS, CITIZEN.\" I COMPLY, REVEALING<br>THE FULL LENGTH DENIM TATTOOS ON<br>BOTH LEGS. THE COP SCREAMS; DEFEATED",
		"turning a big dial taht says \"Racism\" on it and<br>constantly looking back at the audience for approval<br>like a contestant on the price is right",
		"\"if theres a spicy brown mustard, why not a spicy<br>brown ketchup?\" The wise man smiled. \"my friend, the<br>condiment you seek is Barbecue Sauce\"",
		"it is really quite astonishing that I have yet to win<br>The Lottery, given how good I am at selecting<br>six numbers and saying them out loud",
		"neo pets cinematic universe",
		"i just need to say, to anyone reading this.. You are<br>Important, You are loved, and You belong in this world,<br>if you have over 5000 followers",
		"Thinking about getting very pissed off on the computer<br>today",
		"\"jail isnt real,\" i assure myself as i close my eyes and<br>ram the hallmark gift shop with my shitty bronco",
		"Welcome to the citadel of eternal wisdom.<br>Behold, this crystal contains the sum of all human<br>knowledge -- Except Rap And Country",
		"oh nothin, i was just buying some ear medication for<br>my sick uncle... *LOWERS SHADES TO LOOK<br>YOU DEAD IN THE EYE*<br>who's a Model by the way,",
		"awfully bold of you to fly the Good Year blimp<br>on a year that has been extremely bad thus far",
		"joke's on you; i actually love being body slammed by<br>one dozen perfect wrestlers.<br>and my mouth isn't filled with bloodm, it's victory wine",
		"koko the talking ape.. has been living high on the hog,<br>wasting our tax dollars on high capacity diapers.<br>No more. i will suplex that beast,",
		"DOCTOR: you cant keep doing this to yourself. being<br>The Last True Good Boy online will destroy you. you<br>must stop posting with honor<br>ME: No,",
		"the human mind... perhaps the most powerful weapon.<br>second only to the \"GUN\"",
		"user named \" beavis_sinatra \" has been terrorizing me<br>since 2004, by sending me pictures of cups that are<br>too close to the edge of the table",
		"im afraid you do not grasp the enormity of who it is<br>you are dealing with. (removes diaper,. revealing two<br>sub-diapers )<br>Shall we continue..",
		"1st grade: Mastered<br>2nd Grade: MAstered.<br>3rd Grade: Mastered.<br>4th Grade: Heres when they start trying to trick you<br>5th Grade:This ones hard",
		"i refuse to consume any product that has been created<br>by, or is claimed to have been created by, the<br>(((Keebler Elves)))",
		"if you \"clap back\" someone with a PhD on here, you<br>should be allowed to have their PhD. Its just common<br>sense people. Oh that's tea"
	);

	public static String getRandomQuote()
	{
		return DrilQuotes.drilQuotes.get(new Random().nextInt(DrilQuotes.drilQuotes.size()));
	}
}
